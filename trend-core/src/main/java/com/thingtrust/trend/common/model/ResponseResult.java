package com.thingtrust.trend.common.model;

import com.thingtrust.trend.common.enums.ErrorCode;
import com.thingtrust.trend.common.support.consts.AppEnvConsts;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.Serializable;

/**
 * 〈返回模板类〉
 *
 * @author WangYu
 * @create 2018/5/15
 * @since 1.0.0
 */
public class ResponseResult implements Serializable {

    private int code = 0;
    private String msg = "";
    private String detailMsg = "";
    private Object data;

    public static ResponseResult success() {
        return success("");
    }

    public static ResponseResult success(Object data) {
        return build(0, "Success", "", data);
    }

    public static ResponseResult failure(int code, String msg) {
        return failure(code, msg, "");
    }

    public static ResponseResult failure(ErrorCode errorCode) {
        return failure(errorCode, "");
    }

    public static ResponseResult failure(ErrorCode errorCode, Throwable ex) {
        return failure(errorCode, AppEnvConsts.isProductionMode() ? "" : ExceptionUtils.getStackTrace(ex));
    }

    public static ResponseResult failure(ErrorCode errorCode, String detailMsg) {
        return failure(errorCode.getCode(), errorCode.getMessage(), detailMsg);
    }

    public static  ResponseResult failure(ErrorCode errorCode, Object data) {
        return build(errorCode.getCode(), errorCode.getMessage(), "", data);
    }

    public static ResponseResult failure(String msg) {
        return failure(-1, msg, (String)"");
    }

    public static ResponseResult failure(String msg, String detailMsg) {
        return failure(-1, msg, (String)detailMsg);
    }

    public static ResponseResult failure(int code, String msg, String detailMsg) {
        return build(code, msg, detailMsg, "");
    }

    public static ResponseResult failure(int code, String msg, Throwable ex) {
        return build(code, msg, AppEnvConsts.isProductionMode() ? "" : ExceptionUtils.getStackTrace(ex), new Object());
    }

    public static  ResponseResult build(int code, String msg, String detailMsg, Object data) {
        return new ResponseResult(code, msg, detailMsg, data);
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getDetailMsg() {
        return this.detailMsg;
    }

    public Object getData() {
        return this.data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setDetailMsg(String detailMsg) {
        this.detailMsg = detailMsg;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ResponseResult)) {
            return false;
        } else {
            ResponseResult other = (ResponseResult)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getCode() != other.getCode()) {
                return false;
            } else {
                label49: {
                    Object this$msg = this.getMsg();
                    Object other$msg = other.getMsg();
                    if (this$msg == null) {
                        if (other$msg == null) {
                            break label49;
                        }
                    } else if (this$msg.equals(other$msg)) {
                        break label49;
                    }

                    return false;
                }

                Object this$detailMsg = this.getDetailMsg();
                Object other$detailMsg = other.getDetailMsg();
                if (this$detailMsg == null) {
                    if (other$detailMsg != null) {
                        return false;
                    }
                } else if (!this$detailMsg.equals(other$detailMsg)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof ResponseResult;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 59 + this.getCode();
        Object $msg = this.getMsg();
        result = result * 59 + ($msg == null ? 43 : $msg.hashCode());
        Object $detailMsg = this.getDetailMsg();
        result = result * 59 + ($detailMsg == null ? 43 : $detailMsg.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ResponseResult(code=" + this.getCode() + ", msg=" + this.getMsg() + ", detailMsg=" + this.getDetailMsg() + ", data=" + this.getData() + ")";
    }

    public ResponseResult() {
    }

    private ResponseResult(int code, String msg, String detailMsg, Object data) {
        this.code = code;
        this.msg = msg;
        this.detailMsg = detailMsg;
        this.data = data;
    }
}
