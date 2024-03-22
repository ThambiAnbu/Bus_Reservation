package bus_reservation;

public class Bus {
	int busNo;
	boolean ac;
	int capacity;
	
	Bus(int no,boolean ac,int cap){
		busNo=no;
		this.ac=ac;
		capacity=cap;
	}

	public boolean isAc() {
		return ac;
	}

	public void setAc(boolean ac) {
		this.ac = ac;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getBusNo() {
		return busNo;
	}

	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}
	

}
