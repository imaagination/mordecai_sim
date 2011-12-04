import Jama.*;

public class GravityRenderer implements Renderer {

	private final double CAR_SIZE = 10;
  private final double WIDTH = 512;
	private final double HEIGHT = 512;

  public GravityRenderer() {
	  	StdDraw.setCanvasSize((int)WIDTH, (int)HEIGHT);
			StdDraw.setXscale(-WIDTH / 2, WIDTH / 2);
			StdDraw.setYscale(-HEIGHT / 2, HEIGHT / 2);
			StdDraw.show();
	}

	public void update(Matrix s) {
    StdDraw.clear();
		draw(s.get(2, 0), s.get(3, 0));
	}

	private void draw(double x, double y) {
    StdDraw.filledRectangle(x, y, CAR_SIZE / 2, CAR_SIZE / 2);
	}

}
