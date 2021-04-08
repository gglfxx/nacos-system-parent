package com.auth.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *  response返回封装
 */
@Data
@NoArgsConstructor                 //无参构造
@AllArgsConstructor                //有参构造
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 942582550094283238L;

	/**
     * 是否成功
     */
    private boolean success = true;

    /**
     * 服务器当前时间戳
     */
    private Long systemTime = System.currentTimeMillis();

    /**
     * 成功数据
     */
    private T data;

    /**
     * 错误码
     */
    private int code;

    /**
     * 错误描述
     */
    private String msg;

    private long count;

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", systemTime=" + systemTime +
                ", data=" + data +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
