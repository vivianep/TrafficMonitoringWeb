package com.monitoring.objectify;

import java.util.*;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.annotation.*;

@Entity
public class ViaEntity {

	@Id private Long id; 
	private int id_via;
	private int qtdCarros;
	private String viaNome;
	private String situacaoVia;
	private Date date;
	


	public ViaEntity() {
		// TODO Auto-generated constructor stub
	}
	public ViaEntity(int id_via, int qtd,Date date){
	
		id=null;
		this.id_via=id_via;
		switch(id_via){
		case(1):
			viaNome="Salgado Filho";
		break;
		case(2):
			viaNome="Prudente de Morais";
		break;
		case(3):
			viaNome="Amintas Barros";
		break;
		case(4):
			viaNome="Hermes da Fonseca";
		break;
		case(5):
			viaNome="Av. Engenheiro Roberto Freire";
		break;
		case(6):
			viaNome="Av. Antônio Basílio";
		break;
		case(7):
			viaNome="Av. Bernardo Vieira";
		break;
		}
		if(qtd>30)
			situacaoVia="Congestionado";
		else
			situacaoVia="Livre";
			
		this.viaNome=viaNome;
		this.qtdCarros=qtd;
		this.date=date;

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


	public String getSituacaoVia() {
		return situacaoVia;
	}


	public void setSituacaoVia(String situacaoVia) {
		this.situacaoVia = situacaoVia;
	}

	public int getQtdCarros() {
		return qtdCarros;
	}
	public void setQtdCarros(int qtdCarros) {
		this.qtdCarros = qtdCarros;
	}
	public Date getDate() {
		return date;
	}
	





}
