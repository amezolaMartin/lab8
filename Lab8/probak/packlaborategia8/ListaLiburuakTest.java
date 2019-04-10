package packlaborategia8;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packlaborategia5.Liburua;
import packlaborategia5.ListaLiburuak;

public class ListaLiburuakTest 
{
	ListaLiburuak lista,listaN;
	Liburua l,lN,l1,l1B,l2,l3,l3B,l4,l5;

	@Before
	public void setUp() throws Exception 
	{
		//Listak
		lista = new ListaLiburuak();
		
		//Liburuak
		l1 = new Liburua ("El principe de las tinieblas","Gorka",1111);
		l1B = new Liburua ("El principe de las tinieblas","Berna",1111);
		l2 = new Liburua ("Apexero","Martin",2222);
		l3 = new Liburua ("AhoBizi","Toni",3333);
		l3B = new Liburua ("AhoBizi","Alfred",3333);
		l4 = new Liburua ("El prince","Garni",4444);
		l5 = new Liburua ("Harry Cipoter","J.K.",5555);
	}
	@After
	public void tearDown() throws Exception 
	{
		//Listak
		lista = null;
		
		//Liburuak		
		lN = null;
		l1 = null;	l1B = null;
		l2 = null;
		l3 = null;	l3B = null;
		l4 = null;
		l5 = null;
	}
	@Test
	public void testListaLiburuak() 
	{
		//Listak
		assertNull(listaN);
		assertNotNull(lista);
		
		//Liburuak
		assertNull(lN);
		
		assertNotNull(l1);		assertNotNull(l1B);
		assertNotNull(l2);
		assertNotNull(l3);		assertNotNull(l3B);
		assertNotNull(l4);
		assertNotNull(l5);
	}

	@Test
	public void testListarenTamaina() 
	{
		assertEquals(lista.listarenTamaina(),0);
		lista.gehituLiburua(l1);
		assertEquals(lista.listarenTamaina(),1);
		lista.gehituLiburua(l2);
		assertEquals(lista.listarenTamaina(),2);
		lista.kenduLiburua(l1);
		assertEquals(lista.listarenTamaina(),1);
	}

	@Test
	public void testBilatuLiburuaIdz() 
	{
		Liburua lib = null;
		lista.gehituLiburua(l1);
		lista.gehituLiburua(l2);
		lista.gehituLiburua(l3);
		lista.gehituLiburua(l4);
		lista.gehituLiburua(l5);
		
		lib = lista.bilatuLiburuaIdz(1111);
		assertEquals(lib,l1);
		
		lib = lista.bilatuLiburuaIdz(2222);
		assertEquals(lib,l2);
		
		lib = lista.bilatuLiburuaIdz(5555);
		assertEquals(lib,l5);

		lib = lista.bilatuLiburuaIdz(1212);
		assertEquals(lib,null);
		
		lib = lista.bilatuLiburuaIdz(6666);
		assertEquals(lib,null);
	}
	@Test
	public void testBadago() 
	{
		lista.gehituLiburua(l1);
		lista.gehituLiburua(l2);
		lista.gehituLiburua(l5);
		
		assertTrue(lista.badago(l1));
		assertTrue(lista.badago(l2));
		assertTrue(lista.badago(l5));
		
		assertFalse(lista.badago(l3));
		assertFalse(lista.badago(l4));	
	}
	@Test
	public void testIdBerdinekoLibururikBaAlDa() 
	{
		lista.gehituLiburua(l1);
		lista.gehituLiburua(l2);
		lista.gehituLiburua(l3);

		assertTrue(lista.idBerdinekoLibururikBaAlDa(l1B));
		assertTrue(lista.idBerdinekoLibururikBaAlDa(l3B));
		
		assertFalse(lista.idBerdinekoLibururikBaAlDa(l4));
		assertFalse(lista.idBerdinekoLibururikBaAlDa(l5));
	}
	@Test
	public void testGehituLiburua() 
	{
		int zenbat = lista.listarenTamaina();
		lista.gehituLiburua(l1);						//l1 gehitu ahal
		assertEquals(zenbat+1, lista.listarenTamaina());
		
		zenbat = lista.listarenTamaina();
		lista.gehituLiburua(l2);						//l2 gehitu ahal
		assertEquals(zenbat+1, lista.listarenTamaina());
		
		zenbat = lista.listarenTamaina();
		lista.gehituLiburua(l1);						//l1 ezin gehitu, dagoeneko listan
		assertEquals(zenbat, lista.listarenTamaina());
	}
	@Test
	public void testKenduLiburua() 
	{
		lista.gehituLiburua(l1);
		lista.gehituLiburua(l2);
		lista.gehituLiburua(l3);
		lista.gehituLiburua(l4);

		int zenbat = lista.listarenTamaina();
		lista.kenduLiburua(l4); 						//l4 kendu ahal
		assertEquals(zenbat-1,lista.listarenTamaina());
		
		zenbat = lista.listarenTamaina();
		lista.kenduLiburua(l3); 						//l3 kendu ahal
		assertEquals(zenbat-1,lista.listarenTamaina());
		
		zenbat = lista.listarenTamaina();
		lista.kenduLiburua(l5); 						//l5 ezin kendu
		assertEquals(zenbat,lista.listarenTamaina());
	}
	@Test
	public void testInprimatu() 
	{
		lista.gehituLiburua(l1);
		lista.gehituLiburua(l2);
		lista.gehituLiburua(l3);
		lista.gehituLiburua(l4);
		lista.gehituLiburua(l5);
		lista.inprimatu();
	}
}
