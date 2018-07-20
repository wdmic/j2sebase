import java.io.File;

public class TestFile {
	
	/**
	 * 树状打印文件夹目录
	 * @param args
	 */

	public static void main(String[] args) {
		File file = new File("F:/JAVA程序员路线");
		System.out.println(file.getName());
		tree(file, 1);
		
	}
	
	public static void tree(File file, int level) {
		//level代表前面的缩进长度
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
