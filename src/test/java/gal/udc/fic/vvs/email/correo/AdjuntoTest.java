package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class AdjuntoTest {

	private Adjunto adjunto;
	private Mensaje mensaje;
	private Texto texto;
	
	private static String NOMBRE_TEXTO = "EjemploTexto";
	private static String CONTENIDO_TEXTO = "Contenido del texto";
	
	// Tamaño establecido en la clase Mensaje
	private final static int TAMAÑO_PREVISUALIZACION = 32;
	
	private static final String MIME_TYPE = "text/plain";
	
	private int tamaño() {
		return CONTENIDO_TEXTO.length() + texto.obtenerTamaño();
	}
	
	private String previsualizacion() {
	    return CONTENIDO_TEXTO.substring(0, Math.min(CONTENIDO_TEXTO.length(), TAMAÑO_PREVISUALIZACION)) + "...";
	}
	
	private String previsualizacionTexto() {
		return NOMBRE_TEXTO + "(" + CONTENIDO_TEXTO.length() +
					" bytes, " + MIME_TYPE  + ")";
	}
	
	private String visualizacion() {
		return CONTENIDO_TEXTO + "\n\nAdxunto: " + previsualizacionTexto();
	}
	
	private String previsualizacionPadre() {
		return adjunto.obtenerPadre().obtenerRuta() + " > " + previsualizacion();
	}
	
	@Before
	public void crearDatos(){
		texto = new Texto(NOMBRE_TEXTO, CONTENIDO_TEXTO);
		mensaje = new Mensaje(texto);
		adjunto = new Adjunto(mensaje, texto);
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba si un adjunto obtiene la ruta cuando NO tiene padre.
	 */
	@Test
	public void obtenerRutaSinPadreTest() {
		assertEquals(previsualizacion(), adjunto.obtenerRuta());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba si un adjunto obtiene la ruta cuando tiene padre.
	 */
	@Test
	public void obtenerRutaPadreTest() {
		Mensaje padre = new Mensaje(new Texto("EjemploPadre", "Soy el padre"));
		adjunto.establecerPadre(padre);
		assertEquals(previsualizacionPadre(), adjunto.obtenerRuta());
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
		adjunto.explorar();
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
		adjunto.establecerPadre(msgAux);
		adjunto.añadir(msgAux);
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
		adjunto.establecerPadre(msgAux);
		adjunto.eliminar(msgAux);
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
		adjunto.obtenerHijo(10);
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba si un adjunto puede obtener un padre.
	 */
	@Test
	public void establecerYObtenerPadreTest() {
		Mensaje padre = new Mensaje(new Texto("EjemploPadre", "Soy el padre"));
		adjunto.establecerPadre(padre);
		assertEquals(padre.obtenerVisualizacion(), adjunto.obtenerPadre().obtenerVisualizacion());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba si un adjunto recupera el tamaño.
	 */
	@Test
	public void obtenerTamañoTest() {
		assertEquals(tamaño(), adjunto.obtenerTamaño());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba si un adjunto recupera la visualización.
	 */
	@Test
	public void obtenerVisualizacionTest() {
		assertEquals(visualizacion(), adjunto.obtenerVisualizacion());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba si un adjunto se marca como leído y se recupera.
	 */
	@Test
	public void establecerYObtenerLeidaTest() {
		adjunto.establecerLeido(true);
		assertEquals(0, adjunto.obtenerNoLeidos());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba si un adjunto se recupera como NO leído.
	 */
	@Test
	public void obtenerNoLeidoTest() {
		assertEquals(1, adjunto.obtenerNoLeidos());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba si un adjunto recupera el icono de NO leído.
	 */
	@Test
	public void obtenerIconoNoLeidoTest() {
		assertEquals(Correo.ICONO_NUEVO_MENSAJE, adjunto.obtenerIcono());
	}

	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba si un adjunto recupera el icono de leído.
	 */
	@Test
	public void obtenerIconoLeidoTest() {
		adjunto.establecerLeido(true);
		assertEquals(Correo.ICONO_MENSAJE, adjunto.obtenerIcono());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba la recuperación de la previsualización de un adjunto.
	 */
	@Test
	public void obtenerPreVisualizacionTest() {
		assertEquals(previsualizacion(), adjunto.obtenerPreVisualizacion());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba la búsqueda de un adjunto cuando lo encuentra.
	 */
	@Test
	public void buscarExisteTest() {
		Adjunto encontrado = (Adjunto) adjunto.buscar("texto").toArray()[0];
		
		assertEquals(adjunto, encontrado);
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba la búsqueda de un adjunto cuando NO lo encuentra.
	 */
	@Test
	public void buscarNoExisteTest() {	
		Vector<Adjunto> encontrados = (Vector<Adjunto>) adjunto.buscar("Patata");
		
		assertEquals(0, encontrados.size());
	}
}
