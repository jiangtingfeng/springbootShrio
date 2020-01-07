package com.example.springboot.common.table;

import lombok.Data;

import java.util.List;

/**
 * @Auther: chenyu
 * @Date: 2019/4/25 09:04
 * @Description:
 */
@Data
public class BatchFieldData {

    private String tableName;

    /**
     * 字段名
     */
    private List<String> fieldCodes;
    /**
     * 字段值
     */
    private List<List<Object>> params;

    public BatchFieldData(String tableName, List<String> fieldCodes, List<List<Object>> params) {
        this.tableName = tableName;
        this.fieldCodes = fieldCodes;
        this.params = params;
    }
}
