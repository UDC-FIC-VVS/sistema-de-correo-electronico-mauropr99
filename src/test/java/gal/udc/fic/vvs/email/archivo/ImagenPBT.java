package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

@RunWith(JUnitQuickcheck.class)
public class ImagenPBT {

	private final static String MIME_TYPE = "image/png";

	@Property
	public void obtenerPrevisualizacionPBT(@From(StringGenerator.class) String nombre,@From(StringGenerator.class) String contenido) {
		Imagen imagen = new Imagen(nombre, contenido);	
		String esperado = nombre + "(" + contenido.length() + " bytes, " + MIME_TYPE + ")";
		
		assertEquals(esperado, imagen.obtenerPreVisualizacion());
    } 
}
