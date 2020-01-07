package com.example.springboot.common.table;

import lombok.Data;

import java.util.Map;

/**
 * @Auther: chenyu
 * @Date: 2019/4/24 21:10
 * @Description: 单条记录信息
 */
@Data
public class FieldData {

    private Long id;

    private String tableName;

    /**
     * key:字段名，value:值
     */
    private Map<String, Object> params;

    public FieldData(String tableName, Map<String, Object> params) {
        this.tableName = tableName;
        this.params = params;
    }
}
