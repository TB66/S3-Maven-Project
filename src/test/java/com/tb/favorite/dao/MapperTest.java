package com.tb.favorite.dao;

import org.junit.jupiter.api.Test;

import com.tb.favorite.bean.Favorite;
import com.tb.favorite.biz.FavoriteBiz;

public class MapperTest {
	@Test
	public void Test1() {
		Favorite f = new Favorite();
		FavoriteBiz fb = new FavoriteBiz();
		f.setFlabel("淘宝");
		f.setFdesc("购物网站");
		f.setFtags("购物,生活");
		fb.addFavorite(f);
	}

	@Test
	public void Test2() {
		Favorite f = new Favorite();
		FavoriteBiz fb = new FavoriteBiz();
		f.setFlabel("微博");
		f.setFurl("weibo.com");
		f.setFdesc("社交网站");
		f.setFtags("娱乐,生活，游戏");
		fb.addFavorite(f);
	}
}
