public class Solution {
    public boolean canCompleteCircuit(int[] gas, int[] cost) {
    	int N = gas.length;
        int num[] = new int[2 * N];

        for (int i = 0; i < N; i++) {
        	num[i] = gas[i] - cost[i];
        	num[i + N] = num[i];
        }

        int MAX_VAL = num[0];
        int MAX_ID = 0;
        int MAX[] = new int[2 * N];
        int mark[] = new int[2 * N];
        MAX[0] = num[0];
        mark[0] = 0;
        for (int i = 1; i < 2 * N; i++) {
        	if (MAX[i - 1] < 0 || i >= (mark[i - 1] + N)) {
        		MAX[i] = num[i];
        		mark[i] = i;
        	}
        	else{
        		MAX[i] = MAX[i - 1] + num[i];
        		mark[i] = mark[i - 1];
        	}
        	if (MAX[i] > MAX_VAL) {
        		MAX_VAL = MAX[i];
        		MAX_ID = mark[i];
        	}
        }

        int sum = 0;
        int loop = MAX_ID;
        int count = 0;
        while (count < N){
        	sum += num[loop % N];
	       	loop++;
        	count++;
        	if (sum < 0)
        		return false;
        }
        return true;
    }
}