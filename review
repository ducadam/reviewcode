package bt;

import java.util.*;

class Node {
	int data;
	Node next;

	Node(int x) {
		data = x;
		next = null;
	}
}

public class minhduc1220 {
	Node head, cuoi;

	// 1. Nhập danh sách liên kết
	void nhap() {
		head = cuoi = null;
		Scanner kb = new Scanner(System.in);
		while (true) {
			System.out.print("Nhap so >0 de them, <=0 de dung: ");
			int x = kb.nextInt();
			if (x <= 0)
				break;

			Node t = new Node(x);
			if (head == null)
				head = cuoi = t;
			else {
				cuoi.next = t;
				cuoi = t;
			}
		}
	}

//2. In danh sách liên kết
	void in() {
		System.out.print("IN DANH SACH : ");
		Node p = head;
		while (p != null) {
			System.out.print(p.data + " -> ");
			p = p.next;
		}
		System.out.println("Null");
	}

//4. Tính tổng các số lẻ trong danh sách
	int tongLe() {
		int s = 0;
		Node p = head;
		while (p != null) {
			if (p.data % 2 != 0)
				s += p.data;
			p = p.next;
		}
		return s;
	}

//5. Xóa nốt kế cuối trong danh sách
	void xoaKeCuoi() {
		if (head == null || head.next == null) {
			System.out.println("Khong du phan tu de xoa!");
			return;
		}

		Node p = head;
		while (p.next.next != null) {
			p = p.next;
		}
		p.next = null;
		cuoi = p;
	}

//6. Đếm có bao nhiêu đoạn gồm các số tăng dần trong danh sách. Ví dụ với danh sách-->3-->4-->1-->5-->9-->3-->1-->2-->null thì có 4 đoạn tăng dần    
	int demDoanTang() {
		if (head == null)
			return 0;

		int dem = 1;
		Node p = head;

		while (p.next != null) {
			if (p.data >= p.next.data)
				dem++;
			p = p.next;
		}
		return dem;
	}

//7. Xóa tất cả các số lẻ ra khỏi danh sách
	void xoaSoLe() {
		while (head != null && head.data % 2 != 0) {
			head = head.next;
		}

		if (head == null) {
			cuoi = null;
			return;
		}

		Node p = head;
		while (p.next != null) {
			if (p.next.data % 2 != 0) {
				p.next = p.next.next;
			} else {
				p = p.next;
			}
		}
		cuoi = p;
	}

//8. Sắp xếp danh sách tăng dần
	void sapXepTang() {
		for (Node p = head; p != null; p = p.next) {
			for (Node q = p.next; q != null; q = q.next) {
				if (p.data > q.data) {
					int t = p.data;
					p.data = q.data;
					q.data = t;
				}
			}
		}
	}

//9. Đảo danh sách
	void daoDanhSach() {
		Node prev = null;
		Node cur = head;
		Node next = null;
		cuoi = head;

		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		head = prev;
	}

	public static void main(String[] args) {
		minhduc1220 L = new minhduc1220();
		L.nhap();
		L.in();
		System.out.println("Tong cac so le: " + L.tongLe());
		L.xoaKeCuoi();
		L.in();
		System.out.println("So doan tang dan: " + L.demDoanTang());
		L.xoaSoLe();
		L.in();
		L.sapXepTang();
		L.in();
		L.daoDanhSach();
		L.in();
	}
}
