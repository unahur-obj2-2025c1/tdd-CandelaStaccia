package ar.edu.unahur.obj2.tdd;


public class CajaFuerte {

	private Boolean abierta = true;
	private Integer clave;
	private Integer intentosFallidos = 0; //solo en abrir no pq si no se pierde la cant. El objeto tiene q saber cuantos intentos fallidos tiene
	
	public Boolean estaAbierta() {
		return abierta; //toda constante evoluciona a variable
	}

	public void cerrar(Integer clave) {
		if (this.abierta) {
			this.clave = clave;
			this.abierta = false;
		}
	}

	public void abrir(Integer clave) {
		if (this.clave.equals(clave) && !this.estaBloqueada()) { //equals es igual que ==. Tiene q ver con la igualdad de dos clases, == es de objetos
			this.abierta = true;
			this.intentosFallidos = 0;
		} else {
			this.intentosFallidos = intentosFallidos + 1;
		}
	}

	public Boolean estaBloqueada() {
		return this.intentosFallidos >= 3;
	}

}
