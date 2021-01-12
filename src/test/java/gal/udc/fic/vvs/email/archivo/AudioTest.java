package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AudioTest {
	
	private Audio audio;
	
	private static final String NOMBRE_AUDIO = "EjemploAudio";
	private static final String CONTENIDO_AUDIO = "Ejemlo de canción pasado a String";
	private static final String MIME_TYPE = "audio/ogg";
	
	private static String previsualizacion() {
		return NOMBRE_AUDIO + "(" + CONTENIDO_AUDIO.length() + " bytes, " + MIME_TYPE + ")";
	}
	
	@Before
	public void crearDatos(){
		audio = new Audio(NOMBRE_AUDIO, CONTENIDO_AUDIO);
	}
	
	
	/** 
	 * 	Test de unidad.
	 *  Prueba la recuperación del nombre de un Audio.
	 */
	@Test
	public void obtenerNombreTest() {
		assertEquals(NOMBRE_AUDIO, audio.obtenerNombre());
	}
	
	/** 
	 * 	Test de unidad.
	 *  Prueba la recuperación del contenido de un Audio.
	 */
	@Test
	public void obtenerContenidoTest() {
		assertEquals(CONTENIDO_AUDIO, audio.obtenerContenido());
	}
	
	
	/** 
	 * 	Test de unidad.
	 *  Prueba la recuperación del tamaño del contenido de un Audio.
	 */
	@Test
	public void obtenerTamañoTest() {
		assertEquals(CONTENIDO_AUDIO.length(), audio.obtenerTamaño());
	}
	
	/** 
	 * 	Test de unidad.
	 *  Prueba la recuperación de la previsualización de un Audio.
	 */
	@Test
	public void obtenerPreVisualizacionTest() {
		assertEquals(previsualizacion(), audio.obtenerPreVisualizacion());
	}
	
	/** 
	 * 	Test de unidad.
	 *  Prueba la recuperación del mime type de un Audio.
	 */
	@Test
	public void obtenerMimeTypeTest() {
		assertEquals(MIME_TYPE, audio.obtenerMimeType());
	}

}
