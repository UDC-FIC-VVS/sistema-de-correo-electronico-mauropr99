package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

@RunWith(JUnitQuickcheck.class)
public class CarpetaPBT {
	
	@Property
	public void obtenerRutaSinPadrePBT(@From(StringGenerator.class) String nombre) {
		Carpeta carpeta = new Carpeta(nombre);
		assertEquals(nombre, carpeta.obtenerRuta());
    }
}
