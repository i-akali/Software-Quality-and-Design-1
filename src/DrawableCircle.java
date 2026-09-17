import java.awt.*;
public class DrawableCircle extends DrawableShape {

    protected double radius;

    public DrawableCircle(double x, double y, Color color, double radius) {
        super(x, y, color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public void draw() {

        StdDraw.setPenColor(color);
        StdDraw.filledCircle(this.x, this.y, this.radius);
    }


    public static void main(String[] args) {
        DrawableCircle c = new DrawableCircle(0.25, 0.25, Color.RED, 0.10);
        c.draw();
        System.out.println(c.area());
        DrawableShape s = new DrawableCircle(0.75, 0.6, Color.BLUE, 0.20);
        s.draw();
        System.out.println(s.area());
    }

}
