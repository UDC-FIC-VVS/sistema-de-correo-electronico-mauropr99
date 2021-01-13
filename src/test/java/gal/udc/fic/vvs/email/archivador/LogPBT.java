package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;

public class LogPBT {

	private Log log;
	private Archivador decorado;
	
	private static final String NOMBRE_DECORADO = "EjemploDecorado";
	private static final int ESPACIO_ARCHIVADOR = 10;
	
	@Before
	public void crearDatos()
	{
		decorado = new ArchivadorSimple(NOMBRE_DECORADO, ESPACIO_ARCHIVADOR);
		log = new Log(decorado);
	}
	
	@Property
	public void obtenerYEstablecerDelegadoTest(@From(StringGenerator.class) String nombre) {
		Archivador delegado = new ArchivadorSimple(nombre, ESPACIO_ARCHIVADOR);	
		log.establecerDelegado(delegado);
		
		assertEquals(nombre, log.obtenerDelegado().obtenerNombre());
    } 
}
