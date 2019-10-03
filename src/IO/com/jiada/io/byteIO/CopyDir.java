package IO.com.jiada.io.byteIO;

import java.io.File;
import java.io.IOException;

/**
 * 文件夹的拷贝
 * 1.文件赋值 copyfile
 * 2.文件 创建 mkdirs（）
 * 3。递归查找子孙级
 * @author jiadaye
 *
 */
public class CopyDir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//元目录
		String srcPath = "/Users/jiadaye/workspace/study";
		
		//目标目录
		String destPath = "/Users/jiadaye/workspace/dir";
	
		copyDir(srcPath,destPath);
	}
	/**
	 * 拷贝文件夹
	 * @param src 源path
	 * @param dest 目标path
	 */
	public static void copyDir(String srcPath,String destPath) {
		File src = new File(srcPath);
		File dest=new File(destPath);
		copyDir(src,dest);
	}
	
	/**
	 * 拷贝文件夹
	 * @param src 源file对象
	 * @param dest 目标file对象
	 */
	public static void copyDir(File src,File dest) {
		if(src.isDirectory()) {
			 dest = new File(dest,src.getName());
			 if(dest.getAbsolutePath().contains(src.getAbsolutePath())) {
				 System.out.println("父目录不能拷贝到子目录中");
				 return;
			 }
		}
		copyDirDetail(src,dest);

	}
	/**
	 * 拷贝文件夹细节
	 * @param src
	 * @param dest
	 * @param src
	 * @param dest
	 */
	public static void copyDirDetail(File src, File dest) {
		if(src.isFile()) {
			try {
				FileUtil.copyFile(src, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(src.isDirectory()) {
			dest.mkdirs();
			for(File sub: src.listFiles()) {
				copyDirDetail(sub, new File(dest,sub.getName()));
			}
		}
	
	}

}
