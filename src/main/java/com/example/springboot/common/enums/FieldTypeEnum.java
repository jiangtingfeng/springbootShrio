package com.example.springboot.common.enums;


import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.core.enums.IEnum;
import com.example.springboot.common.util.JsonUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: chenyu
 * @Date: 2019/4/16 14:58
 * @Description: 字段类型 ["{1,int32(整数型)}","{2,float(单精度浮点型)}","{3,double(}","{4,enum(枚举型)}","{5,bool(布尔型)}","{6,text(字符串)}","{7,date(时间型)}"]
 * 拓展后续注意TableFieldType.toString 实现
 *
 * 注意此NAME不能超过30个字符，否则需改表结构
 */
public enum FieldTypeEnum implements IEnum<Integer>{


    LONG(1, "int32(整数型)"),

    FLOAT(2, "float(单精度浮点型)"),

    DOUBLE(3, "double(双精度浮点型)"),

    ENUM(4, "enum(枚举型)"),

    Boolean(5, "bool(布尔型)"),

    TEXT(6, "text(字符串)"),
    /**
     * long类型的UTC时间戳 (毫秒)
     */
    DATE(7, "date(时间型)"),

    ARRAY(8, "array(数组)"),

    DATETIME(9, "date(时间型)")
    ;

    /**
     * 类型数值
     */
    @EnumValue
    private Integer value;

    /**
     * 类型名称
     */
    private String title;


    static final Map<Integer,FieldTypeEnum> map = new HashMap<Integer,FieldTypeEnum>();
    static {
        for (FieldTypeEnum c : FieldTypeEnum.values()) {
            map.put(c.getValue(), c);
        }
    }

    FieldTypeEnum(Integer value, String title) {
        this.value = value;
        this.title = title;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static FieldTypeEnum getByType(Integer type) throws Exception {
        if(type == null){
            throw new Exception("未知的参数类型");
        }
        FieldTypeEnum fieldTypeEnum = map.get(type);
        if(fieldTypeEnum == null){
            throw new Exception("未知的参数类型");
        }
        return fieldTypeEnum;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static void main(String[] args) {
        System.out.println(JsonUtil.toJSONString(FieldTypeEnum.values()));
    }
}
