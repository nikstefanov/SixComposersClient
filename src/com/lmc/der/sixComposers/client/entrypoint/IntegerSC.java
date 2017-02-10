package com.lmc.der.sixComposers.client.entrypoint;

public class IntegerSC {
	private int I;

	public IntegerSC() {I=0;}
	public IntegerSC(int i) {I=i;}
	public void set(int i) {I=i;}
	public int  get() {return I;}
	public void increase1() {I++;}
	public void decrease1() {I--;}
	public boolean isPositive(){return I>0;}
	public String toString() {return Integer.toString(I);}

}
