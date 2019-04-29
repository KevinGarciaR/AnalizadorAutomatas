package Analizador;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class OperacionesExpresion {
	 static ArrayList<String> variablesencontradas = new ArrayList<String>();
	 static String expresiontemp="";

	public OperacionesExpresion(String nombreTemp)  {
				//System.out.println("Se encontro igualdad en"+nombreTemp);
				try {
					encontrarVariables(nombreTemp);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		//System.out.println(lexer.listaexpresiones.get(0).getIdentificador());
		//System.out.println(lexer.listaexpresiones.get(0).getExpresion());
	}

	public static void encontrarVariables(String nombreTemp ) throws FileNotFoundException, IOException {
        String archivo="C:\\\\Users\\\\Power\\\\eclipse-workspace\\\\ProyectoAutomatas\\\\src\\\\Analizador\\\\prueba.txt";
		String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            if(cadena.contains(nombreTemp)==true){
            	//System.out.println(cadena);
            	//Se encuentra texto despues del =
            	String[] partes = cadena.split("=");
            	String parte1 = partes[0]; // 004
            	String parte2 = partes[1]; // 034556
                String a=parte2.replaceAll(".$", "");
            	expresiontemp=a;
            	for (int i = 0; i < lexer.tablaSimbolos.size(); i++) {
					if(cadena.contains(lexer.tablaSimbolos.get(i).getNombre())){
						System.out.println("Se encontró la variable: "+lexer.tablaSimbolos.get(i).getNombre()+" dentro de la expresion: "+nombreTemp+" con un valor de: "+lexer.tablaSimbolos.get(i).getValor());
						 String nuevaExpresion=expresiontemp.replace(lexer.tablaSimbolos.get(i).getNombre(),lexer.tablaSimbolos.get(i).getValor());
						 expresiontemp=nuevaExpresion;

					}

				}
            	System.out.println("Expresion encontrada: "+a);
				 System.out.println("Expresion reemplazada: "+expresiontemp);
				 Triplos.Arbol evaluaexp2=new Triplos.Arbol(expresiontemp);
            }
        }
        b.close();
    }


}
   

