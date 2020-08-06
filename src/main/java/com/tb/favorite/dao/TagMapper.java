package com.tb.favorite.dao;

import java.util.List;

import com.tb.favorite.bean.Tag;

public interface TagMapper {
	int insert(Tag tag);

	List<Tag> selectAll();

	Tag selectByTname(String tname);

	int update(String tname);
}
