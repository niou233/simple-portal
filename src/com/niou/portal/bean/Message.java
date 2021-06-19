/**
 * Copyright 2021 json.cn
 */
package com.niou.portal.bean;
import java.util.List;

/**
 * Auto-generated: 2021-06-19 13:30:43
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class Message {

    private Object data;
    private String msg;
    private int status;

    @Override
    public String toString() {
        return "Message{" +
                "data=" + data +
                ", msg='" + msg + '\'' +
                ", status=" + status +
                '}';
    }

    public void setData(Object data) {
        this.data = data;
    }
    public Object getData() {
        return data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public int getStatus() {
        return status;
    }

}