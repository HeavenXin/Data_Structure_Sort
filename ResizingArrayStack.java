package arraystack;

import java.util.Iterator;


public class ResizingArrayStack<Item> implements Iterable<Item>{//设置接口implements
	private Item[]a = (Item[])new Object[1];//栈元素
	private int N = 0;
	//设置是否存在和数据长度
	public boolean isEmpty() {
		return N==0;
	}
	private int size() {
		// TODO Auto-generated method stub
		return N;
	}
	//创建一个长度为max的数组
	private void resize(int max) {
		// TODO Auto-generated method stub
		Item[] temp=(Item[]) new Object[max];//利用向下转型的方法
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;//a即为temp
	}
	//设置push和pop的方法
	public void push(Item item) {
		//元素添加到顶端
		if (N==a.length) {
			resize(a.length*2);
		}
		a[N++] = item;
	}
	public Item pop() {
		//从顶端删除元素
		Item item = a[--N];
		a[N]=null;//游离元素
		if (N>0&&N<=a.length/4) {
			resize(a.length/2);
		}
		return item;
	}
	@Override
	//要继承迭代
	public Iterator<Item> iterator(){
		// TODO Auto-generated method stub
		return new ReverseArrayIterator();
	}
	private class ReverseArrayIterator implements Iterator<Item> {
		//支持先进先出
		private int i = N;
		public boolean hasNext() {
			return i > 0 ;
		}
		public Item next() {
			return a[--i];
		}
		public void remove() {
		}
	}
	
}
