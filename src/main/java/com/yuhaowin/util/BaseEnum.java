package com.yuhaowin.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

//@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public interface BaseEnum {


    Integer getCode();

    String getMessage();
}

