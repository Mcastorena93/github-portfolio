package Project;

import java.util.GregorianCalendar;

import itec4261.Employee;

public class MyDate {
	//MyDate fields
	private int year;
	private int month;
	private int day;
	
	
	
	//no-args constructor that creates a MyDate object for the current date. 
	public MyDate() {
		
		GregorianCalendar calendar = new GregorianCalendar();
		
		day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
		month = calendar.get(GregorianCalendar.MONTH);
		year = calendar.get(GregorianCalendar.YEAR);
		
	}
	
	
	//constructor that creates a MyDate object with the specified year, month, date.
	public MyDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	
	}

	//getter and setter methods. 
	public int getDay() {
		return day;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public int getMonth() {
		return month + 1;
		
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getDate() {
		String date = (this.month +", " + this.day + ", " + this.year);
		return date;
	}
}
