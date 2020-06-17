package it.polito.tdp.extflightdelays.model;

public class Stato {
	
	private String  s;
	private int num;
	/**
	 * @param s
	 * @param num
	 */
	public Stato(String s, int num) {
		super();
		this.s = s;
		this.num = num;
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
	 * @return the num
	 */
	public int getNum() {
		return num;
	}
	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((s == null) ? 0 : s.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stato other = (Stato) obj;
		if (s == null) {
			if (other.s != null)
				return false;
		} else if (!s.equals(other.s))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Stato [s=" + s + ", num=" + num + "]";
	}
	
	

}
