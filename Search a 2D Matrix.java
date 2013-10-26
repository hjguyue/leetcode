public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null)
    		return false;
    	int M = matrix.length;
    	int N = matrix[0].length;

    	int start = 0;
    	int end = M-1;
    	while(end > (start + 1)){
    		int middle = (start + end) / 2;
    		if (target >= matrix[middle][0])
    			start = middle;
    		if (target < matrix[middle][0])
    			end = middle;
    	}
    	int K = start;
    	if (end > start && target >= matrix[end][0])
    		K = end;
    	
    	start = 0;
    	end = N-1;
    	while(end > (start + 1)){
    		int middle = (start + end) / 2;
    		if (target >= matrix[K][middle])
    			start = middle;
    		if (target < matrix[K][middle])
    			end = middle;
    	}
    	int P = start;
    	if (end > start && target >= matrix[K][end])
    		P = end;
    	
    	return (matrix[K][P] == target);
    }
}