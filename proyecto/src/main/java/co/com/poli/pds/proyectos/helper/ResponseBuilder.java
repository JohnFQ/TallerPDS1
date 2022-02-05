package co.com.poli.pds.proyectos.helper;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import co.com.poli.pds.proyectos.model.*;
import static org.springframework.http.HttpStatus.*;
import org.springframework.stereotype.Component;

import co.com.poli.pds.proyectos.model.Response;

@Component
public class ResponseBuilder {

    public Response success(){
        return Response.builder()
                .code(OK.value())
                .status(true)
                .message("Proceso realizado con exito")
                .data(OK.value())
                .build();
    }
    public Response success(Object data){
        return Response.builder()
        		.code(OK.value())
                .status(true)
                .message("Proceso realizado con exito")
                .data(data)
                .build();
    }
    public Response failed(Object data){
        return Response.builder()
                .code(BAD_REQUEST.value())
                .status(false)
                .message("Error al realizar el proceso")
                .data(data)
                .build();
    }

}