public class Solution {
	public double findMedianSortedArrays(int A[], int B[]) {
		if (A.length <= B.length)
			return search(A, B);
		return search(B, A);
	}

    // make sure that A.length <= B.length: m < n
	public double search(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		if (m == 0)
			return (B[n / 2] + B[(n-1) / 2]) / 2.0;
		if (n == 0)
			return (A[m / 2] + A[(m-1) / 2]) / 2.0;

		int leftA = 0;  int rightA = m - 1;
		int leftB = 0;  int rightB = n - 1;

		leftB = Math.max((n - m - 1) / 2, 0);
		rightB = n - 1 - leftB;
		
		while (true) {
			if (leftA >= rightA - 1 || leftB >= rightB - 1)
				break;
			
			int midA = (leftA + rightA) / 2;
			int midB = (leftB + rightB + 1) / 2;
			if (A[midA] < B[midB]) {
				leftA = midA;
				rightB = midB;
			} else {
				rightA = midA;
				leftB = midB;
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = leftA; i <= rightA; i++)
			list.add(A[i]);
		for (int i = leftB; i <= rightB; i++)
			list.add(B[i]);
		Collections.sort(list);
		
		int count = leftA + leftB;
		int remain = (m + n - 1) / 2 - count;
		if ((m + n) % 2 != 0)
			return list.get(remain);
		else
			return (list.get(remain) + list.get(remain+1)) / 2.0;
	}
}