import java.io.File;

public class TestFile {
	
	/**
	 * ��״��ӡ�ļ���Ŀ¼
	 * @param args
	 */

	public static void main(String[] args) {
		File file = new File("F:/JAVA����Ա·��");
		System.out.println(file.getName());
		tree(file, 1);
		
	}
	
	public static void tree(File file, int level) {
		//level����ǰ�����������
		String preStr = "";
		for (int i = 0; i < level; i++) {
			preStr += "    ";
		}
		
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			System.out.println(preStr + files[i].getName());
			if (files[i].isDirectory()) {
				tree(files[i], level+1);
			}
		}
	}

}
