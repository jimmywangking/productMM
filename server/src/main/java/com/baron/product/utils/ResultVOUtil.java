package com.baron.product.utils;

import com.baron.product.VO.ResultVO;

/***
 @package com.baron.product
 @author Baron
 @create 2020-08-12-12:21 AM
 */
public class ResultVOUtil {
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("DONE!");
        resultVO.setDate(object);
        return resultVO;
    }
}
