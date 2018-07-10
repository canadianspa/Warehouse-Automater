import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		 
		// RatioFinder.findRatio();
		// for(int i = 0; i < RatioFinder.skus.size(); i ++)
		// {
		//	 System.out.println(RatioFinder.skus.get(i) + " " + RatioFinder.ratios.get(i));
		// }
		 RatioFinder.tester();
		 String toronto = "KK-10";
		 String victoria = "KH-33";
		 String hamilton = "KP-66";
		 ArrayList<Integer> timeToGet = new ArrayList<Integer>();
		 timeToGet.add(5);
		 timeToGet.add(8);
		 timeToGet.add(20);
		 timeToGet.add(45);
		 timeToGet.add(60);
		 Warehouse w = new Warehouse(timeToGet);
		 
		 Item i1 = new Item(toronto);
		 Item i2 = new Item(victoria);
		 Item i3 = new Item(hamilton);
		 
		 w.placeItem(i1, 0);
		 w.placeItem(i2, 0);
		 w.placeItem(i3, 1);
		 
		 System.out.println(w);

	}

}
