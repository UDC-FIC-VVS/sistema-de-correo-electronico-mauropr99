package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class CarpetaTest {

	Carpeta carpeta;
	private Mensaje mensaje;
	private Texto texto;
	
	private static String NOMBRE_TEXTO = "EjemploTexto";
	private static String CONTENIDO_TEXTO = "Contenido del texto";
	
	private static String NOMBRE_CARPETA = "EjemploCarpeta";
	
	// Tamaño establecido en la clase Mensaje
	private final static int TAMAÑO_PREVISUALIZACION = 32;
	
	private String previsualizacion() {
		return CONTENIDO_TEXTO.substring(0, Math.min(CONTENIDO_TEXTO.length(),
						TAMAÑO_PREVISUALIZACION)) + "...";
	}
	
	private String previsualizacionPadre() {
		return mensaje.obtenerPadre().obtenerRuta();
	}
	
	@Before
	public void crearDatos(){
		texto = new Texto(NOMBRE_TEXTO, CONTENIDO_TEXTO);
		mensaje = new Mensaje(texto);
		carpeta = new Carpeta(NOMBRE_CARPETA);
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba si una carpeta obtiene la ruta cuando NO tiene padre.
	 */
	@Test
	public void obtenerRutaSinPadreTest() {
		assertEquals(NOMBRE_CARPETA, carpeta.obtenerRuta());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba si una carpeta obtiene la ruta cuando tiene padre.
	 * @throws OperacionInvalida 
	 */
	@Test
	public void obtenerRutaPadreTest() throws OperacionInvalida {
		Mensaje padre = new Mensaje(new Texto("EjemploPadre", "Soy el padre"));
		Carpeta carpetaPadre = new Carpeta("Padre");
		carpeta.añadir(mensaje);
		carpeta.establecerPadre(carpetaPadre);
		assertEquals(previsualizacionPadre(), carpeta.obtenerRuta());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba la exploración e inserción de un correo (operación inválida)
	 * @throws OperacionInvalida 
	 */
	@Test
	public void explorarYAñadirTest() throws OperacionInvalida {
		Vector<Mensaje> aux = new Vector<Mensaje>();
		aux.add(mensaje);
		carpeta.añadir(mensaje);
		assertEquals(aux, carpeta.explorar());
		
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba eliminar un correo (operación inválida)
	 * @throws OperacionInvalida 
	 */
	@Test
	public void eliminarTest() throws OperacionInvalida {
		Vector<Mensaje> aux = new Vector<Mensaje>();
		carpeta.añadir(mensaje);
		carpeta.eliminar(mensaje);
		assertEquals(aux, carpeta.explorar());
		
	}

	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba la obtención del hijo de un correo (operación inválida)
	 * @throws OperacionInvalida 
	 */
	@Test()
	public void obtenerHijoTest() throws OperacionInvalida {
		carpeta.añadir(mensaje);
		assertEquals(mensaje, carpeta.obtenerHijo(0));
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba si una carpeta puede obtener un padre.
	 */
	@Test
	public void establecerYObtenerPadreTest() {
		Carpeta padre = new Carpeta("EjemploPadre");
		carpeta.establecerPadre(padre);
		assertEquals(padre.obtenerVisualizacion(), carpeta.obtenerPadre().obtenerVisualizacion());
	}

	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba si una carpeta y sus hijos se marcan como leídos y se recupera.
	 * @throws OperacionInvalida 
	 */
	@Test
	public void establecerYObtenerLeidoTest() throws OperacionInvalida {
		carpeta.añadir(mensaje);
		carpeta.establecerLeido(true);
		assertEquals(0, carpeta.obtenerNoLeidos());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba si una carpeta y sus hijos se recuperan como NO leído.
	 * @throws OperacionInvalida 
	 */
	@Test
	public void obtenerNoLeidoTest() throws OperacionInvalida {
		carpeta.añadir(mensaje);
		assertEquals(1, carpeta.obtenerNoLeidos());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba si una carpeta recupera el tamaño de sus hijos.
	 * @throws OperacionInvalida 
	 */
	@Test
	public void obtenerTamañoTest() throws OperacionInvalida {
		carpeta.añadir(mensaje);
		assertEquals(CONTENIDO_TEXTO.length(), carpeta.obtenerTamaño());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba si una carpeta recupera el icono
	 */
	@Test
	public void obtenerIconoTest() {
		assertEquals(Correo.ICONO_CARPETA, carpeta.obtenerIcono());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba la recuperación de la visualización de una carpeta.
	 * @throws OperacionInvalida 
	 */
	@Test
	public void obtenerVisualizacionTest() throws OperacionInvalida {
		carpeta.añadir(mensaje);
		assertEquals(NOMBRE_CARPETA + " (1)", carpeta.obtenerPreVisualizacion());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba la recuperación de la previsualización de una carpeta.
	 * @throws OperacionInvalida 
	 */
	@Test
	public void obtenerPreVisualizacionTest() throws OperacionInvalida {
		carpeta.añadir(mensaje);
		assertEquals(NOMBRE_CARPETA + " (1)", carpeta.obtenerVisualizacion());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba la búsqueda de una carpeta cuando la encuentra.
	 * @throws OperacionInvalida 
	 */
	@Test
	public void buscarExisteTest() throws OperacionInvalida {
		carpeta.añadir(mensaje);
		Vector encontrados = (Vector) mensaje.buscar("texto");
		
		assertEquals(carpeta.explorar(), encontrados);
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba la búsqueda de una carpeta cuando NO la encuentra.
	 */
	@Test
	public void buscarNoExisteTest() {	
		Collection encontrados =  carpeta.buscar("Patata");
		assertEquals(0, encontrados.size());
	}
	
}
