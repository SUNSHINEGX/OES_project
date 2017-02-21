package com.cool.john.service;

import java.util.Iterator;
import java.util.List;

import com.cool.john.bean.Score;
import com.cool.john.dao.ScoreDao;

public class ScoreService {
	private ScoreDao scoreDao;

	public ScoreDao getScoreDao() {
		return scoreDao;
	}

	public void setScoreDao(ScoreDao scoreDao) {
		this.scoreDao = scoreDao;
	}
	
	public int insert(Score score){
		return this.getScoreDao().insert(score);
	}
	
	public void delete(Score score){
		this.getScoreDao().delete(score);
	}
	
	
	public List find(){
		return this.getScoreDao().find();
	}
	public List findClass(Score score){
		return this.getScoreDao().findClass(score);
	}
	public List findStuName(Score score){
		return this.getScoreDao().findStuName(score);
	}
	public List findScore(Score score){
		return this.getScoreDao().findScore(score);
	}
	public List findSub(Score score){
		return this.getScoreDao().findSub(score);
	}
	public List findOnlySub(Score score){
		return this.getScoreDao().findOnlySub(score);
	}
	//更新问题分
	public void updateQa(Score score,int qascore){
			List scoreList = this.getScoreDao().findSub(score);
			Iterator  it = scoreList.iterator();
			while(it.hasNext()){
				Score obj = (Score)it.next();
				obj.setQaScore(obj.getQaScore()+qascore);
				this.getScoreDao().update(obj);
			}
			
		}
		//更新总分
		public void update(Score score){
			List scoreList = this.getScoreDao().findSub(score);
			Iterator  it = scoreList.iterator();
			while(it.hasNext()){
				Score total = (Score)it.next();
				total.setTotal(total.getFillScore()+ total.getSelScore() + total.getQaScore());
				this.getScoreDao().update(total);
			}
		}
		//管理员按班级
		public List findAdClass(Score score){
			return this.getScoreDao().findAdClass(score);
		}
		//管理员按学号
		public List findAdStuNum(Score score){
			return this.getScoreDao().findAdStuNum(score);
		}
		//管理员按姓名
		public List findAdStuName(Score score){
			return this.getScoreDao().findAdStuName(score);
		}
}
