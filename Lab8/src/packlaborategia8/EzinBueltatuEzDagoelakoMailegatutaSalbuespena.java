package packlaborategia8;

public class EzinBueltatuEzDagoelakoMailegatutaSalbuespena extends Exception 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; /* Esto se pone solo porque salia un warning
	y si lo pones se quita */

	public EzinBueltatuEzDagoelakoMailegatutaSalbuespena (Liburua lib)
	{
		System.out.println("Liburua ez dago mailegatuta, beraz ezin daiteke itzuli.");
		lib.inprimatu();
	}
}
