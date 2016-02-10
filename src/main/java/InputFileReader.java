import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to read line by line from a file.
 *
 */
public class InputFileReader {

	/**
	 * Fully qualified name of the input file, right now to simplify things all
	 * files are kept in the resources folder
	 */
	private String fileName;

	/**
	 * Method for returning a list of lines present in the input file
	 * 
	 * @return List of lines
	 */
	public List<String> getLines() {
		try {
			List<String> lines = new ArrayList<String>();

			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				lines.add(line);
			}
			bufferedReader.close();
			return lines;
		} catch (Exception e) {
			System.out.println("Exception in reading the input file " + fileName);
			return null;
		}
	}

	/**
	 * Setter for fileName attribute
	 * 
	 * @param fileName
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
