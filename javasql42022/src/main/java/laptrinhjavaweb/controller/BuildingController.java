package laptrinhjavaweb.controller;

import java.util.List;

import laptrinhjavaweb.dao.entity.BuildingEntity;
import laptrinhjavaweb.model.input.BuildingSearchInput;
import laptrinhjavaweb.model.output.BuildingSearchOutput;
import laptrinhjavaweb.service.BuildingService;

import laptrinhjavaweb.service.impl.BuildingServiceImpl;

public class BuildingController {
	
	private BuildingService buildingService = new BuildingServiceImpl();
	
      public List<BuildingSearchOutput> findBuilding(BuildingSearchInput buildingSearchInput) {
    	  
    	 List<BuildingSearchOutput> results = buildingService.findBuilding(buildingSearchInput);
    	 
  		return results;
  	}
      
}
