package graph;

/**
 * 计算前景色和背景色
 * @author Sun
 *
 */
public class CalTrough {
	
	/**
	 * 点集合
	 */
	public static double[] point = new double[260];
	
	/**
	 * 计算前景色和背景色中得波谷位置
	 * @return
	 * @throws Exception
	 */
	public static int trough() throws Exception{
		// 去尖锐值 平缓化
		for (int j = 0; j < 100; j++) {
			for (int i = 1; i < point.length - 1; i++) {
				point[i] = (point[i - 1] + point[i] + point[i + 1]) / 3;
			}
		}
		
		// 画图
//		StdDraw.setXscale(0, 255);
//		StdDraw.setYscale(0, 2000);
//		StdDraw.setPenRadius(.005);
//		for (int i = 0; i < point.length; i++) {
//			StdDraw.point(i, point[i]);
//		}
		
		// 获得前景色和背景色的x值
		int f = 0, b = 0;
		for (int i = 1; i < point.length - 1; i++) {
			if (point[i] > point[i - 1] && point[i] > point[i + 1]) {
				if (f == 0) {
					f = i;
				} else {
					b = i;
				}
			}
		}
		
		System.out.println("f:" + f + " b:" + b);
		
		// 获得前景色和背景色区分点
		if (b == 0) {
			int trough = 0;
			for (int i = 1; i < f; i++) {
				if (point[i] < point[i - 1] && point[i] < point[i + 1]) {
					trough = i;
				}
			}
			return trough;
		}
		int trough = 0;
		for (int i = f; i < b; i++) {
			if (point[i] < point[i - 1] && point[i] < point[i + 1]) {
				trough = i;
			}
		}
		return trough;
	}

}
