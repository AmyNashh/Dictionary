package ie.gmit.dip;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author amynashAmy
 *
 */
public class WordDetail {

	int page;
	String definition = "Undefinied";
	private List <Integer> pages = new ArrayList <Integer> ();
	
	/**
	 * Creates an array list for page numbers
	 * Definition is set to undefined by default.
	 */

	public WordDetail(){
		super();
	}
	
	public WordDetail (List<Integer> pages, String definition) {
		super();
		this.pages = pages;
		this.definition = definition;
		}
		
	/**
	 * Creates getters and setters for definition and page numbers	
	 * @param definition
	 */
		public WordDetail(String definition){
			super();
			this.definition = definition;
		}
		
		public String getDefinition() {
			return definition;
		}
		
		public void setDefinition(String definition) {
			this.definition = definition;
		}

		public void addIndex (int page){
			pages.add(page);
		}

		public List<Integer> getIndices(){
			return pages;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((definition == null) ? 0 : definition.hashCode());
			result = prime * result + ((pages == null) ? 0 : pages.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			WordDetail other = (WordDetail) obj;
			if (definition == null) {
				if (other.definition != null)
					return false;
			} else if (!definition.equals(other.definition))
				return false;
			if (pages == null) {
				if (other.pages != null)
					return false;
			} else if (!pages.equals(other.pages))
				return false;
			return true;
		}
		
	
	}
