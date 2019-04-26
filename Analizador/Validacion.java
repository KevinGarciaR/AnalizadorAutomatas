package Analizador;

public class Validacion {

	static public void checarSiExisteToken(Identificador variable) {
		for (int j = 0; j < lexer.tablaSimbolos.size(); j++) {
			if(lexer.tablaSimbolos.get(j).getNombre().equals(variable.getNombre())) {
				System.out.println("****************************************************************************************************");
				System.out.println("Linea: "+variable.getPos()+" Error: La variable "+variable.getNombre()+" ya habia sido declarada con un tipo: "+lexer.tablaSimbolos.get(j).getTipoDato());
			}
		}	

	}

	static public void checarTipoDato(Identificador variable) {
		String tipoDato=variable.getTipoDato();
		String valor=variable.getValor();
		if(tipoDato.equals("int")){
			try {
				if(valor.contains("(") || valor.contains(")") || valor.contains("+") || valor.contains("-") || valor.contains("*") || valor.contains("/")) {
					//System.out.println("Evaluando operacion");
				}else {
					Integer.parseInt(valor);
				}				
			} catch (Exception e) {
				System.out.println("****************************************************************************************************");
				System.out.println("Linea: "+variable.getPos()+" error en el Identificador "+variable.getNombre()+",puesto que este valor no es Entero(Int) - Debes utilizar el Tipo de Dato: "+variable.getTipoDato());
			}
		}
		if(tipoDato.equals("double")) {
			try {
				if(valor.contains("(") || valor.contains(")") || valor.contains("+") || valor.contains("-") || valor.contains("*") || valor.contains("/")) {
					//System.out.println("Evaluando operacion");
				}else {
					Double.parseDouble(valor);
				}				
			} catch (Exception e) {
				System.out.println("****************************************************************************************************");
				System.out.println("Linea: "+variable.getPos()+" error en el Identificador "+variable.getNombre()+",puesto que este valor no es Double- Debes utilizar el Tipo de Dato: "+variable.getTipoDato());

			}
		}
		if(tipoDato.equals("string")){
			try {
				if(valor.startsWith("")&&valor.endsWith("\"")) {
					// System.out.println("String valido");
				}else {
					System.out.println("****************************************************************************************************");
					System.out.println("Linea: "+variable.getPos()+" error en el Identificador "+variable.getNombre()+" puesto que este no es un string debes utilizar comillas dobles: "+"\"Cadena de Ejemplo\"");
				}
			} catch (Exception e) {
				System.out.println("Error en la linea "+variable.getPos()+" de tipo: "+e.getMessage());
			}

		}

		if(tipoDato.equals("boolean")) {
			if (valor.equals("true") || valor.equals("false")) {
				//System.out.println("Booleano correcto");
			}else {
				System.out.println("****************************************************************************************************");
				System.out.println("Linea: "+variable.getPos()+" error en el Identificador "+variable.getNombre()+" puesto que este no es un Boolean debes utilizar: "+"true, false");
			}
		}

	}

	static public void checarComparacionValores(String a, String b, int linea) {
		try {
			if(!a.isEmpty() && !b.isEmpty()) {
				try {
					if(esEntero(a)==true && esEntero(b)==true) {
						//System.out.println("Los dos son Entero");
					}else if(esDoble(a)==true && esDoble(b)==true) {
						//System.out.println("Los dos son Double");
					}else {
						System.out.println("Linea: "+linea+" error en tipo de dato");
					}
				} catch (Exception e) {
					System.out.println("Linea: "+linea+ "error"+e.getMessage());
				}
			}
		} catch (Exception e) {
			System.out.println("Linea: "+linea+" error"+e.getMessage());
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


	public static void obtenerDatoComparacion(String a, String b, int linea) {
		//System.out.println(a);
		//System.out.println(b);

		String temp1="";
		for (int j = 0; j < lexer.tablaSimbolos.size(); j++) {
			if(lexer.tablaSimbolos.get(j).getNombre().equals(a)) {
				temp1=lexer.tablaSimbolos.get(j).getTipoDato();
			}
		}
		if(temp1.isEmpty()) {
			System.out.println("Linea: "+linea+" error: la variable "+a+" no esta declarada");
			System.out.println("****************************************************************************************************");
		}
		for (int j = 0; j < lexer.tablaSimbolos.size(); j++) {
			if(lexer.tablaSimbolos.get(j).getNombre().equals(a)) {
				System.out.println("****************************************************************************************************");
				if(esEntero(b)==true && lexer.tablaSimbolos.get(j).getTipoDato().equals("int")) {
					System.out.println("Linea: "+linea+" comparacion valida "+lexer.tablaSimbolos.get(j).getTipoDato());
				}else if(esDoble(b)==true && lexer.tablaSimbolos.get(j).getTipoDato().equals("double")){
					System.out.println("Linea: "+linea+" comparacion valida "+lexer.tablaSimbolos.get(j).getTipoDato());
				}else if(esBooleano(b)==true && lexer.tablaSimbolos.get(j).getTipoDato().equals("boolean")){
					System.out.println("Linea: "+linea+" comparacion valida "+lexer.tablaSimbolos.get(j).getTipoDato());
				}else {
					System.out.println("Linea: "+linea+" error: comparacion invalida: "+b+" no es de tipo: "+lexer.tablaSimbolos.get(j).getTipoDato());

					
				}
				System.out.println("La variable "+a+" es de tipo: "+lexer.tablaSimbolos.get(j).getTipoDato());
				System.out.println("****************************************************************************************************");
			}
		}
	}

	public static void obtenerDatoComparacion2(String a, String b,int linea) {
		//System.out.println(a);
		//System.out.println(b);
		String temp1="";
		for (int j = 0; j < lexer.tablaSimbolos.size(); j++) {
			if(lexer.tablaSimbolos.get(j).getNombre().equals(a)) {
				temp1=lexer.tablaSimbolos.get(j).getTipoDato();
			}
		}
		if(temp1.isEmpty()) {
			System.out.println("Linea: "+linea+" error: la variable "+a+" no esta declarada");
			System.out.println("****************************************************************************************************");
		}
		for (int j = 0; j < lexer.tablaSimbolos.size(); j++) {
			if(lexer.tablaSimbolos.get(j).getNombre().equals(a)) {
				System.out.println("****************************************************************************************************");
				
				if(esEntero(b)==true && lexer.tablaSimbolos.get(j).getTipoDato().equals("int")) {
					System.out.println("Linea: "+linea+" comparacion valida "+lexer.tablaSimbolos.get(j).getTipoDato());
				}else if(esDoble(b)==true && lexer.tablaSimbolos.get(j).getTipoDato().equals("double")){
					System.out.println("Linea: "+linea+" comparacion valida "+lexer.tablaSimbolos.get(j).getTipoDato());
				}else if(esBooleano(b)==true && lexer.tablaSimbolos.get(j).getTipoDato().equals("boolean")){
					System.out.println("Linea: "+linea+" comparacion valida "+lexer.tablaSimbolos.get(j).getTipoDato());
				}else {
					System.out.println("Linea: "+linea+" error: comparacion invalida: "+b+" no es de tipo: "+lexer.tablaSimbolos.get(j).getTipoDato());
				}
				System.out.println("La variable "+a+" es de tipo: "+lexer.tablaSimbolos.get(j).getTipoDato());
				System.out.println("****************************************************************************************************");
			}
		}	

	}

	public static void obtenerDatoComparacion3(String a, String b, int linea) {
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
			System.out.println("Linea: "+linea+" error: la variable "+a+" no esta declarada");
			System.out.println("****************************************************************************************************");
		}
		if(temp2.isEmpty()) {
			System.out.println("Linea: "+linea+" error: la variable "+b+" no esta declarada");
			System.out.println("****************************************************************************************************");
		}
		if(!temp1.isEmpty() && !temp2.isEmpty() && !temp1.equals(temp2)) {
			System.out.println("****************************************************************************************************");
			System.out.println("Linea: "+linea+" error: las variables: "+a+" y "+b+" no son del mismo tipo");
			System.out.println("La variable: "+a+" es de tipo: "+temp1);
			System.out.println("La variable: "+b+" es de tipo: "+temp2);
			System.out.println("****************************************************************************************************");
		}
	}


	static public void checarTipoDatoenAsignacion(String tipoDato, String valor, String identificador, int linea) {
		if(tipoDato.equals("int")){
			try {
				Integer.parseInt(valor);
				for (int j = 0; j < lexer.tablaSimbolos.size(); j++) {
					if(lexer.tablaSimbolos.get(j).getNombre().equals(identificador)) {
						lexer.tablaSimbolos.get(j).setValor(valor);
					}
				}
			} catch (Exception e) {
				System.out.println("****************************************************************************************************");
				System.out.println("Linea: "+linea+" IMPOSIBLE DE ASIGNAR: Error en el Identificador "+identificador+",puesto que este valor no es Entero(Int) - Debes utilizar el Tipo de Dato: "+tipoDato);
			}
		}
		if(tipoDato.equals("double")) {
			try {
				Double.parseDouble(valor);
				for (int j = 0; j < lexer.tablaSimbolos.size(); j++) {
					if(lexer.tablaSimbolos.get(j).getNombre().equals(identificador)) {
						lexer.tablaSimbolos.get(j).setValor(valor);
					}
				}
			} catch (Exception e) {
				System.out.println("****************************************************************************************************");
				System.out.println("Linea: "+linea+" IMPOSIBLE DE ASIGNAR: Error en el Identificador "+identificador+",puesto que este valor no es Double- Debes utilizar el Tipo de Dato: "+tipoDato);

			}
		}
		if(tipoDato.equals("string")){
			try {
				if(valor.startsWith("")&&valor.endsWith("\"")) {
					// System.out.println("String valido");
					for (int j = 0; j < lexer.tablaSimbolos.size(); j++) {
						if(lexer.tablaSimbolos.get(j).getNombre().equals(identificador)) {
							lexer.tablaSimbolos.get(j).setValor(valor);
						}
					}
				}else {
					System.out.println("****************************************************************************************************");
					System.out.println("Linea: "+linea+" IMPOSIBLE DE ASIGNAR: Error en el Identificador "+identificador+" puesto que este no es un string debes utilizar comillas dobles: "+"\"Cadena de Ejemplo\"");
				}
			} catch (Exception e) {
				System.out.println("Linea: "+linea+" error: "+e.getMessage());
			}

		}

		if(tipoDato.equals("boolean")) {
			if (valor.equals("true") || valor.equals("false")) {
				//System.out.println("Booleano correcto");
				for (int j = 0; j < lexer.tablaSimbolos.size(); j++) {
					if(lexer.tablaSimbolos.get(j).getNombre().equals(identificador)) {
						lexer.tablaSimbolos.get(j).setValor(valor);
					}
				}
			}else {
				System.out.println("****************************************************************************************************");
				System.out.println("Linea: "+linea+" IMPOSIBLE DE ASIGNAR: Error en el Identificador "+identificador+" puesto que intentaste asignar un valor NO BOOLEANO, debes utilizar: "+"true, false");
			}
		}

	}

	public static void asignarvariabledentro(String identificador, String valor, int linea) {
		//System.out.println(identificador);
		//System.out.println(valor);
		String temp1;
		boolean bandera=false;
		for (int j = 0; j < lexer.tablaSimbolos.size(); j++) {
			if(lexer.tablaSimbolos.get(j).getNombre().equals(identificador)) {
				bandera=true;
				temp1=lexer.tablaSimbolos.get(j).getTipoDato();
				checarTipoDatoenAsignacion(temp1, valor, identificador, linea);
				if(esBooleano(valor)==true && temp1.equals("boolean")) {
					System.out.println("****************************************************************************************************");
					System.out.println("Linea: "+linea+"  asignación booleana correcta en: "+identificador);
				}else if(esEntero(valor)==true && temp1.equals("int")){
					System.out.println("****************************************************************************************************");
					System.out.println("Linea: "+linea+"  asignación int correcta en: "+identificador);
				}else if(esDoble(valor)==true && temp1.equals("double")){
					System.out.println("****************************************************************************************************");
					System.out.println("Linea: "+linea+"  asignación double correcta en: "+identificador);
				}
			}

		}
		if(bandera==false) {
			System.out.println("****************************************************************************************************");
			System.out.println("Linea: "+linea+" error: la variable: "+identificador+" no se encuentra declarada y no se puede asignar");
		}
	}
}