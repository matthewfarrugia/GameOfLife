package bbc.codingtests.gameoflife;

import bbc.codingtests.gameoflife.gamestate.GameState;
import bbc.codingtests.gameoflife.gamestate.GameStateImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class LifeTest {

	@Test
	public void testEmptyGrid() {
		String emptyStateInput = "...\n...\n...";

		Life testLife = new LifeImpl();
		GameState emptyState = new GameStateImpl(emptyStateInput);
		assertEquals("An empty grid should stay the same", emptyStateInput, testLife.evolve(emptyState).toString());
	}
	
	@Test
	public void testExampleGrid() {
		String stateInput = "...\n***\n...";
		String stateOutput = ".*.\n.*.\n.*.";
		
		Life testLife = new LifeImpl();
		GameState emptyState = new GameStateImpl(stateInput);
		assertEquals("Incorrect output", stateOutput, testLife.evolve(emptyState).toString());
	}
	
	@Test
	public void testFullGrid() {
		String stateInput = "***\n***\n***";
		String stateOutput = "*.*\n...\n*.*";
		
		Life testLife = new LifeImpl();
		GameState emptyState = new GameStateImpl(stateInput);
		assertEquals("Incorrect output", stateOutput, testLife.evolve(emptyState).toString());
	}
	
	@Test
	public void testDiagGrid() {
		String stateInput = "*..\n.*.\n..*";
		String stateOutput = "...\n.*.\n...";
		
		Life testLife = new LifeImpl();
		GameState emptyState = new GameStateImpl(stateInput);
		assertEquals("Incorrect output", stateOutput, testLife.evolve(emptyState).toString());
	}
	
	@Test
	public void testRows() {
		String stateInput = "***";
		String stateOutput = ".*.";
		
		Life testLife = new LifeImpl();
		GameState emptyState = new GameStateImpl(stateInput);
		assertEquals("Incorrect output", stateOutput, testLife.evolve(emptyState).toString());
	}
	@Test
	public void testColumns() {
		String stateInput = "*\n*\n*";
		String stateOutput = ".\n*\n.";
		
		Life testLife = new LifeImpl();
		GameState emptyState = new GameStateImpl(stateInput);
		assertEquals("Incorrect output", stateOutput, testLife.evolve(emptyState).toString());
	}
	@Test
	public void testLargeGrid() {
		String stateInput = "**.**.\n.**.**\n*.**.*";
		String stateOutput = "**.***\n.....*\n..**.*";
		
		Life testLife = new LifeImpl();
		GameState emptyState = new GameStateImpl(stateInput);
		assertEquals("Incorrect output", stateOutput, testLife.evolve(emptyState).toString());
	}
	@Test
	public void testAsymmetricalGrid() {
		String stateInput = "**.\n*.****\n*";
		String stateOutput = "***\n*.***.\n.";
		
		Life testLife = new LifeImpl();
		GameState emptyState = new GameStateImpl(stateInput);
		assertEquals("Incorrect output", stateOutput, testLife.evolve(emptyState).toString());
	}
}
