package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

@RunWith(JUnitQuickcheck.class)
public class CarpetaLimitadaPBT {
	
	@Property
	public void obtenerRutaSinPadrePBT(@From(StringGenerator.class) String nombre) {
		Carpeta carpeta = new Carpeta(nombre);
		CarpetaLimitada limitada = new CarpetaLimitada(carpeta, 10);
		
		assertEquals(nombre, limitada.obtenerRuta());
    }
}