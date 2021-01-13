package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class ReenvioTest {
	
	private Reenvio reenvio;
	private Mensaje mensaje;
	private Texto texto;
	
	private static String NOMBRE_TEXTO = "EjemploTexto";
	private static String CONTENIDO_TEXTO = "Contenido del texto";
	
	
	// Tamaño establecido en la clase Mensaje
	private final static int TAMAÑO_PREVISUALIZACION = 32;
	
	private String previsualizacion() {
		return CONTENIDO_TEXTO.substring(0, Math.min(CONTENIDO_TEXTO.length(),
						TAMAÑO_PREVISUALIZACION)) + "...";
	}
	
	private String visualizacion() {
		return CONTENIDO_TEXTO + "\n\n---- Correo reenviado ----\n\n" + 
				CONTENIDO_TEXTO + "\n---- Fin correo reenviado ----";
	}
	
	private String previsualizacionPadre() {
		return "Soy el padre... > Contenido del texto...";
	}
	
	@Before
	public void crearDatos(){
		texto = new Texto(NOMBRE_TEXTO, CONTENIDO_TEXTO);
		mensaje = new Mensaje(texto);
		reenvio = new Reenvio(mensaje, mensaje);
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba si un reenvio obtiene la ruta cuando NO tiene padre.
	 */
	@Test
	public void obtenerRutaSinPadreTest() {
		assertEquals(previsualizacion(), reenvio.obtenerRuta());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba si un reenvio obtiene la ruta cuando tiene padre.
	 * @throws OperacionInvalida 
	 */
	@Test
	public void obtenerRutaPadreTest() throws OperacionInvalida {
		Mensaje padre = new Mensaje(new Texto("EjemploPadre", "Soy el padre"));
		reenvio.establecerPadre(padre);
		assertEquals(previsualizacionPadre(), reenvio.obtenerRuta());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba la exploración e inserción de un correo (operación inválida)
	 * @throws OperacionInvalida 
	 */
	@Test(expected = OperacionInvalida.class)
	public void explorarTest() throws OperacionInvalida {
		reenvio.añadir(mensaje);		
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba eliminar un correo (operación inválida)
	 * @throws OperacionInvalida 
	 */
	@Test(expected = OperacionInvalida.class)
	public void eliminarTest() throws OperacionInvalida {
		reenvio.eliminar(mensaje);		
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba añadir un correo (operación inválida)
	 * @throws OperacionInvalida 
	 */
	@Test(expected = OperacionInvalida.class)
	public void añadirTest() throws OperacionInvalida {
		reenvio.añadir(mensaje);		
	}

	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba la obtención del hijo de un correo (operación inválida)
	 * @throws OperacionInvalida 
	 */
	@Test(expected = OperacionInvalida.class)
	public void obtenerHijoTest() throws OperacionInvalida {
		reenvio.obtenerHijo(0);
	}

	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba si un reenvio y sus hijos se marcan como leídos y se recupera.
	 * @throws OperacionInvalida 
	 */
	@Test
	public void establecerYObtenerLeidoTest() throws OperacionInvalida {
		reenvio.establecerLeido(true);
		assertEquals(0, reenvio.obtenerNoLeidos());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba si un reenvio y sus hijos se recuperan como NO leído.
	 * @throws OperacionInvalida 
	 */
	@Test
	public void obtenerNoLeidoTest() throws OperacionInvalida {
		assertEquals(1, reenvio.obtenerNoLeidos());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba si un reenvio recupera el tamaño de sus hijos.
	 * @throws OperacionInvalida 
	 */
	@Test
	public void obtenerTamañoTest() throws OperacionInvalida {
		assertEquals(CONTENIDO_TEXTO.length()*2, reenvio.obtenerTamaño());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba si un reenvio recupera el icono
	 */
	@Test
	public void obtenerIconoTest() {
		assertEquals(Correo.ICONO_NUEVO_MENSAJE, reenvio.obtenerIcono());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba la recuperación de la visualización de un reenvio.
	 * @throws OperacionInvalida 
	 */
	@Test
	public void obtenerVisualizacionTest() throws OperacionInvalida {
		assertEquals(visualizacion(), reenvio.obtenerVisualizacion());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba la recuperación de la previsualización de un reenvio.
	 * @throws OperacionInvalida 
	 */
	@Test
	public void obtenerPreVisualizacionTest() throws OperacionInvalida {
		assertEquals(previsualizacion(), reenvio.obtenerPreVisualizacion());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba la búsqueda de un reenvio cuando la encuentra.
	 * @throws OperacionInvalida 
	 */
	@Test
	public void buscarExisteTest() throws OperacionInvalida {
		Collection encontrados = reenvio.buscar("texto");
		assertEquals(1, encontrados.size());
	}
	
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba la búsqueda de un reenvio cuando NO la encuentra.
	 */
	@Test
	public void buscarNoExisteTest() {	
		Collection encontrados =  reenvio.buscar("Patata");
		assertEquals(0, encontrados.size());
	}
}
