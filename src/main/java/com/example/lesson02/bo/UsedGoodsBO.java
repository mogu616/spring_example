package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.dao.UsedGoodsDAO;
import com.example.lesson02.model.UsedGoods;

@Service
public class UsedGoodsBO {

	@Autowired // 스프링 빈이라 new 객체를 못하지만 이 어노테이션이 new 역활을 해줌
	private UsedGoodsDAO usedGoodsDAO;	// DAO 객체를 가져온다.
	
	// input: 없음
	// output: List<UsedGoods>
	public List<UsedGoods> getUsedGoodsList() {
		return usedGoodsDAO.selectUsedGoodsList();
	}
}
