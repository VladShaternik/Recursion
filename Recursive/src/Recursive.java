/**
 * @author Vladyslav Shaternik and John Obradovic
 */
public class Recursive {

    public static void main(String[] args) {
        final String HEADER = "***************************************************************\n" +
                "* AUTHORS : Vladyslav Shaternik and John Obradovic\n" +
                "* DATE    : 01/16/2019\n" +
                "* CLASS   : CS1D MW/2:30pm\n" +
                "***************************************************************\n";
        final String DESCRIPTION = "This program is using recursion to check whether the sting is palindrome. " +
                "It goes starting from checking\n" +
                "the very first character vs the very last character in string. Then it call s itself " +
                "without first and last\n" +
                "characters. This function also calls function for filtering string from non alphabetic " +
                "characters and makes it\n" +
                "lower case.\n";
        String[] testCases = {
                "A man a plan a canal Panama",
                "The rain in Spain",
                "No lemon, no melon",
                "radar",
                "CS1D",
                "Was it a cat I saw?",
                "Racecar",
                "Saddleback",
                "mom",
                "dad"
        };

        System.out.println(HEADER);
        System.out.println(DESCRIPTION);

        // Display and calculate whether test cases are palindromes
        for (int i = 0; i < testCases.length; i++) {
            String testCase = testCases[i];
            // Call recursive function isPalindrome(), based on the return using ternary comparison operator display
            // whether the string is palindrome or not
            System.out.println("Test #" + (i + 1) + ": [" + testCase + "] | " + ((isPalindrome(testCase)) ? "Palindrome" : "Not Palindrome"));
        }
    }

    /**
     * This function is using recursion to check whether the sting is palindrome. It goes starting from checking
     * the very first character vs the very last character in string. Then it call s itself without first and last
     * characters. This function also calls function for filtering string from non alphabetic characters and makes it
     * lower case.
     * <p>
     * BASE CASE: the function can continue calling itself until first and last character are no equal to each other at
     * the string at that moment. OR if the functions gets the string with only two characters, then it just returns
     * whether they are equal to each other. OR if the function hits the single character, then it just returns true.
     *
     * @param str - string to check whether it is palindrome
     * @return - whether the string is palindrome
     */
    private static boolean isPalindrome(String str) {
        str = filter(str);

        if (str.length() == 1) {
            return true;
        } else if (str.length() == 2) {
            return str.charAt(0) == str.charAt(1);
        } else if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return isPalindrome(str.substring(1, str.length() - 1));
        } else {
            return false;
        }
    }

    /**
     * This function will filter the given string from non alphabetic characters and make the string lowercase
     *
     * @param str - string to filter
     * @return - filtered string
     */
    private static String filter(String str) {
        // Make the string lowercase
        str = str.toLowerCase();

        // Filter from non alphabetic characters
        StringBuilder builder = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                builder.append(c);
            }
        }

        return builder.toString();
    }
}
