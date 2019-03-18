package Merge;

/**
 * 
 * @author Heaven 自下而上的归序算法,先从小组开始,然后小变大,直到排序完成
 */
public class Merge04 {
	private static Comparable[] aux;	

	public static void sort(Comparable[] a) {
		int N = a.length;// 获取数量
		aux = new Comparable[N];
		for (int num = 1; num < N; num += num) {// 子数组大小
			for (int i = 0; i < N - num; i += num + num) {// 进行排序,间隔为一个数组
				merge(a, i, i + num - 1, Math.min(i + num + num - 1, N - 1));
			}
		}
	}

	public static void merge(Comparable[] a,int x, int mid ,int y) {//进行排序的方法
		int N = x;
		int M = mid+1;//设置分段
		for (int i = x; i <= y; i++) {
			aux[i] = a[i];//进行复制
		}
		for (int i = x; i <= y; i++) {//进行排序
			if (N>mid) 
				a[i] = aux[M++];//如果左边的数组已经消耗殆尽,则加入右边的
			else if (M>y)
				a[i] = aux[N++];//同样如果右边的数组已经消耗完,则加入左边的
			else if (less(aux[M],aux[N])) 
				a[i] = aux[M++];
			else {
				a[i] = aux[N++];
			}
		}
		
	}

	public static boolean less(Comparable a, Comparable a2) {// 对元素进行比较
		return a.compareTo(a2) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {// 进行交换
		Object n = a[i];
		a[i] = a[j];
		a[j] = (Comparable<Object>) n;
	}

	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i] + " ");
		} // 进行输出
	}

	public static boolean isSorted(Comparable[] a) {// 测试是否排序
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Integer[] a = new Integer[500];
		for (int j = 0; j < 500; j++) {
			a[j] = (int) (Math.random() * 100);// 随机添加随机数
		}
		sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
