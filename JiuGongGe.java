package graph;

/**
 * 九宫格算法
 * @author Sun
 *
 */
public class JiuGongGe {
	
	private class Node {
		private double one;
		private double two;
		private double three;
		private double four;
		private double five;
		private double six;
		private double seven;
		private double eight;
		private double nine;
		public Node() {
			super();
		}
		public Node(double one, double two, double three, double four, double five, double six, double seven,
				double eight, double nine) {
			super();
			this.one = one;
			this.two = two;
			this.three = three;
			this.four = four;
			this.five = five;
			this.six = six;
			this.seven = seven;
			this.eight = eight;
			this.nine = nine;
		}
		@Override
		public String toString() {
			return "Node [" + one + ", " + two + ", " + three + ", " + four + ", " + five
					+ ", " + six + ", " + seven + ", " + eight + ", " + nine + "]";
		}
	}
	
	public final Node a = new Node(0.48863636363636365, 0.2681818181818182, 0.39090909090909093, 0.2909090909090909, 0.2727272727272727, 0.5, 0.6727272727272727, 0.2590909090909091, 0.5818181818181818);
	public final Node b = new Node(0.5403726708074534, 0.0, 0.0, 0.529192546583851, 0.1031055900621118, 0.4260869565217391, 0.4832298136645963, 0.07453416149068323, 0.48695652173913045);
	public final Node e = new Node(0.35645933014354064, 0.16985645933014354, 0.4138755980861244, 0.6889952153110048, 0.15789473684210525, 0.2607655502392344, 0.5143540669856459, 0.23923444976076555, 0.18181818181818182);
	public final Node g = new Node(0.4091880341880342, 0.2938034188034188, 0.41346153846153844, 0.4700854700854701, 0.36004273504273504, 0.09508547008547008, 0.4091880341880342, 0.18055555555555555, 0.3888888888888889);
	public final Node h = new Node(0.5380952380952381, 0.0, 0.0, 0.4880952380952381, 0.14166666666666666, 0.38452380952380955, 0.49166666666666664, 0.009523809523809525, 0.46785714285714286);
	public final Node l = new Node(0.14102564102564102, 0.8952991452991453, 0.05128205128205128, 0.0, 0.8461538461538461, 0.06623931623931624, 0.09829059829059829, 0.8675213675213675, 0.19658119658119658);
	public final Node m = new Node(0.5012285012285013, 0.47788697788697787, 0.44348894348894347, 0.3316953316953317, 0.3095823095823096, 0.32432432432432434, 0.414004914004914, 0.3955773955773956, 0.3918918918918919);
	public final Node o = new Node(0.38016528925619836, 0.18181818181818182, 0.4524793388429752, 0.5805785123966942, 0.0, 0.5, 0.4690082644628099, 0.11363636363636363, 0.4132231404958678);
	public final Node s = new Node(0.5212121212121212, 0.15151515151515152, 0.4090909090909091, 0.3606060606060606, 0.6363636363636364, 0.5454545454545454, 0.5151515151515151, 0.07272727272727272, 0.5333333333333333);
	public final Node t = new Node(0.21333333333333335, 0.5377777777777778, 0.2, 0.11777777777777777, 0.6377777777777778, 0.015555555555555555, 0.08666666666666667, 0.7044444444444444, 0.19333333333333333);
	public final Node u = new Node(0.5847107438016529, 0.01859504132231405, 0.5681818181818182, 0.53099173553719, 0.0, 0.5268595041322314, 0.5227272727272727, 0.20041322314049587, 0.6487603305785123);
	public final Node y = new Node(0.30444444444444446, 0.29333333333333333, 0.31333333333333335, 0.0, 0.4988888888888889, 0.06111111111111111, 0.3011111111111111, 0.18888888888888888, 0.0);
	
	public final Node[] word = {a, b, e, g, h, l, m, o, s, t, u, y};
	public final String[] wordName = {"a", "b", "e", "g", "h", "l", "m", "o", "s", "t", "u", "y"};
	
	public void cal(byte[][] graph) {
		
//		System.out.println("********************");
//		for (int x = 0; x < graph.length; x++) {
//			for (int y = 0; y < graph[0].length; y++) {
//				System.out.print(graph[x][y]);
//			}
//			System.out.println();
//		}
//		System.out.println("********************");
		
//		System.out.println("********************");
//		for (int x = 0; x < graph[0].length; x++) {
//			for (int y = 0; y < graph.length; y++) {
//				System.out.print(graph[y][x]);
//			}
//			System.out.println();
//		}
//		System.out.println("********************");
		
		Node node = new Node();
		int size = (graph.length / 3) * (graph[0].length / 3);
		
		// 匹配时使用
		node.one = calRatio(0, graph.length / 3, 0, graph[0].length / 3, size, graph);
		node.two = calRatio(0, graph.length / 3, graph[0].length / 3, graph[0].length / 3 * 2, size, graph);
		node.three = calRatio(0, graph.length / 3, graph[0].length / 3 * 2, graph[0].length / 3 * 3, size, graph);
		
		node.four = calRatio(graph.length / 3, graph.length / 3 * 2, 0, graph[0].length / 3, size, graph);
		node.five = calRatio(graph.length / 3, graph.length / 3 * 2, graph[0].length / 3, graph[0].length / 3 * 2, size, graph);
		node.six = calRatio(graph.length / 3, graph.length / 3 * 2, graph[0].length / 3 * 2, graph[0].length / 3 * 3, size, graph);
		
		node.seven = calRatio(graph.length / 3 * 2, graph.length / 3 * 3, 0, graph[0].length / 3, size, graph);
		node.eight = calRatio(graph.length / 3 * 2, graph.length / 3 * 3, graph[0].length / 3, graph[0].length / 3 * 2, size, graph);
		node.nine = calRatio(graph.length / 3 * 2, graph.length / 3 * 3, graph[0].length / 3 * 2, graph[0].length / 3 * 3, size, graph);
		
		// 模板时使用
//		node.one = calRatio(0, graph[0].length / 3, 0, graph.length / 3, size, graph);
//		node.two = calRatio(0, graph[0].length / 3, graph.length / 3, graph.length / 3 * 2, size, graph);
//		node.three = calRatio(0, graph[0].length / 3, graph.length / 3 * 2, graph.length / 3 * 3, size, graph);
//		
//		node.four = calRatio(graph[0].length / 3, graph[0].length / 3 * 2, 0, graph.length / 3, size, graph);
//		node.five = calRatio(graph[0].length / 3, graph[0].length / 3 * 2, graph.length / 3, graph.length / 3 * 2, size, graph);
//		node.six = calRatio(graph[0].length / 3, graph[0].length / 3 * 2, graph.length / 3 * 2, graph.length / 3 * 3, size, graph);
//		
//		node.seven = calRatio(graph[0].length / 3 * 2, graph[0].length / 3 * 3, 0, graph.length / 3, size, graph);
//		node.eight = calRatio(graph[0].length / 3 * 2, graph[0].length / 3 * 3, graph.length / 3, graph.length / 3 * 2, size, graph);
//		node.nine = calRatio(graph[0].length / 3 * 2, graph[0].length / 3 * 3, graph.length / 3 * 2, graph.length / 3 * 3, size, graph);
		
		System.out.println(node);
		
		double maxRatio = 0;
		int count = 0;
		for (int i = 0; i < word.length; i++) {
			double ratio = match(node, word[i]);
			System.out.println(wordName[i] + " " + ratio);
			if (ratio > maxRatio) {
				maxRatio = ratio;
				count = i;
			}
		}
		
		System.out.println(wordName[count]);
	}
	
	/**
	 * 
	 * @param xStart
	 * @param xEnd
	 * @param yStart
	 * @param yEnd
	 * @param size
	 * @param graph
	 * @return
	 */
	public static double calRatio(int xStart, int xEnd, int yStart, int yEnd, int size, byte[][] graph) {
		int count = 0;
		
		// 匹配时使用
		for (int x = xStart; x < xEnd; x++) {
			for (int y = yStart; y < yEnd; y++) {
				if (graph[x][y] == 0) {
					count++;
				}
			}
		}
		
		// 模板时使用
//		for (int x = xStart; x < xEnd; x++) {
//			for (int y = yStart; y < yEnd; y++) {
//				if (graph[y][x] == 0) {
//					count++;
//				}
//			}
//		}
		
		return (double)count / (double)size;
	}
	
	/**
	 * 匹配
	 * @param node1
	 * @param node2
	 * @return
	 */
	public static double match(Node node1, Node node2) {
		double one = calNodeRatio(node1.one, node2.one);
		double two = calNodeRatio(node1.two, node2.two);
		double three = calNodeRatio(node1.three, node2.three);
		double four = calNodeRatio(node1.four, node2.four);
		double five = calNodeRatio(node1.five, node2.five);
		double six = calNodeRatio(node1.six, node2.six);
		double seven = calNodeRatio(node1.seven, node2.seven);
		double eight = calNodeRatio(node1.eight, node2.eight);
		double nine = calNodeRatio(node1.nine, node2.nine);
		
		double ratio = (one + two + three + four + five + six + seven + eight + nine) / 9;
		
		return ratio;
	}
	
	/**
	 * 计算比率
	 * @param a
	 * @param b
	 * @return
	 */
	private static double calNodeRatio(double a, double b) {
		if (a == 0 || b == 0) {
			if (a == b) {
				return 1;
			} else {
				return 0;
			}
		}
		if (a > b) {
			return b / a;
		} else {
			return a / b;
		}
	}

}
