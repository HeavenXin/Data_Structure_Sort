package Accmulator;
//一个简易的累加器
public class Accmulator {
	private double val;
	private int N;
	//实现了累加
	public void addin(double val1) {
		N++;
		val += val1;
	}
	public double mean() {
		return val/N;
	}
	public String toString() {
		return "Val = "+val +"N=" + N;
	}
}
