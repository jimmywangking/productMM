package com.baron.product.service.imp;

import com.baron.common.dataobject.DescreaseStockInput;
import com.baron.common.dataobject.ProductInfoOutput;
import com.baron.product.dataobject.ProductInfo;
import com.baron.product.enums.ProductStatusEnum;
import com.baron.product.enums.ResultEnum;
import com.baron.product.exception.ProductException;
import com.baron.product.repository.ProductInfoRepository;
import com.baron.product.service.ProductService;
import com.baron.product.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/***
 @package com.baron.product.service.imp
 @author Baron
 @create 2020-08-11-10:09 PM
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfoOutput> findList(List<String> productIdList) {

        return productInfoRepository.findByProductIdIn(productIdList).stream()
                .map(e -> {
                    ProductInfoOutput productInfoOutput = new ProductInfoOutput();
                    BeanUtils.copyProperties(e, productInfoOutput);
                    return productInfoOutput;
        }).collect(Collectors.toList());
    }

    @Transient
    public List<ProductInfo> descreaseStockProcess(List<DescreaseStockInput> descreaseStockInputList) {
        List<ProductInfo> productInfoList = new ArrayList<>();
        for(DescreaseStockInput descreaseStockInput : descreaseStockInputList){
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(descreaseStockInput.getProductId());
            if(!productInfoOptional.isPresent()){
                log.info("商品不存在");
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo = productInfoOptional.get();
            //库存判断
            Integer result = productInfo.getProductStock() - descreaseStockInput.getProductQuantity();
            if(result <0){
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
            productInfoList.add(productInfo);

        }
        return productInfoList;
    }


    @Override
    public void descreaseStock(List<DescreaseStockInput> descreaseStockInputList) {

        List<ProductInfo> productInfoList = descreaseStockProcess(descreaseStockInputList);
        List<ProductInfoOutput> outputs = productInfoList.stream().map(e -> {
            ProductInfoOutput productInfoOutput = new ProductInfoOutput();
            BeanUtils.copyProperties(e, productInfoOutput);
            return productInfoOutput;
        }).collect(Collectors.toList());
        //发送消息
//        ProductInfoOutput productInfoOutput = new ProductInfoOutput();
//        BeanUtils.copyProperties(productInfo,productInfoOutput);
        amqpTemplate.convertAndSend("productInfo", JsonUtil.toJson(outputs));

    }
}
