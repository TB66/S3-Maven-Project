package com.tb.favorite.biz;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tb.favorite.bean.Favorite;
import com.tb.favorite.bean.Tag;
import com.tb.favorite.bean.TagFavorite;
import com.tb.favorite.dao.FavoriteMapper;
import com.tb.favorite.dao.TagFavoriteMapper;
import com.tb.favorite.dao.TagMapper;
import com.tb.favorite.util.MyBatisHelper;

public class FavoriteBiz {
	SqlSession session = MyBatisHelper.opensSession();
	FavoriteMapper favoriteMapper = session.getMapper(FavoriteMapper.class);
	TagMapper tagMapper = session.getMapper(TagMapper.class);
	TagFavoriteMapper tagFavoriteMapper = session.getMapper(TagFavoriteMapper.class);

	public List<Favorite> selectAll() {
		return favoriteMapper.selectAll();
	}

	public List<Favorite> selectByTid(Integer tid) {
		return favoriteMapper.selectByTid(tid);
	}

	public void addFavorite(Favorite favorite) {

		try {
			favoriteMapper.insert(favorite);
			if (favorite.getFtags() != null) {
				String[] ftags;
				ftags = favorite.getFtags().split("[,，；;]");
				for (String ftag : ftags) {
					Tag tag = new Tag();
					if (tagMapper.update(ftag) == 0) {
						tag.setTname(ftag);
						tagMapper.insert(tag);
					} else {
						tag = tagMapper.selectByTname(ftag);
					}

					TagFavorite tagFavorite = new TagFavorite();
					tagFavorite.setTid(tag.getTid());
					tagFavorite.setFid(favorite.getFid());
					tagFavoriteMapper.insert(tagFavorite);
					session.commit();
				}
			}
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}

	}
}
