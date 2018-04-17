package graph;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.LookupOp;
import java.awt.image.RescaleOp;
import java.awt.image.ShortLookupTable;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * 
 * @author Sun
 *
 */
public class ImageProcessing {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame frame = new ImageProcessingFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
			
		});
	}

}

class ImageProcessingFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage image;
	private Image img;
	private static final int DEFAULT_WIDTH = 900;
	private static final int DEFAULT_HEIGHT = 600;
	private static List<Point> points = new ArrayList<>();
	private static int[][] oldPoints;
	private static byte[][] graph;
	
	public ImageProcessingFrame() {
		setTitle("ImageProcessing");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		add(new JComponent() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				if (image != null) {
					g.drawImage(image, 100, 100, null);
				}
			}
			
		});
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem openItem = new JMenuItem("Open");
		openItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openFile();
			}
			
		});
		fileMenu.add(openItem);
		
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		fileMenu.add(exitItem);
		
		JMenu editMenu = new JMenu("Edit");
		JMenuItem blurItem = new JMenuItem("Blur/模糊");
		blurItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				float weight = 1.0f / 9.0f;
				float[] elements = new float[9];
				for (int i = 0; i < 9; i++) {
					elements[i] = weight;
				}
				convolve(elements);
			}
			
		});
		editMenu.add(blurItem);
		
		JMenuItem sharpenItem = new JMenuItem("Sharpen/锐化");
		sharpenItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				float[] elements = {0.0f, -1.0f, 0.0f, -1.0f, 5.f, -1.0f, 0.0f, -1.0f, 0.0f};
				convolve(elements);
			}
			
		});
		editMenu.add(sharpenItem);
		
		JMenuItem brightenItem = new JMenuItem("Brighten/增亮");
		brightenItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				float a = 1.1f;
				float b = 0;
				RescaleOp op = new RescaleOp(a, b, null);
				filter(op);
			}
			
		});
		editMenu.add(brightenItem);
		
		JMenuItem edgeDetectItem = new JMenuItem("Edge detect/边缘检测");
		edgeDetectItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				float[] elements = {0.0f, -1.0f, 0.0f, -1.0f, 4.f, -1.0f, 0.0f, -1.0f, 0.0f};
				convolve(elements);
			}
			
		});
		editMenu.add(edgeDetectItem);
		
		JMenuItem negativeItem = new JMenuItem("Negative/底片");
		negativeItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				short[] negative = new short[256 * 1];
				for (int i = 0; i < 256; i++) {
					negative[i] = (short) (255 - i);
				}
				ShortLookupTable table = new ShortLookupTable(0, negative);
				LookupOp op = new LookupOp(table, null);
				filter(op);
			}
			
		});
		editMenu.add(negativeItem);
		
		JMenuItem rotateItem = new JMenuItem("Rotate/旋转");
		rotateItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (image == null) {
					return;
				}
				AffineTransform transform = AffineTransform.getRotateInstance(Math.toRadians(5)
						, image.getWidth() / 2, image.getHeight() / 2);
				AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BICUBIC);
				filter(op);
				
			}
			
		});
		editMenu.add(rotateItem);
		
		JMenuItem grayscale = new JMenuItem("Grayscale");
		grayscale.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int width = image.getWidth();
				int height = image.getHeight();
				int minx = image.getMinX();
				int miny = image.getMinY();
				
				oldPoints = new int[width][height];
				
				for (int x = minx; x < width; x++) {
					for (int y = miny; y < height; y++) {
						int pixel = image.getRGB(x, y);
						oldPoints[x][y] = pixel;
						int r = (pixel & 0xff0000) >> 16;
						int g = (pixel & 0xff00) >> 8;
						int b = (pixel & 0xff);
						int t = (int) (r * 0.11 + g * 0.59 + b * 0.3); 
						CalTrough.point[t]++;
						int newRgb = ((t << 16) & 0xff0000) + ((t << 8) & 0xff00) + t;
						if (newRgb > 0) {
							newRgb -= 16777216;
						}
						image.setRGB(x, y, newRgb);
					}
				}
				repaint();
			}
			
		});
		editMenu.add(grayscale);
	
		JMenuItem blackAndWhite = new JMenuItem("Black And White");
		blackAndWhite.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int width = image.getWidth();
				int height = image.getHeight();
				int minx = image.getMinX();
				int miny = image.getMinY();
				int trough = 0;
				graph = new byte[width][height];
				try {
					trough = CalTrough.trough();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				System.out.println("trough:" + trough);
				for (int x = minx; x < width; x++) {
					for (int y = miny; y < height; y++) {
						int pixel = image.getRGB(x, y);
						int r = (pixel & 0xff0000) >> 16;
						int g = (pixel & 0xff00) >> 8;
						int b = (pixel & 0xff);
						int t = (int) (r * 0.11 + g * 0.59 + b * 0.3); 
						if (t <= trough) {
							image.setRGB(x, y, 0);
							graph[x][y] = 0;
							points.add(new Point(x, y));
						} else {
							image.setRGB(x, y, -1);
							graph[x][y] = 1;
						}
					}
				}
				
				// 调试方法
//				printGraph();
//				WordTemplate.cal(graph);
//				new JiuGongGe().cal(graph);
//				new Eros().cal(graph);
				
				repaint();
			}
			
		});
		editMenu.add(blackAndWhite);
		
		JMenuItem denoising = new JMenuItem("Denoising");
		denoising.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int width = image.getWidth();
				int height = image.getHeight();
				int minx = image.getMinX();
				int miny = image.getMinY();
				for (int i = minx + 1; i < width - 1; i++) {
					for (int j = miny + 1; j < height - 1; j++) {
						int rgb = image.getRGB(i - 1, j - 1) + image.getRGB(i, j - 1) + image.getRGB(i + 1, j -1)
						 	+ image.getRGB(i - 1, j) + image.getRGB(i, j) + image.getRGB(i + 1, j)
						 	+ image.getRGB(i - 1, j + 1) + image.getRGB(i, j + 1) + image.getRGB(i + 1, j + 1);
						if (rgb > -4 * 16777216) {
							image.setRGB(i, j, -1);
						}
					}
				}
				repaint();
			}
			
		});
		editMenu.add(denoising);
		
		JMenuItem adjustAngle = new JMenuItem("Balance");
		adjustAngle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (image == null) {
					return;
				}
				
				double angle = -5;
				double balanceAngle = 0d;
				int maxBalanceCode = Integer.MIN_VALUE;
				
				BufferedImage rootImage = image;
				
				byte[][] graph2 = new byte[graph.length][graph[0].length];
				
				// 在正负5度以内调整
				while (angle <= 5) {
					
					// 顺时针旋转
					AffineTransform transform = AffineTransform.getRotateInstance(Math.toRadians(angle)
							, image.getWidth() / 2, image.getHeight() / 2);
					AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BICUBIC);
					filter(op);
					
					// 更新graph2 不改变图像大小
					for (int i = 0; i < graph.length; i++) {
						for (int j = 0; j < graph[0].length; j++) {
							int rgb = image.getRGB(i, j);
							
							// 去除失真带来的干扰值
							if (rgb != -1) {
								if (rgb == 0) {
									graph2[i][j] = 1;
								} else {
									if (rgb > 0) {
										graph2[i][j] = 1;
									} else {
										if (rgb < -16777216) {
											graph2[i][j] = 1;
										} else {
											graph2[i][j] = 0;
										}
									}
								}
							} else {
								graph2[i][j] = 1;
							}
						}
					}
					
					// 计算平衡值
					int balanceCode = calculateBalanceCode(graph2);
					if (balanceCode > maxBalanceCode) {
						maxBalanceCode = balanceCode;
						balanceAngle = angle;
					}
					angle += 0.1;
					
					// 图像还原
					image = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
					image.getGraphics().drawImage(rootImage, 0, 0, null);
				}
				
				System.out.println("Balance Angle : " + balanceAngle);
				
				// 调整到合适位置
				AffineTransform transform = AffineTransform.getRotateInstance(Math.toRadians(balanceAngle)
						, image.getWidth() / 2, image.getHeight() / 2);
				AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BICUBIC);
				filter(op);
				
				// 更新graph
				updateGraph();
				
			}
			
		});
		editMenu.add(adjustAngle);
		
		JMenuItem Recognition = new JMenuItem("Recognition");
		Recognition.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Cut.horizontalCutting(graph);
			}
			
		});
		editMenu.add(Recognition);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		setJMenuBar(menuBar);
	}
	
	/**
	 * Open a file and load the image.
	 */
	public void openFile() {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("E://"));
		String[] extensions = ImageIO.getReaderFileSuffixes();
		chooser.setFileFilter(new FileNameExtensionFilter("Image files", extensions));
		int r = chooser.showOpenDialog(this);
		if (r != JFileChooser.APPROVE_OPTION) {
			return;
		}
		
		try {
			img = ImageIO.read(chooser.getSelectedFile());
			image = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
			image.getGraphics().drawImage(img, 0, 0, null);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e);
		}
		repaint();
	}
	
	/**
	 * Apply a filter and repaint.
	 * @param op
	 */
	private void filter(BufferedImageOp op) {
		if (image == null) {
			return;
		}
		image = op.filter(image, null);
		repaint();
	}
	
	/**
	 * Apply a convolution and repaint.
	 * @param elements
	 */
	private void convolve(float[] elements) {
		Kernel kernel = new Kernel(3, 3, elements);
		ConvolveOp op = new ConvolveOp(kernel);
		filter(op);
	}
	
	/**
	 * Update graph by image.
	 */
	private void updateGraph() {
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; j++) {
				int rgb = image.getRGB(i, j);
				// 去除失真带来的干扰值
				if (rgb != -1) {
					if (rgb == 0) {
						graph[i][j] = 1;
					} else {
						if (rgb > 0) {
							graph[i][j] = 1;
						} else {
							if (rgb < -16777216) {
								graph[i][j] = 1;
							} else {
								graph[i][j] = 0;
							}
						}
					}
				} else {
					graph[i][j] = 1;
				}
			}
		}
	}
	
	/**
	 * Calculate the graph balance code.
	 * @return balance code
	 */
	@SuppressWarnings("unused")
	private int calculateBalanceCode() {
		int sum = 0;
		for (int i = 0; i < graph[0].length; i++) {
			boolean flag = true;
			for (int j = 0; j < graph.length; j++) {
				if (graph[j][i] != 1) {
					flag = false;
					break;
				}
			}
			if (flag) {
				sum++;
			}
		}
		return sum;
	}
	
	/**
	 * Calculate the graph balance code.
	 * @return balance code
	 */
	private int calculateBalanceCode(byte[][] graph2) {
		int sum = 0;
		for (int i = 0; i < graph2[0].length; i++) {
			boolean flag = true;
			for (int j = 0; j < graph2.length; j++) {
				if (graph2[j][i] != 1) {
					flag = false;
					break;
				}
			}
			if (flag) {
				sum++;
			}
		}
		return sum;
	}
	
	/**
	 * Print image graph by byte(0 or 1).
	 */
	@SuppressWarnings("unused")
	private void printGraph() {
		for (int y = 0; y < graph[0].length; y++) {
			for (int x = 0; x < graph.length; x++) {
				System.out.print(graph[x][y]);
			}
			System.out.println();
		}
	}
	
	/**
	 * Print image graph RGB.
	 */
	@SuppressWarnings("unused")
	private void printGraphRGB() {
		for (int y = 0; y < graph[0].length; y++) {
			for (int x = 0; x < graph.length; x++) {
				System.out.print(image.getRGB(x, y) + " ");
			}
			System.out.println();
		}
	}
	
}
