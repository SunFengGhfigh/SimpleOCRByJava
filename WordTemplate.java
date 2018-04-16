package graph;

/**
 * 重心匹配模板(效果不佳 放弃)
 * @author Sun
 *
 */
public class WordTemplate {
	
	private static final Point a = new Point(42.057863824233195, 50.62910593865565);
	private static final Point b = new Point(47.24891285440946, 62.985408560311285);
	private static final Point e = new Point(32.667183863460046, 33.08145849495733);
	private static final Point g = new Point(36.99740596627756, 62.92276917724822);
	private static final Point h = new Point(41.416853428955626, 60.69789332138055);
	private static final Point l = new Point(18.34189189189189, 54.86081081081081);
	private static final Point m = new Point(55.71986754966888, 32.37814569536424);
	private static final Point o = new Point(32.92263056092843, 33.14700193423597);
	private static final Point s = new Point(22.247454972592013, 33.70477682067345);
	private static final Point t = new Point(24.244979919678716, 48.65220883534136);
	private static final Point u = new Point(33.16136363636364, 34.10568181818182);
	private static final Point y = new Point(42.73988764044944, 45.16629213483146);
	
	private static Point[] WORD_TEMP = {a, b, e, g, h, l, m, o, s, t, u, y};
	private static String[] WORD_NAME = {"a", "b", "e", "g", "h", "l", "m", "o", "s", "t", "u", "y"};
	
	class Node {
		private int count;
		private double suitability;
		public Node() {};
		public Node(int count, double suitability) {
			super();
			this.count = count;
			this.suitability = suitability;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public double getSuitability() {
			return suitability;
		}
		public void setSuitability(double suitability) {
			this.suitability = suitability;
		}
	}
	
	public static void cal(byte[][] graph) {
		double row = 0;
		int rcount = 0;
		double vertical = 0;
		
		for (int x = 0; x < graph.length; x++) {
			for (int y = 0; y < graph[0].length; y++) {
				if (graph[x][y] == 0) {
					row += y;
					rcount ++;
					vertical += (graph.length - 1 - x);
				}
			}
		}
		System.out.println("row: " + row / rcount);
		
//		for (int y = 0; y < graph.length; y++) {
//			for (int x = 0; x < graph[0].length; x++) {
//				if (graph[y][x] == 0) {
//					vertical += x;
//					vCount++;
//				}
//			}
//		}
		System.out.println("vertical: " + vertical / rcount);
		
		// 初步匹配模板
		double suitability = 0;
		int count = 0;
		Node node = new WordTemplate().match(row, vertical, rcount);
		suitability = node.suitability;
		count = node.count;
		
		// 二步修改(事实上，导致需要二部修改的原因是因为模板值得不准确，可以使用高度学习确定值)
				
			// 针对h误认为 b修改 和 b误认为 h 以及g误认为h
		if (WORD_NAME[count] == "b" || WORD_NAME[count] == "h") {
			int first = 0;
			int end = 0;
			for (int y = 0; y < graph[0].length; y++) {
				if (graph[graph.length - 1][y] == 0) {
					first = y;
					break;
				}
			}
			
			for (int y = graph[0].length - 1; y > -1; y--) {
				if (graph[graph.length - 1][y] == 0) {
					end = y;
					break;
				}
			}
			
			boolean flag = false;
			for (int y = first; y <= end; y++) {
				if (graph[graph.length - 1][y] == 1) {
					flag = true;
					break;
				}
			}
			
			if (WORD_NAME[count] == "b") {
				if (flag) {
					node = new WordTemplate().match(row, vertical, rcount, "b");
					suitability = node.suitability;
					count = node.count;
				}
			} else {
				node = new WordTemplate().match(row, vertical, rcount, "h");
				suitability = node.suitability;
				count = node.count;
			}
		}
		
			// 针对y误识别为g
		if (WORD_NAME[count] == "g") {
			int first = 0;
			int end = 0;
			for (int y = 0; y < graph[0].length; y++) {
				if (graph[0][y] == 0) {
					first = y;
					break;
				}
			}
			
			for (int y = graph[0].length - 1; y > -1; y--) {
				if (graph[0][y] == 0) {
					end = y;
					break;
				}
			}
			
			boolean flag = false;
			for (int y = first; y <= end; y++) {
				if (graph[0][y] == 1) {
					flag = true;
					break;
				}
			}
			
			if (flag) {
				node = new WordTemplate().match(row, vertical, rcount, "a", "b", "e", "g", "h", "l", "m", "o", "s", "t");
				suitability = node.suitability;
				count = node.count;
			}
			
		}
			// 针对u误识别为o
		if (WORD_NAME[count] == "o") {
			int first = 0;
			int end = 0;
			for (int y = 0; y < graph[0].length; y++) {
				if (graph[graph.length - 1][y] == 0) {
					first = y;
					break;
				}
			}
			
			for (int y = graph[0].length - 1; y > -1; y--) {
				if (graph[graph.length - 1][y] == 0) {
					end = y;
					break;
				}
			}
			
			boolean flag = false;
			for (int y = first; y <= end; y++) {
				if (graph[graph.length - 1][y] == 1) {
					flag = true;
					break;
				}
			}
			
			if (flag) {
				node = new WordTemplate().match(row, vertical, rcount, "a", "b", "e", "g", "l", "o", "s", "t");
				suitability = node.suitability;
				count = node.count;
			}
			
		}
			// 针对a误识别为y
		if (WORD_NAME[count] == "y") {
			int first = 0;
			int end = 0;
			for (int y = 0; y < graph[0].length; y++) {
				if (graph[0][y] == 0) {
					first = y;
					break;
				}
			}
			
			for (int y = graph[0].length - 1; y > -1; y--) {
				if (graph[0][y] == 0) {
					end = y;
					break;
				}
			}
			
			boolean flag = false;
			for (int y = first; y <= end; y++) {
				if (graph[0][y] == 1) {
					flag = true;
					break;
				}
			}
			
			if (flag) {
				node = new WordTemplate().match(row, vertical, rcount, "a", "b", "e", "g", "l", "o", "s", "t");
				suitability = node.suitability;
				count = node.count;
			}
			
		}
		
			// 针对y误识别为a
		if (WORD_NAME[count] == "a") {
			int first = 0;
			int end = 0;
			for (int y = 0; y < graph[0].length; y++) {
				if (graph[graph.length / 4 * 3][y] == 0) {
					first = y;
					break;
				}
			}
			
			for (int y = graph[0].length - 1; y > -1; y--) {
				if (graph[graph.length / 4 * 3][y] == 0) {
					end = y;
					break;
				}
			}
			
			boolean flag = false;
			for (int y = first; y <= end; y++) {
				if (graph[graph.length / 4 * 3][y] == 1) {
					flag = true;
					break;
				}
			}
			
			if (!flag) {
				node = new WordTemplate().match(row, vertical, rcount, "a", "b", "g", "h", "m", "o", "s", "u");
				suitability = node.suitability;
				count = node.count;
			}
			
		}
		
		// 针对s误识别为b
		if (WORD_NAME[count] == "b") {
			int first = 0;
			int end = 0;
			for (int y = 0; y < graph[0].length; y++) {
				if (graph[graph.length / 5][y] == 0) {
					first = y;
					break;
				}
			}
			
			for (int y = graph[0].length - 1; y > -1; y--) {
				if (graph[graph.length / 5][y] == 0) {
					end = y;
					break;
				}
			}
			
			boolean flag = false;
			for (int y = first; y <= end; y++) {
				if (graph[graph.length / 5][y] == 1) {
					flag = true;
					break;
				}
			}
			
			if (flag) {
				node = new WordTemplate().match(row, vertical, rcount, "a", "b", "h", "l", "t");
				suitability = node.suitability;
				count = node.count;
			}
			
		}
		
		System.out.println("匹配度：" + suitability * 100 + "%");
		System.out.println(WORD_NAME[count]);
	}
	
	private Node match(double row, double vertical, int rcount) {
		double suitability = 0;
		int count = 0;
		for (int i = 0; i < WORD_TEMP.length; i++) {
			double suit = (row / rcount) / (vertical / rcount);
			double k = 0;
			if (suit >= WORD_TEMP[i].getRatio()) {
				k = WORD_TEMP[i].getRatio() / suit;
			} else {
				k = suit / WORD_TEMP[i].getRatio();
			}
			System.out.println(WORD_NAME[i] + "匹配度：" + k * 100 + "%");
			if (k > suitability) {
				suitability = k;
				count = i;
			}
		}
		Node node = new Node(count, suitability);
		return node;
	}
	
	private Node match(double row, double vertical, int rcount, String...name) {
		double suitability = 0;
		int count = 0;
		for (int i = 0; i < WORD_TEMP.length; i++) {
			boolean flag = false;
			String wordName = WORD_NAME[i];
			for (int j = 0; j < name.length; j++) {
				if (name[j].equals(wordName)) {
					flag = true;
					break;
				}
			}
			if (flag) {
				continue;
			}
			double suit = (row / rcount) / (vertical / rcount);
			double k = 0;
			if (suit >= WORD_TEMP[i].getRatio()) {
				k = WORD_TEMP[i].getRatio() / suit;
			} else {
				k = suit / WORD_TEMP[i].getRatio();
			}
			System.out.println(WORD_NAME[i] + "匹配度：" + k * 100 + "%");
			if (k > suitability) {
				suitability = k;
				count = i;
			}
		}
		Node node = new Node(count, suitability);
		return node;
	}

}
