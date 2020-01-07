package com.example.springboot.common.page;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiangtingfeng
 * @description
 * @date 2020/1/3/003
 */
@Data
public class DaoSerach {
    @ApiModelProperty(
            name = "flag",
            value = "搜索标记;0-高级搜索；1-普通搜索",
            example = "1",
            hidden = true
    )
    private Integer flag = 1;
    @ApiModelProperty(
            name = "search",
            value = "普通搜索值",
            example = ""
    )
    private String search;
    @ApiModelProperty(
            name = "params",
            value = "高级搜索集合",
            example = "{\"\":\"\",\"\":\"\"}",
            dataType = "json字符串",
            hidden = true
    )
    private Map params;
    @ApiModelProperty(
            hidden = true
    )
    private Map other;
    @ApiModelProperty(
            name = "startNumber",
            value = "分页开始数值",
            example = "1",
            hidden = true
    )
    private Integer startNumber;
    @ApiModelProperty(
            name = "pageSize",
            value = "每页多少数据",
            example = "10"
    )
    private Integer pageSize;
    @ApiModelProperty(
            name = "current",
            value = "当前第几页",
            example = "1"
    )
    private Integer current;
    public static final int ADVANCED_SEARCH = 0;
    public static final int GENERAL_SEARCH = 1;

    public void setParams(String params) {
        try {
            if (params != null && !"".equals(params) && !"null".equals(params)) {
                this.params = JSON.parseObject(params);
            } else {
                this.params = new HashMap(0);
            }
        } catch (Exception var3) {
            var3.printStackTrace();
            this.params = new HashMap(0);
        }
    }
}
