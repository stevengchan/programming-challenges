import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Evernote Programming Challenge - Multiply Except Self
 * 
 * @author Steven Chan
 */
public class MultiplyExceptSelf {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		long mult = 1;
		int zeros = 0;
		
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			nums[i] = n;
			if (n == 0) {
				zeros++;
			} else {
				mult *= n;
			}
		}
		
		if (zeros >= 2) {
			for (int i = 0; i < N; i++) {
				System.out.println(0);
			}
		} else if (zeros == 1) {
			for (int i = 0; i < N; i++) {
				int n = nums[i];
				if (n == 0) {
					System.out.println(mult);
				} else {
					System.out.println(0);
				}
			}
		} else {
			for (int i = 0; i < N; i++) {
				int n = nums[i];
				long x = mult / n;
				System.out.println(x);
			}
		}
	}
}