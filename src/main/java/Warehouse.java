import java.util.ArrayList;
import java.util.Iterator;

public class Warehouse {

	ArrayList<ArrayList<Item>> zones = new ArrayList<ArrayList<Item>>();
	ArrayList<Integer> timeToGet = new ArrayList<Integer>();
	ArrayList<Integer> space = new ArrayList<Integer>();

	public Warehouse(ArrayList<Integer> timeToGet,ArrayList<Integer> space) {
		for(int i = 0; i < timeToGet.size(); i ++)
		{
			zones.add(new ArrayList<Item>());
		}
		this.timeToGet = timeToGet;
		this.space = space;
	}

	public int placeItem(Item i, int zone)
	{	
		//only place if space availaible 
		if(zones.get(zone).size() < space.get(zone))
		{
			for(ArrayList<Item> ai : zones)
			{
				for(Item it: ai)
				{
					if(it.id == i.id)
					{
						return -1;
					}
				}
			}
			zones.get(zone).add(i);
			return 0;
			
		}
		return -1;
	}

	@SuppressWarnings("unlikely-arg-type")
	public void removeItem(Integer id)
	{
		for(ArrayList<Item> ai : zones)
		{
			Iterator<Item> iter = ai.iterator();

			while (iter.hasNext()) {
				Item i = iter.next();

				if (i.equals(id))
					iter.remove();
			}		}
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

	public Double countReciprocalAverageTime(String sku) {
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

		if(count == 0)
		{
			return 0.0;
		}
		return 1/ ((double) time / count);
	}

	public Double totalReciprocalTime()
	{
		Double count = 0.0;
		for(String s: RatioFinder.skus)
		{
			count += countReciprocalAverageTime(s);
		}
		return count;
	}
	
	public ArrayList<Double> currentRatio()
	{
		ArrayList<Double> ratios = new ArrayList<Double>();
		Double totalTime = totalReciprocalTime();
		for(String s: RatioFinder.skus)
		{
			ratios.add(countReciprocalAverageTime(s) / totalReciprocalTime());
		}
		return ratios;
	}
	
	public Double testZone(Item i, int zone)
	{
		if(zones.get(zone).size() > space.get(zone))
		{
			return -1.0;
		}
		placeItem(i,zone);
		for(int z = 0; z  < RatioFinder.skus.size(); z ++)
		{
			if(RatioFinder.skus.get(z).equals(i.sku))
			{
				ArrayList<Double> ratios = currentRatio();
				removeItem(i.id);
				return ratios.get(z);
			}
		}
		return -1.0;
	}



}
