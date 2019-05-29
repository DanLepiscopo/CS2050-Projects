/**
*
*Class purpose:
*Help MSU Denver track their students and their grades in various courses 
*
*@version 1.0
*
*@author Daniel L'Episcopo
*@author Sinh Mai
*
*Class/Computer Info:
*Programming Project #2, CS 2050, Section 2
*jGRASP 2.04.4_0, Macbook Pro 2015 OS X
*
*Vocab Word: 
*Hamartia (Noun | hah-mahr-TEE-uh)
*A flaw in character that brings about the downfall of the hero 
*of a tragedy: tragic flaw.
*
*Quote:
*"I have learned over the years that when one's mind if made up, this diminishes
*fear; knowning what must be done does away with fear."
*- Rosa Parks (1913 - 2005)
*
*/

public class LList<T> implements MyCollectionInterfaceProject04<T> {
   
   private Node headNode;    // First node in the list 
   private Node tailNode;    // Last node in the list
   private Node currentNode; // Current node in the list
   
   private T[] list;         // Array of items from the collection
   private int numOfEntries; // Number of entries in the list 
   
   // ***** Begin Constructors Section *****
   
   // ***************************************************************
   
   /** Default constructor - Creating object to contain initial capacity */
   public LList() {
      
      clear();
      
   } // End default constructor
   
   // ***************************************************************
   
   // ***** End Constructor Section *****
   
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
   
      Node newNode = new Node(newItem); // Adding a new node to the list
      
      if (isEmpty()) {
      
         headNode = newNode;
      
       } // End if
       
      else {
      
         Node tailNode = getNodeAt(numOfEntries);
         tailNode.setNextNode(newNode);
         numOfEntries++;
         return true;
       
       } // end else
     
      numOfEntries++;
 
      return false;
   } // End add
   
   // ***************************************************************
   
   /**
   * Finds the specific location of a node and gives the position
   *
   *@param givenPosition The postion where the node is located at
   *@return currentNode The current location where the node at
   */
   private Node getNodeAt(int givenPostion) {
      
      Node currentNode = headNode;  // Find the current node in the list
      
      for (int count = 1; count < givenPostion; count++) {
      
         currentNode = currentNode.getNextNode();
      
      } // End for
      
      return currentNode;
   } // End getNodeAt
   
   // ***************************************************************
   
   /**
   * Adds a new entry to this collection at the given position
   * 
   * @param newItem The object to be added to the collection
   * @param position The location where newItem will be inserted.
   * @return True if the addition is successful, or false if not.
   */
   @Override
   public boolean add(T newItem, int position) {
    
      boolean isSuccessful = true;  // Returns true if successful
      
      if((position >= 1) && (position <= numOfEntries + 1))  {
         
         Node newNode = new Node(newItem);
         
         if(isEmpty()) {
         
            headNode = newNode;
            tailNode = newNode;
         
         } // End if
         
         else if (position == 1) {
         
            newNode.setNextNode(headNode);
            headNode = newNode;
         
         } // End else if
         
         else if (position == numOfEntries + 1) {
            
            tailNode.setNextNode(newNode);
            tailNode = newNode;
         
         } //End else if
         
         else {
            
            Node nodeBefore = getNodeAt(position - 1);
            Node nodeAfter = nodeBefore.getNextNode();
            newNode.setNextNode(nodeAfter);
            nodeBefore.setNextNode(newNode);
            
         } // End else
         
         numOfEntries++; 
      
      } // End if
      
      else {
      
         throw new IllegalArgumentException(
            "Error occoured at given postion during the add operation.");
      
      } // End else
       
      return isSuccessful;
   } // End add
   
   // ***************************************************************
   
   /**
   * Removes one occurrence of a given entry from this collection.
   *
   * @param anEntry The entry to be removed.
   * @return True if the removal was successful, false if not.
   */
   @Override
   public boolean remove(T anEntry) {
   
      boolean isSucessful = false; // Returns the return value
      
      try {
      
         for(int index = 1; index <= numOfEntries; index++) {
      
          if(list[index].equals(anEntry)) {
         
               list[index] = null;
               
               Node nodeBefore = getNodeAt(index - 1);
               Node nodeToBefore = nodeBefore.getNextNode();
               Node nodeAfter = nodeToBefore.getNextNode();
               nodeBefore.setNextNode(nodeAfter);
               
               Node nodeToRemove = null;
               isSucessful = true;
               numOfEntries--;
         
            } // End if
      
         } // End for
          
       } catch(NullPointerException e) {
         
            System.out.println(e.getMessage());
       
         } // End catch
    
     return isSucessful;
   } // End remove
   
   // ***************************************************************
   
   /**
   * Removes all entries from this collection.
   */
   @Override
   public void clear() {
   
      headNode = null;
      tailNode = null;
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
      
      return (numOfEntries == 0);
          
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
      
      int counter = 0; // Counts the number of occurrences
      
      for(int index = 0; index < numOfEntries; index++) {
      
         if(anEntry.equals(index)) {
         
            counter++;
         
         } // End if
      
       } // End for
      
      return counter;
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
   
      boolean found = false;       // Returns the return value
      Node currentNode = headNode; // Find the current node in the list
      
      while(!found && (currentNode != null)) {
         
         if(anEntry.equals(currentNode.getData())) {
         
            found = true;
         
         } // End if
         
         else {
         
            currentNode = currentNode.getNextNode();
         
         } // End else
      
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
      
      int index = 0;                // Traverses the number of entries in the list
      Node currentNode = headNode;  // Find the current node in the list
      
      T[] result = (T[])new Object[numOfEntries];
      
      while((index < numOfEntries) && (currentNode != null)) {
      
         result[index] = (T)currentNode.getData();
         currentNode = currentNode.getNextNode();
         index++;
      
      } // End while
       
      return result;
   } // End toArray
   
   // ***************************************************************
   
   // ***** End Methods Section *****
   
   // ***** Start Node Class *****
   
   // ***************************************************************
   
   /**
   * @author Frank M. Carrano, Timothy M. Henry
   * @version 5.0
   * package BagPackage
   */
   
   public class Node {
      
      private T    data;
      private Node next;
      
   // *************************************************************** 
      
      // The constructor's name is Node, not Node<T>
      public Node(T dataPortion) {
      
         this(dataPortion, null);
   
         } // End constructor
         
   // ***************************************************************     
        
      public Node(T dataPortion, Node nextNode) {
         
         data = dataPortion;
         next = nextNode;
      
         } // End constructor
         
   // ***************************************************************       
      
      public T getData() {
         
         return data;
      
         } // End getData  
         
   // ***************************************************************      
      
      public void setData(T newData) {
      
         data = newData;
      
         } // End setData
         
   // ***************************************************************      
      
      public Node getNextNode() {
         
         return next;
      
         } // End getNextNode
         
   // *************************************************************** 
      
      public void setNextNode(Node nextNode) {
      
         next = nextNode;
      
         } // End setNextNode
         
   // *************************************************************** 
      
      } // End Node Class
      
   // ***************************************************************    
      
   // ***** End Node Class **** 

} // End LList