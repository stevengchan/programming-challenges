import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

/**
 * Code Eval Programming Challenge - Following Integer
 * 
 * @author Steven Chan
 */
public class FollowingInteger {

	private static TreeSet<String> numbers;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n;
		
		while ((n = br.readLine()) != null) {
			numbers = new TreeSet<String>();
			getPerms("", n);
			String next = numbers.higher(n);
			if (next == null) {
				StringBuffer sb = new StringBuffer(numbers.first());
				while (sb.charAt(0) == '0') {
					sb.deleteCharAt(0);
					sb.append(0);
				}
				sb.insert(1, 0);
				next = sb.toString();
			}
			System.out.println(next);
		}
	}
	
	public static void getPerms(String pre, String s) {
		int n = s.length();
		if (n == 0) {
			numbers.add(pre);
		} else {
			for (int i = 0; i < n; i++) {
				getPerms(pre + s.charAt(i), s.substring(0, i) + s.substring(i + 1, n));
			}
		}
	}
}