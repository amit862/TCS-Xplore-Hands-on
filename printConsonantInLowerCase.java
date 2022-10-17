/*Question 3 :
Write main method in Solution class.


In the main method, read a String and print all consonants characters (in lower case) in the sequence as they appear in the input value. Please note: The consonants are characters that are not vowels.


Sample input:
DATABase

Output:
dtbs */

import java.util.Scanner;

public class printConsonantInLowerCase {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        str1 = str1.toLowerCase();
        char[] str = str1.toCharArray();
        for (int i = 0; i < str1.length(); i++) {
            if (str[i] == 'a' || str[i] == 'A' || str[i] == 'e' || str[i] == 'E' || str[i] == 'i' || str[i] == 'I'
                    || str[i] == 'o' || str[i] == 'O' || str[i] == 'u' || str[i] == 'U') {
                continue;
            } else {
                System.out.print(str[i] + "");
            }
        }
    }
}
