public class Solution {
    public static int M;
    public static int N;
    int flag[][];
    char grid[][];
    boolean FIND;

    public boolean exist(char[][] board, String word) {
        if (board.length == 0)
            return false;
        M = board.length;
        N = board[0].length;
        flag = new int[M][N];
        grid = board;

        FIND = false;
        for (int i = 0; i < M; i++) {
        	for (int j = 0; j < N; j++) {
        		if (search(word, i ,j))
        			return true;
        	}
        }
        return false;
    }

    public boolean search(String str, int x, int y){
    	if (FIND)
    		return true;
    	if (str.length() == 0)
    		return true;
    	if (str.charAt(0) != grid[x][y])
    		return false;
    	
    	boolean ans = false;
    	Node node = new Node(x,y);
    	String remain = str.substring(1);
    	if (remain.length() == 0)
    		return true;

    	flag[x][y] = 1;
    	if (node.up()) {
    		if (flag[node.x][node.y] == 0)
    			ans = ans | search(remain, node.x, node.y);
    		node.down();
    	}
    	
    	if (node.right()) {
    		if (flag[node.x][node.y] == 0)
    			ans = ans | search(remain, node.x, node.y);
    		node.left();
    	}

    	if (node.down()) {
    		if (flag[node.x][node.y] == 0)
    			ans = ans | search(remain, node.x, node.y);
    		node.up();
    	}

    	if (node.left()) {
    		if (flag[node.x][node.y] == 0)
    			ans = ans | search(remain, node.x, node.y);
    		node.right();
    	}
    	flag[x][y] = 0;

    	FIND = FIND | ans;
    	return ans;
    }
}

class Node{
    int x;
    int y;

    public Node(int X, int Y){
        x = X;  y = Y;
    }

    public boolean up(){
        if (x - 1 >= 0) {
            x--;
            return true;
        }
        return false;
    }

    public boolean down(){
        if (x + 1 < Solution.M) {
            x++;
            return true;
        }
        return false;
    }

    public boolean right(){
        if (y + 1 < Solution.N) {
            y++;
            return true;
        }
        return false;
    }

    public boolean left(){
        if (y - 1 >= 0) {
            y--;
            return true;
        }
        return false;
    }
}

