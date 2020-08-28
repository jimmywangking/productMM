package com.baron.common.dataobject;

import lombok.Data;
import java.math.BigDecimal;

/***
 @package PACKAGE_NAME
 @author Baron
 @create 2020-08-13-8:13 PM
 */
@Data
public class ProductInfoOutput {
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productStock;
    private String productDescription;
    private String productIcon;
    private Integer productStatus;
    private Integer categoryType;
}
