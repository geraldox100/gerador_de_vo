package br.com.geraldoferraz.geradordevo.tipo;

import java.util.ArrayList;
import java.util.List;

public abstract class Classe {

	protected String nome;
	protected List<Atributo> atributos = new ArrayList<Atributo>();
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(!nome.endsWith("VO"))
			nome = nome+"VO";
		this.nome = nome;
	}

	public List<Atributo> getAtributos() {
		return new ArrayList<Atributo>(atributos);
	}

	public void adicionarAtributo(Atributo atributo) {
		this.atributos.add(atributo);

	}

	public abstract String getTextoDaClasse();

}
