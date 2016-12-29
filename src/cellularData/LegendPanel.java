package cellularData;

import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Prints a legend
 * @author tigeriv
 *
 */
public class LegendPanel extends JPanel
{
   int numCountries;
   private LinkedList<PlottedDataSet> plottedSet;
   
   public LegendPanel(GraphView view)
   {
      plottedSet = view.getSet();
      numCountries = findNumCountries();
   }
   
   /**
    * Finds number of countries
    * @return returns an int for the number of countries
    */
   private int findNumCountries()
   {
      int numC = 0;
      for (PlottedDataSet pS: plottedSet)
      {
         numC++;
      }
      return numC;
   }
   
   /**
    * Creates a legend
    * @param g2d The graphics object
    */
   protected void createLegend(Graphics g2d)
   {
      int i = 0;
      for (PlottedDataSet currentSet: plottedSet)
      {
         i++;
         g2d.setColor(currentSet.getColor()); 
         g2d.fillOval(675, 50*i, 20, 20);
         g2d.drawString(currentSet.getName(), 700, 50*i);  
      }
   }
}
