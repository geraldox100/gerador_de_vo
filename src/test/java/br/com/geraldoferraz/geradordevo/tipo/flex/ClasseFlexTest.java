package br.com.geraldoferraz.geradordevo.tipo.flex;



import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.geraldoferraz.geradordevo.entidades.Permissao;
import br.com.geraldoferraz.geradordevo.template.FlexTemplates;
import br.com.geraldoferraz.geradordevo.tipo.Atributo;
import br.com.geraldoferraz.geradordevo.tipo.Classe;

public class ClasseFlexTest {

	private Classe classe;

	@Before
	public void beforeVO() {
		classe = new Classe();
		classe.setTemplate(new FlexTemplates());
		classe.setNome("br.com.entidade.Usuario");
	}

	@Test
	public void quandoPerguntarNomeDaClasseDeveSerVO() {
		assertThat(classe.getNome(), equalTo("br.com.entidade.UsuarioVO"));
	}

	@Test
	public void quandoPerguntarNomeDaClasseQueJaTemVO() {
		classe.setNome("br.com.entidade.UsuarioVO");
		assertThat(classe.getNome(), equalTo("br.com.entidade.UsuarioVO"));
	}

	@Test
	public void quandoPedirAtributosENaoTiverAtributos() {
		assertThat(classe.getAtributos(), not(equalTo(null)));
		assertThat(classe.getAtributos().size(), equalTo(0));
	}

	@Test
	public void quandoaAdicionarAtributo() {
		Atributo atributo = montarAtributo();
		classe.adicionarAtributo(atributo);

		assertThat(classe.getAtributos().size(), equalTo(1));
		assertThat(classe.getAtributos().get(0), equalTo(atributo));
		assertThat(classe.getAtributos().get(0), sameInstance(atributo));

	}

	@Test
	public void listaDeAtributosDeveSerImutavel() {
		Atributo atributo = montarAtributo();
		classe.adicionarAtributo(atributo);

		List<Atributo> atributos = classe.getAtributos();

		atributos.add(atributo);

		assertThat(classe.getAtributos().size(), equalTo(1));

	}
	
	@Test
	public void quandoPedirOTextoDaClasseSimples(){
		classe.adicionarAtributo(montarAtributo());
		String textoDaClasse = classe.getTextoDaClasse();
		
		String realClass = "public class UsuarioVO {\n\n\tprivate var _login : String;\n\n\tpublic function get login(): String{ \n\t\treturn _login;\n\t}\n\n\tpublic function set login(valor: String) : void {\n\t\t_login = valor;\n\t}\n\n}";
		
		assertThat(textoDaClasse, equalTo(realClass));
	}
	
	@Test
	public void quandoPedirOTextoDaClasseComMaisDeUmAtributoSimples(){
		classe.adicionarAtributo(montarAtributo("login","java.lang.String"));
		classe.adicionarAtributo(montarAtributo("idade","java.lang.Integer"));
		String textoDaClasse = classe.getTextoDaClasse();
		
		String realClass = "public class UsuarioVO {\n\n\tprivate var _login : String;\n\tprivate var _idade : Number;\n\n\tpublic function get login(): String{ \n\t\treturn _login;\n\t}\n\n\tpublic function set login(valor: String) : void {\n\t\t_login = valor;\n\t}\n\n\tpublic function get idade(): Number{ \n\t\treturn _idade;\n\t}\n\n\tpublic function set idade(valor: Number) : void {\n\t\t_idade = valor;\n\t}\n\n}";
		
		assertThat(textoDaClasse, equalTo(realClass));
	}
	
	@Test
	public void quandoPedirOTextoDaClasseComMaisDeUmAtributoComplexo(){
		classe.adicionarAtributo(montarAtributo("login","java.lang.String"));
		classe.adicionarAtributo(montarAtributo("idade","java.lang.Integer"));
		classe.adicionarAtributo(montarAtributo("permissao","br.com.geraldoferraz.geradordevo.entidades.Permissao"));
		String textoDaClasse = classe.getTextoDaClasse();
		
		String realClass = "import br.com.geraldoferraz.geradordevo.entidades.PermissaoVO;\n\npublic class UsuarioVO {\n\n\tprivate var _login : String;\n\tprivate var _idade : Number;\n\tprivate var _permissao : PermissaoVO;\n\n\tpublic function get login(): String{ \n\t\treturn _login;\n\t}\n\n\tpublic function set login(valor: String) : void {\n\t\t_login = valor;\n\t}\n\n\tpublic function get idade(): Number{ \n\t\treturn _idade;\n\t}\n\n\tpublic function set idade(valor: Number) : void {\n\t\t_idade = valor;\n\t}\n\n\tpublic function get permissao(): PermissaoVO{ \n\t\treturn _permissao;\n\t}\n\n\tpublic function set permissao(valor: PermissaoVO) : void {\n\t\t_permissao = valor;\n\t}\n\n}";
		
		assertThat(textoDaClasse, equalTo(realClass));
	}
	
	@Test
	public void quandoPedirOTextoDaClasseComDoisAtributosDoMesmoTipo(){
		classe.adicionarAtributo(montarAtributo("permissao1","br.com.geraldoferraz.geradordevo.entidades.Permissao"));
		classe.adicionarAtributo(montarAtributo("permissao2","br.com.geraldoferraz.geradordevo.entidades.Permissao"));
		String textoDaClasse = classe.getTextoDaClasse();
		
		String realClass = "import br.com.geraldoferraz.geradordevo.entidades.PermissaoVO;\n\npublic class UsuarioVO {\n\n\tprivate var _permissao1 : PermissaoVO;\n\tprivate var _permissao2 : PermissaoVO;\n\n\tpublic function get permissao1(): PermissaoVO{ \n\t\treturn _permissao1;\n\t}\n\n\tpublic function set permissao1(valor: PermissaoVO) : void {\n\t\t_permissao1 = valor;\n\t}\n\n\tpublic function get permissao2(): PermissaoVO{ \n\t\treturn _permissao2;\n\t}\n\n\tpublic function set permissao2(valor: PermissaoVO) : void {\n\t\t_permissao2 = valor;\n\t}\n\n}";
		
		assertThat(textoDaClasse, equalTo(realClass));
	}
	
	@Test
	public void quandoPedirOTextoDaClasseComHierarquia(){
		classe.definirHierarQuia(Permissao.class.getName());
		String textoDaClasse = classe.getTextoDaClasse();
		
		String realClass = "import br.com.geraldoferraz.geradordevo.entidades.Permissao;\n\npublic class UsuarioVO extends Permissao{\n\n\n}";
		
		assertThat(textoDaClasse, equalTo(realClass));
	}
	
	@Test
	public void quandoPedirOTextoDaClasseComPacote(){
		classe.setPacote("br.com.geraldoferraz.vo");
		String textoDaClasse = classe.getTextoDaClasse();
		
		String realClass = "package br.com.geraldoferraz.vo;\n\npublic class UsuarioVO {\n\n\n}";
		
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
	
	
	

}
