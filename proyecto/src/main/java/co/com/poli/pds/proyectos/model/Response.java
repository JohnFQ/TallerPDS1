package co.com.poli.pds.proyectos.model;


import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Builder
public class Response {
	
	private Integer code;
	private Boolean status;
	private String message;
	private Object data;
	
	
	
	
}
