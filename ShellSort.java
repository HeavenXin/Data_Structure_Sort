package ShellSort;
/**
 * 
 * @author Heaven
 *	这是希尔排序的实现,理解较难,画图比较好
 */
public class ShellSort {
	public static void sort(Comparable[] a) {//进行排序的方法
		int N = a.length;//得到所有的个数
		int h = 1;//初始化希尔值
		while (h<N/3) 
			h = 3*h +1;//保证不超过的情况获取最合适的希尔值,1,4,13
		while(h>1) {
			for (int i = h; i < N; i++) {//一层遍历由N开始
				for (int j = i; j >= h && less(a[j], a[j-h]); j-=h) {
					//查找数组前面的希尔值,然后判断是否需要交换
					exch(a, j, j-h);
				}
			}
			h =h/3;//然后进行更深的排序,h更小;
		}
	}
	public static boolean less(Comparable a,Comparable a2) {//对元素进行比较
		return a.compareTo(a2) < 0;
	}
	private static void exch(Comparable[] a,int i,int j) {//进行交换
		Object n =a[i];
		a[i] = a[j];
		a[j] = (Comparable<Object>) n;
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
	public static void main(String[] args) {
		Double[] a = new Double[500];
		for (int j = 0; j < 500; j++) {
			a[j] = Math.random();//随机添加随机数
		}
		sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
