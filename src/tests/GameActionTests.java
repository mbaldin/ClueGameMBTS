package tests;

import org.junit.BeforeClass;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import clueGame.*;
import static org.junit.Assert.*;

import clueGame.Board;

public class GameActionTests {

	private static Board board;
	@BeforeClass
	public static void setUp() {
		//initialize a board instance
		board = Board.getInstance();
		//using our config files
		board.setConfigFiles("MBSR_ClueLayout.csv", "MBSR_ClueLegend.txt","MBSR_test_players.txt","MBSR_test_weapons.txt");
		//initializing
		board.initialize();
	}
	
	@Test
	public void testRandomTargetRoomless() {
		ComputerPlayer player = new ComputerPlayer("Testy", Color.BLACK, 21, 20);
		board.calcTargets(21, 20, 1);
		boolean case21_19 = false;
		boolean case20_20 = false;
		//run 100 times
		for (int i = 0; i < 100; ++i) {
			BoardCell selected = player.pickLocation(board.getTargets());
			if (selected == board.getCellAt(21,  19)) {
				case21_19 = true;
			}
			else if (selected == board.getCellAt(20, 20)) {
				case20_20 = true;
			}
			else {
				fail("Invalid target selected.");
			}
		}
		assertTrue(case21_19);
		assertTrue(case20_20);
	}
}
