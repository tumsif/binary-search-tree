import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class Palindrome {
    /**
 * Demonstrating palindrome function using stacks and queue
 * 
 * Stacks helps us to arrange data in a first in last out order
 * Queue on the other hand allows us to arrange data in a first in first out order
 * 
 * By leveraging the two functionalities we can detect if a string is either a palindrome or not
 * 
 * Algorithm:
 * Store or receive the string value
 * For each character of the string push it to each of the stacks or queue classes
 * Pop the character on the stack and remove the character from the key and then compare them
 * If in any occation the values do not match the string is not a palindrome
 * 
 */

    private boolean isPalindrome(String value){
        char[] valueArr = value.toCharArray();
        Stack<Character> charStack = new Stack<>();
        Queue<Character> charQueue = new LinkedList<Character>();

        for(Character valueChar: valueArr){
            charStack.push(valueChar);
            charQueue.add(valueChar);
        }

        for(Character valueChar: valueArr){
            if(charStack.pop() != charQueue.remove()){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String palindromeString = "ono";
        String nonPalindromeStr = "one";
        Palindrome pal = new Palindrome();
        System.out.println(pal.isPalindrome(palindromeString));
        System.out.println(pal.isPalindrome(nonPalindromeStr));

    }
}