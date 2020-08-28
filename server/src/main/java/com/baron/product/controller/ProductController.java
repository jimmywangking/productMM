package com.baron.product.controller;

import com.baron.common.dataobject.DescreaseStockInput;
import com.baron.common.dataobject.ProductInfoOutput;
import com.baron.product.VO.ProductInfoVO;
import com.baron.product.VO.ProductVO;
import com.baron.product.VO.ResultVO;
import com.baron.product.dataobject.ProductCategory;
import com.baron.product.dataobject.ProductInfo;
import com.baron.product.service.CategoryService;
import com.baron.product.service.ProductService;
import com.baron.product.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/***
 @package com.baron.product
 @author Baron
 @create 2020-08-11-6:49 PM
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    @CrossOrigin(allowCredentials = "true")
    public ResultVO<ProductVO> list(){
        List<ProductInfo> productInfoList = productService.findUpAll();
        List<Integer> categoryList = productInfoList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryList);

        List<ProductVO> productVOArrayList = new ArrayList<ProductVO>();
        for(ProductCategory productCategory : productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVO> productInfoVOArrayList  = new ArrayList<ProductInfoVO>();
            for(ProductInfo productInfo : productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
//                productInfoVO.setProductId(productInfo.getProductId());
//                productInfoVO.setProductName(productInfo.getProductName());
//                productInfoVO.setProductPrice(productInfo.getProductPrice());
//                productInfoVO.setProductDescription(productInfo.getProductDescription());
//                productInfoVO.setProductIcon(productInfo.getProductIcon());
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOArrayList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOArrayList);
            productVOArrayList.add(productVO);
        }
//        ResultVO resultVO = new ResultVO();
//        resultVO.setCode(0);
//        resultVO.setMsg("DONE!");
//        resultVO.setDate(productVOArrayList);
        return ResultVOUtil.success(productVOArrayList);
    }

    @PostMapping("/listForOrder")
    public List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList){
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return productService.findList(productIdList);
    }

    @PostMapping("/descreaseStock")
    public void descreaseStock(@RequestBody List<DescreaseStockInput> descreaseStockInputList){
        productService.descreaseStock(descreaseStockInputList);
    }
}
