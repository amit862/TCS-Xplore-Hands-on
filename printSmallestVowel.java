/* Question 4 :
Write main method in Solution class.

In the main method, write code to read a String value using Scanner and print the smallest vowel. Assume all input values are in lower case.

E.g If the input value is "matrix" then output will be a (since there are two vowels a and i where a is smaller as per ASCII sequence).
 */

import java.util.Scanner;

public class printSmallestVowel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        char large = 'u';
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                if (ch < large) {
                    large = ch;
                }
            }
        }
        System.out.print(large);
    }
}
