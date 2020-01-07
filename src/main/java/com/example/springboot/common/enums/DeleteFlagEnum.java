package com.example.springboot.common.enums;
/*
 *删除状态  公共使用的枚举类
 *author jtf
 *@date 2019/12/31/031
 *@param
 *@return
 */

public enum DeleteFlagEnum {
    DELETE(1),NOT_DELETE(0);
    private int isDelete;
    DeleteFlagEnum(int i) {
        isDelete = i;
    }
    public int getIsDelete() {
        return isDelete;
    }
}
