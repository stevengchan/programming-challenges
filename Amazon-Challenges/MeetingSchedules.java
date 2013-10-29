import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Amazon Programming Challenge - Meeting Schedules
 * 
 * @author Steven Chan
 */
public class MeetingSchedules {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int M = Integer.parseInt(line[0]);
		int K = Integer.parseInt(line[1]);
		boolean[] minutes = new boolean[1441];
		
		for (int i = 0; i < M; i++) {
			String[] s = br.readLine().split(" ");
			int startHH = Integer.parseInt(s[0]);
			int startMM = Integer.parseInt(s[1]);
			int startTime = startHH * 60 + startMM;
			int endHH = Integer.parseInt(s[2]);
			int endMM = Integer.parseInt(s[3]);
			int endTime = endHH * 60 + endMM;
			
			for (int j = startTime; j < endTime; j++) {
				minutes[j] = true;
			}
		}
		
		int start = -1;
		int end = -1;
		minutes[1440] = true; // end of minutes; to terminate any streak
		for (int i = 0; i < 1441; i++) {
			boolean busy = minutes[i];
			if (busy) {
				if (start >= 0) {
					if ((end + 1 - start) >= K) {
						int startHH = start / 60;
						int startMM = start % 60;
						int endHH = (end + 1) / 60;
						int endMM = (end + 1) % 60;
						if (endHH == 24) {
							endHH = 0;
						}
						System.out.print(toTimeString(startHH) + " ");
						System.out.print(toTimeString(startMM) + " ");
						System.out.print(toTimeString(endHH) + " ");
						System.out.println(toTimeString(endMM));
					}
					start = -1;
					end = -1;
				}
			} else {
				if (start == -1) {
					start = i;
				}
				end = i;
			}
		}
	}
	
	static String toTimeString(int t) {
		if (t < 10) {
			return "0" + t;
		} else {
			return "" + t;
		}
	}
}