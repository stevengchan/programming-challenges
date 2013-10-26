import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Evernote Programming Challenge - Circular Buffer
 * 
 * @author Steven Chan
 */
public class CircularBuffer {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<String> buffer = new ArrayDeque<String>();
		String line = br.readLine();
        
		while (!line.equals("Q")) {
			String[] commands = line.split(" ");
			if (commands[0].equals("A")) {
				int k = Integer.parseInt(commands[1]);
				for (int i = 0; i < k; i++) {
					if (buffer.size() == N) {
						buffer.poll();
					}
					buffer.offer(br.readLine());
				}
			} else if (commands[0].equals("R")) {
				int k = Integer.parseInt(commands[1]);
				for (int i = 0; i < k; i++) {
					if (!buffer.isEmpty()) {
						buffer.poll();
					}
				}
			} else if (commands[0].equals("L")) {
				for (String s : buffer) {
					System.out.println(s);
				}
			}
			line = br.readLine();
		}
	}
}