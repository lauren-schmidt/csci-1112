 
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

class WallPanel extends JPanel {

    // Store the image locally so that the panel class can access it for drawing.
    Image image;


    // This method is where drawing is done.

    public void paintComponent (Graphics g)
    {
        // Render the image.
	g.drawImage (image, 0,0, this);

        // INSERT YOUR CODE HERE:
	// Do your graffitti here. For example,
	g.drawLine (150,100, 150,140);
	g.drawLine (150,140, 200,140);
	g.drawLine (205, 140, 215,100);
	g.drawLine (215,100, 225,140);
	g.drawLine (205,120, 225,120);
	g.drawLine (230,140, 250, 140);
	g.drawLine (250,140, 250,120);
	g.drawLine (250, 120, 230, 120);
	g.drawLine (230, 120, 230,100);
	g.drawLine (230,100, 250,100);
    }

}


class WallFrame extends JFrame {

    public WallFrame ()
    {
        // Set frame parameters.
	this.setSize (400, 400);
	this.setTitle ("Wall");

        // Image tool to handle image loading.
	ImageTool imTool = new ImageTool ();
	Image image = imTool.readImageFile ("wall.jpg");

        // Create the panel and place inside frame.
	WallPanel panel = new WallPanel ();
	panel.image = image;
	Container cPane = this.getContentPane();
	cPane.add (panel);

        // Show the frame.
	this.setVisible (true);
    }
}


public class Wall {
    public static void main (String[] argv)
    {
        // Bring up the frame, which does everything else.
	WallFrame w = new WallFrame ();
    }

}
