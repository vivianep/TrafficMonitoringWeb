package com.monitoring.objectify;

import java.util.*;

import com.googlecode.objectify.*;

import static com.googlecode.objectify.ObjectifyService.ofy;
public class StartupServlet {

	static {
        ObjectifyService.register(ViaEntity.class);
    }
	
	public Iterable<ViaEntity> loadVias(){
	
		Iterable<ViaEntity> vias =ofy().load().type(ViaEntity.class).filter("index", 1);
		return vias;
	}
	
	public void saveVias(List<ViaEntity> list_vias){
		ofy().save().entities(list_vias).now();
	}

}
