import java.util.ArrayList;

public class Warehouse {

	ArrayList<ArrayList<Item>> zones = new ArrayList<ArrayList<Item>>();
	ArrayList<Integer> timeToGet = new ArrayList<Integer>();
	

	public Warehouse(ArrayList<Integer> timeToGet) {
		for(int i = 0; i < timeToGet.size(); i ++)
		{
			zones.add(new ArrayList<Item>());
		}
		this.timeToGet = timeToGet;
	}

	public void placeItem(Item i, int zone)
	{	
		zones.get(zone).add(i);
	}

	@SuppressWarnings("unlikely-arg-type")
	public void removeItem(Integer id)
	{
		for(ArrayList<Item> ai : zones)
		{
			ai.remove(id);
		}
	}

	@Override
	public String toString() {
		String output = "";
		int counter = 0;
		for(ArrayList<Item> ai : zones)
		{
			output += "Zone " + counter + System.lineSeparator();
			for(Item i: ai)
			{
				output += i + System.lineSeparator();
			}
			counter ++;
		}
		return output;
	}

	public int countAverageTime(String sku) {
		int time = 0;
		int count = 0;
		int counter = 0;
		for(ArrayList<Item> ai : zones)
		{
			for(Item i: ai)
			{
				if(i.sku.equals(sku))
				{
					count ++;
					time += timeToGet.get(counter);
				}
			}
			counter ++;
		}
	

		return time / count;
	}



}
