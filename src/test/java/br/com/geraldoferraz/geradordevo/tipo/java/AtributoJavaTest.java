package br.com.geraldoferraz.geradordevo.tipo.java;



import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.geraldoferraz.geradordevo.tipo.Atributo;


public class AtributoJavaTest {

	private Atributo atributo;

	@Before
	public void beforeAtributoVO() {
		paraAtributoString("login", "String");
	}

	private void paraAtributoString(String nome, String tipo) {
		atributo = new AtributoJava();
		atributo.setNome(nome);
		atributo.setTipo(tipo);
	}

	@Test
	public void quandoPerguntarNome() {
		assertThat(atributo.getNome(), equalTo("login"));
	}

	@Test
	public void quandoPerguntarTipo() {
		assertThat(atributo.getTipo(), equalTo("String"));
	}

	@Test
	public void quandoPedirTextoDoGet() {
		String getter = atributo.getGetter();

		String realGetter = "\tpublic String getLogin(){\n\t\treturn this.login;\n\t}";
		assertThat(getter, equalTo(realGetter));
	}
	
	@Test
	public void quandoPedirTextoDoGetDeUmTipoCalendar() {
		paraAtributoString("data", "java.util.Calendar");
		String getter = atributo.getGetter();

		String realGetter = "\tpublic Calendar getData(){\n\t\treturn this.data;\n\t}";
		assertThat(getter, equalTo(realGetter));
	}
	
	@Test
	public void quandoPedirTextoDoGetDeUmTipoDate() {
		paraAtributoString("data", "java.util.Date");
		String getter = atributo.getGetter();

		String realGetter = "\tpublic Date getData(){\n\t\treturn this.data;\n\t}";
		assertThat(getter, equalTo(realGetter));
	}
	
	@Test
	public void quandoPedirTextoDoGetParaTipoGenerico() {
		Atributo atributo = new AtributoJava();
		atributo.setNome("permissoes");
		atributo.setTipo("java.util.List<br.com.entidades.Permissao>");
		String getter = atributo.getGetter();

		String realGetter = "\tpublic List<PermissaoVO> getPermissoes(){\n\t\treturn this.permissoes;\n\t}";
		assertThat(getter, equalTo(realGetter));
	}

	@Test
	public void quandoPedirTextoDoSet() {
		String setter = atributo.getSetter();

		String realGetter = "\tpublic void setLogin(String login){\n\t\tthis.login = login;\n\t}";
		assertThat(setter, equalTo(realGetter));
	}
	
	@Test
	public void quandoPedirTextoDoSetParaUmTipoCalendar() {
		paraAtributoString("data", "java.util.Calendar");
		String setter = atributo.getSetter();

		String realGetter = "\tpublic void setData(Calendar data){\n\t\tthis.data = data;\n\t}";
		assertThat(setter, equalTo(realGetter));
	}
	
	@Test
	public void quandoPedirTextoDoSetParaUmTipoDate() {
		paraAtributoString("data", "java.util.Date");
		String setter = atributo.getSetter();

		String realGetter = "\tpublic void setData(Date data){\n\t\tthis.data = data;\n\t}";
		assertThat(setter, equalTo(realGetter));
	}
	
	@Test
	public void quandoPedirTextoDoSetParaTipoGenerico() {
		Atributo atributo = new AtributoJava();
		atributo.setNome("permissoes");
		atributo.setTipo("java.util.List<br.com.entidades.Permissao>");
		String setter = atributo.getSetter();

		String realGetter = "\tpublic void setPermissoes(List<PermissaoVO> permissoes){\n\t\tthis.permissoes = permissoes;\n\t}";
		assertThat(setter, equalTo(realGetter));
	}

	@Test
	public void quandoPedirTextoDeclaracao() {
		String declaracao = atributo.getDeclaracao();
		assertThat(declaracao, equalTo("\tprivate String login;\n"));
	}
	
	@Test
	public void quandoPedirTextoDeclaracaoParaTipoComplexo() {
		Atributo atributo = new AtributoJava();
		atributo.setNome("permissao");
		atributo.setTipo("br.com.entidade.Permissao");
		String declaracao = atributo.getDeclaracao();
		assertThat(declaracao, equalTo("\tprivate PermissaoVO permissao;\n"));
	}
	
	@Test
	public void quandoPedirTextoDeclaracaoParaTipoGenerico() {
		Atributo atributo = new AtributoJava();
		atributo.setNome("permissoes");
		atributo.setTipo("java.util.List<Permissao>");
		String declaracao = atributo.getDeclaracao();
		assertThat(declaracao, equalTo("\tprivate List<PermissaoVO> permissoes;\n"));
	}

	@Test
	public void quandoPerguntarTipoEForInteger() {
		paraAtributoString("login", "Integer");
		assertThat(atributo.getTipo(), equalTo("Integer"));
	}

	@Test
	public void quandoPedirTextoDoGetDeUmTipoInteger() {
		paraAtributoString("login", "Integer");
		String getter = atributo.getGetter();

		String realGetter = "\tpublic Integer getLogin(){\n\t\treturn this.login;\n\t}";
		assertThat(getter, equalTo(realGetter));
	}

	@Test
	public void quandoPedirTextoDoSetDeUmTipoInteger() {
		paraAtributoString("login", "Integer");
		String setter = atributo.getSetter();

		String realGetter = "\tpublic void setLogin(Integer login){\n\t\tthis.login = login;\n\t}";
		assertThat(setter, equalTo(realGetter));
	}

	@Test
	public void quandoPedirTextoDeclaracaoDeUmTipoInteger() {
		paraAtributoString("login", "Integer");
		String declaracao = atributo.getDeclaracao();
		assertThat(declaracao, equalTo("\tprivate Integer login;\n"));
	}
	
	@Test
	public void quandoPedirTextoDoImportDeUmTipoPermissao() {
		paraAtributoString("permissao", "br.com.geraldoferraz.entidade.Permissao");
		String importt = atributo.getImport();
		assertThat(importt, equalTo("import br.com.geraldoferraz.entidade.PermissaoVO;\n"));
	}
	
	@Test
	public void quandoPedirTextoDoImportDeUmTipoGenerico() {
		paraAtributoString("permissoes", "java.util.List<Permissao>");
		String importt = atributo.getImport();
		assertThat(importt, equalTo("import java.util.List;\nimport PermissaoVO;\n"));
	}
	
	@Test
	public void quandoPedirTextoDoImportDeUmCalendar() {
		paraAtributoString("data", "java.util.Calendar");
		String importt = atributo.getImport();
		assertThat(importt, equalTo("import java.util.Calendar;\n"));
	}
	
	@Test
	public void quandoPedirTextoDoImportDeUmDate() {
		paraAtributoString("data", "java.util.Date");
		String importt = atributo.getImport();
		assertThat(importt, equalTo("import java.util.Date;\n"));
	}
	
	

}
