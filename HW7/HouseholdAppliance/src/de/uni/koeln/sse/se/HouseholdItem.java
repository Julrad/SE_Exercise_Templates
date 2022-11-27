package de.uni.koeln.sse.se;

public interface HouseholdItem {
	public abstract void accept(Visitor v);
}
