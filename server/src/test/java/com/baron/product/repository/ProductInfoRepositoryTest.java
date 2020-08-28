package com.baron.product.repository;

import com.baron.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rx.internal.util.LinkedArrayList;

import java.util.Arrays;
import java.util.List;


/***
 @package com.baron.product.repository
 @author Baron
 @create 2020-08-11-7:31 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductStatus() throws Exception{
        List<ProductInfo> list = productInfoRepository.findByProductStatus(0);
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void findByProductIdIn() {
        List<ProductInfo> list  = productInfoRepository.findByProductIdIn(Arrays.asList("157875196366160022","111"));
        Assert.assertTrue(list.size() == 1);
    }
}
