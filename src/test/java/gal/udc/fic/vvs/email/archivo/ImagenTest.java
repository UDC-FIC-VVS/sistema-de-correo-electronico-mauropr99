package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ImagenTest {

	private Imagen imagen;
	
	private static final String NOMBRE_IMAGEN = "EjemploImagen";
	private static final String CONTENIDO_IMAGEN = "Ejemlo de imagen pasada a String";
	private static final String MIME_TYPE = "image/png";
	
	private static String previsualizacion() {
		return NOMBRE_IMAGEN + "(" + CONTENIDO_IMAGEN.length() + " bytes, " + MIME_TYPE + ")";
	}
	
	@Before
	public void crearDatos(){
		imagen = new Imagen(NOMBRE_IMAGEN, CONTENIDO_IMAGEN);
	}
	
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba la recuperación del nombre de una imagen.
	 */
	@Test
	public void obtenerNombreTest() {
		assertEquals(NOMBRE_IMAGEN, imagen.obtenerNombre());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba la recuperación del contenido de una imagen.
	 */
	@Test
	public void obtenerContenidoTest() {
		assertEquals(CONTENIDO_IMAGEN, imagen.obtenerContenido());
	}
	
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba la recuperación del tamaño del contenido de una imagen.
	 */
	@Test
	public void obtenerTamañoTest() {
		assertEquals(CONTENIDO_IMAGEN.length(), imagen.obtenerTamaño());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba la recuperación de la previsualización de una imagen.
	 */
	@Test
	public void obtenerPreVisualizacionTest() {
		assertEquals(previsualizacion(), imagen.obtenerPreVisualizacion());
	}
	
	/** 
	 * 	Test de unidad.
	 * 
	 *  Prueba funcional de caja negra.
	 *  
	 *  Datos introducidos manualmente.
	 *  
	 *  Prueba la recuperación del mime type de una imagen.
	 */
	@Test
	public void obtenerMimeTypeTest() {
		assertEquals(MIME_TYPE, imagen.obtenerMimeType());
	}
}
