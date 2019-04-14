package packlaborategia8;

public class EzinBueltatuEzDagoelakoMailegatutaSalbuespena extends Exception 
{
	public EzinBueltatuEzDagoelakoMailegatutaSalbuespena (Liburua lib)
	{
		System.out.println("Liburua ez dago mailegatuta, beraz ezin daiteke itzuli.");
		lib.inprimatu();
	}
}
