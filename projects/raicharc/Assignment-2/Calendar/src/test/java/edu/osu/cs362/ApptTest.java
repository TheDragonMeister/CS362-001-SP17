package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class ApptTest {

	int startHour = 13;
	int startMinute = 30;
	int startDay = 1;
	int startMonth = 4;
	int startYear = 2010;
	String title = "B-day";
	String description = "Party";
	Appt holder = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

	// this tests if all the get functions work properly
	@Test
	public void test0() throws Exception {
		assertEquals(13,holder.getStartHour());
		assertEquals(30,holder.getStartMinute());
		assertEquals(1,holder.getStartDay());
		assertEquals(4,holder.getStartMonth());
		assertEquals(2010,holder.getStartYear());
		assertEquals("B-day",holder.getTitle());
		assertEquals("Party",holder.getDescription());
		assertTrue(holder.getValid());
	}

	//this checks if the set functions are working correctly
	@Test
	public void test02()	throws Throwable	{
		holder.setStartHour(13);
			assertTrue(holder.getValid());
		holder.setStartMinute(25);
			assertTrue(holder.getValid());
		holder.setStartDay(8);
			assertTrue(holder.getValid());
		holder.setStartMonth(6);
			assertTrue(holder.getValid());
		holder.setStartYear(2011);
			assertTrue(holder.getValid());
		holder.setTitle(null);
			assertEquals("", holder.getTitle());
		holder.setTitle("Jog");
			assertEquals("Jog", holder.getTitle());
		holder.setDescription(null);
			assertEquals("", holder.getDescription());
		holder.setDescription("dying painfully");
			assertEquals("dying painfully", holder.getDescription());
	}

	/* this test is to find out if the isValid() method can actually work */
	@Test
	public void test03()	throws Throwable	{
		holder.setStartMonth(14);
			assertFalse(holder.getValid());
		holder.setStartMonth(0);
			assertFalse(holder.getValid());

		holder.setStartDay(35);
			assertFalse(holder.getValid());
		holder.setStartDay(0);
			assertFalse(holder.getValid());

		holder.setStartMinute(60);
			assertFalse(holder.getValid());
		holder.setStartMinute(-1);
			assertFalse(holder.getValid());

		holder.setStartHour(24);
			assertFalse(holder.getValid());
		holder.setStartHour(-1);
			assertFalse(holder.getValid());
	}

	/*  this test makes sure that the toString()method will output the correct information*/
	@Test
	public void test04()	throws Throwable	{
		assertTrue(holder.getValid());
		assertEquals(holder.toString(), ("\t" + holder.getStartMonth()+ "/" +holder.getStartDay()+"/"+holder.getStartYear() + " at " + 1 + ":" + holder.getStartMinute() + "pm" + " ," + holder.getTitle() + ", " + holder.getDescription() + "\n"));
	}

	
}
