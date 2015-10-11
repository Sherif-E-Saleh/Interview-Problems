package questions;

import java.util.Scanner;

public class StringPerumtations {
	
	public static void getPermutations(String pre, String input) {
		if (input.length() == 0 )
			System.out.println(pre);
		else
			for (int i = 0; i < input.length(); i++) {
				getPermutations(pre+input.charAt(i),input.substring(0, i)+input.substring(i+1));
			}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		int numTests = Integer.parseInt(reader.nextLine());
		String [] inputs = new String [numTests];
		for (int i = 0; i < inputs.length; i++) {
			inputs[i] = reader.nextLine();
		}
		for (int i = 0; i < inputs.length; i++) {
			System.out.println("input ("+(i+1)+"): "+inputs[i]);
			getPermutations("", inputs[i]);
			System.out.println("------------------------");
		}

	}

}
