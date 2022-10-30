package de.uni.koeln.se.state;


public class Elevator{
	
	public static int current_Floor=5;
	int dest_Floor;
	
	private Elv_States State = new Elv_States();
	
	public Elevator (int dest_floor)
	{
	this.dest_Floor=dest_floor;
	System.out.println("*** Destination floor is: "+ dest_Floor);
	
	State.Current_State = State.Idle;
	
	if(current_Floor < dest_Floor) {
		go_up();
	}
	if(current_Floor > dest_Floor) {
		go_down();
	}
	if((current_Floor == dest_Floor)&(State.Current_State == State.Idle)) {
		arrive_atFloor();
	}
	}

	private void arrive_atFloor() {
		System.out.println("You arrived at your destination: Floor " + current_Floor);
	}
	private void go_up() {
		State.Current_State = State.Moving_up;
		current_Floor = current_Floor+1;
		System.out.println(State.Current_State+" towards "+current_Floor+" Floor");
		if(current_Floor == dest_Floor) {
			State.Current_State = State.Idle;
		}else {
			go_up();
		}
	}
	private void go_down() {
		State.Current_State = State.Moving_down;
		current_Floor = current_Floor-1;
		System.out.println(State.Current_State+" towards "+current_Floor+" Floor");
		if(current_Floor == dest_Floor) {
			State.Current_State = State.Idle;
		}else {
			go_down();
		}
	}
	

	
}
