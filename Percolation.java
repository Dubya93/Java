
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation 
{
	private int n;
	private byte[][] array;
	private int countOpen;
	private WeightedQuickUnionUF weightedQuickUnionUF;
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n)
    {
    	 if (n <= 0) 
    	 {
             throw new java.lang.IllegalArgumentException();
         }
         this.n = n;
         array = new byte[n][n];
         weightedQuickUnionUF = new WeightedQuickUnionUF(n * n + 2);
         countOpen = 0;
    }
    private void setFull(int row, int col) 
    {
        if (row < 1 || row > n || col < 1 || col > n) return;
        if (!isOpen(row, col) || isFull(row, col)) return;
        array[row - 1][col - 1] |= 1 << 1;
        setFull(row - 1, col);
        setFull(row + 1, col);
        setFull(row, col - 1);
        setFull(row, col + 1);
    }

    private void checkConnectedTop(int row, int col) 
    {
        if (row < 1 || row > n || col < 1 || col > n) return;
        if (isFull(row, col)) return;
        if (row == 1 || (row > 1 && isFull(row - 1, col)) || (row < n && isFull(row + 1, col)) || (col > 1 && isFull(row, col - 1)) || (col < n && isFull(row, col + 1))) 
        {
            setFull(row, col);
        }
    }
    
    // opens the site (row, col) if it is not open already
    public void open(int row, int col)
    {
        if (row < 1 || col > n || col < 1 || col > n) 
        {
            throw new java.lang.IllegalArgumentException();
        }
        if (!isOpen(row, col)) 
        {
            array[row - 1][col - 1] |= 1;
            checkConnectedTop(row, col);
            countOpen++;
            if (row - 1 == 0) 
            {
                weightedQuickUnionUF.union(0, col);
            }
            if (row == n) 
            {
                weightedQuickUnionUF.union((n - 1) * n + col, n * n + 1);
            }
            if (row > 1 && isOpen(row - 1, col)) 
            {
                weightedQuickUnionUF.union((row - 1) * n + (col - 1) + 1, (row - 2) * n + (col - 1) + 1);
            }
            if (row < n && isOpen(row + 1, col)) 
            {
                weightedQuickUnionUF.union((row - 1) * n + (col - 1) + 1, (row) * n + (col - 1) + 1);
            }
            if (col > 1 && isOpen(row, col - 1)) 
            {
                weightedQuickUnionUF.union((row - 1) * n + (col - 1) + 1, (row - 1) * n + (col - 2) + 1);
            }
            if (col < n && isOpen(row, col + 1)) 
            {
                weightedQuickUnionUF.union((row - 1) * n + (col - 1) + 1, (row - 1) * n + (col) + 1);
            }
        }
    }
    
    // is the site (row, col) open?
    public boolean isOpen(int row, int col)
    {
    	  if (row < 1 || row > n || col < 1 || col > n) 
    	  {
              throw new java.lang.IllegalArgumentException();
          }
          return (array[row - 1][col - 1] & 1) == 1;
    }
    // is the site (row, col) full?
    public boolean isFull(int row, int col)
    {
    	 if (row < 1 || row > n || col < 1 || col > n) 
    	 {
             throw new java.lang.IllegalArgumentException();
         }
         return ((array[row - 1][col - 1] >> 1) & 1) == 1;
    }
    // returns the number of open sites
    public int numberOfOpenSites()
    {
    	return countOpen;
    	
    }
    // does the system percolate?
    public boolean percolates()
    {
    	return weightedQuickUnionUF.find(0) == weightedQuickUnionUF.find(n * n + 1);
    }
    // test client (optional)
    public static void main(String[] args)
    {
    	   Percolation percolation = new Percolation(5);
           percolation.open(3, 1);
           percolation.open(2, 1);
           percolation.open(1, 1);
           percolation.open(3, 2);
           System.out.println(percolation.isFull(1, 1) + "");
           System.out.println(percolation.isFull(2, 1) + "");
           System.out.println(percolation.isFull(3, 2) + "");
    	
    }
}
