package com.baron.common.dataobject;

import lombok.Data;

/***
 @package com.baron.common.dataobject
 @author Baron
 @create 2020-08-13-10:58 PM
 */
@Data
public class DescreaseStockInput {
    private String productId;

    private Integer productQuantity;

    public DescreaseStockInput(){};

    public DescreaseStockInput(String productId, Integer productQuantity){
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

}
