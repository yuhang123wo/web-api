package com.yuhang.framework;

import java.io.Serializable;

public class JsonResult implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4783777689121397396L;
	private Integer success;
	private Object data;
	private ErrorMessage error;
	// 传递至前端的其他参数
	private Object others;
	public JsonResult(Integer success, Object data, String errorCode, String errorMessage) {
		this.data = data;
		this.success = success;
		if (success == 0) {
			this.error = new ErrorMessage(errorCode, errorMessage);
		}
	}

	public JsonResult(Integer success, Object data, Object others) {
		this(success, data);
		this.others = others;

	}

	public JsonResult(Integer success, Object data) {
		this.data = data;
		this.success = success;
	}

	public JsonResult(MyException exception) {
		this.data = null;
		this.success = 0;
		String errorCode = exception.getMessage();
		String errorMsg = ErrorInfos.getMessage(errorCode);
		this.setError(new ErrorMessage(errorCode, errorMsg
				+ (exception.getMsgExtention() == null ? "" : exception.getMsgExtention())));
	}

	public JsonResult(String errorCode) {
		this.data = null;
		this.success = 0;
		String errorMsg = ErrorInfos.getMessage(errorCode);
		this.setError(new ErrorMessage(errorCode, errorMsg));
	}

	public Integer getSuccess() {
		return success;
	}

	public void setSuccess(Integer success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ErrorMessage getError() {
		return error;
	}

	public void setError(ErrorMessage error) {
		this.error = error;
	}

	public Object getOthers() {
		return others;
	}

	public void setOthers(Object others) {
		this.others = others;
	}

}

class ErrorMessage {
	private String code;
	private String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ErrorMessage(String code, String message) {
		this.setCode(code);
		this.setMessage(message);
	}
}
