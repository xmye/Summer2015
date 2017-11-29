package Link;

import java.util.Random;

public class Linklist<T> {
	private Node head;
	private Node tail;
	private int size = 0;

	// 增加
	public void add(T element) {
		Node newnode = new Node(element);
		if (size == 0) {
			head = newnode;
			tail = newnode;
		} else {
			tail.next = newnode;
			tail = newnode;
		}
		size++;
	}

	// delete
	public void delete(int index) {
		if (size == 0 || index > size || index < 0) {
			System.out.println("输入有误");
		}
		if (index == 0) {
			Node node = head;
			head = head.next;
			node.next = null;
		} else {
			Node lastnode = head;
			// 上一个节点
			for (int i = 0; i < index - 1; i++) {
				lastnode = lastnode.next;
			}
			// 需删除的节点
			Node node = lastnode.next;
			// 下一个节点
			Node nextnode = node.next;
			// 删除
			lastnode.next = nextnode;
			node.next = null;

			// 尾节点 （tail.next=null)
			if (index == size - 1) {
				tail = lastnode; // 将tail指向现在的尾节点
			}
			size--;
		}
		// 若开始只有一个元素
		if (size == 0) {
			head = null;
		}
	}

	// change
	public void change(T element, int index) {
		Node node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		node.data = element;
	}

	// find
	public T find(int index) {
		Node node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		System.out.println((Integer) node.data);
		return (T) node.data;
	}

	// show 遍历
	public void show() {
		if (size != 0) {
			Node node = head;
			for (int i = 0; i < size; i++) {
				System.out.print(node.data + " ");
				node = node.next;
			}
		}
		System.out.println();
		System.out.println();
	}

	// insert
	public void insert(T element, int index) {
		Node node = head;
		Node newnode = new Node(element);
		for (int i = 0; i < index - 1; i++) {
			node = node.next;
		}
		Node nextnode = node.next;
		node.next = newnode;
		newnode.next = nextnode;
		newnode.data = element;
		size++;
	}

	public int getsize() {
		return size;
	}

	// 排序
	public void Order(int size) {
		for (int i = 0; i < size; i++) {
			Node node = head;
			Node tnode = node.next;
			for (int j = 0; j < size - 1 - i; j++) {
				// System.out.print("ss");
				// show();
				if ((int) node.data > (int) tnode.data) {

					int a;
					a = (int) node.data;
					node.data = tnode.data;
					tnode.data = a;
				}
				node = tnode;
				tnode = tnode.next;
			}
		}
	}

	public static void main(String[] args) {
		Linklist<Integer> link = new Linklist<Integer>();
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			link.add(r.nextInt(20));
		}
		link.show();
		link.delete(2);
		link.show();
		link.change(50, 3);
		link.show();
		link.insert(50, 1);
		link.show();
		link.find(4);
		link.Order(link.getsize());
		link.show();
	}
}
