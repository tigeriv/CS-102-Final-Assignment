package cellularData;


/**
 *  Creates class SubscriptionYear, which stores years and the subscriptions
 *
 * @author Foothill College, [Joey Wilson]
 */
public class SubscriptionYear
{
   private int year;
   private double subscriptions;
   
   public static int MIN_YEAR = 1960;
   public static int MAX_YEAR = 2014;
   public static int DEFAULT_YEAR = 1997;
   public static int MIN_SUBSCRIPTIONS = 0;
   public static int DEFAULT_SUBSCRIPTIONS = 0;
   
   /**
    * Constructor for class Subscription Year, which takes an integer for yearC
    * and a double for subscriptions
    * @param yearC the current year
    * @param subscriptionsC the number of subscriptions
    */
   public SubscriptionYear(int yearC, double subscriptionsC)
   {
      if (setYear(yearC) == false)
      {
         setYear(DEFAULT_YEAR);
      }
      
      if (setSubscriptions(subscriptionsC) == false)
      {
         setSubscriptions(DEFAULT_SUBSCRIPTIONS);
      }
   }
   
   /**
    * Sets the year 
    * @param yearIn The year input
    * @return true if correct value
    */
   
   public boolean setYear (int yearIn)
   {
      if (yearIn < MIN_YEAR || yearIn > MAX_YEAR)
      {
         return false;
      }
      else 
      {
         year = yearIn;
         return true;
      }      
   }
   
   /**
    * Getter for int year
    * @return int year
    */
   public int getYear()
   {
      return year;
   }
   
   /**
    * Sets Subscriptions
    * @param subscriptionsIn double subscriptions
    * @return true or false
    */
   public boolean setSubscriptions (double subscriptionsIn)
   {
      if (subscriptionsIn < MIN_SUBSCRIPTIONS)
      {
         System.out.println("Not a valid # of subscriptions.");
         return false;
      }
      else 
      {
         subscriptions = subscriptionsIn;
         return true;
      }      
   }
   
   /**
    * getter for subscriptions
    * @return double subscriptions
    */
   public double getSubscriptions()
   {
      return subscriptions;
   }
   
   /**
    * Converts subscriptions to a string
    */
   public String toString()
   {
      String subscriptionsString = Double.toString(subscriptions);
      return subscriptionsString;
   }
}
