import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class RatioFinder {

	static ArrayList<String> skus = new ArrayList<String>();
	static ArrayList<Double> ratios = new ArrayList<Double>();


	public static void tester()
	{
		skus.add("KK-10");
		skus.add("KH-33");
		skus.add("KP-66");
		ratios.add(0.6);
		ratios.add(0.3);
		ratios.add(0.1);
	}

	public static void findRatio()
	{
		String csvFile = "v2.csv";
		String line = "";
		String cvsSplitBy = ",";
		Integer count = 0;
		ArrayList<String> skus = new ArrayList<String>();
		ArrayList<Integer> sales = new ArrayList<Integer>();
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			br.readLine();
			while ((line = br.readLine()) != null) {


				try {
					line = line.replaceAll("\".*?\"","");
					// use comma as separator
					String[] report = line.split(cvsSplitBy);
					//System.out.println(report[11]);
					//System.out.println(report[1]);
					Integer sold = Integer.parseInt(report[11]);
					sales.add(sold);
					count += sold;
					skus.add(report[1]);
				} catch (Exception e) {
					System.out.println(line);
					e.printStackTrace();
				}



			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < skus.size(); i ++)
		{
			ratios.add(Double.valueOf(sales.get(i)) / count);
		}
		RatioFinder.skus = skus;

	}

}
