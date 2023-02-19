package edu.miu.cs.cs472.letexplore.service;

import java.util.ArrayList;
import java.util.List;

import edu.miu.cs.cs472.letexplore.model.AddressModel;
import edu.miu.cs.cs472.letexplore.model.NewsModel;
import edu.miu.cs.cs472.letexplore.model.NewsModelList;
import edu.miu.cs.cs472.letexplore.model.TourGuideModel;
import edu.miu.cs.cs472.letexplore.model.TourGuideModelList;
import edu.miu.cs.cs472.letexplore.model.TourLocationModel;
import edu.miu.cs.cs472.letexplore.repository.RepositoryWrapper;
import edu.miu.cs.cs472.letexplore.repository.TourGuideRepository;

public class TourGuideService {
	
	private TourGuideRepository tourGuideDataRepo = RepositoryWrapper.getTourGuideRepository();
	
	public void addTourGuideWithParameter(String name , String street , String city , String state , String zip, String phoneNo , String email , String website , String logoPath) {
		AddressModel address = new AddressModel(street , city , state , zip);
		TourGuideModel tourGuide = new TourGuideModel(name , address , phoneNo , email , website , logoPath);
		tourGuideDataRepo.addTourGuideData(tourGuide);
	}
	
	public void addTourGuide(TourGuideModel tourGuide) {
		tourGuideDataRepo.addTourGuideData(tourGuide);
	}
	
	
	
	public String getAllTourGuideDatas(){
		List<TourGuideModel> tourGuides = tourGuideDataRepo.getTourGuideData();
		StringBuilder jsonString = new StringBuilder();
		
		jsonString.append("[");
		
		for(int i = 0 ; i < tourGuides.size() ; i++) {
			
			TourGuideModel tourGuide = tourGuides.get(i);
			tourGuide.setLogoPath("http://localhost:8080/LetExploreInEclipseFolder/" + tourGuide.getLogoPath());
			
        	jsonString.append(TourGuideJson(tourGuide));
        	if(i != tourGuides.size() - 1) {
				jsonString.append(",");
			}
        }
		jsonString.append("]");
		return jsonString.toString();
	}
	
	public List<TourGuideModelList> getAllTourGuideDatasList(){
		List<TourGuideModelList> tourguidelist = new ArrayList<>();
		List<TourGuideModel> tourguides = tourGuideDataRepo.getTourGuideData();
		for(TourGuideModel tourguide : tourguides) {
			TourGuideModelList tourguidedata = new TourGuideModelList(tourguide.getName(), tourguide.getAddress(), tourguide.getPhoneNo(), tourguide.getEmail(), tourguide.getWebsite(), tourguide.getLogoPath());
			tourguidelist.add(tourguidedata);
		}
		return tourguidelist;
	}
	
	public String getTourGuideByName(String name) {
		List<TourGuideModel> tourGuides = tourGuideDataRepo.getTourGuideData();
		TourGuideModel selectedTourGuide = null;
		for(TourGuideModel tourGuide : tourGuides) {
			if(tourGuide.getName().equals(name)) {
				selectedTourGuide =  tourGuide;
				break;
			}
		}
		return TourGuideJson(selectedTourGuide);
	}
	
	public String TourGuideJson(TourGuideModel tourGuide) {
		return String.format("{\"name\":\"%s\", \"address\":\"%s\", \"phoneNo\":\"%s\", \"email\":\"%s\", \"website\":\"%s\",\"logoPath\":\"%s\"} \n",
				tourGuide.getName() ,tourGuide.getAddress(),tourGuide.getPhoneNo(),tourGuide.getEmail(),tourGuide.getWebsite(),tourGuide.getLogoPath());
	}
	
}
