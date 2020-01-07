package com.example.springboot.common.page;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author jiangtingfeng
 * @description
 * @date 2019/12/31/031
 */
@Data
public class ReturnParamsMap implements Serializable {
    private Map<String,Object> paramsMap;
    private Map<String,Object> returnMap;
}
