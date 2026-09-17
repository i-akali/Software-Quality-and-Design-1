import java.awt.*;

public class DrawableRectangle extends DrawableShape {
    protected double width;
    protected double height;

    public DrawableRectangle(double x, double y, Color color, double width, double height){
        super(x,y,color);
        this.width = width;
        this.height = height;
    }

    public double getWidth(){
        return width;
    }

    public double getHeight(){
        return height;
    }

    @Override
    public double area(){
        return width * height;
    }

    @Override
    public void draw() {
        StdDraw.setPenColor(color);
        StdDraw.filledRectangle(x,y,width/2, height/2);

    }

    public static void main(String[] args){
        DrawableRectangle c = new DrawableRectangle(0.25, 0.25, Color.RED, 0.50, 0.30);
        c.draw();
        System.out.println(c.area());
        DrawableShape s = new DrawableRectangle(0.75, 0.6, Color.BLUE, 0.20, 0.75);
        s.draw();
        System.out.println(s.area());
    }
}
