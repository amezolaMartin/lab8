package packlaborategia8;


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
 	public void itzuliLiburua(int pIdLiburua) throws EzinBueltatuEzDagoelakoMailegatutaSalbuespena
	{
	 	Liburua Lib = this.lista.bilatuLiburuaIdz(pIdLiburua);
	 	if (Lib != null)
	 	{
	 		if (ListaErabiltzaileak.getListaErabiltzaileak().norkDaukaMaileguan(Lib) != null)
	 		{
	 			this.lista.kenduLiburua(Lib);
			}
			else
			{
	 			throw (new EzinBueltatuEzDagoelakoMailegatutaSalbuespena (Lib));
	 		}
	 	}
	}
 	public void katalogatuLiburua(Liburua pLiburua)
 	{		
 		this.lista.gehituLiburua(pLiburua);
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