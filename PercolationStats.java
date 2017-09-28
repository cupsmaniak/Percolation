
/**
 * To perform a series of computational experiments.
 * 
 * Wurood Mandawi
 * Sep 16 2016
 * 
 * Assignment URL: http://www.cs.princeton.edu/courses/archive/fall16/cos226/assignments/percolation.html
 */
public class PercolationStats {
    private int N;
    private int T;
    private double[] pThreshold;
    private Percolation site;

    public PercolationStats(int N, int T) {  // perform T independent experiments on an N-by-N grid
        if(N <= 0 || T <= 0) throw new IllegalArgumentException("T and N have to be more than 0");
        this.N = N;
        this.T = T;
        pThreshold = new double[T];

        for(int i = 0; i < T; i++) {
            site = new Percolation(N);
            int openedSites = 0;
            while (!site.percolates()) {
                int row = StdRandom.uniform(0, N);
                int col = StdRandom.uniform(0, N);
                if(!site.isOpen(row, col)){
                    site.open(row, col);
                    openedSites++;
                }
            }
            double pt = (double) openedSites / (N * N);
            pThreshold[i] = pt;
        }
    }

    public double mean() {   // sample mean of percolation threshold
        return StdStats.mean(pThreshold); //from Std library
    }

    public double stddev() {                 // sample standard deviation of percolation threshold
        return StdStats.stddev(pThreshold); //from Std library
    }

    public double confidenceLow() {          // low  endpoint of 95% confidence interval
        return mean() - (1.96 * stddev()) / Math.sqrt(T); // use the equation of the lower interval
    }

    public double confidenceHigh()  {        // high endpoint of 95% confidence interval
        return mean() + (1.96 *stddev()) / Math.sqrt(T); // use the equation of the higher interval
    }
    //public static void main(String[] args) {
      // Stopwatch st = new Stopwatch();
        //int N = Integer.parseInt(args[0]);
        //int T = Integer.parseInt(args[1]);
        //PercolationStats ps = new PercolationStats(N, T);
        
        

        //String confidence = ps.confidenceLow() + ", " + ps.confidenceHigh();
        //StdOut.println("mean                    = " + ps.mean());
        //StdOut.println("stddev                  = " + ps.stddev());
        //StdOut.println("95% confidence interval = " + confidence);
        //double time = st.elapsedTime();
        //StdOut.println("time:" + time);
    //}

}

