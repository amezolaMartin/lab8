package packlaborategia8;

public class NAGUSIA 
{

	public static void main(String[] args) throws KatalogatzeanIdErrepikatuaSalbuespena, EzinBueltatuEzDagoelakoMailegatutaSalbuespena
	{
		// TODO Auto-generated method stub
		Liburua lib1, lib2, lib3, lib4, lib5, lib6;
		Katalogoa kat;
		Erabiltzailea erab1, erab2, erab3;

		//String pTitulua, String pIdazlea, int pIdLiburua
		
		lib1 = new Liburua ("El principe de las tinieblas","Gorka",1111);
		lib2 = new Liburua ("Apexero","Martin",2222);
		lib3 = new Liburua ("AhoBizi","Toni",3333);
		/* Liburu hauek id berdina du lib1, lib2 eta lib3-rekin, 
		horregatik, katalogatzean errore emango du eta liburuarenIdAldatu() metodoa saiatu beharko
		dugu. */
		lib4 = new Liburua ("El prince","Garni",1111); 
		lib5 = new Liburua ("Spaidermart", "Martin", 2222);
		lib6 = new Liburua ("Simarro en clase", "Mision Imposible", 3333);

		erab1 = new Erabiltzailea("Ramon Gonzalez", 1000);
		erab2 = new Erabiltzailea("Jorge Estebanez", 2000);
		erab3= new Erabiltzailea("Dari Goitia", 3000);
		ListaErabiltzaileak lista = ListaErabiltzaileak.getListaErabiltzaileak();
		lista.erabiltzaileariAltaEman(erab1);
		lista.erabiltzaileariAltaEman(erab2);


		//2.ataza
			//1.puntua
		System.out.println("_________________________");
		System.out.println("testErabiltzaileaBajaEman");
		System.out.println("");
		
		lista.erabiltzaileaBajaEman(1000);					//erab3 kendu ahal
		
		lista.erabiltzaileaBajaEman(2000);					//erab2 kendu ahal
		
		lista.erabiltzaileaBajaEman(3333);					//Ez dago listan, salbuespena saltatu behar
			
			//2.puntua
		System.out.println("_________________________");
		System.out.println("testItzuliLiburua");
		System.out.println("");
		
		lista.erabiltzaileariAltaEman(erab1);
		lista.erabiltzaileariAltaEman(erab2);
		lista.erabiltzaileariAltaEman(erab3);
		
		kat = Katalogoa.getKatalogoa();
		kat.erreseteatu();
		kat.katalogatuLiburua(lib1);
		kat.katalogatuLiburua(lib2);
		kat.katalogatuLiburua(lib3); //Hauek arazorik gabe katalogatu behar
		
		kat.mailegatuLiburua(1111, 1000);
		kat.mailegatuLiburua(2222, 2000); //Hauek biak arazorik gabe mailegatu behar
		
		kat.itzuliLiburua(1111);
		kat.itzuliLiburua(2222);
		kat.itzuliLiburua(3333);
			
			//3.puntua
		System.out.println("_________________________");
		System.out.println("testKatalogatuLiburua");
		System.out.println("");
		kat = Katalogoa.getKatalogoa();
		kat.katalogatuLiburua(lib1);
		kat.katalogatuLiburua(lib2);
		kat.katalogatuLiburua(lib3); // Meto los tres libros en el Katalogoaa
		
		/* Ahora meto el 4, 5 y 6, y como tiene el mismo id que otros, podemos ver si la salbuespena 
		 funciona. */
		
		kat.katalogatuLiburua(lib4); 
		kat.katalogatuLiburua(lib5);
		kat.katalogatuLiburua(lib6); 
	}
}
