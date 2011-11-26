// This class renders a simple 2D world in shich a car operates
// The car's state is defined by it's position and velocity
// State = [x_dot, y_dot, x, y]
public class CarRenderer implements Renderer {

	private final double CAR_SIZE = 10;

	public CarRenderer {
	  	StdDraw.setCanvasSize(1000, 800);
			StdDraw.setXscale(-500.0, 500.0);
			StdDraw.setYscale(-400.0, 400.0);
	}

	public void update(Matrix s) {
    // Check state dimension
		if (s.getRowDimension() != 4 || s.getColumnDimension() != 1) {
      throw new RuntimeException("CarRenderer: invalid state dimension");
		}

		drawCar(s.get(2.0, 0.0), s.get(3.0, 0.0));
	}

	private void drawCar(double x, double y) {
    StdDraw.filledRectangle(x, y, CAR_SIZE / 2, CAR_SIZE / 2);
	}

}
