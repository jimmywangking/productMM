package com.baron.product.VO;

import lombok.Data;

/***
 @package com.baron.product
 @author Baron
 @create 2020-08-11-11:05 PM
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T date;
}
