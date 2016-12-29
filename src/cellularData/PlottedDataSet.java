package cellularData;

import java.awt.Color;
import java.util.Random;

/**
 * Class Plotted Data Set contains a linked list of Colored Point for a Country
 * @author tigeriv
 *
 */
public class PlottedDataSet
{
    private String countryName;
    private Color color;
    private LinkedList<ColoredPoint> thisSet;
    public PlottedDataSet(String countryNameC)
    {
       thisSet = new LinkedList<ColoredPoint>();
       Random rand = new Random();
       float r = rand.nextFloat();
       float g = rand.nextFloat();
       float b = rand.nextFloat();
       Color randomColor = new Color(r, g, b);
       color = randomColor;
       countryName = countryNameC;
    }
    
    /**
     * Adds a colored point to the list
     * @param point A colored point
     */
    public void add (ColoredPoint point)
    {
       thisSet.add(point);
    }
    
    /**
     * Returns list of points
     * @return List of colored points
     */
    public LinkedList<ColoredPoint> getSet()
    {
       return thisSet;
    }
    
    /**
     * Returns object as a string, of all points in the list
     */
    public String toString()
    {
       String thisText = "";
       for (ColoredPoint thisPoint: thisSet)
       {
          thisText = thisText + thisPoint.toString() + " ";
       }
       return thisText;
    }
    
    /**
     * Getter for the color
     * @return the color of the points
     */
    public Color getColor()
    {
       return color;
    }
    
    /**
     * Getter for country name
     * @return the country name
     */
    public String getName()
    {
       return countryName;
    }
}
