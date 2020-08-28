package com.baron.product.client;

import com.baron.common.dataobject.DescreaseStockInput;
import com.baron.common.dataobject.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/***
 @package com.baron.product.client
 @author Baron
 @create 2020-08-14-12:33 AM
 */
//@FeignClient(name = "product", fallback = ProductClient.ProductClientFallback.class)
@FeignClient(name = "product")
public interface ProductClient {
    @PostMapping("/product/listForOrder")
    List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/product/descreaseStock")
    void descreaseStock(@RequestBody List<DescreaseStockInput> descreaseStockInputList);

//    @Component
//    static class ProductClientFallback implements ProductClient{
//
//        @Override
//        public List<ProductInfoOutput> listForOrder(List<String> productIdList) {
//            return null;
//        }
//
//        @Override
//        public void descreaseStock(List<DescreaseStockInput> descreaseStockInputList) {
//
//        }
//    }
}
