/**
*
*Class purpose:
*Help MSU Denver track their students and their grades in various courses 
*
*@version 2.0
*@author Daniel L'Episcopo
* 
*Class/Computer Info:
*Programming Project #1, CS 2050, Section 2
*jGRASP 2.04.4_0, Macbook Pro 2015 OS X
*
*Vocab Word:
*Adjudicate (verb | uh-JOO-dih-kayt):
*To make an official decision about who is right in (a dispute).
*
*Quote:
*The ultimate measure of a man is not where he stands in moments of 
*comfort and convenience, but where he stands at times of challenge 
*and controversy.
*- Martin Luther King Jr (1929 - 1968)
*
*/

import java.io.IOException; // Access the IOException class

public class Student {

   private String studentId    = "";  // A unique student ID for the student
   private String firstName    = "";  // First name of the student
   private String lastName     = "";  // Last name of the student
   private String emailAddress = "";  // Email address of the student
   
   public boolean result = false;     // Set if any variables aren't equal 
    
  // ***** Begin Constructors Section *****
  
  // ***************************************************************
  
  /** Default constructor -  default values for the objects */
  
  public Student() {
  
      studentId    = "";  // A unique student ID for the student
      firstName    = "";  // First name of the student
      lastName     = "";  // Last name of the student
      emailAddress = "";  // Email address of the student
  
  } // End Default Constructor
  
  // ***************************************************************
   
   /**
   * Test variables if they are empty or if the email doesn't have an "@" 
   * @param student  A student's individual ID
   * @param first    A student's first name
   * @param last     A student's last name
   * @param email    A student's school email
   * @throws IllegalArgumentException  If one or more fields are blank
   * @throws IllegalArgumentException  Check email is null, blank, or missing "@"
   */
   
   public Student(String student, String first, String last, String email) throws IllegalArgumentException {
      
      try {
      
	      if (student.isEmpty() || first.isEmpty() ||
	          last.isEmpty() || email.isEmpty()) {
	    	  
	    	  throw new IllegalArgumentException("One or more fields are blank.");
           
         } // End if
	     
	      } catch(IllegalArgumentException e) {
         
	    	  	System.err.println(e.getMessage());
            
	      } // End catch
	    	
	   try {
         
	      if (email.equals(null) || email.equals("") || !(email.contains("@"))) {
         
	         throw new IllegalArgumentException(
	            "Email address is blank, null, or missing the @ symbol.");
            
            } // End if
            
	        } catch(IllegalArgumentException e) {
         
	    	  System.out.println(e.getMessage());
           
	      } // End catch
      
      this.studentId = student;
      this.firstName = first;
      this.lastName = last;
      this.emailAddress = email;
     
  } // End Student
   
  // ***************************************************************
   
  // ***** End Constructors Section *****
  
  // ***** Begin Getters Section *****
  
  // ***************************************************************
   
   /**
   * This returns the student's student ID 
   * @return  This student's student ID
   */
   
   public String getStudentId() {
   
      return studentId;
   
  } // End getStudentId
   
  // ***************************************************************
   
   /**
   * This returns the student's first name 
   * @return  This student's first name 
   */
   
   public String getFirstName() {
   
      return firstName;
   
  } // End getFirstName
   
  // ***************************************************************
   
   /**
   * This returns the student's last name
   * @return  This student's last name
   */
   
   public String getLastName() {
   
      return lastName;
   
  } // End getLastName
   
  // ***************************************************************
   
   /**
   * This returns the student's email address
   * @return  This student's email address 
   */
   
   public String getEmailAddress() {
   
      return emailAddress;
   
  } // End getEmailAddress
   
  // ***************************************************************
  
  // ***** End Getters Section *****
  
  // ***** Start Equals Section *****
  
  // ***************************************************************
   
   /**
   * Tests all instance variables if they equal to other object
   * @param Student other  The other student that's being compared
   * @return  If all instance variables are equal
   */
   
   public boolean equals(Student other) {
      
      boolean result = false; // Set if any variables aren't equal
      
      if(other == null) {
      
         throw new NullPointerException("Cannot compare with null.");
         
         } // End if
      
      if (studentId.equals(other.studentId) &&
          firstName.equals(other.firstName) &&
          lastName.equals(other.lastName)   &&
          emailAddress.equals(other.emailAddress)) {
      
         result = true;
      } // End if
      
      return result;
  } // End equals 
   
  // ***************************************************************
  
  // ***** End Equals Section *****
  
  // ***** Start toString Section *****
  
  // ***************************************************************
   
   /**
   * Formats objects to print out into a string
   * @return studentId     A student's individual ID
   * @return firstName     A student's first name 
   * @return lastName      A student's last name
   * @return emailAddress  A student's email address
   */
   
   public String toString() {
      
      return "Student ID: "      + studentId + 
             "\nFirst Name: "    + firstName + 
             "\nLast Name: "     + lastName  + 
             "\nEmail Address: " + emailAddress;
   
  } // End toString
   
  // ***************************************************************
   
  // ***** End toString Section *****

} // End Class 