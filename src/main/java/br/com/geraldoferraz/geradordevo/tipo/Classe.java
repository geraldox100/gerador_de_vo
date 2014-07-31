package br.com.geraldoferraz.geradordevo.tipo;

import java.util.ArrayList;
import java.util.List;

import br.com.geraldoferraz.geradordevo.template.Template;

public class Classe {

	protected String nome;
	protected List<Atributo> atributos = new ArrayList<Atributo>();
	private String hierarquia;
	private String pacote;
	private Template template;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (!nome.endsWith("VO"))
			nome = nome + "VO";
		this.nome = nome;
	}

	public List<Atributo> getAtributos() {
		return new ArrayList<Atributo>(atributos);
	}

	public void adicionarAtributo(Atributo atributo) {
		this.atributos.add(atributo);

	}

	public void setTemplate(Template template){
		this.template = template;
		
	}
	public void definirHierarQuia(String hierarquia) {
		this.hierarquia = hierarquia;
	}

	public String getTextoDaClasse() {
		StringBuilder classBuilder = new StringBuilder(template.getClassTemplate());
		StringBuilder importBuilder = new StringBuilder();
		StringBuilder atributoBuilder = new StringBuilder();
		StringBuilder metodosBuilder = new StringBuilder();

		for (Atributo atributo : atributos) {
			String importt = atributo.getImport();
			if (importBuilder.indexOf(importt) < 0) {
				importBuilder.append(importt);
			}

			atributoBuilder.append(atributo.getDeclaracao());

			metodosBuilder.append(atributo.getGetter());
			metodosBuilder.append("\n\n");
			metodosBuilder.append(atributo.getSetter());
			metodosBuilder.append("\n\n");
		}
		String packagee = "";
		if(pacote != null){
			packagee = "package "+pacote+";\n\n";
		}
		String extendss = "";
		if(hierarquia != null){
			extendss = "extends "+removerPacoteDoNome(hierarquia);
			importBuilder.append(template.getImportTemplate().replace("#tipo#", hierarquia));
		}
		if (importBuilder.length() > 0) {
			importBuilder.append("\n");
		}
		String importt = importBuilder.toString();
		String atributos = atributoBuilder.toString();
		String metodos = metodosBuilder.toString();
		String clazz = classBuilder.toString();
		String nome = this.nome;
		int ponto = nome.lastIndexOf(".");
		if (ponto > 0) {
			nome = nome.substring(ponto + 1);
		}
		String retorno = clazz.replace("#package", packagee).replace("#import", importt).replace("#nome", nome).replace("#extends", extendss).replace("#atributos", atributos).replace("#metodos", metodos);
		return retorno;
	}
	
	protected String removerPacoteDoNome(String nomeClasse) {
		int ponto = nomeClasse.lastIndexOf(".");
		if (ponto > 0) {
			nomeClasse = nomeClasse.substring(ponto + 1);
		}
		return nomeClasse;
	}
	
	protected String removerNomeDoPacote(String nomeClasse) {
		String nomeSemPacote = removerPacoteDoNome(nomeClasse);
		
		return nomeClasse.replace("."+nomeSemPacote, "");
	}

	public void setPacote(String pacote) {
		this.pacote = pacote;
	}

	public String getExtesao() {
		return template.getExtensao();
	}

}
