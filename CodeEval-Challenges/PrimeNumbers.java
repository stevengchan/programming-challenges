import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Code Eval Programming Challenge - Prime Numbers
 * 
 * @author Steven Chan
 */
public class PrimeNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		List<Integer> primes = new ArrayList<Integer>();
		int last = 1;
		
		while ((line = br.readLine()) != null) {
			int N = Integer.parseInt(line);
			
			for (int p : primes) {
				if (p < N) {
					if (p == 2) {
						System.out.print(p);
					} else {
						System.out.print("," + p);
					}
				} else {
					break;
				}
			}
			
			if (N > last) {
				for (int p = last + 1; p < N; p++) {
					boolean isPrime = true;
					int max = p / 2;
					
					for (int j = 2; j <= max; j++) {
						if (p % j == 0) {
							isPrime = false;
							break;
						}
					}
					
					if (isPrime) {
						primes.add(p);
						if (p == 2) {
							System.out.print(p);
						} else {
							System.out.print("," + p);
						}
					}
				}
				last = N - 1;
			}
			
			System.out.println();
		}
	}
}