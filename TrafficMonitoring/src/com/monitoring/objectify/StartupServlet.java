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
		return ofy().load().type(ViaEntity.class).order("date");
	}
	
	public Iterable<ViaEntity> loadViasporDia(String date){
		int ano=Integer.parseInt(date.substring(0, 4));
		int mes =Integer.parseInt(date.substring(5, 7));
		int dia =Integer.parseInt(date.substring(8, 10));
		return ofy().load().type(ViaEntity.class).filter("ano",ano).filter("mes",mes).filter("dia",dia);
	}
	
	public Iterable<ViaEntity> loadViasporMes(String date){
		int ano=Integer.parseInt(date.substring(0, 4));
		int mes =Integer.parseInt(date.substring(5, 7));
		
		return ofy().load().type(ViaEntity.class).filter("ano",ano).filter("mes",mes);
	}
	
	public void delete(Iterable<ViaEntity> iterable){
		Iterator<ViaEntity> iterator= iterable.iterator();
		ViaEntity v;
		while(iterator.hasNext()){
			v=iterator.next();
			ofy().delete().type(ViaEntity.class).id(v.getId());
		}
	}
	
	public Iterable<ViaEntity> loadPorId(int id){
	
		return ofy().load().type(ViaEntity.class).filter("id_via",id);
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
	
	public Iterable<ViaEntity> loadbySituacao(String situacao){
		return ofy().load().type(ViaEntity.class).filter("situacaoVia", situacao);
	}
	
	public Iterable<AcidenteEntity> loadbyAcidente(String acidenteString){
		return ofy().load().type(AcidenteEntity.class).filter("acidenteString", acidenteString);
	}
	
	
	public ArrayList<InfoSituacao> getEstSituacao(){
		Iterable<ViaEntity> iterable=this.loadbySituacao("Congestionado");
	
		ArrayList<InfoSituacao> info_situacao= new ArrayList<InfoSituacao>();
		info_situacao.add(new InfoSituacao());
		info_situacao.add(new InfoSituacao());
		info_situacao.add(new InfoSituacao());
		info_situacao.add(new InfoSituacao());
		info_situacao.add(new InfoSituacao());
		info_situacao.add(new InfoSituacao());
		info_situacao.add(new InfoSituacao());
		Iterator<ViaEntity> iterator= iterable.iterator();
		while(iterator.hasNext()){
			info_situacao.get((iterator.next()).getId_via()-1).num_congest++;
		}
		iterable=this.loadbySituacao("Livre");
		iterator= iterable.iterator();
		while(iterator.hasNext()){
			info_situacao.get((iterator.next()).getId_via()-1).num_livres++;
		}
		return info_situacao;
	}
	
	public ArrayList<Integer> getEstAcidente(){
		Iterable<AcidenteEntity> iterable=this.loadbyAcidente("Acidente Registrado");
		int id_via=0;
		ArrayList<Integer> info_acid= new ArrayList<Integer>();
		info_acid.add(0);
		info_acid.add(0);
		info_acid.add(0);
		info_acid.add(0);
		info_acid.add(0);
		info_acid.add(0);
		info_acid.add(0);
		Iterator<AcidenteEntity> iterator= iterable.iterator();
		while(iterator.hasNext()){
			id_via=iterator.next().getId_via();
			info_acid.add(id_via-1, info_acid.get(id_via-1)+1);
		}
		
		return info_acid;
	}
	


}