package dominic.common.base;

import java.io.Serializable;

/**
 * Created by Administrator:herongxing on 2017/4/13 14:32.
 */

public class ResultDTO<T> implements Serializable {
	
	private boolean success = true;
	private String resultCode;
	private String message;
	private T model;
    
    private ResultDTO(boolean success, T model, String message, String resultCode){
    	this.success = success;
    	this.model = model;
    	this.message = message;
    	this.resultCode = resultCode;
    }
    
    public static <T> ResultDTO<T> succeed(){
    	return new ResultDTO<T>(true, null, null, null);
    }
    public static <T> ResultDTO<T> succeedWith(T model){
		return succeedWith(model, null);
    }
    public static <T> ResultDTO<T> succeedWith(T model, String message){
    	return new ResultDTO<T>(true, model, message, null);
    }
    public static <T> ResultDTO<T> succeedWith(T model, String message, String resultCode){
    	return new ResultDTO<T>(true, model, message, resultCode);
    }

    public static <T> ResultDTO<T> failed(String message){
    	return failedWith(null, message);
    }
    public static <T> ResultDTO<T> failedWith(T model, String message){
        return new ResultDTO<T>(false, model , message, null);
    }
    public static <T> ResultDTO<T> failedWith(T model, String message, String resultCode){
        return new ResultDTO<T>(false, model , message, resultCode);
    }

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getModel() {
		return model;
	}

	public void setModel(T model) {
		this.model = model;
	}
    
    @Override
	public String toString() {
		return "ResultDTO(success=" + this.isSuccess() + ", resultCode=" + this.getResultCode() + ", message=" + this.getMessage() + ", model=" + this.getModel() + ")";
	}
}
