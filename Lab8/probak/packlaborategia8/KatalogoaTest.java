package packlaborategia8;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KatalogoaTest {
	Katalogoa kat,katN;
	Liburua l,lN,l1,l2,l3,l4,l5,liburua;
	Erabiltzailea erabiltzailea, erab1, erab2, erab3;
	ListaErabiltzaileak lista, listaN;

	@Before
	public void setUp() throws Exception {
		//Liburuak
				l1 = new Liburua ("El principe de las tinieblas","Gorka",1111);
				l2 = new Liburua ("Apexero","Martin",2222);
				l3 = new Liburua ("AhoBizi","Toni",3333);
				l4 = new Liburua ("El prince","Garni",4444);
				l5 = new Liburua ("Harry Cipoter","J.K.",5555);
				liburua = new Liburua ("Aitortxu","Uri",0000);
				
				//Katalogoak
				kat = Katalogoa.getKatalogoa();
				
				//Erabiltzaileak
				erab1 = new Erabiltzailea ("Gorka Ortiz",1111);
				erab2 = new Erabiltzailea ("Gorka Ortiz",2222);
				erab3 = new Erabiltzailea ("Gorka Ortiz",3333);
				
					erab1.gehituLiburua(l1);
					
					erab2.gehituLiburua(l3);
					
					erab3.gehituLiburua(l5);
					
				//Lista Erabiltzaileak
				lista = ListaErabiltzaileak.getListaErabiltzaileak();
				lista.erabiltzaileariAltaEman(erab1);
				lista.erabiltzaileariAltaEman(erab2);
				lista.erabiltzaileariAltaEman(erab3);
	}

	@After
	public void tearDown() throws Exception {
		//Liburuak
				l = null;
				lN = null;
				l1 = null;
				l2 = null;
				l3 = null;
				l4 = null;
				l5 = null;
				
				//Katalogoak
				kat = null;
				katN = null;
				
				//Erabiltzaileak
				
				erab1 = null;
				erab2 = null;
				erab3 = null;
				erabiltzailea = null;
				
				//Lista Erabiltzaileak
				lista = null;
				listaN = null;
	}

	@Test
	public void testGetKatalogoa() {
		assertNull(katN);
		kat.katalogatuLiburua(l1);
		kat.katalogatuLiburua(l2);
		kat.katalogatuLiburua(l3);
		kat.katalogatuLiburua(l4);
		kat.katalogatuLiburua(l5);
		katN = Katalogoa.getKatalogoa();
		assertEquals(kat,katN);
	}

	@Test
	public void testLiburuKopuru() {
		kat.erreseteatu();
		int zenbat = kat.liburuKopuru();
		kat.katalogatuLiburua(l1);
		assertEquals(zenbat+1,kat.liburuKopuru());
		zenbat = kat.liburuKopuru();
		kat.katalogatuLiburua(l2);
		kat.katalogatuLiburua(l3);
		assertEquals(zenbat+2,kat.liburuKopuru());
	}

	@Test
	public void testBilatuLiburuaIdz() {
		kat = Katalogoa.getKatalogoa();
		kat.erreseteatu();
		kat.katalogatuLiburua(l1);
		kat.katalogatuLiburua(l2);
		kat.katalogatuLiburua(l3);
		liburua = kat.bilatuLiburuaIdz(1111);//l1 da
		assertEquals (liburua,l1);
		liburua = kat.bilatuLiburuaIdz(2222);
		assertEquals (liburua,l2);
		liburua = kat.bilatuLiburuaIdz(3333);
		assertEquals (liburua,l3);
		liburua = kat.bilatuLiburuaIdz(0000);
		assertNull(liburua);
	}

	@Test
	public void testMailegatuLiburua() 
	{
		System.out.println("testMailegatuLiburua:");
		
		kat.erreseteatu();
		Liburua l = new Liburua ("Proba","Proba",1001);
		Liburua ondo = new Liburua ("Ondo","Ondo",0101);
		kat.katalogatuLiburua(l1);
		kat.katalogatuLiburua(l2);
		kat.katalogatuLiburua(l3);
		kat.katalogatuLiburua(l4);
		kat.katalogatuLiburua(l5);
		kat.katalogatuLiburua(l);
		kat.katalogatuLiburua(ondo);
				
		//Liburua ez dago katalogoan
		kat.mailegatuLiburua(0000, 1111);
		assertNull(kat.bilatuLiburuaIdz(0000));
		//id hori duen erabiltzilerik ez dago
		kat.mailegatuLiburua(1111, 0000);
		assertNotNull(kat.bilatuLiburuaIdz(1111));
		//Dagoeneko mailegatuta dago
		kat.mailegatuLiburua(1111, 2222);
		assertNotNull(kat.bilatuLiburuaIdz(1111));
		//Mailegatze maximoa gaindituta
		kat.mailegatuLiburua(2222, 1111);
		kat.mailegatuLiburua(4444, 1111);
		kat.mailegatuLiburua(1001, 1111);
		//Mailegatu daiteke
		kat.mailegatuLiburua(0101, 3333);
		assertTrue(erab3.idBerdinaDute(lista.norkDaukaMaileguan(ondo)));
	}

	@Test
	public void testItzuliLiburua() throws EzinBueltatuEzDagoelakoMailegatutaSalbuespena
	{
		System.out.println("testItzuliLiburua");
		kat.erreseteatu();
		
		kat.katalogatuLiburua(l1);
		kat.katalogatuLiburua(l2);
		kat.katalogatuLiburua(l3);
		
		
		kat.itzuliLiburua(3333);		//arazorik gabe itzuli ahal l3
		assertNull(kat.bilatuLiburuaIdz(3333));
		
		kat.itzuliLiburua(2222);		//ezin itzuli l2, ez dago mailegatuta
		assertNull(kat.bilatuLiburuaIdz(2222));
		
		kat.itzuliLiburua(0000); 		//Ez da existitzen
		assertNull(kat.bilatuLiburuaIdz(0000));
		System.out.println("_________________________");
	}

	@Test
	public void testKatalogatuLiburua() {
		kat.erreseteatu();
		int zenbat = kat.liburuKopuru();
		kat.katalogatuLiburua(l1);					//Arazorik gabe katalogatu
		assertEquals(zenbat+1,kat.liburuKopuru());
		zenbat = kat.liburuKopuru();
		kat.katalogatuLiburua(l2);					//Arazorik gabe katalogatu
		kat.katalogatuLiburua(l3);
		assertEquals(zenbat+2,kat.liburuKopuru());
		kat.katalogatuLiburua(l1); 					//Dagoeneko listan
		zenbat = kat.liburuKopuru();				
		assertEquals(zenbat,kat.liburuKopuru());
	}

	@Test
	public void testDeskatalogatuLiburua() {
		System.out.println("testDeskatalogatuLiburua:");
		Liburua l;
		
		kat.erreseteatu();
		kat.katalogatuLiburua(l1);
		kat.katalogatuLiburua(l2);
		kat.katalogatuLiburua(l3);
		kat.katalogatuLiburua(l4);
		kat.katalogatuLiburua(l5);
				
		kat.deskatalogatuLiburua(1111);//Ezin daiteke deskatalogatu, dagoeneko mailegatuta erab1
		assertNotNull(kat.bilatuLiburuaIdz(1111));
		
		kat.deskatalogatuLiburua(0000);//Ezin daiteke deskatalogatu, ez dago katalogoan
		assertNull(kat.bilatuLiburuaIdz(0000));
		
		l = kat.bilatuLiburuaIdz(2222);//Deskatalogatu daiteke arazorik gabe
		assertTrue(l.idBerdinaDute(l2));
		kat.deskatalogatuLiburua(2222);
		assertNull(kat.bilatuLiburuaIdz(2222));
	}

	@Test
	public void testInprimatu() {
		System.out.println("testInprimatu:");
		kat.inprimatu();
	}

	@Test
	public void testErreseteatu() {
		kat.erreseteatu();
		assertEquals(0,kat.liburuKopuru());
		kat.katalogatuLiburua(l1);
		kat.katalogatuLiburua(l2);
		kat.katalogatuLiburua(l3);
		assertEquals(3,kat.liburuKopuru());
		kat.erreseteatu();
		assertEquals(0,kat.liburuKopuru());	
	}

}
