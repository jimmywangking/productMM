package com.baron.product.enums;

import lombok.Data;
import lombok.Getter;

/***
 @package com.baron.product
 @author Baron
 @create 2020-08-11-10:13 PM
 */
@Getter
public enum ProductStatusEnum {
    UP(0,"在架"),

    DOWN(1,"下架"),
    ;

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
