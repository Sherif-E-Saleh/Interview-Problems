package questions;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintAnagrams {

	public static ArrayList<String> container = new ArrayList<String>();

	private static boolean isAnagrams(String g, String f) {
		char c1[] = g.toCharArray();
		char c2[] = f.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		String str1 = new String(c1);
		String str2 = new String(c2);
		return str1.equals(str2);
	}

	public static Object [] getAnagrams(String[] array) {
		for (int i = 0; i < array.length / 2; i++) {
			for (int j = array.length - 1; j > array.length / 2; j--) {
				if (isAnagrams(array[i], array[j]) && i != j) {
					container.add(array[i]);
					container.add(array[j]);
				}
			}
		}
		return container.toArray();
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] lamia = { "tac", "tower", "asdasd", "actor","act", "otwer"};
		System.out.println(Arrays.deepToString(getAnagrams(lamia)));
	}

}
