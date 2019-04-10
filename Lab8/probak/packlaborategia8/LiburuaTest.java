package packlaborategia8;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packlaborategia8.Liburua;

public class LiburuaTest 
{
	Liburua l,lN,l1,l1B,l2,l3,l3B,l4,l5;
	@Before
	public void setUp() throws Exception 
	{
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
		l = null;
		lN = null;
		l1 = null;
		l1B = null;
		l2 = null;
		l3 = null;
		l3B = null;
		l4 = null;
		l5 = null;
	}
	@Test
	public void testLiburua() 
	{
		assertNull(lN);
		
		assertNotNull(l1);	assertNotNull(l1B);
		assertNotNull(l2);
		assertNotNull(l3);	assertNotNull(l3B);	
		assertNotNull(l4);
		assertNotNull(l5);
	}

	@Test
	public void testIdHauDu() 
	{
		assertFalse (l1.idHauDu(1112));
		assertFalse (l2.idHauDu(1111));
		
		assertTrue (l3.idHauDu(3333));
		assertTrue (l4.idHauDu(4444));
		assertTrue (l5.idHauDu(5555));
	}

	@Test
	public void testIdBerdinaDute() 
	{
		assertFalse(l1.idBerdinaDute(l2));
		assertFalse(l2.idBerdinaDute(l3));
		
		assertTrue(l1.idBerdinaDute(l1B));
		assertTrue (l3.idBerdinaDute(l3B));
	}

	@Test
	public void testInprimatu() 
	{
		l1.inprimatu();
		l2.inprimatu();
		l3.inprimatu();
		l4.inprimatu();
		l5.inprimatu();
	}
}
