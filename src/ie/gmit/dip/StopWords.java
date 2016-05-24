package ie.gmit.dip;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 
 * @author amynashAmy
 *
 */

public class StopWords {
	
	final TreeSet <String> ignore = new TreeSet<String>();
	
	/**
	 * Create a Treeset ignore
	 * @return
	 */
	
	public TreeSet <String> stopWords () {
		
		Scanner s;
		try {
			s = new Scanner(new File("textfiles/stopwords.txt"));
			while(s.hasNextLine()){
				String nextWord = s.nextLine();
				ignore.add(nextWord);
				}
	/**
	 * Scanner scans in the textfile.
	 * While the textfile has a next line add each word to the TreeSet
	 */
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ignore;

	}
}