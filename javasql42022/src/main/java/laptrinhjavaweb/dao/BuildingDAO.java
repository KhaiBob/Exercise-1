package laptrinhjavaweb.dao;

import java.util.List;

import laptrinhjavaweb.dao.entity.BuildingEntity;

public interface BuildingDAO {
    
	List<BuildingEntity> findBuilding(String name, String street, String ward, String district, Integer floorArea, String types);
}
