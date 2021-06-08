package com.lib.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.lib.vo.JsonVO;

public class ApiController {
	public static void main(String[] args) {

		String result = "";
		JSONObject jsonObj = null;
		JSONObject jsonObj2 = null;

		List<JsonVO> arrayList = new ArrayList<JsonVO>();

		// 1. API 통신
		// 2. 데이터 변환
		// 3. DB insert

		// TODO API 통신
		BufferedReader br = null;
		try {
			String urlstr = "http://openapi.seoul.go.kr:8088/56504d68436c6565353067596b7578/json/LOCALDATA_072405/1/10/";
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));

			String line;
			while ((line = br.readLine()) != null) {
				result = result + line;
			}
//			System.out.println(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// TODO 데이터 변환

		try {
			JSONParser parser = new JSONParser();
			jsonObj = (JSONObject) parser.parse(result);
			jsonObj2 = (JSONObject) jsonObj.get("LOCALDATA_072405");

			JSONArray jsonArray = (JSONArray) ((JSONObject) jsonObj2).get("row");

			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObj3 = new JSONObject();
				jsonObj3 = (JSONObject) jsonArray.get(i);

//				System.out.println("jsonObj4 : "+ jsonObj3);

				JsonVO vo = new JsonVO();
				
				vo.setDTLSTATENM(jsonObj3.get("DTLSTATENM").toString());
				vo.setUPTAENM(jsonObj3.get("UPTAENM").toString());
				
				if (jsonObj3.get("BPLCNM").toString() != null && !jsonObj3.get("BPLCNM").toString().trim().equals("")) {
					System.out.println(jsonObj3.get("RDNWHLADDR").toString());
					if (jsonObj3.get("RDNWHLADDR").toString() != null && !jsonObj3.get("RDNWHLADDR").toString().trim().equals("")) {
						if(vo.getDTLSTATENM().equals("영업")) {
							if(vo.getUPTAENM().equals("과자점") || vo.getUPTAENM().equals("떡카페") 
									|| vo.getUPTAENM().equals("아이스크림") || vo.getUPTAENM().equals("전통찻집")
									|| vo.getUPTAENM().equals("커피숍")) {
								vo.setBPLCNM(jsonObj3.get("BPLCNM").toString());
								vo.setRDNWHLADDR(jsonObj3.get("RDNWHLADDR").toString());
								vo.setSITETEL(jsonObj3.get("SITETEL").toString());
								arrayList.add(vo);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// TODO DB insert
		// 데이터베이스와 연결하는 객체
		Connection con = null;

		// 1. JDBC Driver Class
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 데이터베이스에 연결하기 위한 정보
		String url = "jdbc:oracle:thin:@192.168.18.128:1521:xe";
		String user = "CARE"; // 데이터베이스 ID
		String pw = "CARE"; // 데이터베이스 PW

		try {
			String sql = "insert into STOREINFO (storeno, storename, address, callnumber) VALUES (STORENUM.NEXTVAL,?,?,?)";

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pw);
			PreparedStatement ps = con.prepareStatement(sql);
			for (int i = 0; i < arrayList.size(); i++) {
				JsonVO vo = arrayList.get(i);
				ps.setString(1, vo.getBPLCNM());
				ps.setString(2, vo.getRDNWHLADDR());
				ps.setString(3, vo.getSITETEL());
				ps.execute();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
