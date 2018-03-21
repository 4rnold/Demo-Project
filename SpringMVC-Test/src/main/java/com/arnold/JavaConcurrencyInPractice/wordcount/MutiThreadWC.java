package com.arnold.JavaConcurrencyInPractice.wordcount;


import cn.hutool.json.JSONUtil;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class MutiThreadWC {

	static ConcurrentMap<Character,AtomicLong> result = new ConcurrentHashMap<Character, AtomicLong>();
	static ExecutorService pool = Executors.newCachedThreadPool();

	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		/*File file = new File("D:\\Desktop\\wc\\wordlist.txt");
		BufferReader bf = new BufferReader(new FileReader(file));*/

		File file = new File("D:\\\\Desktop\\\\wc\\\\wordlist.txt");
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

		int lines = getFileLines(file);
		int block = (int) Math.floor(lines / 3);

		for (int i = 0; i < 3; i++) {
			MyTask myTask = null;
			if (i!=9) {
				myTask = new MyTask(file, 1 + i * block, block);
			} else {
				myTask = new MyTask(file, 1 + i * block, lines-9*block);
			}
			pool.execute(myTask);
		}

		pool.shutdown();
		try {
			//要加do while？
			pool.awaitTermination(30,TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//JSONUtil.toJsonStr(result);


		System.out.println(JSONUtil.toJsonStr(result));
		long endTime = System.currentTimeMillis();
		long total = endTime - startTime;
		System.out.println(total);
	}

	static class MyTask implements Runnable {
		private int start = 0;
		private int size = 0;
		private File file;

		public MyTask(File file, int start, int size) {
			this.file = file;
			this.start = start;
			this.size = size;
		}

		@Override
		public void run() {
			//System.out.println(start + "-"+ (start + size -1));
			String str = null;
			try {
				LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(file));
				//这个函数只是修改了行号，读取的时候，还是按照原来的顺序读取文件内容。
				lineNumberReader.setLineNumber(start);
				int readlines = 0;
				/*while ((str = lineNumberReader.readLine()) != null *//*&& readlines <size*//*) {
					str = StringUtils.trimAllWhitespace(str);
					for (char c : str.toCharArray()) {
						increase(c);
					}
					readlines++;
				}*/
				for (int lineCounter = 1; lineCounter < start && (str = lineNumberReader.readLine()) != null; lineCounter++) {
				}

				for (int lineCounter = 0; lineCounter < size && (str = lineNumberReader.readLine()) != null; lineCounter++) {
					str = StringUtils.trimAllWhitespace(str);
					for (char c : str.toCharArray()) {
						increase(c);
					}
				}

				//System.out.println("over");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static long increase(char word){
		AtomicLong number = result.get(word);
		if (number == null) {
			AtomicLong newNum = new AtomicLong(0);
			//如果已存在则返回存在的那个
			number = result.putIfAbsent(word, newNum);
			if (number == null) {
				number = newNum;
			}
		}
		//atomic原子操作
		return number.incrementAndGet();
	}

	public static int getFileLines(File file) {

		int lines = 0;
		LineNumberReader lineNumberReader = null;
		try {
			lineNumberReader = new LineNumberReader(new BufferedReader(new FileReader(file)));
			long fileLength = file.length();
			if (lineNumberReader != null) {
				lineNumberReader.skip(fileLength);
				lines = lineNumberReader.getLineNumber();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (lineNumberReader != null) {
					lineNumberReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return lines +1 ;

	}
}
