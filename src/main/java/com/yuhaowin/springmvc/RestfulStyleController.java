package com.yuhaowin.springmvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestfulStyleController {

    @RequestMapping("/test")
    @ResponseBody
    public String testDELETE(String name) {
        System.out.println(name);
        return "ok test";
    }

    @RequestMapping(value = "/restful", method = RequestMethod.PUT)
    @ResponseBody
    public Object edit(User user) {
        System.out.println(user.toString());
        return "ok";
    }

    /**
     * produces 和 ajax的dateType 的作用是一样的  指定返回内容的类型 如:json
     * <p>
     * consumes 和 ajax的contenType 的作用是一样的  指定提交内容的类型 如:json
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/restful1", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Object edit1(String name, Integer age, String _method) {
        // System.out.println(user.toString());
        return "{\"name\":\"yuhao\",\"age\":18,\"birthday\":\"2000-11-11\"}";
        //return user;
    }

    @RequestMapping(value = "/restful2", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Object edit2(@RequestBody User user) {
        System.out.println(user.toString());
        return "{\"name\":\"yuhao\",\"age\":18,\"birthday\":\"2000-11-11\"}";
        //return user;
    }
}
