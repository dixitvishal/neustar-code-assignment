import org.junit.Test;

import org.junit.Assert;

/**
 * junit test for the Processor Class
 */
public class ProcessorTest {
	
	private String RESULT_STRING_1[] = {"CATEGORY  COUNT",
										"PERSON      3",
									    "PLACE      2",
									    "ANIMAL      2",
									    "COMPUTER      1",
									    "OTHER      1",
									    "PERSON  Bob Jones", 
									    "PLACE  Washington", 
									    "PERSON  Mary", 
									    "COMPUTER  Mac", 
									    "OTHER  Tree", 
									    "ANIMAL  Dog", 
									    "PLACE  Texas", 
									    "FOOD  Steak", 
									    "ANIMAL  Cat"};
	
	@Test
	public void testResults() {
    	Processor.init("src/main/resources/input.txt"); 
    	String results = Processor.createResults();
    	String tokens[] = results.split("\n");
    	for (int i = 0; i < tokens.length; i++) {
    		Assert.assertEquals(RESULT_STRING_1[i], tokens[i].trim());
    	}
	}
}
