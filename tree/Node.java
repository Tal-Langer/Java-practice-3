package tree;

import java.util.Scanner;

public class Node {
	private int count;
	private Node[] children = new Node[26];

	public Node() {
		count = 0;
	}

	public int num(String s) {
		if (s.equals(""))
			return count;
		int index = s.charAt(0) - 'a';// index as a=0 ,b=1 ,....,z=25
		if (children[index] == null)
			children[index] = new Node();
		return children[index].num(s.substring(1));
	}

	public void add(String s) {
		if (s.equals("")) // case of empty string
		{
			count++;
			return;
		}
		int index = s.charAt(0) - 'a';// index as a=0 ,b=1 ,....,z=25
		if (children[index] == null)
			children[index] = new Node();
		children[index].add(s.substring(1));
	}

}
