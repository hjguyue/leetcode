public class Solution {
	public String multiply(String num1, String num2) {
		String temp = "";
		String result = "";

		for (int i = num1.length() - 1; i >= 0; i--) {
			result = add(result, multi(num2, num1.substring(i, i + 1)) + temp);
			temp = temp + "0";
		}

		return result;
	}

	public String multi(String num1, String digit) {
		if (num1.equals("0") || digit.equals("0"))
			return "0";

		int save = 0;
		String result = "";
		for (int i = num1.length() - 1; i >= 0; i--) {
			int value = Integer.parseInt(num1.substring(i, i + 1)) * Integer.parseInt(digit) + save; result = (value % 10) + result;
			save = value / 10;
		}
		if (save != 0)
			result = save + result;
		return result;
	}

	public String add(String num1, String num2) {
		// make sure length_num1 < length_num2
		if (num1.length() > num2.length()) {
			String temp = num1;
			num1 = num2;
			num2 = temp;
		}
		String result = "";
		int save = 0;
		int dis = num2.length() - num1.length();
		for (int i = num2.length() - 1; i >= 0; i--) {
			int first = 0;
			if (i >= dis)
				first = Integer.parseInt(num1.substring(i - dis, i - dis + 1));
			int value = first + Integer.parseInt(num2.substring(i, i + 1)) + save;
			result = (value % 10) + result;
			save = value / 10;
		}
		if (save != 0)
			result = save + result;
		// reduce:
		while(result.length() > 1 && result.substring(0,1).equals("0")){
			result = result.substring(1);
		}
		return result;
	}
}