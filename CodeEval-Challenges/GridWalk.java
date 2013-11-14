import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

/**
 * Code Eval Programming Challenge - Grid Walk
 * 
 * @author Steven Chan
 */
public class GridWalk {

	public static void main(String[] args) {
		int count = 0;
		HashSet<String> checked = new HashSet<String>();
		Deque<int[]> coords = new ArrayDeque<int[]>();
		int[] c = {0, 0};
		coords.push(c);
		
		while (!coords.isEmpty()) {
			int[] coord = coords.pop();
			int x = coord[0];
			int y = coord[1];
			String code = x + " " + y;
			
			if (!checked.contains(code)) {
				if (isAccessible(x, y)) {
					count++;
					checked.add(code);
					int[] next1 = {x+1, y};
					int[] next2 = {x-1, y};
					int[] next3 = {x, y+1};
					int[] next4 = {x, y-1};
					coords.push(next1);
					coords.push(next2);
					coords.push(next3);
					coords.push(next4);
				}
			}
		}
		
		System.out.println(count);
	}
	
	public static boolean isAccessible(int x, int y) {
		String xs = Math.abs(x) + "";
		String ys = Math.abs(y) + "";
		int sum = 0;
		
		for (int i = 0; i < xs.length(); i++) {
			sum += Integer.parseInt(xs.charAt(i) + "");
		}
		for (int i = 0; i < ys.length(); i++) {
			sum += Integer.parseInt(ys.charAt(i) + "");
		}
		
		if (sum <= 19) {
			return true;
		} else {
			return false;
		}
	}
}