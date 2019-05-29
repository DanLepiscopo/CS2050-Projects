/**
*
*Class purpose:
*Help MSU Denver track their students and their grades in various courses 
*
*@version 2.0
*
*@author Daniel L'Episcopo
*@author Derek Haviland
*@author Anthony Irwin 
*
*Class/Computer Info:
*Programming Project #2, CS 2050, Section 2
*jGRASP 2.04.4_0, Macbook Pro 2015 OS X
*
*Vocab Word: 
*Camaraderie (Noun | ca-ma-ra-de-rie):
*A spirit of good friendship and loyalty among members of a group.
*
*Quote:
*"Be yourself; everyone else is already taken."
*- Oscar Wilde
*
*/

public class List<T> implements MyCollectionInterface<T> {
   
   private T[] list;                               // Array of items from collection
   private int numOfEntries;                       // Number of entries in our list
   private static final int INITIAL_CAPACITY = 25; // Starting capacity of the list
   
   // ***** Begin Constructors Section *****
   
   // ***************************************************************
   
   /** Default constructor -  Creating object to contain initial capacity */
   public List() {
      
      @SuppressWarnings("unchecked")
      T[] tempList = (T[])new Object[INITIAL_CAPACITY];
      list = tempList;
      
   } // End constructor
   
   // ***************************************************************
   
   // ***** End Constructors Section *****
   
   // ***** Begin Methods Section *****
      
   // ***************************************************************
   
   /**
   * Adds a new entry to this collection
   * 
   * @param newItem  The object to be added to the collection
   * @return True if the addition is successful, or false if not.
   */
   @Override
   public boolean add(T newItem) { 
      
      boolean isSuccessful = true; // Checks value and returns
      
      try {
         
         if(numOfEntries < list.length) {
         
            list[numOfEntries] = newItem;
            numOfEntries++;
         
            } // End if
         else { 
         
            throw new IllegalArgumentException(
            "Cannot add, list is at capacity.");
         
         } // End else   
         
      } catch (Exception e) {
           
         System.err.println(e.getMessage());
         isSuccessful = false;
      
      } // End catch
      
      return isSuccessful;
   } // End add
   
   // ***************************************************************
   
   /**
   * Removes one unspecified entry from the collection, if possible.
   *
   * @return Either the removed entry, if the removal was successful, or null.
   */
   @Override
   public T remove() { 
   
      T result = null; // Changes value to null
	
		if(!(isEmpty() && numOfEntries > 0)) {
      
			result = list[numOfEntries];
			list[numOfEntries] = null;
			numOfEntries--;
         
		} // End if
      
      return result;
   } // End remove
   
   // ***************************************************************
   
   /**
   * Removes one occurrence of a given entry from this collection.
   *
   * @param anEntry The entry to be removed.
   * @return True if the removal was successful, false if not.
   */
   @Override
   public boolean remove(T anEntry) {
    
    boolean remove = false;  // The boolean return value
    int index      = 0;      // The index of the array 
    int position   = 0;      // Position of the array
    
    for(int i = 0; i <= numOfEntries; i++) {
      
      if(list[i].equals(anEntry)) {
         
         position = i;
         list[i].equals(null);
         remove = true;
         break;
      
         } // End if
      } // End for 
    
    while(position <= numOfEntries) {
      
         list[position] = list[position]; 
         position++;
    
      } // End while
      numOfEntries--;
    
      return remove;
   } // End remove
   
   // ***************************************************************
   
   /**
   * Removes all entries from this collection.
   */
   @Override
   public void clear() {
   
      numOfEntries = 0;
   
   } // End clear
   
   // ***************************************************************
   
   /**
   * Gets the current number of entries in this collection.
   *
   * @return The integer number of entries currently in the collection. 
   */
   @Override
   public int getCurrentSize() {
   
      return numOfEntries; 
   
   } // End getCurrentSize
   
   // ***************************************************************
   
   /**
   * Check to see if the collection is empty.
   *
   * @return True if the collection is empty, or false if not.
   */
   @Override
   public boolean isEmpty() {
      
      return (getCurrentSize() == 0);
      
   } // End isEmpty
   
   // ***************************************************************
   
   /**
   * Counts the number of times a given entry appears in this collection.
   *
   * @param anEntry The entry to be counted.
   * @return The number of times anEntry appears in the collection.
   */
   @Override
   public int getFrequencyOf(T anEntry) {
   
      int frequency = 0;  // Count the frequency of values
      
         for(int i = 0; i < numOfEntries; i++) {
         
            if(list[i].equals(anEntry)) {
            
               frequency++;
               
            } // End if 
         } // End for  
   
      return frequency;
   } // End getFrequencyOf

   // ***************************************************************
   
   /**
   * Tests whether this collection contains a given entry.
   *
   * @param anEntry The entry to locate.
   * @return True if the collection contains anEntry, or false if not. 
   */
   @Override
   public boolean contains(T anEntry) {
   
      boolean found = false; // The boolean return value
      int index     = 0;     // The index of the array
      
      while((!found) && (index < numOfEntries)) {
      
         if(list[index].equals(anEntry)) {
         
            found = true;
         
            } // End if
            index++;
         
         } // End while
   
      return found;
   } // End contains
   
   // ***************************************************************
   
   /**
   * Retrieves all entries that are in this collection.
   *
   * @return A newly allocated array of all the entries in the collection. 
   * Note: If the collection is empty, the returned array is empty.
   */
   @SuppressWarnings("unchecked")
   public T[] toArray() {
 
      Object[] outputArray = new Object[getCurrentSize()];

      for(int i = 0; i < numOfEntries; i++) {
         
         outputArray[i] = (Object) list[i];
            
         } // End for
        
      return (T[]) outputArray;
   } // End toArray
   
   // ***************************************************************
   
   // ***** End Methods Section *****

} // End List