package logol.common;

import java.io.Serializable;

public class RestResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int status;	
	private String message; 
	private Object contents;
	private long totalRecords;	
	
	public RestResponse(){
	}
	
	public RestResponse(int status, String message, Object contents){
		this.status = status;
		this.message = message;
		this.contents = contents;
	}
	
	public RestResponse(int status, String message){
		this.status = status;
		this.message = message;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Object getContents() {
		return contents;
	}
	
	public void setContents(Object contents) {
		this.contents = contents;
	}

	public long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	} 
		
}
