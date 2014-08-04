package br.com.geraldoferraz.geradordevo.tipo.java;



import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.geraldoferraz.geradordevo.entidades.Permissao;
import br.com.geraldoferraz.geradordevo.template.JavaVOTemplates;
import br.com.geraldoferraz.geradordevo.tipo.Atributo;
import br.com.geraldoferraz.geradordevo.tipo.Classe;

public class ClasseJavaTest {

	private Classe classe;

	@Before
	public void beforeVO() {
		classe = new Classe();
		classe.setTemplate(new JavaVOTemplates());
		classe.setNome("br.com.entidade.Usuario");
	}

	@Test
	public void quandoPedirONomeDaClasseQueJaTemVO() {
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
		
		String realClass = "public class UsuarioVO {\n\n\tprivate static final long serialVersionUID = 1L;\n\n\tprivate String login;\n\n\tpublic String getLogin(){\n\t\treturn this.login;\n\t}\n\n\tpublic void setLogin(String login){\n\t\tthis.login = login;\n\t}\n\n}";
		
		assertThat(textoDaClasse, equalTo(realClass));
	}
	
	@Test
	public void quandoPedirOTextoDaClasseComMaisDeUmAtributoSimples(){
		classe.adicionarAtributo(montarAtributo("login","java.lang.String"));
		classe.adicionarAtributo(montarAtributo("idade","java.lang.Integer"));
		String textoDaClasse = classe.getTextoDaClasse();
		
		String realClass = "public class UsuarioVO {\n\n\tprivate static final long serialVersionUID = 1L;\n\n\tprivate String login;\n\tprivate Integer idade;\n\n\tpublic String getLogin(){\n\t\treturn this.login;\n\t}\n\n\tpublic void setLogin(String login){\n\t\tthis.login = login;\n\t}\n\n\tpublic Integer getIdade(){\n\t\treturn this.idade;\n\t}\n\n\tpublic void setIdade(Integer idade){\n\t\tthis.idade = idade;\n\t}\n\n}";
		
		assertThat(textoDaClasse, equalTo(realClass));
	}
	
	@Test
	public void quandoPedirOTextoDaClasseComMaisDeUmAtributoComplexo(){
		classe.adicionarAtributo(montarAtributo("login","java.lang.String"));
		classe.adicionarAtributo(montarAtributo("idade","java.lang.Integer"));
		classe.adicionarAtributo(montarAtributo("permissao","br.com.geraldoferraz.geradordevo.entidades.Permissao"));
		String textoDaClasse = classe.getTextoDaClasse();
		
		String realClass = "import br.com.geraldoferraz.geradordevo.entidades.PermissaoVO;\n\npublic class UsuarioVO {\n\n\tprivate static final long serialVersionUID = 1L;\n\n\tprivate String login;\n\tprivate Integer idade;\n\tprivate PermissaoVO permissao;\n\n\tpublic String getLogin(){\n\t\treturn this.login;\n\t}\n\n\tpublic void setLogin(String login){\n\t\tthis.login = login;\n\t}\n\n\tpublic Integer getIdade(){\n\t\treturn this.idade;\n\t}\n\n\tpublic void setIdade(Integer idade){\n\t\tthis.idade = idade;\n\t}\n\n\tpublic PermissaoVO getPermissao(){\n\t\treturn this.permissao;\n\t}\n\n\tpublic void setPermissao(PermissaoVO permissao){\n\t\tthis.permissao = permissao;\n\t}\n\n}";
		
		assertThat(textoDaClasse, equalTo(realClass));
	}
	
	
	@Test
	public void quandoPedirOTextoDaClasseComDoisAtributosDoMesmoTipo(){
		classe.adicionarAtributo(montarAtributo("permissao1","br.com.geraldoferraz.geradordevo.entidades.Permissao"));
		classe.adicionarAtributo(montarAtributo("permissao2","br.com.geraldoferraz.geradordevo.entidades.Permissao"));
		String textoDaClasse = classe.getTextoDaClasse();
		
		String realClass = "import br.com.geraldoferraz.geradordevo.entidades.PermissaoVO;\n\npublic class UsuarioVO {\n\n\tprivate static final long serialVersionUID = 1L;\n\n\tprivate PermissaoVO permissao1;\n\tprivate PermissaoVO permissao2;\n\n\tpublic PermissaoVO getPermissao1(){\n\t\treturn this.permissao1;\n\t}\n\n\tpublic void setPermissao1(PermissaoVO permissao1){\n\t\tthis.permissao1 = permissao1;\n\t}\n\n\tpublic PermissaoVO getPermissao2(){\n\t\treturn this.permissao2;\n\t}\n\n\tpublic void setPermissao2(PermissaoVO permissao2){\n\t\tthis.permissao2 = permissao2;\n\t}\n\n}";
		
		assertThat(textoDaClasse, equalTo(realClass));
	}
	
	@Test
	public void quandoPedirOTextoDaClasseComHierarquia(){
		classe.adicionarAtributo(montarAtributo("idade","int"));
		classe.definirHierarQuia(Permissao.class.getName());
		String textoDaClasse = classe.getTextoDaClasse();
		
		String realClass = "import br.com.geraldoferraz.geradordevo.entidades.Permissao;\n\npublic class UsuarioVO extends Permissao{\n\n\tprivate static final long serialVersionUID = 1L;\n\n\tprivate int idade;\n\n\tpublic int getIdade(){\n\t\treturn this.idade;\n\t}\n\n\tpublic void setIdade(int idade){\n\t\tthis.idade = idade;\n\t}\n\n}";
		
		assertThat(textoDaClasse, equalTo(realClass));
	}
	
	@Test
	public void quandoPedirOTextoDaClasseComPacote(){
		classe.setPacote("br.com.geraldoferraz.vo");
		String textoDaClasse = classe.getTextoDaClasse();
		
		String realClass = "package br.com.geraldoferraz.vo;\n\npublic class UsuarioVO {\n\n\tprivate static final long serialVersionUID = 1L;\n\n\n}";
		
		assertThat(textoDaClasse, equalTo(realClass));
	}
	
	private Atributo montarAtributo(String nome, String tipo) {
		Atributo atributo = new AtributoJava();
		atributo.setNome(nome);
		atributo.setTipo(tipo);
		return atributo;
	}

	private Atributo montarAtributo() {
		
		return montarAtributo("login", "java.lang.String");
	}
	

}
