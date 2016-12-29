package cellularData;

/**
 * CSVReader class, converts a csv file to a usable double array.
 * @author Foothill College, [Joey Wilson]
 */
import java.io.File;
import java.util.Scanner;

/**
 * Class CSV Reader converts a csv file to a usable double array.
 * @author tigeriv
 *
 */
public class CSVReader {
   
   private String [] linesOfText;
   private String [][] cellularDataTable;
   private int [] yearLabels;
   private int numYears;
   private int numLines;
   private String [] countryNames;
    
   /**
    * Constructor for CSVReader, takes parameter of a String for file location.
    * @param fileLocation
    * String for file location
    * Integer for the number of lines
    */
   CSVReader(String fileLocation)
   {
      //numLines = numLines1;
      numLines = findNumLines(fileLocation);
      linesOfText = new String[numLines];
      countryNames = new String [numLines - 3];
      int count = 0;      
       try {
           File file = new File(fileLocation);

           Scanner input = new Scanner(file);            
           
           while (input.hasNextLine() && count < linesOfText.length) {
               String line = input.nextLine();    
               linesOfText[count] = line;
               count++;
           }
           input.close();
       } catch (Exception ex) {
           ex.printStackTrace();
       }
       //int numYears = getNumYears(linesOfText);
       //System.out.println(numYears);
       numYears = findNumYears (linesOfText);
       cellularDataTable = separateByTokens(linesOfText, numYears);
       yearLabels = new int[numYears];
       yearLabels = findYearLabels(linesOfText);
       countryNames = findCountryNames(cellularDataTable, numLines);
   }
   
   /**
    * Returns an integer for the total number of years, found through textLines
    * @param textLines
    * String for lines of text
    * @return number of years
    * An integer for number of years
    */
   int findNumYears (String[] textLines)
   {
      int years = 0;
      for (int i = 0; i < textLines.length; i++)
      {
         String [] tokens = textLines[i].split(",");
         if (tokens [0].equals("Country Name"))
         {          
            years = tokens.length;
         }                           
      }   
      return years;
   }
    
   /**
    * Returns a 2D array, of textLines separated by commas
    * @param textLines
    * String array of lines of text
    * @param numYears
    * Integer for number of years
    * @return
    * Returns a 2D string array
    */
   String[][] separateByTokens(String[] textLines, int numYears)
   {
      String [][] allTokens;
      allTokens = new String [textLines.length][numYears];
      for (int i = 1; i < textLines.length; i++)
      {
         String [] tokens = textLines[i].split(",");
         if (tokens[0].charAt(0) == '"')
         {
            tokens [0] = tokens [0] + tokens [1];
            for (int l = 1; l < tokens.length - 1; l ++)
            {
               tokens [l] = tokens [l+1];
            }
         }
         for (int j = 0; j < tokens.length; j++)
         {
            if (i < textLines.length && j < numYears)
            {
               allTokens[i][j] = tokens[j];
            }
         }
      }
      return allTokens;
   }
   /**
    * Accessor for numYears
    * @return
    * Returns # years
    */
   int getNumberOfYears()
   {
      return numYears;
   }
   
   /**
    * Finds a 1D array of ints for year labels from textLines
    * @param textLines
    * String array for lines of text
    * @return
    * Returns the year labels
    */
   
   int[] findYearLabels (String[] textLines)
   {
      int years = 0;
      int startingYear = 0;
      int[] yearLabelsGetter;
      for (int i = 0; i < textLines.length; i++)
      {
         String [] tokens = textLines[i].split(",");
         if (tokens [0].equals("Country Name"))
         {      
            years = tokens.length;
            startingYear = Integer.parseInt(tokens[1]);          
         }                           
      }  
      yearLabelsGetter = new int[years];
      for (int i = 0; i < years - 1; i++)
      {
         yearLabelsGetter[i] = startingYear + i;
      }
      return yearLabelsGetter;
   }
   
   /**
    * Finds and returns a 1D array for country names
    * @param data
    * 2D String array
    * @param numLines1
    * Integer number of lines
    * @return
    * Returns a 1d string array for country names
    */
   
   String [] findCountryNames(String[][] data, int numLines1)
   {
      String [] countriesHolder;
      int numCountries = numLines1 - 3;
      countriesHolder = new String [numCountries];
      for (int i = 0; i < numCountries; i++)
      {
         countriesHolder[i] = data[i + 3][0];
      }
      return countriesHolder;
   }
   
   /**
    * Returns countryNames
    * @return
    * 1D String array country names
    */
   
   String [] getCountryNames()
   {
      return countryNames;
   }
   
   /**
    * Returns yearLabels
    * @return
    * Year labels 1d int array
    */
   
   int [] getYearLabels()
   {
      return yearLabels;
   }
    
   /**
    * accessor for number of lines
    * @return
    * Integer for number of lines
    */
   int getNumLines()
   {
      return numLines;
   }
   
   /**
    * returns a parsed table
    * @return
    * 2D double array for the parsed table
    */
   double [][] getParsedTable()
   {
      double [][] parsingTable;
      int numLinesN = numLines - 3;
      parsingTable = new double [numLines - 3][numYears];
      for (int i = 0; i < numLinesN; i ++)
      {
         for (int j = 0; j < numYears - 1; j++)
         {
            parsingTable[i][j] = Double.parseDouble(cellularDataTable[i + 3][j + 1]);   
         }
      }     
      return parsingTable;
   }
   
   int findNumLines (String fileLocation)
   {
      int count = 0;      
      try {
          File file = new File(fileLocation);

          Scanner input = new Scanner(file);            
          
          while (input.hasNextLine()) {
              input.nextLine();    
              count++;
          }
          input.close();
      } catch (Exception ex) {
          ex.printStackTrace();
      }
      return count;     
   }
   
}