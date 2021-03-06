import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

/**
 * Code Eval Programming Challenge - String Permutations
 * 
 * @author Steven Chan
 */
public class StringPermutations {

	private static TreeSet<String> perms;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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