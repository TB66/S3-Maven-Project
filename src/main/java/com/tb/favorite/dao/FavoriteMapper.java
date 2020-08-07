package com.tb.favorite.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tb.favorite.bean.Favorite;

public interface FavoriteMapper {
	int insert(Favorite favorite);

	List<Favorite> selectByTid(@Param("tid") Integer tid);

	List<Favorite> selectAll();
}
