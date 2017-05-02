package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {
	TimeTable holder = new TimeTable();
	//Testing the method of getApptRange
	@Test
	public void test01()  throws Throwable {
		//add three to the linked list
		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.addFirst(new Appt(15, 40, 20, 6, 2016, "school", "do school work"));
		appts.add(new Appt(11, 10, 30, 4, 2014, "jog", "pant for days"));
		appts.add(new Appt(13, 30, 1, 5, 2010, "B-day", "Party"));


		GregorianCalendar cal = new GregorianCalendar();
		GregorianCalendar cal2 = new GregorianCalendar();
		cal.set(2015, 5, 27);

		TimeTable holder = new TimeTable();
		holder.getApptRange(appts, cal, cal2);



	}

	// this test will check if the delete appt() method is workign properly
	@Test
	public void test02()	throws Throwable	{
		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.addFirst(new Appt(15, 40, 20, 6, 2016, "school", "do school work"));
		appts.add(new Appt(11, 10, 30, 4, 2014, "jog", "pant for days"));
		appts.add(new Appt(13, 30, 1, 5, 2010, "B-day", "Party"));


		//asserts try null values
		assertTrue(holder.deleteAppt(appts, null) == null);
		assertTrue(holder.deleteAppt(null,
				new Appt(13, 30, 1, 5, 2010, "B-day", "Party")) == null);

		assertTrue(holder.deleteAppt(appts,
				new Appt(15, 30, 30, 4, 2017, "Birthday", "Birthday Party!")) == null);

		// assert tries invalid values
		assertTrue(holder.deleteAppt(appts,
				new Appt(0, 0, 0, 0, 0, "", "")) == null);
	}


}
