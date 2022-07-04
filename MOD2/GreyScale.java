import java.awt.*;
import java.awt.image.*;

public class GreyScale {

	static ImageTool imTool = new ImageTool ();

	public static void main (String[] argv)
	{
		// Read in an image and display.
		Image image = imTool.readImageFile ("statue.jpg");
		imTool.showImage (image, "original");

		// Convert to grey scale and display.
		Image greyImage = toGreyScale (image);
		imTool.showImage (greyImage, "grey-scale");
	}

	static Image toGreyScale (Image image)
	{
		// Extract pixels and size.
		int[][][] pixels = imTool.imageToPixels (image);
		int numRows = pixels.length;
		int numCols = pixels[0].length;

		// Make array of exactly the same size.
		int[][][] greyPixels = new int [numRows][numCols][4];

		// INSERT YOUR CODE HERE
		int avg = 0;

		//Create a for loop that traverses the pixels array 
		for(int i=0; i < numRows; i++)
		{
			for(int j = 0; j < numCols; j++)
			{
				//for loop to find the average of R,G,B values 
				for(int a = 1; a < 4; a++)
				{
					avg += pixels[i][j][a]; 
				}

				avg = avg / 3; 

				//for loop to put the new grey values into the new array
				for(int k = 1; k < 4; k++)
				{
					greyPixels[i][j][k] = avg;

				} 
				//reset the average 
				avg = 0;	

				//make sure that the opacity stays the same in each pixel 
				greyPixels[i][j][0] = pixels[i][j][0];
			} 
		}
		Image greyImage = imTool.pixelsToImage (greyPixels);
		return greyImage;
	}

}
