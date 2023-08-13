//Ian Pompliano and Rakshit Sridhar
import java.util.*;

public class Reservation {
	private String name;
	private String phoneNumber;
	private String dietaryRestrictions;
	private String date;
	private int time;
	private int partySize;

	public Reservation(String name, String phoneNumber, String dietaryRestrictions, String date, int time, int partySize) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.dietaryRestrictions = dietaryRestrictions;
		this.date = date;
		this.time = time;
		this.partySize = partySize;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDietaryRestrictions() {
		return dietaryRestrictions;
	}

	public void setDietaryRestrictions(String dietaryRestrictions) {
		this.dietaryRestrictions = dietaryRestrictions;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getPartySize() {
		return partySize;
	}

	public void setPartySize(int partySize) {
		this.partySize = partySize;
	}
}
