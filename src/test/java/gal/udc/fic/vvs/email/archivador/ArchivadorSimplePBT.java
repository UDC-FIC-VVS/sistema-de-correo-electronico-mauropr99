package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.lang.IntegerGenerator;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

@RunWith(JUnitQuickcheck.class)
public class ArchivadorSimplePBT {
		
	private ArchivadorSimple archivadorSimple;
	
	private final static String NOMBRE_ARCHIVADOR = "EjemploArchivador";
	private final static int ESPACIO_ARCHIVADOR = 5;

	@Property
	public void obtenerNombrePBT(@From(StringGenerator.class) String nombre) {
		archivadorSimple = new ArchivadorSimple(nombre, ESPACIO_ARCHIVADOR);	
		assertEquals(nombre, archivadorSimple.obtenerNombre());
    } 
	
	@Property
	public void obtenerTamañoPBT(@From(IntegerGenerator.class) int tamaño) {
		archivadorSimple = new ArchivadorSimple(NOMBRE_ARCHIVADOR, tamaño);	
		assertEquals(tamaño, archivadorSimple.obtenerEspacioTotal());
    } 

}