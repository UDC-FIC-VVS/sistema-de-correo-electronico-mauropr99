package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Texto;

@RunWith(JUnitQuickcheck.class)
public class ReenvioPBT {

	@Property
	public void obtenerTamañoPBT(@From(StringGenerator.class) String contenido) {
		Texto texto = new Texto("txt", contenido);
		Mensaje mensaje = new Mensaje(texto);
		Reenvio reenvio = new Reenvio(mensaje, mensaje);
		
		assertEquals(contenido.length()*2, reenvio.obtenerTamaño());
    }
	
}
