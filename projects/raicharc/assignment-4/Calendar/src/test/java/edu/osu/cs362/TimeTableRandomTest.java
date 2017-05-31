package edu.osu.cs362;

import java.util.Calendar;
import java.util.Random;
import java.util.*;
import java.util.GregorianCalendar;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {

	private static final long TestTimeout = 60 * 500 * 1;


	@Test
	public void radnomtest()  throws Throwable  {


		long start = Calendar.getInstance().getTimeInMillis();
		long timePassed = Calendar.getInstance().getTimeInMillis() - start;


		System.out.println("Start testing...");

		for (int iteration = 0; timePassed < TestTimeout; iteration++) {
			long randomseed = 10;//System.currentTimeMillis();
			//			System.out.println(" Seed:"+randomseed );
			Random random = new Random(randomseed);


			TimeTable table = new TimeTable();
			GregorianCalendar gCal = new GregorianCalendar();
			CalDay cal = new CalDay(gCal);
			int startHour = ValuesGenerator.getRandomIntBetween(random, 0, 23);
			int startMinute = ValuesGenerator.getRandomIntBetween(random, 0, 59);
			int startDay = ValuesGenerator.getRandomIntBetween(random, 1, 31);
			int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 12);
			int startYear = 2017;
			String title = "Soccer Tournment";
			String description = "Cant lose the soccer tournemnt must play hard";
			Appt appt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
			Appt appt2 = new Appt(startHour + 1, startMinute + 1, startDay + 1, startMonth + 1, startYear + 1, title, description);
			Appt appt3 = new Appt(startHour - 1, startMinute - 1, startDay - 1, startMonth - 1, startYear - 1, title, description);
			LinkedList<Appt> apptList = new LinkedList<Appt>();
			apptList.push(appt1);
			apptList.push(appt2);
			apptList.push(appt3);

			table.deleteAppt(apptList, appt2);

			timePassed = (Calendar.getInstance().getTimeInMillis() - start);
			if((iteration%10000)==0 && iteration!=0 )
				System.out.println("elapsed time: "+ timePassed + " of "+TestTimeout);


		}

		long randomseed = 10;
		Random random = new Random(randomseed);

		TimeTable table = new TimeTable();
		table.deleteAppt(null, null);

		int startHour = ValuesGenerator.getRandomIntBetween(random, 1, 23);
		int startMinute = ValuesGenerator.getRandomIntBetween(random, 0, 59);
		int startDay = ValuesGenerator.getRandomIntBetween(random, 1, 31);
		int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 12);
		int startYear = 2016;

		Appt newAppt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear, "test 1", "test 1");

		Appt newAppt2 = new Appt(-15, -15, -15, -15, -15, "test 2", "test 2");

		Appt newAppt3 = new Appt(15,15 , 15, 15, 15, "test 3", "test 3");

		LinkedList<Appt> apptList = new LinkedList<Appt>();
		apptList.push(newAppt1);

		table.deleteAppt(apptList, null);

		table.deleteAppt(null, newAppt1);
		table.deleteAppt(apptList, newAppt2);

		LinkedList<Appt> apptList2 = new LinkedList<Appt>();
		apptList2.push(newAppt1);
		table.deleteAppt(apptList, newAppt3);

	}



}