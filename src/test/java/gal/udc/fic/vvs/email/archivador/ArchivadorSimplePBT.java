package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;


@RunWith(JUnitQuickcheck.class)
public class ArchivadorSimplePBT {
		
	private ArchivadorSimple archivadorSimple;
	
	private static String NOMBRE_ARCHIVADOR = "EjemploArchivador";
	private static int ESPACIO_ARCHIVADOR = 5;

	@Property
	public void obtenerNombreTest(@From(StringGenerator.class) String nombre) {
		archivadorSimple = new ArchivadorSimple(nombre, ESPACIO_ARCHIVADOR);	
		assertEquals(nombre, archivadorSimple.obtenerNombre());
    } 
	
	@Property
	public void obtenerTamañoTest(@InRange(min = "1") int tamaño) {
		archivadorSimple = new ArchivadorSimple(NOMBRE_ARCHIVADOR, tamaño);	
		assertEquals(tamaño, archivadorSimple.obtenerEspacioTotal());
    } 

}