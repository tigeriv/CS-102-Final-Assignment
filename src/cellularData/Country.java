package cellularData;
/**
 * Class Country creates a generic linked list of type subscription years called subscriptions
 * @author tigeriv
 *
 */
public class Country
{
   private String name;
   private LinkedList<SubscriptionYear> subscriptions;
   private int numYears;
   private int subscriptionPosition = 0;
   private int minYear;
   private int maxYear;
   
   public static int MIN_YEARS = 0;
   public static int DEFAULT_YEARS = 54;
   
   /**
    * Constructor for country class, taking a String for country name and an 
    * int for number of years.
    * @param countryName String country name
    * @param numYearsC int number of years
    */
   public Country(String countryName, int numYearsC)
   {
      subscriptions = new LinkedList<SubscriptionYear>();
      name = countryName;
      minYear = 9999;
      maxYear = 0;
      if (setSubscriptions(numYearsC) == false)
      {
         setSubscriptions(DEFAULT_YEARS);
      }
   }
   
   /**
    * Constructor for country class, taking a String for country name
    * @param countryName String country name
    */
   public Country(String countryName)
   {
      subscriptions = new LinkedList<SubscriptionYear>();
      name = countryName;
      minYear = 9999;
      maxYear = 0;
   }
   
   /**
    * getter for name
    * @return name
    */
   public String getName()
   {
      return name;
   }
  
   
   /**
    * setter for subscriptions
    * @param yearIn int year
    * @return true/false
    */
   public boolean setSubscriptions (int yearIn)
   {
      if (yearIn < MIN_YEARS)
      {
         System.out.println("Not a valid number of years.");
         return false;
      }
      else 
      {
         numYears = yearIn;
         return true;
      }      
   }
   
   /**
    * adds a subscription year
    * @param currentYear int current year
    * @param currentSubscriptions double subscriptions
    */
   public void addSubscriptionYear (int currentYear, double currentSubscriptions)
   {
      SubscriptionYear thisYear = new SubscriptionYear (currentYear, currentSubscriptions);  
      subscriptions.add(thisYear);
      if (currentYear > maxYear)
      {
         maxYear = currentYear;
      }
      if (currentYear < minYear && currentYear > 0)
      {
         minYear = currentYear;
      }    
   }
   
   /**
    * returns number of subscriptions in a period. uses iterator
    * @param startYear int starting year
    * @param endYear int ending year
    * @return double total subscriptions
    */
   public double getNumSubscriptionsForPeriod(int startYear, int endYear)
   {
      if (startYear < minYear || endYear > maxYear)
      {
         System.out.println("Invalid year entries.");
      }
      java.util.Iterator<SubscriptionYear> iterator = subscriptions.iterator();
      SubscriptionYear current = null;
      double totalSubscriptions = 0;
      try
      {
         while(iterator.hasNext())
         {
            current = iterator.next();
            int year = current.getYear();
            if (year <= endYear && year >= startYear)
            {
               totalSubscriptions = totalSubscriptions + current.getSubscriptions();
            }
         }
         /*Node<SubscriptionYear> walker = subscriptions.getHead();
         while (walker.getNext() != null)
         {
            SubscriptionYear thisSubscriptions = (SubscriptionYear) walker.getData();
            if (thisSubscriptions.getYear() <= endYear && thisSubscriptions.getYear() >= startYear)
            {
               totalSubscriptions = totalSubscriptions + thisSubscriptions.getSubscriptions();              
            }   
            walker = walker.getNext();
         }*/
      }
      catch (IllegalArgumentException e)
      {
         System.out.println("Invalid year caught!");
      }
      return totalSubscriptions;     
   }
   
 /**
  * Converts to a string using iterator
  */
   public String toString()
   {
      String countryString = "";
      for (SubscriptionYear yearString: subscriptions)
      {
         countryString += yearString.toString() + "     ";
      }
      /*countryString = countryString + name + "\t";
      Node<SubscriptionYear> walker = subscriptions.getHead();
      while (walker.getNext() != null)
      {
         countryString = countryString + walker.getData() + "\t";
         walker = walker.getNext();
      }*/
      return countryString;
   }
   
   public int getMinYear()
   {
      return minYear;
   }
   
   public int getMaxYear()
   {
      return maxYear;
   }
   
   public double getMaxSubscriptions()
   {
      double maxSubscription = 0;
      for (SubscriptionYear yearString: subscriptions)
      {
         double thisSubscription = yearString.getSubscriptions();
         if (thisSubscription > maxSubscription)
         {
            maxSubscription = thisSubscription;
         }
      }
      return maxSubscription;
   }
   
   public LinkedList<SubscriptionYear> getSubscriptions()
   {
      return subscriptions;
   }
}
