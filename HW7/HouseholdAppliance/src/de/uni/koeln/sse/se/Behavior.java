package de.uni.koeln.sse.se;

import java.util.List;

public class Behavior implements Visitor{
	private double price;
	private String instruction;
	
	public void behavior(List<HouseholdItem> namesList) {
		for (HouseholdItem item : namesList) {
			item.accept(this);
		}
	}
	
	public void visitGlass(Glass g) {
		switch(g.tickness) {
		case 1:
			price = 2;
			break;
		case 2:
			price = 1.2;
			break;
		case 3:
			price = 0.7;
			break;	
		}
		price = price * g.lenght;
		System.out.println("Total Cost for "+g.name+" is: "+price+" Euros.");
		instruction = ">should be wrapped with Bubble wraps and packed in a box with dimension: "+(g.lenght+1)+"x"+(g.width+1)+"x"+(g.height+1);
		System.out.println(instruction);
	}
	public void visitFurniture(Furniture f) {
		price = 5*(f.weight % 20);
		System.out.println("Total Cost for "+f.name+" is: "+price+" Euros.");
		instruction = ">should be covered with waterproof covers with area of: "+(f.lenght)+"x"+(f.width)+"x"+(f.height);
		System.out.println(instruction);
	}
	public void visitElectronic(Electronic e) {
		if (e.fragile) {
			price = 5*(e.weight % 10);
		}else if(!(e.fragile)) {
			price = 5*(e.weight % 15);
		}
		System.out.println("Total Cost for "+e.name+" is: "+price+" Euros.");
		instruction = ">should be covered with Polyethylene foam film and packed in a box with dimension "+(e.lenght+1)+"x"+(e.width+1)+"x"+(e.height+1);
		System.out.println(instruction);
	}
}
