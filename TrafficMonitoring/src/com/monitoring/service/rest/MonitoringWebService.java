package com.monitoring.service.rest;

import java.util.*;

import javax.servlet.http.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.*;

import org.codehaus.jackson.map.annotate.*;
import org.codehaus.jettison.json.*;

import com.sun.jersey.json.impl.provider.entity.*;
import com.monitoring.objectify.*;

@Path("/")

public class MonitoringWebService {

	StartupServlet s= new StartupServlet();
	
	@POST
	@Path("via/{via}/{carros}")
	public void atualizarVia(@PathParam("via") int id_via , @PathParam("carros") int carros ) { 
		Date date= new Date();
		ViaEntity via = new ViaEntity(id_via,carros,date);
		s.saveVia(via);
	}
	
	@POST
	@Path("acidente/{via}/{acidente}")
	public void atualizarAcidente(@PathParam ("via") int id_via,@PathParam ("acidente")boolean acidente){
		Date date= new Date();
		AcidenteEntity acidenteEnt=new AcidenteEntity(id_via, acidente, date);
		s.saveAcidente(acidenteEnt);
	}
	

	@POST
	@Path("post/{n_elements}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void insertBatch(JSONArray jarray,@PathParam ("n_elements") int n_elements ){
		Calendar calendar = new GregorianCalendar();
		calendar.setTimeZone( TimeZone.getTimeZone("Europe/Copenhagen"));
		Date date= calendar.getTime();
		org.codehaus.jettison.json.JSONObject json;
		ViaEntity viaEnt = null;
		List<ViaEntity> list_entities= new ArrayList<ViaEntity>();
		for (int i = 0; i < n_elements; i++) {
			
			try {
				json = (org.codehaus.jettison.json.JSONObject) jarray.get(i);
				viaEnt=new ViaEntity(json.getInt("via"), json.getInt("qtdCarros"), date);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			list_entities.add(viaEnt);
		}
		s.saveVias(list_entities);
	
		
	}

	
	@GET 
	@Path("get/xml")
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<Via> getXML(){
		
		ArrayList<Via> list_vias = new ArrayList<Via>();
		Iterable<ViaEntity> iterable = s.loadVias();
		Iterator<ViaEntity> iterator= iterable.iterator();
		ViaEntity viaEntity =null;
		Via v= null;
		while(iterator.hasNext()){
			v= new Via();
			viaEntity= iterator.next();
			v.setId_Via(viaEntity.getId_via());
			v.setViaNome(viaEntity.getViaNome());
			v.setDate(viaEntity.getDate());
			v.setQtdCarros(viaEntity.getQtdCarros());
			v.setSituacaoVia(viaEntity.getSituacaoVia());
			list_vias.add(v);
		}
		return list_vias;
	}
	
	@GET 
	@Path("get/json")
	@Produces(MediaType.APPLICATION_JSON +";charset=utf-8")
	public JSONArray getJSON(){
		
		JSONArray jArray = new JSONArray();
		Iterable<ViaEntity> iterable = s.loadVias();
		Iterator<ViaEntity> iterator= iterable.iterator();
		ViaEntity viaEntity =null;
		JSONObject v= null;
		while(iterator.hasNext()){
			v= new JSONObject();
			viaEntity= iterator.next();
			try {
				v.put("viaNome",viaEntity.getViaNome());
				v.put("qtdCarros",viaEntity.getQtdCarros());
				v.put("situacaoVia",viaEntity.getSituacaoVia());
				v.put("date", viaEntity.getDate());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			jArray.put(v);
		}
		return jArray;
	}

	@GET 
	@Path("get/vias/xml")
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<MapVia> getViasXML(){
		ArrayList<MapVia> list_vias = new ArrayList<MapVia>();
		for(int i=0;i<ViaEntity.nomes.length;i++){
			list_vias.add(new MapVia());
			list_vias.get(i).setId_Via(i+1);
			list_vias.get(i).setViaNome(ViaEntity.nomes[i]);
		}
		return list_vias;
	
	}
	
	
	@GET 
	@Path("get/vias/json")
	@Produces(MediaType.APPLICATION_JSON +";charset=utf-8")
	public JSONArray getViasJSON(){
		JSONArray jArray = new JSONArray();
		JSONObject v=null;
		for(int i=0;i<ViaEntity.nomes.length;i++){
			v= new JSONObject();
			try {
				v.put("viaNome",ViaEntity.nomes[i]);
				v.put("id_via",i+1);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jArray.put(v);
			
		}
		return jArray;
		
		
	}

	
	@GET 
	@Path("get/{id_via}/xml")
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<Via> getViasPorIdXML(@PathParam ("id_via") int id_via ){
		
		ArrayList<Via> list_vias = new ArrayList<Via>();
		Iterable<ViaEntity> iterable = s.loadPorId(id_via);
		Iterator<ViaEntity> iterator= iterable.iterator();
		ViaEntity viaEntity =null;
		Via v= null;
		while(iterator.hasNext()){
			v= new Via();
			viaEntity= iterator.next();
			v.setId_Via(viaEntity.getId_via());
			v.setViaNome(viaEntity.getViaNome());
			v.setDate(viaEntity.getDate());
			v.setQtdCarros(viaEntity.getQtdCarros());
			v.setSituacaoVia(viaEntity.getSituacaoVia());
			list_vias.add(v);
		}
		return list_vias;
	}

	@GET 
	@Path("get/{id_via}/json")
	@Produces(MediaType.APPLICATION_JSON +";charset=utf-8")
	public JSONArray getViasPorIdJSON(@PathParam ("id_via") int id_via ){
		

		JSONArray jArray = new JSONArray();
		Iterable<ViaEntity> iterable = s.loadPorId(id_via);
		Iterator<ViaEntity> iterator= iterable.iterator();
		ViaEntity viaEntity =null;
		JSONObject v= null;
		while(iterator.hasNext()){
			v= new JSONObject();
			viaEntity= iterator.next();
			try {
				v.put("viaNome",viaEntity.getViaNome());
				v.put("qtdCarros",viaEntity.getQtdCarros());
				v.put("situacaoVia",viaEntity.getSituacaoVia());
				v.put("date", viaEntity.getDate());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			jArray.put(v);
		}
		return jArray;
	
	}

		
	@GET 
	@Path("get/dia/{date}/xml")
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<Via> getPorDia(@PathParam ("date") String date){
		
		ArrayList<Via> list_vias = new ArrayList<Via>();
		Iterable<ViaEntity> iterable = s.loadViasporDia(date);
		Iterator<ViaEntity> iterator= iterable.iterator();
		ViaEntity viaEntity =null;
		Via v= null;
		while(iterator.hasNext()){
			v= new Via();
			viaEntity= iterator.next();
			v.setId_Via(viaEntity.getId_via());
			v.setViaNome(viaEntity.getViaNome());
			v.setDate(viaEntity.getDate());
			v.setQtdCarros(viaEntity.getQtdCarros());
			v.setSituacaoVia(viaEntity.getSituacaoVia());
			list_vias.add(v);
		}
		return list_vias;
	}
	
	@GET 
	@Path("get/dia/{date}/json")
	@Produces(MediaType.APPLICATION_JSON +";charset=utf-8")
	public JSONArray getPorDiaJSON(@PathParam ("date") String date){
		
		JSONArray jArray = new JSONArray();
		Iterable<ViaEntity> iterable = s.loadViasporDia(date);
		Iterator<ViaEntity> iterator= iterable.iterator();
		ViaEntity viaEntity =null;
		JSONObject v= null;
		while(iterator.hasNext()){
			v= new JSONObject();
			viaEntity= iterator.next();
			try {
				v.put("viaNome",viaEntity.getViaNome());
				v.put("qtdCarros",viaEntity.getQtdCarros());
				v.put("situacaoVia",viaEntity.getSituacaoVia());
				v.put("date", viaEntity.getDate());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			jArray.put(v);
		}
		return jArray;

	}
		
				
	@Path("delete/dia/{date}")
	@DELETE
	@Produces("text/plain")
	public String deletePorDia(@PathParam("date") String date){
		s.delete(s.loadViasporDia(date));
		return "Informações removidas com sucesso";
	}
	
	@Path("delete/mes/{date}")
	@DELETE
	@Produces("text/plain")
	public String deletePorMes(@PathParam("date") String date){
		s.delete(s.loadViasporMes(date));
		return "Informações removidas com sucesso";
	}
	
	@Path("delete/via/{id_via}")
	@DELETE
	@Produces("text/plain")
	public String deletePorMes(@PathParam("id_via") int id_via){
		s.delete(s.loadPorId(id_via));
		return "Informações removidas com sucesso";
	}
	
}