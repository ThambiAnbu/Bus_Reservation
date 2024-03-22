package bus_reservation;

import java.util.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Booking {
	String PassengerName;
	int BusNo;
	Date date;
	
	Booking(){
		Scanner s=new Scanner(System.in);
		System.out.println("enter your Name");
		PassengerName=s.next();
		System.out.println("enter BusNo");
		BusNo=s.nextInt();
		System.out.println("enter Date on this formate dd-mm-yyyy");
		String inputDate=s.next();
		SimpleDateFormat dateFormate=new SimpleDateFormat("dd-MM-yyyy");
		try {
			date=dateFormate.parse(inputDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public boolean isAvailable()throws SQLException{
		
		BusDAO busdao=new BusDAO();
		BookingDAO bookingdao= new BookingDAO();
		
		int capacity=busdao.getCapacity(BusNo);
		
		int booked=bookingdao.getBookedCount(BusNo,date);
		
		return booked<capacity;
		
	}


}
