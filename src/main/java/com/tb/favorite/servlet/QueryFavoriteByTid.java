package com.tb.favorite.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tb.favorite.biz.FavoriteBiz;

@WebServlet("/QueryFavoriteByTid")
public class QueryFavoriteByTid extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String stid = request.getParameter("tid");
		Integer tid;
		Gson gson = new Gson();
		String json;
		if (stid != null && stid.trim().isEmpty() == false && "null".equals(stid) == false) {
			tid = Integer.valueOf(stid);
		} else {
			tid = null;
		}

		json = gson.toJson(new FavoriteBiz().selectByTid(tid));
		response.getWriter().append(json);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
