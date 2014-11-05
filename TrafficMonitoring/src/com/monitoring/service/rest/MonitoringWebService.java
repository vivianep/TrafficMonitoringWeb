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
	@Path("{via}/{carros}/{situacao}/{acidente}")
	public void atualizarTeste(@PathParam("via") int id_via , @PathParam("carros") int carros , @PathParam("situacao") String situacao , @PathParam("acidente") boolean acidente) { 
		Date date= new Date();
		ViaEntity via = new ViaEntity(id_via, situacao, carros, acidente, date);
		s.saveVia(via);
	}

}