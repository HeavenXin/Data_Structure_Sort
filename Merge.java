package Merge;

/**
 * 
 * @author Heaven
 *	基于原地归序的数组,是一种递归归并的手段,当然其缺点很明显,需要创建多个额外小数组
 */
public class Merge {
	private static Comparable[] aux;//复制数组
	public static void sort(Comparable[] a) {//进行排序方法1
		aux = new Comparable[a.length];
		sort(a,0,a.length-1);
	}
	private static void sort(Comparable[] a,int x,int y) {
		// 重载上面方法
		if (x>=y) //!!!!!因为大于小于没看清楚,查了半天!!!
			return;//判断是否达到了尽头
		int mid = x+(y-x)/2;//获取数组中间数
		sort(a, x, mid);//左半边递归排序
		sort(a, mid+1, y);//右半边递归排序
		merge(a,x,mid,y);//最后总和
		
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
	public static void main(String[] args) {//验证是否正确
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
