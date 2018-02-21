import java.io.*;
import java.util.*;

public class Caesar {
  
  public static String encrypt(String s, int rotation) {
    // Complete this method
    // changes string s into a character array
    char[] message = s.toCharArray();
    //new array to hold the rotated characters
    char[] hold = new char[message.length];
    
    //goes through message, shifts the characters by the indicated rotation,
    //and puts it into hold
    for(int i= 0; i < message.length; i++) {
      char shift = letterOperation(message[i], rotation);
      hold[i] = shift;
    }
    //turns hold from an array to a string
    String output = new String(hold); 
    return output;
  }
  public static String decrypt(String s, int rotation) {
    /* takes everything from the encrypt method and reverses it by turning
     * int rotation into a negative */ 
    rotation *= -1;
    String myString = encrypt(s, rotation);
    return myString;
  }
  
  private static char letterOperation(char a, int rotation) {
    //Complete this method
    /*letterOperation will create the cyclic loop that will allow 'z' to rotate 
     to 'a' and vice versa, anything in between. If the ASCII code called goes out of
     bounds, it will return char a without doing any rotations. No short circuits
     were applied, therefore it will have to run through the whole method before
     it returns the unrotated a. */
     
     
    /*The modulus accounts for rotating through the cipher (all 26 letters)
     *at least once without going out of bounds*/
    rotation = rotation % 26;
    
    //this method accounts for all uppercase letter rotations
    if(a >= 65 && a <= 90) {
      a = (char)(a + rotation);
      if(a > 90) {
        a = (char) (a - 26);
      }
      if(a < 65) {
        a = (char)(a + 26);
      }
    }
    //this method accounts for all lowercase letter rotations
    if(a>= 97 && a<= 122) {
      a = (char)(a + rotation);
      if(a > 122) {
        a = (char) (a - 26);
      }
      if(a < 97) {
        a = (char) (a + 26);
      }
    }
    return a;
  }
}
