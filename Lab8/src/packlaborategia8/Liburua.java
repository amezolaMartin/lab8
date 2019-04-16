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
	public String getTituloa ()
	{
		return this.titulua;
	}
	public int getId ()
	{
		return this.idLiburua;
	}
	public void liburuarenIdAldatu(int pId) 
	{
		if (this.getId()== pId)
		{
			System.out.println("Id berdina sartu duzu");
		}
		else
		{
			this.idLiburua = pId;
		}
	}
}
