package com.baron.product.service;

import com.baron.common.dataobject.DescreaseStockInput;
import com.baron.common.dataobject.ProductInfoOutput;
import com.baron.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/***
 @package com.baron.product.service
 @author Baron
 @create 2020-08-11-10:24 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll(){
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void findList(){
        List<ProductInfoOutput> productServiceList  = productService.findList(Arrays.asList("157875196366160022"));
        Assert.assertTrue(productServiceList.size() > 0);
    }

    @Test
    public void descreaseStock() throws Exception{
        DescreaseStockInput descreaseStockInput = new DescreaseStockInput("157875196366160022",2);
        productService.descreaseStock(Arrays.asList(descreaseStockInput));
    }
}
