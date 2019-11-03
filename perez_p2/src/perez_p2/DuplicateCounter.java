package perez_p2;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;


public class DuplicateCounter {
	private Map<String, Integer> map;
	private HashMap<String, Integer> wordCounter;
	
	public DuplicateCounter() {
		this.wordCounter = new HashMap<String, Integer>();
		this.map = new HashMap<>();
	}
	
	public void count(String dataFile) {
		Scanner reader;
		try {
			reader = new Scanner(new File(dataFile));
			while(reader.hasNextLine()) {
				String str1 = reader.next().trim();
				String[] data = line.split("[\\W]+");
				
				for(String word : data) {
					this.wordCounter = map.get(word);
					this.wordCounter = (this.wordCounter == null) ? 1: ++this.wordCounter;
					map.compute(word,  this.wordCounter);
				}
			}
			
			reader.close();
		} catch(FileNotFoundException fnfe) {
			//Exits program if exception is found.
			System.exit(1);
		}
	}
	
	public void write(String outputFile)
	{
		FileWriter fw;
		PrintWriter pw;
		try {
			fw = new FileWriter(new File(outputFile));
			pw = new PrintWriter(fw);
			
			for(Map.Entry<String, Integer> entry : map.entrySet())
			{
				pw.write(entry.getKey() + " occurs " + entry.getValue() + " times" + System.lineSeparator());
			}
			
			pw.flush();
			fw.close();
			pw.close();
		} catch (IOException ex) {
			// Exits program if exception is found.
			System.exit(1);
		}
	}
}

