package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class ArchivadorSimpleTest {
	
	private ArchivadorSimple archivadorSimple;
	private Mensaje mensaje;
	private Texto texto;
	
	private static final String NOMBRE_ARCHIVADOR = "EjemploArchivador";
	private static final int ESPACIO_ARCHIVADOR = 10;
	
	
	@Before
	public void crearDatos(){
		archivadorSimple = new ArchivadorSimple(NOMBRE_ARCHIVADOR, ESPACIO_ARCHIVADOR);
	}
	
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *   
	 *  Prueba la recuperación del nombre de un ArchivadorSimple.
	 */
	@Test
	public void obtenerNombreTest() {
		assertEquals(NOMBRE_ARCHIVADOR, archivadorSimple.obtenerNombre());
	}
	
	/** 
	 * 	Test de unidad.
	 *  
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba el almacenamiento de un correo en un ArchivadorSimple
	 *  en caso de que el espacio disponible sea suficiente.
	 */
	@Test
	public void almacenarCorreoTest() {
		texto = new Texto("EjemploTexto", "Hola!");
		mensaje = new Mensaje(texto);
		
		assertTrue(archivadorSimple.almacenarCorreo(mensaje));
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 * 
	 *  Prueba el almacenamiento de un correo en un ArchivadorSimple.
	 *  en caso de que el espacio disponible NO sea suficiente.
	 */
	@Test
	public void almacenarCorreoEspacioInsuficienteTest() {
		texto = new Texto("EjemploTexto", "Hola mundo!");
		mensaje = new Mensaje(texto);
		
		assertFalse(archivadorSimple.almacenarCorreo(mensaje));
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra
	 * 
	 *  Prueba la recuperación del espacio total de un ArchivadorSimple.
	 */
	@Test
	public void obtenerEspacioTotalTest() {
		assertEquals(ESPACIO_ARCHIVADOR, archivadorSimple.obtenerEspacioTotal());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 * 
	 *  Prueba la recuperación del espacio disponible de un ArchivadorSimple.
	 */
	@Test
	public void obtenerEspacioDisponibleTest() {
		texto = new Texto("EjemploTexto", "cinco");
		mensaje = new Mensaje(texto);
		archivadorSimple.almacenarCorreo(mensaje);
		
		assertEquals(5, archivadorSimple.obtenerEspacioDisponible());
	}
	
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 * 
	 *  Prueba la recuperación del espacio total de un ArchivadorSimple.
	 */
	@Test
	public void obtenerDelegadoTest() {
		assertNull(archivadorSimple.obtenerDelegado());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba cómo se establece un delegado en un ArchivadorSimple.
	 */
	@Test
	public void establecerDelegadoTest() {
		ArchivadorSimple delegado = new ArchivadorSimple("EjemploDelegado", ESPACIO_ARCHIVADOR);
		archivadorSimple.establecerDelegado(delegado);
		
		assertNull(archivadorSimple.obtenerDelegado());
	}
	
}
