package com.mmjj.common.lang;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {

    private int code; //200为正常，其余异常
    private String msg;
    private Object data;

    public static Result success(Object data){
        return success(200,"操作成功", data);
    }

    public static Result success(int code, String msg, Object data){
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static Result fail(String msg){
        return fail(400,msg,null);
    }

    public static Result fail(String msg, Object data){
        return fail(400,msg,data);
    }

    public static Result fail(int code, String msg, Object data){
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

}
