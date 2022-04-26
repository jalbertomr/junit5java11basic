package com.bext.junit5java11basic.service;

import static org.junit.jupiter.api.Assertions.*;
import static java.time.Duration.ofSeconds;

import java.util.List;
import java.util.Map;

import static com.bext.junit5java11basic.model.Race.HOBBIT;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.bext.junit5java11basic.model.Movie;
import com.bext.junit5java11basic.model.Ring;
import com.bext.junit5java11basic.model.TolkeinCharacter;

class DataServiceTest {

	private DataService dataService;

	@BeforeEach
	void setupBeforeEach() {
		dataService = new DataService();
	}

	@Test
	void ensurethatInitializationOkTolkeinCharacterWorksTest() {
		TolkeinCharacter frodo = new TolkeinCharacter("Frodo", 33, HOBBIT);

		Assertions.assertEquals(33, frodo.getAge());
		Assertions.assertEquals("Frodo", frodo.getName());
		Assertions.assertNotEquals("Frodon", frodo.getName());
	}

	@Test
	void ensureThatEqualsWorksForCharacters() {
		Object jake = new TolkeinCharacter("Jake", 43, HOBBIT);
		Object samejake = jake;
		Object jakePseudoClone = new TolkeinCharacter("Jake", 22, HOBBIT);

		Assertions.assertEquals(jake, samejake);
		Assertions.assertNotEquals(jake, jakePseudoClone);
	}

	@Test
	void ensureGetFellowShipReturnNotNull() {
		List<TolkeinCharacter> fellowShips = dataService.getFellowShip();
		Assertions.assertTrue(fellowShips.size() > 0);
	}
	@Test
	void checkInheritance() {
		TolkeinCharacter tolkeinCharacter = dataService.getFellowShip().get(0);

		Assertions.assertTrue(TolkeinCharacter.class.isAssignableFrom(tolkeinCharacter.getClass()));
		Assertions.assertFalse(Movie.class.isAssignableFrom(tolkeinCharacter.getClass()));
	}

	@Test
	void ensureFellowShipCharacterAccessByNameReturnsNullForUnknownCharacter() {
		TolkeinCharacter notFound = dataService.getFellowShipCharacter("NotExistSally");
		Assertions.assertNull(notFound);
	}

	@Test
	void ensureFellowShipCharacterAccessByNameWorksGivenCorrectNameIsGiven() {
		TolkeinCharacter fellowShipCharacter = dataService.getFellowShipCharacter("Frodo");
		Assertions.assertEquals("Frodo", fellowShipCharacter.getName());
	}

	@Test
	void ensureThatFrodoAndGandalfArePartOfTheFellowship() {
		List<TolkeinCharacter> fellowship = dataService.getFellowShip();
		TolkeinCharacter frodo = dataService.getFellowShipCharacter("Frodo");
		TolkeinCharacter gandalf = dataService.getFellowShipCharacter("Gandalf");

		Assertions.assertTrue(fellowship.contains(frodo));
		Assertions.assertTrue(fellowship.contains(gandalf));
	}

	@Test
	void ensureThatOneRingBearerIsPartOfTheFellowship() {
		List<TolkeinCharacter> fellowship = dataService.getFellowShip();
		// todo check that at least one ring bearer is part of the fellowship
		Map<Ring, TolkeinCharacter> ringBearers = dataService.getRingBearers();
		Assertions.assertTrue(ringBearers.values().stream().anyMatch(ringBearersvalues -> fellowship.contains(ringBearersvalues)));
	}

	@RepeatedTest(1000)
	@Tag("slow")
	@DisplayName("Minimal stress testing: run this test 10000 times")
	void ensureThatWeCanRetrieveFellowshipMultipleTimes() {
		dataService = new DataService();
		assertNotNull(dataService.getFellowShip());
	}

	@Test
	void ensureOrdering() {
		List<TolkeinCharacter> fellowship = dataService.getFellowShip();
		// Ensure that the order of the fellowship is:
		// frodo, sam, merry,pippin, gandalf,legolas,gimli,aragorn,boromir
		Assertions.assertEquals( dataService.getFellowShipCharacter("Frodo"),fellowship.get(0));
		Assertions.assertEquals( dataService.getFellowShipCharacter("Sam"),fellowship.get(1));
		Assertions.assertEquals( dataService.getFellowShipCharacter("Merry"),fellowship.get(2));
		Assertions.assertEquals( dataService.getFellowShipCharacter("Pippin"),fellowship.get(3));
		Assertions.assertEquals( dataService.getFellowShipCharacter("Gandalf"),fellowship.get(4));
		Assertions.assertEquals( dataService.getFellowShipCharacter("Legolas"),fellowship.get(5));
		Assertions.assertEquals( dataService.getFellowShipCharacter("Gimli"),fellowship.get(6));
		Assertions.assertEquals( dataService.getFellowShipCharacter("Aragorn"),fellowship.get(7));
		Assertions.assertEquals( dataService.getFellowShipCharacter("Boromir"),fellowship.get(8));
		
	}

	@Test
	void ensureThatFellowsStayASmallGroup() {
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> dataService.getFellowShip().get(20));
	}
	
	@Test
	void ensureUpdateTakesNoMore3Sec() {
		Assertions.assertTimeout(ofSeconds(3), () -> dataService.update());
	}
	
	@Test
	void ensureUpdateTakesNoMore3SecWithResultAndWaitResult() {
		Boolean result = Assertions.assertTimeout(ofSeconds(3), () -> {return dataService.update();});
		Assertions.assertTrue( result);
	}

	@Test
	void ensureUpdateTakesNoMore3SecWithResultAndNoWaitResult() {
		Boolean result = Assertions.assertTimeoutPreemptively(ofSeconds(3), () -> {return dataService.update();});
		Assertions.assertTrue( result);
	}
}
