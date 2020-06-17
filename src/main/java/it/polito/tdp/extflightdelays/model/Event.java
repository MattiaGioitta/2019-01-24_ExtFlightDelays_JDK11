package it.polito.tdp.extflightdelays.model;

public class Event implements Comparable<Event>{

	private int g;
	private String nameState;
	/**
	 * @param g
	 * @param nameState
	 */
	public Event(int g, String nameState) {
		super();
		this.g = g;
		this.nameState = nameState;
	}
	/**
	 * @return the nameState
	 */
	public String getNameState() {
		return nameState;
	}
	/**
	 * @param nameState the nameState to set
	 */
	public void setNameState(String nameState) {
		this.nameState = nameState;
	}
	/**
	 * @return the g
	 */
	public int getG() {
		return g;
	}
	@Override
	public int compareTo(Event o) {
		// TODO Auto-generated method stub
		return this.g-o.g;
	}
	
	
	
	
}
