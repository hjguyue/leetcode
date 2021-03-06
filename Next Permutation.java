public class Solution {
    public void nextPermutation(int[] num) {
        int position = num.length-1;
        while(true){
            if (position == 0)
        		break;
        	if (num[position] > num[position-1])
        		break;
        	position--;
        }
        if (position == 0) {
        	reverse(num, 0, num.length-1);
        	return;
        }
        reverse(num, position, num.length-1);
        for (int i = position; i < num.length; i++) {
        	if (num[i] > num[position-1]) {
        		int temp = num[position-1];
        		num[position-1] = num[i];
        		num[i] = temp;
        		break;
        	}
        }
    }

    public void reverse(int[] num, int start, int end){
    	for (int i = start; i <= (end + start)/2; i++) {
    		int temp = num[i];
    		num[i] = num[start + end - i];
    		num[start + end - i] = temp;
    	}
    }
}