
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClassifierDisplay extends JFrame {
	
	public ClassifierDisplay(String title) {
		setTitle(title);
		
		setLayout(new BorderLayout());
		
		
		canvas = new XYPlotCanvas();
		canvas.setPreferredSize(new Dimension(500, 500));
		add(canvas, BorderLayout.CENTER);
		
		
		
		/**
		 * adding nice things
		 */
		JPanel p = new JPanel();
		JLabel l = new JLabel("Linear Classifiers");
		p.setBackground(Color.GREEN);
		p.add(l);
	
		JPanel q = new JPanel();
		q.setBackground(Color.BLUE);
		JLabel n = new JLabel("p");
		q.add(n);
		
//		/add(q, BorderLayout.SOUTH);
		add(p , BorderLayout.NORTH);
		
		
		JPanel w = new JPanel();
		JLabel wq = new JLabel("Proportion Correct      1");
		w.setBackground(Color.ORANGE);
		w.add(wq);
		add(w, BorderLayout.WEST);
		
		this.setBackground(Color.GREEN);
		
		this.getContentPane().setBackground(Color.PINK);
		
		/**
		 * 
		 */
		
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	protected XYPlotCanvas canvas;
	protected int lastx, lasty;
	
	public void addPoint(double x, double y) {
		int xx = (int)(x * getWidth());
		int yy = (int)((1.0-y) * getHeight());
		canvas.getGraphics().drawLine(lastx, lasty, xx, yy);
		lastx = xx;
		lasty = yy;
	}

}