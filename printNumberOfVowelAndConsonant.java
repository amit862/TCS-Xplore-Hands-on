/* 03- Write main method in Solution class.

In the main method, read a String (which may have alphabets along with numeric digits) and print the number of vowel and consonants (any alphabet apart from vowel is a consonant) present in the given String.
Note: The output should be printed in the same format as mentioned in the sample output.

Consider below sample input and output:

Input:
Welcome123

Output:
Number of Vowels: 3
Number of Consonants: 4 */


import java.util.*;

public class MyClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int countVowel = 0, countConsonant = 0;

        input = input.toLowerCase();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'i' || input.charAt(i) == 'o'
                    || input.charAt(i) == 'u') {
                countVowel++;
            } else if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
                countConsonant++;
            }
        }
        System.out.println("Number of Vowels: " + countVowel);
        System.out.println("Number of Consonants: " + countConsonant);
    }
}