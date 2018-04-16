package graph;

/**
 * ����ǰ��ɫ�ͱ���ɫ
 * @author Sun
 *
 */
public class CalTrough {
	
	/**
	 * �㼯��
	 */
	public static double[] point = new double[260];
	
	/**
	 * ����ǰ��ɫ�ͱ���ɫ�еò���λ��
	 * @return
	 * @throws Exception
	 */
	public static int trough() throws Exception{
		// ȥ����ֵ ƽ����
		for (int j = 0; j < 100; j++) {
			for (int i = 1; i < point.length - 1; i++) {
				point[i] = (point[i - 1] + point[i] + point[i + 1]) / 3;
			}
		}
		
		// ��ͼ
//		StdDraw.setXscale(0, 255);
//		StdDraw.setYscale(0, 2000);
//		StdDraw.setPenRadius(.005);
//		for (int i = 0; i < point.length; i++) {
//			StdDraw.point(i, point[i]);
//		}
		
		// ���ǰ��ɫ�ͱ���ɫ��xֵ
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
		
		// ���ǰ��ɫ�ͱ���ɫ���ֵ�
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
