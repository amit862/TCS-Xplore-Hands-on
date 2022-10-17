
/* Question 7 :
Create a Class Player with below attributes:

playerId - int
playerName - String
iccRank - int
noOfMatchesPlayed - int
totalRunsScored - int

Write getters, setters and parameterized constructor as required. 

Create class Solution with main method. 

Implement static method - findAverageScoreOfPlayers in Solution class.

This method will take an int parameter named target along with the other parameter as array of

Player objects. 
The method will calculate the average runrate of the player based on totalRunsScored and

noOfMatchesPlayed and return the same in a double array where the noOfMatchesPlayed attribute

is greater than or equal to the int parameter target passed.

This method should be called from the main method and display the Grade of the players.

If the averageRunRate is greater than or equal to 80 then it should print "Grade A Player". If

the averageRunRate is between 50 to 79 then it should print "Grade B Player", else it should

print "Grade C Player" .

Before calling this method(findAverageScoreOfPlayers) in the main method, use Scanner object to

read values for four Player objects referring the attributes in the above sequence. 
then, read the value for noOfMatchesPlayed parameter. 
Next call the method findAverageScoreOfPlayers, write the logic to display the Grade(in the main method) and display the result. 

Consider below sample input and output:

Input:
100
Sachin
1
102
13000
101
Shewag
2
110
10000
102
Dhoni
3
80
7500
104
Kholi
4
70
7000
100

Output:
Grade A Player
Grade A Player



--------------------------------------------------
Sample code snippet for reference:
Please use below code to build your solution.
--------------------------------------------------

public class Solution
{

public static void main(String[] args)
{
//code to read values
//code to call required method
//code to calculate Grade and display the results
}

public static double[] findAverageScoreOfPlayers(Player[] player,int totalMatches)
{
//method logic

}
}

class Player
{
//code to build player class
}

-------------------------------------------------

Note on using Scanner object:
Sometimes scanner does not read the new line character while invoking methods like nextInt(),

nextDouble() etc. 
Usually, this is not an issue, but this may be visible while calling nextLine() immediately after those methods.

Consider below input values:
22
hello

Referring below code:

Scanner sc = new Scanner(System.in);
int x = sc.nextInt();
String str = sc.nextLine(); -> here we expect str to have value hello. Instead it may be "".

If above issue is observed, then it is suggested to add one more explicit call to nextLine()
after reading numeric value.




 

              
public class Solution
{

 public static void main(String[] args)
 {
  //code to read values 
  //code to call required method
  //code to calculate Grade and display the results
 }

 public static double[] findAverageScoreOfPlayers(Player[] player,int totalMatches)
 {
  //method logic
  
 }
}

class Player
{
  //code to build player class
} */
import java.util.*;

public class playerGrading {
    public static void main(String[] args) {
        int id;
        String name;
        int iccrank;
        int noOfMatches;
        int totalRunsScored;

        Players[] player = new Players[4];

        Scanner get = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            id = get.nextInt();
            name = get.next();
            iccrank = get.nextInt();
            noOfMatches = get.nextInt();
            totalRunsScored = get.nextInt();

            player[i] = new Players(id, name, iccrank, noOfMatches, totalRunsScored);
        }
        int target = get.nextInt();
        double[] answer = findAverageScoreOfPlayers(player, target);

        for (double i : answer) {
            if (i >= 80) {
                System.out.println("Grade A Player");
            } else if (i >= 50 && i <= 79) {
                System.out.println("Grade B Player");
            } else if (i > 0 && i <= 49) {
                System.out.println("Grade C Player");
            }
        }

        get.close();
    }

    public static double[] findAverageScoreOfPlayers(Players[] player, int totalMatches) {
        // method logic

        double[] temp = new double[0];

        for (int i = 0; i < 4; i++) {
            if (player[i].noOfMatches >= totalMatches) {
                double avg = player[i].totalRunsScored / player[i].noOfMatches;
                temp = Arrays.copyOf(temp, temp.length + 1);
                temp[temp.length - 1] = avg;
            }
        }

        return temp;
    }

}

class Players {
    int id;
    String name;
    int iccrank;
    int noOfMatches;
    int totalRunsScored;

    public Players(int id, String name, int iccrank, int noOfMatches, int totalRunsScored) {
        super();
        this.id = id;
        this.name = name;
        this.iccrank = iccrank;
        this.noOfMatches = noOfMatches;
        this.totalRunsScored = totalRunsScored;
    }

    public Players(int id2, String country, String side, double price) {
    }

}