package BubbleSort;
/**
 * 
 * @author Heaven
 *	最简单的冒泡排序,其运算即为两重for循环,然后比较两边的大小进行交换
 */
public class BubbleSort {
	public static void sort(Comparable[] a) {//进行排序的方法
		int N =a.length;
		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j < N-i-1; j++) {
				if (less(a[j], a[j+1])) {
					exch(a, j, j+1);
				}
			}
		}
	}
	public static boolean less(Comparable a,Comparable a2) {//对元素进行比较
		return a.compareTo(a2) > 0;
	}
	private static void exch(Comparable[] a,int i,int j) {//进行交换
		Object n =a[i];
		a[i] = a[j];
		a[j] = (Comparable<Object>)n;
	}
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]+" ");
		}//进行输出
	}
	public static boolean isSorted(Comparable[] a) {//测试是否排序
		for (int i = 1; i < a.length; i++) {
			if (less(a[i],a[i-1])) {
				return false;
			}
		}
		return true;
	}
	/*
	 * public static void main(String[] args) { Double[] a = new Double[500]; for
	 * (int j = 0; j < 500; j++) { a[j] = Math.random();//随机添加随机数 } sort(a); for
	 * (int i = 0; i < a.length; i++) { System.out.println(a[i]); } }
	 */
	
}
