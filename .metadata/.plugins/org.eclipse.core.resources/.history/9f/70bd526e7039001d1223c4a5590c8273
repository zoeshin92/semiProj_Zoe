package kr.co.ansany.order.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.co.ansany.order.model.vo.Order;

public class OrderDao {

	public ArrayList<Order> selectAllOrders(Connection conn) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Order> list = new ArrayList<Order>();
		String query = "select * from order_tbl order by status";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int orderNo = rset.getInt("order_no");
				String memberId = rset.getString("member_id");
				int productNo = rset.getInt("product_no");
				int totalPrice = rset.getInt("total_price");
				String orderName = rset.getString("order_name");
				String orderAddr = rset.getString("order_addr");
				String orderPhone = rset.getString("order_phone");
				String orderDate = rset.getString("order_date");
				int status = rset.getInt("status");
				Order o = new Order(orderNo, memberId, productNo, totalPrice, orderName, orderAddr, orderPhone, orderDate, status);
				list.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}

}
