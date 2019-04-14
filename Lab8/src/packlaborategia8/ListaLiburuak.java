package packlaborategia8;


import java.util.ArrayList;
import java.util.Iterator;

public class ListaLiburuak
{
	// atributuak
	
	private ArrayList<Liburua> lista;

	// eraikitzailea
	
	public ListaLiburuak()
	{
		this.lista = new ArrayList<Liburua>();
	}
	
	// beste metodoak
	
	public int listarenTamaina()
	{  
		return this.lista.size();
	}
	private Iterator<Liburua> getIteradorea()
	{
		return this.lista.iterator();
	}
	public Liburua bilatuLiburuaIdz(int pIdLiburua)
	{
		Liburua liburua = null;
		boolean salataria = false;
		Iterator<Liburua>itr = this.getIteradorea();
		while (itr.hasNext() && !salataria)
		{
			liburua = itr.next();
			if (liburua.idHauDu(pIdLiburua))
			{
				salataria = true; 
			}
		}
		if (!salataria)
		{
			liburua = null;
		}
		return liburua;
	}
	public boolean badago(Liburua pLiburua)
	{
		boolean emaitza = false;
		if (this.lista.contains(pLiburua))
		{
			emaitza = true;
		}
		return emaitza;
	}
	public boolean idBerdinekoLibururikBaAlDa(Liburua pLiburua)
	{
		Iterator<Liburua>itr = this.getIteradorea();
		boolean emaitza = false;
		Liburua lib = null;
		while (itr.hasNext() && !emaitza)
		{
			lib = itr.next();
			if (lib.idBerdinaDute(pLiburua))
			{
				emaitza = true;
			}
		}
		return emaitza;
	}
	public void gehituLiburua(Liburua pLiburua)
    {
		if (!this.lista.contains(pLiburua)) 
		{
			this.lista.add(pLiburua);
		}
		else
		{
			// TODO.
		}
    }
	public void kenduLiburua(Liburua pLiburua)
    {
		if(this.lista.contains(pLiburua))
		{
			this.lista.remove(pLiburua);
		}
	}
	public void inprimatu()
	{
		int i = 0;
		Liburua lib = null;
		Iterator<Liburua>itr = this.getIteradorea();
		while (itr.hasNext())
		{
			i++;
			System.out.println(i+":");
			lib = itr.next();
			lib.inprimatu();
		}
	}
	public void erreseteatu()
	{
		this.lista.clear();
	}
 }
