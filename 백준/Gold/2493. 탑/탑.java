import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> numbers = new Stack<>();
		Stack<Integer> idx = new Stack<>();
		StringBuilder sb = new StringBuilder();
		sb.append(0);
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (numbers.isEmpty()) {
				numbers.push(num);
				idx.push(1);
				continue;
			}
			if (numbers.peek() < num) {
				while (numbers.peek() < num) {
					numbers.pop();
					idx.pop();
					if (numbers.isEmpty())
						break;
				}
				if (numbers.isEmpty()) {
					sb.append(" " + 0);
				} else {
					sb.append(" " + idx.peek());
				}
				numbers.push(num);
				idx.push(i);
			} else {
				sb.append(" " + idx.peek());
				numbers.push(num);
				idx.push(i);
			}
		}
		System.out.print(sb);
	}
}