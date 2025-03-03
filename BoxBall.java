import java.awt.*;
import java.util.*;
import java.awt.geom.*;
/**
 * Write a description of class BoxBall here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BoxBall
{
    private Ellipse2D.Double circle;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int boxSize;
    private Canvas canvas;
    private int ySpeed = 7;  
    private int xSpeed = 7;
    private Color color;
    
    /**
     * Constructor for objects of class BouncingBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter,
                        Canvas drawingCanvas,int Boxsize)
    {
        xPosition = xPos;
        yPosition = yPos;
        diameter = ballDiameter;
        boxSize = Boxsize;
        canvas = drawingCanvas;
        Random ran = new Random();
        color = new Color(ran.nextInt(125) + 30, ran.nextInt(125) + 30 ,ran.nextInt(125) + 30);
    }
    
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }
    
    /**
    * Erase this ball at its current position.
    **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    
    
    
    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        yPosition += ySpeed;
        xPosition += xSpeed;

        // check if it has hit the ground
        if (yPosition >= (boxSize - diameter) && ySpeed > 0) {
            yPosition = (int)(boxSize - diameter);
            ySpeed = -ySpeed; 
        }
        if (xPosition >= (boxSize - diameter) && xSpeed > 0) {
            xPosition = (int)(boxSize - diameter);
            xSpeed = -xSpeed; 
        }
        if (yPosition < (40 + diameter) && ySpeed < 0) {
            yPosition = (int)(35 + diameter);
            ySpeed = -ySpeed; 
        }
        if (xPosition < (40 + diameter) && xSpeed < 0) {
            xPosition = (int)(35 + diameter);
            xSpeed = -xSpeed; 
        }

        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}
