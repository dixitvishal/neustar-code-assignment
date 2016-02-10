/**
 * Class encapsulating a given category and its value attributes.
 *
 */
public class Entity {
	
	public Entity(String category, String name) {
		this.category = category;
		this.name = name;
	}

	private String category;
	
	private String name;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
