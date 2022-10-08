import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private byte[] grid;
    private int sideLength;
    private WeightedQuickUnionUF uf;
    private int numOpenSites;
    private boolean doesPercolate;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n <= 0!");
        }
        grid = new byte[n * n];
        sideLength = n;
        uf = new WeightedQuickUnionUF(n * n);
        numOpenSites = 0;
        doesPercolate = false;
    }

    private void validate(int row, int col) {
        if (row < 1 || row > sideLength || col < 1 || col > sideLength) {
            throw new IllegalArgumentException("Argument is outside its prescribed range!");
        }
    }

    private int getIndexOfSite(int row, int col) {
        return (sideLength * (row - 1) + col - 1);
    }

    private boolean checkPercolate(byte rootStatus) {
        if (rootStatus == 7) {
            doesPercolate = true;
            return true;
        }
        return false;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validate(row, col);
        if (!isOpen(row, col)) {
            numOpenSites++;
            if (sideLength == 1) {
                grid[getIndexOfSite(row, col)] = 7;
                doesPercolate = true;
                return;
            } else if (row == 1) {
                grid[getIndexOfSite(row, col)] = 6;
            } else if (row == sideLength) {
                grid[getIndexOfSite(row, col)] = 5;
            } else {
                grid[getIndexOfSite(row, col)] = 4;
            }

            byte newRootStatus;
            byte rootStatus = grid[uf.find(getIndexOfSite(row, col))];
            if (row > 1 && isOpen(row - 1, col)) {
                newRootStatus = (byte) (rootStatus | grid[uf.find(getIndexOfSite(row - 1, col))]);
                uf.union(getIndexOfSite(row, col), getIndexOfSite(row - 1, col));
                grid[uf.find(getIndexOfSite(row, col))] = newRootStatus;
                if (checkPercolate(newRootStatus)) {
                    return;
                }
            }
            if (row < sideLength && isOpen(row + 1, col)) {
                newRootStatus = (byte) (rootStatus | grid[uf.find(getIndexOfSite(row + 1, col))]);
                uf.union(getIndexOfSite(row, col), getIndexOfSite(row + 1, col));
                grid[uf.find(getIndexOfSite(row, col))] = newRootStatus;
                if (checkPercolate(newRootStatus)) {
                    return;
                }
            }
            if (col > 1 && isOpen(row, col - 1)) {
                newRootStatus = (byte) (rootStatus | grid[uf.find(getIndexOfSite(row, col - 1))]);
                uf.union(getIndexOfSite(row, col), getIndexOfSite(row, col - 1));
                grid[uf.find(getIndexOfSite(row, col))] = newRootStatus;
                if (checkPercolate(newRootStatus)) {
                    return;
                }
            }
            if (col < sideLength && isOpen(row, col + 1)) {
                newRootStatus = (byte) (rootStatus | grid[uf.find(getIndexOfSite(row, col + 1))]);
                uf.union(getIndexOfSite(row, col), getIndexOfSite(row, col + 1));
                grid[uf.find(getIndexOfSite(row, col))] = newRootStatus;
                checkPercolate(newRootStatus);
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validate(row, col);
        return (grid[getIndexOfSite(row, col)] != 0);
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validate(row, col);
        return ((row == 1 && isOpen(row, col)) || grid[uf.find(getIndexOfSite(row, col))] == 6
                || grid[uf.find(getIndexOfSite(row, col))] == 7);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return numOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return doesPercolate;
    }
}
