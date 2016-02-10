import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class encapsulates the valid categories present in the input file. Valid
 * categories are PERSON, PLACE, ANIMAL, COMPUTER and OTHER. It also contains an
 * order in which the categories are to be displayed.
 *
 */
public enum Categories {

	PERSON("PERSON", 0), PLACE("PLACE", 1), ANIMAL("ANIMAL", 2), COMPUTER("COMPUTER", 3), OTHER("OTHER", 4);

	private String value;

	private int order;

	/**
	 * Constructor
	 * 
	 * @param value
	 * @param order
	 */
	private Categories(String value, int order) {
		this.value = value;
		this.order = order;
	}

	/**
	 * Retrieves a set of the display order values for the categories
	 * 
	 * @return set of order values
	 */
	public static Set<Integer> getCategoryOrders() {
		Set<Integer> values = new HashSet<Integer>();
		for (Categories category : EnumSet.allOf(Categories.class)) {
			values.add(category.order);
		}
		return values;
	}

	/**
	 * Retrieves a set of all category values
	 * 
	 * @return set of category values
	 */
	public static Set<String> getCategoryValues() {
		Set<String> values = new TreeSet<String>();
		for (Categories category : EnumSet.allOf(Categories.class)) {
			values.add(category.value);
		}
		return values;
	}

	/**
	 * Retrieves a category value given it's display order
	 * 
	 * @param order
	 *            of display
	 * @return category values
	 */
	public static String getCategoryValue(int order) {
		for (Categories category : EnumSet.allOf(Categories.class)) {
			if (order == category.order) {
				return category.value;
			}
		}
		return null;
	}
}
