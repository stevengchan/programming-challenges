import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Code Eval Programming Challenge - Longest Common Subsequence
 * 
 * @author Steven Chan
 */
public class LongestCommonSubsequence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		while ((line = br.readLine()) != null) {
			String[] lineArray = line.split(";");
			String s1 = lineArray[0];
			String s2 = lineArray[1];
			System.out.println(lcs(s1, s2));
		}
	}
	
	public static String lcs(String s1, String s2) {
		int[][] subs = new int[s1.length() + 1][s2.length() + 1];
		
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					subs[i+1][j+1] = subs[i][j] + 1;
				} else {
					subs[i+1][j+1] = Math.max(subs[i+1][j], subs[i][j+1]);
				}
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for (int i = s1.length(), j = s2.length(); i != 0 && j != 0; ) {
			if (subs[i][j] == subs[i-1][j]) {
				i--;
			} else if (subs[i][j] == subs[i][j-1]) {
				j--;
			} else {
				sb.append(s1.charAt(i-1));
				i--;
				j--;
			}
		}
		
		return sb.reverse().toString();
	}
}