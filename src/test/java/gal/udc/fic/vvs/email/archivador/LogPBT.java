package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertTrue;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.generator.java.lang.IntegerGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;

@RunWith(JUnitQuickcheck.class)
public class LogPBT {

	@Property public void almacenarCorreoPBT(@From(IntegerGenerator.class) @InRange(min = "1") int espacioArchivador) {
		Mensaje mensaje = new Mensaje(new Texto("1","1"));
		Archivador archivadorDecorado = new ArchivadorSimple("nombre", espacioArchivador);
		Archivador archivadorDelegado = null;
		Log log = new Log(archivadorDecorado);
		
		log.establecerDelegado(archivadorDelegado);
		
		assertTrue(log.almacenarCorreo(mensaje));
	}
}
