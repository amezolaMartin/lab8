package packlaborategia8;

import java.util.Scanner;

public class Katalogoa 
{
	// atributuak
	private ListaLiburuak lista;
	private static Katalogoa nireListaLiburuak=null;
	
	// eraikitzailea
	
	private Katalogoa()
	{
		this.lista = new ListaLiburuak();
	}

 	// otros metodos
	
	public static Katalogoa getKatalogoa() 
	{
		if (Katalogoa.nireListaLiburuak == null)
		{
			Katalogoa.nireListaLiburuak = new Katalogoa();
		}
		return Katalogoa.nireListaLiburuak;
	}
 	public int liburuKopuru ()
 	{
 		return this.lista.listarenTamaina();
 	}
 	public Liburua bilatuLiburuaIdz(int pIdLiburua)
 	{
 	 	Liburua lib=this.lista.bilatuLiburuaIdz(pIdLiburua);
 	 	return lib;
 	}
 	public void mailegatuLiburua(int pIdLiburua, int pIdErabiltzailea)
	{
 		Liburua lib = this.bilatuLiburuaIdz(pIdLiburua);//Liburua aurkitu katalogoan
 		ListaErabiltzaileak listaErabil = ListaErabiltzaileak.getListaErabiltzaileak();
 		if (lib != null)
	 	{
 			Erabiltzailea e = listaErabil.bilatuErabiltzaileaIdz(pIdErabiltzailea);//Erabiltzailea aurkitu
 			if (e != null)
 			{
 				Erabiltzailea erab = listaErabil.norkDaukaMaileguan(lib);//Nork duen mailegatuta aurkitu
 	 			if (erab == null)
		 		{
		 			if (!e.mailegatzekoMaximoaGainditua())
		 			{
		 				e.gehituLiburua(lib);
		 				System.out.println("Ondo mailegatuta");
		 			}
		 			else
		 			{
		 				System.out.println("Ezin daiteke mailegatu, mailegatze maximoa gainditu delako");
		 			}
		 		}
		 		else
		 		{
		 			System.out.println("Ezin daiteke mailegatu, dagoeneko mailegatuta dagoelako");
		 		}
 			}
 			else
 			{
 				System.out.println("Ezin daiteke liburua mailegatu, ez dago id hori duen Erabiltzailerik");
 			}
 		}
 		else
 		{
 			System.out.println("Ezin daiteke liburua mailegatu, ez da liburua exititzen");
 		}
	}
 	public void itzuliLiburua(int pIdLiburua) 
	{
 		Liburua Lib = this.lista.bilatuLiburuaIdz(pIdLiburua);
 		if (Lib != null)
 		{
	 		try
	 		{
	 			this.itzulketaKonprobatu(Lib);
	 			System.out.println(Lib.getTituloa()+" liburua ondo itzuli da");
	 		}
	 		catch (EzinBueltatuEzDagoelakoMailegatutaSalbuespena e)
	 		{
	 			System.out.println(e.getMessage());
	 			Lib.inprimatu();
	 		}
	 		finally
	 		{
	 			System.out.println("");
	 		}
 		}
	}
 	private void itzulketaKonprobatu (Liburua Lib) throws EzinBueltatuEzDagoelakoMailegatutaSalbuespena
 	{
	 	if (Lib != null)
	 	{
	 		if (ListaErabiltzaileak.getListaErabiltzaileak().norkDaukaMaileguan(Lib) != null)
	 		{
	 			this.lista.kenduLiburua(Lib);
	 			System.out.println(Lib.getTituloa()+" liburua, ondo itzuli da");
			}
			else
			{
	 			throw (new EzinBueltatuEzDagoelakoMailegatutaSalbuespena());
	 		}
	 	}
 	}
 	public void katalogatuLiburua(Liburua pLiburua) 
 	{	
 		boolean denaKontrolpean = false;
 		int saiakerak = 1;
 		
 		do
 		{
 			try
 			{
 				if (!this.lista.idBerdinekoLibururikBaAlDa(pLiburua))
 				{
 					this.lista.gehituLiburua(pLiburua);
 					System.out.println(pLiburua.getTituloa()+" liburua ondo katalogatuta");
 					denaKontrolpean = true; // Y sale del do/while.
 				}
 			}
 			catch (KatalogatzeanIdErrepikatuaSalbuespena e) /*a este catch va a entrar solo si cuando hacemos la comprobacion 
 															idBerdinekoLibururikBaAlDa es true*/
 			{
 				System.out.println(pLiburua.getTituloa()+" "+e.getMessage());
 				Scanner sc = new Scanner (System.in);
				System.out.println(saiakerak+". saiakera, Sartu id berri bat mesedez:");
				int pId = sc.nextInt(); // Escanea el número que mete el erabiltzaile.				
				pLiburua.liburuarenIdAldatu(pId);
				/* Si el id que ha metido sigue siendo el mismo, printea saiatu berriro. Sino, lo cambia. Y en la siguiente vuelta,
				entra en el if y sale del do/while*/
 				saiakerak ++;
 			} 			
 		}while (!denaKontrolpean && saiakerak <= 3);
		if (!denaKontrolpean)
		{
			System.out.println("Hiru saiakerak agortu dituzu, katalogatze prozesua bertan behera utzi da.");
	 		denaKontrolpean = true;
		}
		System.out.println("");
 	}	
 	public void deskatalogatuLiburua(int pIdLiburua)
 	{
 		ListaErabiltzaileak listaErabil = ListaErabiltzaileak.getListaErabiltzaileak();
 		Liburua lib = this.lista.bilatuLiburuaIdz(pIdLiburua);
 		if (lib != null)
 		{
 			Erabiltzailea erab = listaErabil.norkDaukaMaileguan(lib);
 			if (erab == null)
 			{
 				this.lista.kenduLiburua(lib);
 			}
 			else
 			{
 				System.out.println("Ezin da deskatalogatu, dagoeneko mailegatuta dago");
 			}
 		}
		else
		{
			System.out.println("Ezin da deskatalogatu, ez dago katalogoan");
		}
 	}
 	public void inprimatu()
 	{
 		this.lista.inprimatu();
 	}
 	public void erreseteatu()
 	{
 		this.lista.erreseteatu();
 	}
}	