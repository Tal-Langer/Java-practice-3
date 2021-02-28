package tree;

import java.util.Scanner;

public class ReversedWords {
	public static int checkReversed() {
		int cnt = 0;
		Scanner s = new Scanner(System.in);
		Node node = new Node();// make the first node
		String temp = s.next();
		while (!temp.equals("X") || temp.length() == 0) {
			/* make reversed word */
			String revTemp = "";
			for (int i = temp.length() - 1; i >= 0; i--)
				revTemp += temp.charAt(i);// last letter
			if (node.num(revTemp) > 0)
				cnt++; // word is already exist
			node.add(temp);// add user word to the tree
			temp = s.next();

		} // while
		return cnt;
	}

}
