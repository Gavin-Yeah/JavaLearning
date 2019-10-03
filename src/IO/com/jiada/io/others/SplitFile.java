package IO.com.jiada.io.others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SplitFile {
	// 文件的路径
	private String filePath;
	// name
	private String fileName;
	//文件大小
	private long length;
	// 块数
	private int size;
	// 每块的大小
	private long blockSize;
	// 每块的名称
	private List<String> blockPath;

	public SplitFile(String filePath) {
		this(filePath, 1024);

	}

	public SplitFile(String filePath, long blockSize) {
		this();
		this.filePath = filePath;
		this.blockSize = blockSize;
		init();
	}

	public SplitFile() {
		blockPath = new ArrayList<>();

	}

	// initialization 计算块数，确定文件名
	public void init() {
		File src = null;

		if (null == filePath || !((src = new File(filePath)).exists())) {
			return;
		}
		if (src.isDirectory()) {
			return;
		}
		this.fileName = src.getName();
		// 计算块数 实际大小 与每块大小
		this.length = src.length();
		if (this.blockSize > length) {
			this.blockSize = length;
		}
		// 确定块数
		size = (int) Math.ceil(length * 1.0 / this.blockSize);
		
	}

	private void initPathName(String destPath) {
		for (int i = 0; i < size; i++) {
			this.blockPath.add(destPath+this.fileName + ".part" + i);
		}
	}

	/**
	 * 文件的分割
	 * 0）第几块
	 * 1）起始位置
	 * 2）实际大小
	 * @param destPath 分割文件存放目录
	 * @throws IOException 
	 */
	public void split(String destPath) throws IOException {
		initPathName(destPath);
		long beginPos=0;
		long actualBlockSize= blockSize;
		for(int i=0;i<size;i++) {
			if(i==size-1) {
				actualBlockSize=this.length-beginPos;
			}
			splitDetail(i, beginPos,actualBlockSize);
			beginPos+=actualBlockSize;
		}
	}
	public void splitDetail(int idx,long beginPos, long actualBlockSize) throws IOException {
		File src=new File(this.filePath);
		File dest =new File(this.blockPath.get(idx));
		RandomAccessFile raf =null;
		BufferedOutputStream bos=null;
		try {
			raf = new RandomAccessFile(src, "r");
			bos=new BufferedOutputStream(new FileOutputStream(dest));
			
			//read file
			raf.seek(beginPos);
			//buffer
			byte[]flush=new byte[1024];
			int len=0;
			while(-1!=(len=raf.read(flush))) {
				if(actualBlockSize-len>=0) {
				bos.write(flush, 0, len);
				actualBlockSize-=len;
				}else {//fibal block
					bos.write(flush, 0, (int)actualBlockSize);
					break;
					
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			bos.close();
			raf.close();
		}
		
	}

	
	/**
	 * 文件的合并
	 * @throws IOException 
	 */
	public void mergeFile(String destPath) throws IOException {
		File dest = new File(destPath);
		
		BufferedOutputStream bos = null;
		SequenceInputStream sis= null;
		Vector<InputStream> vi=new Vector<>();
		
			try {
				
				for(int i=0;i<this.blockSize;i++) {
					vi.add(new BufferedInputStream(new FileInputStream(new File(this.blockPath.get(i)))));
				}
				
				bos= new BufferedOutputStream(new FileOutputStream(dest,true));
				sis=new SequenceInputStream(vi.elements());
				byte[]flush=new byte[1024];
				int len=0;
				while(-1!=(len=sis.read(flush))) {
					bos.write(flush, 0, len);
				}
				bos.flush();
				bos.flush();
			}catch(

	FileNotFoundException e)
	{
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}finally
	{
			bos.close();
		}
	}
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		SplitFile file = new SplitFile("/Users/jiadaye/workspace/a.txt", 50);
		System.out.println(file.size);
		file.split("/Users/jiadaye/workspace/a/a");
		file.mergeFile("/Users/jiadaye/workspace/d.txt");
	}
	
	
}
