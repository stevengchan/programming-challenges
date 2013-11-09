import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/**
 * Code Eval Programming Challenge - String Permutations
 * 
 * @author Steven Chan
 */
public class StringPermutations {

	private static TreeSet<String> perms;
	
	public static void main(String[] args) throws IOException {
		File f = new File(args[0]);
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line;
		
		while ((line = br.readLine()) != null) {
			perms = new TreeSet<String>();
			getPerms("", line);
			
			boolean first = false;
			for (String p : perms) {
				if (first) {
					System.out.print(",");
				} else {
					first = true;
				}
				System.out.print(p);
			}
			System.out.println();
		}
		
		br.close();
	}
	
	public static void getPerms(String pre, String s) {
		int n = s.length();
		if (n == 0) {
			perms.add(pre);
		} else {
			for (int i = 0; i < n; i++) {
				getPerms(pre + s.charAt(i), s.substring(0, i) + s.substring(i + 1, n));
			}
		}
	}
}