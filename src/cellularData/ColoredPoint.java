package cellularData;

import java.awt.Color;
import java.awt.Point;
import java.text.DecimalFormat;

/**
 * Class ColoredPoint defines a colored point to be plotted
 * @author tigeriv
 *
 */
public class ColoredPoint extends Point
{
   private Color color;
   private double originalX;
   private double originalY;
   
   /**
    * Constructor for Colored Point
    * @param cC Constructor Color
    * @param mX Constructor mappedX
    * @param mY Constructor mapped Y
    * @param oX Constructor original X
    * @param oY Constructor original Y
    */
   public ColoredPoint(Color cC, int mX, int mY, double oX, double oY)
   {
      super(mX, mY);
      color = cC;
      originalX = oX;
      originalY = oY;
   }
   
   /**
    * Returns the color for the point
    * @return the color
    */
   public Color getColor()
   {
      return color;
   }
   
   /**
    * Returns label for the point
    * @return a String for label
    */
   public String getLabel()
   {
      DecimalFormat df = new DecimalFormat();
      df.setMaximumFractionDigits(1);
      String rV = "(" + (int)originalX + ", " + df.format(originalY) + ")";
      return rV;
   }
}
