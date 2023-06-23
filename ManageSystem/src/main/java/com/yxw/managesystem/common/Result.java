package com.yxw.managesystem.common;

import com.yxw.managesystem.common.exception.BusinessException;
import com.yxw.managesystem.enums.ExceptionTypeEnum;
import com.yxw.managesystem.enums.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel("Result")
public class Result {
    /**
     * 1.status状态值：代表本次请求response的状态结果。
     */
    @ApiModelProperty("状态码")
    private String status;
    /**
     * 2.response描述：对本次状态码的描述。
     */
    @ApiModelProperty("描述")
    private String msg;
    /**
     * 3.data数据：本次返回的数据。
     */
    @ApiModelProperty("数据")
    private Object data;

    /**
     * 成功，创建ResResult：没data数据
     */
    public static Result suc() {
        Result result = new Result();
        result.setResultEnum(ResultCodeEnum.SUCCESS);
        return result;
    }

    /**
     * 成功，创建ResResult：有data数据
     */
    public static Result suc(Object data) {
        Result result = new Result();
        result.setResultEnum(ResultCodeEnum.SUCCESS);
        result.setData(data);
        return result;
    }

    /**
     * 失败，指定status、desc
     */
    public static Result fail(String status, String desc) {
        Result result = new Result();
        result.setStatus(status);
        result.setMsg(desc);
        return result;
    }

    /**
     * 失败，指定ResultCode枚举
     */
    public static Result fail(ResultCodeEnum resultCode) {
        Result result = new Result();
        result.setResultEnum(resultCode);
        return result;
    }

    public static Result fail() {
        Result result = new Result();
        result.setResultEnum(ResultCodeEnum.FAIL);
        return result;
    }

    public static Result fail(String msg) {
        Result result = new Result();
        result.setData(null);
        result.setStatus("200");
        result.setMsg(msg);
        return result;
    }

    public static Result fail(BusinessException e) {
        Result result = new Result();
        result.setData(e);
        result.setStatus(e.getCode());
        result.setMsg(e.getMessage());
        return result;
    }

    public static Result fail(ExceptionTypeEnum typeEnum) {
        Result result = new Result();
        result.setData(null);
        result.setStatus(typeEnum.getCode());
        result.setMsg(typeEnum.getMessage());
        return result;
    }

    /**
     * 把ResultCode枚举转换为ResResult
     */
    private void setResultEnum(ResultCodeEnum code) {
        this.status = code.code();
        this.msg = code.message();
    }
}
