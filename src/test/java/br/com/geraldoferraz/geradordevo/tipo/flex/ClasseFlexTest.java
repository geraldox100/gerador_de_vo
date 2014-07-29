package br.com.geraldoferraz.geradordevo.tipo.flex;



import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.geraldoferraz.geradordevo.tipo.Atributo;
import br.com.geraldoferraz.geradordevo.tipo.Classe;

public class ClasseFlexTest {

	private Classe vo;

	@Before
	public void beforeVO() {
		vo = new ClasseFlex();
		vo.setNome("br.com.entidade.Usuario");
	}

	@Test
	public void quandoPerguntarNomeDaClasseDeveSerVO() {
		assertThat(vo.getNome(), equalTo("br.com.entidade.UsuarioVO"));
	}

	@Test
	public void quandoPerguntarNomeDaClasseQueJaTemVO() {
		vo.setNome("br.com.entidade.UsuarioVO");
		assertThat(vo.getNome(), equalTo("br.com.entidade.UsuarioVO"));
	}

	@Test
	public void quandoPedirAtributosENaoTiverAtributos() {
		assertThat(vo.getAtributos(), not(equalTo(null)));
		assertThat(vo.getAtributos().size(), equalTo(0));
	}

	@Test
	public void quandoaAdicionarAtributo() {
		Atributo atributo = montarAtributo();
		vo.adicionarAtributo(atributo);

		assertThat(vo.getAtributos().size(), equalTo(1));
		assertThat(vo.getAtributos().get(0), equalTo(atributo));
		assertThat(vo.getAtributos().get(0), sameInstance(atributo));

	}

	@Test
	public void listaDeAtributosDeveSerImutavel() {
		Atributo atributo = montarAtributo();
		vo.adicionarAtributo(atributo);

		List<Atributo> atributos = vo.getAtributos();

		atributos.add(atributo);

		assertThat(vo.getAtributos().size(), equalTo(1));

	}
	
	@Test
	public void quandoPedirOTextoDaClasseSimples(){
		vo.adicionarAtributo(montarAtributo());
		String textoDaClasse = vo.getTextoDaClasse();
		
		String realClass = "public class UsuarioVO {\n\n\tprivate var _login : String;\n\n\tpublic function get login(): String{ \n\t\treturn _login;\n\t}\n\n\tpublic function set login(valor: String) : void {\n\t\t_login = valor;\n\t}\n\n}";
		
		assertThat(textoDaClasse, equalTo(realClass));
	}
	
	@Test
	public void quandoPedirOTextoDaClasseComMaisDeUmAtributoSimples(){
		vo.adicionarAtributo(montarAtributo("login","java.lang.String"));
		vo.adicionarAtributo(montarAtributo("idade","java.lang.Integer"));
		String textoDaClasse = vo.getTextoDaClasse();
		
		String realClass = "public class UsuarioVO {\n\n\tprivate var _login : String;\n\tprivate var _idade : Number;\n\n\tpublic function get login(): String{ \n\t\treturn _login;\n\t}\n\n\tpublic function set login(valor: String) : void {\n\t\t_login = valor;\n\t}\n\n\tpublic function get idade(): Number{ \n\t\treturn _idade;\n\t}\n\n\tpublic function set idade(valor: Number) : void {\n\t\t_idade = valor;\n\t}\n\n}";
		
		assertThat(textoDaClasse, equalTo(realClass));
	}
	
	@Test
	public void quandoPedirOTextoDaClasseComMaisDeUmAtributoComplexo(){
		vo.adicionarAtributo(montarAtributo("login","java.lang.String"));
		vo.adicionarAtributo(montarAtributo("idade","java.lang.Integer"));
		vo.adicionarAtributo(montarAtributo("permissao","br.com.geraldoferraz.geradordevo.entidades.Permissao"));
		String textoDaClasse = vo.getTextoDaClasse();
		
		String realClass = "import br.com.geraldoferraz.geradordevo.entidades.PermissaoVO;\n\npublic class UsuarioVO {\n\n\tprivate var _login : String;\n\tprivate var _idade : Number;\n\tprivate var _permissao : PermissaoVO;\n\n\tpublic function get login(): String{ \n\t\treturn _login;\n\t}\n\n\tpublic function set login(valor: String) : void {\n\t\t_login = valor;\n\t}\n\n\tpublic function get idade(): Number{ \n\t\treturn _idade;\n\t}\n\n\tpublic function set idade(valor: Number) : void {\n\t\t_idade = valor;\n\t}\n\n\tpublic function get permissao(): PermissaoVO{ \n\t\treturn _permissao;\n\t}\n\n\tpublic function set permissao(valor: PermissaoVO) : void {\n\t\t_permissao = valor;\n\t}\n\n}";
		
		assertThat(textoDaClasse, equalTo(realClass));
	}
	
	

	private Atributo montarAtributo(String nome, String tipo) {
		Atributo atributo = new AtributoFlex();
		atributo.setNome(nome);
		atributo.setTipo(tipo);
		return atributo;
	}

	private Atributo montarAtributo() {
		
		return montarAtributo("login", "java.lang.String");
	}
	
	
//	public static void main(String[] args) {
//		String realClass = "public class UsuarioVO {\n\n\tprivate String login;\n\n\tpublic String getLogin(){\n\t\treturn this.login;\n\t}\n\n\tpublic void setLogin(String login){\n\t\tthis.login = login;\n\t}\n\n}";
//		String text = "public class UsuarioVO {\n\n\tprivate String login;\n\tprivate Integer idade;\n\n\tpublic String getLogin(){\n\t\treturn this.login;\n\t}\n\n\tpublic void setLogin(String login){\n\t\tthis.login = login;\n\t}\n\n\tpublic Integer getIdade(){\n\t\treturn this.idade;\n\t}\n\n\tpublic void setIdade(Integer idade){\n\t\tthis.idade = idade;\n\t}\n\n}";
//		String a = "public class UsuarioVO {\n\n\tprivate String login;\n\tprivate Integer idade;\n\n\tpublic String getLogin(){\n\t\treturn this.login;\n\t}\n\n\tpublic void setLogin(String login){\n\t\tthis.login = login;\n\t}\n\n\tpublic Integer getIdade(){\n\t\treturn this.idade\n\t}\n\n\tpublic void setIdade(Integer idade){\n\t\tthis.idade = idade;\n\t}\n\n}";
//		String b = "public class UsuarioVO {\n\n\tprivate String login;\n\tprivate Integer idade;\n\n\tpublic String getLogin(){\n\t\treturn this.login;\n\t}\n\n\tpublic void setLogin(String login){\n\t\tthis.login = login;\n\t}\n\n\tpublic Integer getIdade(){\n\t\treturn this.idade;\n\t}\n\n\tpublic void setIdade(Integer idade){\n\t\tthis.idade = idade;\n\t}\n\n}";
//		String c = "public class UsuarioVO {\n\n\tprivate String login;\n\tprivate Integer idade;\n\n\tpublic String getLogin(){\n\t\treturn this.login;\n\t}\n\n\tpublic void setLogin(String login){\n\t\tthis.login = login;\n\t}\n\n\tpublic Integer getIdade(){\n\t\treturn this.idade;\n\t}\n\n\tpublic void setIdade(Integer idade){\n\t\tthis.idade = idade;\n\t}\n\n\tpublic Permissao getPermissao(){\n\t\treturn this.permissao;\n\t}\n\n\tpublic void setPermissao(Permissao permissao){\n\t\tthis.permissao = login;\n\t}\n\n}";
//		
//		System.out.println(c);
//		System.out.println("####");
//		System.out.println(b);
//	String realClass = "import br.com.geraldoferraz.geradordevo.entidades.Permissao;\n\npublic class UsuarioVO {\n\n\tprivate String login;\n\tprivate Integer idade;\n\tprivate Permissao permissao;\n\n\tpublic String getLogin(){\n\t\treturn this.login;\n\t}\n\n\tpublic void setLogin(String login){\n\t\tthis.login = login;\n\t}\n\n\tpublic Integer getIdade(){\n\t\treturn this.idade;\n\t}\n\n\tpublic void setIdade(Integer idade){\n\t\tthis.idade = idade;\n\t}\n\n\tpublic Permissao getPermissao(){\n\t\treturn this.permissao;\n\t}\n\n\tpublic void setPermissao(Permissao permissao){\n\t\tthis.permissao = permissao;\n\t}\n\n}";
//	System.out.println(realClass);
//	}
	

}
