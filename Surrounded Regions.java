public class Solution {
	public static int M;
	public static int N;

    public void solve(char[][] board) {
        if (board.length == 0)
        	return;

        M = board.length;
        N = board[0].length;
        Queue<Node> queue = new LinkedList<Node>();
        char grid[][] = new char[M][N];

        Queue<Node> candidates = new LinkedList<Node>();
       	for (int i = 0; i < M; i++) {
       		candidates.offer(new Node(i,0));
       		candidates.offer(new Node(i,N-1));
       	}
       	for (int j = 0; j < N; j++) {
       		candidates.offer(new Node(0, j));
       		candidates.offer(new Node(M-1, j));
       	}

       	while(candidates.size() != 0){
       		Node cand = candidates.poll();
       		if (board[cand.x][cand.y] == 'O') {
       				Node node = new Node(cand.x,cand.y);
       				queue.offer(node);
       				board[cand.x][cand.y] = 'X';
       				while (queue.size() != 0){
       					node = queue.poll();
       					grid[node.x][node.y] = 'O';

       					if (node.up()) {
       						if (board[node.x][node.y] == 'O'){
       							queue.offer(new Node(node.x, node.y));
       							board[node.x][node.y] = 'X';
       						}
       						node.down();
       					}
       					if (node.right()) {
       						if (board[node.x][node.y] == 'O'){
       							queue.offer(new Node(node.x, node.y));
       							board[node.x][node.y] = 'X';
       						}
       						node.left();
       					}
       					if (node.down()) {
       						if (board[node.x][node.y] == 'O'){
       							queue.offer(new Node(node.x, node.y));
       							board[node.x][node.y] = 'X';
       						}
       						node.up();
       					}
       					if (node.left()) {
       						if (board[node.x][node.y] == 'O'){
       							queue.offer(new Node(node.x, node.y));
       							board[node.x][node.y] = 'X';
       						}
       						node.right();
       					}
       				}
       			}
       	}
       			
       	for (int i = 0; i < M; i++) {
       		for (int j = 0; j < N; j++) {
       			if (grid[i][j] == 'O')
       				board[i][j] = 'O';
       			else
       				board[i][j] = 'X';
       		}
       	}

    }
}

class Node{
	int x;
	int y;
	public Node(int X, int Y){
		x = X;
		y = Y;
	}

	public boolean up(){
		if (x - 1 < 0)
			return false;
		x--;
		return true;
	}

	public boolean down(){
		if (x + 1 >= Solution.M)
			return false;
		x++;
		return true;
	}

	public boolean right(){
		if (y + 1 >= Solution.N)
			return false;
		y++;
		return true;
	}

	public boolean left(){
		if (y - 1 < 0)
			return false;
		y--;
		return true;
	}
}