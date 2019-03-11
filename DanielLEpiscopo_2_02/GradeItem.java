/**
*
*@version 2.0
*@author Daniel L'Episcopo
*
*Class purpose:
*Help MSU Denver track their students and their grades in various courses  
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

public class GradeItem {
   
   private int gradeId;       // A unique value for the grade item
   private int maxScore;      // The max score a student can recieve
   private int actScore;      // Current score of a student's work 
   
   private String studentId;  // A unique student ID for the student 
   private String courseId;   // A unique course ID for the class 
   private String itemType;   // Different types of class work 
   private String date;       // Dates formatted to yyyy/mm/dd
   
   public boolean result;     // Set if any variables aren't equal
   
   // Contains the types of class work
   private String[] itemTypes = {"HW","Quiz","Class Work","Test", "Final"};
   
  // ***** Begin Constructors Section *****
  
  // ***************************************************************
  
  /** Default constructor -  default values for the objects */
  
  public GradeItem() {
  
      gradeId   = 0;
      studentId = "";
      courseId  = "";
      itemType  = "";
      date      = "";
      maxScore  = 0;
      actScore  = 0; 
  
  } // End Student
   
  // ***************************************************************
   
   /**
   * Testing instance variables if they are within specifications 
   * @param grade    A unique value for the grade item
   * @param student  A student's individual ID
   * @param course   A student's course ID
   * @param item     A student's item type
   * @param date     A student's date
   * @param mScore   The max score a student could recieve
   * @param aScore   The student's actual score 
   * @throws IllegalArgumentException  One or more fields are blank
   * @throws IllegalArgumentException  Maximum score is NOT greater than 0
   * @throws IllegalArgumentException  Actual score is NOT < 0 or < max score
   */
   
   public GradeItem(int grade, String student, String course, String item, 
                    String date, int mScore, int aScore) throws IllegalArgumentException {
      
      try {
      
	      if (!(grade > 0) || student.isEmpty() || course.isEmpty() || 
	          item.isEmpty() || date.isEmpty());
             
	          throw new IllegalArgumentException("One or more GI fields are blank.");
             
		  } catch(IllegalArgumentException e) {
        
			  System.out.println(e.getMessage());
           
		  } // End catch
		  
		try {
      
	      if (!(mScore > 0));
         
	         throw new IllegalArgumentException(mScore + " is not greater than 0.");
            
		  } catch(IllegalArgumentException e) {
        
			  System.out.println(e.getMessage());
           
		  } // End catch
		  
		try {	
        	  
	      if (!(aScore > 0) && !(aScore < mScore));
         
	         throw new IllegalArgumentException(
	         aScore + " is not greater than 0 or it isn't greater than max score.");
            
		  } catch(IllegalArgumentException e) {
        
			  System.out.println(e.getMessage());
           
		  } // End catch
      
      this.gradeId = grade;  
      this.studentId = student;
      this.courseId = course;
      this.itemType = item;
      this.date = date;
      this.maxScore = mScore;
      this.actScore = aScore;
      
   } // GradeItem
   
  // ***************************************************************
   
  // ***** End Constructors Section *****
   
  // ***** Begin Getters Section *****
  
  // ***************************************************************
  
  /**
   * This returns the student's grade item 
   * @return  This student's grade item
   */
   
   public int getGradeItem() {
   
      return gradeId;
      
   } // End getGradeItem
   
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
   * This returns the student's course ID 
   * @return  This student's course ID
   */
   
   public String getCourseId() {
   
      return courseId;
      
   } // End getCourseId     
   
  // ***************************************************************
   
   /**
   * This returns the student's item type
   * @return  This student's item type
   */
   
   public String getItemType() {
   
      return itemType;
      
   } // End getItemType      
   
  // ***************************************************************
   
   /**
   * This returns the student's date 
   * @return  This student's date
   */
   
   public String getDate() {
   
      return date;
      
   } // End getDate      
   
  // ***************************************************************
  
  /**
   * This returns the max score of the item 
   * @return  This max score of the item
   */
   
   public int getMaxScore() {
   
      return maxScore;
      
   } // End getMaxScore
   
  // ***************************************************************
  
  /**
   * This returns the actual score of student 
   * @return  This student's actual score
   */
   
   public int getActScore() {
   
      return actScore;
      
   } // End getActScore
   
  // ***************************************************************
   
  // ***** End Getters Section *****
   
  // ***** Start Equals Section *****
   
  // ***************************************************************
   
   /**
   * Tests all instance variables if they equal to other object
   * @param GradeItem other  The other student that's being comapred
   * @return  If all instance variables are equal
   */
   public boolean equals(GradeItem other) {
   
      boolean result = false; // Set if any variables aren't equal
   
      if(other == null)
         throw new NullPointerException("Cannot compare with null.");
   
      if(gradeId == (other.gradeId) 
      && studentId.equals(other.studentId) 
      && courseId.equals(other.courseId) 
      && itemType.equals(other.itemType) 
      && date.equals(other.date)) {
      
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
   * @return gradeId    A unique value for the grade item
   * @reutrn studentId  A student's individual ID
   * @return courseId   A student's course ID
   * @return itemType   A student's item type
   * @return date       A student's date
   * @return maxScore   The max score a student could recieve
   * @return actScore   The student's actual score 
   */
   
   public String toString() {
      
      String display = "Grade Item: "     + gradeId   +
                       "\nStudent ID: "   + studentId + 
                       "\nCourse ID: "    + courseId  + 
                       "\nItem Type: "    + itemType  +  
                       "\nDate: "         + date      +
                       "\nMax Score: "    + maxScore  +
                       "\nActual Score: " + actScore;
                       
      return display;                
   
   } // End toString
   
  // ***************************************************************
   
  // ***** End toString Section *****

} // End Class