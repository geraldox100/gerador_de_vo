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
	public void quandoPedirTextoDoGetDeUmTipoPrimitivo() {
		paraAtributoString("numero", "int");
		String intt = atributo.getGetter();
		
		paraAtributoString("numero", "long");
		String longg = atributo.getGetter();
		
		paraAtributoString("numero", "double");
		String doublee = atributo.getGetter();
		
		paraAtributoString("numero", "byte");
		String bytee = atributo.getGetter();
		
		paraAtributoString("numero", "short");
		String shortt = atributo.getGetter();
		
		paraAtributoString("numero", "float");
		String floatt = atributo.getGetter();
		
		String realGetter = "\tpublic function get numero(): Number{ \n\t\treturn _numero;\n\t}";

		assertThat(intt, equalTo(realGetter));
		assertThat(longg, equalTo(realGetter));
		assertThat(doublee, equalTo(realGetter));
		assertThat(bytee, equalTo(realGetter));
		assertThat(shortt, equalTo(realGetter));
		assertThat(floatt, equalTo(realGetter));
	}
	
	@Test
	public void quandoPedirTextoDoGetDeUmTipoCharOuString(){
		paraAtributoString("numero", "char");
		String charr = atributo.getGetter();
		
		paraAtributoString("numero", "java.lang.String");
		String string = atributo.getGetter();
		
		String realGetter = "\tpublic function get numero(): String{ \n\t\treturn _numero;\n\t}";
		
		assertThat(charr, equalTo(realGetter));
		assertThat(string, equalTo(realGetter));
	}
	
	@Test
	public void quandoPedirTetoDoGetDeUmTipoBoolean(){
		paraAtributoString("numero", "boolean");
		String booleann = atributo.getGetter();
		
		String realGetter = "\tpublic function get numero(): Boolean{ \n\t\treturn _numero;\n\t}";
		
		assertThat(booleann, equalTo(realGetter));
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
	public void quandoPedirTextoDoGetParaTipoDateTimeDB() {
		paraAtributoString("data", "br.com.bancoob.persistencia.types.DateTimeDB");
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
	public void quandoPedirTextoDoSetDeUmTipoPrimitivo() {
		paraAtributoString("numero", "int");
		String intt = atributo.getSetter();
		
		paraAtributoString("numero", "long");
		String longg = atributo.getSetter();
		
		paraAtributoString("numero", "double");
		String doublee = atributo.getSetter();
		
		paraAtributoString("numero", "byte");
		String bytee = atributo.getSetter();
		
		paraAtributoString("numero", "short");
		String shortt = atributo.getSetter();
		
		paraAtributoString("numero", "float");
		String floatt = atributo.getSetter();
		
		String realSetter = "\tpublic function set numero(valor: Number) : void {\n\t\t_numero = valor;\n\t}";

		assertThat(intt, equalTo(realSetter));
		assertThat(longg, equalTo(realSetter));
		assertThat(doublee, equalTo(realSetter));
		assertThat(bytee, equalTo(realSetter));
		
		assertThat(shortt, equalTo(realSetter));
		assertThat(floatt, equalTo(realSetter));
		
	}
	
	@Test
	public void quandoPedirTextoDoSetDeUmTipoCharOuCharacter(){
		paraAtributoString("numero", "char");
		String charr = atributo.getSetter();
		
		paraAtributoString("numero", "java.lang.Character");
		String character = atributo.getSetter();
		
		String realSetter = "\tpublic function set numero(valor: String) : void {\n\t\t_numero = valor;\n\t}";
		assertThat(charr, equalTo(realSetter));
		assertThat(character, equalTo(realSetter));
	}
	
	@Test
	public void quandoPedirTextoDoSetDeUmTipoBoolean(){
		paraAtributoString("numero", "boolean");
		String booleann = atributo.getSetter();
		
		paraAtributoString("numero", "java.lang.Boolean");
		String wrapper = atributo.getSetter();
		
		String realSetter = "\tpublic function set numero(valor: Boolean) : void {\n\t\t_numero = valor;\n\t}";
		assertThat(booleann, equalTo(realSetter));
		assertThat(wrapper, equalTo(realSetter));
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
	
	@Test
	public void quandoPedirTextoImportDeUmTipoWrapper() {
		paraAtributoString("data", "java.lang.Boolean");
		String wrapperBoolean = atributo.getImport();
		
		paraAtributoString("data", "java.lang.Byte");
		String wrapperByte = atributo.getImport();
		
		paraAtributoString("data", "java.lang.Character");
		String wrapperCharacter = atributo.getImport();
		
		paraAtributoString("data", "java.lang.Short");
		String wrapperShort = atributo.getImport();
		
		paraAtributoString("data", "java.lang.Integer");
		String wrapperInteger = atributo.getImport();
		
		paraAtributoString("data", "java.lang.Long");
		String wrapperLong = atributo.getImport();
		
		paraAtributoString("data", "java.lang.Float");
		String wrapperFloat = atributo.getImport();
		
		paraAtributoString("data", "java.lang.Double");
		String wrapperDouble = atributo.getImport();
		
		assertThat(wrapperBoolean, equalTo(""));
		assertThat(wrapperByte, equalTo(""));
		assertThat(wrapperCharacter, equalTo(""));
		assertThat(wrapperShort, equalTo(""));
		assertThat(wrapperInteger, equalTo(""));
		assertThat(wrapperLong, equalTo(""));
		assertThat(wrapperFloat, equalTo(""));
		assertThat(wrapperDouble, equalTo(""));
	}
	
	@Test
	public void quandoPedirTextoImportDeUmTipoPrimitivo() {
		paraAtributoString("data", "boolean");
		String booleann = atributo.getImport();
		
		paraAtributoString("data", "byte");
		String bytee = atributo.getImport();
		
		paraAtributoString("data", "char");
		String charr = atributo.getImport();
		
		paraAtributoString("data", "short");
		String shortt = atributo.getImport();
		
		paraAtributoString("data", "int");
		String intt = atributo.getImport();
		
		paraAtributoString("data", "long");
		String longg = atributo.getImport();
		
		paraAtributoString("data", "float");
		String floatt = atributo.getImport();
		
		paraAtributoString("data", "double");
		String Double = atributo.getImport();
		
		assertThat(booleann, equalTo(""));
		assertThat(bytee, equalTo(""));
		assertThat(charr, equalTo(""));
		assertThat(shortt, equalTo(""));
		assertThat(intt, equalTo(""));
		assertThat(longg, equalTo(""));
		assertThat(floatt, equalTo(""));
		assertThat(Double, equalTo(""));
	}
	
	

}
