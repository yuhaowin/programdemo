package com.yuhaowin.util;

/**
 * @author wany
 * @desc 枚举工具类
 * @date 2019/7/2 14:31
 */
public class EnumUtils {
    /**
     * 返回指定编码的'枚举'
     * @param code
     * @return SharedObjTypeEnum
     * @throws
     */
    public static <T extends BaseEnum> T getEnumByValue(Class<T> clazz, int code) {
        for(T _enum : clazz.getEnumConstants()){
            if(code == _enum.getCode()){
                return _enum;
            }
        }
        return null;
    }
}
