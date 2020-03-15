package com.yuhaowin.springmvc;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.yuhaowin.enums.Type;
import lombok.Data;

@Data
public class Teacher {
    String name;
    //@JsonDeserialize(using = JsonEnumDeserializer.class)
    Type type;
}
