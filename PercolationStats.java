
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;


public class PercolationStats 
{
	private int t;
    private double[] percentage;
    private double Confidence_95 = 1.96;
    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int t)
    {
    	// perform T independent experiments on an N-by-N grid
        if (n <= 0 || t <= 0) 
        {
            throw new java.lang.IllegalArgumentException();
        }
        this.t = t;
        this.percentage = new double[t];
        for (int i = 0; i < t; i++) 
        {
            int count = 0;
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) 
            {
                int x, y;
                do 
                {
                    x = StdRandom.uniform(n) + 1;
                    y = StdRandom.uniform(n) + 1;
                } while (percolation.isOpen(x, y));
                percolation.open(x, y);
                count++;
            }
            percentage[i] = (double) count / n / n;
        }
    	
    }
    // sample mean of percolation threshold
    public double mean()
    {
    	// sample mean of percolation threshold
        return StdStats.mean(percentage);
    	
    }
    // sample standard deviation of percolation threshold
    public double stddev()
    {
    	// sample standard deviation of percolation threshold
        return StdStats.stddev(percentage);
    	
    }
    // low endpoint of 95% confidence interval
    public double confidenceLo()
    {
    	  // low  endpoint of 95% confidence interval
        return StdStats.mean(percentage) - Confidence_95 * StdStats.stddev(percentage) / Math.sqrt(t);
    	
    }
    // high endpoint of 95% confidence interval
    public double confidenceHi()
    {
    	// high endpoint of 95% confidence interval
        return StdStats.mean(percentage) + Confidence_95 * StdStats.stddev(percentage) / Math.sqrt(t);
    	
    }
   // test client (see below)
   public static void main(String[] args)
   {
	// test client (described below)
       int n = 2;
       int t = 10000;
       PercolationStats stats = new PercolationStats(n, t);
       System.out.println(stats.mean() + "");
       System.out.println(stats.stddev() + "");
       System.out.println(stats.confidenceLo() + " " + stats.confidenceHi());
    	
   }
}
