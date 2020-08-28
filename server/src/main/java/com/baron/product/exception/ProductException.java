package com.baron.product.exception;

import com.baron.product.enums.ResultEnum;

/***
 @package com.baron.product
 @author Baron
 @create 2020-08-13-6:17 PM
 */
public class ProductException extends RuntimeException{

    private Integer code;

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public ProductException(String message, Integer code) {
        super(message);
        this.code = code;
    }
}
