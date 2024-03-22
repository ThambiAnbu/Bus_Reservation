package bus_reservation;

import java.sql.*;

public class BusDAO {
	public void displayBusInfo() throws SQLException{
		String query="select * from bus";
		Connection con=DbConnection.getConnection();
		Statement st=con.createStatement();
		ResultSet res=st.executeQuery(query);
		
		while(res.next()) {
			System.out.println("Bus Number  :"+res.getInt(1));
			if(res.getInt(2)==0) {
				System.out.println("AC Availability  : NO");
			}else {
				System.out.println("AC Availability  : YES");
			}
			System.out.println("Bus Capacity  :"+res.getInt(3));
		}
		System.out.println("-----***-----");
	}
	public int getCapacity(int id) throws SQLException{
		String query="select capacity from bus where id="+id;
		Connection con=DbConnection.getConnection();
		Statement st=con.createStatement();
		ResultSet res=st.executeQuery(query);
		res.next();
		
		return res.getInt(1);
		
	}

}
