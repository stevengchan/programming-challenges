import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Amazon Programming Challenge - Connected Sets
 * 
 * @author Steven Chan
 */
public class ConnectedSets {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] matrix = new int[N][N];
			List<Cell> cells = new ArrayList<Cell>();
			for (int j = 0; j < N; j++) {
				String[] s = br.readLine().split(" ");
				for (int k = 0; k < N; k++) {
					int n = Integer.parseInt(s[k]);
					matrix[j][k] = n;
					if (n == 1) {
						cells.add(new Cell(j, k));
					}
				}
			}
			
			int sets = 0;
			boolean[][] marked = new boolean[N][N];
			for (Cell c : cells) {
				if (!marked[c.x][c.y]) {
					sets++;
					Deque<Cell> connected = new ArrayDeque<Cell>();
					connected.push(c);
					
					while (!connected.isEmpty()) {
						Cell curr = connected.pop();
						int x = curr.x;
						int y = curr.y;
						marked[x][y] = true;
						if (x - 1 >= 0 && y - 1 >= 0) {
							if (!marked[x-1][y-1] && matrix[x-1][y-1] == 1)
								connected.push(new Cell(x-1, y-1));
						}
						if (y - 1 >= 0) {
							if (!marked[x][y-1] && matrix[x][y-1] == 1)
								connected.push(new Cell(x, y-1));
						}
						if (x + 1 < N && y - 1 >= 0) {
							if (!marked[x+1][y-1] && matrix[x+1][y-1] == 1)
								connected.push(new Cell(x+1, y-1));
						}
						if (x + 1 < N) {
							if (!marked[x+1][y] && matrix[x+1][y] == 1)
								connected.push(new Cell(x+1, y));
						}
						if (x + 1 < N && y + 1 < N) {
							if (!marked[x+1][y+1] && matrix[x+1][y+1] == 1)
								connected.push(new Cell(x+1, y+1));
						}
						if (y + 1 < N) {
							if (!marked[x][y+1] && matrix[x][y+1] == 1)
								connected.push(new Cell(x, y+1));
						}
						if (x - 1 >= 0 && y + 1 < N) {
							if (!marked[x-1][y+1] && matrix[x-1][y+1] == 1)
								connected.push(new Cell(x-1, y+1));
						}
						if (x - 1 >= 0) {
							if (!marked[x-1][y] && matrix[x-1][y] == 1)
								connected.push(new Cell(x-1, y));
						}
					}
				}
			}
			
			System.out.println(sets);
		}
	}
	
	public static class Cell {
		public int x;
		public int y;
		
		public Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}