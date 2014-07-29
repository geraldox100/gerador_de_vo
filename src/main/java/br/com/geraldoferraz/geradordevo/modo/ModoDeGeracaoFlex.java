package br.com.geraldoferraz.geradordevo.modo;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

import javax.persistence.Transient;

import br.com.geraldoferraz.geradordevo.tipo.Atributo;
import br.com.geraldoferraz.geradordevo.tipo.Classe;
import br.com.geraldoferraz.geradordevo.tipo.flex.AtributoFlex;
import br.com.geraldoferraz.geradordevo.tipo.flex.ClasseFlex;

public class ModoDeGeracaoFlex implements ModoDeGeracao{

	public String executar(Class<?> clazz) {
		Classe classe = new ClasseFlex();
		classe.setNome(clazz.getName());

		for (Field field : clazz.getDeclaredFields()) {
			if (!field.isAnnotationPresent(Transient.class)) {

				Atributo atributo = new AtributoFlex();
				atributo.setNome(field.getName());
				definirTipo(field, atributo);

				classe.adicionarAtributo(atributo);
			}
		}
		
		return classe.getTextoDaClasse();
	}
	
	private void definirTipo(Field field, Atributo atributo) {
		atributo.setTipo(field.getType().getName());
		resolverTipoGenerico(field, atributo);
	}

	private void resolverTipoGenerico(Field field, Atributo atributo) {
		try{
			ParameterizedType typeWithGeneric = (ParameterizedType) field.getGenericType();
			atributo.setTipo(typeWithGeneric.toString());
			
		}catch(Exception e){
			
		}
	}

}