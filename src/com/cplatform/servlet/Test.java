package com.cplatform.servlet;

import com.cplatform.similarity.SentenceSimilarity;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SentenceSimilarity ss = SentenceSimilarity.getInstance();
		String firstSen = "��Ҫȥ�����ò���";
		String secondSen = "��Ҫȥʳ�óԷ���";
		double sen = ss.getSimilarity(firstSen, secondSen);
		System.out.println(sen);
	}
}
