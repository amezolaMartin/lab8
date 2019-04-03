

public class Erabiltzailea
{
	//atributuak

	private int idErabilitzailea;
	private String izenOsoa;
	private int maxLiburuak;
	private ListaLiburuak liburuMailegatuak;
	
	//eraikitzailea
	
	public Erabiltzailea(String pIzenOsoa, int pIdErabiltzaile)
	{
		this.idErabilitzailea = pIdErabiltzaile;
		this.izenOsoa = pIzenOsoa;
		this.maxLiburuak = 3;
		this.liburuMailegatuak = new ListaLiburuak();
	}
	
	// beste metodoak
	
	public boolean idHauDu(int pId)
	{
		if (this.idErabilitzailea == pId)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public int zenbat ()
	{
		return this.liburuMailegatuak.listarenTamaina();
	}
	public boolean idBerdinaDute(Erabiltzailea pErabiltzailea)
	{
		boolean emaitza = false;
		if (pErabiltzailea.idHauDu(this.idErabilitzailea))
		{
			emaitza = true;;
		}
		return emaitza;
	}	
	public boolean mailegatzekoMaximoaGainditua()
	{
		if (this.liburuMailegatuak.listarenTamaina() >= this.maxLiburuak)
		{
			return true;
		}else
		{
			return false;
		}
	}
	public void gehituLiburua(Liburua pLiburua)
	{
		this.liburuMailegatuak.gehituLiburua(pLiburua);
	}
	public void kenduLiburua(Liburua pLiburua)
	{
		this.liburuMailegatuak.kenduLiburua(pLiburua);
	}
	public boolean maileguanDu(Liburua pLiburua)
	{
		if (this.liburuMailegatuak.badago(pLiburua))
		{
			return true;
		}else
		{
			return false;
		}
	}
	public void inprimatu()
	{
		System.out.println(this.idErabilitzailea+", "+this.izenOsoa+":");
		if (this.liburuMailegatuak.listarenTamaina() == 0)
		{
			System.out.println("Ez ditu libururik maileguan");
		}else
		{
			this.liburuMailegatuak.inprimatu();
		}
	}
}
