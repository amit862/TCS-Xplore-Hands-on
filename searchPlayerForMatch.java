/*Question 8 :
Create a Class Player with below attributes:

id - int
country - String
side - String
price - double

Write getters, setters and parameterized constructor as required. 

Create class Solution with main method. 

Implement static method - searchPlayerForMatch in Solution class.

This method will take a String parameter along with the other parameter as array of Player objects. 
The method will return array of Player where the String parameter appears in the side attribute (with case insensitive search).

This method should be called from main method and display the id of returned objects in ascending order. 

Before calling this method(searchPlayerForMatch) in the main method, use Scanner object to read values for four Player objects referring the attributes in the above sequence. 
then, read the value for search parameter. 
Next call the method searchPlayerForMatch, write the logic to sort the id in ascending order (in main method) and display the result. 

Consider below sample input and output:

Input:
1
India
Batting
2500000
2
Australia
Batting
1000000
3
Srilanka
Bowling
1700000
4
England
Bowling
2000000
Batting

Output:
1
2 */

import java.util.*;

public class searchPlayerForMatch {
    public static void main(String[] args) {
        Scanner get = new Scanner(System.in);
        Player[] players = new Player[4];
        int id;
        String country;
        String side;
        double price;
        for (int i = 0; i < 4; i++) {
            id = get.nextInt();
            get.nextLine();
            country = get.nextLine();
            side = get.nextLine();
            price = get.nextDouble();
            players[i] = new Player(id, country, side, price);
        }
        get.nextLine();
        String search = get.nextLine();
        Player[] result = searchPlayerForMatch(search, players);
        Arrays.sort(result);
        for (Player p : result)
            System.out.println(p.getId());

        get.close();
    }

    public static Player[] searchPlayerForMatch(String search, Player[] players) {
        // method logic
        Player[] temp = new Player[0];
        for (Player p : players) {
            if (p.getSide().toLowerCase().equals(search.toLowerCase())) {
                temp = Arrays.copyOf(temp, temp.length + 1);
                temp[temp.length - 1] = p;
            }
        }

        return temp;

    }
}

class Player implements Comparable<Player> {
    private int id;
    String country;
    String side;
    double price;

    public Player(int id, String country, String side, double price) {
        super();
        this.setId(id);
        this.country = country;
        this.side = side;
        this.price = price;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Player p) {

        return this.getId() - p.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
