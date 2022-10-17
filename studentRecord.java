/*Create a class called Student with the below attributes:

rollNo - int
name - String
branch - String
score – double
dayScholar - boolean

The above attributes should be private, write getters, setters and parameterized constructor as required.

Create class Solution with main method.
Implement two static methods -findCountOfDayscholarStudents  and findStudentwithSecondHighestScore in Solution class.

findCountOfDayscholarStudents:

This method will take an array of Student objects as an input parameter . This method will calculate and return the count of Students whose score is greater than 80 and who are all from dayScholar.

If no Student scored greater than 80 and from dayScholar are present in the array of Student objects, then the method should return 0.

findStudentwithSecondHighestScore:

This method will take an array of Student objects as an input parameter. This method will return the object of the second highest score student from the array of Student objects who are not from the dayScholar.

If no Student is a dayScholar  in the array of Student objects, then the method should return null.

Note : All the searches should be case insensitive.

           The combination of dayScholar and score for each student is always unique.

The above mentioned static methods should be called from the main method.

For findCountOfDayscholarStudents method - The main method should print the returned count as it is if the returned value is greater than 0, else it should print "There are no such dayscholar students".

For findStudentwithSecondHighestScore method - The main method should print the rollNo, name and score in the below format from the returned object if the retuned value is not null.

rollNo#name#score

If the returned value is null, then it should print ”There are no student from non day scholar”

Before calling these static methods in main, use Scanner object to read the values of four Student objects referring attributes in the above mentioned attribute sequence. 
Consider below sample input and output:

Input:

1001
Ashwa
IT
85
true
1002
Preeti
IT
70
false
1003
Uma
ECE
85
false
1004
Akash
EEE
90
true


Output:
2
1002#Preeti#70.0 */

import java.util.Scanner;

public class studentRecord {

  public static void main(String[] args) {
    // code to read values
    Scanner sc = new Scanner(System.in);
    Student[] st = new Student[4];
    for (int i = 0; i < st.length; i++) {
      int rollNo = sc.nextInt();
      sc.nextLine();
      String name = sc.nextLine();
      String branch = sc.nextLine();
      double score = sc.nextDouble();
      sc.nextLine();
      boolean dayScholar = sc.nextBoolean();
      st[i] = new Student(rollNo, name, branch, score, dayScholar);
    }

    // code to call required method

    int ans1 = findCountOfDayscholarStudents(st);// first method call
    Student ans2[] = findStudentWithSecondHighestScore(st);

    // code to display the result
    if (ans1 > 0) {
      System.out.println(ans1);
    } else
      System.out.println("There are no such dayscholar students");

    // Outpur of the second method
    if (ans2[0] != null) {

      System.out.println(ans2[0].getrollNo() + "#" + ans2[0].getname() + "#" + ans2[0].getscore());
    } else {
      System.out.println("There are no student from non day scholar");
    }

  } // main

  // code the first method
  public static int findCountOfDayscholarStudents(Student[] s) {
    int count = 0;
    for (int i = 0; i < s.length; i++) {
      if (s[i].getdayScholar() && s[i].getscore() > 80) {
        count += 1;
      }
    }

    if (count == 0)
      return 0;
    else
      return count;

  }

  // code the second method
  public static Student[] findStudentWithSecondHighestScore(Student[] s) {
    Student[] ans = new Student[1];
    int count = 0;
    for (int i = 0; i < s.length; i++) {
      for (int j = 1; j < s.length; j++) {
        if (s[j - 1].getscore() < s[j].getscore()) {
          Student temp = s[j - 1];
          s[j - 1] = s[j];
          s[j] = temp;
        }
      } // for j
    } // for i
    for (int i = 0; i < s.length; i++) {
      if (!s[i].getdayScholar()) {
        ans[0] = s[i];
        count += 1;
        if (count > 2) {
          break;
        }
      }
    }
    return ans;

  }

}

// code the class
class Student {
  private int rollNo;
  private String name, branch;
  private double score;
  private boolean dayScholar;

  Student(int rollNo, String name, String branch, double score, boolean dayScholar) {
    this.rollNo = rollNo;
    this.name = name;
    this.branch = branch;
    this.score = score;
    this.dayScholar = dayScholar;
  }

  int getrollNo() {
    return rollNo;
  }

  String getname() {
    return name;
  }

  String getbranch() {
    return branch;
  }

  double getscore() {
    return score;
  }

  boolean getdayScholar() {
    return dayScholar;
  }

}
