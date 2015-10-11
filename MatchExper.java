package questions;

public class MatchExper {

	public static boolean match(String str, String expr) {
		if (str.length() == 0 || expr.length() == 0 || str == null
				|| expr == null)
			return false;
		else {
			boolean result = true;
			int i = 0;
			int j = 0;
			while (i < str.length() && j < expr.length()) {
				if (str.charAt(i) != expr.charAt(j)) {
					// case 01: charAt(j) is '.'
					if (expr.charAt(j) == '.') {
						i++;
						j++;
					}
					// case 02: charAt(j) is any different letter followed by
					// '*'
					else if (expr.charAt(j + 1) == '*') {
						j = j + 2;
					}
					// case 03: charAt(j) is '*'
					else if (expr.charAt(j) == '*') {
						if (i > 0 && str.charAt(i) == str.charAt(i - 1)) {
							i++;
							while (str.charAt(i) == str.charAt(i - 1)) {
								i++;
							}
							j++;
						} else
							j++;
					} else {
						result = false;
						break;
					}
				} else {
					i++;
					j++;
				}

			}
			return result;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(match("Facebook", "F.cebo*k"));

	}

}
