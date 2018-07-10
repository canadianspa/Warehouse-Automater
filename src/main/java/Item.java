
public class Item {

	
	
	private static int idCounter = 0;    
	
	int id;
	String sku;
	

	public Item(String sku) {
		this.id = idCounter;
		this.sku = sku;
		idCounter += 1;
	}


	@Override
	public boolean equals(Object obj) {

		if (obj == this) {
			return true;
		}

		/* Check if o is an instance of Complex or not
	          "null instanceof [type]" also returns false */
		if (!(obj instanceof Integer)) {
			return false;
		}
		Integer i = (Integer) obj;
		
		if(id == i)
		{
			return true;
		}
		return false;

	}


	@Override
	public String toString() {
		return id + " " + sku;
	
	}


}
