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
	public void quandoPedirTextoDoGetDeUmTipoDateTimeDB() {
		paraAtributoString("data", "br.com.bancoob.persistencia.types.DateTimeDB");
		String getter = atributo.getGetter();

		String realGetter = "\tpublic DateTimeDB getData(){\n\t\treturn this.data;\n\t}";
		assertThat(getter, equalTo(realGetter));
		
	}
	@Test
	public void quandoPedirTextoDoGetDeUmTipoSQLDate() {
		paraAtributoString("data", "java.sql.Date");
		String getter = atributo.getGetter();

		String realGetter = "\tpublic Date getData(){\n\t\treturn this.data;\n\t}";
		assertThat(getter, equalTo(realGetter));
		
	}
	
	@Test
	public void quandoPedirTextoDoGetDeUmTipoPrimitivo() {
		paraAtributoString("numero", "int");
		String intt = atributo.getGetter();
		String intGetter = "\tpublic int getNumero(){\n\t\treturn this.numero;\n\t}";
		
		paraAtributoString("numero", "long");
		String longg = atributo.getGetter();
		String longGetter = "\tpublic long getNumero(){\n\t\treturn this.numero;\n\t}";
		
		paraAtributoString("numero", "double");
		String doublee = atributo.getGetter();
		String doubleGetter = "\tpublic double getNumero(){\n\t\treturn this.numero;\n\t}";
		
		paraAtributoString("numero", "byte");
		String bytee = atributo.getGetter();
		String byteGetter = "\tpublic byte getNumero(){\n\t\treturn this.numero;\n\t}";
		
		paraAtributoString("numero", "char");
		String charr = atributo.getGetter();
		String charGetter = "\tpublic char getNumero(){\n\t\treturn this.numero;\n\t}";
		
		paraAtributoString("numero", "short");
		String shortt = atributo.getGetter();
		String shortGetter = "\tpublic short getNumero(){\n\t\treturn this.numero;\n\t}";
		
		paraAtributoString("numero", "boolean");
		String booleann = atributo.getGetter();
		String boleanGetter = "\tpublic boolean getNumero(){\n\t\treturn this.numero;\n\t}";
		
		paraAtributoString("numero", "float");
		String floatt = atributo.getGetter();
		String floatGetter = "\tpublic float getNumero(){\n\t\treturn this.numero;\n\t}";
		

		assertThat(intt, equalTo(intGetter));
		assertThat(longg, equalTo(longGetter));
		assertThat(doublee, equalTo(doubleGetter));
		assertThat(bytee, equalTo(byteGetter));
		assertThat(charr, equalTo(charGetter));
		assertThat(shortt, equalTo(shortGetter));
		assertThat(booleann, equalTo(boleanGetter));
		assertThat(floatt, equalTo(floatGetter));
	}
	
	@Test
	public void quandoPedirTextoDoGetDeUmTipoDate() {
		paraAtributoString("data", "java.util.Date");
		String getter = atributo.getGetter();

		String realGetter = "\tpublic Date getData(){\n\t\treturn this.data;\n\t}";
		assertThat(getter, equalTo(realGetter));
	}
	
	@Test
	public void quandoPedirTextoDoGetDeTipoGenerico() {
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
	public void quandoPedirTextoDoSetParaUmTipoDateTimeDB() {
		paraAtributoString("data", "br.com.bancoob.persistencia.types.DateTimeDB");
		String setter = atributo.getSetter();

		String realGetter = "\tpublic void setData(DateTimeDB data){\n\t\tthis.data = data;\n\t}";
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
	public void quandoPedirTextoDoGetParaUmTipoPrimitivo(){
		paraAtributoString("numero", "int");
		String intt = atributo.getGetter();
		String intGetter = "\tpublic int getNumero(){\n\t\treturn this.numero;\n\t}";
		
		paraAtributoString("numero", "long");
		String longg = atributo.getGetter();
		String longGetter = "\tpublic long getNumero(){\n\t\treturn this.numero;\n\t}";
		
		paraAtributoString("numero", "double");
		String doublee = atributo.getGetter();
		String doubleGetter = "\tpublic double getNumero(){\n\t\treturn this.numero;\n\t}";
		
		paraAtributoString("numero", "byte");
		String bytee = atributo.getGetter();
		String byteGetter = "\tpublic byte getNumero(){\n\t\treturn this.numero;\n\t}";
		
		paraAtributoString("numero", "char");
		String charr = atributo.getGetter();
		String charGetter = "\tpublic char getNumero(){\n\t\treturn this.numero;\n\t}";
		
		paraAtributoString("numero", "short");
		String shortt = atributo.getGetter();
		String shortGetter = "\tpublic short getNumero(){\n\t\treturn this.numero;\n\t}";
		
		paraAtributoString("numero", "boolean");
		String booleann = atributo.getGetter();
		String boleanGetter = "\tpublic boolean getNumero(){\n\t\treturn this.numero;\n\t}";
		
		paraAtributoString("numero", "float");
		String floatt = atributo.getGetter();
		String floatGetter = "\tpublic float getNumero(){\n\t\treturn this.numero;\n\t}";
		

		assertThat(intt, equalTo(intGetter));
		assertThat(longg, equalTo(longGetter));
		assertThat(doublee, equalTo(doubleGetter));
		assertThat(bytee, equalTo(byteGetter));
		assertThat(charr, equalTo(charGetter));
		assertThat(shortt, equalTo(shortGetter));
		assertThat(booleann, equalTo(boleanGetter));
		assertThat(floatt, equalTo(floatGetter));
	}
	
	@Test
	public void quandoPedirTextoDoSetParaUmTipoPrimitivo() {
		paraAtributoString("data", "int");
		String intt = atributo.getSetter();
		String intSetter = "\tpublic void setData(int data){\n\t\tthis.data = data;\n\t}";
		
		paraAtributoString("data", "long");
		String longg = atributo.getSetter();
		String longSetter = "\tpublic void setData(long data){\n\t\tthis.data = data;\n\t}";
		
		paraAtributoString("data", "double");
		String doublee = atributo.getSetter();
		String doubleSetter = "\tpublic void setData(double data){\n\t\tthis.data = data;\n\t}";
		
		paraAtributoString("data", "byte");
		String bytee = atributo.getSetter();
		String byteSetter = "\tpublic void setData(byte data){\n\t\tthis.data = data;\n\t}";
		
		paraAtributoString("data", "char");
		String charr = atributo.getSetter();
		String charSetter = "\tpublic void setData(char data){\n\t\tthis.data = data;\n\t}";
		
		paraAtributoString("data", "short");
		String shortt = atributo.getSetter();
		String shortSetter = "\tpublic void setData(short data){\n\t\tthis.data = data;\n\t}";
		
		paraAtributoString("data", "boolean");
		String booleann = atributo.getSetter();
		String boleanSetter = "\tpublic void setData(boolean data){\n\t\tthis.data = data;\n\t}";
		
		paraAtributoString("data", "float");
		String floatt = atributo.getSetter();
		String floatSetter = "\tpublic void setData(float data){\n\t\tthis.data = data;\n\t}";
		
		
		assertThat(intt, equalTo(intSetter));
		assertThat(longg, equalTo(longSetter));
		assertThat(doublee, equalTo(doubleSetter));
		assertThat(bytee, equalTo(byteSetter));
		assertThat(charr, equalTo(charSetter));
		assertThat(shortt, equalTo(shortSetter));
		assertThat(booleann, equalTo(boleanSetter));
		assertThat(floatt, equalTo(floatSetter));
	}
	
	@Test
	public void quandoPedirTextoDoSetParaUmTipoDate() {
		paraAtributoString("data", "java.util.Date");
		String setter = atributo.getSetter();

		String realGetter = "\tpublic void setData(Date data){\n\t\tthis.data = data;\n\t}";
		assertThat(setter, equalTo(realGetter));
	}
	
	@Test
	public void quandoPedirTextoDoSetParaUmTipoSQLDate() {
		paraAtributoString("data", "java.sql.Date");
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
	public void quandoPedirTextoDoGetDeUmJavaMath() {
		paraAtributoString("login", "java.math.BigDecimal");
		String getter = atributo.getGetter();

		String realGetter = "\tpublic BigDecimal getLogin(){\n\t\treturn this.login;\n\t}";
		assertThat(getter, equalTo(realGetter));
	}

	@Test
	public void quandoPedirTextoDoSetParaUmTipoInteger() {
		paraAtributoString("login", "Integer");
		String setter = atributo.getSetter();

		String realGetter = "\tpublic void setLogin(Integer login){\n\t\tthis.login = login;\n\t}";
		assertThat(setter, equalTo(realGetter));
	}
	
	@Test
	public void quandoPedirTextoDoSetParaUmTipoJavaMath() {
		paraAtributoString("login", "java.math.BigDecimal");
		String setter = atributo.getSetter();

		String realGetter = "\tpublic void setLogin(BigDecimal login){\n\t\tthis.login = login;\n\t}";
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
	public void quandoPedirTextoDoImportDeUmDateTimeDB() {
		paraAtributoString("data", "br.com.bancoob.persistencia.types.DateTimeDB");
		String importt = atributo.getImport();
		assertThat(importt, equalTo("import br.com.bancoob.persistencia.types.DateTimeDB;\n"));
		
	}
	
	@Test
	public void quandoPedirTextoDoImportDeUmDate() {
		paraAtributoString("data", "java.util.Date");
		String importt = atributo.getImport();
		assertThat(importt, equalTo("import java.util.Date;\n"));
	}
	
	@Test
	public void quandoPedirTextoDoImportDeUmSQLDate() {
		paraAtributoString("data", "java.sql.Date");
		String importt = atributo.getImport();
		assertThat(importt, equalTo("import java.sql.Date;\n"));
	}
	
	
	@Test
	public void quandoPedirTextoDoImportDeUmTipoPrimitivo() {

		paraAtributoString("numero", "int");
		String intt = atributo.getImport();
		
		paraAtributoString("numero", "long");
		String longg = atributo.getImport();
		
		paraAtributoString("numero", "double");
		String doublee = atributo.getImport();
		
		paraAtributoString("numero", "byte");
		String bytee = atributo.getImport();
		
		paraAtributoString("numero", "char");
		String charr = atributo.getImport();
		
		paraAtributoString("numero", "short");
		String shortt = atributo.getImport();
		
		paraAtributoString("numero", "boolean");
		String booleann = atributo.getImport();
		
		paraAtributoString("numero", "float");
		String floatt = atributo.getImport();
		
		String vazia = "";

		assertThat(intt, equalTo(vazia));
		assertThat(longg, equalTo(vazia));
		assertThat(doublee, equalTo(vazia));
		assertThat(bytee, equalTo(vazia));
		assertThat(charr, equalTo(vazia));
		assertThat(shortt, equalTo(vazia));
		assertThat(booleann, equalTo(vazia));
		assertThat(floatt, equalTo(vazia));
		
		
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
		
		paraAtributoString("data", "java.math.BigInteger");
		String wrapperBigInteger = atributo.getImport();
		
		paraAtributoString("data", "java.math.BigDecimal");
		String wrapperBigDecimal = atributo.getImport();
		
		assertThat(wrapperBoolean, equalTo(""));
		assertThat(wrapperByte, equalTo(""));
		assertThat(wrapperCharacter, equalTo(""));
		assertThat(wrapperShort, equalTo(""));
		assertThat(wrapperInteger, equalTo(""));
		assertThat(wrapperLong, equalTo(""));
		assertThat(wrapperFloat, equalTo(""));
		assertThat(wrapperDouble, equalTo(""));
		assertThat(wrapperBigInteger, equalTo(""));
		assertThat(wrapperBigDecimal, equalTo(""));
	}
	
	@Test
	public void quandoPedirTextoDoImportDeUmTipoVO() {
		paraAtributoString("permissao", "br.com.geraldoferraz.Permissao");
		atributo.setPacote("br.com.geraldoferraz.vo");
		String importt = atributo.getImport();

		assertThat(importt, equalTo("import br.com.geraldoferraz.vo.PermissaoVO;\n"));
	}
	
	@Test
	public void quandoPedirTextoDoImportDeUmTipoVOGenerico() {
		paraAtributoString("permissao", "java.util.List<br.com.entidades.Permissao>");
		atributo.setPacote("br.com.geraldoferraz.vo");
		String importt = atributo.getImport();

		assertThat(importt, equalTo("import java.util.List;\nimport br.com.geraldoferraz.vo.PermissaoVO;\n"));
		

	}

}
