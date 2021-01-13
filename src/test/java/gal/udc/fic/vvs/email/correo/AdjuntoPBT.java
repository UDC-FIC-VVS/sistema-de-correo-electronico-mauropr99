package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Texto;

@RunWith(JUnitQuickcheck.class)
public class AdjuntoPBT {

		@Property
		public void obtenerTamañoPBT(@From(StringGenerator.class)String contenido) {
			Texto texto = new Texto("nombre", contenido);
			Mensaje mensaje = new Mensaje(texto);
			Adjunto adjunto = new Adjunto(mensaje, texto);
			
			assertEquals(mensaje.obtenerTamaño() + texto.obtenerTamaño(), adjunto.obtenerTamaño());
	    } 

}
