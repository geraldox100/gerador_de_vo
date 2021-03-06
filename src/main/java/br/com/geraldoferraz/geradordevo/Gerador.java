package br.com.geraldoferraz.geradordevo;

import static br.com.geraldoferraz.scanyourpath.searches.filters.arguments.SearchArguments.annotedOnClassWith;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Transient;

import br.com.geraldoferraz.geradordevo.modo.ModoDeGeracao;
import br.com.geraldoferraz.geradordevo.tipo.Atributo;
import br.com.geraldoferraz.geradordevo.tipo.Classe;
import br.com.geraldoferraz.geradordevo.tipo.Metodo;
import br.com.geraldoferraz.scanyourpath.Scanner;
import br.com.geraldoferraz.scanyourpath.searches.filters.arguments.Argument;

public class Gerador {

	private Scanner scanner = new Scanner();
	private String pacoteDasEntidades;

	public Gerador() {
		scanner.allClasses(annotedOnClassWith(Entity.class).or(new Argument() {
			
			@Override
			public boolean validate(Class<?> clazz) {
				return clazz.getName().endsWith("EJB");
			}
		}));
	}

	public Gerador buscarClassesEm(String pacoteDasEntidades) {
		this.pacoteDasEntidades = pacoteDasEntidades;
		return this;
	}

	public Map<String, String> gerar(ModoDeGeracao... modos) {
		try {
			Map<String, String> retorno = new HashMap<String,String>();
			Set<Class<?>> classes = scanner.exactlyIn(pacoteDasEntidades);

			for (ModoDeGeracao modo : modos) {
				for (Class<?> clazz : classes) {

					Classe classe = new Classe();
					classe.setTemplate(modo.getTemplate());

					classe.setPacote(modo.buscarPacote());
					classe.setNome(clazz.getName()+modo.getSuffix());
					classe.definirHierarQuia(modo.buscarHierarquia());

					for (Field field : clazz.getDeclaredFields()) {
						if (!(forTransient(field) || forSerialVersionID(field) || forEstatico(field))) {

							Atributo atributo = modo.getAtributo().newInstance();
							atributo.setPacote(modo.buscarPacote());
							atributo.setNome(field.getName());
							definirTipo(field, atributo);

							classe.adicionarAtributo(atributo);
						}
					}
					
					for (Method method : clazz.getDeclaredMethods()) {
						if(Modifier.isPublic(method.getModifiers())){
							if(!forGetter(method) && !forSetter(method)){
								Metodo metodo = modo.getMetodo().newInstance();
								metodo.setNome(method.getName());
								metodo.setParametros(method.getParameterTypes());
								metodo.setRetorno(method.getReturnType());
								classe.adicionarMetodo(metodo);
							}
						}
					}

					retorno.put(removerPacoteDoNome(classe.getNome())+classe.getExtesao(),classe.getTextoDaClasse());

				}
			}

			return retorno;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private boolean forSetter(Method method) {
		return method.getName().startsWith("set");
	}

	private boolean forGetter(Method method) {
		return method.getName().startsWith("get");
	}

	private boolean forEstatico(Field field) {
		return Modifier.isStatic(field.getModifiers());
	}

	private boolean forSerialVersionID(Field field) {
		return field.getName().equals("serialVersionUID");
	}

	private boolean forTransient(Field field) {
		return field.isAnnotationPresent(Transient.class) || Modifier.isTransient(field.getModifiers());
	}

	private void definirTipo(Field field, Atributo atributo) {
		atributo.setTipo(field.getType().getName());
		resolverTipoGenerico(field, atributo);
	}

	private void resolverTipoGenerico(Field field, Atributo atributo) {
		try {
			ParameterizedType typeWithGeneric = (ParameterizedType) field.getGenericType();
			atributo.setTipo(typeWithGeneric.toString());

		} catch (Exception e) {

		}
	}
	
	protected String removerPacoteDoNome(String nomeClasse) {
		int ponto = nomeClasse.lastIndexOf(".");
		if (ponto > 0) {
			nomeClasse = nomeClasse.substring(ponto + 1);
		}
		return nomeClasse;
	}

}
