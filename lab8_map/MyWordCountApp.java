package lab8_map;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MyWordCountApp {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";
	// <word, its occurences>
	private Map<String, Integer> map = new HashMap<String, Integer>();

	// Load data from fileName into the above map (containing <word, its occurences>)
	// using the guide given in TestReadFile.java
	
	public MyWordCountApp() throws FileNotFoundException {
		this.loadData();
	}
	
	public void loadData() throws FileNotFoundException {
		Scanner input= new Scanner(new File(fileName));
		
		while(input.hasNext()) {
			String word= input.next();
			map.put(word, map.getOrDefault(word, 0)+1);
		}
		
		System.out.println(map);
		input.close();
	}

	// Returns the number of unique tokens in the file data/hamlet.txt or fit.txt
	public int countUnique() {
		return this.map.size();
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public void printWordCounts() throws FileNotFoundException {
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key= entry.getKey();
			Integer value= entry.getValue();
			
			System.out.print(key+"-"+value+"; ");
		}
		
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public void printWordCountsAlphabet() {
		Map<String, Integer> re= new TreeMap<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		
		re.putAll(map);
		System.out.println(re);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		MyWordCountApp app = new MyWordCountApp();
		
		System.out.println(app.countUnique());
	    app.printWordCounts();
	    System.out.println();
	    app.printWordCountsAlphabet();
	    
	    System.out.println(app.map);
	}
}
