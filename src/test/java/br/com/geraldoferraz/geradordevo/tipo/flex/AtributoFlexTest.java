package br.com.geraldoferraz.geradordevo.tipo.flex;



import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.geraldoferraz.geradordevo.tipo.Atributo;


public class AtributoFlexTest {

	private Atributo atributo;

	@Before
	public void beforeAtributoVO() {
		paraAtributoString("login", "java.lang.String");
	}

	private void paraAtributoString(String nome, String tipo) {
		atributo = new AtributoFlex();
		atributo.setNome(nome);
		atributo.setTipo(tipo);
	}

	@Test
	public void quandoPerguntarNome() {
		assertThat(atributo.getNome(), equalTo("login"));
	}

	@Test
	public void quandoPerguntarTipo() {
		assertThat(atributo.getTipo(), equalTo("java.lang.String"));
	}

	@Test
	public void quandoPedirTextoDoGet() {
		String getter = atributo.getGetter();

		String realGetter = "\tpublic function get login(): String{ \n\t\treturn _login;\n\t}";
		assertThat(getter, equalTo(realGetter));
	}
	
	@Test
	public void quandoPedirTextoDoGetParaTipoCalendar() {
		paraAtributoString("data", "java.util.Calendar");
		String getter = atributo.getGetter();

		String realGetter = "\tpublic function get data(): Date{ \n\t\treturn _data;\n\t}";
		assertThat(getter, equalTo(realGetter));
	}
	
	@Test
	public void quandoPedirTextoDoGetParaTipoDate() {
		paraAtributoString("data", "java.util.Date");
		String getter = atributo.getGetter();

		String realGetter = "\tpublic function get data(): Date{ \n\t\treturn _data;\n\t}";
		assertThat(getter, equalTo(realGetter));
	}
	
	@Test
	public void quandoPedirTextoDoGetParaTipoDateTime() {
		paraAtributoString("data", "br.com.sicoob.tipos.DateTime");
		String getter = atributo.getGetter();

		String realGetter = "\tpublic function get data(): Date{ \n\t\treturn _data;\n\t}";
		assertThat(getter, equalTo(realGetter));
	}
	
	
	@Test
	public void quandoPedirTextoDoGetDeUmaLista() {
		Atributo atributo = new AtributoFlex();
		atributo.setNome("login");
		atributo.setTipo("java.util.List<Permissao>");
		String getter = atributo.getGetter();

		String realGetter = "\tpublic function get login(): ListCollectionView{ \n\t\treturn _login;\n\t}";
		assertThat(getter, equalTo(realGetter));
	}
	
	@Test
	public void quandoPedirTextoDoSet() {
		String setter = atributo.getSetter();

		String realGetter = "\tpublic function set login(valor: String) : void {\n\t\t_login = valor;\n\t}";
		assertThat(setter, equalTo(realGetter));
	}
	
	@Test
	public void quandoPedirTextoDoSetDeUmTipoCalendar() {
		paraAtributoString("data", "java.util.Calendar");
		String setter = atributo.getSetter();

		String realGetter = "\tpublic function set data(valor: Date) : void {\n\t\t_data = valor;\n\t}";
		assertThat(setter, equalTo(realGetter));
	}
	
	@Test
	public void quandoPedirTextoDoSetDeUmTipoDate() {
		paraAtributoString("data", "java.util.Date");
		String setter = atributo.getSetter();

		String realGetter = "\tpublic function set data(valor: Date) : void {\n\t\t_data = valor;\n\t}";
		assertThat(setter, equalTo(realGetter));
	}
	
	@Test
	public void quandoPedirTextoDoSetDeUmTipoDateTime() {
		paraAtributoString("data", "br.com.sicoob.tipos.DateTime");
		String setter = atributo.getSetter();

		String realGetter = "\tpublic function set data(valor: Date) : void {\n\t\t_data = valor;\n\t}";
		assertThat(setter, equalTo(realGetter));
	}
	
	@Test
	public void quandoPedirTextoDoSetDeUmaLista() {
		Atributo atributo = new AtributoFlex();
		atributo.setNome("login");
		atributo.setTipo("java.util.List<Permissao>");
		String setter = atributo.getSetter();

		String realSetter = "\tpublic function set login(valor: ListCollectionView) : void {\n\t\t_login = valor;\n\t}";
		assertThat(setter, equalTo(realSetter));
	}
	


	@Test
	public void quandoPedirTextoDeclaracao() {
		String declaracao = atributo.getDeclaracao();
		assertThat(declaracao, equalTo("\tprivate var _login : String;\n"));
	}
	
	@Test
	public void quandoPedirTextoDeclaracaoParaTipoComplexo() {
		Atributo atributo = new AtributoFlex();
		atributo.setNome("permissao");
		atributo.setTipo("br.com.entidade.Permissao");
		String declaracao = atributo.getDeclaracao();
		assertThat(declaracao, equalTo("\tprivate var _permissao : PermissaoVO;\n"));
	}
	
	@Test
	public void quandoPerguntarTipoEForInteger() {
		paraAtributoString("login", "Integer");
		assertThat(atributo.getTipo(), equalTo("Integer"));
	}

	@Test
	public void quandoPedirTextoDoGetDeUmTipoInteger() {
		paraAtributoString("login", "java.lang.Integer");
		String getter = atributo.getGetter();

		String realGetter = "\tpublic function get login(): Number{ \n\t\treturn _login;\n\t}";
		assertThat(getter, equalTo(realGetter));
	}

	@Test
	public void quandoPedirTextoDoSetDeUmTipoInteger() {
		paraAtributoString("login", "java.lang.Integer");
		String setter = atributo.getSetter();

		String realGetter = "\tpublic function set login(valor: Number) : void {\n\t\t_login = valor;\n\t}";
		assertThat(setter, equalTo(realGetter));
	}

	@Test
	public void quandoPedirTextoDeclaracaoDeUmTipoInteger() {
		paraAtributoString("login", "java.lang.Integer");
		String declaracao = atributo.getDeclaracao();
		assertThat(declaracao, equalTo("\tprivate var _login : Number;\n"));
	}
	
	@Test
	public void quandoPedirTextoImportDeUmTipoPermissao() {
		paraAtributoString("permissao", "br.com.geraldoferraz.entidade.Permissao");
		String importt = atributo.getImport();
		assertThat(importt, equalTo("import br.com.geraldoferraz.entidade.PermissaoVO;\n"));
	}
	
	@Test
	public void quandoPedirTextoImportDeUmTipoGenerico() {
		paraAtributoString("permissoes", "java.util.List<Permissao>");
		String importt = atributo.getImport();
		assertThat(importt, equalTo("import mx.collections.ListCollectionView;\n"));
	}
	
	@Test
	public void quandoPedirTextoImportDeUmTipoCalendar() {
		paraAtributoString("data", "java.util.Calendar");
		String importt = atributo.getImport();
		assertThat(importt, equalTo(""));
	}
	
	@Test
	public void quandoPedirTextoImportDeUmTipoDate() {
		paraAtributoString("data", "java.util.Date");
		String importt = atributo.getImport();
		assertThat(importt, equalTo(""));
	}
	
	@Test
	public void quandoPedirTextoImportDeUmTipoDateTime() {
		paraAtributoString("data", "br.com.sicoob.tipos.DateTime");
		String importt = atributo.getImport();
		assertThat(importt, equalTo(""));
	}
	
	

}
