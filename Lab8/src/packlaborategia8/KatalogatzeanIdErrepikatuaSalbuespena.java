package packlaborategia8;

import java.util.Scanner;

public class KatalogatzeanIdErrepikatuaSalbuespena extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	
	public KatalogatzeanIdErrepikatuaSalbuespena (Liburua liburua)
	{
		//Metodo honen helburua, liburu baten id aldatzea, horretarako erabiltzaileak
		//3 saiakera izango ditu, hiru saiakerak txarto egiten baditu, kontsolan agertuko da
		//mezu bat non katalogatze prozesua bertan behera utzi dela adierazten da.
		Scanner sc = new Scanner (System.in);
		int pId = 0;
		int saiakerak = 1;
		boolean salataria = false;
		while (saiakerak <= 3 && !salataria)
		{
			System.out.println("	"+saiakerak+". saiakera. Sartu liburu honetarako ID berri bat:");
			pId = sc.nextInt();
			if (Katalogoa.getKatalogoa().bilatuLiburuaIdz(pId) == null)
			{
				salataria = true;
				liburua.liburuarenIdAldatu(pId);
			}
			else
			{
				System.out.println("ID hori dagoeneko beste liburu batek du");
				saiakerak ++;
			}
		}
		sc.close();
		if (!salataria)
		{
			System.out.println("Saiakera guztiak agortu dituzu, katalogatze prozesua eten da");
		}
		else
		{
			System.out.println("Ondo katalogatuta, id berria hau da: "+pId);
		}	
	}
}