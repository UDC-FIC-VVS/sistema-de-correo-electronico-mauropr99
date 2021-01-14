package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class CarpetaLimitadaTest {

	CarpetaLimitada carpetaLimitada;
	Carpeta carpeta;
	private Mensaje mensaje;
	private Texto texto;
	
	private static String NOMBRE_TEXTO = "EjemploTexto";
	private static String CONTENIDO_TEXTO = "Contenido del texto";
	
	private static String NOMBRE_CARPETA = "EjemploCarpeta";
	private static int TAMAÑO_CARPETA = 3;
	
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
		carpetaLimitada = new CarpetaLimitada(carpeta, TAMAÑO_CARPETA);
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba si una carpeta limitada obtiene la ruta cuando NO tiene padre.
	 */
	@Test
	public void obtenerRutaSinPadreTest() {
		assertEquals(NOMBRE_CARPETA, carpetaLimitada.obtenerRuta());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba si una carpeta limitada btiene la ruta cuando tiene padre.
	 * @throws OperacionInvalida 
	 */
	@Test
	public void obtenerRutaPadreTest() throws OperacionInvalida {
		Mensaje padre = new Mensaje(new Texto("EjemploPadre", "Soy el padre"));
		Carpeta carpetaPadre = new Carpeta("Padre");
		carpetaLimitada.añadir(mensaje);
		carpetaLimitada.establecerPadre(carpetaPadre);
		assertEquals(previsualizacionPadre(), carpetaLimitada.obtenerRuta());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba la exploración e inserción de un correo (operación inválida)
	 * @throws OperacionInvalida 
	 */
	@Test
	public void explorarYAñadirTest() throws OperacionInvalida {
		Vector<Mensaje> aux = new Vector<Mensaje>();
		aux.add(mensaje);
		carpetaLimitada.añadir(mensaje);
		assertEquals(aux, carpetaLimitada.explorar());
		
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
	@Test
	public void eliminarTest() throws OperacionInvalida {
		Vector<Mensaje> aux = new Vector<Mensaje>();
		carpetaLimitada.añadir(mensaje);
		carpetaLimitada.eliminar(mensaje);
		assertEquals(aux, carpetaLimitada.explorar());
		
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
	@Test()
	public void obtenerHijoTest() throws OperacionInvalida {
		carpetaLimitada.añadir(mensaje);
		assertEquals(mensaje, carpetaLimitada.obtenerHijo(0));
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba si una carpeta limitada puede obtener un padre.
	 */
	@Test
	public void establecerYObtenerPadreTest() {
		Carpeta padre = new Carpeta("EjemploPadre");
		carpetaLimitada.establecerPadre(padre);
		assertEquals(padre.obtenerVisualizacion(), carpetaLimitada.obtenerPadre().obtenerVisualizacion());
	}

	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba si una carpeta limitada y sus hijos se marcan como leídos y se recupera.
	 * @throws OperacionInvalida 
	 */
	@Test
	public void establecerYObtenerLeidoTest() throws OperacionInvalida {
		carpetaLimitada.añadir(mensaje);
		carpetaLimitada.establecerLeido(true);
		assertEquals(0, carpetaLimitada.obtenerNoLeidos());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba si una carpeta y sus hijos se recuperan como NO leído.
	 * @throws OperacionInvalida 
	 */
	@Test
	public void obtenerNoLeidoTest() throws OperacionInvalida {
		carpetaLimitada.añadir(mensaje);
		assertEquals(1, carpetaLimitada.obtenerNoLeidos());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba si una carpeta limitada recupera el tamaño de sus hijos.
	 * @throws OperacionInvalida 
	 */
	@Test
	public void obtenerTamañoTest() throws OperacionInvalida {
		carpetaLimitada.añadir(mensaje);
		assertEquals(CONTENIDO_TEXTO.length(), carpetaLimitada.obtenerTamaño());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba si una carpeta limitada recupera el icono
	 */
	@Test
	public void obtenerIconoTest() {
		assertEquals(Correo.ICONO_CARPETA, carpetaLimitada.obtenerIcono());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba la recuperación de la visualización de una carpeta limitada.
	 * @throws OperacionInvalida 
	 */
	@Test
	public void obtenerVisualizacionTest() throws OperacionInvalida {
		carpetaLimitada.añadir(mensaje);
		assertEquals(NOMBRE_CARPETA + " (1)", carpetaLimitada.obtenerPreVisualizacion());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba la recuperación de la previsualización de una carpeta limitada.
	 * @throws OperacionInvalida 
	 */
	@Test
	public void obtenerPreVisualizacionTest() throws OperacionInvalida {
		carpetaLimitada.añadir(mensaje);
		assertEquals(NOMBRE_CARPETA + " (1)", carpetaLimitada.obtenerVisualizacion());
	}
	
	/** 
	 * 	Test de unidad.
	 *  Prueba la búsqueda de una carpeta limitada cuando la encuentra.
	 * @throws OperacionInvalida 
	 */
	@Test
	public void buscarExisteTest() throws OperacionInvalida {
		carpetaLimitada.añadir(mensaje);
		Collection encontrados = mensaje.buscar("texto");
		
		assertEquals(carpetaLimitada.explorar(), encontrados);
	}
	
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba la búsqueda de una carpeta limitada cuando NO la encuentra.
	 */
	@Test
	public void buscarNoExisteTest() {	
		Collection encontrados =  carpetaLimitada.buscar("Patata");
		assertEquals(0, encontrados.size());
	}
}
