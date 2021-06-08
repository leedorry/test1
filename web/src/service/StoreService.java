package service;

import java.sql.Connection;

import jdbc.connection.ConnectionProvider;
import dao.StoreDao;
import dao.StoreRequest;
import model.Store;

public class StoreService {
	
	private StoreDao storeDao = new StoreDao();
	
	public void store(StoreRequest storeReq) {
		Connection conn  = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			
//			Store store = storeDao.insertAPI(conn, store);
			
//			Store store = storeDao.insertAPI(conn, new Store(0, storeReq.getStoreName(), storeReq.getAddress(), storeReq.getCallNumber()));
		
		}
	}
}
