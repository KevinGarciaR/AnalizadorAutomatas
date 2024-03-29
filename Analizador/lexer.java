/* Generated By:JavaCC: Do not edit this line. lexer.java */
package Analizador;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.ArrayList;

class lexer implements lexerConstants {
   public static HashMap<Integer,Identificador> tablaSimbolos = new HashMap<Integer,Identificador>();
   static int pos=0;
   static String modificadorTemp, tipoDatoTemp, nombreTemp, valorTemp;
   Identificador identificadores;
   static Token modificador;
   static Token tipoDato;
   static ArrayList<Expresion> listaexpresiones = new ArrayList<Expresion>();
        public static void main(String[] args) throws ParseException, FileNotFoundException
        {
                try
                {

                        lexer analizador=new lexer(new FileInputStream("C:\u005c\u005cUsers\u005c\u005cPower\u005c\u005ceclipse-workspace\u005c\u005cProyectoAutomatas\u005c\u005csrc\u005c\u005cAnalizador\u005c\u005cprueba.txt"));
                        //analizador.Start();
                        analizador.programa();
                        System.out.println("****************************************************************************************************");
                        System.out.println("La cadena fue aceptada");
                        System.out.println("Numero de Tokens:"+ tablaSimbolos.size());
                        System.out.println("****************************************************************************************************");
                System.out.println("Impresion de HashMap FINAL:");
                System.out.println("");
                        //Impresion Clase
                        int posclase=tablaSimbolos.size()-1;
                System.out.println("Linea: "+tablaSimbolos.get(posclase).getPos()+" Nombre: "+tablaSimbolos.get(posclase).getNombre()+
                                                ", Tipo: "+tablaSimbolos.get(posclase).getTipo()+
                                                ", Uso: "+tablaSimbolos.get(posclase).getUso()+
                                                ", TipoDato: "+tablaSimbolos.get(posclase).getTipoDato()+
                                                ", Modificador: "+tablaSimbolos.get(posclase).getModificador()+
                                                ", Valor: "+tablaSimbolos.get(posclase).getValor()+
                                                ", Alcance: "+tablaSimbolos.get(posclase).getAlcance());

              //Impresion de los demas Tokens
                          for ( int i = 0; i < tablaSimbolos.size()-1; i ++){
                                System.out.println("Linea: "+tablaSimbolos.get(i).getPos()+" Nombre: "+tablaSimbolos.get(i).getNombre()+
                                                ", Tipo: "+tablaSimbolos.get(i).getTipo()+
                                                ", Uso: "+tablaSimbolos.get(i).getUso()+
                                                ", TipoDato: "+tablaSimbolos.get(i).getTipoDato()+
                                                ", Modificador: "+tablaSimbolos.get(i).getModificador()+
                                                ", Valor: "+tablaSimbolos.get(i).getValor()+
                                                ", Alcance: "+tablaSimbolos.get(i).getAlcance());
                        }
                        for ( int i = 0; i < listaexpresiones.size(); i ++){
                               // System.out.println("EXPRESIONES MATEMATICAS INGRESADAS : ");
                               // System.out.println("Identificador: "+listaexpresiones.get(i).getIdentificador()+" Expresion: "+listaexpresiones.get(i).getExpresion());
                        }

                }
                catch(ParseException e)
                {

                        System.out.println(e.getMessage());
                }
        }

/*===== Operadores Logicos  ======*/
  static final public void programa() throws ParseException {
    Token nombre;
    Token modificador;
    try {
      modificador = jj_consume_token(MODIFICADOR);
      jj_consume_token(CLASS);
      nombre = jj_consume_token(IDENTIFICADOR);
      jj_consume_token(LLAVEIZQUIERDA);
      label_1:
      while (true) {
        if (jj_2_1(3)) {
          ;
        } else {
          break label_1;
        }
        sentencia();
      }
      jj_consume_token(LLAVEDERECHA);
         Identificador temp=new Identificador("","","","","","",0,"No aplica");
          temp.setTipo("Clase");
      temp.setUso("Declaracion");
      temp.setTipoDato("No Aplica");
          temp.setNombre(nombre.image);
          temp.setModificador(modificador.image);
          temp.setValor("No aplica");
          temp.setPos(modificador.beginLine);
          tablaSimbolos.put(pos,temp);
          pos++;
    } catch (ParseException e) {

    }
  }

/*M�todos para field_declaration*/
  static final public void field_declaration() throws ParseException {
    variable_declaration();
  }

  static final public void variable_declaration() throws ParseException {
    modificador = jj_consume_token(MODIFICADOR);
    tipoDato = type();
    variable_declarator();
    jj_consume_token(PUNTOYCOMA);
          Identificador tempgeneral=new Identificador("","","","","","",0,"");
          //System.out.print(tipo.image+ " ");
          //System.out.print(modificador.image+ " ");
          tipoDatoTemp=tipoDato.image;
          modificadorTemp=modificador.image;
          tempgeneral.setPos(modificador.beginLine);
          tempgeneral.setTipo("Variable");
          tempgeneral.setUso("Declaracion");
          tempgeneral.setModificador(modificadorTemp);
          tempgeneral.setTipoDato(tipoDatoTemp);
          tempgeneral.setNombre(nombreTemp);
          tempgeneral.setValor(valorTemp);
          tempgeneral.setAlcance("Global");
           Validacion val=new Validacion();
           val.checarSiExisteToken(tempgeneral);
           val.checarTipoDato(tempgeneral);
           tablaSimbolos.put(pos,tempgeneral);
           pos++;

          //System.out.println("*************");

  }

  static final public void variable_declaration_local() throws ParseException {
    modificador = jj_consume_token(MODIFICADOR);
    tipoDato = type();
    variable_declarator();
    jj_consume_token(PUNTOYCOMA);
          Identificador tempgeneral=new Identificador("","","","","","",0,"Local");
          //System.out.print(tipo.image+ " ");
          //System.out.print(modificador.image+ " ");
           tipoDatoTemp=tipoDato.image;
          modificadorTemp=modificador.image;
          tempgeneral.setPos(modificador.beginLine);
          tempgeneral.setTipo("Variable");
          tempgeneral.setUso("Declaracion");
          tempgeneral.setAlcance("Local");
          tempgeneral.setModificador(modificadorTemp);
          tempgeneral.setTipoDato(tipoDatoTemp);
          tempgeneral.setNombre(nombreTemp);
          tempgeneral.setValor(valorTemp);
           Validacion val=new Validacion();
           val.checarSiExisteToken(tempgeneral);
           val.checarTipoDato(tempgeneral);
           tablaSimbolos.put(pos,tempgeneral);
           pos++;

          //System.out.println("*************");

  }

  static final public Token type() throws ParseException {
        Token tipo;
    tipo = jj_consume_token(TIPODATO);
          {if (true) return tipo;}
    throw new Error("Missing return statement in function");
  }

  static final public void variable_declarator() throws ParseException {
  Token identificador;
  Token valor=null;
  Token valorexpresion=null;
    identificador = jj_consume_token(IDENTIFICADOR);
    jj_consume_token(ASIGNACION);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER_LITERAL:
      valor = jj_consume_token(INTEGER_LITERAL);
      break;
    case BOOLEAN_LITERAL:
      valor = jj_consume_token(BOOLEAN_LITERAL);
      break;
    case DOUBLE_LITERAL:
      valor = jj_consume_token(DOUBLE_LITERAL);
      break;
    case STRING_LITERAL:
      valor = jj_consume_token(STRING_LITERAL);
      break;
    case EXPRESION_REGULAR:
      valorexpresion = jj_consume_token(EXPRESION_REGULAR);
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
           //System.out.print(identificador.image + " ");
           //System.out.print(valor.image + " ");
           nombreTemp=identificador.image;
           if(valor==null) {
           valorTemp=valorexpresion.image;
           try {
    Triplos.Arbol evaluaexp=new Triplos.Arbol(valorTemp);
       } catch (Exception e) {
           System.out.println("Se encontraron variables dentro de la expresion: "+nombreTemp);
           OperacionesExpresion oe=new OperacionesExpresion(nombreTemp);
}

           Expresion exptemp=new Expresion();
           exptemp.setIdentificador(nombreTemp);
           exptemp.setExpresion(valorTemp);
           listaexpresiones.add(exptemp);

           }else{
         valorTemp=valor.image;
           }
  }

  static final public void modificacion_variable() throws ParseException {
  Token identificador;
  Token valor;
    identificador = jj_consume_token(IDENTIFICADOR);
    jj_consume_token(ASIGNACION);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER_LITERAL:
      valor = jj_consume_token(INTEGER_LITERAL);
      break;
    case BOOLEAN_LITERAL:
      valor = jj_consume_token(BOOLEAN_LITERAL);
      break;
    case DOUBLE_LITERAL:
      valor = jj_consume_token(DOUBLE_LITERAL);
      break;
    case STRING_LITERAL:
      valor = jj_consume_token(STRING_LITERAL);
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(PUNTOYCOMA);
        String identificadorvar=identificador.image;
        String valorvar=valor.image;
        Validacion val=new Validacion();
        val.asignarvariabledentro(identificadorvar,valorvar, identificador.beginLine);
  }

/*Metodos para sentencia*/
  static final public void sentencia() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MODIFICADOR:
      variable_declaration();
      break;
    case IF:
      if_todo();
      break;
    case WHILE:
      while_sentencia();
      break;
    case IDENTIFICADOR:
      modificacion_variable();
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void sentencia_local() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MODIFICADOR:
      variable_declaration_local();
      break;
    case IF:
      if_todo();
      break;
    case WHILE:
      while_sentencia();
      break;
    case IDENTIFICADOR:
      modificacion_variable();
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void if_todo() throws ParseException {
    jj_consume_token(IF);
    if_sentencia();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ELSEIF:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_2;
      }
      else_if_sentencia();
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ELSE:
      else_sentencia();
      break;
    default:
      jj_la1[5] = jj_gen;
      ;
    }
  }

  static final public void if_sentencia() throws ParseException {
    jj_consume_token(PARENTESISIZQUIERDO);
    expression();
    jj_consume_token(PARENTESISDERECHO);
    jj_consume_token(LLAVEIZQUIERDA);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MODIFICADOR:
      case IF:
      case WHILE:
      case IDENTIFICADOR:
        ;
        break;
      default:
        jj_la1[6] = jj_gen;
        break label_3;
      }
      sentencia_local();
    }
    jj_consume_token(LLAVEDERECHA);
  }

  static final public void else_sentencia() throws ParseException {
    jj_consume_token(ELSE);
    jj_consume_token(LLAVEIZQUIERDA);
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MODIFICADOR:
      case IF:
      case WHILE:
      case IDENTIFICADOR:
        ;
        break;
      default:
        jj_la1[7] = jj_gen;
        break label_4;
      }
      sentencia_local();
    }
    jj_consume_token(LLAVEDERECHA);
  }

  static final public void else_if_sentencia() throws ParseException {
    jj_consume_token(ELSEIF);
    if_sentencia();
  }

  static final public void while_sentencia() throws ParseException {
    jj_consume_token(WHILE);
    jj_consume_token(PARENTESISIZQUIERDO);
    expression();
    jj_consume_token(PARENTESISDERECHO);
    jj_consume_token(LLAVEIZQUIERDA);
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MODIFICADOR:
      case IF:
      case WHILE:
      case IDENTIFICADOR:
        ;
        break;
      default:
        jj_la1[8] = jj_gen;
        break label_5;
      }
      sentencia_local();
    }
    jj_consume_token(LLAVEDERECHA);
  }

  static final public void expression() throws ParseException {
    testing_expression();
  }

  static final public void testing_expression() throws ParseException {
   Token nombrecomparacion1=null;
   Token nombrecomparacion2=null;
   Token expresion;
   Token valor1=null;
   Token valor2=null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER_LITERAL:
      valor1 = jj_consume_token(INTEGER_LITERAL);
      break;
    case IDENTIFICADOR:
      nombrecomparacion1 = jj_consume_token(IDENTIFICADOR);
      break;
    case DOUBLE_LITERAL:
      valor1 = jj_consume_token(DOUBLE_LITERAL);
      break;
    case BOOLEAN_LITERAL:
      valor1 = jj_consume_token(BOOLEAN_LITERAL);
      break;
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    expresion = jj_consume_token(EXPRESION);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER_LITERAL:
      valor2 = jj_consume_token(INTEGER_LITERAL);
      break;
    case IDENTIFICADOR:
      nombrecomparacion2 = jj_consume_token(IDENTIFICADOR);
      break;
    case DOUBLE_LITERAL:
      valor2 = jj_consume_token(DOUBLE_LITERAL);
      break;
    case BOOLEAN_LITERAL:
      valor2 = jj_consume_token(BOOLEAN_LITERAL);
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
         Identificador tempgeneral=new Identificador("","","","","","",0,"");

     Validacion val=new Validacion();
         if(nombrecomparacion1==null && nombrecomparacion2==null) {
         String a=valor1.image;
     String b=valor2.image;
     tempgeneral.setPos(valor1.beginLine);
     val.checarComparacionValores(a,b, valor1.beginLine);
         }
         if(nombrecomparacion1!=null && nombrecomparacion2==null) {
         String valtemp=nombrecomparacion1.image;
         String valtemp2=valor2.image;
         tempgeneral.setPos(nombrecomparacion1.beginLine);
     val.obtenerDatoComparacion(valtemp,valtemp2, nombrecomparacion1.beginLine);
         }
         if(nombrecomparacion1==null && nombrecomparacion2!=null) {
          String valtemp=nombrecomparacion2.image;
         String valtemp2=valor1.image;
         tempgeneral.setPos(nombrecomparacion2.beginLine);
         val.obtenerDatoComparacion2(valtemp,valtemp2,nombrecomparacion2.beginLine);
         }
     if(nombrecomparacion1!=null && nombrecomparacion2!=null) {
          String valtemp=nombrecomparacion1.image;
         String valtemp2=nombrecomparacion2.image;
         tempgeneral.setPos(nombrecomparacion1.beginLine);
         val.obtenerDatoComparacion3(valtemp,valtemp2, nombrecomparacion1.beginLine);
         }

         if(nombrecomparacion1!=null) {
     tempgeneral.setNombre(nombrecomparacion1.image);
     tempgeneral.setTipo("Variable");
     tempgeneral.setTipoDato("Comparacion: "+expresion.image+"  ");
         }else {
     tempgeneral.setNombre("No hay variables");
     tempgeneral.setTipoDato("Comparacion: "  +expresion.image+"  ");
         }
     tempgeneral.setUso("Comparacion");



     //System.out.println(a);

            //val.checarComparacionValores(a,b);

     tablaSimbolos.put(pos,tempgeneral);
         pos++;
  }

  static private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_3R_12() {
    if (jj_scan_token(IF)) return true;
    if (jj_3R_17()) return true;
    return false;
  }

  static private boolean jj_3R_10() {
    if (jj_3R_14()) return true;
    return false;
  }

  static private boolean jj_3R_18() {
    if (jj_3R_19()) return true;
    return false;
  }

  static private boolean jj_3R_11() {
    if (jj_scan_token(MODIFICADOR)) return true;
    if (jj_3R_15()) return true;
    if (jj_3R_16()) return true;
    return false;
  }

  static private boolean jj_3_1() {
    if (jj_3R_6()) return true;
    return false;
  }

  static private boolean jj_3R_19() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(25)) {
    jj_scanpos = xsp;
    if (jj_scan_token(29)) {
    jj_scanpos = xsp;
    if (jj_scan_token(27)) {
    jj_scanpos = xsp;
    if (jj_scan_token(26)) return true;
    }
    }
    }
    return false;
  }

  static private boolean jj_3R_14() {
    if (jj_scan_token(IDENTIFICADOR)) return true;
    if (jj_scan_token(ASIGNACION)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(25)) {
    jj_scanpos = xsp;
    if (jj_scan_token(26)) {
    jj_scanpos = xsp;
    if (jj_scan_token(27)) {
    jj_scanpos = xsp;
    if (jj_scan_token(28)) return true;
    }
    }
    }
    return false;
  }

  static private boolean jj_3R_13() {
    if (jj_scan_token(WHILE)) return true;
    if (jj_scan_token(PARENTESISIZQUIERDO)) return true;
    if (jj_3R_18()) return true;
    return false;
  }

  static private boolean jj_3R_6() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_7()) {
    jj_scanpos = xsp;
    if (jj_3R_8()) {
    jj_scanpos = xsp;
    if (jj_3R_9()) {
    jj_scanpos = xsp;
    if (jj_3R_10()) return true;
    }
    }
    }
    return false;
  }

  static private boolean jj_3R_7() {
    if (jj_3R_11()) return true;
    return false;
  }

  static private boolean jj_3R_8() {
    if (jj_3R_12()) return true;
    return false;
  }

  static private boolean jj_3R_16() {
    if (jj_scan_token(IDENTIFICADOR)) return true;
    return false;
  }

  static private boolean jj_3R_15() {
    if (jj_scan_token(TIPODATO)) return true;
    return false;
  }

  static private boolean jj_3R_17() {
    if (jj_scan_token(PARENTESISIZQUIERDO)) return true;
    if (jj_3R_18()) return true;
    return false;
  }

  static private boolean jj_3R_9() {
    if (jj_3R_13()) return true;
    return false;
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public lexerTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[11];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x1e001000,0x1e000000,0x20000920,0x20000920,0x400,0x200,0x20000920,0x20000920,0x20000920,0x2e000000,0x2e000000,};
   }
  static final private JJCalls[] jj_2_rtns = new JJCalls[1];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

  /** Constructor with InputStream. */
  public lexer(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public lexer(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new lexerTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public lexer(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new lexerTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public lexer(lexerTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(lexerTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  static final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[30];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 11; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 30; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  static private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 1; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
