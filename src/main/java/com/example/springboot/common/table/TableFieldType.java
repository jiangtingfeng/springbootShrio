package com.example.springboot.common.table;

import com.example.springboot.common.enums.FieldTypeEnum;
import lombok.Data;

/**
 * @Auther: chenyu
 * @Date: 2019/4/19 17:04
 * @Description: 表字段类型
 */
@Data
public class TableFieldType {

    /**
     * 字段类型
     */
    private FieldTypeEnum fieldType;

    /**
     * 字段长度
     */
    private Integer fieldLength;

    /**
     * 字段小数长度
     */
    private Integer	decimalPlaces;

    public TableFieldType(FieldTypeEnum fieldType, Integer fieldLength, Integer decimalPlaces) {
        this.fieldType = fieldType;
        this.fieldLength = fieldLength;
        this.decimalPlaces = decimalPlaces;
    }

    /**
     *  字段类型，目前
     *    varchar(1)
     *    double(5,2)
     *    datetime
     *    decimal(5,2)
     * @return
     */
    @Override
    public String toString() {
        switch (fieldType){
            case DOUBLE:
            case FLOAT:
                return new StringBuilder("decimal(10,").append(fieldLength).append(")").toString();
            case TEXT:
                if(fieldLength == null || fieldLength == 0){
                    return "varchar(512)";
                }else{
                    return new StringBuilder("varchar(").append(fieldLength).append(")").toString();
                }
            case LONG:
            case DATE:
                return "bigint";
            case DATETIME:
                return "datetime";
            case ENUM:
                return "tinyint(4)";
            case Boolean:
                return "tinyint(1)";
            default: // 默认json
                return "json";
        }
    }
}
