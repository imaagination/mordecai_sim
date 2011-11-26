// This class renders a simple 2D world in shich a car operates
// The car's state is defined by it's position and velocity
// State = [x_dot, y_dot, x, y]

import Jama.*;

public class CarRenderer implements Renderer {

	private final double CAR_SIZE = 10;
  private final double WIDTH = 1000;
	private final double HEIGHT = 800;

  public CarRenderer() {
	  	StdDraw.setCanvasSize((int)WIDTH, (int)HEIGHT);
			StdDraw.setXscale(-WIDTH / 2, WIDTH / 2);
			StdDraw.setYscale(-HEIGHT / 2, HEIGHT / 2);
			StdDraw.show();
	}

	public void update(Matrix s) {
    // Check state dimension
		if (s.getRowDimension() != 4 || s.getColumnDimension() != 1) {
      throw new RuntimeException("CarRenderer: invalid state dimension");
		}

    StdDraw.clear();
		drawCar(s.get(2, 0), s.get(3, 0));
	}

	private void drawCar(double x, double y) {
    StdDraw.filledRectangle(x, y, CAR_SIZE / 2, CAR_SIZE / 2);
	}

}
