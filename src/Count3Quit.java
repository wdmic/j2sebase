
public class Count3Quit {
	
	public static void main(String[] args) {
		KidCircle kc = new KidCircle(500);
		Kid kid = kc.first;
		int countNum = 0;
		while (kc.count > 1) {
			countNum ++;
			if (countNum == 3) {
				countNum = 0;
				kc.delete(kid);
			}
			kid = kid.right;
		}
		System.out.println(kc.first.id);
	}

}
class Kid {
	int id;
	Kid left, right;
}

class KidCircle{
	int count;
	Kid first, last;
	public KidCircle(int n) {
		for (int i = 0; i < n; i++) {
			add();
		}
	}
	
	void add() {
		Kid kid = new Kid();
		kid.id = count;
		if (count <= 0) {
			first = kid;
			last = kid;
			kid.left = kid;
			kid.right = kid;
		}else {
			last.right = kid;
			kid.left = last;
			kid.right = first;
			first.left = kid;
			last = kid;
		}
		count ++;
	}
	
	void delete(Kid kid) {
		if (count <= 0 ) {
			return;
		}else if (count == 1) {
			first = last = null;
		}else {
			kid.left.right = kid.right;
			kid.right.left = kid.left;
			if (kid == first) {
				first = kid.right;
			}else if (kid == last) {
				last = kid.left;
			}
		}
		count --;
	}
}