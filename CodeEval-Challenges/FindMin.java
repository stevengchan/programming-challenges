import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Code Eval Programming Challenge - Find Min
 * 
 * @author Steven Chan
 */
public class FindMin {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		while ((line = br.readLine()) != null) {
			int n = Integer.parseInt(line);
			int[][] matrix = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				String[] lineArray = br.readLine().split(",");
				int[] row = new int[n];
				for (int j = 0; j < n; j++) {
					row[j] = Integer.parseInt(lineArray[j]);
				}
				matrix[i] = row;
			}
			
			int min = 0;
			boolean minNew = true;
			Deque<int[]> coords = new ArrayDeque<int[]>();
			int[] start = {0, 0, matrix[0][0]};
			coords.push(start);
			
			while (!coords.isEmpty()) {
				int[] coord = coords.pop();
				int x = coord[0];
				int y = coord[1];
				int sum = coord[2];
				
				if (x == n - 1 && y == n - 1) {
					if (minNew) {
						minNew = false;
						min = sum;
					} else if (sum < min) {
						min = sum;
					}
				} else {
					if (x + 1 < n) {
						int[] c = {x+1, y, sum + matrix[x+1][y]};
						coords.push(c);
					}
					if (y + 1 < n) {
						int[] c = {x, y+1, sum + matrix[x][y+1]};
						coords.push(c);
					}
				}
			}
			
			System.out.println(min);
		}
	}
}