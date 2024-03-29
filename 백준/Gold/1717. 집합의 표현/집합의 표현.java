import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 집합의 표현
public class Main {

	static int N, M;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		make();
		StringBuilder sb = new StringBuilder();
		String str = null;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int flag = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (flag == 0) {
				union(a, b);
			} else {
				str = find(a) == find(b) ? "YES" : "NO";
				sb.append(str + "\n");
			}
		}
		System.out.println(sb);
	}

	private static int find(int a) {
		if (parents[a] == a)
			return parents[a];

		return parents[a] = find(parents[a]);
	}

	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot != bRoot) {
			parents[bRoot] = aRoot;
		}
	}

	private static void make() {
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

}
