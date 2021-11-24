package com.mic.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @Title: JSONResult.java
 * @Package com.mic.utils
 * @Description: 自定义响应数据结构
 * 				本类可提供给 H5/ios/安卓/公众号/小程序 使用
 * 				前端接受此类数据（json object)后，可自行根据业务去实现相关功能
 * 
 * 				200：表示成功
 * 				500：表示错误，错误信息在msg字段中
 * 				501：bean验证错误，不管多少个错误都以map形式返回
 * 				502：拦截器拦截到用户token出错
 * 				555：异常抛出信息
 * 				556: 用户qq校验异常
 * @Copyright: Copyright (c) 2020
 * @Company: www.imooc.com
 * @author 慕课网 - 风间影月
 * @version V1.0
 */
public class FimJSONResult {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;
    
    @JsonIgnore
    private String ok;	// 不使用

    public static FimJSONResult build(Integer status, String msg, Object data) {
        return new FimJSONResult(status, msg, data);
    }

    public static FimJSONResult build(Integer status, String msg, Object data, String ok) {
        return new FimJSONResult(status, msg, data, ok);
    }
    
    public static FimJSONResult ok(Object data) {
        return new FimJSONResult(data);
    }

    public static FimJSONResult ok() {
        return new FimJSONResult(null);
    }
    
    public static FimJSONResult errorMsg(String msg) {
        return new FimJSONResult(500, msg, null);
    }
    
    public static FimJSONResult errorMap(Object data) {
        return new FimJSONResult(501, "error", data);
    }
    
    public static FimJSONResult errorTokenMsg(String msg) {
        return new FimJSONResult(502, msg, null);
    }
    
    public static FimJSONResult errorException(String msg) {
        return new FimJSONResult(555, msg, null);
    }
    
    public static FimJSONResult errorUserQQ(String msg) {
        return new FimJSONResult(556, msg, null);
    }

    public FimJSONResult() {

    }

    public FimJSONResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    
    public FimJSONResult(Integer status, String msg, Object data, String ok) {
        this(status, msg, data);
        this.ok = ok;
    }

    public FimJSONResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOK() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

	public String getOk() {
		return ok;
	}

	public void setOk(String ok) {
		this.ok = ok;
	}

}
