import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Code Eval Programming Challenge - Mnth to Last Element
 * 
 * @author Steven Chan
 */
public class MnthToLastElement {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
	}
}