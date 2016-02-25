package lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

// A doubly-linked list based on LList<E>.
class DList<E> implements List<E> {
	private DLink<E> head;
	private DLink<E> tail;
	protected DLink<E> curr;
	int count;
	
	DList() {
		curr = tail = head = new DLink<E>(null, null);
		count = 0;
	}
	
	@Override
	public void clear() {
		head.setNext(null);
		curr = tail = head = new DLink<E>(null, null);
		count = 0;
	}

	@Override
	public void insert(E item) {
		DLink<E> next = curr.next();
		DLink<E> newItem = new DLink<E>(item, curr, next);
		curr.setNext(newItem);
		next.setPrev(newItem);
		if (tail == curr) tail = newItem;
		count++;
		
	}

	@Override
	public void append(E item) {
		DLink<E> currTail = tail;
		tail = tail.setNext(new DLink<E>(item, currTail, null));
		count++;
	}

	@Override
	public E remove() {
		if (curr.next() == null) return null;
		E item = curr.next().element();
		if (tail == curr.next()) tail = curr;
		DLink<E> newNext = curr.next().next();
		curr.setNext(newNext);
		if (newNext != null) newNext.setPrev(curr);
		count--;
		return item;
	}

	@Override
	public void moveToStart() {
		curr = head;
	}

	@Override
	public void moveToEnd() {
		curr = tail;
	}

	@Override
	public void prev() {
		if (curr != head) curr = curr.prev();
	}

	@Override
	public void next() {
		if (curr != tail) curr = curr.next();
	}

	@Override
	public int length() {
		return count;
	}

	@Override
	public int currPos() {
		DLink<E> temp = head;
		int i;
		for (i = 0; curr != temp; i++) temp = temp.next();
		return i;
	}

	@Override
	public void moveToPos(int pos) {
		assert (pos >= 0) && (pos <= count);
		curr = head;
		for (int i = 0; i < pos; i++) curr = curr.next();
	}

	@Override
	public E getValue() {
		if (curr.next() == null) return null;
		return curr.next().element();
	}
	
	// Part 2
	public DList<E> reverse() {
		DList<E> temp = new DList<E>();
		moveToEnd();
		prev();
		for (int i = length(); i != 0; i--) {
			temp.append(getValue());
			prev();
		}
		return temp;
	}
	
	public String toString() {
		int oldPos = currPos();
		int length = length();
		StringBuffer out = new StringBuffer((length() + 1) * 4);
		moveToStart();
		out.append("< ");
		for (int i = 0; i < oldPos; i++) {
			out.append(getValue());
			out.append(" ");
			next();
		}
		out.append("| ");
		for (int i = oldPos; i < length; i++) {
			out.append(getValue());
			out.append(" ");
			next();
		}
		out.append(">");
		moveToPos(oldPos);
		return out.toString();
	}
}

public class Part1and2 {
	public static void main(String[] args) {
		DList<String> list = new DList<String>();
		
		try {
			//
			// Part 1.A
			//
			BufferedReader reader = new BufferedReader(new FileReader(new File("test.dat").getAbsoluteFile()));
			
			while (reader.ready()) {
				// Fill our list.
				list.append(reader.readLine());
			}
			
			System.out.println(list.toString() + " " + list.length());
			
			//
			// Part 1.B
			//
			BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
			boolean running = true;
			boolean removed = false;
			
			while (running) {
				System.out.print("Please enter an item to remove (or \"exit\" to terminate): ");
				String input = inputReader.readLine();
				removed = false;
				
				if (input.equals("exit")) {
					running = false;
				} else {
					list.moveToStart();
					while (list.currPos() < list.length()) {
						if (list.getValue().equals(input)) {
							list.remove();
							removed = true;
							break;
						} else {
							list.next();
						}
					}
					
					if (!removed) {
						System.out.println("Sorry, we couldn't find the value you were looking for.");
					}
					
					System.out.println(list.toString() + " " + list.length());
				}
			}
			
			//
			// Part 1.C
			//
			System.out.println(list.toString() + " " + list.length());
			running = true;
			boolean exists = false;
			
			while (running) {
				System.out.print("Please enter an new value to insert at the beginning of the list (or \"exit\" to terminate): ");
				String input = inputReader.readLine();
				exists = false;
				
				if (input.equals("exit")) {
					running = false;
				} else {
					list.moveToStart();
					while (list.currPos() < list.length()) {
						if (list.getValue().equals(input)) {
							exists = true;
							break;
						} else {
							list.next();
						}
					}
					
					if (exists) {
						System.out.println("Sorry, that value already exists.");
					} else {
						list.moveToStart();
						list.insert(input);
					}
					
					System.out.println(list.toString() + " " + list.length());
				}
			}
			
			// Part 2 (see above for `reverse`).
			System.out.println("Reversing list...");
			list = list.reverse();
			
			System.out.println(list.toString() + " " + list.length());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
