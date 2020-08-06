package com.tb.favorite.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisHelper {
	private static SqlSessionFactory sqlSessionFactory;
	static {
		try {
			// mybatis配置文件
			String resource = "mybatis.xml";
			// 读入配置文件
			InputStream inputStream = Resources.getResourceAsStream(resource);
			// 构建会话工厂==> 23 设计模式工厂模式
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// 开启回话
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static SqlSession opensSession() {
		return sqlSessionFactory.openSession();
	}
}
