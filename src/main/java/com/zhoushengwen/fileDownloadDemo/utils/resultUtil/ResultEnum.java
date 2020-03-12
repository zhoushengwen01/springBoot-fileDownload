package com.zhoushengwen.fileDownloadDemo.utils.resultUtil;

public enum ResultEnum {

    SUCCESS("200", "成功"),
    ERROR("-1", "失败"),
    FIlE_NAME_IS_EMPTY("500","文件名称为空"),
    RESOURCES_IS_NULL("501","资源不存在");

    private String code;
    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
