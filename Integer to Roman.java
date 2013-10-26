public class Solution {

	String letters[] = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
	int nums[] = {1,4,5,9,10,40,50,90,100,400,500,900,1000};

	public String intToRoman(int num) {
		int N = letters.length;
		String result = "";
		while (num > 0){
			for (int i = N-1; i >= 0; i--) {
				if (num < nums[i])
					continue;
				num -= nums[i];
				result = result + letters[i];
				break;
			}
		}
		return result;
	}
}