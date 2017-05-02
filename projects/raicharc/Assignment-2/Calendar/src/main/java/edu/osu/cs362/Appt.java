package edu.osu.cs362;
public class Appt {
    private boolean valid;
    private int startHour;
    private int startMinute;
    private int startDay;
    private int startMonth;
    private int startYear;
    private String title;
    private String description;
    public Appt(int startHour, int startMinute, 
            int startDay, int startMonth, int startYear,String title, String description)
    {
        //Sets all instance variables 
    	this.startHour = startHour;
    	this.startMinute = startMinute; 
    	this.startDay = startDay; 
    	this.startMonth = startMonth;
    	this.startYear = startYear; 
        setTitle(title);
        setDescription(description);
        isValid();
    }
    private void isValid() {
    	if(startHour<0 || startHour>23)
    		this.valid=false;
    	else
        	if(startMinute<0 || startMinute>59)
        		this.valid=false;
        	else
            	if(startDay<1 || startDay>31)
            		this.valid=false;
            	else
                	if(startMonth<1 || startMonth>12)
                		this.valid=false;
                	else
                		this.valid=true;
    }
    public void setStartHour(int startHour) {
    	this.startHour = startHour;
    	 isValid();
    }
    public void setStartMinute(int startMinute) {   	
        this.startMinute = startMinute;
        isValid();
    }
    public void setStartDay(int startDay) {
        this.startDay = startDay;
        isValid();
    }
    public void setStartMonth(int startMonth) {
        this.startMonth = startMonth;
        isValid();
    }
    public void setStartYear(int startYear) {
        this.startYear = startYear;
        isValid();
    }
    public void setTitle(String title) {
        if (title == null) 
            this.title = "";
        else
            this.title = title;
    }
    public void setDescription(String description) {
        if (description == null)
            this.description = "";
        else
            this.description = description;
    }
    public int getStartHour() {
        return startHour;
    }
    public int getStartMinute() {
        return startMinute;
    }
    public int getStartDay() {
        return startDay;
    }
    public int getStartMonth() {
        return startMonth;
    }
    public int getStartYear() {
        return startYear;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public boolean getValid() {
        return this.valid;
    }
    public String toString()
    {
		if (!getValid()) {
		    return null;
		}
        String half = (getStartHour() > 11) ? "pm" : "am";
        int printableHour = getStartHour();
        if (printableHour > 11)
        {
            printableHour -= 12;
        }
        if (printableHour == 0)
        {
            printableHour = 12;
        }
        String day= this.getStartMonth()+"/"+this.getStartDay()+"/"+this.getStartYear() + " at ";
        return "\t"+ day +   printableHour +":"+ getStartMinute() + half + " ," +  getTitle()+ ", "+  getDescription()+"\n";
    }
}
