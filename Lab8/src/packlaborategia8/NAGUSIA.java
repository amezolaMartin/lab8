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
		lib4 = new Liburua ("El prince","Garni",4444);

		erab1 = new Erabiltzailea("Ramon Gonzalez", 1234);
		erab2 = new Erabiltzailea("Ramon Gonzalez", 1234);
		erab3= new Erabiltzailea("Ramon Gonzalez", 1111);
		erab4 = new Erabiltzailea("Ramon Gonzalez", 1234);

		
		kat = Katalogoa.getKatalogoa();
		kat.mailegatuLiburua(lib1, pIdErabiltzailea);
		
		

	}

}
