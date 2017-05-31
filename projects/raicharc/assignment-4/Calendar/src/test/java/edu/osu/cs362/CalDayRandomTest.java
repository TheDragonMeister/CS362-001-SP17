package edu.osu.cs362;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayRandomTest {

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;


	public static Appt generateRandomAppt(Random random) {
		int startHour = (int) ValuesGenerator.getRandomIntBetween(random, -100, 100);
		int startMinute = (int) ValuesGenerator.getRandomIntBetween(random, -100, 100);
		int startDay = (int) ValuesGenerator.getRandomIntBetween(random, -100, 100);
		int startMonth = (int) ValuesGenerator.getRandomIntBetween(random, -100, 100);
		int startYear = (int) ValuesGenerator.getRandomIntBetween(random, 0, 2500);
		String title = "Soccer Tournment";
		String description = "Cant lose the soccer tournemnt must play hard";


		Appt appt = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);

		return appt;
	}
	public static GregorianCalendar generateGregCal(Random random) {
		int year = (int) ValuesGenerator.getRandomIntBetween(random, 0, 2500);
		int month = (int) ValuesGenerator.getRandomIntBetween(random, 1, 12);
		int day = (int) ValuesGenerator.getRandomIntBetween(random, 1, 31);
		int hour = (int) ValuesGenerator.getRandomIntBetween(random, 0, 23);
		int minute = (int) ValuesGenerator.getRandomIntBetween(random, 0, 59);
		int second = (int) ValuesGenerator.getRandomIntBetween(random, 0, 59);

		GregorianCalendar newCal = new GregorianCalendar(year, month, day, hour, minute, second);

		return newCal;
	}


	@Test
	public void randomtest()  throws Throwable  {

		long start = Calendar.getInstance().getTimeInMillis();
		long timePassed = Calendar.getInstance().getTimeInMillis() - start;

		System.out.println("Start testing...");

		for (int iteration = 0; timePassed < TestTimeout; iteration++) {
			long randomseed = 10;
			Random random = new Random(randomseed);

			GregorianCalendar gregCal = generateGregCal(random);
			CalDay cal = new CalDay(gregCal);

			int apptsSize = (int) ValuesGenerator.getRandomIntBetween(random, 0, 5);

			for (int i = 0; i < NUM_TESTS; i++) {
				for (int j = 0; j < apptsSize; j++) {
					Appt temp = generateRandomAppt(random);
					cal.addAppt(temp);
				}
			}


			timePassed = (Calendar.getInstance().getTimeInMillis() - start);
			if((iteration%10000)==0 && iteration!=0)
				System.out.println("passed time: "+ timePassed + " of "+TestTimeout);
		}

		System.out.println("Done testing...");
	}
}