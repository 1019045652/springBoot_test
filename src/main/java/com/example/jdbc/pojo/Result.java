package com.example.jdbc.pojo;

public class Result {


    private Integer code;//状态码
    private Boolean isSuccess;//状态
    private String massege;//消息
    private Object result;//数据对象

    /**
     * 无参构造器
     */
    public Result(){
        super();
    }

    public Result(Boolean success, Integer code, String massege){
        super();
        this.isSuccess=success;
        this.code=code;
        this.massege=massege;
    }

    public Result(Boolean success, Integer code, Object result){
        super();
        this.isSuccess=success;
        this.code=code;
        this.result=result;
    }

    public Result(Boolean success, Integer code, String massege, Object result){
        super();
        this.isSuccess=success;
        this.code=code;
        this.massege=massege;
        this.result=result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getMassege() {
        return massege;
    }

    public void setMassege(String massege) {
        this.massege = massege;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
