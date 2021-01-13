package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class DelegadoTest {

	private Delegado delegado;
	private  Archivador decorado;
	private  Archivador archivadorDelegado;
	
	private Mensaje mensaje;
	private Texto texto;
	
	private static final String NOMBRE_DECORADO = "EjemploDecorado";
	private static final String NOMBRE_DELEGADO = "EjemploDelegado";
	private static final int ESPACIO_ARCHIVADOR = 10;
	
	@Before
	public void crearDatos() {
		decorado = new ArchivadorSimple(NOMBRE_DECORADO, ESPACIO_ARCHIVADOR);
		archivadorDelegado = new ArchivadorSimple(NOMBRE_DELEGADO, ESPACIO_ARCHIVADOR*2);
		
		delegado = new Delegado(decorado);
		delegado.establecerDelegado(archivadorDelegado);
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba el almacenamiento de un correo en un Delegado
	 *  en caso de que el espacio disponible del decorado sea suficiente
	 */
	@Test
	public void almacenarCorreoTest() {
		texto = new Texto("EjemploTexto", "Hola!");
		mensaje = new Mensaje(texto);
		
		assertTrue(delegado.almacenarCorreo(mensaje));
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba el almacenamiento de un correo en un Delegado
	 *  en caso de que el espacio disponible con el delegado sea suficiente
	 */
	@Test
	public void almacenarCorreoEspacioSuficienteEnDecoradoTest() {
		texto = new Texto("EjemploTexto", "Hola mundo!");
		mensaje = new Mensaje(texto);
		
		assertTrue(delegado.almacenarCorreo(mensaje));
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba el almacenamiento de un correo en un Delegado
	 *  en caso de que el espacio total disponible NO sea suficiente.
	 */
	@Test
	public void almacenarCorreoEspacioInsuficienteTest() {
		texto = new Texto("EjemploTexto", "Hola mundo! El espacio ahora es insuficiente");
		mensaje = new Mensaje(texto);
		
		assertFalse(delegado.almacenarCorreo(mensaje));
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba si se establece un delegado en un Delegado.
	 */
	@Test
	public void establecerDelegadoTest() {
		Archivador aux = new ArchivadorSimple("ArchivadorAux", ESPACIO_ARCHIVADOR);
		delegado.establecerDelegado(aux);
		
		assertEquals("ArchivadorAux", delegado.obtenerDelegado().obtenerNombre());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba si se obtiene un delegado en un Delegado.
	 */
	@Test
	public void obtenerDelegadoTest() {
		assertEquals(NOMBRE_DELEGADO, this.delegado.obtenerDelegado().obtenerNombre());
	}
}
