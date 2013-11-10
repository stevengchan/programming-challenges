import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Code Eval Programming Challenge - Beautiful Strings
 * 
 * @author Steven Chan
 */
public class BeautifulStrings {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		while ((line = br.readLine()) != null) {
			HashMap<Integer, Integer> charMap = new HashMap<Integer, Integer>();
			TreeMap<Integer, Integer> freqMap = new TreeMap<Integer, Integer>();
			
			for (int i = 0; i < line.length(); i++) {
				int c = line.charAt(i);
				if (c >= 65 && c <= 90) {
					c += 32;
				}
				if (c >= 97 && c <= 122) {
					if (charMap.containsKey(c)) {
						int freq = charMap.get(c);
						int val = freqMap.get(freq);
						val--;
						if (val == 0) {
							freqMap.remove(freq);
						} else {
							freqMap.put(freq, val);
						}
						freq++;
						charMap.put(c, freq);
						if (freqMap.containsKey(freq)) {
							val = freqMap.get(freq);
							val++;
							freqMap.put(freq, val);
						} else {
							freqMap.put(freq, 1);
						}
					} else {
						charMap.put(c, 1);
						if (freqMap.containsKey(1)) {
							int val = freqMap.get(1);
							val++;
							freqMap.put(1, val);
						} else {
							freqMap.put(1, 1);
						}
					}
				}
			}
			
			int beauty = 26;
			int result = 0;
			for (int freq : freqMap.descendingKeySet()) {
				int val = freqMap.get(freq);
				for (int i = 0; i < val; i++) {
					result += beauty * freq;
					beauty--;
				}
			}
			
			System.out.println(result);
		}
	}
}