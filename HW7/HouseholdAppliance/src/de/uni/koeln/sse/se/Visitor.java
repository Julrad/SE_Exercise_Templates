package de.uni.koeln.sse.se;

public interface Visitor {
	void visitGlass(Glass g);
	void visitFurniture(Furniture f);
	void visitElectronic(Electronic e);
}
