package SortCompare;

import java.util.Random;

import InsertSort.InsertSort;
import ShellSort.ShellSort;
import sorteselection.SorteSelection;

public class SortCompare {
	public static double time(String a, Double[] b) {
		long start = System.currentTimeMillis();// 测试时间
		if (a.equals("Insert")) InsertSort.sort(b);
		if (a.equals("Selection")) SorteSelection.sort(b);
		if (a.equals("Shell")) ShellSort.sort(b);
		//if (a.equals("Insert")) InsertSort.sort(b);	
		long now = System.currentTimeMillis();
		return (now - start) / 1000.0;
	}

	public static double timeRandomInput(String x,int N,int M) {//N为元素数量,M为测试次数
		double total = 0.0;
		Double[] a = new Double[N];
		for (int i = 0; i < M; i++) {//进行测试
			for (int j = 0; j < a.length; j++) {
				a[j] = Math.random();//随机添加随机数
			}
			total += time(x,a);
		}
		return total;
	}

	public static void main(String[] args) {
		String name = "Selection";
		String name2 = "Insert";
		String name3 = "Shell";
		int N = 5000 ;
		int M = 20;
		double time =timeRandomInput(name, N, M);
		double time2 = timeRandomInput(name2, N, M);
		double time3 = timeRandomInput(name3, N, M);
		System.out.println(time);
		System.out.println(time2);
		System.out.println(time3);
		System.out.println("差距为"+(time-time2)+"  "+(time2-time3));
	}
}
