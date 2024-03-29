package Analizador;


public class Identificador {
	String nombre;
	String valor;
	String tipoDato;
	String tipo;
	String uso;
	String modificador;
	String alcance;
	
	public Identificador(String nombre, String valor, String tipoDato, String tipo, String uso, String modificador, int pos, String alcance) {
		super();
		this.nombre = nombre;
		this.valor = valor;
		this.tipoDato = tipoDato;
		this.tipo = tipo;
		this.uso = uso;
		this.modificador = modificador;
		this.pos = pos;
	}

	public String getAlcance() {
		return alcance;
	}


	public void setAlcance(String alcance) {
		this.alcance = alcance;
	}
	int pos;

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getTipoDato() {
		return tipoDato;
	}
	public void setTipoDato(String tipo) {
		this.tipoDato = tipo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getModificador() {
		return modificador;
	}
	public void setModificador(String modificador) {
		this.modificador = (modificador == null)?"":modificador;
	}
	public String getUso() {
		return uso;
	}
	public void setUso(String uso) {
		this.uso = uso;
	}

}
