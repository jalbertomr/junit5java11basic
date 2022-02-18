package com.bext.junit5java11basic.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.bext.junit5java11basic.model.Race.DWARF;
import static com.bext.junit5java11basic.model.Race.ELF;
import static com.bext.junit5java11basic.model.Race.HOBBIT;
import static com.bext.junit5java11basic.model.Race.MAIA;
import static com.bext.junit5java11basic.model.Race.MAN;
import static com.bext.junit5java11basic.model.Race.ORC;

import com.bext.junit5java11basic.model.Movie;
import com.bext.junit5java11basic.model.Ring;
import com.bext.junit5java11basic.model.TolkeinCharacter;

public class DataService {
	 static final String ERROR_MESSAGE_EXAMPLE_FOR_ASSERTION = "{} assertion : {}\n";

		final TolkeinCharacter frodo = new TolkeinCharacter("Frodo", 33, HOBBIT);
		final TolkeinCharacter sam = new TolkeinCharacter("Sam", 38, HOBBIT);
		final TolkeinCharacter merry = new TolkeinCharacter("Merry", 36, HOBBIT);
		final TolkeinCharacter pippin = new TolkeinCharacter("Pippin", 28, HOBBIT);
		final TolkeinCharacter gandalf = new TolkeinCharacter("Gandalf", 2020, MAIA);
		final TolkeinCharacter gimli = new TolkeinCharacter("Gimli", 139, DWARF);
		final TolkeinCharacter legolas = new TolkeinCharacter("Legolas", 1000, ELF);
		final TolkeinCharacter aragorn = new TolkeinCharacter("Aragorn", 87, MAN);
		final TolkeinCharacter boromir = new TolkeinCharacter("Boromir", 37, MAN);
		final TolkeinCharacter sauron = new TolkeinCharacter("Sauron", 50000, MAIA);
		final TolkeinCharacter galadriel = new TolkeinCharacter("Galadriel", 3000, ELF);
		final TolkeinCharacter elrond = new TolkeinCharacter("Elrond", 3000, ELF);
		final TolkeinCharacter guruk = new TolkeinCharacter("Guruk", 20, ORC);
		final Movie theFellowshipOfTheRing = new Movie("the fellowship of the Ring", new Date(), "178 min");
		final Movie theTwoTowers = new Movie("the two Towers", new Date(), "179 min");
		final Movie theReturnOfTheKing = new Movie("the Return of the King", new Date(), "201 min");
		
	public List<TolkeinCharacter> getFellowShip(){
		final List<TolkeinCharacter> fellowshipOfTheRing = new ArrayList<>();
		fellowshipOfTheRing.add(frodo);
        fellowshipOfTheRing.add(sam);
        fellowshipOfTheRing.add(merry);
        fellowshipOfTheRing.add(pippin);
        fellowshipOfTheRing.add(gandalf);
        fellowshipOfTheRing.add(legolas);
        fellowshipOfTheRing.add(gimli);
        fellowshipOfTheRing.add(aragorn);
        fellowshipOfTheRing.add(boromir);
		return fellowshipOfTheRing;
	}
	
	public List<TolkeinCharacter> getOrcWithHobbitPrisoner(){
		final List<TolkeinCharacter> orcsWithHobbitPrisoners = new ArrayList<>();
		orcsWithHobbitPrisoners.add(guruk);
        orcsWithHobbitPrisoners.add(merry);
        orcsWithHobbitPrisoners.add(pippin);
		return orcsWithHobbitPrisoners;
	}
	
	public TolkeinCharacter getFellowShipCharacter(String name) {
		List<TolkeinCharacter> ringBearers = getFellowShip();
		return ringBearers.stream().filter(s -> s.equals(name)).findFirst().get();
	}
	
	public Map<Ring, TolkeinCharacter> getRingBearers(){
		Map<Ring,TolkeinCharacter> ringBearers = new HashMap<>();
		ringBearers.put(Ring.nenya, galadriel);
        ringBearers.put(Ring.narya, gandalf);
        ringBearers.put(Ring.vilya, elrond);
        ringBearers.put(Ring.oneRing, frodo);
		return ringBearers;
	}
}
