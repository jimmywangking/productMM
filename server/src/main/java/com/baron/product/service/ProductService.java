package com.baron.product.service;

import com.baron.common.dataobject.DescreaseStockInput;
import com.baron.common.dataobject.ProductInfoOutput;
import com.baron.product.dataobject.ProductInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 @package com.baron.product
 @author Baron
 @create 2020-08-11-8:21 PM
 */
@Service
public interface ProductService {

    List<ProductInfo> findUpAll();

    List<ProductInfoOutput> findList(List<String> productIdList);

    void descreaseStock(List<DescreaseStockInput> descreaseStockInputList);
}
