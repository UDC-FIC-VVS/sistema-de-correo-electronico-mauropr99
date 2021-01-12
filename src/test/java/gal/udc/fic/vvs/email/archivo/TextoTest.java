package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TextoTest {

	private Texto texto;
	
	private static final String NOMBRE_TEXTO = "EjemploTexto";
	private static final String CONTENIDO_TEXTO = "Ejemlo de texto";
	private static final String MIME_TYPE = "text/plain";
	
	private static String previsualizacion() {
		return NOMBRE_TEXTO + "(" + CONTENIDO_TEXTO.length() + " bytes, " + MIME_TYPE + ")";
	}
	
	@Before
	public void crearDatos(){
		texto = new Texto(NOMBRE_TEXTO, CONTENIDO_TEXTO);
	}
	
	
	/** 
	 * 	Test de unidad.
	 *  Prueba la recuperación del nombre de un texto.
	 */
	@Test
	public void obtenerNombreTest() {
		assertEquals(NOMBRE_TEXTO, texto.obtenerNombre());
	}
	
	/** 
	 * 	Test de unidad.
	 *  Prueba la recuperación del contenido de un texto.
	 */
	@Test
	public void obtenerContenidoTest() {
		assertEquals(CONTENIDO_TEXTO, texto.obtenerContenido());
	}
	
	
	/** 
	 * 	Test de unidad.
	 *  Prueba la recuperación del tamaño del contenido de un texto.
	 */
	@Test
	public void obtenerTamañoTest() {
		assertEquals(CONTENIDO_TEXTO.length(), texto.obtenerTamaño());
	}
	
	/** 
	 * 	Test de unidad.
	 *  Prueba la recuperación de la previsualización de un texto.
	 */
	@Test
	public void obtenerPreVisualizacionTest() {
		assertEquals(previsualizacion(), texto.obtenerPreVisualizacion());
	}
	
	/** 
	 * 	Test de unidad.
	 *  Prueba la recuperación del mime type de un texto.
	 */
	@Test
	public void obtenerMimeTypeTest() {
		assertEquals(MIME_TYPE, texto.obtenerMimeType());
	}
}
