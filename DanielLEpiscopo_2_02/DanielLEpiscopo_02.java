/**
*
*Class purpose:
*Help MSU Denver track their students and their grades in various courses
*
*@version 2.0
*@author Daniel L'Episcopo  
*
*Class/Computer Info:
*Programming Project #2, CS 2050, Section 2
*jGRASP 2.04.4_0, Macbook Pro 2015 OS X
*
*Vocab Word:
*Proliferate (verb | pruh-LIF-uh-rayt):
*To grow or cause to grow by rapid production of new parts, cells, 
*buds, or offspring.
*
*Quote:
*"I made the best out of what I thought was impossible."
*- Parker Cannon (b. 1992)
*
*/

import java.util.Scanner;  // Access the Scanner class
import java.io.*;          // Access IO and related classes

public class DanielLEpiscopo_02 {
   
   public static Student student1;     // Hard-coded object of student
   public static Student student2;     // Array reference for student 
     
   public static GradeItem gradeItem1; // Hard-coded object of grade item
   public static GradeItem gradeItem2; // Array reference for grade item
   
   public static Scanner inputFile;    // Use the Scanner to read inuput file
   public static File inputDataFile;   // Open the input file to read data
   
   public static void main (String[] args) throws IOException {
       
      final String INPUT_FILE = "Project_02_Input01.txt";
      
      String[] data = new String[8];  // Array to store input file values
      String temp   = "";             // Temporary value to store input file
  
     // *****   Begin Program Execution   *****
     
     // ***************************************************************
     
     /*
     * The first set of tests simply is to instantiate the student1 object
     * and hard coding in values to call the Student class constructor.
     * Afterwards, printing out to the concole using the .toStirng().
     */
       
     // *** Begin Test Set 1 ***
     
      System.out.println("****************** Test Set 1 ******************\n");
       
     // ************* Test 1a *************
     
      System.out.println("Running Test 1a:");
       
         student1 = new Student("900123456","Joe","Doe","joedoe@msudenver.edu");
         System.out.println("Student {\n" + (student1.toString()) + "\n}");
       
     // ************* Test 1b *************
     
      System.out.println("\nRunning Test 1b:");
       
         gradeItem1 = new GradeItem(1,"900123456","23456","HW","20170112",100,95);
         System.out.println("Grade Item {\n" + gradeItem1.toString() + "\n}");
      
     // *** End Test Set 1 ***
      
     // ***************************************************************
     
     /*
     * The second set of tests opens the input file, uses split() to the data
     * into an array, then processes and prints to the console. Throw illegal 
     * exceptions if input file is not found or student or grade item dont exist.
     */
      
     // *** Begin Test Set 2 ***
     
     System.out.println("\n****************** Test Set 2 ******************"); 
     
     // ************* Test 2a / Test 2b *************
      
     try {
     
         inputDataFile = new File(INPUT_FILE);
         inputFile     = new Scanner(inputDataFile);
         
         while(inputFile.hasNextLine()) {
         
               temp = inputFile.nextLine();
               data = temp.split(",");   
            
            if(data[0].equals("STUDENT")) {
            
                processStudentData(data);
               
                // Print out getter methods from the Student class
                System.out.print("\nRunning Test 2a:"    +
                                 "\nStudent Object Data" +
                                 "\nStudent ID: "    + student2.getStudentId() +
                                 "\nFirst Name: "    + student2.getFirstName() +
                                 "\nLast Name: "     + student2.getLastName()  +
                                 "\nEmail Address: " + student2.getEmailAddress());
                                
                  }  // End if
                                  

            else if(data[0].equals("GRADE ITEM")) { 
           
                  processGradeItemData(data);                    
                
                  // Print out getter methods from the GradeItem class                 
                  System.out.print("\n\nRunning Test 2b:" +
                                   "\nGradeItem Data"     +
                                   "\nGrade Item: "   + gradeItem2.getGradeItem() +
                                   "\nStudent ID: "   + gradeItem2.getStudentId() +
                                   "\nCourse ID: "    + gradeItem2.getCourseId()  +
                                   "\nItem Type: "    + gradeItem2.getItemType()  +
                                   "\nDate: "         + gradeItem2.getDate()      + 
                                   "\nMax Score: "    + gradeItem2.getMaxScore()  +
                                   "\nActual Score: " + gradeItem2.getActScore());
                                   
                  } // End else if 
         
            else {
                  throw new IllegalArgumentException(
                        "student or grade item does not exist");
                  
                  } // End else 
      
             } // End while          
            
     // *** End Test Set 2 ***
     
     // ***************************************************************
     
     /*
     * The third set of tests check the equals() methods in the student and
     * GradeItem classes. Create equal instances of both classes and compare
     * to see if they're equal or not equal. Print to the console for either. 
     */
      
     // *** Begin Test Set 3 ***
     
     System.out.println("\n\n****************** Test Set 3 ******************");
      
     // ************* Test 3a *************
     
     if(student1.equals(student2)) {
     
         System.out.println(
            "\nStudent objects are equal: Student IDs are " + 
            student1.getStudentId());
            
         } // End if
     else {
         
         System.out.println(
            "\nStudent objects are unequal: Student IDs are " + 
            student1.getStudentId() + " and " + student2.getStudentId());
           
         } // End else
      
     // ************* Test 3b *************
     
      if (gradeItem1.equals(gradeItem2)) {
         
         System.out.println(
            "GradeItem objects are equal: Student IDs are " + 
            gradeItem1.getStudentId());
            
         } // End if
      else {
         
         System.out.println(
            "GradeItem objects are unequal: Student IDs are " + 
            gradeItem1.getStudentId() + " and " + gradeItem2.getStudentId());
           
         } // End else
     
     // *** End Test Set 3 ***    
     
         } catch(NullPointerException e) {
         
            System.err.println("NullPointerException found.");
            System.out.print(data);
            System.exit(0);
         
         } catch(FileNotFoundException e) {
      
            System.err.println("\nFile " + INPUT_FILE + " not found.");
            System.exit(0);
            
         } // End catch 
         
     // ***************************************************************        
      
     // *****   End Program Execution   *****
      
     // Exit
     inputFile.close();
     System.exit(0);
      
  }  // End Main
   
     // ***** Begin Methods Section *****
       
     // ***************************************************************
     
     /** 
     * Processes Student data array for valid entries from input file
     * 
     * @param data  Array to store input file values
     */
     public static void processStudentData(String[] data) {
   
      try {
      
         if(data[1].equals("ADD"))
         
            student2 = new Student(data[2], data[3], data[4], data[5]);
            
      } catch (IllegalArgumentException e) {
            System.err.println("Student is not added to grade book.");
      
      } // End catch 
     
   } // End processStudentData
    
     // ***************************************************************
     
     /** 
     * Processes GradeItem data array for valid entries from input file
     *
     * @param data  Array to store input file values
     */
     public static void processGradeItemData(String[] data) {
      
      int gradeId  = 0; // 
      int maxScore = 0; // 
      int actScore = 0; // 
      
      try {
   
         if(data[1].equals("ADD"))
         
            gradeItem2 = new GradeItem(
            Integer.parseInt(data[2]), data[3], 
            data[4], data[5], data[6],
            Integer.parseInt(data[7]), 
            Integer.parseInt(data[8]));
         
      } catch(IllegalArgumentException e) {
            System.err.println("Student is not added to grade book.");
   
         } // End catch   
    
   } // End processGradeItemData
    
     // ***************************************************************
     
     // ***** End Methods Section *****
     
}    // End Class