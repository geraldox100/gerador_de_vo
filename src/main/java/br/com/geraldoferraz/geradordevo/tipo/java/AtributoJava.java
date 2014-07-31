package br.com.geraldoferraz.geradordevo.tipo.java;

import br.com.geraldoferraz.geradordevo.template.JavaTemplates;
import br.com.geraldoferraz.geradordevo.tipo.Atributo;

public class AtributoJava extends Atributo {

	private JavaTemplates templates = new JavaTemplates();

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
		return texto.replace("#tipo#", getTipoResolvido()).replace("#NomeCamelCase#", getNomeCamelCase()).replace("#nome#", nome);
	}

	private String getTipoResolvido() {
		String vo = resolverSeTemQueColocarVO();
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

	private String resolverSeTemQueColocarVO() {
		String vo = "";
		if (!(forData() || forJavaLang() || forPrimitivo() || forJavaMath())) {
			vo = "VO";
		}
		return vo;
	}

	private boolean forPrimitivo() {
		return tipo.equals("boolean") || tipo.equals("byte") || tipo.equals("char") || tipo.equals("short") || tipo.equals("int") || tipo.equals("long") || tipo.equals("float")
				|| tipo.equals("double");
	}

	private boolean forJavaLang() {
		return this.tipo.startsWith("java.lang.");
	}

	private boolean forJavaMath() {
		return this.tipo.startsWith("java.math.");
	}

	private boolean forData() {
		return this.tipo.equals("java.util.Calendar") || this.tipo.equals("java.util.Date") || this.tipo.equals("java.sql.Date") || this.tipo.endsWith("DateTime")
				|| this.tipo.endsWith("DateTimeDB");
	}

	@Override
	public String getImport() {
		String retorno = "";
		if (!forPrimitivo()) {
			String vo = resolverSeTemQueColocarVO();
			if (tipo.contains("<") && tipo.contains(">")) {
				int menor = tipo.indexOf("<");
				int maior = tipo.indexOf(">");

				String retorno1 = tipo.substring(0, menor);
				String retorno2 = tipo.substring(menor + 1, maior);

				retorno = templates.getImportTemplate().replace("#tipo#", retorno1);
				
				if(getPacote() != null && !getPacote().equals("")){
					String nome = removerPacoteDoNome(retorno2);
					retorno += templates.getImportTemplate().replace("#tipo#", getPacote() + "." + nome + vo);
				}else{
					retorno += templates.getImportTemplate().replace("#tipo#", retorno2 + vo);
				}

			} else if (vo != null && !vo.equals("")) {
				if (getPacote() != null && !getPacote().equals("")) {
					String nome = removerPacoteDoNome(this.tipo);
					retorno = templates.getImportTemplate().replace("#tipo#", getPacote() + "." + nome + vo);
				}else{
					retorno = templates.getImportTemplate().replace("#tipo#", tipo + vo);
				}
			} else if (!(tipo.startsWith("java.lang.") || tipo.startsWith("java.math."))) {
				retorno = templates.getImportTemplate().replace("#tipo#", tipo + vo);
			}
		}
		return retorno;
	}

}
