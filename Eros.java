package graph;

/**
 * 
 * @author Sun
 *
 */
public class Eros {
	
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
		private double ten;
		private double eleven;
		private double twelve;
		private double thirteen;
		private double fourteen;
		private double fifteen;
		private double sixteen;
		public Node() {
			super();
		}
		
		public Node(double one, double two, double three, double four, double five, double six, double seven,
				double eight, double nine, double ten, double eleven, double twelve, double thirteen, double fourteen,
				double fifteen, double sixteen) {
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
			this.ten = ten;
			this.eleven = eleven;
			this.twelve = twelve;
			this.thirteen = thirteen;
			this.fourteen = fourteen;
			this.fifteen = fifteen;
			this.sixteen = sixteen;
		}

		@Override
		public String toString() {
			return "Node [" + one + ", " + two + ", " + three + ", " + four + ", " + five
					+ ", " + six + ", " + seven + ", " + eight + ", " + nine + ", " + ten
					+ ", " + eleven + ", " + twelve + ", " + thirteen + ", " + fourteen
					+ ", " + fifteen + ", " + sixteen + "]";
		}
		
	}
	
	public final Node a = new Node(0.5607843137254902, 0.2901960784313726, 0.5764705882352941, 0.2, 0.12941176470588237, 0.1843137254901961, 0.5725490196078431, 0.3333333333333333, 0.6784313725490196, 0.19607843137254902, 0.4196078431372549, 0.3333333333333333, 0.7607843137254902, 0.32941176470588235, 0.5803921568627451, 0.5450980392156862);
	public final Node b = new Node(0.5610859728506787, 0.19909502262443438, 0.0, 0.0, 0.47058823529411764, 0.3076923076923077, 0.17873303167420815, 0.19004524886877827, 0.5135746606334841, 0.18099547511312217, 0.0, 0.6877828054298643, 0.4819004524886878, 0.25565610859728505, 0.083710407239819, 0.5859728506787331);
	public final Node d = new Node(0.0, 0.0, 0.19786096256684493, 0.5151515151515151, 0.1414141414141414, 0.1687462863933452, 0.24598930481283424, 0.5151515151515151, 0.7070707070707071, 0.0, 0.14557338086749852, 0.5008912655971479, 0.5115864527629234, 0.23648247177658943, 0.31194295900178254, 0.5377302436125966);
	public final Node e = new Node(0.21008403361344538, 0.36134453781512604, 0.19747899159663865, 0.4411764705882353, 0.8277310924369747, 0.24789915966386555, 0.18067226890756302, 0.5630252100840336, 0.8445378151260504, 0.029411764705882353, 0.0, 0.0, 0.2857142857142857, 0.5672268907563025, 0.28991596638655465, 0.24789915966386555);
	public final Node g = new Node(0.4269005847953216, 0.17738791423001948, 0.5399610136452242, 0.4093567251461988, 0.4327485380116959, 0.2475633528265107, 0.42300194931773877, 0.031189083820662766, 0.45614035087719296, 0.48927875243664715, 0.4269005847953216, 0.30994152046783624, 0.5516569200779727, 0.06042884990253411, 0.11500974658869395, 0.37037037037037035);
	public final Node h = new Node(0.5876068376068376, 0.16666666666666666, 0.0, 0.0, 0.4444444444444444, 0.28846153846153844, 0.27350427350427353, 0.12393162393162394, 0.4444444444444444, 0.1987179487179487, 0.038461538461538464, 0.5769230769230769, 0.5149572649572649, 0.14316239316239315, 0.027777777777777776, 0.5811965811965812);
	public final Node l = new Node(0.1440329218106996, 0.5679012345679012, 0.9382716049382716, 0.0, 0.0, 0.3333333333333333, 1.0, 0.0, 0.0, 0.3333333333333333, 0.9794238683127572, 0.0, 0.102880658436214, 0.4897119341563786, 0.9711934156378601, 0.1934156378600823);
	public final Node m = new Node(0.640625, 0.4419642857142857, 0.4263392857142857, 0.5357142857142857, 0.47098214285714285, 0.11607142857142858, 0.33705357142857145, 0.4330357142857143, 0.42857142857142855, 0.10714285714285714, 0.2857142857142857, 0.42857142857142855, 0.5022321428571429, 0.16964285714285715, 0.3080357142857143, 0.484375);
	public final Node n = new Node(0.5787476280834914, 0.3681214421252372, 0.4240986717267552, 0.4117647058823529, 0.4411764705882353, 0.23719165085388993, 0.0018975332068311196, 0.611954459203036, 0.4411764705882353, 0.11764705882352941, 0.0, 0.5977229601518027, 0.5512333965844403, 0.19639468690702086, 0.08918406072106262, 0.6916508538899431);
	public final Node o = new Node(0.27205882352941174, 0.34191176470588236, 0.27205882352941174, 0.4742647058823529, 0.7683823529411765, 0.0, 0.0, 0.6102941176470589, 0.7977941176470589, 0.0, 0.0, 0.5845588235294118, 0.3014705882352941, 0.3860294117647059, 0.23161764705882354, 0.375);
	public final Node s = new Node(0.48128342245989303, 0.22994652406417113, 0.18181818181818182, 0.5828877005347594, 0.6310160427807486, 0.7647058823529411, 0.4385026737967914, 0.20855614973262032, 0.1497326203208556, 0.0962566844919786, 0.40641711229946526, 0.8983957219251337, 0.6684491978609626, 0.23529411764705882, 0.19786096256684493, 0.49732620320855614);
	public final Node t = new Node(0.0, 0.3181818181818182, 0.26859504132231404, 0.0, 0.2396694214876033, 0.8388429752066116, 0.49586776859504134, 0.2892561983471074, 0.0, 0.8181818181818182, 0.18181818181818182, 0.0, 0.0, 0.7148760330578512, 0.4669421487603306, 0.2024793388429752);
	public final Node u = new Node(0.7242647058823529, 0.051470588235294115, 0.21323529411764705, 0.5882352941176471, 0.6470588235294118, 0.058823529411764705, 0.0625, 0.5882352941176471, 0.6066176470588235, 0.06985294117647059, 0.1323529411764706, 0.5882352941176471, 0.4889705882352941, 0.35294117647058826, 0.3382352941176471, 0.6433823529411765);
	public final Node w = new Node(0.6122580645161291, 0.1638709677419355, 0.4638709677419355, 0.29935483870967744, 0.38903225806451613, 0.1967741935483871, 0.4832258064516129, 0.12838709677419355, 0.1296774193548387, 0.47096774193548385, 0.47870967741935483, 0.13032258064516128, 0.0, 0.3696774193548387, 0.31225806451612903, 0.03354838709677419);
	public final Node y = new Node(0.2202729044834308, 0.6042884990253411, 0.05847953216374269, 0.4269005847953216, 0.0, 0.5263157894736842, 0.3255360623781676, 0.023391812865497075, 0.0, 0.0935672514619883, 0.4015594541910331, 0.0, 0.45419103313840153, 0.2982456140350877, 0.01364522417153996, 0.0);
	
	public final Node[] word = {a, b, d, e, g, h, l, m, n, o, s, t, u, w, y};
	public final String[] wordName = {"a", "b", "d", "e", "g", "h", "l", "m", "n", "o", "s", "t", "u", "w", "y"};
	
	public void cal(byte[][] graph) {
		
		Node node = new Node();
		int size = (graph.length / 4) * (graph[0].length / 4);
		
		// 切分 匹配时使用
		node.one = calRatio(0, graph.length / 4, 0, graph[0].length / 4, size, graph);
		node.two = calRatio(0, graph.length / 4, graph[0].length / 4, graph[0].length / 4 * 2, size, graph);
		node.three = calRatio(0, graph.length / 4, graph[0].length / 4 * 2, graph[0].length / 4 * 3, size, graph);
		node.four = calRatio(0, graph.length / 4, graph[0].length / 4 * 3, graph[0].length / 4 * 4, size, graph);
		
		node.five = calRatio(graph.length / 4, graph.length / 4 * 2, 0, graph[0].length / 4, size, graph);
		node.six = calRatio(graph.length / 4, graph.length / 4 * 2, graph[0].length / 4, graph[0].length / 4 * 2, size, graph);
		node.seven = calRatio(graph.length / 4, graph.length / 4 * 2, graph[0].length / 4 * 2, graph[0].length / 4 * 3, size, graph);
		node.eight = calRatio(graph.length / 4, graph.length / 4 * 2, graph[0].length / 4 * 3, graph[0].length / 4 * 4, size, graph);
		
		node.nine = calRatio(graph.length / 4 * 2, graph.length / 4 * 3, 0, graph[0].length / 4, size, graph);
		node.ten = calRatio(graph.length / 4 * 2, graph.length / 4 * 3, graph[0].length / 4, graph[0].length / 4 * 2, size, graph);
		node.eleven = calRatio(graph.length / 4 * 2, graph.length / 4 * 3, graph[0].length / 4 * 2, graph[0].length / 4 * 3, size, graph);
		node.twelve = calRatio(graph.length / 4 * 2, graph.length / 4 * 3, graph[0].length / 4 * 3, graph[0].length / 4 * 4, size, graph);
		
		node.thirteen = calRatio(graph.length / 4 * 3, graph.length / 4 * 4, 0, graph[0].length / 4, size, graph);
		node.fourteen = calRatio(graph.length / 4 * 3, graph.length / 4 * 4, graph[0].length / 4, graph[0].length / 4 * 2, size, graph);
		node.fifteen = calRatio(graph.length / 4 * 3, graph.length / 4 * 4, graph[0].length / 4 * 2, graph[0].length / 4 * 3, size, graph);
		node.sixteen = calRatio(graph.length / 4 * 3, graph.length / 4 * 4, graph[0].length / 4 * 3, graph[0].length / 4 * 4, size, graph);
		
		// 切分 模板时使用
//		node.one = calRatio(0, graph[0].length / 4, 0, graph.length / 4, size, graph);
//		node.two = calRatio(0, graph[0].length / 4, graph.length / 4, graph.length / 4 * 2, size, graph);
//		node.three = calRatio(0, graph[0].length / 4, graph.length / 4 * 2, graph.length / 4 * 3, size, graph);
//		node.four = calRatio(0, graph[0].length / 4, graph.length / 4 * 3, graph.length / 4 * 4, size, graph);
//		
//		node.five = calRatio(graph[0].length / 4, graph[0].length / 4 * 2, 0, graph.length / 4, size, graph);
//		node.six = calRatio(graph[0].length / 4, graph[0].length / 4 * 2, graph.length / 4, graph.length / 4 * 2, size, graph);
//		node.seven = calRatio(graph[0].length / 4, graph[0].length / 4 * 2, graph.length / 4 * 2, graph.length / 4 * 3, size, graph);
//		node.eight = calRatio(graph[0].length / 4, graph[0].length / 4 * 2, graph.length / 4 * 3, graph.length / 4 * 4, size, graph);
//		
//		node.nine = calRatio(graph[0].length / 4 * 2, graph[0].length / 4 * 3, 0, graph.length / 4, size, graph);
//		node.ten = calRatio(graph[0].length / 4 * 2, graph[0].length / 4 * 3, graph.length / 4, graph.length / 4 * 2, size, graph);
//		node.eleven = calRatio(graph[0].length / 4 * 2, graph[0].length / 4 * 3, graph.length / 4 * 2, graph.length / 4 * 3, size, graph);
//		node.twelve = calRatio(graph[0].length / 4 * 2, graph[0].length / 4 * 3, graph.length / 4 * 3, graph.length / 4 * 4, size, graph);
//		
//		node.thirteen = calRatio(graph[0].length / 4 * 3, graph[0].length / 4 * 4, 0, graph.length / 4, size, graph);
//		node.fourteen = calRatio(graph[0].length / 4 * 3, graph[0].length / 4 * 4, graph.length / 4, graph.length / 4 * 2, size, graph);
//		node.fifteen = calRatio(graph[0].length / 4 * 3, graph[0].length / 4 * 4, graph.length / 4 * 2, graph.length / 4 * 3, size, graph);
//		node.sixteen = calRatio(graph[0].length / 4 * 3, graph[0].length / 4 * 4, graph.length / 4 * 3, graph.length / 4 * 4, size, graph);
		
		// 打印所识别字母的node信息
//		System.out.println(node);
		
//		double maxRatio = 0;
//		int count = 0;
//		for (int i = 0; i < word.length; i++) {
//			double ratio = match(node, word[i]);
//			
//			// 打印每次匹配的结果
////			System.out.println(wordName[i] + " " + ratio);
//			
//			if (ratio > maxRatio) {
//				maxRatio = ratio;
//				count = i;
//			}
//		}
		
		int count = matchAllWord(node);
		
		count = updateCount(count, graph, node);
		
		System.out.print(wordName[count]);
	}
	
	/**
	 * 计算像素点占比
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
	 * 匹配单词占比
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
		double ten = calNodeRatio(node1.ten, node2.ten);
		double eleven = calNodeRatio(node1.eleven, node2.eleven);
		double twelve = calNodeRatio(node1.twelve, node2.twelve);
		double thirteen = calNodeRatio(node1.thirteen, node2.thirteen);
		double fourteen = calNodeRatio(node1.fourteen, node2.fourteen);
		double fifteen = calNodeRatio(node1.fifteen, node2.fifteen);
		double sixteen = calNodeRatio(node1.sixteen, node2.sixteen);
		
		double ratio = (one + two + three + four + five + six + seven + eight + nine + ten + eleven + twelve + thirteen + fourteen + fifteen + sixteen) / 16;
		
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
	
	/**
	 * 匹配所有字母
	 * @param node
	 * @param name
	 * @return
	 */
	private int matchAllWord(Node node, String...name) {
		double maxRatio = 0;
		int count = 0;
		for (int i = 0; i < word.length; i++) {
			
			boolean flag = true;
			for (int j = 0; j < name.length; j++) {
				if (name[j].equals(wordName[i])) {
					flag = false;
					break;
				}
			}
			if (!flag) {
				continue;
			}
			
			double ratio = match(node, word[i]);
			
			// 打印每次匹配的结果
//			System.out.println(wordName[i] + " " + ratio);
			
			if (ratio > maxRatio) {
				maxRatio = ratio;
				count = i;
			}
		}
		return count;
	}
	
	/**
	 * 修正字符
	 * @param count
	 * @param graph
	 * @param node
	 * @return
	 */
	private int updateCount(int count, byte[][] graph, Node node) {
		
		// 纠正部分h误认为b
		if (wordName[count] == "b") {
			int num = 0;
			
			for (int j = graph.length - 2; j < graph.length - 1; j++) {
				for (int i = 0; i < graph[0].length; i++) {
					if (graph[j][i] == 0) {
						num++;
					}
				}
			}
			
			if (((double)num / (double)graph[0].length) > 0.6) {
				count = matchAllWord(node, "b");
			}
		}
		
		// 纠正部分o误认为e
		if (wordName[count] == "e") {
			if (node.twelve > 0.4) {
				count = matchAllWord(node, "e");
			}
		}
		
		return count;
	}


}
