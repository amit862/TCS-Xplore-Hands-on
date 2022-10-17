/*Create a class Bill with below attributes:

billNo- int
name - String
typeOfConnection - String
billAmount - double
status – boolean

where billNo is the bill number, name is the name of the customer, typeOfConnection is the type of the connection (prepaid, postpaid), billAmount is the bill amount and status is whether the bill is paid or not (if paid then value is TRUE else value is FALSE). 

The above attributes should be private, write getters, setters and parameterized constructor as required. 

Create class Solution with main method.
Implement two static methods - findBillWithMaxBillAmountBasedOnStatus and getCountWithTypeOfConnection in Solution class.
findBillWithMaxBillAmountBasedOnStatus method:

This method will take an array of Bill objects and a boolean parameter as parameters. 

The method will return bill object array in ascending order of their bill number from the array of Bill objects whose bill Amount is maximum in the array with the status attribute that matches with the input parameter.

If no Bill with the given status is present in the array of Bill objects, then the method should return null.

getCountWithTypeOfConnection method:
This method will take two input parameters - array of Bill objects and string parameter ( for type of connection).
The method will return the count of bills from array of bill objects for the given type of connection.
If no bill with the given type of connection is present in the array of bill objects, then the method should return 0.


Note :

Two bill object can have the same bill amount.
All the searches should be case insensitive. 

The above mentioned static methods should be called from the main method.

For findBillWithMaxBillAmountBasedOnStatus method - The main method should print the billNo followed by # and name from the returned Bill object array if the returned value is not null.

If the returned value is null then it should print "There are no bill with the given status".


For getCountWithTypeOfConnection method - The main method should print the count of bills as it is, if the returned value is greater than 0,  otherwise it should print "There are no bills with given type of connection".


Before calling these static methods in main, use Scanner to read the number of object and objects to read the values of Bill objects referring attributes in the above mentioned attribute sequence. 

Next, read the value for status and typeOfConnection.


Consider below sample input and output:
Input:

4
111
Aman Mittal
Prepaid
914.25
true
222
Rekha Kumar
Prepaid
1425.75
false
333
Samyra Gupta
Prepaid
1305.00
true
444
Mohit Saxena
Postpaid
1300.50
false
false
Prepaid

Output:

222#Rekha Kumar
3
 */

/* 
import java.util.Scanner;
public class billsDetails
{

 public static void main(String[] args)
 {
  // code to read values 
   
   Scanner sc = new Scanner(System.in);
   int nu = sc.nextInt();
   Bill[] bl = new Bill[nu];
   for(int i=0;i<bl.length;i++){
     int billNo = sc.nextInt();
     sc.nextLine();
     String name = sc.nextLine();
     String type = sc.nextLine();
     double amount = sc.nextDouble();
     boolean status = sc.nextBoolean();
     
     bl[i] = new Bill(billNo,name,type,amount,status);
   }
   
   boolean status = sc.nextBoolean();
   sc.nextLine();
   String type = sc.nextLine();
   
  // code to call required method
   
   Bill ans1 = findBillWithMaxBillAmountBasedOnStatus(bl,status);
   int ans2 = getCountWithTypeOfConnection(bl,type);
   
  // code to display the result
   //Displaying the output of the fist method
   if(ans1!=null){
    System.out.println(ans1.getbillNo()+"#"+ans1.getname());
   }
   else{
   System.out.println("There are no bill with the given status");
   }
   // Displaying the output of the second method
   if(ans2>0)
  System.out.println(ans2);
else
  System.out.println("There are no bills with given type of connection");
   
 }


    
 //code the first method

public static Bill findBillWithMaxBillAmountBasedOnStatus(Bill[] b,boolean status){
  
  // sorting the Bill objects in descending order of their respective Bill Amount
  for(int i=0;i<b.length;i++){
    for(int j=1;j<b.length;j++){
      if(b[j-1].getbillAmount()<b[j].getbillAmount()){
        Bill temp = b[j-1];
        b[j-1] = b[j];
        b[j] = temp;       
      }
    }
  }
  Bill ans = null;
  for(int i=0;i<b.length;i++){
    if(b[i].getstatus()==status){
      ans = b[i];
      break;
    }
  }
  return ans;
}
    
 //code the second method   

  public static int getCountWithTypeOfConnection(Bill[] b,String billtype){
  int count = 0;
  for(int i=0;i<b.length;i++){
   if(billtype.equalsIgnoreCase(b[i].gettypeOfConnection())){
     count+=1; 
   }
 }
  //System.out.println(count);
  return count;
 }
}// main

//code the class

class Bill{
 private int billNo;
  private String name,typeOfConnection;
  private double billAmount;
  private boolean status;
  
  Bill(int billNo,String name,String typeOfConnection,double billAmount,boolean status){
    this.billNo = billNo;
    this.name = name;
    this.typeOfConnection = typeOfConnection;
    this.billAmount = billAmount;
    this.status = status;
  }
  
  int getbillNo(){
  return billNo;
  }
  
  String getname(){
  return name;
  }
  
  String gettypeOfConnection(){
  return typeOfConnection;
  }
  
  double getbillAmount(){
  return billAmount;
  }
  
  boolean getstatus(){
  return status;
  }
}
*/

import java.util.*;

public class billsDetails {
    public static void main(String[] args) {
        // code to read values
        Scanner get = new Scanner(System.in);
        int billNo;
        String name;
        String typeOfconnection;
        double billAmount;
        boolean status;
        int n = get.nextInt();
        Bill[] bills = new Bill[n];
        for (int i = 0; i < n; i++) {
            billNo = get.nextInt();
            get.nextLine();
            name = get.nextLine();
            typeOfconnection = get.nextLine();
            billAmount = get.nextDouble();
            status = get.nextBoolean();
            bills[i] = new Bill(billNo, name, typeOfconnection, billAmount, status);
        }
        boolean findbool = get.nextBoolean();
        get.nextLine();
        String search = get.nextLine();

        Bill[] ans = findBillWithMaxBillAmountBasedOnStatus(findbool, bills);
        int ans1 = getCountWithTypeOfConnection(search, bills);

        if (ans != null)

        {
            for (int i = 0; i < ans.length; i++) {
                if (i == ans.length - 1) {
                    System.out.println(ans[i].getBillNo() + "#" + ans[i].getName());
                }
            }
        }

        else
            System.out.println("There are no bill with the given status");

        if (ans1 == 0)
            System.out.println("There are no bills with given type of connection");

        else
            System.out.println(ans1);

        get.close();

    }

    public static Bill[] findBillWithMaxBillAmountBasedOnStatus(boolean findbool, Bill[] bills) {
        // method logic
        Bill[] result = new Bill[0];

        for (Bill b : bills) {
            if (b.isStatus() == findbool) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = b;
            }

        }
        Arrays.sort(result);
        if (result.length == 0)
            return null;
        else
            return result;

    }

    public static int getCountWithTypeOfConnection(String search, Bill[] bills) {
        // method logic
        int count = 0;
        for (Bill b : bills) {
            if (b.getTypeOfconnection().toLowerCase().equals(search.toLowerCase())) {
                count++;
            }
        }
        return count;
    }
}

class Bill implements Comparable<Bill> {
    private int billNo;
    private String name;
    private String typeOfconnection;
    private double billAmount;
    private boolean status;

    public int getBillNo() {
        return billNo;
    }

    public void setBillNo(int billNo) {
        this.billNo = billNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOfconnection() {
        return typeOfconnection;
    }

    public void setTypeOfconnection(String typeOfconnection) {
        this.typeOfconnection = typeOfconnection;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Bill() {
    }

    public Bill(int billNo, String name, String typeOfconnection, double billAmount, boolean status) {
        this.billNo = billNo;
        this.name = name;
        this.typeOfconnection = typeOfconnection;
        this.billAmount = billAmount;
        this.status = status;

    }

    @Override
    public int compareTo(Bill o) {
        return (int) this.billAmount - (int) o.billAmount;
    }
}
