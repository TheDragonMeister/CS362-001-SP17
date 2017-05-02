package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.*;

import org.junit.Test;

import static org.junit.Assert.*;


public class CalDayTest {
	GregorianCalendar cal = new GregorianCalendar(2010, 4, 10, 13, 30, 0);
	CalDay holder = new CalDay(cal);

	/* The test number 01 is to ensure that the constructor and methods
	 within Cal Day Test are working properly.*/
	@Test
	public void test01()	throws Throwable  {
		holder = new CalDay();
		assertFalse(holder.isValid());

		holder = new CalDay(cal);
		assertTrue(holder.isValid());
	}

	@Test
	public void getAppts() throws Exception {
		assertTrue(holder.getAppts() != null);
	}

	@Test
	public void getSizeAppts() throws Exception {
		assertEquals(holder.getSizeAppts(),0);
	}

	@Test
	public void getDay() throws Exception {
		assertEquals(holder.getDay(), 10);
	}

	@Test
	public void getMonth() throws Exception {
		assertEquals( holder.getMonth(),4);
	}

	@Test
	public void getYear() throws Exception {
		assertEquals( holder.getYear(),2010);
	}

	/* This test is adding appointments to the list and checking to make
	 * sure that the list is the correct length */
	@Test
	public void test03()	throws Throwable {
		// Adds a valid appointment
		holder.addAppt(new Appt(19, 30, 30, 4, 2017, "b-day", "PARTY"));
		assertEquals(1, holder.getSizeAppts());

		// Adds a second valid appointment
		holder.addAppt(new Appt(20, 30, 30, 4, 2017, "presents", "Open and enjoy"));
		assertEquals(2, holder.getSizeAppts());

		// Adds a third valid appointment
		holder.addAppt(new Appt(15, 30, 30, 4, 2017, "clean", "Have the house cleaned"));
		assertEquals(3, holder.getSizeAppts());

		// Adds a bad appointment
		holder.addAppt(new Appt(0, 0, 0, 0, 0, null, null));
		assertEquals(3, holder.getSizeAppts());

	}

	/* This test is checking if the method toString() Works as wanted */
	@Test
	public void test04()	throws Throwable {
		holder = new CalDay();
		assertEquals("", holder.toString());

		holder = new CalDay(cal);
		holder.addAppt(new Appt(11, 30, 10, 4, 2010, "jog", "be in pain"));
		holder.addAppt(new Appt(13, 30, 10, 4, 2010, "jog more", "be in pain more"));
		assertTrue(holder.toString() != "");
	}

	/* This test is checking if the method iterator() is working*/
	@Test
	public void test05()	throws Throwable {
		assertTrue(holder.iterator() != null);

		holder = new CalDay();
		assertTrue(holder.iterator() == null);
	}
}
