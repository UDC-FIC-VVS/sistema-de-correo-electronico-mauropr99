package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class CabeceraTest {

	private Cabecera cabecera;
	private Mensaje mensaje;
	private Texto texto;
	
	private static String NOMBRE_TEXTO = "EjemploTexto";
	private static String CONTENIDO_TEXTO = "Contenido del texto";
	
	private static String NOMBRE_CABECERA = "EjemploCabecera";
	private static String VALOR_CABECERA = "Valor de la cabecera";
	
	// Tamaño establecido en la clase Mensaje
	private final static int TAMAÑO_PREVISUALIZACION = 32;
	
	private int tamaño() {
		return CONTENIDO_TEXTO.length() + NOMBRE_CABECERA.length() + VALOR_CABECERA.length();
	}
	
	private String previsualizacion() {
		return CONTENIDO_TEXTO.substring(0, Math.min(CONTENIDO_TEXTO.length(),
						TAMAÑO_PREVISUALIZACION)) + "...";
	}
	
	private String visualizacion() {
		return NOMBRE_CABECERA + ": " + VALOR_CABECERA + "\n" + mensaje.obtenerVisualizacion();
	}
	
	private String previsualizacionPadre() {
		return cabecera.obtenerPadre().obtenerRuta() + " > " + previsualizacion();
	}
	
	@Before
	public void crearDatos(){
		texto = new Texto(NOMBRE_TEXTO, CONTENIDO_TEXTO);
		mensaje = new Mensaje(texto);
		cabecera = new Cabecera(mensaje, NOMBRE_CABECERA, VALOR_CABECERA);
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba si una cabecera obtiene la ruta cuando NO tiene padre.
	 */
	@Test
	public void obtenerRutaSinPadreTest() {
		assertEquals(previsualizacion(), cabecera.obtenerRuta());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba si una cabecera obtiene la ruta cuando tiene padre.
	 */
	@Test
	public void obtenerRutaPadreTest() {
		Mensaje padre = new Mensaje(new Texto("EjemploPadre", "Soy el padre"));
		cabecera.establecerPadre(padre);
		assertEquals(previsualizacionPadre(), cabecera.obtenerRuta());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba la exploración de un correo (operación inválida)
	 * @throws OperacionInvalida 
	 */
	@Test(expected = OperacionInvalida.class)
	public void Test() throws OperacionInvalida {
		cabecera.explorar();
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
		Mensaje msgAux = new Mensaje(new Texto("EjemploAux", "Soy el mensaje aux"));
		cabecera.establecerPadre(msgAux);
		cabecera.añadir(msgAux);
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
		Mensaje msgAux = new Mensaje(new Texto("EjemploAux", "Soy el mensaje aux"));
		cabecera.establecerPadre(msgAux);
		cabecera.eliminar(msgAux);
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
		cabecera.obtenerHijo(10);
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba si una cabecera puede obtener un padre.
	 */
	@Test
	public void establecerYObtenerPadreTest() {
		Mensaje padre = new Mensaje(new Texto("EjemploPadre", "Soy el padre"));
		cabecera.establecerPadre(padre);
		assertEquals(padre.obtenerVisualizacion(), cabecera.obtenerPadre().obtenerVisualizacion());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba si una cabecera recupera el tamaño.
	 */
	@Test
	public void obtenerTamañoTest() {
		assertEquals(tamaño(), cabecera.obtenerTamaño());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba si una cabecera recupera la visualización.
	 */
	@Test
	public void obtenerVisualizacionTest() {
		assertEquals(visualizacion(), cabecera.obtenerVisualizacion());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba si una cabecera se marca como leída y se recupera.
	 */
	@Test
	public void establecerYObtenerLeidaTest() {
		cabecera.establecerLeido(true);
		assertEquals(0, cabecera.obtenerNoLeidos());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba si una cabecera se recupera como NO leído.
	 */
	@Test
	public void obtenerNoLeidoTest() {
		assertEquals(1, cabecera.obtenerNoLeidos());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba si una cabecera recupera el icono de NO leído.
	 */
	@Test
	public void obtenerIconoNoLeidoTest() {
		assertEquals(Correo.ICONO_NUEVO_MENSAJE, cabecera.obtenerIcono());
	}

	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba si una cabecera recupera el icono de leído.
	 */
	@Test
	public void obtenerIconoLeidoTest() {
		cabecera.establecerLeido(true);
		assertEquals(Correo.ICONO_MENSAJE, cabecera.obtenerIcono());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba la recuperación de la previsualización de una cabecera.
	 */
	@Test
	public void obtenerPreVisualizacionTest() {
		assertEquals(previsualizacion(), cabecera.obtenerPreVisualizacion());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba la búsqueda de una cabecera cuando la encuentra.
	 */
	@Test
	public void buscarExisteTest() {
		Cabecera encontrada = (Cabecera) cabecera.buscar("texto").toArray()[0];
		
		assertEquals(cabecera, encontrada);
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Prueba la búsqueda de una cabecera cuando NO la encuentra.
	 */
	@Test
	public void buscarNoExisteTest() {	
		Vector<Cabecera> encontradas = (Vector<Cabecera>) cabecera.buscar("Patata");
		
		assertEquals(0, encontradas.size());
	}
}
