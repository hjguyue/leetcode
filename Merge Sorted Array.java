public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int cursor  = m + n - 1;

        while (cursor >= 0) {
            if (n == 0 || (m > 0 && n > 0 && A[m - 1] > B[n - 1])) {
                A[cursor] = A[m - 1];
                m--;
            } else if (m == 0 || (m > 0 && n > 0 && A[m - 1] <= B[n - 1])) {
                A[cursor] = B[n - 1];
                n--;
            }
            cursor--;
        }
    }
}