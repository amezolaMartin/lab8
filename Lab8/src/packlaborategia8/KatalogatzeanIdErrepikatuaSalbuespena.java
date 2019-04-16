package packlaborategia8;

import java.util.Scanner;

public class KatalogatzeanIdErrepikatuaSalbuespena extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	
	public KatalogatzeanIdErrepikatuaSalbuespena (Liburua liburua) throws KatalogatzeanIdErrepikatuaSalbuespena
	{
		//Metodo honen helburua, liburu baten id aldatzea, horretarako erabiltzaileak
		//3 saiakera izango ditu, hiru saiakerak txarto egiten baditu, kontsolan agertuko da
		//mezu bat non katalogatze prozesua bertan behera utzi dela adierazten da.
		Scanner sc = new Scanner (System.in);
		int pId = 0;
		liburua.liburuarenIdAldatu(pId);
		Katalogoa.getKatalogoa().katalogatuLiburua(liburua);
		sc.close();
	}
}