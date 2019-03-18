package Analizador;

public class Validacion {

	static public void checarSiExisteToken(Identificador variable) {
		for (int j = 0; j < lexer.tablaSimbolos.size(); j++) {
			if(lexer.tablaSimbolos.get(j).getNombre().equals(variable.getNombre())) {
				System.out.println("Error: La variable "+variable.getNombre()+" ya habia sido declarada con un tipo: "+lexer.tablaSimbolos.get(j).getTipoDato());
			}
		}	

	}

	static public void checarTipoDato(Identificador variable) {
		String tipoDato=variable.getTipoDato();
		String valor=variable.getValor();
		if(tipoDato.equals("int")){
			try {
				Integer.parseInt(valor);
			} catch (Exception e) {
				System.out.println("Error en el Identificador "+variable.getNombre()+",puesto que este valor no es Entero(Int) - Debes utilizar el Tipo de Dato: "+variable.getTipoDato());
			}
		}
		if(tipoDato.equals("double")) {
			try {
				Double.parseDouble(valor);
			} catch (Exception e) {
				System.out.println("Error en el Identificador "+variable.getNombre()+",puesto que este valor no es Double- Debes utilizar el Tipo de Dato: "+variable.getTipoDato());

			}
		}
	   if(tipoDato.equals("string")){
		   try {
			   if(valor.startsWith("")&&valor.endsWith("\"")) {
				  // System.out.println("String valido");
			   }else {
				   System.out.println("Error en el Identificador "+variable.getNombre()+" puesto que este no es un string debes utilizar comillas dobles: "+"\"Cadena de Ejemplo\"");
			   }
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		  
	   }
	   
	if(tipoDato.equals("boolean")) {
		if (valor.equals("true") || valor.equals("false")) {
		System.out.println("Booleano correcto");
		}else {
	    System.out.println("El tipo de dato Booleano es incorrecto");
		}
	}
		
	}
}