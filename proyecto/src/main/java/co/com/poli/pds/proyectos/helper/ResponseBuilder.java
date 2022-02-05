package co.com.poli.pds.proyectos.helper;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import co.com.poli.pds.proyectos.model.Response;

@Component
public class ResponseBuilder {

	public Response success() {
		Response rs = new Response(HttpStatus.CREATED.value(), true, "Se ha creado satisfactoriamente");
		return rs;
	}
	
	public Response failed() {
		Response rs = new Response(HttpStatus.BAD_REQUEST.value(), false, "Ha ocurrido un error, valide la informacion");
		return rs;
	}
}
