import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Code Eval Programming Challenge - Mnth to Last Element
 * 
 * @author Steven Chan
 */
public class MnthToLastElement {

	public static void main(String[] args) throws IOException {
		File f = new File(args[0]);
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line;
		
		while ((line = br.readLine()) != null) {
			String[] lineArray = line.split(" ");
			int length = lineArray.length - 1;
			int M = Integer.parseInt(lineArray[length]);
			int index = length - M;
			if (index < 0 || index >= length) {
				System.out.println();
			} else {
				System.out.println(lineArray[index]);
			}
		}
		
		br.close();
	}
}