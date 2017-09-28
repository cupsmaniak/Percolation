
/**
 * To model a percolation system.
 * 
 * Wurood Mandawi 
 * Sep 16, 2016
 * Assignment URL: http://www.cs.princeton.edu/courses/archive/fall16/cos226/assignments/percolation.html
 */
public class Percolation
{
    private int size; //number of sites in the grid
    private int gridSize; //the size of the grid
    private WeightedQuickUnionUF quf;
    private WeightedQuickUnionUF backWash; 
    private boolean[] open; // to chick if the site is open 
    private int virtualTop;  //a virtual point at the top to check with things on the top
    private int virtualBottom; // a virtual point at the bottom to check if it is connect 
    private int openSites; //keeps track of the open sites
   
    public Percolation(int N) {               // create N-by-N grid, with all sites initially blocked
        //Check if the size is less or equal to zero. 
        
        if (N <= 0) throw new IllegalArgumentException("The size must be greater than 0");
        size = N; //set size to equal N
        gridSize = size * size; //set the size of the grid.
        open = new boolean[gridSize]; //check if something is open
        quf = new WeightedQuickUnionUF(gridSize + 2);
        backWash = new WeightedQuickUnionUF(gridSize + 1);
        virtualTop = gridSize; //the virtual point at the top
        virtualBottom = gridSize + 1; //the virtual point at the bottom
        openSites = 0;
    }

    private int to1D(int row, int col) {        // Convert from 2D to 1D      
        return size * row + col;
    }

    private boolean validBounds (int row, int col) { //check the bounds of the grid
        if((row < 0 || row >= size) || (col < 0 || col >= size)) 
            return false;
        return true;
    }

    private void connected(int row, int col) { 
        // check if the sites are connect  to each other and 
        //the virtual top and the virtual bottom
        int site = to1D(row, col);
       
   
        if(row == 0) { //connect the open sites in the first row to the virtual top
            quf.union(virtualTop, site);
            backWash.union(virtualTop,  site);
        }
        if(row == size - 1) { //connect the open sites in the last row to the virtual bottom
            quf.union(virtualBottom, site);
        }

        if(col > 0) { 
            if (isOpen(row, col - 1)) {
                //connect the open site to its open left site
                quf.union(to1D(row, col - 1), site);
                backWash.union(to1D(row, col - 1), site);
            }
        }
        if(col < (size - 1)) {
            if (isOpen(row, col + 1)) {
                //connect the open site to its open right site
                quf.union(to1D(row, col + 1), site);
                backWash.union(to1D(row, col + 1), site);
            }
        }
        if(row > 0) {
            if (isOpen(row - 1, col)) {
                //connect the open site to its open top site
                quf.union(to1D(row - 1, col), site);
                backWash.union(to1D(row - 1, col), site);
            }
        }
        if(row < (size - 1)){
            if ( isOpen(row + 1, col)) {
                //connect the open site to its open bottom site
                quf.union(to1D(row + 1, col), site);
                backWash.union(to1D(row + 1, col), site);  
           }
        }
    }

    public void open(int row, int col) {      // open the site (row, col) if it is not open already
        if(!validBounds(row, col)) throw new IndexOutOfBoundsException("Invaild index");
        if (isOpen(row, col)) return;

        open[to1D(row, col)] = true; // open the site of row and col
        connected(row, col);
        openSites++; //keep track of open sites

    }

    public boolean isOpen(int row, int col) { // is the site (row, col) open?
        if(!validBounds(row, col)) throw new IndexOutOfBoundsException("Invaild index");
        int index = to1D(row, col);
        return open[index] == true;
    }

    public boolean isFull(int row, int col) { // is the site (row, col) full?
        if(!validBounds(row, col)) throw new IndexOutOfBoundsException("Invaild index");
        return backWash.connected((to1D(row, col)), virtualTop);
    }

    public int numberOfOpenSites() {          // number of open sites
        return openSites;
    }

    public boolean percolates() {             // does the system percolate?
        //if the virtual top is connect  to the virtual bottom then it percolates      
        return quf.connected(virtualTop, virtualBottom);
    }
    

}
