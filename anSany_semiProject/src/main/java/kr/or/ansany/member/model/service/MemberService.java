package kr.or.ansany.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.StringTokenizer;

import common.JDBCTemplate;
import kr.co.ansany.member.model.dao.MemberDao;
import kr.co.ansany.member.model.vo.Member;
import kr.co.ansany.product.model.vo.Product;

public class MemberService {
	MemberDao dao = new MemberDao();

	public MemberService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Member> selectAllMember() {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = dao.selectAllMember(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public int changeLevel(int memberNo, int memberLevel) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.changeLevel(conn, memberNo, memberLevel);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}		
		return result;
	}

	public ArrayList<Member> searchMember(String searchCate, String searchInput) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = new ArrayList<Member>();
		if(searchCate.equals("memberNo")) {
			list = dao.searchMember1(conn,searchInput);			
		}else if(searchCate.equals("memberId")) {
			list = dao.searchMember2(conn,searchInput);
		}else if(searchCate.equals("memberName")) {
			list = dao.searchMember3(conn,searchInput);
		}		
		JDBCTemplate.close(conn);
		return list;
	}

	public boolean chkedChangeLevel(String num, String level) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		
		StringTokenizer sT1 = new StringTokenizer(num,"/");
		StringTokenizer sT2 = new StringTokenizer(level,"/");
		boolean result = true;
		while(sT1.hasMoreTokens()) {
			int memberNo = Integer.parseInt(sT1.nextToken());
			int memberLevel = Integer.parseInt(sT2.nextToken());
			int changeResult = dao.changeLevel(conn, memberNo, memberLevel);
			if(changeResult==0) {
				result = false;
				break;
			}
		}
		if(result) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	
}
