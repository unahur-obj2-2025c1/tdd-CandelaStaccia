package ar.edu.unahur.obj2.tdd;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CajaFuerteTest {
	private CajaFuerte caja = new CajaFuerte();
	
	@Test
	public void queLaCajaFuerteEsteAbiertaAlCrearla() {
		//CajaFuerte caja = new CajaFuerte();//ejecucion
		
		assertTrue(caja.estaAbierta()); //contrastacion
	}
	
	@Test
	public void queSePuedaCerrarLaCajaFuerteConUnCodigo() {
		//CajaFuerte caja = new CajaFuerte();//ejecucion
		
		caja.cerrar(1234);
		assertFalse(caja.estaAbierta()); //contrastacion
	}
	
	@Test
	public void queSePuedaAbrirLaCajaFuerteConElCodigoCorrecto() {
		//CajaFuerte caja = new CajaFuerte();//ejecucion
		
		caja.cerrar(1234);
		caja.abrir(1234);
		
		assertTrue(caja.estaAbierta()); //contrastacion
	}
	
	@Test
	public void queNoSeAbreLaCajaFuerteConElCodigoIncorrecto() {
		//CajaFuerte caja = new CajaFuerte();//ejecucion
		
		caja.cerrar(1234);
		caja.abrir(4321);
		
		assertFalse(caja.estaAbierta()); //contrastacion
	}
	
	@Test
	public void queNoSePuedeCambiarElCodigoUnaVezCerradaLaCajaFuerte() {
		//CajaFuerte caja = new CajaFuerte();//ejecucion
		
		caja.cerrar(1234);
		caja.cerrar(5678); //no entra, no lo hace
		caja.abrir(1234);
		
		assertTrue(caja.estaAbierta()); //contrastacion
	}
	
	@Test
	public void queSeBloqueaLuegoDeTresIntentosFallidos() {
		//CajaFuerte caja = new CajaFuerte();//ejecucion
		
		caja.cerrar(1234);
		caja.abrir(2345);
		caja.abrir(3456);
		caja.abrir(4567);
		
		assertTrue(caja.estaBloqueada()); //contrastacion
	}
	
	@Test
	public void queLuegoDeBloqueadaNoPuedaAbrirConClaveCorrecta() {
		//CajaFuerte caja = new CajaFuerte();//ejecucion
		
		caja.cerrar(1234);
		caja.abrir(2345);
		caja.abrir(3456);
		caja.abrir(4567);
		
		caja.abrir(1234);
		
		assertFalse(caja.estaAbierta());
		assertTrue(caja.estaBloqueada()); //contrastacion
	}
	
	@Test
	public void queSeReseteanLosIntentosFallidosTrasAperturaCorrecta() {
		//CajaFuerte caja = new CajaFuerte();//ejecucion
		
		caja.cerrar(1234);
		caja.abrir(2345);
		caja.abrir(3456);
		
		caja.abrir(1234);
		caja.cerrar(5678);
		caja.abrir(4567);
		
		assertFalse(caja.estaBloqueada()); //contrastacion
	}
}
