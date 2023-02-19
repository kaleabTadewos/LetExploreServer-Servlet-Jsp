package edu.miu.cs.cs472.letexplore.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import edu.miu.cs.cs472.letexplore.dataaccess.DataAccess;
import edu.miu.cs.cs472.letexplore.dataaccess.DataAccessFacade;
import edu.miu.cs.cs472.letexplore.model.TourGuideModel;

public class TourGuideRepository {
	
	DataAccess dataAccess = DataAccessFacade.getInstance();
	
	public TourGuideRepository() {
		
	}

     public void addTourGuideData(TourGuideModel tourGuideModel) {
		
		dataAccess.saveNewTourGuides(tourGuideModel);
	}
	
	
	public List<TourGuideModel> getTourGuideData(){
		List<TourGuideModel> tourGuideModels = new ArrayList<>();
		Map<String , TourGuideModel> newTourGuideMap = dataAccess.readTourGuideMap();
		
		Iterator<String> it = newTourGuideMap.keySet().iterator();
		while (it.hasNext()) {
			tourGuideModels.add(newTourGuideMap.get(it.next()));
		}
		
		return tourGuideModels;
	}
}
