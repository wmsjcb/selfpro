package com.self.common.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.*;

/**
 * ZIP压缩工具
 * 
 */
public class ZipUtils {
	public static final String TMP = "_tmp";
	private static final String BASE_DIR = "";
	private static final int BUFFER = 1024;

	/**
	 * 压缩
	 * 
	 * @param srcPaths
	 *            源文件名称列表
	 * @param basePath
	 *            目标文件名称
	 * @throws IOException 
	 */
	public static boolean compress(List<String> srcPaths, String basePath) throws IOException {
		List<File> files = new ArrayList<File>();
		for (String srcPath : srcPaths) {
			File srcFile = new File(srcPath);
			files.add(srcFile);
		}

		// _tmp后缀为中间名,打包完毕后更改为原名称
		String destPath = basePath + TMP;
		File tmpFile = new File(destPath);
		if(tmpFile.exists()){
			tmpFile.delete();
		}
		compress(files, tmpFile);
		File zipFile = new File(basePath);
		if(zipFile.exists()){
			zipFile.delete();
		}
		return tmpFile.renameTo(zipFile);
	}

	/**
	 * 压缩
	 * 
	 * @param files
	 *            源文件列表
	 * @param newFile
	 *            目标文件
	 * @throws IOException 
	 */
	public static void compress(List<File> files, File newFile){
		ZipOutputStream zos = null;
		try {
			// 对输出文件做CRC32校验
			CheckedOutputStream cos = new CheckedOutputStream(new FileOutputStream(newFile), new CRC32());
			zos = new ZipOutputStream(cos);
			compressFile(files, zos, BASE_DIR);
		}catch (Exception e){
			//
		}finally {
			try {
				zos.flush();
			} catch (IOException e) {

			}
			if(zos !=null){
				try {
					zos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public static  List<String> zipFileRead(String zipPath)  {
		List<String> nameList = new ArrayList<String>();
		ZipFile zipFile =null;
		try {
			// 获得zip信息
			zipFile = new ZipFile(zipPath);
			@SuppressWarnings("unchecked")
			Enumeration<ZipEntry> enu = (Enumeration<ZipEntry>) zipFile
					.entries();
			while (enu.hasMoreElements()) {
				ZipEntry zipElement = (ZipEntry) enu.nextElement();
				String fileName = zipElement.getName();
				if (fileName != null && fileName.indexOf(".") != -1) {// 是否为文件
					String subFileName=fileName.substring(0,fileName.indexOf(".pdf"));
					nameList.add(subFileName.split("-")[1]);
				}
			}
		}catch (Exception e){
			//
		}finally {
           if(zipFile!=null){
			   try {
				   zipFile.close();
			   } catch (IOException e) {
				   e.printStackTrace();
			   }
		   }

		}

		return nameList;
	}

	/**
	 * 压缩
	 * 
	 * @param files
	 *            源文件列表
	 * @param zos
	 * @param dir
	 * @throws IOException 
	 * 
	 */
	private static void compressFile(List<File> files, ZipOutputStream zos, String dir) throws IOException {
		for (File file : files) {
			BufferedInputStream bis = null;
			try {
				ZipEntry entry = new ZipEntry(dir + file.getName());
				zos.putNextEntry(entry);
				bis = new BufferedInputStream(new FileInputStream(file));
				
				int count;
				byte data[] = new byte[BUFFER];
				while ((count = bis.read(data, 0, BUFFER)) != -1) {
					zos.write(data, 0, count);
				}
			}finally{
				if(bis != null){
					bis.close();
				}
			}
			file.delete();
		}
		zos.closeEntry();
	}

	public static void main(String[] args) throws IOException {
//		List<File> files = new ArrayList<File>();
//		files.add(new File("D:\\testZip\\1.pdf"));
//		files.add(new File("D:\\testZip\\2.pdf"));
//		File newFile = new File("D:\\testZip\\test.zip");
//
//		try {
//			compress(files,newFile);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		List<String> srcPaths = new ArrayList<String>();
//		srcPaths.add("D:\\testZip\\1.pdf");
//		srcPaths.add("D:\\testZip\\2.pdf");
		String basePath="D:\\\\testZip\\\\test.zip";


		//compress(srcPaths,basePath);
	List<String> ls=	zipFileRead(basePath);
		System.out.println(ls.size());
	}
}
