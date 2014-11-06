package com.monitoring.service.rest;

import java.util.*;

import javax.servlet.http.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.monitoring.objectify.*;

@Path("/")
public class MonitoringWebService {

	StartupServlet s= new StartupServlet();
	
	@GET
	@Path("via/{via}/{carros}")
	public void atualizarVia(@PathParam("via") int id_via , @PathParam("carros") int carros ) { 
		Date date= new Date();
		ViaEntity via = new ViaEntity(id_via,carros,date);
		s.saveVia(via);
	}
	
	@GET
	@Path("acidente/{via}/{acidente}")
	public void atualizarAcidente(@PathParam ("via") int id_via,@PathParam ("acidente")boolean acidente){
		Date date= new Date();
		AcidenteEntity acidenteEnt=new AcidenteEntity(id_via, acidente, date);
		s.saveAcidente(acidenteEnt);
	}

}