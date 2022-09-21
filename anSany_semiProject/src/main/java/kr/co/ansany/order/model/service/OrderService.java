package kr.co.ansany.order.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.co.ansany.order.model.dao.OrderDao;
import kr.co.ansany.order.model.vo.Order;

public class OrderService {
	OrderDao dao = new OrderDao();

	public OrderService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Order> selectAllOrders() {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Order> list = dao.selectAllOrders(conn);
		JDBCTemplate.close(conn);
		return list;
	}
	
}
