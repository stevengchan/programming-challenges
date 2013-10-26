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
		int[] prods = new int[N];
		int mult = 1;
        
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
        	nums[i] = x;
        	prods[i] = mult;
        	if (i < N - 1) {
        		mult *= x;
        	}
		}
        
		mult = 1;
		for (int i = N - 1; i >= 0; i--) {
			int x = nums[i];
			nums[i] = prods[i] * mult;
			if (i > 0) {
				mult *= x;
			}
		}
        
		for (int i = 0; i < N; i++) {
			System.out.println(nums[i]);
		}
	}
}