import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeMap;


public class SubSegment {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] text = line.split("[ .,?!\\d]+");
		int k = Integer.parseInt(br.readLine());
		String[] words = new String[k];
		for (int i = 0; i < k; i++) {
			words[i] = br.readLine();
		}
		HashMap<String, Integer> currentIndices = new HashMap<String, Integer>();
		TreeMap<Integer, String> sortedIndices = new TreeMap<Integer, String>();
		TreeMap<Integer, int[]> subSegments = new TreeMap<Integer, int[]>();
		
		for (int i = 0; i < text.length; i++) {
			String s = text[i];
			for (int j = 0; j < k; j++) {
				String word = words[j];
				if (s.equalsIgnoreCase(word)) {
					if (currentIndices.containsKey(word)) {
						int index = currentIndices.get(word);
						sortedIndices.remove(index);
					}
					currentIndices.put(word, i);
					sortedIndices.put(i, word);
					if (sortedIndices.size() == k) {
						int start = sortedIndices.firstKey();
						int end = sortedIndices.lastKey();
						int length = end - start;
						if (!subSegments.containsKey(length)) {
							int[] subSegment = { start, end };
							subSegments.put(length, subSegment);
						}
					}
				}
			}
		}
		if (currentIndices.size() < k) {
			System.out.println("NO SUBSEGMENT FOUND");
		} else {
			int[] subSegment = subSegments.get(subSegments.firstKey());
			int start = subSegment[0];
			int end = subSegment[1];
			for (int i = start; i < end; i++) {
				System.out.print(text[i] + " ");
			}
			System.out.print(text[end]);
		}
	}

}
