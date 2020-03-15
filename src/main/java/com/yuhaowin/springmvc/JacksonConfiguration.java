package com.yuhaowin.springmvc;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.yuhaowin.enums.EnumBase;
import com.yuhaowin.enums.Type;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Jackson配置
 */
@Configuration
public class JacksonConfiguration {
    /**
     * Jackson配置
     */
    @Bean
    public HttpMessageConverters customConverters() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder()
                //缩进输出
                .indentOutput(true)
                //输入、输出日期时间格式化
                //.dateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))
                //配置时区
                //.timeZone("GMT+8")
                //long转String
                .serializerByType(Long.TYPE, new ToStringSerializer())
                //Long转String
                .serializerByType(Long.class, new ToStringSerializer())
                //枚举类型显示 message 到前端
                .serializerByType(EnumBase.class, new EnumSerializer(EnumBase.class))
                .deserializerByType(EnumBase.class, new JsonEnumDeserializer())
                ;
        ObjectMapper objectMapper = builder.build();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        // 配置 null 值不进行序列化
       // objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return new HttpMessageConverters(new MappingJackson2HttpMessageConverter(objectMapper));
    }
}

/**
 * 自定义枚举序列化器
 */
class EnumSerializer extends StdSerializer<EnumBase> {

    public EnumSerializer(Class<EnumBase> clazz) {
        super(clazz);
    }

    @Override
    public void serialize(EnumBase value, JsonGenerator generator,
                          SerializerProvider provider) throws IOException {
        generator.writeString(value.getMessage());
    }
}


class JsonEnumDeserializer extends JsonDeserializer<EnumBase> {

    @Override
    public EnumBase deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        try {
            //前端输入的值
            String inputParameter = p.getText();
//            if (StringUtils.isBlank(inputParameter)) {
//                return null;
//            }
            JsonStreamContext parsingContext = p.getParsingContext();
            //字段名
            String currentName = parsingContext.getCurrentName();
            //前端注入的对象(ResDTO)
            Object currentValue = parsingContext.getCurrentValue();
            // 通过对象和属性名获取属性的类型
            Field field = getField(currentValue.getClass(), currentName);
            Class enumClass = field.getType();

            return getEnum(inputParameter, enumClass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Field getField(Class<?> clazz, String name) throws NoSuchFieldException {
        try {
            Field f = clazz.getDeclaredField(name);
            f.setAccessible(true);
            return f;
        } catch (NoSuchFieldException e) {
            if (clazz == Object.class){
                throw e;
            }
            return getField(clazz.getSuperclass(), name);
        }
    }

    public static EnumBase getEnum(String inputParameter, Class enumClass) {
        try {
            Method valuesMethod = enumClass.getDeclaredMethod("values");

            EnumBase[] values = (EnumBase[]) valuesMethod.invoke(null);
            EnumBase baseEnum = null;

            for (EnumBase value : values) {
                //因为inputParameter都是string类型的,code + "" 转成字符串才能比较
                if (inputParameter.equals(value.getCode() + "")) {
                    baseEnum = value;
                    break;
                } else {
                    continue;
                }
            }
            //如果都拿不到,那就直接抛出异常了
            if (baseEnum == null) {
                throw new RuntimeException("输入参数不符合预期");
            }
            return baseEnum;
        } catch (Exception e) {
            // logger.error("getEnum error: " + Throwables.getStackTraceAsString(e));
            throw new RuntimeException(e);
        }
    }
}