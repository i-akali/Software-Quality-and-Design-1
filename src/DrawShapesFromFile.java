import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DrawShapesFromFile {

    public static DrawableShape[] readFile(String filename){

        BufferedReader reader;

        try{
             reader = new BufferedReader(new FileReader(filename));
             String line = reader.readLine();

             int numShapes = Integer.parseInt(line);

             //Initialize array with size indicated in file
             DrawableShape[] shapes = new DrawableShape[numShapes];

            //Get next shape
            line = reader.readLine();

            //Loop until we have reached accounted shapes
            for(int i = 0; i <= shapes.length && line != null; i++)
            {
                //Split lines by whitespace
                String[] scope = line.split("\\s+");

                double x = Double.parseDouble(scope[1]);
                double y = Double.parseDouble(scope[2]);
                Color color = switch (scope[3]) {
                    case "blue" -> Color.BLUE;
                    case "green" -> Color.GREEN;
                    default -> Color.RED;
                };

                //Assign radius if a circle
                if(scope[0].equals("c")) {
                    double radius = Double.parseDouble(scope[4]);
                    DrawableShape result = new DrawableCircle(x, y, color, radius);
                    shapes[i] = result;
                }

                //Assign height and width if a rectangle
                if(scope[0].equals("r")) {
                    double width = Double.parseDouble(scope[4]);
                    double length = Double.parseDouble(scope[5]);
                    DrawableShape result = new DrawableRectangle(x, y, color, width, length);
                    shapes[i] = result;
                }

                //Get next shape
                line = reader.readLine();
            }

            return shapes;
        }
        catch(IOException e) {
            System.err.println("Error reading file");
            return null;
        }
        catch(NumberFormatException e) {
            System.err.println("Please specify valid size and location values");
            return null;
        }

    }

    public static void main(String[] args) {

        DrawableShape[] shapes = readFile(args[0]);

        if(shapes == null) {return;}
        for (DrawableShape shape : shapes) {
            shape.draw(); // oooooh... polymorphism!
        }
    }

}
