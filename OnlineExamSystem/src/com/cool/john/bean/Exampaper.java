package com.cool.john.bean;

public class Exampaper {
	private String subject;
	private int EasySelNum;
	private int HardSelNum;
	private int SelScore;
	private int EasyFillNum;
	private int HardFillNum;
	private int FillScore;
	private int EasyQaNum;
	private int HardQaNum;
	private int QaSocre;
	public Exampaper() {
		super();
	}
	public Exampaper(String subject, int easySelNum, int hardSelNum,
			int selScore, int easyFillNum, int hardFillNum, int fillScore,
			int easyQaNum, int hardQaNum, int qaSocre) {
		super();
		this.subject = subject;
		EasySelNum = easySelNum;
		HardSelNum = hardSelNum;
		SelScore = selScore;
		EasyFillNum = easyFillNum;
		HardFillNum = hardFillNum;
		FillScore = fillScore;
		EasyQaNum = easyQaNum;
		HardQaNum = hardQaNum;
		QaSocre = qaSocre;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getEasySelNum() {
		return EasySelNum;
	}
	public void setEasySelNum(int easySelNum) {
		EasySelNum = easySelNum;
	}
	public int getHardSelNum() {
		return HardSelNum;
	}
	public void setHardSelNum(int hardSelNum) {
		HardSelNum = hardSelNum;
	}
	public int getSelScore() {
		return SelScore;
	}
	public void setSelScore(int selScore) {
		SelScore = selScore;
	}
	public int getEasyFillNum() {
		return EasyFillNum;
	}
	public void setEasyFillNum(int easyFillNum) {
		EasyFillNum = easyFillNum;
	}
	public int getHardFillNum() {
		return HardFillNum;
	}
	public void setHardFillNum(int hardFillNum) {
		HardFillNum = hardFillNum;
	}
	public int getFillScore() {
		return FillScore;
	}
	public void setFillScore(int fillScore) {
		FillScore = fillScore;
	}
	public int getEasyQaNum() {
		return EasyQaNum;
	}
	public void setEasyQaNum(int easyQaNum) {
		EasyQaNum = easyQaNum;
	}
	public int getHardQaNum() {
		return HardQaNum;
	}
	public void setHardQaNum(int hardQaNum) {
		HardQaNum = hardQaNum;
	}
	public int getQaSocre() {
		return QaSocre;
	}
	public void setQaSocre(int qaSocre) {
		QaSocre = qaSocre;
	}
	@Override
	public String toString() {
		return "{\"subject\":\"" + subject + "\", \"EasySelNum\":\""
				+ EasySelNum + "\", \"HardSelNum\":\"" + HardSelNum
				+ "\", \"SelScore\":\"" + SelScore + "\", \"EasyFillNum\":\""
				+ EasyFillNum + "\", \"HardFillNum\":\"" + HardFillNum
				+ "\", \"FillScore\":\"" + FillScore + "\", \"EasyQaNum\":\""
				+ EasyQaNum + "\", \"HardQaNum\":\"" + HardQaNum
				+ "\", \"QaSocre\":\"" + QaSocre + "\"}";
	}
}
