package com.cplatform.servlet;

import com.cplatform.similarity.SentenceSimilarity;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SentenceSimilarity ss = SentenceSimilarity.getInstance();
		String firstSen = "我要去餐厅用餐了";
		String secondSen = "俺要去食堂吃饭了";
		double sen = ss.getSimilarity(firstSen, secondSen);
		System.out.println(sen);
	}
}
