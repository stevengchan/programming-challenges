import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Evernote Programming Challenge - Frequent Terms
 * 
 * @author Steven Chan
 */
public class FrequencyTerms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> freqMap = new HashMap<String, Integer>();
		TreeMap<Integer, TreeSet<String>> sortedMap = new TreeMap<Integer, TreeSet<String>>();
        
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			if (freqMap.containsKey(s)) {
				int freq = freqMap.get(s);
				freq++;
				freqMap.put(s, freq);
			} else {
				freqMap.put(s, 1);
			}
		}
        
		for (String s : freqMap.keySet()) {
			int freq = freqMap.get(s);
			if (sortedMap.containsKey(freq)) {
				TreeSet<String> sortedStrings = sortedMap.get(freq);
				sortedStrings.add(s);
				sortedMap.put(freq, sortedStrings);
			} else {
				TreeSet<String> sortedStrings = new TreeSet<String>();
				sortedStrings.add(s);
				sortedMap.put(freq, sortedStrings);
			}
		}
        
		int k = Integer.parseInt(br.readLine());
		mainLoop:
		for (int freq : sortedMap.descendingKeySet()) {
			TreeSet<String> sortedStrings = sortedMap.get(freq);
			for (String s : sortedStrings) {
				System.out.println(s);
				k--;
				if (k <= 0) {
					break mainLoop;
				}
			}
		}
	}
}