package packlaborategia8;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packlaborategia5.Erabiltzailea;
import packlaborategia5.Liburua;
import packlaborategia5.ListaErabiltzaileak;

public class ListaErabiltzaileakTest 
{
	Erabiltzailea erab1, erab2, erab3, erabiltzailea, erabiltzaileaN;
	ListaErabiltzaileak lista, listaN;
	Liburua lib1,lib2,lib3,lib4,lib5,lib6;
	@Before
	public void setUp() throws Exception 
	{
		//Liburuak
		
		lib1 = new Liburua("La Casa de los Espiritus", "Isabel Allende", 0001);
		lib2 = new Liburua("El Nombre del Viento", "Patrick Rothfuss", 0002);
		lib3 = new Liburua("La chica del tren", "Paula Hawkins", 0003);
		lib4 = new Liburua("El Imperio Final", "Brandon Sanderson", 0004);
		lib5 = new Liburua("Los secretos de Youtube", "TheGrefg", 0005);
		lib6 = new Liburua("IT", "Stephen King", 0006);
		
		//Erabiltzaileak
		erab1 = new Erabiltzailea ("Gorka Ortiz",1111);
		erab2 = new Erabiltzailea ("Gorka Ortiz",2222);
		erab3 = new Erabiltzailea ("Gorka Ortiz",3333);
		erabiltzailea = new Erabiltzailea ("Auxiliarra",0000);
		
			erab1.gehituLiburua(lib1);
			erab1.gehituLiburua(lib2);

			erab2.gehituLiburua(lib3);
			erab2.gehituLiburua(lib4);
		
			erab3.gehituLiburua(lib5);
			
		//ListaErabiltzaileak
		lista = ListaErabiltzaileak.getListaErabiltzaileak();
	}

	@After
	public void tearDown() throws Exception 
	{
		erab1 = null;
		erab2 = null;
		erab3 = null;
		erabiltzailea = null;
	}

	@Test
	public void testGetListaErabiltzaileak() 
	{
		assertNull(listaN);
		lista.erabiltzaileariAltaEman(erab1);
		lista.erabiltzaileariAltaEman(erab2);
		lista.erabiltzaileariAltaEman(erab3);
		listaN = ListaErabiltzaileak.getListaErabiltzaileak();
		assertNotNull(lista);
		assertNotNull(listaN);
		assertEquals(lista,listaN);
	}
	@Test
	public void testErabiltzaileKopurua() 
	{
		lista.erreseteatu();
//		System.out.println(lista.erabiltzaileKopurua());
		assertEquals(lista.erabiltzaileKopurua(),0);
		lista.erabiltzaileariAltaEman(erab1);
		assertEquals(lista.erabiltzaileKopurua(),1);
		lista.erabiltzaileariAltaEman(erab2);
		lista.erabiltzaileariAltaEman(erab3);
		assertEquals(lista.erabiltzaileKopurua(),3);
	}
	@Test
	public void testBilatuErabiltzaileaIdz() 
	{
		lista.erreseteatu();
		Erabiltzailea erab = null;
		lista.erabiltzaileariAltaEman(erab1);
		lista.erabiltzaileariAltaEman(erab2);
		lista.erabiltzaileariAltaEman(erab3);
		erab = lista.bilatuErabiltzaileaIdz(1111);//Erab1 da 
		assertTrue(erab.idBerdinaDute(erab1));
		erab = lista.bilatuErabiltzaileaIdz(2222);//Erab2 da
		assertTrue(erab.idBerdinaDute(erab2));
		erab = lista.bilatuErabiltzaileaIdz(1212);//1212 id duen erabiltzailerik ez dago
		assertNull(erab);
	}

	@Test
	public void testBadagoIdBerdinekoErabiltzailerik() 
	{
		lista.erreseteatu();
		lista.erabiltzaileariAltaEman(erab1);
		lista.erabiltzaileariAltaEman(erab2);
		lista.erabiltzaileariAltaEman(erab3);
		
		Erabiltzailea erab = new Erabiltzailea ("WillyRex",1111);
		assertTrue(lista.badagoIdBerdinekoErabiltzailerik(erab));
	}

	@Test
	public void testErabiltzaileariAltaEman() 
	{
		lista.erreseteatu();
		int zenbat = lista.erabiltzaileKopurua();
		lista.erabiltzaileariAltaEman(erab1);				//Erabiltzailea gehitu ahal
		assertEquals(zenbat+1,lista.erabiltzaileKopurua());
		
		zenbat = lista.erabiltzaileKopurua();
		lista.erabiltzaileariAltaEman(erab2);				//Erabiltzailea gehitu ahal
		assertEquals(zenbat+1,lista.erabiltzaileKopurua());
		
		zenbat = lista.erabiltzaileKopurua();
		lista.erabiltzaileariAltaEman(erab1);				//Erabiltzailea ezin gehitu, dagoeneko listan
		assertEquals(zenbat,lista.erabiltzaileKopurua());
	}
	@Test
	public void testErabiltzaileaBajaEman() 
	{
		lista.erreseteatu();
		lista.erabiltzaileariAltaEman(erab1);
		lista.erabiltzaileariAltaEman(erab2);
		lista.erabiltzaileariAltaEman(erab3);
		
		int zenbat = lista.erabiltzaileKopurua();
		lista.erabiltzaileaBajaEman(3333);					//erab3 kendu ahal
		assertEquals(zenbat-1,lista.erabiltzaileKopurua());
		
		zenbat = lista.erabiltzaileKopurua();
		lista.erabiltzaileaBajaEman(2222);					//erab2 kendu ahal
		assertEquals(zenbat-1,lista.erabiltzaileKopurua());
		
		zenbat = lista.erabiltzaileKopurua();
		lista.erabiltzaileaBajaEman(0000);					//Ez dago listan
		assertEquals(zenbat,lista.erabiltzaileKopurua());
	}
	@Test
	public void testNorkDaukaMaileguan() 
	{
		lista.erreseteatu();
		lista.erabiltzaileariAltaEman(erab1);
		lista.erabiltzaileariAltaEman(erab2);
		lista.erabiltzaileariAltaEman(erab3);
		
		Erabiltzailea erab;
		erab = lista.norkDaukaMaileguan(lib1);
		assertTrue(erab.idBerdinaDute(erab1));
		
		erab = lista.norkDaukaMaileguan(lib3);
		assertTrue(erab.idBerdinaDute(erab2));
		
		erab = lista.norkDaukaMaileguan(lib5);
		assertTrue(erab.idBerdinaDute(erab3));
		
		erab = lista.norkDaukaMaileguan(lib6);
		assertNull(erab);
	}
	@Test
	public void testInprimatu() 
	{
		lista.inprimatu();
		lista.erabiltzaileariAltaEman(erab1);
		lista.erabiltzaileariAltaEman(erab2);
		lista.erabiltzaileariAltaEman(erab3);
		lista.inprimatu();
	}
	@Test
	public void testErreseteatu() 
	{
		lista.erreseteatu();
		lista.erabiltzaileariAltaEman(erab1);
		lista.erabiltzaileariAltaEman(erab2);
		lista.erabiltzaileariAltaEman(erab3);
		assertNotSame(0,lista.erabiltzaileKopurua());
		lista.erreseteatu();
		assertSame(0,lista.erabiltzaileKopurua());
	}

}
