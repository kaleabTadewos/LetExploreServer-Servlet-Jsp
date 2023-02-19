package edu.miu.cs.cs472.letexplore.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import edu.miu.cs.cs472.letexplore.dataaccess.DataAccess;
import edu.miu.cs.cs472.letexplore.dataaccess.DataAccessFacade;
import edu.miu.cs.cs472.letexplore.model.TourLocationModel;

public class TourLocationRepository {
	
    DataAccess dataAccess = DataAccessFacade.getInstance();
	
	public TourLocationRepository() {
		
	}

     public void addTourLocationData(TourLocationModel tourLocationModel) {
		
		dataAccess.saveNewTourLocation(tourLocationModel);
	}
	
	
	public List<TourLocationModel> getTourLocationData(){
		List<TourLocationModel> tourLocationModels = new ArrayList<>();
		Map<String , TourLocationModel> tourLocationMap = dataAccess.readTourLocationMap();
		
		Iterator<String> it = tourLocationMap.keySet().iterator();
		while (it.hasNext()) {
			tourLocationModels.add(tourLocationMap.get(it.next()));
		}
		
		return tourLocationModels;
	}
}
