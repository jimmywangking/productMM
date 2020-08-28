package com.baron.product.enums;

import lombok.Getter;

/***
 @package com.baron.product.enums
 @author Baron
 @create 2020-08-13-6:18 PM
 */
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(1, "商品不存在"),
    PRODUCT_STOCK_ERROR(2, "库存不足"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
