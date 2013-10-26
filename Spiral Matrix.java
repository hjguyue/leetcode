public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        list = new ArrayList<Integer>();
        if (matrix.length == 0)
            return list;

        int m = matrix.length;
        int n = matrix[0].length;

        insert(0,0,m-1,n-1,matrix);
        return list;
    }

    ArrayList<Integer> list;
    public void insert(int x1, int y1, int x2, int y2,int[][] matrix){
        if (x1 > x2 || y1 > y2)
            return;
        if (x1 == x2) {
            for (int i = y1; i <= y2; i++)
                list.add(matrix[x1][i]);
            return;
        }
        if (y1 == y2) {
            for (int i = x1; i <= x2; i++)
                list.add(matrix[i][y1]);
            return;
        }
        for (int i = y1; i < y2; i++)
            list.add(matrix[x1][i]);
        for (int i = x1; i < x2; i++)
            list.add(matrix[i][y2]);
        for (int i = y2; i > y1; i--)
            list.add(matrix[x2][i]);
        for (int i = x2; i > x1; i--)
            list.add(matrix[i][y1]);
        insert(x1+1, y1+1, x2-1, y2-1, matrix);
    }
}