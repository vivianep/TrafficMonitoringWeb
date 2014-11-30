package com.monitoring.objectify;

import java.util.*;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.annotation.*;

@Entity
public class ViaEntity {

	@Id private Long id; 
	@Index private int id_via;
	private int qtdCarros;
	private String viaNome;
	@Index private String situacaoVia;
	@Index private Date date;
	@Index private int ano;
	@Index private int mes;
	@Index private int dia;
	@Ignore
	public static String[] nomes = new String[7];
	static{
	nomes[0]="Salgado Filho";
	nomes[1]="Prudente de Morais";
	nomes[2]="Amintas Barros";
	nomes[3]="Hermes da Fonseca";
	nomes[4]="Av. Engenheiro Roberto Freire";
	nomes[5]="Av. Antônio Basílio";
	nomes[6]="Av. Bernardo Vieira";
	}



	public ViaEntity() {
		// TODO Auto-generated constructor stub
	}
	public ViaEntity(int id_via, int qtd,Date date){

		id=null;
		this.id_via=id_via;
		if(qtd>30)
			situacaoVia="Congestionado";
		else
			situacaoVia="Livre";

		this.viaNome=ViaEntity.nomes[id_via-1];
		this.qtdCarros=qtd;
		this.date=date;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		this.ano= cal.get(Calendar.YEAR);
		this.mes=1+cal.get(Calendar.MONTH);
		this.dia=cal.get(Calendar.DAY_OF_MONTH);

	}


	public Long getId() {
		return id;
	}

	public int getId_via(){
		return id_via;
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
