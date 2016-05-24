package ie.gmit.dip;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.IOException;
/**
 * 
 * @author amynashAmy
 *
 */
public class Menu extends NewDictionary{
	
	private String menuText = null;
	Map<String, WordDetail> map = new HashMap<String, WordDetail>();
	private Scanner sc = new Scanner(System.in);
	Dictionary d = new Dictionary();
	NewDictionary nd = new NewDictionary();
	StopWords s = new StopWords();
	int option;
	
	/**
	 * Create instance of Dictionary, NewDictioanry and StopWords
	 */
	
	public Menu() {
		super();
		this.buildMenu();
		System.out.println(menuText);
		try {
			this.getUserOption();
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the user interface menuText
	 */
	private void buildMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("-------------------------------\n");
		sb.append("\tDictionary\n");
		sb.append("-------------------------------\n");
		sb.append("Choose a book \n");
		sb.append("1. Poblacht na HEirean \n");
		sb.append("2. Happy Prince\n");
		sb.append("3. War and Peace\n");
		sb.append("4. Divine Comedy\n");
		sb.append("5. The Prince\n");
		sb.append("6. Picture of Dorian Grey\n");
		sb.append("7. Exit\n\n");
		sb.append("Enter Option [1-7]>");
		menuText = sb.toString();
	}

	private void getUserOption() throws IOException{
		boolean keepRunning = true;
		while (keepRunning){
			int option = sc.nextInt();
			if (option == 1) {
				nd.newDictionary("textfiles/PoblachtNaHEireann.txt");
			} else if (option == 2){
				nd.newDictionary("textfiles/HappyPrince-Wilde.txt");
			} else if (option == 3){
				nd.newDictionary("textfiles/warandpeace.txt");
			} else if (option == 4){
				nd.newDictionary("textfiles/DivineComedy-Dante.txt");
			} else if (option == 5){
				nd.newDictionary("textfiles/ThePrince-Machiavelli.txt");
			} else if (option == 6){
				nd.newDictionary("textfiles/PictureOfDorianGray-Wilde.txt");
			} else if (option == 7){
			System.out.println("Bye!");
			keepRunning = false;
			} else {
				System.out.println("Enter a value [1-7]>");
			}
		}
	}
	
	/**
	 * newDictionary is called once a book is chosen.
	 * The book location and title is passed to newDictionary
	 * as String text
	 */
}
