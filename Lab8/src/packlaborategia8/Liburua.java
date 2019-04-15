package packlaborategia8;


public class Liburua
{
	// atributuak
	private String titulua;
	private String idazlea;
	private int idLiburua;
	// eraikitzaile
	public Liburua(String pTitulua, String pIdazlea, int pIdLiburua)
	{
		titulua = pTitulua;
		idazlea = pIdazlea;
		idLiburua = pIdLiburua;
	}
	// beste metodoak
	public boolean idHauDu(int pIdLiburua)
	{
		if (this.idLiburua == pIdLiburua)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean idBerdinaDute (Liburua pLiburua)
	{	
		if (pLiburua.idHauDu(this.idLiburua))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void inprimatu() 
	{
		System.out.println(this.titulua+"-ren idazlea "+this.idazlea+" da, "+this.idLiburua+" id-arekin");
	}
	
	public void liburuarenIdAldatu(int pId)
	{
		//Metodo honen helburua, liburu baten id aldatzea, horretarako erabiltzaileak
		//3 saiakera izango ditu, hiru saiakerak txarto egiten baditu, kontsolan agertuko da
		//mezu bat non katalogatze prozesua bertan behera utzi dela adierazten da.
	}
}
