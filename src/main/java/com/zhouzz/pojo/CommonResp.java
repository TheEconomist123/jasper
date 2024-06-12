package com.zhouzz.pojo;

import java.io.Serializable;

/**
 * @author zhouzz
 * @version 1.0
 * @date 2024/6/4 周二
 * @time 15:45
 * @desc
 */
public class CommonResp implements Serializable {
    private String retCode;
    private String retMsg;
    private Object retData;

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public Object getRetData() {
        return retData;
    }

    public void setRetData(Object retData) {
        this.retData = retData;
    }
}
