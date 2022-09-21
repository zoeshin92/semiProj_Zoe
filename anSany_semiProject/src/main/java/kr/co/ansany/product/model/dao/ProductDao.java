package kr.co.ansany.product.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.co.ansany.product.model.vo.Product;

public class ProductDao {

	public int insertProduct(Connection conn, Product p) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into product_tbl values (product_seq.nextval,?,?,?,?,?,?)";		
		try {
			pstmt = conn.prepareStatement(query);			
				pstmt.setInt(1, p.getCateCode());
				pstmt.setString(2, p.getProductName());
				pstmt.setInt(3, p.getProductPrice());
				pstmt.setInt(4, p.getProductQty());
				pstmt.setString(5, p.getProductImg());
				pstmt.setString(6, p.getProductInfo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteProd(Connection conn, String prodNo) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from product_tbl where product_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, prodNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Product selectProduct(Connection conn, String prodNo) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Product p = null;
		String query = "select * from product_tbl where product_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, prodNo);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				p = new Product();
				p.setProductImg(rset.getString("product_img"));
				p.setProductInfo(rset.getString("product_info"));
				p.setProductName(rset.getString("product_name"));
				p.setProductNo(rset.getInt("product_no"));
				p.setProductPrice(rset.getInt("product_price"));
				p.setProductQty(rset.getInt("product_Qty"));		
				p.setCateCode(rset.getInt("cate_code"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return p;
	}

	public ArrayList<Product> selectAllProducts(Connection conn) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> products = new ArrayList<Product>();
		String query = "select * from product_tbl";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				int productNo = rset.getInt("product_no");
				int cateCode = rset.getInt("cate_code");
				String productName = rset.getString("product_name");
				int productPrice = rset.getInt("product_price");
				int productQty = rset.getInt("product_qty");
				String productImg = rset.getString("product_img");
				String productInfo = rset.getString("product_info");
				Product p = new Product(productNo, cateCode, productName, productPrice, productQty, productImg, productInfo);
				products.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return products;
	}

	public int modifyProd(Connection conn, Product p) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update product_tbl set cate_code=?, product_name=?, product_price=?, product_qty=?, product_img=?, product_info=? where product_no=?";
		try {
			pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, p.getCateCode());
				pstmt.setString(2, p.getProductName());
				pstmt.setInt(3, p.getProductPrice());
				pstmt.setInt(4, p.getProductQty());
				pstmt.setString(5, p.getProductImg());
				pstmt.setString(6, p.getProductInfo());
				pstmt.setInt(7, p.getProductNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}


}
