package edu.miu.cs.cs472.letexplore.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.miu.cs.cs472.letexplore.model.TourGuideModel;
import edu.miu.cs.cs472.letexplore.model.TourGuideModelList;
import edu.miu.cs.cs472.letexplore.model.TourLocationModel;
import edu.miu.cs.cs472.letexplore.model.TourLocationModelList;
import edu.miu.cs.cs472.letexplore.repository.RepositoryWrapper;
import edu.miu.cs.cs472.letexplore.repository.TourLocationRepository;

public class TourLocationService {
	
	private TourLocationRepository tourLocationDataRepo = RepositoryWrapper.getTourLocationRepository();
	
	public void addTourLocationWithParameter(String name , String history , String demography , String transportation , String imgPath , LocalDate createdDate) {
		TourLocationModel tourLocation = new TourLocationModel(name , history , demography , transportation , imgPath , createdDate);
		tourLocationDataRepo.addTourLocationData(tourLocation);
	}
	
	public void addTourLocation(TourLocationModel tourLocation) {
		tourLocationDataRepo.addTourLocationData(tourLocation);
	}
	
	public String getAllTourLocationDatas(){
		List<TourLocationModel> tourLocations = tourLocationDataRepo.getTourLocationData();
		StringBuilder jsonString = new StringBuilder();
		
		jsonString.append("[");
		
        for(int i = 0 ; i < tourLocations.size() ; i++) {
        	
        	TourLocationModel tourLocation = tourLocations.get(i);
        	tourLocation.setImgPath("http://localhost:8080/LetExploreInEclipseFolder/" + tourLocation.getImgPath());
			
        	jsonString.append(TourLocationJson(tourLocation));
        	if(i != tourLocations.size() - 1) {
				jsonString.append(",");
			}
        }
		jsonString.append("]");
		return jsonString.toString();
	}
	
	
	public List<TourLocationModelList> getAllTourLocationDatasList(){
		List<TourLocationModelList> tourlocationlist = new ArrayList<>();
		List<TourLocationModel> tourlocations = tourLocationDataRepo.getTourLocationData();
		for(TourLocationModel tourlocation : tourlocations) {
			TourLocationModelList tourlocationdata = new TourLocationModelList(tourlocation.getName(), tourlocation.getHistory(), tourlocation.getDemography(), tourlocation.getTransportation(), tourlocation.getImgPath(), tourlocation.getCreateDate());
			tourlocationlist.add(tourlocationdata);
		}
		return tourlocationlist;
	}
	
	
	public String getTourLocationByName(String name) {
		List<TourLocationModel> tourLocations = tourLocationDataRepo.getTourLocationData();
		TourLocationModel selectedTourLocation = null;
		for(TourLocationModel tourLocation : tourLocations) {
			if(tourLocation.getName().equals(name)) {
				selectedTourLocation =  tourLocation;
				break;
			}
		}
		
		return TourLocationJson(selectedTourLocation);
	}
	
	public String TourLocationJson(TourLocationModel tourLocation) {
		return String.format("{\"name\":\"%s\", \"history\":\"%s\", \"demography\":\"%s\", \"transportation\":\"%s\", \"imgPath\":\"%s\",\"createDate\":\"%s\"} \n",
				tourLocation.getName() ,tourLocation.getHistory(),tourLocation.getDemography(),tourLocation.getTransportation(),tourLocation.getImgPath(),tourLocation.getCreateDate());
	}
	
}
