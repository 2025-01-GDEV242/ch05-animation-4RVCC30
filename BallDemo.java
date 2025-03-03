import java.awt.Color;

/**
 * BOX BALL!!!!!!!!!!!!!!!!!!!!!! - THEY PUT THE BALLS IN A BOX!!!!!!!!!!!!!!!!!
 * Canvas class. 
 *
 * @author Emery Vallejo
 * @version 2025.03.02
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private boolean Finished;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }
    
    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, ground, 550, ground);
        myCanvas.drawLine(50, ground - 50, 550, ground - 50);

        // create and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
        }
    }
    
    public void bounceWalls()
    {
        int boxSize = 400;   // position of the ground line
        int minSize = 50;
        
        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(minSize, boxSize, boxSize, boxSize);
        myCanvas.drawLine(minSize, minSize, boxSize, minSize);
        myCanvas.drawLine(minSize, boxSize, minSize, minSize);
        myCanvas.drawLine(boxSize, boxSize,boxSize,minSize);

        // create and show the balls
        BoxBall ball = new BoxBall(200, 50, 16 , myCanvas, boxSize);
        ball.draw();
        BoxBall ball2 = new BoxBall(150, 50, 32, myCanvas, boxSize);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
        }
    }
}
