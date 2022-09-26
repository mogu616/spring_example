package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.dao.ReviewDAO;
import com.example.lesson03.model.Review;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewDAO reviewDAO;
	
	// input: id
	// output: Review
	
	public Review getReviewById(int id) {
		return reviewDAO.selectReviewById(id);
	}
	
	// return int : 인서트가 성공한 행의 개수
	public int addReview(Review review) {
		return reviewDAO.insertReview(review);
	}
	
//	addReviewAsField(4, "콤비네이션R", "포양", 5.0, "맛있네영")
	public int addReviewAsField(int storeId, String name, String userName, Double point, String review) {
		return reviewDAO.insertReviewAsField(storeId, name, userName, point, review);
	}
	
	public int updateReviewById(int id, String review) {
		return reviewDAO.updateReviewById(id, review);
	}
	
	// input: 삭제할 id
	// output: x
	public void deleteReviewById(int id) {
		reviewDAO.deleteReviewById(id);
	}
}
