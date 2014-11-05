package com.monitoring.objectify;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.annotation.*;

@Entity
public class ViaEntity {

	@Id private Long id; 
	@Index private int index;
	private int qtdCarros;
	private String viaNome;
	private String situacaoVia;
	private boolean acidente;


	public ViaEntity() {
		// TODO Auto-generated constructor stub
	}
	public ViaEntity(String viaNome, String situacaoVia, int qtd, int index){
		id=null;
		this.viaNome=viaNome;
		this.situacaoVia=situacaoVia;
		this.index=index;
		this.qtdCarros=qtd;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getViaNome() {
		return viaNome;
	}


	public void setViaNome(String viaNome) {
		this.viaNome = viaNome;
	}


	public String getSituacaoVia() {
		return situacaoVia;
	}


	public void setSituacaoVia(String situacaoVia) {
		this.situacaoVia = situacaoVia;
	}


	public boolean getAcidente() {
		return acidente;
	}


	public void setAcidente(boolean acidente) {
		this.acidente = acidente;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getQtdCarros() {
		return qtdCarros;
	}
	public void setQtdCarros(int qtdCarros) {
		this.qtdCarros = qtdCarros;
	}
	

	
	
}
