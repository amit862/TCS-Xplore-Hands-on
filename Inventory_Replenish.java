/*Create a Class Inventory with below attributes:

inventoryId - String
maximumQuantity - int
currentQuantity - int
threshold - int

Write getters, setters and parameterized constructor as required. 

Create class Solution with main method. 

Implement static method - replenish in Solution class.

This method will take an int parameter named limit along with the other parameter as array of Inventory objects. 
The method will return array of Inventory where the threshold attribute is less than or equal to the int parameter passed.

This method should be called from main method and display the id of returned objects along with Filling status.

if the threshold is greater than or equal to 75 then it should print "Critical Filling" as Filling Status. If the threshold is between 74 to 50 then Filling status should be "Moderate Filling", else should be "Non-Critical Filling" .

Before calling this method(replenish) in the main method, use Scanner object to read values for four Inventory objects referring the attributes in the above sequence. 
then, read the value for limit parameter. 
Next call the method replenish and display the result. 

Consider below sample input and output:

Input:
1
100
50
40
2
100
50
50
3
100
40
45
4
100
80
25
45

Output:
1 Non-Critical Filling
3 Non-Critical Filling
4 Non-Critical Filling */

import java.util.Arrays;
import java.util.Scanner;

public class Inventory_Replenish {
    public static void main(String[] args) {
        Inventory[] inventories = new Inventory[4];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < inventories.length; i++) {
            String inventoryId = sc.nextLine();
            int maximumQuantity = sc.nextInt();
            sc.nextLine();
            int currentQuantity = sc.nextInt();
            sc.nextLine();
            int threshold = sc.nextInt();
            sc.nextLine();
            inventories[i] = new Inventory(inventoryId, maximumQuantity, currentQuantity, threshold);
        }
        int limit = sc.nextInt();
        sc.close();
        Inventory[] result = replenish(inventories, limit);
        for (int i = 0; i < result.length; i++) {
            if (result[i].getThreshold() >= 75)
                System.out.println(result[i].getInventoryId() + " Critical Filling");
            else if (result[i].getThreshold() >= 50 && result[i].getThreshold() <= 74)
                System.out.println(result[i].getInventoryId() + " Moderate Filling");
            else
                System.out.println(result[i].getInventoryId() + " Non-Critical Filling");
        }
    }

    public static Inventory[] replenish(Inventory[] inventories, int limit) {
        Inventory[] refined = new Inventory[0];
        for (int i = 0; i < inventories.length; i++) {
            if (inventories[i].getThreshold() <= limit) {
                refined = Arrays.copyOf(refined, refined.length + 1);
                refined[refined.length - 1] = inventories[i];
            }
        }
        return refined;
    }
}

class Inventory {
    String inventoryId;
    int maximumQuantity;
    int currentQuantity;
    int threshold;

    public Inventory(String inventoryId, int maximumQuantity, int currentQuantity, int threshold) {
        this.inventoryId = inventoryId;
        this.maximumQuantity = maximumQuantity;
        this.currentQuantity = currentQuantity;
        this.threshold = threshold;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public int getThreshold() {
        return threshold;
    }
}
