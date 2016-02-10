import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Class for processing an input file data and displaying the results.
 *
 */
public class Processor {
	
	/**
	 * Regex delimiter to be used for splitting the line read
	 * from the file into tokens
	 */
	private static String DELIMITER_REGEX = "\\s";
	
	/**
	 * Space that could be present between a name
	 */
	private static String SPACE = " ";
	
	/**
	 * List of all categories present in the input file, can have 
	 * duplicate values
	 */
	private static List<String> categoryList = new ArrayList<String>();
	
	/**
	 * Map containing all unique category and name pair present in the
	 * input file
	 */
	private static Map<Integer, Entity> categoryValues = new HashMap<Integer, Entity>();
	
	/**
	 * Set of unique names present in the input file for any category type
	 */
	private static Set<String> names = new HashSet<String>();
	
	/**
	 * Main method to process the file and display the results
	 */
    public static void main(String [] args) {
    	init("src/main/resources/input.txt");  	
    	printResults();
    }
    
    /**
	 * Method for creating the category count string
	 * 
	 * @return category value string
	 */
    private static String createCategoryCounts() {
    	StringBuilder categoryCountBuilder = new StringBuilder();
    	categoryCountBuilder.append("CATEGORY  COUNT");
    	categoryCountBuilder.append(System.getProperty("line.separator"));
    	for (Integer order : Categories.getCategoryOrders()) {
        	categoryCountBuilder.append(Categories.getCategoryValue(order));
        	categoryCountBuilder.append("      ");
        	categoryCountBuilder.append(Collections.frequency(categoryList, 
        			Categories.getCategoryValue(order)));
        	categoryCountBuilder.append(System.getProperty("line.separator"));
        }
    	return categoryCountBuilder.toString();
    }
    
    /**
	 * Method for creating the category values string
	 * 
	 * @return category value string
	 */
    private static String createCategoryValues() {
    	StringBuilder categoryValueBuilder = new StringBuilder();
    	for (Integer key : categoryValues.keySet()) {
    		Entity entity = categoryValues.get(key);
    		categoryValueBuilder.append(entity.getCategory());
    		categoryValueBuilder.append("  ");
    		categoryValueBuilder.append(entity.getName());	
    		categoryValueBuilder.append(System.getProperty("line.separator"));
    	} 
    	return categoryValueBuilder.toString();
    }
    
    /**
	 * Method to print the results after processing the input file.
	 * 
	 */
    public static String createResults() {
    	return createCategoryCounts() 
    			+ createCategoryValues();
    }
    
    /**
	 * Method to initialize the file reader, read the input file
	 * and process tokens from the file.
	 * 
	 * @param fileName path to file
	 */
    public static void init(String fileName) {
    	InputFileReader reader = new InputFileReader();
    	reader.setFileName(fileName);
    	
    	List<String> lines = reader.getLines();
    	int lineNumber = 0;
    	for (String line : lines) {
    		processTokens(tokenize(line), lineNumber++);
    	}
    }  
    
    /**
	 * Method to print the results after processing the input file.
	 * 
	 */
    public static void printResults() { 	
    	System.out.println(createResults());
    }
    
    /**
	 * Method processing the string token array for a certain line number
	 * from the input file, if that value has not been seen before it will
	 * be saved in the categoryValues map
	 * 
	 * @param token[] string array
	 * @param lineNumber of the line being processed
	 */
    private static void processTokens(String[] tokens, int lineNumber) {
    	categoryList.add(tokens[0]);
    	StringBuilder value = new StringBuilder();
    	for (int i = 1; i < tokens.length; i++) {
    		value.append(tokens[i]);
    		if (tokens.length > 1) {
        		value.append(SPACE);
    		}
    	}    	
    	if (!names.contains(value.toString())) {
    		categoryValues.put(new Integer(lineNumber), 
    				new Entity(tokens[0], value.toString()));
    	}   	
		names.add(value.toString());
    }
    
    /**
	 * Method to tokenize a given line using the space delimiter,
	 * this will parse out the category as the first token and its
	 * corresponding value as subsequent tokens
	 * 
	 * @param line to be tokenized
	 * @return token string array
	 */
    private static String[] tokenize(String line) {
    	String[] tokens = line.split(DELIMITER_REGEX);
    	return tokens;
    }
}
