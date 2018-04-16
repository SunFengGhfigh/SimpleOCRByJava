package graph;

/**
 * 
 * @author Sun
 *
 */
public class Point {
	
	private int x;
	private int y;
	
	private double x0;
    private double y0;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(double x0, double y0) {
		this.x0 = x0;
		this.y0 = y0;
	}
	
	public double getRatio() {
		return x0 / y0; 
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getX0() {
		return x0;
	}

	public void setX0(double x0) {
		this.x0 = x0;
	}

	public double getY0() {
		return y0;
	}

	public void setY0(double y0) {
		this.y0 = y0;
	}
	
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", x0=" + x0 + ", y0=" + y0 + "]";
	}
	
}
