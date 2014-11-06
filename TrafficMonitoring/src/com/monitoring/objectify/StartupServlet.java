package com.monitoring.objectify;

import java.util.*;

import com.googlecode.objectify.*;

import static com.googlecode.objectify.ObjectifyService.ofy;
public class StartupServlet {

	static {
		ObjectifyService.register(ViaEntity.class);
		ObjectifyService.register(AcidenteEntity.class);
	}

	public Iterable<ViaEntity> loadVias(){
		return ofy().load().type(ViaEntity.class);
	}

	public void saveVias(List<ViaEntity> list_vias){
		ofy().save().entities(list_vias).now();
	}

	public void saveVia(ViaEntity via){
		ofy().save().entity(via).now();
	}

	public void saveAcidente(AcidenteEntity acidente){
		ofy().save().entity(acidente).now();
	}

	public Iterable<AcidenteEntity> loadAcidentes(){
		return ofy().load().type(AcidenteEntity.class);
	}


}
