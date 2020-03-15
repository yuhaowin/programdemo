package com.yuhaowin.springmvc;

import com.yuhaowin.enums.EnumBase;
import com.yuhaowin.enums.Type;
import com.yuhaowin.util.Result;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/restful")
public class RestfulStyleController {

    EnumBase enumBase = Type.A;

    @RequestMapping("/test")
    public String testDELETE(String name) {
        System.out.println(name);
        return "ok test";
    }

    @RequestMapping(value = "/restful", method = RequestMethod.PUT)
    public Object edit(User user) {
        System.out.println(user.toString());
        return "ok";
    }

    /**
     * produces 和 ajax的dateType 的作用是一样的  指定返回内容的类型 如:json
     * <p>
     * consumes 和 ajax的contenType 的作用是一样的  指定提交内容的类型 如:json
     *
     * @return
     */
    @RequestMapping(value = "/restful1", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object edit1(String name, Integer age, String _method) {
        // System.out.println(user.toString());
        return "{\"name\":\"yuhao\",\"age\":18,\"birthday\":\"2000-11-11\"}";
        //return user;
    }

    @RequestMapping(value = "/restful2", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object edit2(@RequestBody User user) {
        System.out.println(user.toString());
        return "{\"name\":\"yuhao\",\"age\":18,\"birthday\":\"2000-11-11\"}";
        //return user;
    }

    @RequestMapping("/test1")
    public Map<String, String[]> test(HttpServletRequest request){
        return request.getParameterMap();
    }


    @RequestMapping("/get-enum")
    public Result getEnum(){

        Teacher teacher = new Teacher();
        teacher.setName("余浩");
        teacher.setType(Type.A);

        return Result.successData(teacher);
    }

    @RequestMapping("/set-enum-json")
    public Result setEnum(@RequestBody Teacher t){


        return Result.successData(t);
    }

    public static void main(String[] args) {
    }

}
