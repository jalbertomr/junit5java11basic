package com.bext.junit5java11basic.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import static com.bext.junit5java11basic.model.Race.HOBBIT;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.bext.junit5java11basic.model.TolkeinCharacter;

class DataServiceTest {

	//Todo Initialize before each test
	DataService dataService;
	
	
	@Test
	void ensurethatInitializationOkTolkeinCharacterWorksTest() {
		//Todo check that age is less than 33
		//Todo chack that name is frodo
		//Todo check that name is not frodon
		fail("Not yet implemented");
	}
	
	@Test
	void ensureThatEqualsWorksForCharacters() {
		Object jake = new TolkeinCharacter("Jake",43,HOBBIT);
		Object samejake = jake;
		Object jakePseudoClone = new TolkeinCharacter("Jake",22,HOBBIT);
		//Todo check that
		//jake is equal to samejack
		//jake is not equal to jackClone
		fail("Not yet implemented");
	}
	
	
	@Test
	void checkInheritance() {
		TolkeinCharacter tolkeinCharacter = dataService.getFellowShip().get(0);
		//Todo Check that tolkeinCharacter.getClass() is not a movie class
		fail("Not yet implemented");
	}
	
	@Test
	void ensureFellowShipCharacterAccessByNameReturnsNullForUnknownCharacter() {
		//Todo implement that  a check that dataService.getFellowShipCharacter return null for an
		// unknow fellow
		fail("Not yet implemented");
	}
	
	@Test
	void ensureFellowShipCharacterAccessByNameWorksGivenCorrectNameIsGiven() {
		//Todo implement a check that dataService.getFellowShipCharacter return a fellow
		// for an given fellow
		fail("not yet implemented");
	}

	@Test
	void ensureThatFrodoAndGandalfArePartOfTheFellowship() {
		List<TolkeinCharacter> fellowship = dataService.getFellowShip();
		//todo chech that Frodo and Gandalf are part of the fellowship
		fail("not yet implemented");
	}
	
	@Test
	void ensureThatOneRingBearerIsPartOfTheFellowship() {
		List<TolkeinCharacter> fellowship = dataService.getFellowShip();
		//todo chech that at least one ring bearer is part of the fellowship
		fail("not yet implemented");
	}
	
	//TODO use @RepeatedTest(int) to execute this test 1000  times
	@Test
	@Tag("slow")
	@DisplayName("Minimal stress testing: run this test 10000 times")
	void ensureThatWeCanRetrieveFellowshipMultipleTimes() {
		dataService = new DataService();
		assertNotNull(dataService.getFellowShip());
		fail("not yet implemented");
		
	}
	
	@Test
	void ensureOrdering() {
		List<TolkeinCharacter> fellowship = dataService.getFellowShip();
		//Ensure that the order of the fellowship is:
		// frodo, sam, merry,pippin, gandalf,legolas,gimli,aragorn,boromir
		fail("not yet implemented");
	}
	
	@Test
	void ensureThatFellowsStayASmallGroup() {
		//Todo write a test to get the 20 elements from the fellowShip throwns an 
		//IndexOutOfBoundsException
		fail("not yet implemented");
	}
}
