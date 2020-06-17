package it.polito.tdp.extflightdelays.model;

public class Vicino implements Comparable<Vicino>{
	
	private String s;
	private double peso;
	/**
	 * @param s
	 * @param peso
	 */
	public Vicino(String s, double peso) {
		super();
		this.s = s;
		this.peso = peso;
	}
	/**
	 * @return the s
	 */
	public String getS() {
		return s;
	}
	/**
	 * @param s the s to set
	 */
	public void setS(String s) {
		this.s = s;
	}
	/**
	 * @return the peso
	 */
	public double getPeso() {
		return peso;
	}
	/**
	 * @param peso the peso to set
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}
	@Override
	public int compareTo(Vicino o) {
		// TODO Auto-generated method stub
		return (int) (o.getPeso()-this.peso);
	}
	@Override
	public String toString() {
		return s + " peso=" + peso;
	}
	
	

}
