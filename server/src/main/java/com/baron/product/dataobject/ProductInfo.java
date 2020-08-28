package com.baron.product.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/***
 @package com.baron.product
 @author Baron
 @create 2020-08-11-7:13 PM
 */
@Data
@Entity
public class ProductInfo {
//    product_id
//            product_name
//    product_price
//            product_stock
//    product_description
//            product_icon
//    product_status
//            category_type
//    create_time
//            update_time
    @Id
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productStock;
    private String productDescription;
    private String productIcon;
    private Integer productStatus;
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;
}
