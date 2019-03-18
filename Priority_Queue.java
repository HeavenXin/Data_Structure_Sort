package Priority_Queue;

/**
 * 
 * @author Heaven
 *	尝试使用无序数组完成优先队列
 */
public class Priority_Queue{
	private static int [] pq;
	private static int N = 0;
	private static int Number = 0;
	public static void MaxPQ() {
		pq =new int[++N];
		Number++;
	}
	public static void MaxPQ(int X) {
		N = X;

		pq =new int[X+1];
		Number++;
	}
	public static void MaxPQ(int[] a) {
		N =a.length+1;
		int [] temp =  new int [N] ;
		for (int i = 0; i < a.length; i++) {
			temp[i] = a[i];
		}
		pq =temp;
		Number++;
	}//三个构造结构
	public static void Insert(int X) {//插入一个元素
		int count =pq.length;//获取元素数量
		if (N==count) {
			int[] temp = new int[N+1];
			
			for (int i = 0; i < pq.length; i++) {
				temp[i] = pq[i];
			}
			N = N+1;//让N的数量增大
			pq = temp;
			Number++;
		}
		pq[count]= X;
	}
	public static int max() {
		int numMax = 0;
		for (int i = 0; i < pq.length; i++) {
			if(pq[i]>numMax)
				numMax =pq[i];
		}
		return  numMax;
	}
	public static int delmax() {
		int numMax = 0;
		int count = 0;
		for (int i = 0; i < pq.length; i++) {
			if(pq[i]>numMax)
				numMax =pq[i];
				count = i;
		}
		exch(pq,count,pq.length-1);
		pq[pq.length-1] =-1;
		return numMax;
	}
	public static boolean isEmpty() {
		return N==0;
	}
	public static int size() {
		return N-Number;//减2是因为,在开头创建数组时候+1,插入一次,加一次1
	}
	private static void exch(int[] a, int i, int j) {// 进行交换
		int n = a[i];
		a[i] = a[j];
		a[j] = n;
	}
	public static void main(String[] args) {
		int [] a = new int [10000];
		for (int j = 0; j < 10000; j++) {
			a[j] = (int) (Math.random()*10000);// 随机添加随机数
		}
		MaxPQ(a);
		Insert(15);
		int x =delmax();
		System.out.println(x);
		int  i = size();
		System.out.println(i);
	}
}
