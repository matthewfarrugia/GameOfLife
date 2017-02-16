package bbc.codingtests.gameoflife;

import bbc.codingtests.gameoflife.gamestate.GameState;
import bbc.codingtests.gameoflife.gamestate.GameStateImpl;

public class LifeImpl implements Life
{
	public GameState evolve(GameState currentState) {
	//Counts the neighbours of each cell and applies the rules of the game to the inputed GameState
		
		int numRows, numCols;
		int row, col;
		int neighbours;
		
		GameState resultState = new GameStateImpl(currentState.toString()); //Duplicates the inputed currentState to a new GameState to check neighbours and apply rules simultaneously
		
		numRows = currentState.getRows();
		for(row = 0; row < numRows; row++){
			
			numCols = currentState.getCols(row);
			for(col = 0; col < numCols; col++){ //Cycles through all indexes in main 2D array
			
				neighbours = currentState.countNeighbours(row,col); //Counts the alive neighbours of cell

				if((neighbours < 2) || (neighbours > 3)){ //Implements scenario 1 & 2 kills alive cells if under or over populated
				
					resultState.killCell(row,col);
				}
			
				if(neighbours == 3){ //Implements scenario 3 & 4, cell is created or continues to live if it has exactly 3 neighbours
				
					resultState.createCell(row,col);
				}
			}
			
		}
		return resultState;
	}
}
