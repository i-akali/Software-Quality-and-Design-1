import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Program to implement RSVP speed reader using StdDraw library.
 *
 * This assignment originally created by Peter-Michael Osera at University of Pennsylvania.
 * 
 * @author Chris Murphy
 */

public class SpeedReader {

    /*
    This method is responsible for updating the text in the window for the speed reader.
    You will need to change the parameters as you complete this part of the assignment.
     */
    public static void show(String filename, int rate) {




        // Attempt to read file, exit if failed
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();

            // this sets up the window... don't forget to call it!
            setup();

            while(line != null) {

                //Split each line by word
                String [] words = line.split("\\s+");


                for(String word: words) {

                    //Skip empty space
                    if(word.isEmpty())
                    {
                       continue;
                    }


                    //Find our middle character
                    char anchor = word.charAt(word.length()/2);


                    if(word.length() % 2 == 0 )
                    {
                        //Shifts the word to the left if there is an even number of characters
                        // 7.5 units / 2 = 3.5 units; 50 - 3.5 = 46.25 units
                        StdDraw.text(46.25, 50, String.valueOf(word));

                    }
                    else{
                        //Prints to the middle of the terminal if an odd number of characters
                        StdDraw.text(50, 50, String.valueOf(word));
                    }


                    // this displays the text
                    StdDraw.show();

                    StdDraw.setPenColor(StdDraw.RED);

                    // this places the text in the center of the screen
                    // the coordinate (50, 50) is used for the center of the text
                    StdDraw.text(50, 50, String.valueOf(anchor));
                    StdDraw.show();
                    StdDraw.setPenColor(StdDraw.BLACK);

                    // this causes the program to wait for 500ms
                    while(!StdDraw.isMousePressed())
                    {
                        StdDraw.pause(1);
                    }
                    StdDraw.pause(60000/rate);
                    // this removes everything that is being displayed
                    StdDraw.clear();
                }
                //Get next line
                line = reader.readLine();
            }

            reader.close();


        }
        catch (IOException e){
            System.err.println("Error reading file");
        }


    }

    /*
    This method sets up the window for the speed reader.
    You should not need to change anything here!
    Please speak to the Instructor if you think any change is necessary.
     */
    private static void setup() {
        // this creates a window of 800x600 pixels
        StdDraw.setCanvasSize(800, 400);

        // this sets the scale of the x- and y-axis to be from 0 to 100
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);

        // this enables animation so that things don't appear jittery
        StdDraw.enableDoubleBuffering();

        // this sets the drawing color to black
        StdDraw.setPenColor(StdDraw.BLACK);


        // this sets the text font to be fixed-width
        StdDraw.setFont(new java.awt.Font("COURIER NEW", java.awt.Font.BOLD, 100));
    }


    public static void main(String[] args) {
        // modify this code as needed in order to pass arguments to the show() method

        //exit if not two arguements
        if(args.length != 2)
        {
            System.err.println("Please specify the file name and wpm");
            return;
        }

        //Exit if invalid wpm
        try{
            int wpm = Integer.parseInt(args[1]);
            if(wpm <= 0) {
                System.err.println("Please specify a positive wpm");
                return;
            }
            show("alice.txt", wpm);
        }
        catch(NumberFormatException e) {
            System.err.println("Please specify a positive wpm");

        }

    }
    
}
