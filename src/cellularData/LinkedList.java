package cellularData;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * Stores a linked list of generic nodes, as many as the user wants
 * @author tigeriv
 *
 */
public class LinkedList<T> implements Iterable<T>
{
 //Keeps track of front of the list
 private Node<T> head;
 
 // keeps track of the number of nodes in the list
 private int size;
 
 //Create an empty CountryList

 /**
  * Creates an empty linked list
  */
 public LinkedList()
 {
    this.size = 0;
    this.head = null;
 }
 
 //Checks if the list is empty
 /**
  * Checks the head
  * @return returns whether the head is null
  */
 public boolean isEmpty()
 {
     if (this.head == null)  
     {
        return true;
     }
     else 
     {
        return false;
     }
 }
 
 /**
  * Takes a generic object and adds it to the end of the list
  * @param inputCountry used to create a new node
  */
 public void add(T inputCountry)
 {
    Node<T> current = new Node<T>(inputCountry);
    //If list is empty, start the list
    if (this.isEmpty())
    {
        head = current;
        this.size++;
    }
    else 
    //If list isn't empty, find the end and add to the end
    {
       Node<T> walker = head;
       while (walker.getNext() != null)
       {
          walker = walker.getNext();
          if (walker.getNext() == null)
          {
             continue;
          }
       }
       walker.setNext(current);
       this.size++;
    }
 } 
 
 //Takes a Country object as a parameter 
 //Checks if name of country can be found in the list
 //Assume Country equal if names equal
/**
 * Takes a generic object as a parameter
  * Checks if name of object can be found in the list
  * Assume object equal if names equal
 * @param inputObject an input object to be matched
 * @return a country that matches the input
 */
 public Country contains(T inputObject)
 {
    if (inputObject instanceof Country) 
    {
        Country inputCountry = (Country)inputObject;
        Node<T> walker = head;
        while (walker != null)
        {
           if (inputCountry.getName().equals(walker.getCountryName()))
           {
              return (Country) walker.getData();
           }
           try 
           {
              walker = walker.getNext();
           }
           catch (NullPointerException e)
           {
              break;
           }
        }
    }   
    System.out.println("Country not found.");
    return null;
 }
 
 
 //Returns a string of info about every country in list
 //Traverse all nodes and print each one
 /**
  * Returns a string of info about every country in list
  * Traverse all nodes and print each one
  */
 public String toString()
 {
    String output = "";
    Node<T> walker = head;
    while (walker != null)
    {
       output = output + walker.toString();
       walker = walker.getNext();
    }
    return output;
 }
 
 /**
  * 
  * @return returns the size of the list
  */
 public int size()
 {
    return size;
 }
 
 /**
  * Returns the country at a specified index
  * @param index int for the index value
  * @return returns the country if it is found
  */
 public Country getIndex(int index)
 {
    Node<T> walker = head;
    int i = 0;
    try
    {
       while(walker != null && i <= index)
       {
           // reached requested interest  
           // so return the node we're at 
           if (i == index)
           {
              return (Country) walker.getData();
           }          
           // move to the next node
           else
           {
              walker = walker.getNext();
           }        
           // increment the position
           i++;
       }
    }
    catch (IndexOutOfBoundsException e)
    {
       System.out.println("Invalid index.");
    }
    System.out.println("Index was too high. First returned instead.");
    return (Country) head.getData();
 }
 
 /**
  * Getter function
  * @return returns the head country
  */
 public Node<T> getHead()
 {
    return head;
 }
 //EXTRA CREDIT insertatIndex()
 /**
  * Inserts a specified country at a specified index
  * @param iC input country
  * @param index input index
  */
 public void insertAtIndex(T iC, int index)
 {
    Node<T> current = new Node<T>(iC);
    Node<T> walker = head;
    Node<T> previous = null;
    boolean reachedEnd = false;
    if (index == 0)
    {
       current.setNext(head);
       head = current;
       size++;
    }
    else 
    {
       try
       {
          for (int i = 0; i < index - 1; i++)
          {
              if (walker.getNext() == null)
              {
                 walker.setNext(current);
                 reachedEnd = true;
                 size++;
                 break;
              }          
              // move to the next node
              else
              {
                 previous = walker;
                 walker = walker.getNext();
              }        
              // increment the position
          }
          if (reachedEnd == false)
          {
             previous.setNext(current);
             current.setNext(walker);
             size++;
          }
       }
       catch (NullPointerException e)
       {
          System.out.println("Invalid index.");
       }
    }    
 }
 
 /**
  * Implements iterator
  * @author tigeriv
  *Used to traverse linked list
  */
 private class MyListIterator implements Iterator<T> 
 {
     private Node<T> current;

     // initialize this iterator
     public MyListIterator() 
     {    current = head; }

     // test if more elements can be traversed 
     /**
      * Returns true if next, false if no next node
      */
     public boolean hasNext() 
     {
         // check if the next node is valid
         // if node is invalid, return false
         if (current == null)
             return false;

         // otherwise we haven't reached the end of the list
         return true;
     }

     // return the next available element
     /**
      * Returns next element
      */
     public T next() 
     {    
         if (current == null)
         {
             throw new java.util.NoSuchElementException();
         }

         // if we're here, then we're looking at a valid current node
         // so grab the data portion, to give to the caller
         T data = (T) current.getData();

         // move in preparation for the next time.
         current = current.getNext();

         return data;  
     }
 }
 /**
  * Returns an iterator object
  */
 public Iterator<T> iterator() 
 {
     return new MyListIterator();
 }
}

