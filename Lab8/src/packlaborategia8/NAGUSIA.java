package packlaborategia8;

public class NAGUSIA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Liburua lib1, lib2, lib3, lib4;
		Katalogoa kat;
		Erabiltzailea erab1, erab2, erab3, erab4;

		//String pTitulua, String pIdazlea, int pIdLiburua
		
		lib1 = new Liburua ("El principe de las tinieblas","Gorka",1111);
		lib2 = new Liburua ("Apexero","Martin",2222);
		lib3 = new Liburua ("AhoBizi","Toni",3333);
		lib4 = new Liburua ("El prince","Garni",1111); /* Liburu hauu id berdina du lib1-rekin, 
		horregatik, katalogatzean errore emango du eta liburuarenIdAldatu() metodoa saiatu beharko
		dugu. */

		erab1 = new Erabiltzailea("Ramon Gonzalez", 1000);
		erab2 = new Erabiltzailea("Jorge Estebanez", 2000);// jola
		erab3= new Erabiltzailea("Dari Goitia", 3000);
		erab4 = new Erabiltzailea("Pepe el de las Papas", 4000);

		
		kat = Katalogoa.getKatalogoa();
		kat.katalogatuLiburua(lib1);
		kat.katalogatuLiburua(lib2);
		kat.katalogatuLiburua(lib3); // Meto los tres libros en el Katalogoa.
		
		
//		kat.mailegatuLiburua(1111, 1000);

		

		
		
		

	}

}
