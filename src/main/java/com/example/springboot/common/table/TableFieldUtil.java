package com.example.springboot.common.table;

import com.example.springboot.common.enums.FieldTypeEnum;
import org.springframework.stereotype.Component;

@Component
public class TableFieldUtil {
    public static TableFieldParam getTableFieldId(){
        TableFieldParam tableFieldId = new TableFieldParam();
        tableFieldId.setFieldName("序号");
        tableFieldId.setFieldCode("id");
        tableFieldId.setPrimary(true);
        tableFieldId.setAutoIncrement(true);
        tableFieldId.setRequired(false);
        tableFieldId.setUnique(false);
        tableFieldId.setSys(true);
        tableFieldId.setTableFieldType(new TableFieldType(FieldTypeEnum.LONG, 20, 0));
        return tableFieldId;
    }

    public static TableFieldParam getTableFieldCode(){
        TableFieldParam tableFieldCode = new TableFieldParam();
        tableFieldCode.setFieldName("码");
        tableFieldCode.setFieldCode("code");
        tableFieldCode.setPrimary(false);
        tableFieldCode.setAutoIncrement(false);
        tableFieldCode.setRequired(true);
        tableFieldCode.setUnique(true);
        tableFieldCode.setSys(true);
        tableFieldCode.setTableFieldType(new TableFieldType(FieldTypeEnum.TEXT, 32, 0));
        tableFieldCode.setDefaultValue("n");
        return tableFieldCode;
    }

    public static TableFieldParam getTableFieldCodeSystemId(){
        TableFieldParam tableFieldCodeSystemId = new TableFieldParam();
        tableFieldCodeSystemId.setFieldName("码制");
        tableFieldCodeSystemId.setFieldCode("code_system_id");
        tableFieldCodeSystemId.setPrimary(false);
        tableFieldCodeSystemId.setAutoIncrement(false);
        tableFieldCodeSystemId.setRequired(true);
        tableFieldCodeSystemId.setUnique(false);
        tableFieldCodeSystemId.setSys(true);
        tableFieldCodeSystemId.setTableFieldType(new TableFieldType(FieldTypeEnum.LONG, 11, 0));
        tableFieldCodeSystemId.setDefaultValue("0");
        return tableFieldCodeSystemId;
    }

    public static TableFieldParam getTableFieldCodeDownloadId(){
        TableFieldParam tableFieldCode = new TableFieldParam();
        tableFieldCode.setFieldName("码下载Id");
        tableFieldCode.setFieldCode("code_download_id");
        tableFieldCode.setPrimary(false);
        tableFieldCode.setAutoIncrement(false);
        tableFieldCode.setRequired(true);
        tableFieldCode.setUnique(false);
        tableFieldCode.setSys(true);
        tableFieldCode.setTableFieldType(new TableFieldType(FieldTypeEnum.LONG, 11, 0));
        tableFieldCode.setDefaultValue("0");
        return tableFieldCode;
    }

    public static TableFieldParam getTableFieldStatus(){
        TableFieldParam tableFieldStatus = new TableFieldParam();
        tableFieldStatus.setFieldName("状态");
        tableFieldStatus.setFieldCode("status");
        tableFieldStatus.setPrimary(false);
        tableFieldStatus.setAutoIncrement(false);
        tableFieldStatus.setRequired(true);
        tableFieldStatus.setUnique(false);
        tableFieldStatus.setSys(true);
        tableFieldStatus.setTableFieldType(new TableFieldType(FieldTypeEnum.LONG, 11, 0));
        tableFieldStatus.setDefaultValue("0");
        return tableFieldStatus;
    }

    public static TableFieldParam getTableFieldCreateTime(){
        TableFieldParam tableFieldCreateTime = new TableFieldParam();
        tableFieldCreateTime.setFieldName("创建时间");
        tableFieldCreateTime.setFieldCode("create_time");
        tableFieldCreateTime.setPrimary(false);
        tableFieldCreateTime.setAutoIncrement(false);
        tableFieldCreateTime.setRequired(true);
        tableFieldCreateTime.setUnique(false);
        tableFieldCreateTime.setSys(true);
        tableFieldCreateTime.setTableFieldType(new TableFieldType(FieldTypeEnum.DATETIME, 0, 0));
        tableFieldCreateTime.setDefaultValue("CURRENT_TIMESTAMP");
        return tableFieldCreateTime;
    }

    public static TableFieldParam getTableFieldUpdateTime(){
        TableFieldParam tableFieldUpdateTime = new TableFieldParam();
        tableFieldUpdateTime.setFieldName("更新时间");
        tableFieldUpdateTime.setFieldCode("update_time");
        tableFieldUpdateTime.setPrimary(false);
        tableFieldUpdateTime.setAutoIncrement(false);
        tableFieldUpdateTime.setRequired(true);
        tableFieldUpdateTime.setUnique(false);
        tableFieldUpdateTime.setSys(true);
        tableFieldUpdateTime.setTableFieldType(new TableFieldType(FieldTypeEnum.DATETIME, 0, 0));
        tableFieldUpdateTime.setDefaultValue("CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP");
        return tableFieldUpdateTime;
    }
}
