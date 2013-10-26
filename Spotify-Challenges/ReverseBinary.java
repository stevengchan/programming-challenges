import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Spotify Programming Challenge - Reverse Binary
 * 
 * @author Steven Chan
 */
public class ReverseBinary {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		
		while (N > 0) {
			int mod = N % 2;
			sum = sum * 2 + mod;
			N = N / 2;
		}
		System.out.print(sum);
	}
}