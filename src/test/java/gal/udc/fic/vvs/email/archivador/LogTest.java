package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class LogTest {
	
	private Log log;
	private Archivador decorado;
	
	private Mensaje mensaje;
	private Texto texto;
	
	private static final String NOMBRE_DECORADO = "EjemploDecorado";

	private static final int ESPACIO_ARCHIVADOR = 10;
	
	@Before
	public void crearDatos()
	{
		decorado = new ArchivadorSimple(NOMBRE_DECORADO, ESPACIO_ARCHIVADOR);
		log = new Log(decorado);
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba la recuperación del nombre del decorado de un Log.
	 */
	@Test
	public void obtenerNombreTest() {
		assertEquals(NOMBRE_DECORADO, log.obtenerNombre());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba el almacenamiento de un correo en el decorado de un Log
	 *  en caso de que el espacio disponible sea suficiente.
	 */
	@Test
	public void almacenarCorreoTest() {
		texto = new Texto("EjemploTexto", "Hola!");
		mensaje = new Mensaje(texto);
		
		assertTrue(log.almacenarCorreo(mensaje));
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba el almacenamiento de un correo en el decorado de un Log
	 *  en caso de que el espacio disponible NO sea suficiente.
	 */
	@Test
	public void almacenarCorreoEspacioInsuficienteTest() {
		texto = new Texto("EjemploTexto", "Hola mundo!");
		mensaje = new Mensaje(texto);
		
		assertFalse(log.almacenarCorreo(mensaje));
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba la recuperación del espacio disponible del decorado de un Log.
	 */
	@Test
	public void obtenerEspacioDisponibleTest() {
		texto = new Texto("EjemploTexto", "cinco");
		mensaje = new Mensaje(texto);
		log.almacenarCorreo(mensaje);
		
		assertEquals(5, log.obtenerEspacioDisponible());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba la recuperación del espacio total del decorado de un Log.
	 */
	@Test
	public void obtenerEspacioTotalTest() {
		assertEquals(ESPACIO_ARCHIVADOR, log.obtenerEspacioTotal());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba la recuperación de un delegado del decorado de un Log.
	 */
	@Test
	public void obtenerDelegadoTest() {
		assertNull(log.obtenerDelegado());
	}

	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba si se establece un delegado en un Log.
	 */
	@Test
	public void establecerDelegadoTest() {
		Archivador delegado = new Delegado(decorado);
		log.establecerDelegado(delegado);
		
		assertEquals(delegado.obtenerNombre(), log.obtenerNombre());
	}
	
	
}
