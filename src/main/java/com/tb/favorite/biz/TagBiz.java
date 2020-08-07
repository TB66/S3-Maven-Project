package com.tb.favorite.biz;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tb.favorite.bean.Tag;
import com.tb.favorite.dao.FavoriteMapper;
import com.tb.favorite.dao.TagFavoriteMapper;
import com.tb.favorite.dao.TagMapper;
import com.tb.favorite.util.MyBatisHelper;

public class TagBiz {
	SqlSession session = MyBatisHelper.opensSession();
	FavoriteMapper favoriteMapper = session.getMapper(FavoriteMapper.class);
	TagMapper tagMapper = session.getMapper(TagMapper.class);
	TagFavoriteMapper tagFavoriteMapper = session.getMapper(TagFavoriteMapper.class);

	public List<Tag> selectAll() {
		return tagMapper.selectAll();
	}
}
