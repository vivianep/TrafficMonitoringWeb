package com.monitoring.service;

import java.io.IOException;
import java.util.*;

import javax.servlet.http.*;

import com.monitoring.objectify.*;

@SuppressWarnings("serial")
public class TrafficMonitoringServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		/*ViaEntity via1= new ViaEntity("Salgado Filho", "Congestionada",10,1);
		ViaEntity via2= new ViaEntity("Prudente de Morais", "Livre", 20,1);
		ViaEntity via3= new ViaEntity("Alexandrino", "Congestionada",40,1);
		ViaEntity via4= new ViaEntity("Salgdo Filho", "Congestionada",30,2);
		ViaEntity via5= new ViaEntity("Prudete de Morais", "Livre",10,2);
		ViaEntity via6= new ViaEntity("Alexanrino", "Congestionada",10,2);
		List<ViaEntity> list_via=new ArrayList<ViaEntity>();
		list_via.add(via1);
		list_via.add(via2);
		list_via.add(via3);
		list_via.add(via4);
		list_via.add(via5);
		list_via.add(via6);
		resp.setContentType("text/plain");
		*/
		//Iterable<ViaEntity> iterator= s.load(list_via);
		//Iterator<ViaEntity> iter=iterator.iterator();
		//while(iter.hasNext()){
		//	ViaEntity via=iter.next();
		//	resp.getWriter().println("Id : "+ via.getId()+"Nome: "+via.getViaNome());
		//}
	}
	
	StartupServlet s= new StartupServlet();
	
}
