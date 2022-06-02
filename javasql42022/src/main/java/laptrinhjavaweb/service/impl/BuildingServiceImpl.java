package laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import laptrinhjavaweb.dao.BuildingDAO;
import laptrinhjavaweb.dao.entity.BuildingEntity;
import laptrinhjavaweb.dao.impl.BuildingDaoImpl;
import laptrinhjavaweb.model.input.BuildingSearchInput;
import laptrinhjavaweb.model.output.BuildingSearchOutput;
import laptrinhjavaweb.service.BuildingService;
import laptrinhjavaweb.utils.BuildingTypeUtils;
import laptrinhjavaweb.utils.StringUtils;


public class BuildingServiceImpl implements BuildingService {
         
	private BuildingDAO buildingDao = new BuildingDaoImpl();
	
	@Override
	public List<BuildingSearchOutput> findBuilding(BuildingSearchInput buildingSearchFilterInput) {
		List<BuildingSearchOutput> results = new ArrayList<> ();
		List<BuildingEntity> buildingEntity = buildingDao.findBuilding(buildingSearchFilterInput.getName(), buildingSearchFilterInput.getStreet(), buildingSearchFilterInput.getWard(),
				                                                        buildingSearchFilterInput.getDistrict(), buildingSearchFilterInput.getFloorArea(), buildingSearchFilterInput.getTypes());
		
		for(BuildingEntity item: buildingEntity) {
			BuildingSearchOutput buildingSearchFilterOutput = new BuildingSearchOutput();
			buildingSearchFilterOutput.setId(item.getId());
			buildingSearchFilterOutput.setName(item.getName());
			buildingSearchFilterOutput.setAddress(item.getStreet() + " - " + item.getWard() + " - " + item.getDistrict());
			buildingSearchFilterOutput.setTypes(item.getTypes());
			results.add(buildingSearchFilterOutput);
			
		}
		return results;
	}
	
	private String convertBuildingTypes(String dbType) {
		Map<String, String> typeMap = BuildingTypeUtils.getBuildingType();
		StringBuilder convertedType = new StringBuilder();
		
		if (!StringUtils.isNullOrEmpty(dbType)) {
			String[] dbCode = dbType.split(",");
			for(String code: dbCode) {
					convertedType.append("\n" + typeMap.get(code)); 
			}	
		}
		return convertedType.toString();
	}

}
