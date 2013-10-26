import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

/**
 * Evernote Programming Challenge - Top Four
 * 
 * @author Steven Chan
 */
public class TopFour {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		TreeMap<Integer, Integer> sorted = new TreeMap<Integer, Integer>();
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			int e = Integer.parseInt(br.readLine());
			if (count < 4) {
				if (!sorted.containsKey(e)) {
					sorted.put(e, 1);
				} else {
					int val = sorted.get(e);
					val++;
					sorted.put(e, val);
				}
				count++;
			} else if (e > sorted.firstKey()) {
				int val = sorted.get(sorted.firstKey());
				if (val == 1) {
					sorted.pollFirstEntry();
				} else {
					val--;
					sorted.put(sorted.firstKey(), val);
				}
				if (sorted.containsKey(e)) {
					val = sorted.get(e);
					val++;
					sorted.put(e, val);
				} else {
					sorted.put(e, 1);
				}
			}
		}
		
		for (int e : sorted.descendingKeySet()) {
			int val = sorted.get(e);
			for (int i = 0; i < val; i++) {
				System.out.println(e);
			}
		}
	}
}