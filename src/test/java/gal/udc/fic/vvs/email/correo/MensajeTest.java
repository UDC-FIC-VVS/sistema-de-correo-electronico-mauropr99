package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class MensajeTest {

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
	
	private String previsualizacionPadre() {
		return mensaje.obtenerPadre().obtenerRuta() + " > " + previsualizacion();
	}
	
	@Before
	public void crearDatos(){
		texto = new Texto(NOMBRE_TEXTO, CONTENIDO_TEXTO);
		mensaje = new Mensaje(texto);
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba si un mensaje obtiene la ruta cuando NO tiene padre.
	 */
	@Test
	public void obtenerRutaSinPadreTest() {
		assertEquals(previsualizacion(), mensaje.obtenerRuta());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba si un mensaje obtiene la ruta cuando tiene padre.
	 */
	@Test
	public void obtenerRutaPadreTest() {
		Mensaje padre = new Mensaje(new Texto("EjemploPadre", "Soy el padre"));
		mensaje.establecerPadre(padre);
		assertEquals(previsualizacionPadre(), mensaje.obtenerRuta());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba la exploración de un correo (operación inválida)
	 * @throws OperacionInvalida 
	 */
	@Test(expected = OperacionInvalida.class)
	public void Test() throws OperacionInvalida {
		mensaje.explorar();
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba añadir un correo (operación inválida)
	 * @throws OperacionInvalida 
	 */
	@Test(expected = OperacionInvalida.class)
	public void añadirTest() throws OperacionInvalida {
		Mensaje msgAux = new Mensaje(new Texto("EjemploAux", "Soy el mensaje aux"));
		mensaje.establecerPadre(msgAux);
		mensaje.añadir(msgAux);
	}
	
	
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba eliminar un correo (operación inválida)
	 * @throws OperacionInvalida 
	 */
	@Test(expected = OperacionInvalida.class)
	public void eliminarTest() throws OperacionInvalida {
		Mensaje msgAux = new Mensaje(new Texto("EjemploAux", "Soy el mensaje aux"));
		mensaje.establecerPadre(msgAux);
		mensaje.eliminar(msgAux);
	}

	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba la obtención del hijo de un correo (operación inválida)
	 * @throws OperacionInvalida 
	 */
	@Test(expected = OperacionInvalida.class)
	public void obtenerHijoTest() throws OperacionInvalida {
		mensaje.obtenerHijo(10);
	}
	
	/** 
* 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba si un mensaje puede obtener un padre.
	 */
	@Test
	public void establecerYObtenerPadreTest() {
		Mensaje padre = new Mensaje(new Texto("EjemploPadre", "Soy el padre"));
		mensaje.establecerPadre(padre);
		assertEquals(padre.obtenerVisualizacion(), mensaje.obtenerPadre().obtenerVisualizacion());
	}

	/** 
* 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba si un mensaje se marca como leído y se recupera.
	 */
	@Test
	public void establecerYObtenerLeidoTest() {
		mensaje.establecerLeido(true);
		assertEquals(0, mensaje.obtenerNoLeidos());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba si un mensaje se recupera como NO leído.
	 */
	@Test
	public void obtenerNoLeidoTest() {
		assertEquals(1, mensaje.obtenerNoLeidos());
	}
	
	/** 
* 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba si un mensaje recupera el tamaño.
	 */
	@Test
	public void obtenerTamañoTest() {
		assertEquals(CONTENIDO_TEXTO.length(), mensaje.obtenerTamaño());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba si un mensaje recupera el icono de NO leído.
	 */
	@Test
	public void obtenerIconoNoLeidoTest() {
		assertEquals(Correo.ICONO_NUEVO_MENSAJE, mensaje.obtenerIcono());
	}

	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba si un mensaje recupera el icono de leído.
	 */
	@Test
	public void obtenerIconoLeidoTest() {
		mensaje.establecerLeido(true);
		assertEquals(Correo.ICONO_MENSAJE, mensaje.obtenerIcono());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba la recuperación de la previsualización de un mensaje.
	 */
	@Test
	public void obtenerPreVisualizacionTest() {
		assertEquals(previsualizacion(), mensaje.obtenerPreVisualizacion());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba la recuperación de la visualización de un mensaje.
	 */
	@Test
	public void obtenerVisualizacionTest() {
		assertEquals(CONTENIDO_TEXTO, mensaje.obtenerVisualizacion());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba la búsqueda de un mensaje cuando lo encuentra.
	 */
	@Test
	public void buscarExisteTest() {
		Mensaje encontrado = (Mensaje) mensaje.buscar("texto").toArray()[0];
		
		assertEquals(mensaje, encontrado);
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba la búsqueda de un mensaje cuando NO lo encuentra.
	 */
	@Test
	public void buscarNoExisteTest() {	
		Vector<Mensaje> encontrados = (Vector<Mensaje>) mensaje.buscar("Patata");
		
		assertEquals(0, encontrados.size());
	}
	
}
