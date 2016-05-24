package ie.gmit.dip;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;
import javax.swing.JOptionPane;

/**
 * 
 * @author amynashAmy
 *
 */

public class NewDictionary{

	Map<String, WordDetail> map = new HashMap<String, WordDetail>();
	Dictionary d = new Dictionary();
	Map <String, String> dictionary = d.dictionary();
	StopWords stop = new StopWords();
	final TreeSet <String> ignore = stop.stopWords();
	
	/**
	 * Creates a new map called dictionary mapping keys as Strings
	 * to WordDetail Values
	 * Creates an instance of dictionary map
	 * Creates an instance of stop TreeSet
	 * @param text
	 * @throws IOException
	 */
	
	public void newDictionary(String text) throws IOException {
		int linecounter = 0;
		int page = 1;
	/**
	 * Take the String text value from the menu class
	 * Begin the linecounter at 0 and the page counter at 1
	 */
	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(text)));
	try {
		while ((text = br.readLine()) != null) {
			linecounter++; 
			if (linecounter % 40 == 0)
			page++;
			String [] words = text.replaceAll("[^a-zA-Z]+"," ").toLowerCase().split(" ");
			for (int i = 0; i <words.length; i++){
				String word = words[i];
	/**
	 * Divide the line counter by 40, where each 40 lines is a page.
	 * The String array words is set to lower case and split by spaces
	 */
		if(ignore.contains(word)){
			continue;
		}
	/**
	 * If the ignore treeset contains any of the words in the text; continue.
	 */
		if (map.containsKey(word)){
			WordDetail wd = map.get(word);
			wd.addIndex(page);
	/**
	 * If the map contains the word, add a page index
	 */
		
		}else{
			WordDetail wd = new WordDetail();
			String newKey;
			newKey = "\"" + word + "\"";
			String definition = dictionary.get(newKey);
		if (definition != null){
			wd.setDefinition(definition);
			wd.addIndex(page);
			
	/**
	 * If the definition is not equaled to null, set the 
	 * definition and add a page index.
	 */
		}else{
			wd.setDefinition("is not defined");
			wd.addIndex(page);
	/**
	 * If the definition is null, set the definition to "not defined", 
	 * and add a page index
	 */
		}	

		map.put(words[i], wd);
	/**
	 * Put the keys and values on the map
	 */
		
		} 		
	}		
} 
		
}catch (IOException e) {
	
	} getUserOption2();
}
	
	private void getUserOption2() throws IOException{
		StringBuffer sbb = new StringBuffer();
		boolean keepRunning = true;
		sbb.append("What would you like to do? \n");
		sbb.append("1. Download the book\n");
		sbb.append("2. Search for a word \n");
		sbb.append("3. Exit\n");
		sbb.append("Enter Option [1-3]>");
		String menuText2 = sbb.toString();
		System.out.println(menuText2);
		@SuppressWarnings("resource")
		Scanner ss = new Scanner(System.in);
		while (keepRunning){
			int option2 = ss.nextInt();
			if (option2 == 1) {
				download();
			}else if (option2 == 2){
				search();
			}else if (option2 == 3){
				System.out.println("Bye!");
				keepRunning = false;
			}else{
			System.out.println("Enter a value [1-3]>");
		}
	}
}

	private void download() throws IOException {
		FileWriter fstream;
	    BufferedWriter out = null;
		fstream = new FileWriter("textfiles/BookIndex.txt");
	    out = new BufferedWriter(fstream);
	    Iterator<String> keySetIterator = map.keySet().iterator();
		Iterator<WordDetail> valuesIterator = map.values().iterator();
		while(keySetIterator.hasNext()){
			while(valuesIterator.hasNext()){
				String key = keySetIterator.next();
				WordDetail value = valuesIterator.next();
		/**
		 * The File writer writes streams of characters.
		 * The key and value iterator to iterate over all keys and values 
		 * in the map.
		 */
				value = map.get(key);
				out.write("\n" + "Word: " + key + "\n" + "Definition:" + value.getDefinition().toString()
							 + "\n" + "Index:" + value.getIndices() + "\n\n");
			}
		}
		
		/**
		 * The buffered writer writes each word as the key
		 * and the word type and definition as a value.
		 */
	 out.flush();
	 out.close();  
	 getUserOption2();
	}

	private void search() throws IOException {
		Iterator<WordDetail> valuesIterator = map.values().iterator();
		String key = JOptionPane.showInputDialog("Search for a word");
		WordDetail value = valuesIterator.next();
		value = map.get(key.toLowerCase());
		if (map.containsKey(key.toLowerCase())){
			String value2 = value.getDefinition().toString();
			JOptionPane.showMessageDialog(null, "Definition of "+ key + ": " + value2, "Dictionary", JOptionPane.PLAIN_MESSAGE );
		}else{
		JOptionPane.showMessageDialog(null, "Definition of "+ key + " is not defined" , "Dictionary", JOptionPane.PLAIN_MESSAGE );
	  }
		getUserOption2();
	}
}
	/**
	 * 
	 * A dialog box prompts the user to search for a word.
	 * Iterates over the values in the map.
	 * The hashcode values are converted to Strings.
	 * Another dialog box displays the values for the word that was searched.
	 */



