package Priority_Queue;
/**
 * 
 * @author Heaven
 *
 * 	此方法是使用了堆对数组进行排序
 * 	修改了sink方法,添加了个新数组
 * 	
 */
public class Priority_Queue_Sort<Key extends Comparable<Key>> {
	private static int N = 0;//设置长度
	private static Comparable[] pq ;//输出的数组
	private static int count = 0;//设置添加的元素
	public static Comparable[] sort(Comparable[] a) {
		int N = a.length;
		pq = new Comparable[N] ;
		for (int k = N/2; k >= 1; k--) {//从中间开始往前下沉
			Sink(a,k,N);
		}
		while (N>1) {//堆排序完成后进行输出
			Comparable x=exch(a,1,N--);
			pq[count++] = x;
			Sink(a,1,N);
		}
		return pq;
	}
	private static Comparable exch(Comparable[] a,int j,int k) {
		Object n = a[j];
		a[j] = a[k];
		a[k] = (Comparable<Object>) n;
		return (Comparable) n;
	}
	private static void Sink(Comparable[] a,int j,int k) {
		while (2*j<=k) {//子节点小于数组
			int i= 2*j;
			if (i<N &&less(pq[i], pq[i+1])) {//只要不溢出且比子节点小
				i++;//加大索引
			}
			while (!less(pq[j], pq[i]))
				break;//如果大于则退出
			exch(pq, j, i);//交换
			j = i;//然后递归
		}
	}
	private static boolean less(Comparable a, Comparable a2) {// 对元素进行比较
		return a.compareTo(a2) < 0;
	}

	
}
