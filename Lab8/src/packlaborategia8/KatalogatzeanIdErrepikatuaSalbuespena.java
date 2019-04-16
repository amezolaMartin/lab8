package packlaborategia8;

public class KatalogatzeanIdErrepikatuaSalbuespena extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	
	public KatalogatzeanIdErrepikatuaSalbuespena ()  
	{
		super ("Ezin da katalogatu, Id hori dagoeneko liburu batek duelako");
	}
}