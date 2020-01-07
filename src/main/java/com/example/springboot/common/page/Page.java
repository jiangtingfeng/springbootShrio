package com.example.springboot.common.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jiangtingfeng
 * @description 分页实体类
 * @date 2019/12/31/031
 */
@Data
@ApiModel(description = "分页结果实体类")
public class Page implements Serializable {
    @ApiModelProperty("当前页开始数字")
    private int startNumber;
    @ApiModelProperty("当前页")
    private int current;
    @ApiModelProperty("总页数")
    private int totalPage;
    @ApiModelProperty("每页记录数")
    private int pageSize;
    @ApiModelProperty("总记录数")
    private int total;

    public Page (int pageSize,int current,int total) throws Exception {
        if (pageSize <1 || current < 1) {
            throw new Exception("每页记录数或者当前页的值小于1");
        }
        this.pageSize = pageSize;
        this.current = current;
        this.total = total;
        this.startNumber = (current - 1) * pageSize;

        if (total == 0) {
            this.totalPage = 1;
        } else {
            int temCount = total%pageSize;
            int totalPage = total / pageSize;
            if (temCount != 0) {
                totalPage = totalPage + 1;
            }
            this.totalPage = totalPage;
        }
    }
}
