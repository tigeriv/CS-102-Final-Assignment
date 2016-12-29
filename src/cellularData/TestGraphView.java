package cellularData;
/**
 *  Tests the GraphView class by creating an object of type GraphView and adding components to it.
 *  Creates one container of type JFrame and adds an object of type GraphView.
 *
 * @author Foothill College, [Joey Wilson]
 */

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TestGraphView 
{
   private final int FRAME_WIDTH = 800;
   private final int FRAME_HEIGHT = 600;

   /**
    * Builds a list of countries to debug.
    */
   private void debugListOfCountries(Country [] allCountries)
   {
      // TODO: The purpose is to help you debug
      // Note: The implementation of method is optional.
   }

   /**
    * Creates a generic linked list. Then based on the user's input,
    * adds a random number of countries to the list.
    * @param allCountries      An array of Country objects
    */
   private LinkedList<Country> buildCountryList(Country [] allCountries)
   {  
      JFrame frame = new JFrame("Cellular Graph");

      String userInput = (String)JOptionPane.showInputDialog(
            frame,
            "Enter the number of countries to graph:\n",
            "Input",
            JOptionPane.PLAIN_MESSAGE,
            null,
            null,
            "5");

      int requestedSize = Integer.parseInt(userInput);

      // Build the list out of a random selection of countries.
      Random random = new Random();

      // A singly linked list of country data.
      LinkedList<Country> selectedCountries = new LinkedList<Country>();
      for (int i = 0; i < requestedSize; i++)
      {
         int selectedIndex = random.nextInt(allCountries.length);
         selectedCountries.add(allCountries[selectedIndex]);
      }

      return selectedCountries;
   }


   /**
    * Initializes the GUI with two JPanels and populates them.
    * One panel draws the data points, the second draws the legend.
    * @param selectedCountries      A randomly selected list of countries.
    *
    * Note: You may add as many panels as you see fit.
    */
   private void initializeGui(LinkedList<Country> selectedCountries)
   {
      JFrame frame = new JFrame("Cellular Graph");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // TODO: Select a layout for your frame
      //frame.setLayout(/* TO COMPLETE */);


      // TODO: Specify the size of your graph view based on your other panels
      int graph_panel_size = FRAME_WIDTH;

      // TODO: Define the class GraphView such that it will map the cellular data of a country to the 
      //       width and height of the panel.
      GraphView myPlots = new GraphView(graph_panel_size, FRAME_HEIGHT, selectedCountries);  

      // TODO: add the GraphView object to your layout
      //frame.add(/* myPlots, etc. */);
      frame.add(myPlots);
      
      //Container contentPane = frame.getContentPane();
      
      // Now, you can add whatever you want to the container
      
      // Draw the legend
        // TODO (optional extra credit): add the legend panel to your frame
      //LegendPanel legendPanel = new LegendPanel(myPlots);
      //frame.add(legendPanel);


      // Setup the frame to view.
      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setResizable(false);
      frame.setVisible(true);    
   }

   /**
    * Uses a CSV to parse a CSV file.
    * Adds the data for each country to an array of Country objects.
    * Adds a random selection of countries to a generic LinkedList object.
    * Draws the list of countries to a JFrame.
    * @param args array of arguments
    */
   public static void main(String[] args) 
   {     
      final String FILENAME = "resources/cellular"; // test file with shorter number of countries and subscription years
      //final String FILENAME = "resources/cellular.csv";   // test file with latest set of countries and subscription years

      // Parses the CSV data file
      // NOTE: Handle all exception`s in the constructor.
      // For full credit, do *not* throw exceptions to main. 
      CSVReader parser = new CSVReader(FILENAME);

      // In class CSVReader the accessor methods only return values of instance variables.
      String [] countryNames = parser.getCountryNames();
      int [] yearLabels = parser.getYearLabels();
      double [][] parsedTable = parser.getParsedTable();    


      // Holds the data for all Country object read from the input data file.
      Country [] countries;

      // Initializes the to the number of entries read by CSVReader.
      countries = new Country[countryNames.length];

      // Reference to a Country object
      Country current;

      // Go through each country name parsed from the CSV file.
      for (int countryIndex = 0; countryIndex < countries.length; countryIndex++)
      {
         int numberOfYears = yearLabels.length;   

         // TODO: Initially convert your CountryList to a generic LinkedList and make sure that list builds 
         //        correctly using the original Country constructor which takes the numberOfYears to setup
         //        the array of subscriptions.
         // NOTE: Once you've verified that your generic LinkedList builds correctly,
         //       make sure to comment the line below before submitting.
         //current = new Country(countryNames[countryIndex], numberOfYears);     // version 1

         // TODO: Once you are successful in creating a generic LinkedList of countries, create a
         //        LinkedList of SubscriptionYear in the Country class.
         //         So, your Country class should no longer have an array of SubscriptionYear objects.
         current = new Country(countryNames[countryIndex]); // version 2 and final version of Country constructor

         // Go through each year of cellular data read from the CSV file.
         for (int yearIndex = 0; yearIndex < numberOfYears; yearIndex++)
         {
            double [] allSubscriptions = parsedTable[countryIndex];
            double countryData = allSubscriptions[yearIndex];
            current.addSubscriptionYear(yearLabels[yearIndex], countryData);
         }

         // Add the newly created country to the 1D array.
         countries[countryIndex] = current;
      }

      // Creates an object of our current application.      
      TestGraphView application = new TestGraphView();

      // TODO: Initially, to test your output you may hard-code the number of 
      //       countries added, and the array positions selected.
      //     However, make sure to comment this out before submitting your work.
      //application.debugListOfCountries(countries);

      // Tests the generic LinkedList class by adding a random number of entries
      // from the array of Country objects.
      LinkedList<Country> listOfCountries = application.buildCountryList(countries);

      // Create graphical representation of our data.
      application.initializeGui(listOfCountries);

      // flush the error stream
      System.err.flush();

      System.out.println("\nDone with TestGraphView.");
   }
}