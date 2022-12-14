package kr.co.ansany.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.co.ansany.member.model.vo.Member;
import kr.co.ansany.product.model.vo.Product;

public class MemberDao {

	public ArrayList<Member> selectAllMember(Connection conn) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<Member>();
		String query = "select * from member_tbl order by 1";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int memberNo = rset.getInt("member_no");
				String memberId = rset.getString("member_id");
				String memberPw = rset.getString("member_pw");
				String memberName = rset.getString("member_name");
				String memberBirth = rset.getString("member_birth");
				String memberPhone = rset.getString("member_phone");
				String memberAddr = rset.getString("member_addr");
				String memberEmail = rset.getString("member_email");
				String enrollDate = rset.getString("enroll_date");
				int memberLevel = rset.getInt("member_level");
				Member m = new Member(memberNo, memberId, memberPw, memberName, memberBirth, memberPhone, memberAddr, memberEmail, enrollDate, memberLevel);
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}

	public int changeLevel(Connection conn, int memberNo, int memberLevel) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update member_tbl set member_level=? where member_no=?";
		try {
			pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, memberLevel);
				pstmt.setInt(2, memberNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Member> searchMember1(Connection conn,String searchInput) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<Member>();
		String query = "select * from member_tbl where member_no=?";
		try {
			pstmt = conn.prepareStatement(query);
				pstmt.setString(1, searchInput);
				
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int memberNo = rset.getInt("member_no");
				String memberId = rset.getString("member_id");
				String memberPw = rset.getString("member_pw");
				String memberName = rset.getString("member_name");
				String memberBirth = rset.getString("member_birth");
				String memberPhone = rset.getString("member_phone");
				String memberAddr = rset.getString("member_addr");
				String memberEmail = rset.getString("member_email");
				String enrollDate = rset.getString("enroll_date");
				int memberLevel = rset.getInt("member_level");
				Member m = new Member(memberNo, memberId, memberPw, memberName, memberBirth, memberPhone, memberAddr, memberEmail, enrollDate, memberLevel);
				list.add(m);
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

	public ArrayList<Member> searchMember2(Connection conn, String searchInput) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<Member>();
		String query = "select * from member_tbl where member_Id=?";
		try {
			pstmt = conn.prepareStatement(query);
				pstmt.setString(1, searchInput);
				
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int memberNo = rset.getInt("member_no");
				String memberId = rset.getString("member_id");
				String memberPw = rset.getString("member_pw");
				String memberName = rset.getString("member_name");
				String memberBirth = rset.getString("member_birth");
				String memberPhone = rset.getString("member_phone");
				String memberAddr = rset.getString("member_addr");
				String memberEmail = rset.getString("member_email");
				String enrollDate = rset.getString("enroll_date");
				int memberLevel = rset.getInt("member_level");
				Member m = new Member(memberNo, memberId, memberPw, memberName, memberBirth, memberPhone, memberAddr, memberEmail, enrollDate, memberLevel);
				list.add(m);
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

	public ArrayList<Member> searchMember3(Connection conn, String searchInput) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<Member>();
		String query = "select * from member_tbl where member_name=?";
		try {
			pstmt = conn.prepareStatement(query);
				pstmt.setString(1, searchInput);
				
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int memberNo = rset.getInt("member_no");
				String memberId = rset.getString("member_id");
				String memberPw = rset.getString("member_pw");
				String memberName = rset.getString("member_name");
				String memberBirth = rset.getString("member_birth");
				String memberPhone = rset.getString("member_phone");
				String memberAddr = rset.getString("member_addr");
				String memberEmail = rset.getString("member_email");
				String enrollDate = rset.getString("enroll_date");
				int memberLevel = rset.getInt("member_level");
				Member m = new Member(memberNo, memberId, memberPw, memberName, memberBirth, memberPhone, memberAddr, memberEmail, enrollDate, memberLevel);
				list.add(m);
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
	public Member selectOneMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;
		String query = "select * from member_tbl where member_id=? and member_pw=?";
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			rset=pstmt.executeQuery();
			if(rset.next()) {
				m = new Member();
				m.setMemberNo(rset.getInt("member_no"));
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberBirth(rset.getString("member_birth"));
				m.setMemberPhone(rset.getString("member_phone"));
				m.setMemberAddr(rset.getString("member_addr"));
				m.setMemberEmail(rset.getString("member_email"));
				m.setEnrollDate(rset.getString("enroll_date"));
				m.setMemberLevel(rset.getInt("member_level"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return m;
	}

	public int insertMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "insert into member_tbl values(member_seq.nextval,?,?,?,?,?,'??????',?,to_char(sysdate,'yyyy-mm-dd'),3)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getMemberBirth());
			pstmt.setString(5, m.getMemberPhone());
			pstmt.setString(6, m.getMemberEmail());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	//ajax id ??????
	public Member selectChkMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null; // ??????????????? null return
		
		String query = "select * from member_tbl where member_id =?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member();
				m.setMemberNo(rset.getInt("member_no"));
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberBirth(rset.getString("member_birth"));
				m.setMemberPhone(rset.getString("member_phone"));
				m.setMemberAddr(rset.getString("member_addr"));
				m.setMemberEmail(rset.getString("member_email"));
				m.setEnrollDate(rset.getString("enroll_date"));
				m.setMemberLevel(rset.getInt("member_level"));
			}else {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return m;
	}



}
