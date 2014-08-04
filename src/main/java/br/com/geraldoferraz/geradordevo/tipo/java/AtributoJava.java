package br.com.geraldoferraz.geradordevo.tipo.java;


import br.com.geraldoferraz.geradordevo.template.JavaVOTemplates;
import br.com.geraldoferraz.geradordevo.tipo.Atributo;
import static br.com.geraldoferraz.geradordevo.util.Util.*;

public class AtributoJava extends Atributo {

	private JavaVOTemplates templates = new JavaVOTemplates();

	@Override
	public String getGetter() {
		return substituirVariaveis(templates.getGetterTemplate());
	}

	@Override
	public String getSetter() {
		return substituirVariaveis(templates.getSetterTemplate());
	}

	@Override
	public String getDeclaracao() {
		return substituirVariaveis(templates.getDeclaracaoTemplate());
	}

	private String substituirVariaveis(String texto) {
		return texto.replace("#tipo", getTipoResolvido()).replace("#NomeCamelCase#", getNomeDeClasseComVO(nome)).replace("#nome#", nome);
	}

	private String getTipoResolvido() {
		String vo = colocarSeForVO(tipo);
		String tipo = this.tipo.replace("java.lang.", "");
		int ponto = tipo.lastIndexOf(".");
		int menor = tipo.lastIndexOf("<");
		int maior = tipo.lastIndexOf(">");
		if (menor > 0) {
			ponto = tipo.substring(0, menor).lastIndexOf(".");
			String tipo2 = tipo.substring(menor + 1, maior);
			int pontoTipo2 = tipo2.lastIndexOf(".");
			if (pontoTipo2 > 0)
				tipo2 = tipo2.substring(pontoTipo2 + 1);
			tipo = tipo.substring(ponto + 1, menor);
			tipo = tipo + "<" + tipo2 + vo + ">";
			ponto = -1;
		}
		if (ponto > 0) {
			tipo = tipo.substring(ponto + 1) + vo;
		}
		return tipo;
	}

	@Override
	public String getImport() {
		String retorno = "";
		if (!forPrimitivo(tipo)) {
			String vo = colocarSeForVO(tipo);
			if (tipo.contains("<") && tipo.contains(">")) {
				int menor = tipo.indexOf("<");
				int maior = tipo.indexOf(">");

				String retorno1 = tipo.substring(0, menor);
				String retorno2 = tipo.substring(menor + 1, maior);

				retorno = templates.getImportTemplate().replace("#tipo", retorno1);
				
				if(getPacote() != null && !getPacote().equals("")){
					String nome = removerPacoteDoNome(retorno2);
					retorno += templates.getImportTemplate().replace("#tipo", getPacote() + "." + nome + vo);
				}else{
					retorno += templates.getImportTemplate().replace("#tipo", retorno2 + vo);
				}

			} else if (vo != null && !vo.equals("")) {
				if (getPacote() != null && !getPacote().equals("")) {
					String nome = removerPacoteDoNome(this.tipo);
					retorno = templates.getImportTemplate().replace("#tipo", getPacote() + "." + nome + vo);
				}else{
					retorno = templates.getImportTemplate().replace("#tipo", tipo + vo);
				}
			} else if (!(tipo.startsWith("java.lang.") || tipo.startsWith("java.math."))) {
				retorno = templates.getImportTemplate().replace("#tipo", tipo + vo);
			}
		}
		return retorno;
	}

}
