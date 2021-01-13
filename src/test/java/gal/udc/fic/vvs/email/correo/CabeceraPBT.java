package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Texto;

@RunWith(JUnitQuickcheck.class)
public class CabeceraPBT {
	
	 @Property
	    public void obtenerTamañoCabeceraPBT(@From(StringGenerator.class) String nombre, @From(StringGenerator.class) String valor) {
		 Texto texto = new Texto("nombre", "contenido");
		 Mensaje mensaje = new Mensaje(texto);   
		 Cabecera cabecera = new Cabecera(mensaje, nombre, valor);

	        assertEquals(mensaje.obtenerTamaño() + nombre.length() + valor.length(), cabecera.obtenerTamaño());

	    }
}

