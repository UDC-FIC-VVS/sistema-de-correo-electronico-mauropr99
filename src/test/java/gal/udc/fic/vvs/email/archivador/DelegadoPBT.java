package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

@RunWith(JUnitQuickcheck.class)
public class DelegadoPBT {
	
	private Delegado delegado;
	private  Archivador decorado;
	private  Archivador archivadorDelegado;
	
	private static final String NOMBRE_DECORADO = "EjemploDecorado";
	private static final int ESPACIO_ARCHIVADOR = 10;
	
	@Before
	public void crearDatos() {
		decorado = new ArchivadorSimple(NOMBRE_DECORADO, ESPACIO_ARCHIVADOR);	
		delegado = new Delegado(decorado);
	}
	
	@Property
	public void obtenerYEstablecerDelegadoPBT(@From(StringGenerator.class) String nombreDelegado) {		
		archivadorDelegado = new ArchivadorSimple(nombreDelegado, ESPACIO_ARCHIVADOR*2);
		delegado.establecerDelegado(archivadorDelegado);
		
		assertEquals(archivadorDelegado.obtenerNombre(), delegado.obtenerDelegado().obtenerNombre());
    } 
	
}
