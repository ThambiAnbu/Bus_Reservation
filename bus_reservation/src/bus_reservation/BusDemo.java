package bus_reservation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class BusDemo {
	static Scanner s= new Scanner(System.in);
	public static void main(String[] args)  {
		System.out.println("\t\t\twelcome to Anbulakshmi Bus Servises\n Available Buses Listed Below");
		
	
		
		BusDAO busdao=new BusDAO();
		try {
			busdao.displayBusInfo();
			
			int userOpt=1;
			while(userOpt==1){
				System.out.println("Enter 1 to Book and 2 to Exit");
				userOpt=s.nextInt();
				if(userOpt==1) {
					Booking booking=new Booking();
					if(booking.isAvailable()) {
						BookingDAO bookingdao=new BookingDAO();
						bookingdao.addBooking(booking);
						System.out.println("your tickest booking Succesfully..");
					}else {
						System.out.println("ticket not available try another bus");
					}
				
				}
			}
			System.out.println("Thank you for visiting");
			s.close();
			
	}catch(Exception e) {
		e.printStackTrace();
	}
	}

}
