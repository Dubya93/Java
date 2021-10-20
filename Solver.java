import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Solver {
    private boolean solvable;
    private MinPQ<Node> pq1;
    private MinPQ<Node> pq2;
    private Queue<Board> solution;
    private int moves;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        solvable = false;
        pq1 = new MinPQ<Node>();
        pq2 = new MinPQ<Node>(); // twin
        solution = new Queue<Board>();
        moves = 0;

        Node initialNode = new Node(initial, 0, null);
        pq1.insert(initialNode);

        Node initialTwin = new Node(initial.twin(), 0, null);
        pq2.insert(initialTwin);

        // int step = 0;

        while (true) {
            /*
            StdOut.println("Step: " + step);
            for (Node n : pq) {
                StdOut.println(n);
            }
            step++;
             */

            Node node = pq1.delMin();
            solution.enqueue(node.board);

            Node twin = pq2.delMin();

            // check node isGoal
            if (node.board.isGoal()) {
                solvable = true;
                moves = node.moves;
                break;
            } else if (twin.board.isGoal()) {
                solvable = false;
                moves = -1;
                solution = null;
                break;
            } else {
                for (Board board : node.board.neighbors()) {
                    Node neighborNode = new Node(board, node.moves + 1, node);

                    if (node.prev == null
                        || !neighborNode.board.equals(node.prev.board)) {
                        pq1.insert(neighborNode);
                    }
                }

                // twin path
                for (Board board : twin.board.neighbors()) {
                    Node neighborNode = new Node(board, twin.moves + 1, twin);

                    if (twin.prev == null
                        || !neighborNode.board.equals(twin.prev.board)) {
                        pq2.insert(neighborNode);
                    }
                }
            }
        }
    }

    // is the initial board solvable?
    public boolean isSolvable() {
        return solvable;
    }

    // min number of moves to solve initial board; -1 if no solution
    public int moves() {
        return moves;
    }

    // sequence of boards in a shortest solution; null if no solution
    public Iterable<Board> solution() 
    {
    	if(isSolvable())
    		return solution;
    	else
    		return null;
    }

    private class Node implements Comparable<Node> {
        private final Board board;
        private final int moves;
        private final Node prev;
        private final int manhattan;
        private final int priority;

        public Node(Board initial, int moves, Node prev) {
            this.board = initial;
            this.moves = moves;
            this.prev = prev;
            this.manhattan = this.board.manhattan();
            this.priority = this.moves + this.manhattan;
        }

        public int compareTo(Node that) {
            return this.priority - that.priority;
        }

        public int priority() {
            assert priority == manhattan + moves;
            return priority;
        }

        public String toString() {
            String s = "";
            s += "priority  = " + priority + "\n";
            s += "moves     = " + moves + "\n";
            s += "manhattan = " + manhattan + "\n";
            s += board;

            return s.toString();
        }
    }

    // solve a slider puzzle (given below)
    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int N = in.readInt();
        int[][] blocks = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}