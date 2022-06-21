package com.seres.module.data;

import com.seres.module.constant.MessageConstant;
import lombok.Data;

import java.util.Collections;
import java.util.List;
import java.util.Objects;


@Data
public class ResponseData<T> {

    private String msgCode;
    private String msg;
    private List<T> resp;
    private boolean success;
    private Integer total;

    /**
     * 返回操作成功
     */
    public ResponseData() {
        this.success = true;
        this.total = 0;
    }

    /**
     * 返回操作结果
     * @param success 操作结果
     */
    public ResponseData(boolean success) {
        this.success = success;
        this.total = 0;
    }

    /**
     * 返回list结果集且操作成功
     * @param list 数据集合
     */
    public ResponseData(List<T> list) {
        this(true);
        if(Objects.isNull(list)){
            this.resp = null;
            this.total = 0;
        }else{
            this.resp = list;
            this.total = list.size();
        }
    }

    /**
     *  返回状态码且操作成功
     * @param success   操作结果
     * @param msgCode   信息状态码
     */
    public ResponseData(boolean success, String msgCode) {
        this.success = success;
        this.total = 0;
        this.msgCode = msgCode;
    }

    /**
     * 返回操作结果
     * @param msgCode   信息状态码
     * @param msg       信息
     * @param success   操作结果
     */
    public ResponseData(String msgCode, String msg, boolean success) {
        this.msgCode = msgCode;
        this.msg = msg;
        this.success = success;
        this.total = 0;

    }

    /**
     *  返回分页结果
     * @param msgCode   信息状态码
     * @param msg       信息
     * @param resp      返回集合
     * @param success   是否操作成功
     * @param total     数据总条数
     */
    public ResponseData(String msgCode, String msg, List<T> resp, boolean success, Integer total) {
        this.msgCode = msgCode;
        this.msg = msg;
        this.resp = resp;
        this.success = success;
        this.total = total;
    }

    /**
     * 返回全集结果
     * @param msgCode   信息状态码
     * @param msg       信息
     * @param resp      返回集合
     * @param success   是否操作成功
     */
    public ResponseData(String msgCode, String msg, List<T> resp, boolean success) {
        this.msgCode = msgCode;
        this.msg = msg;
        this.resp = resp;
        this.success = success;
        if (null != resp && !resp.isEmpty()) {
            this.total = resp.size();
        } else {
            this.total = 0;
        }
    }

    public static <T> ResponseData<T> success(T data) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setResp(Collections.singletonList(data));
        responseData.setMsgCode(MessageConstant.SYS_SUCCESS);
        responseData.setMsg(MessageConstant.SYS_SUCCESS_VALUE);
        return responseData;
    }

    public static <T> ResponseData<T> success() {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setMsgCode(MessageConstant.SYS_SUCCESS);
        responseData.setMsg(MessageConstant.SYS_SUCCESS_VALUE);
        return responseData;
    }

    public static <T> ResponseData<T> successWithMsg(String message) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setMsgCode(MessageConstant.SYS_SUCCESS);
        responseData.setMsg(message);
        return responseData;
    }

    public static <T> ResponseData<T> fail(String msgCode, String msg) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setMsgCode(msgCode);
        responseData.setMsg(msg);
        responseData.setSuccess(false);
        return responseData;
    }

    public static <T> ResponseData<T> fail() {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setMsgCode(MessageConstant.SYS_FAILED);
        responseData.setMsg(MessageConstant.SYS_FAILED_VALUE);
        responseData.setSuccess(false);
        return responseData;
    }

    public static <T> ResponseData<T> fail(T data) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setMsgCode(MessageConstant.SYS_FAILED);
        responseData.setMsg(MessageConstant.SYS_FAILED_VALUE);
        responseData.setSuccess(false);
        responseData.setResp(Collections.singletonList(data));
        return responseData;
    }

    public static<T> ResponseData<T> failWithMsg(String message) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setMsgCode(MessageConstant.SYS_FAILED);
        responseData.setMsg(message);
        responseData.setSuccess(false);
        return responseData;
    }

    public static <T> ResponseData<T> fail(T data, MessageEnum messageEnum) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setMsgCode(messageEnum.name());
        responseData.setMsg(messageEnum.getMessage());
        responseData.setSuccess(false);
        responseData.setResp(Collections.singletonList(data));
        return responseData;
    }

    public static <T> ResponseData<T> fail(T data, String code, String message) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setMsgCode(code);
        responseData.setMsg(message);
        responseData.setSuccess(false);
        responseData.setResp(Collections.singletonList(data));
        return responseData;
    }

    public static <T> ResponseData<T> fail(MessageEnum messageEnum) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setMsgCode(messageEnum.name());
        responseData.setMsg(messageEnum.getMessage());
        responseData.setSuccess(false);
        return responseData;
    }

    public static <T> ResponseData<T> success(MessageEnum messageEnum) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setMsgCode(messageEnum.name());
        responseData.setMsg(messageEnum.getMessage());
        responseData.setSuccess(true);
        return responseData;
    }

    public static <T> ResponseData<T> success(MessageEnum messageEnum, T data) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setMsgCode(messageEnum.name());
        responseData.setMsg(messageEnum.getMessage());
        responseData.setSuccess(true);
        responseData.setResp(Collections.singletonList(data));
        return responseData;
    }
}
