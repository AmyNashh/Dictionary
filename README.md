# Dictionary

My project "Dictionary Project" has a folder named "textfiles", in which there are seven 
books, a dictionary csv file and a stopwords textfile. 
It also contains 6 classes;
- Dictionary:
  This class parses a complete dictionary into a HashMap called dictionary (O(1) time)
- Stopwords:
  This class parses the list of stopwords from the stopwords textfile into 
  a TressSet called ignore.
- Runner:
  Contains the main method for the program, it calls the Menu class.
- Menu:
  This class builds the user interface menu, the user is prompted to choose a book.
  Once they have chosen a book, the NewDictionary class is called. 
- NewDictionary:
  This class parses the selected book, skipping the ignore words,counting every 4O lines 
  as one page. It sets the definitions for each word by calling dictionary.get(key) and 
  setdefinition. If there is no definition available, it is set to "not defined". 
  These words[key],their wordtype and definition[value] are put into a HashMap called map 
  using .put. This class also contains a menu that asks the user if they wish to download 
  the index and dictionary or search for a word in that book to get a definition. If they 
  wish to download, the download method in this class is called, which creates a textfile 
  named "BookIndex.txt" which will contain a index, word and definition. When the search 
  method is called, a small window will display on the users screen (JFrame ref) asking them 
  to type in the word they wish to search for, once entered, the definition for that word 
  will display. After this, the user will be prompted again with the same options as before.
- WordDetail:
  This class contains the getters and setters for the definition and indices (value) for 
  each key in the map.
