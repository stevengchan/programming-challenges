import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Code Eval Programming Challenge - Text Dollar
 * 
 * @author Steven Chan
 */
public class TextDollar {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		String[] ones = { "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
		String[] teens = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
		String[] tens = { "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
		String[] thousands = { "Hundred", "Thousand", "Million", "Billion" };
		
		while ((line = br.readLine()) != null) {
			int N = Integer.parseInt(line);
			Deque<String> result = new ArrayDeque<String>();
			int thousand = 0;
			
			for (int n = N; n > 0; n = n / 1000) {
				int mod = n % 1000;
				if (mod > 0) {
					if (thousand > 0) {
						result.push(thousands[thousand]);
					}
					int ten = 0;
					int last = 0;
					boolean hasOne = true;
					
					for (int m = mod; m > 0; m = m / 10) {
						int mod2 = m % 10;
						if (mod2 == 0) {
							hasOne = false;
						} else {
							hasOne = true;
							String word = null;
							if (ten == 0) {
								word = ones[mod2 - 1];
							} else if (ten == 1) {
								if ((mod2 < 2) && hasOne && !result.isEmpty()) {
									result.pop();
								}
								if (mod2 == 1) {
									word = teens[last];
								} else {
									word = tens[mod2 - 1];
								}
							} else if (ten == 2) {
								result.push(thousands[0]);
								word = ones[mod2 - 1];
							}
							result.push(word);
						}
						ten++;
						last = mod2;
					}
				}
				thousand++;
			}
			
			while (!result.isEmpty()) {
				System.out.print(result.pop());
			}
			System.out.println("Dollars");
		}
	}
}