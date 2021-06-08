package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import model.Store;

public class StoreDao {

	public Store select(Connection conn, String storeName) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from storeinfo where storename = ?");
			pstmt.setString(1, storeName);
			rs = pstmt.executeQuery();
			Store store = null;
			
			if(rs.next()) {
				store = new Store(
						rs.getInt("storeNo"),
						rs.getString("storeName"),
						rs.getString("storePic"),
						rs.getString("address"),
						rs.getString("hours"),
						rs.getString("closedays"),
						rs.getInt("callNumber"));
			}
			return store;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	public Store insertAPI(Connection conn, Store store) throws SQLException{
		try(PreparedStatement pstmt = conn.prepareStatement("insert into STOREINFO (storeno, storename, address, callnumber) VALUES (STORENUM.NEXTVAL,?,?,?)")) {
			pstmt.setString(1, store.getStoreName());
			pstmt.setString(2, store.getAddress());
			pstmt.setInt(3, store.getCallNumber());
			pstmt.executeUpdate();
		}
		return store;
	}
	
	public void update(Connection conn, Store store) throws SQLException{
		try(PreparedStatement pstmt = conn.prepareStatement("update storeinfo set storename = ?, storepic = ?, address = ?,"
				+ "hours = ?, closedays = ?, callnumber = ? ")){
			pstmt.setString(1, store.getStoreName());
			pstmt.setString(2, store.getStorePic());
			pstmt.setString(3, store.getAddress());
			pstmt.setString(4, store.getHours());
			pstmt.setString(5, store.getClosedays());
			pstmt.setInt(6, store.getCallNumber());
			
			pstmt.executeUpdate();
		}
	}

}
