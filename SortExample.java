package sortexample;
/**
 * 
 * @author Heaven
 *	此为一个模板,是为了接下来各类排序算法的API模板
 */
public class SortExample {
	public static void sort(Comparable[] a) {//进行排序的方法
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
	
}
