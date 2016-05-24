package ie.gmit.dip;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author amynashAmy
 *	Reads in a full Dictionary
 */
public class Dictionary {
	
	Map <String, String> dictionary = new HashMap<String, String>(); 
	public Map <String, String> dictionary(){
		final String DICTIONARY = "textfiles/dictionary.csv".toLowerCase();
		
		/**
		 * Creates a dictionary map where the words are the keys
		 * and the wordtypes and definitions are the values 
		 */
	try {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(DICTIONARY)));
		String line = "";
		String cvsSplitBy = ",";
		StringBuffer sb = new StringBuffer();
		/**
		 * Reads in dictionary file and splits the entries by a comma
		 */
		
		while ((line = br.readLine()) != null) {
			String[]arr = line.split(cvsSplitBy);
			String key = arr[0];
			for (int i = 1; i < arr.length; i++) {
				sb.append(arr[i]); 
				}
		/**
		 * Split the entries and read the word at position zero
		 * i.e. the first word. Read the words from position 1 and increment 
		 * until the next split to get the the word type and definition
		 */
			String value = sb.toString();
				if (! key.startsWith("\""))
				continue;
		/**
		 * Assign the words in the stringbuffer to values
		 * If the key does not start with inverted commas
		 * continue
		 */
				dictionary.put(key.toLowerCase(), value);
				sb = new StringBuffer();	
				}
		/**
		 * Put the keys and values on the map
		 */
		br.close();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dictionary;
	}
}
