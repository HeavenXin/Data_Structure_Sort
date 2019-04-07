package sorteselection;
/**
 *
 * @author Heaven
 *	基本的选择排序的实现,每次交换两个元素,然后排序后就不需要去烦恼了
 *	第一遍我们找到最小的,然后每次进行循环
 */
public class SorteSelection {
	public static void sort(Comparable[] a) {//进行排序的方法
		for (int i = 0; i < a.length; i++) {
			int min =i;//当前最小元素的索引
			for (int j = i + 1; j < a.length; j++) {
				if (less(a[j], a[min])) {//进行min和i+1(j)的比较;
					min = j;//遍历一遍
				}
			}
			exch(a, i, min);//进行交换
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
}
