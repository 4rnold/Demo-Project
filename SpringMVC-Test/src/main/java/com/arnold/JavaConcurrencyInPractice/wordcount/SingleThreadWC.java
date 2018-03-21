package com.arnold.JavaConcurrencyInPractice.wordcount;

import cn.hutool.json.JSONUtil;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

public class SingleThreadWC {

	static ConcurrentMap<Character,AtomicLong> result = new ConcurrentHashMap<Character, AtomicLong>();

	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis(); //程序开始记录时间
		/*File file = new File("D:\\Desktop\\wc\\wordlist.txt");
		BufferReader bf = new BufferReader(new FileReader(file));*/

		FileInputStream fileInputStream = new FileInputStream("D:\\\\Desktop\\\\wc\\\\wordlist.txt");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

		String str = null;
		while ((str = bufferedReader.readLine()) != null) {
			str = StringUtils.trimAllWhitespace(str);
			for (char c : str.toCharArray()) {
				increase(c);
			}
		}
		//JSONUtil.toJsonStr(result);

		System.out.println(JSONUtil.toJsonStr(result));
		long endTime = System.currentTimeMillis();
		long total = endTime - startTime;
		System.out.println(total);
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
}