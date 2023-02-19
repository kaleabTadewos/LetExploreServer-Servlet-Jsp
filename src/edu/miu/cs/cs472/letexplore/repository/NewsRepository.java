package edu.miu.cs.cs472.letexplore.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import edu.miu.cs.cs472.letexplore.dataaccess.DataAccess;
import edu.miu.cs.cs472.letexplore.dataaccess.DataAccessFacade;
import edu.miu.cs.cs472.letexplore.model.NewsModel;

public class NewsRepository {
	
	DataAccess dataAccess = DataAccessFacade.getInstance();

	public NewsRepository() {
		
	}

	public void addNewData(NewsModel newModel) {
		
		dataAccess.saveNews(newModel);
	}
	
	public List<NewsModel> getNewsData(){
		List<NewsModel> newModels = new ArrayList<>();
		Map<String , NewsModel> newModelMap = dataAccess.readNewsMap();
		
		Iterator<String> it = newModelMap.keySet().iterator();
		while (it.hasNext()) {
			newModels.add(newModelMap.get(it.next()));
		}
		
		return newModels;
	}

}
