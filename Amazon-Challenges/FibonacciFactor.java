import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class FibonacciFactor {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int K = Integer.parseInt(br.readLine());
			
			int last = 1;
			int curr = 2;
			fibLoop:
			while (curr <= K) {
				for (int j = 2; j <= curr; j++) {
					if (curr % j == 0 && K % j == 0) {
						System.out.println(curr + " " + j);
						break fibLoop;
					}
				}
				int temp = curr;
				curr += last;
				last = temp;
			}
		}
	}

}
