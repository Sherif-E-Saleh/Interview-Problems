package questions;

import java.util.Scanner;

public class ValidPalindrome {

	public static boolean isPalindrome (String str){
		return isPalindromeMain((str.replaceAll("[^A-Za-z0-9]", "")).toLowerCase());
	}
	
	public static boolean isPalindromeMain (String input){
		boolean result = true;
		for (int i = 0; i < input.length()/2; i++) {
			if(input.charAt(i) != input.charAt((input.length()-1)-i)){
				result = false;
				break;
			}
		}
		return result;
	}

//	Recursive Solution
//	*******************
//	public static boolean isPalindromeMain (String input){
//		if(input.length() <= 1)
//			return true;
//		else if(input.charAt(0)== input.charAt(input.length()-1))
//			return true && isPalindromeMain(input.substring(1, input.length()-1));
//		else
//			return false;
//	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner (System.in);
		String s = reader.nextLine();
		System.out.println(isPalindrome(s));
	}

}
