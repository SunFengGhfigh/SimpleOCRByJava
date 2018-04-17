package graph;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * 剪切
 * @author Sun
 *
 */
public class Cut {
	
	/**
	 * 水平剪切与竖直剪切
	 * @param graph
	 */
	public static void horizontalCutting(byte[][] graph) {
		
//		StdDraw.setXscale(0, graph.length);
//		StdDraw.setYscale(0, graph[0].length);
//		StdDraw.setPenRadius(.005);
		
		int[] point = new int[graph[0].length + 1];
		
		for (int y = 0; y < graph[0].length; y++) {
			int sum = 0;
			for (int x = 0; x < graph.length; x++) {
				if (graph[x][y] == 0) {
					sum++;
				}
			}
			point[graph[0].length - y] = sum;
		}
		
		// 平缓化
//		for (int j = 0; j < 10; j++) {
//			for (int i = 1; i < point.length - 1; i++) {
//				point[i] = (point[i - 1] + point[i] + point[i + 1]) / 3;
//			}
//		}
		
		// 画图
//		for (int i = 0; i < point.length; i++) {
//			StdDraw.point(point[i], i);
//		}
//		StdDraw.setPenColor(Color.RED);
//		StdDraw.setPenRadius(.01);
		
		ArrayList<Integer> row = new ArrayList<>();
		
		// 计算切割行数
		for (int i = 1; i < point.length - 1; i++) {
			if (point[i - 1] == 0 && point[i] > 0) {
				System.out.println("row start:" + i);
				row.add(i);
			}
			if (point[i] > 0 && point[i + 1] == 0) {
				System.out.println("row end:" + i);
				row.add(i);
			}
		}
		
		ArrayList<byte[][]> graphList = new ArrayList<>();
		
		// 切割
		for (int i = 0; i < row.size(); i+= 2) {
			byte[][] newGraph = new byte[graph.length][row.get(i + 1) - row.get(i)];
			int j = 0;
			for (int y = graph[0].length - row.get(i + 1); y < graph[0].length - row.get(i); y++) {
				for (int x = 0; x < graph.length; x++) {
					newGraph[x][j] = graph[x][y];
				}
				j++;
			}
			graphList.add(newGraph);
		}
		
		// 打印 竖直切割
		for (int i = 0; i < graphList.size(); i++) {
			byte[][] g = graphList.get(i);
			
			StdDraw.setXscale(0, graph[0].length);
			StdDraw.setYscale(0, graph.length);
			StdDraw.setPenRadius(.005);

			int[] pointSum = new int[graph.length];
			
			for (int x = 0; x < g.length; x++) {
				int sum = 0;
				for (int y = 0; y < g[0].length; y++) {
					if (g[x][y] == 0) {
						sum++;
					}
				}
				pointSum[g.length - x - 1] = sum; 
				StdDraw.point(sum, g.length - x);
			}
			
			StdDraw.setPenColor(Color.RED);
			
			// 记录纵向分割点
			List<Integer> verticalPointList = new ArrayList<>();
			for (int j = pointSum.length - 1; j > 0; j--) {
				if (pointSum[j] == 0 && pointSum[j - 1] > 0) {
					StdDraw.point(0, j);
					verticalPointList.add(j);
				}
				if (pointSum[j] > 0 && pointSum[j - 1] == 0) {
					StdDraw.point(0, j);
					verticalPointList.add(j);
				}
			}
			
			List<byte[][]> wordGraphList = new ArrayList<>();
			
			for (int j = 0; j < verticalPointList.size(); j += 2) {
				byte[][] g2 = new byte[verticalPointList.get(j) - verticalPointList.get(j + 1)][g[0].length];
				int k = 0;
				for (int x = g.length - verticalPointList.get(j); x < g.length - verticalPointList.get(j + 1); x++) {
					for (int y = 0; y < g[0].length; y++) {
						g2[k][y] = g[x][y];
					}
					k++;
				}
				wordGraphList.add(g2);
			}
			
			for (int j = 0; j < wordGraphList.size(); j++) {
				byte[][] g2 = wordGraphList.get(j);
				
				// 去除空行
				int count = 0;
				for (int x = 0; x < g2[0].length; x++) {
					boolean flag = false;
					for (int m = 0; m < g2.length; m++) {
						if (g2[m][x] == 0) {
							flag = true;
							break;
						}
					}
					if (flag) {
						count++;
					}
				}
				
				byte[][] wordGraph = new byte[count][g2.length];
				int k = 0;
				for (int x = 0; x < g2[0].length; x++) {
					boolean flag = false;
					for (int m = 0; m < g2.length; m++) {
						if (g2[m][x] == 0) {
							flag = true;
							break;
						}
					}
					if (flag) {
						for (int y = 0; y < g2.length; y++) {
							wordGraph[k][y] = g2[y][x];
						}
						k++;
					}
				}
				
				// 打印图像
//				for (int x = 0; x < wordGraph.length; x++) {
//					for (int y = 0; y < wordGraph[0].length; y++) {
//						System.out.print(wordGraph[x][y]);
//					}
//					System.out.println();
//				}
				
				new Eros().cal(wordGraph);
			}
		}
	}

}
