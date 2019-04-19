

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
public class MovingQuadPie extends MovingOval {

	/** constructor to create an oval with default values
	 */
	public MovingQuadPie() {
		this(0, 0, defaultWidth, defaultHeight, defaultMarginWidth, defaultMarginHeight, defaultBorderColor, defaultFillColor, defaultPath); // the default properties
	}

	/** constructor to create an oval shape
	 */
	public MovingQuadPie(int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, int pathType) {
		super(x ,y ,w ,h ,mw ,mh ,bc ,fc , pathType);
	}

	/** draw the oval with the fill colour
	 *  If it is selected, draw the handles
	 *  @param g	the Graphics control
	 */
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(borderColor);
		g.fillOval(topLeft.x-5, topLeft.y-5,Math.min(width, height)+10, Math.min(width, height)+10);
		g.drawArc(topLeft.x, topLeft.y, Math.min(width, height), Math.min(width, height),0,360);

		g.setColor(fillColor);
		g.fillArc(topLeft.x, topLeft.y, Math.min(width, height),Math.min(width, height),0,90);
		g.fillArc(topLeft.x, topLeft.y, Math.min(width, height), Math.min(width, height),-90,-90);
		g.setColor(Color.white);
		g.fillArc(topLeft.x, topLeft.y, Math.min(width, height),Math.min(width, height),90,90);
		g.fillArc(topLeft.x, topLeft.y, Math.min(width, height), Math.min(width, height),0,-90);		


		drawHandles(g);
	}

	/** Returns whether the point is in the oval or not
	 * @return true if and only if the point is in the oval, false otherwise.
	 */
	public boolean contains(Point mousePt) {
		double dx, dy;
		Point EndPt = new Point(topLeft.x + width, topLeft.y + height);
		dx = (2 * mousePt.x - topLeft.x - EndPt.x) / (double) width;
		dy = (2 * mousePt.y - topLeft.y - EndPt.y) / (double) height;
		return dx * dx + dy * dy < 1.0;
	}
}