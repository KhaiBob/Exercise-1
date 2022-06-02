package laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import laptrinhjavaweb.constant.SystemConstant;
import laptrinhjavaweb.dao.BuildingDAO;
import laptrinhjavaweb.dao.entity.BuildingEntity;
import laptrinhjavaweb.utils.StringUtils;

public class BuildingDaoImpl implements BuildingDAO {
	
	private String DB_URL = "jdbc:mysql://localhost:3306/javasql42022?serverTimezone=GMT";
	private String USER = "root";
	private String PASS = "tmk17121997";

	@Override
	public List<BuildingEntity> findBuilding(String name, String street, String ward, String district, Integer floorArea, String types) {
		List<BuildingEntity> results = new ArrayList<> ();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			 conn = DriverManager.getConnection(DB_URL, USER, PASS);
			 stmt = conn.createStatement();
			 StringBuilder sql = new StringBuilder("SELECT * FROM building  "+SystemConstant.ONE_TO_ONE+"") ;
			   if (name != null && name != "") {
				sql.append("  and name like '%"+name+"%'");   
			   }
			   if (name != null && name != "") {
					sql.append(" and street like '%"+street+"%'") ;   
			   }
			   if (name != null && name != "") {
					sql.append(" and ward like = "+ward+"") ;   
			    }
			   if (name != null && name != "") {
					sql.append(" and district like = "+district+"") ;   
			    }
			   if (floorArea != null) {
					sql.append(" and floorArea like = "+floorArea+"");   
			    }
			   if (name != null && name != "") {
					sql.append(" and types like '%"+types+"%'") ;   
			   }
			   rs = stmt.executeQuery(sql.toString());
			//int i=0;
			while (rs.next()) { //xu li data dau ra
				BuildingEntity buildingEntity = new BuildingEntity();
				buildingEntity.setId(rs.getLong("id"));
				buildingEntity.setName(rs.getString("name"));
				buildingEntity.setStreet(rs.getString("street"));
				buildingEntity.setWard(rs.getString("ward"));
				buildingEntity.setDistrict(rs.getString("district"));
				buildingEntity.setTypes(rs.getString("types"));
				results.add(buildingEntity);
						
			}
			return results;
			//System.out.println("execute access");
		} catch(SQLException| ArithmeticException e) {
			e.printStackTrace();
	}    catch (Exception e) {
		      e.printStackTrace();
	}finally {
		try {
			conn.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

		return null;
	}

}
