package com.example.springboot.common.table;

import com.example.springboot.common.enums.FieldTypeEnum;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: chenyu
 * @Date: 2019/4/19 10:31
 * @Description:  表的字段信息
 */
@Data
public class TableFieldParam {

	public final static Map<String, TableFieldParam> sysFields = new LinkedHashMap<>();

	/**
	 * 初始化系统字段
	 */
	static {
		TableFieldParam idParam = getPrimaryColumn();// Id
		sysFields.put(idParam.getFieldCode(), idParam);
		sysFields.put(AppConstants.COLUMN_CREATETIME, getColumn(true, AppConstants.COLUMN_CREATETIME, "创建时间", new TableFieldType(FieldTypeEnum.DATE, 0,0)));
	}

	public static TableFieldParam getColumn(Boolean sys, String fieldCode, String fieldName, TableFieldType tableFieldType){
		TableFieldParam tableFieldParam = new TableFieldParam();
		tableFieldParam.setSys(sys);
		tableFieldParam.setPrimary(false);
		tableFieldParam.setUnique(false);
		tableFieldParam.setAutoIncrement(false);
		tableFieldParam.setRequired(false);
		tableFieldParam.setFieldCode(fieldCode);
		tableFieldParam.setFieldName(fieldName);
		tableFieldParam.setTableFieldType(tableFieldType);
		return tableFieldParam;
	}

	public static TableFieldParam getPrimaryColumn(){
		TableFieldParam idParam = new TableFieldParam();
		idParam.setSys(true);
		idParam.setPrimary(true);
		idParam.setUnique(true);
		idParam.setRequired(true);
		idParam.setAutoIncrement(true);
		idParam.setFieldCode(AppConstants.COLUMN_ID);
		idParam.setFieldName(AppConstants.COLUMN_ID);
		idParam.setTableFieldType(new TableFieldType(FieldTypeEnum.LONG, 0,0));
		return idParam;
	}

	/**
	 * 获取所有系统字段
	 * @return
	 */
	public static List<TableFieldParam> getSysFields(){
		ArrayList<TableFieldParam> tableFieldParams = new ArrayList<>();
		tableFieldParams.addAll(sysFields.values());
		return tableFieldParams;
	}

	/**
	 * 字段名
	 */
	private String fieldCode;

	/**
	 * 字段描述
	 */
	private String fieldName;

	/**
	 * 字段类型
	 */
	private TableFieldType tableFieldType;

	/**
	 * 字段是否必填
	 */
	private boolean	isRequired;

	/**
	 * 字段是否是主键
	 */
	private boolean	isPrimary;

	/**
	 * 主键是否自增
	 */
	private boolean	isAutoIncrement;

	/**
	 * 字段默认值
	 */
	private String defaultValue;

	/**
	 * 值是否唯一
	 */
	private boolean	isUnique;

	/**
	 * 是否系统字段
	 */
	private boolean isSys;

}
