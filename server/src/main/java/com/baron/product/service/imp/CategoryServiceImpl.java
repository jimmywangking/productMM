package com.baron.product.service.imp;

import com.baron.product.dataobject.ProductCategory;
import com.baron.product.repository.ProductCategoryRepository;
import com.baron.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/***
 @package com.baron.product.service.imp
 @author Baron
 @create 2020-08-11-10:47 PM
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}
