import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
public class MovingSquarePattern   extends MovingSquare {

	/** constructor to create an oval with default values
	 */
	public MovingSquarePattern  () {
		this(0, 0, defaultWidth, defaultHeight, defaultMarginWidth, defaultMarginHeight, defaultBorderColor, defaultFillColor, defaultPath); // the default properties
	}

	/** constructor to create an oval shape
	 */
	public MovingSquarePattern  (int x, int y, int w, int h, int mw, int mh, Color bc, Color fc, int pathType) {
		super(x ,y ,Math.min(w, h),Math.min(w, h),mw ,mh ,bc ,fc , pathType);
	}

	/** draw the oval with the fill colour
	 *  If it is selected, draw the handles
	 *  @param g	the Graphics control
	 */
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		//g.setColor(fillColor);
		//g.fillRect(topLeft.x, topLeft.y, Math.min(width, height),Math.min(width, height));
		g.setColor(fillColor);
		g.drawArc(topLeft.x, topLeft.y, Math.min(width, height),Math.min(width, height),-90,-90);
		g.drawArc(topLeft.x, topLeft.y, Math.min(width, height), Math.min(width, height),0,90);
		for (int i=0;i<=10;i++) {
			g.drawLine(topLeft.x, topLeft.y+Math.min(width, height)/10*i, topLeft.x+Math.min(width, height)/10*i,topLeft.y+ Math.min(width, height));

		}
		for (int i=0;i<=10;i++) {
			g.drawLine(topLeft.x+Math.min(width, height)/10*i,topLeft.y,topLeft.x+ Math.min(width, height), topLeft.y+Math.min(width, height)/10*i );

		}
		g.drawArc(topLeft.x, topLeft.y, Math.min(width, height),Math.min(width, height),-90,-90);

		g.setColor(fillColor);
		g.drawRect(topLeft.x, topLeft.y, Math.min(width, height),Math.min(width, height));
		drawHandles(g);
	}

	/** Returns whether the point is in the oval or not
	 * @return true if and only if the point is in the oval, false otherwise.
	 */
	public boolean contains(Point mousePt) {
		double dx, dy;
		Point EndPt = new Point(topLeft.x + Math.min(width, height), topLeft.y +Math.min(width, height));
		dx = (2 * mousePt.x - topLeft.x - EndPt.x) / (double) Math.min(width, height);
		dy = (2 * mousePt.y - topLeft.y - EndPt.y) / (double) Math.min(width, height);
		return (dx < 1.0 && dy<1.0) ;
	}
}