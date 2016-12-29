package cellularData;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * GraphView prints the graph
 * @author tigeriv
 *
 */
public class GraphView extends JPanel
{
   private int width;
   private int height;
   private Font font;
   private double plottedXmin;
   private double plottedXmax;
   private double plottedYmin;
   private double plottedYmax;
   private int dataMinX;
   private int dataMaxX;
   private double dataMinY;
   private double dataMaxY;
   private LinkedList<Country> countries;
   private int margin = 100;
   private LinkedList<PlottedDataSet> plottedSet;
   private static int POINT_SIZE = 10;
   private LegendPanel legendPanel;
   
   /**
    * Graph View Constructor
    * @param widthC Constructor Width
    * @param heightC Constructor Height
    * @param countriesC Constructor Countries linked list
    */
   public GraphView(int widthC, int heightC, LinkedList<Country> countriesC)
   {
      font = new Font("Serif", Font.PLAIN, 8);
      width = widthC;
      height = heightC;
      countries = countriesC;
      plottedYmin = 0;
      plottedYmax = 600;
      plottedXmin = 0;
      plottedXmax = 700;
      height = 600;
      width = 700;
      dataMinX = countries.getHead().getData().getMinYear();
      dataMaxX = countries.getHead().getData().getMaxYear();
      dataMinY = 0;
      dataMaxY = getMaxSubscriptions();
      dataMaxY = dataMaxY/100;
      //Loop through and create a new plotted data set list for each country
      //For each subscription data, pass in value and map x and y coordinates 
      //then create colored point
      LinkedList<PlottedDataSet> thisSet = new LinkedList<PlottedDataSet>();
      for (Country thisCountry: countries)
      {
         PlottedDataSet currentCountry = new PlottedDataSet(thisCountry.getName());
         for (SubscriptionYear thisYear: thisCountry.getSubscriptions())
         {
            double originalX = thisYear.getYear();
            double originalY = thisYear.getSubscriptions()/100;
            double mappedX = map(originalX, dataMinX, dataMaxX, margin, width-margin);
            double mappedY = map(originalY, dataMinY, dataMaxY, height-margin, margin);
            int mX = (int)mappedX;
            int mY = (int)mappedY;
            ColoredPoint thisPoint = new ColoredPoint(currentCountry.getColor(), mX, mY, originalX, originalY);
            currentCountry.add(thisPoint);
         }
         thisSet.add(currentCountry);
      }
      plottedSet = thisSet;
      legendPanel = new LegendPanel(this);
   }
   
   /**
    * Maps the point to the graph
    * @param value Subscriptions amount
    * @param dataMin Min value
    * @param dataMax Max value
    * @param plottedMin Plotted min value
    * @param plottedMax Plot max value
    * @return Returns a double for the mapped value
    */
   //Maps Data Points to drawing area
   static public final double map(double value, double dataMin, double dataMax,
         double plottedMin, double plottedMax)
  {
      return plottedMin + (plottedMax - plottedMin) * ((value - dataMin) / (dataMax - dataMin));
  }
   
   /**
    * Paints the components
    */
   protected void paintComponent(Graphics g2d)
   {
      for (PlottedDataSet currentSet: plottedSet)
      {
         for (ColoredPoint current: currentSet.getSet())
         {
            g2d.setColor(current.getColor());   
            g2d.fillOval((int)current.getX(), (int)current.getY(), POINT_SIZE, POINT_SIZE);
            g2d.drawString(current.getLabel(), (int)current.getX(),(int)current.getY());  
         }
      } 
      int pX = (int) plottedXmax;
      int pY = (int) plottedYmax;
      g2d.setColor(Color.black);
      g2d.drawLine(pX, pY-100, 100, pY-100);
      g2d.drawLine(100, 0, 100 , pY - 100);
      g2d.drawString("Subscriptions", 10, 300);
      g2d.drawString("Year", 400, 520);
      legendPanel.createLegend(g2d);
   }
   
   /**
    * Finds the max subscriptions
    * @return The max number of subscriptions
    */
   public double getMaxSubscriptions()
   {
      double maxSubscription = 0;
      for (Country countryString: countries)
      {
         double thisSubscription = countryString.getMaxSubscriptions();
         if (thisSubscription > maxSubscription)
         {
            maxSubscription = thisSubscription;
         }
      }
      return maxSubscription;
   }
   
   /**
    * Returns plottedSet
    * @return A linked list of plotted data sets
    */
   public LinkedList<PlottedDataSet> getSet()
   {      
      return plottedSet;
   }
}
