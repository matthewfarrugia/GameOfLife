package bbc.codingtests.gameoflife.gamestate;

public interface GameState {
    /**
     * Whether the cell at the given row and column is alive or not
     * Should return false if the coordinates are outside the grid
     * @param row
     * @param col
     * @return
     */
    boolean isCellAliveAt(int row, int col);

    /**
     * @return Number of rows the game has
     */
    int getRows();

    /**
     * @return Number of columns the game has
     */
    int getCols();
    
    /*
     * Returns the number of columns in a particular row
     * @param row
     * @return Number of columns the game has
     */
	int getCols(int row);
	
    /*
     * Sets the value of selected cell to true/alive
     * @param row
     * @param col
     */
	void createCell(int row, int col);
	
    /*
     * Sets the value of selected cell to false/empty
     * @param row
     * @param col
     */
	void killCell(int row, int col);
	
    /*
     * Checks every neighbour and increments the neighbour integer if they are alive
     * @param row
     * @param col
     */
	int countNeighbours(int row, int col);
	
    /*
     * Checks if input parameters are in bounds of the 2D ArrayList
     * @param row
     * @param col
     * @return True or False
     */
	boolean checkBounds(int row, int col);
}
