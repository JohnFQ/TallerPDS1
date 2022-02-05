package co.com.poli.pds.proyectos.model;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@Builder
public class Response {
	
	private Integer code;
	private Boolean status;
	private String message;
	private Object data;
	
	public Response() {
		
	}
	
	public Response(Integer code, Boolean status, String message, Object data ) {
		this.status = status;
		this.message = message;
		this.data = data;
	}
	
	
}
