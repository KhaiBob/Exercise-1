package laptrinhjavaweb.view;

import java.util.List;
import java.util.Scanner;

import laptrinhjavaweb.controller.BuildingController;
import laptrinhjavaweb.model.input.BuildingSearchInput;
import laptrinhjavaweb.model.output.BuildingSearchOutput;

public class BuildingListView {
	
	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		System.out.println("Enter your name: ");
//		String name = in.nextLine();
		String name = null;
		String street = null;
		String ward = null;
		String district = null;
		Integer floorArea = null;
		BuildingSearchInput buildingSearchInput = new BuildingSearchInput();
		buildingSearchInput.setName(name);
		buildingSearchInput.setStreet(street);
		buildingSearchInput.setWard(ward);
		buildingSearchInput.setDistrict(district);
		buildingSearchInput.setFloorArea(floorArea);
		BuildingController buildingController = new BuildingController();
		List<BuildingSearchOutput> buildingSearchOutputs = buildingController.findBuilding(buildingSearchInput);
		for (BuildingSearchOutput item: buildingSearchOutputs) {
			System.out.println("ID: " + item.getId());
			System.out.println("name: " + item.getName());
			System.out.println("Adress: " + item.getAddress());
			System.out.println("Types: " + item.getTypes());
		}
		//in.close();
	}

}
