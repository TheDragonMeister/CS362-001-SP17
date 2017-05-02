package edu.osu.cs362;
import java.util.*;
public class CalDay {
	LinkedList<Appt> appts;
	boolean valid;
	int day;
	int month;
	int year;
	public CalDay() {
		valid = false;
	}
	public CalDay(GregorianCalendar cal) {
		int day = cal.get(cal.DAY_OF_MONTH);
		int month = cal.get(cal.MONTH);
		int year = cal.get(cal.YEAR);
		setDay(day);
		setMonth(month);
		setYear(year);
		setAppts(new LinkedList<Appt>());
		valid = true;
	}
	public void addAppt(Appt appt) {
		if (appt.getValid()) {
			for (int i = 0; i < getAppts().size(); i++) {
				//Put the appointment in the correct order - finish this
				if (((Appt)getAppts().get(i)).getStartHour() >
										appt.getStartHour()) {
					getAppts().add(i, appt);
					return;
				}
			}
		    getAppts().add(appt);
		}
	}
	public boolean isValid() {
	    return valid;
	}
	public Iterator<?> iterator() {
	    if (isValid()) {
	        return getAppts().iterator();
	    }
	    else {
	        return null;
	    }
	}
	private void setAppts(LinkedList<Appt> appts) {
		if(appts!=null)
				this.appts = appts;
		if(appts!=null&&appts.size()==0)
			this.appts = appts;
	}
	private void setDay(int day) {
	    this.day = day;
	}
	private void setMonth(int month) {
	    this.month = month;
	}
	private void setYear(int year) {
	    this.year = year;
	}
	public LinkedList<Appt> getAppts() {
	    return appts;
	}
	public int getSizeAppts() {
	    return appts.size();
	}
	public int getDay() {
	    return day;
	}
	public int getMonth() {
	    return month;
	}
	public int getYear() {
	    return year;
	}
	public String toString() {
	     StringBuilder sb = new StringBuilder();
		if (isValid()) {
			String todayDate = (getMonth()) + "/" + getDay() + "/" + getYear();
			sb.append("\t --- " + todayDate + " --- \n");
			sb.append(" --- -------- Appointments ------------ --- \n");
			Iterator<Appt> itr = this.appts.iterator();
		    while(itr.hasNext()) {
		         Object element = itr.next();
		         
		         sb.append(element + " ");
		      }
			sb.append("\n");
		}
       	 return sb.toString();
	}
}