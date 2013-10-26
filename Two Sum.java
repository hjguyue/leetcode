public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int temp[] = numbers.clone();
        Arrays.sort(numbers);

        int num[] = new int[2];
        num[0] = 0;
        num[1] = numbers.length - 1;

        while (true){
        	if (numbers[num[0]] + numbers[num[1]] > target)
        		num[1]--;
        	else if (numbers[num[0]] + numbers[num[1]] < target)
        		num[0]++;
        	else {
        		for (int i = 0; i < numbers.length; i++) {
        			if (temp[i] == numbers[num[0]]){
        				num[0] = i + 1;
        				break;
        			}
        		}
        		for (int i = 0; i < numbers.length; i++) {
        			if (temp[i] == numbers[num[1]] && i != num[0]-1){
        				num[1] = i + 1;
        				break;
        			}
        		}
        		if (num[0] > num[1]) {
        			int x = num[1];
        			num[1] = num[0];
        			num[0] = x;
        		}
        		return num;
        	}
        }
    }
}