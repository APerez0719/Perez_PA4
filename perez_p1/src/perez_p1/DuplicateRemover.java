package perez_p1;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;


public class DuplicateRemover {
	private Set<String> uniqueWords;
	//Using this, we can take the file name as input and remove duplicates using the Set
	
	public void remove(String data) throws FileNotFoundException {
		String word;
		uniqueWords = new HashSet<String>();
		Scanner scnr = new Scanner(new File(data));
		
		while(scnr.hasNext())
		{
			word = scnr.next();
			uniqueWords.add(word);
		}
		
		scnr.close();
	}
	
//This method will write the finished contents to the output file.
public void Write(String output) throws IOException {
	File f;
	FileWriter fw = null;
	
	f = new File(output);
	
	//If a file f has already been created, we can simply just write the output to the existing file.
	if(f.exists()) {
		fw = new FileWriter(f, true);
		Iterator itr = uniqueWords.iterator();
		
		while(itr.hasNext()) {
			String str = (String) itr.next();
			fw.write(str + "\n");
		}
		
		fw.close();
		// System.out.println("We just finished writing to the file!!!");
	} else {
		// Else statement covers the possibility that the file f doesn't exist beforehand.
		f.createNewFile();
		fw = new FileWriter(f);
		Iterator itr = uniqueWords.iterator();
		
		while(itr.hasNext())
		{
			String str = (String)itr.next();
			fw.write(str + "\n");
		}
		
		fw.close();
		System.out.println("Date Written to File");
	}
}
}