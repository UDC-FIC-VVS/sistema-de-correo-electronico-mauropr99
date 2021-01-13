package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

@RunWith(JUnitQuickcheck.class)
public class AudioPBT {
	
	private static String MIME_TYPE = "audio/ogg";
	
	@Property
	public void obtenerPrevisuaizacionPBT(@From(StringGenerator.class)String nombre, @From(StringGenerator.class)String contenido) {
		Audio audio = new Audio(nombre, contenido);	
		
		String esperado = nombre + "(" + contenido.length() + " bytes, " + MIME_TYPE + ")";
		assertEquals(esperado, audio.obtenerPreVisualizacion());
    } 

}
