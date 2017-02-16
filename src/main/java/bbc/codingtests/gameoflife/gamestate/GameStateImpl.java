package bbc.codingtests.gameoflife.gamestate;

import java.util.List;
import java.util.ArrayList;

public class GameStateImpl implements GameState {
	
	private List<List<Boolean>> table = new ArrayList<List<Boolean>>(); //ArrayList within ArrayList to represent rows and columns
	
    @Override
    public String toString() {
    //Convert 2D array to string representation and return
    	
        String output = ""; //Empty string to allow characters to be concatenated properly
        
        for(List<Boolean> rowData:table){
        	for(Boolean i:rowData){ //Cycles through rows and columns
        		
        		if(i){
        			output += '*'; //'*' if cell is true/alive
        		}else{
        			output += '.'; //'.' if cell is false/empty
        		}
        		
        	}
        	output += '\n'; //Adds newline character at the end of a row
        }
        
        return output.trim(); //Removes final '\n' char to match input sequence formatting
    }

    public GameStateImpl(String input) {
    //Constructor of GameStateImpl, converts inputed string to boolean values held in a 2D ArrayList
    	
    	List<Boolean> rowData = new ArrayList<Boolean>(); //ArrayList to collect data in each row
    	
        for(char c:input.toCharArray()){ //Cycles through each char in the input array
        	
        	switch(c){
        	
        	case '.':
        		rowData.add(false); //'.' Represents empty cell/false
        		break;
        		
        	case '*':
        		rowData.add(true); //'.' Represents alive cell/true
        		break;
        		
        	case '\n':
        		table.add(new ArrayList<Boolean>(rowData)); //Places each row into the main 2D array
        		rowData.clear(); //Clears rowData ArrayList ready for the next row
        		break;
        	}
        }
       	
        if(!rowData.isEmpty()){ //Places the last row into the main 2D array if final '\n' is not present in input string
        	table.add(new ArrayList<Boolean>(rowData));
    		rowData.clear();
        }
    }

    public boolean isCellAliveAt(int row, int col) {
    //Method checks if inputed row & column parameters are in bounds then returns the cell's state
    	
    	if(checkBounds(row,col)){
    		return table.get(row).get(col); //Returns boolean value of selected cell which corresponds to being empty or alive
    	}else{
    		return false;
    	}
    	
    }

    public int getRows() {
    //Returns number of rows in main 2D array
        return table.size();
    }
    
	public int getCols() {
	//Returns number of columns in the first row in main 2D array
		return table.get(0).size();
	}
	
    public int getCols(int row) {
    //Returns number of columns in a particular row in main 2D array
        return table.get(row).size();
    }
    
    public void createCell(int row, int col){
    //Sets the value of selected cell to true/alive
    	if(checkBounds(row,col)){
    	table.get(row).set(col, true);
    	}
    }
    
    public void killCell(int row, int col){
    //Sets the value of selected cell to false/empty
    	if(checkBounds(row,col)){
    		table.get(row).set(col, false);
    	}
    }
    
    public int countNeighbours(int row, int col){
    //Method checks every neighbour and increments the neighbour integer if they are alive
    	
    	int neighbours = 0;
    	
    	//Increments if selected neighbouring cells are alive
    	neighbours = isCellAliveAt(row-1, col-1) ? neighbours+1:neighbours;
		neighbours = isCellAliveAt(row-1, col) ? neighbours+1:neighbours;
		neighbours = isCellAliveAt(row-1, col+1) ? neighbours+1:neighbours;
		
		neighbours = isCellAliveAt(row, col-1) ? neighbours+1:neighbours;
		neighbours = isCellAliveAt(row, col+1) ? neighbours+1:neighbours;
		
		neighbours = isCellAliveAt(row+1, col-1) ? neighbours+1:neighbours;
		neighbours = isCellAliveAt(row+1, col) ? neighbours+1:neighbours;
		neighbours = isCellAliveAt(row+1, col+1) ? neighbours+1:neighbours;
		
		return neighbours;
    }
    
    public boolean checkBounds(int row, int col){
    //Method to check if input parameters are in bounds of the 2D ArrayList
    	if ((row < 0) || (row >= getRows()) || (col < 0) || (col >= getCols(row))){
    		return false; //Returns false if row or column parameters are out of bounds
    	}else{
    		return true;
    	}
    }
}
