package com.baron.product.service;

import com.baron.product.dataobject.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 @package com.baron.product.service
 @author Baron
 @create 2020-08-11-10:44 PM
 */
@Service
public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
