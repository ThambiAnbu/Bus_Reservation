package bus_reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class BookingDAO {

	public int getBookedCount(int busNo, Date date) throws SQLException {
		String query="select count(passenger_name) from booking where bus_no=? and travel_date=?";
		
		Connection con=DbConnection.getConnection();
		PreparedStatement st=con.prepareStatement(query);
		
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		
		st.setInt(1, busNo);
		st.setDate(2, sqlDate);
		
		ResultSet res=st.executeQuery();
		res.next();

		return res.getInt(1);
		
	}

	public void addBooking(Booking booking) throws SQLException {
		String query="INSERT into booking VALUES(?,?,?)";
		Connection con=DbConnection.getConnection();
		
		java.sql.Date sqlDate=new java.sql.Date(booking.date.getTime());
		PreparedStatement ste=con.prepareStatement(query);

		ste.setString(1, booking.PassengerName);
		ste.setInt(2, booking.BusNo);
		ste.setDate(3, sqlDate);
		
		ste.executeUpdate();
		
		
		
		
	}
	

}
