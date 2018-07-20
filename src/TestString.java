
public class TestString {
	
	/**
	 * 计算java出现的次数
	 * @param args
	 */

	public static void main(String[] args) {
		String s = "javafdajavafaljjava314fjava4654goodjava";
		String[] strings = s.split("java");
		for (String string : strings) {
			System.out.println(string);
		}
		int count = 0;
		int index = 0;
		String sFind = "java";
		while ((index = s.indexOf(sFind)) != -1) {
			s = s.substring(index + sFind.length());
			count ++;
		}
		System.out.println(count);

	}

}
