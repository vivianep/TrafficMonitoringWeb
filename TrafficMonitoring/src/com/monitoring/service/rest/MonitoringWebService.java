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

@Path("/monitor")
public class MonitoringWebService {

	StartupServlet s= new StartupServlet();
	@GET
	@Produces("text/plain")
	@Path("/teste/{via}/{carros}")
	public String atualizarTeste(@PathParam("via") int via, @PathParam("carros") int carros) { 
		//HttpServletRequest req = null;
		//Long date=req.getDateHeader("http://trafficmonitoring-lv.appspot.com/rest/monitor/teste/"+Integer.toString(via)+"/" +carros);
		return "Via "+via+"--"+carros+"Timestamp:";//date;
	}

}