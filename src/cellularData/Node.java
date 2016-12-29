package cellularData;

/**
 * Class Node stores a generic node and the next node
 * @author tigeriv
 *
 */
public class Node <T>
{
   //change to a generic variable called data
 private T data;
 private Node<T> next;
 
 //Constructor w/ one parameter
 /**
  * Constructor w/ one parameter
  * @param cCountry input for country
  */
 public Node(T cCountry)
 {
    this.data = cCountry;
    this.next = null;
 }
 
 /**
  * Constructor w/ two parameters
  * @param cCountry input generic
  * @param cNode input node
  */
 //Constructor w/ two parameters
 public Node(T cCountry, Node<T> cNode)
 {
    this.data = cCountry;
    if (setNext(cNode) == false)
    {        
       System.out.println("Invalid node entry.");
    }
 }
 
 //Getter method for all attributes
 /**
  * Getter for next
  * @return next returns country node
  */
 public Node<T> getNext()
 {
    return next;
 }
 
 /**
  * Getter for country
  * @return returns next country
  */
 public T getData()
 {
    return data;
 }
 
 //Setter method for next
 /**
  * Setter for next
  * @param nextIn next country node 
  * @return return false if invalid entry
  */
 public boolean setNext (Node<T> nextIn)
 {
    if (nextIn == null)
    {
       System.out.println("Not a valid CountryNode.");
       return false;
    }
    else 
    {
       this.next = nextIn;
       return true;
    }      
 }  
 
 /**
  * Getter for country name
  * @return string for country name
  */
 public String getCountryName()
 {
    if (data instanceof Country) 
    {
        Country inputCountry = (Country)data;
        String result = inputCountry.getName();
        return result; 
    }
    else if (data instanceof SubscriptionYear)
    {
       SubscriptionYear sY = (SubscriptionYear)data;
       return sY.toString();
    }
    else return "Not an instance of Country.";
 }
 
 /**
  * Converts country name to a string
  * @return result for country name
  */
 public String toString() 
 {
     String result = this.getCountryName() + "\n" + this.getData().toString() + "\n";
     return result;        
 }
}

