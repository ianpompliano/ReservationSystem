//Ian Pompliano and Rakshit Sridhar
import java.util.*;

public class Schedule {
	public Reservation[] reservations;
	private int currentSize;

	public Schedule() {
		currentSize = 0;
		reservations = new Reservation[currentSize];
	}

	public void addReservation(String name, String phoneNumber, String dietaryRestrictions, String date, int time, int partySize) {
		Reservation newReservation = new Reservation(name, phoneNumber, dietaryRestrictions, date, time, partySize);
		Reservation[] copyReservations = new Reservation[currentSize + 1];
		
		for (int i=0; i < currentSize; i++) {
			copyReservations[i] = reservations[i];
		}
		copyReservations[currentSize] = newReservation;
		reservations = copyReservations;
		currentSize++;
		sortByDate();
	}

	public void cancelReservation(int index) {
		for (int i=0; i<currentSize; i++) {
			if (i == index) {
				reservations[i] = null;
				for (int j=i; j<currentSize-1; j++) {
					reservations[j] = reservations[j+1];
				}
				reservations[currentSize - 1] = null;
				currentSize--;
			}
		}

		Reservation[] copyReservations = new Reservation[currentSize];
		for (int i=0; i<currentSize; i++) {
			copyReservations[i] = reservations[i];
		}
		reservations = copyReservations;
	}

	public void editReservation(Reservation reservation, String name, String phoneNumber, String dietaryRestrictions, String date, int time, int partySize) {
		reservation.setName(name);
		reservation.setPhoneNumber(phoneNumber);
		reservation.setDietaryRestrictions(dietaryRestrictions);
		reservation.setDate(date);
		reservation.setTime(time);
		reservation.setPartySize(partySize);
	}

	// for search Reservations AND display Reservations
	public void sortByDate() {
	    Reservation[] sortedReservations = new Reservation[currentSize];

	    for (int i=0; i<currentSize; i++) {
	        String[] dateParts = reservations[i].getDate().split("/");
	        int month = Integer.parseInt(dateParts[0]);
	        int day = Integer.parseInt(dateParts[1]);
	        int year = Integer.parseInt(dateParts[2]);
	        int time = reservations[i].getTime();

	        int insertionIndex = 0;
	        for (int j=0; j<i; j++) {
	            String[] compareDateParts = reservations[j].getDate().split("/");
	            int compareMonth = Integer.parseInt(compareDateParts[0]);
	            int compareDay = Integer.parseInt(compareDateParts[1]);
	            int compareYear = Integer.parseInt(compareDateParts[2]);
	            int compareTime = reservations[j].getTime();

	            if (year < compareYear ||
	                (year == compareYear && month < compareMonth) ||
	                (year == compareYear && month == compareMonth && day < compareDay) ||
	                (year == compareYear && month == compareMonth && day == compareDay && time < compareTime)) {
	                break;
	            }
	            insertionIndex++;
	        }

	        for (int j=i; j>insertionIndex; j--) {
	            sortedReservations[j] = sortedReservations[j - 1];
	        }
	        sortedReservations[insertionIndex] = reservations[i];
	    }
	    reservations = sortedReservations;
	}

	//checks if reservation is a duplicate
	public boolean isDuplicate(String name, String phoneNumber, String dietaryRestrictions, String date, int time, int partySize) {
		for (int i=0; i<currentSize; i++) {
			String checkName = reservations[i].getName();
			String checkPhoneNumber = reservations[i].getPhoneNumber();
			String checkDietaryRestrictions = reservations[i].getDietaryRestrictions();
			String checkDate = reservations[i].getDate();
			int checkTime = reservations[i].getTime();
			int checkPartySize = reservations[i].getPartySize();

			if (name.equals(checkName) && 
				phoneNumber.equals(checkPhoneNumber) && 
				dietaryRestrictions.equals(checkDietaryRestrictions) && 
				date.equals(checkDate) && 
				time == checkTime && 
				partySize == checkPartySize) {

				return true;
			}
		}
		return false;
	}

	//checks if there are more than 3 reservations at the same time
	public boolean moreThanThree(String date, int time) {
		int counter = 0;
		for (int i=0; i<currentSize; i++) {
			String checkDate = reservations[i].getDate();
			int checkTime = reservations[i].getTime();

			if (date.equals(checkDate) && time == checkTime) {
				counter += 1;
			}
			if (counter >= 3) {
				return true;
			}
		}
		return false;
	}
}