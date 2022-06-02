package laptrinhjavaweb.service;

import java.util.List;

import laptrinhjavaweb.model.input.BuildingSearchInput;
import laptrinhjavaweb.model.output.BuildingSearchOutput;


public interface BuildingService {
  
	List<BuildingSearchOutput> findBuilding(BuildingSearchInput buildingSearchFilterInput);
}
