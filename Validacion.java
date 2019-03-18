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
				//System.out.println("Booleano correcto");
			}else {
				System.out.println("El tipo de dato Booleano es incorrecto");
			}
		}

	}

	static public void checarComparacionValores(String a, String b) {
		try {
			if(!a.isEmpty() && !b.isEmpty()) {
				try {
					if(esEntero(a)==true && esEntero(b)==true) {
						//System.out.println("Los dos son Entero");
					}else if(esDoble(a)==true && esDoble(b)==true) {
						//System.out.println("Los dos son Double");
					}else {
						System.out.println("Error en tipo de dato");
					}
				} catch (Exception e) {
					System.out.println("Error"+e.getMessage());
				}
			}
		} catch (Exception e) {
			System.out.println("Error"+e.getMessage());
		}
	}

	public static boolean esEntero(String numero){
		try{
			Integer.parseInt(numero);
			return true;
		}catch(NumberFormatException e){
			return false;
		}
	}

	public static boolean esDoble(String numero){
		try{
			Double.parseDouble(numero);
			return true;
		}catch(NumberFormatException e){
			return false;
		}
	}


	public static boolean esBooleano(String numero){
		if(numero.equals("true") ||numero.equals("false")) {
			return true;
		}else {
			return false;
		}
	}


	public static void obtenerDatoComparacion(String a, String b) {
		//System.out.println(a);
		//System.out.println(b);
		
		String temp1="";
		for (int j = 0; j < lexer.tablaSimbolos.size(); j++) {
			if(lexer.tablaSimbolos.get(j).getNombre().equals(a)) {
				temp1=lexer.tablaSimbolos.get(j).getTipoDato();
			}
		}
		if(temp1.isEmpty()) {
			System.out.println("Error: la variable "+a+" no esta declarada");
			System.out.println("****************************************************************************************************");
		}
		for (int j = 0; j < lexer.tablaSimbolos.size(); j++) {
			if(lexer.tablaSimbolos.get(j).getNombre().equals(a)) {
				System.out.println("La variable "+a+" es de tipo: "+lexer.tablaSimbolos.get(j).getTipoDato());
				if(esEntero(b)==true && lexer.tablaSimbolos.get(j).getTipoDato().equals("int")) {
					System.out.println("Comparacion Valida "+lexer.tablaSimbolos.get(j).getTipoDato());
				}else if(esDoble(b)==true && lexer.tablaSimbolos.get(j).getTipoDato().equals("double")){
					System.out.println("Comparacion Valida "+lexer.tablaSimbolos.get(j).getTipoDato());
				}else if(esBooleano(b)==true && lexer.tablaSimbolos.get(j).getTipoDato().equals("boolean")){
					System.out.println("Comparacion Valida "+lexer.tablaSimbolos.get(j).getTipoDato());
				}else {
					System.out.println("Error: comparacion invalida: "+b+" no es de tipo: "+lexer.tablaSimbolos.get(j).getTipoDato());
					System.out.println("****************************************************************************************************");
				}
			}
		}
	}

	public static void obtenerDatoComparacion2(String a, String b) {
		//System.out.println(a);
		//System.out.println(b);
		String temp1="";
		for (int j = 0; j < lexer.tablaSimbolos.size(); j++) {
			if(lexer.tablaSimbolos.get(j).getNombre().equals(a)) {
				temp1=lexer.tablaSimbolos.get(j).getTipoDato();
			}
		}
		if(temp1.isEmpty()) {
			System.out.println("Error: la variable "+a+" no esta declarada");
			System.out.println("****************************************************************************************************");
		}
		for (int j = 0; j < lexer.tablaSimbolos.size(); j++) {
			if(lexer.tablaSimbolos.get(j).getNombre().equals(a)) {
				System.out.println("La variable "+a+" es de tipo: "+lexer.tablaSimbolos.get(j).getTipoDato());
				if(esEntero(b)==true && lexer.tablaSimbolos.get(j).getTipoDato().equals("int")) {
					System.out.println("Comparacion Valida "+lexer.tablaSimbolos.get(j).getTipoDato());
				}else if(esDoble(b)==true && lexer.tablaSimbolos.get(j).getTipoDato().equals("double")){
					System.out.println("Comparacion Valida "+lexer.tablaSimbolos.get(j).getTipoDato());
				}else if(esBooleano(b)==true && lexer.tablaSimbolos.get(j).getTipoDato().equals("boolean")){
					System.out.println("Comparacion Valida "+lexer.tablaSimbolos.get(j).getTipoDato());
				}else {
					System.out.println("Error: Comparacion invalida: "+a+" no es de tipo: "+lexer.tablaSimbolos.get(j).getTipoDato());
					System.out.println("****************************************************************************************************");
				}
			}	}
	}

	public static void obtenerDatoComparacion3(String a, String b) {
		String temp1="";
		String temp2="";
		for (int j = 0; j < lexer.tablaSimbolos.size(); j++) {
			if(lexer.tablaSimbolos.get(j).getNombre().equals(a)) {
				temp1=lexer.tablaSimbolos.get(j).getTipoDato();
			}
		}
		for (int j = 0; j < lexer.tablaSimbolos.size(); j++) {
			if(lexer.tablaSimbolos.get(j).getNombre().equals(b)) {
				temp2=lexer.tablaSimbolos.get(j).getTipoDato();
			}
		}
		if(temp1.isEmpty()) {
			System.out.println("Error: la variable "+a+" no esta declarada");
			System.out.println("****************************************************************************************************");
		}
		if(temp2.isEmpty()) {
			System.out.println("Error: la variable "+b+" no esta declarada");
			System.out.println("****************************************************************************************************");
		}
		if(!temp1.isEmpty() && !temp2.isEmpty() && !temp1.equals(temp2)) {
			System.out.println("****************************************************************************************************");
			System.out.println("Error: las variables: "+a+" y "+b+" no son del mismo tipo");
			System.out.println("La variable: "+a+" es de tipo: "+temp1);
			System.out.println("La variable: "+b+" es de tipo: "+temp2);
			System.out.println("****************************************************************************************************");
		}
	}
}