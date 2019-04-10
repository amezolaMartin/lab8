package packlaborategia8;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packlaborategia5.Erabiltzailea;
import packlaborategia5.Liburua;
import packlaborategia5.ListaLiburuak;

public class ErabiltzaileaTest 
{
	Erabiltzailea erabiltzailea, erab1, erab2, erab3, erab4, erab5, erab6;
	ListaLiburuak mailegatutakoLiburuak, list;
	Liburua lib1, lib2, lib3, lib4, lib5, lib6;
	@Before
	public void setUp() throws Exception 
	{
	// ERABILTZAILEAK
		//String pIzenOsoa, int pIdErabiltzaile
		erabiltzailea = new Erabiltzailea ("Gorka Ortiz",1111);
		erab1 = new Erabiltzailea("Ramon Gonzalez", 1234);
		erab2 = new Erabiltzailea("Ramon Gonzalez", 1234);
		erab3= new Erabiltzailea("Ramon Gonzalez", 1111);
		erab4 = new Erabiltzailea("Ramon Gonzalez", 1234);
		erab5 = new Erabiltzailea("Ramon Gonzalez", 1234);
		erab6 = new Erabiltzailea("Ramon Gonzalez", 1234);
		
	// LIBURUAK
		//String pTitulua, String pIdazlea, int pIdLiburua
		lib1 = new Liburua("La Casa de los Espiritus", "Isabel Allende", 0001);
		lib2 = new Liburua("El Nombre del Viento", "Patrick Rothfuss", 0002);
		lib3 = new Liburua("La chica del tren", "Paula Hawkins", 0003);
		lib4 = new Liburua("El Imperio Final", "Brandon Sanderson", 0004);
		lib5 = new Liburua("Los secretos de Youtube", "TheGrefg", 0005);
		lib6 = new Liburua("IT", "Stephen King", 0006);
		
		list = new ListaLiburuak();
		mailegatutakoLiburuak  = new ListaLiburuak();	
	}
	@After
	public void tearDown() throws Exception 
	{
		//ERABILTZAILEAK
		erab1 = null;
		erab2 = null;
		erab3 = null;
		erab4 = null;
		erab5 = null;
		erab6 = null;
		erabiltzailea = null;
		
		//LIBURUAK
		lib1 = null;
		lib2 = null;
		lib3 = null;
		lib4 = null;
		lib5 = null;
		lib6 = null;
		
		//LISTA
		mailegatutakoLiburuak = null;
		list = null;
	}
	@Test
	public void testErabiltzailea() 
	{
		// ERABILTZAILEAK
		assertNotNull(erabiltzailea);
		assertNotNull(erab1);
		assertNotNull(erab2);
		assertNotNull(erab3);
		assertNotNull(erab4);
		assertNotNull(erab5);
		assertNotNull(erab6);
		
		// LIBURUAK
		assertNotNull(lib1);
		assertNotNull(lib2);
		assertNotNull(lib3);
		assertNotNull(lib4);
		assertNotNull(lib5);
		assertNotNull(lib6);
		
		// LISTA
		assertNotNull(mailegatutakoLiburuak);
	}
	@Test
	public void testIdHauDu() 
	{
		assertTrue(erab1.idHauDu(1234));
		assertFalse(erab1.idHauDu(1233));
	}
	@Test
	public void testIdBerdinaDute() 
	{
		assertTrue(erab1.idBerdinaDute(erab2));// Id berdina duten bi erabiltzaile
		assertFalse(erab1.idBerdinaDute(erab3)); // Id ezberdina duten bi erabiltzaile
	}
	@Test
	public void testMailegatzekoMaximoaGainditua() 
	{
		erab1.gehituLiburua(lib1);
		assertFalse(erab1.mailegatzekoMaximoaGainditua());
		
		erab2.gehituLiburua(lib1);
		erab2.gehituLiburua(lib2);
		assertFalse(erab2.mailegatzekoMaximoaGainditua());
		
		erab3.gehituLiburua(lib1);
		erab3.gehituLiburua(lib2);
		erab3.gehituLiburua(lib3);
		assertTrue(erab3.mailegatzekoMaximoaGainditua());
		
		erabiltzailea.gehituLiburua(lib1);
		erabiltzailea.gehituLiburua(lib2);
		erabiltzailea.gehituLiburua(lib3);
		erabiltzailea.gehituLiburua(lib4);
		assertTrue(erabiltzailea.mailegatzekoMaximoaGainditua());
	}
	@Test
	public void testGehituLiburua() 
	{
		erab1.gehituLiburua(lib1);

		erab2.gehituLiburua(lib1);
		erab2.gehituLiburua(lib2);
		
		erab3.gehituLiburua(lib1);
		erab3.gehituLiburua(lib2);
		erab3.gehituLiburua(lib3);
		
		erabiltzailea.gehituLiburua(lib1);
		erabiltzailea.gehituLiburua(lib2);
		erabiltzailea.gehituLiburua(lib3);
		erabiltzailea.gehituLiburua(lib4);
	}
	@Test
	public void testKenduLiburua() 
	{
		erabiltzailea.gehituLiburua(lib1);
		erabiltzailea.gehituLiburua(lib2);
		erabiltzailea.gehituLiburua(lib3);
		erabiltzailea.gehituLiburua(lib4);
		
		int zenbat = erabiltzailea.zenbat();
		erabiltzailea.kenduLiburua(lib1);
		assertEquals(erabiltzailea.zenbat(),zenbat-1);
		
		zenbat = erabiltzailea.zenbat();
		erabiltzailea.kenduLiburua(lib2);
		assertEquals(erabiltzailea.zenbat(),zenbat-1);
		
		zenbat = erabiltzailea.zenbat();
		erabiltzailea.kenduLiburua(lib3);
		assertEquals(erabiltzailea.zenbat(),zenbat-1);
		
		zenbat = erabiltzailea.zenbat();
		erabiltzailea.kenduLiburua(lib4);
		assertEquals(erabiltzailea.zenbat(),zenbat-1);
	}
	@Test
	public void testMaileguanDu() 
	{
		erabiltzailea.gehituLiburua(lib1);
		erabiltzailea.gehituLiburua(lib2);
		erabiltzailea.gehituLiburua(lib3);
		erabiltzailea.gehituLiburua(lib4);
		
		assertTrue(erabiltzailea.maileguanDu(lib1));
		assertTrue(erabiltzailea.maileguanDu(lib2));
		
		assertFalse(erabiltzailea.maileguanDu(lib5));
		assertFalse(erabiltzailea.maileguanDu(lib6));
	}
	@Test
	public void testInprimatu() 
	{
		erab1.inprimatu();
		erab2.inprimatu();
		erab3.inprimatu();
	}
}
