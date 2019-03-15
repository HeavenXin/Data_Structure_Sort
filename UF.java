package UF;
/**
 * 
 * @author Heaven
 *	此方法为了研究触点问题,并开发出一套行之有效的API
 *这里我们把触点问题简化成int数据类型的问题;
 *此方法缺点:每次加连接都需要遍历
 *Tip:触点问题类似病毒式扩散,碰到即赋值,大型问题直接GG
 */
public class UF {
	private int [] id;
	private int count;//剩余分量的数量
	public UF(int N) {
		id = new int [N];//创建一个数组格式来存储触点
		count = N;
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}
	public int count() {//调查数字
		return  count;
	}
	public boolean connected(int p,int q) {//检测连接
		return (find(p)==find(q));
	}
	public int find(int p) { //查询所在标识符
		return id[p];
	}
	public void union(int p,int q) {//两者之间添加连接,请先确定两者是否连接
		int findP = find(p);
		int findQ = find(q);
		if (connected(p, q)) 
			return;
		for (int i = 0; i < id.length; i++) {
			if (id[i]==findP) {
				findQ = id[i];
				count--;
			}
		}
	}
	public static void main(String[] args) {//常见用例
		int N = 10;//设置输入
		UF uf =new UF(N);
		int count = uf.count;
		int p = 3;
		int q = 8;
		if (!uf.connected(p, q)) {
			uf.union(p, q);
			System.out.println(p+" "+q);
		}
	}
}
