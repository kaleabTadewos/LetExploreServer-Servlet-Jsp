package edu.miu.cs.cs472.letexplore.dataaccess;

import java.util.Map;

import edu.miu.cs.cs472.letexplore.model.NewsModel;
import edu.miu.cs.cs472.letexplore.model.TourGuideModel;
import edu.miu.cs.cs472.letexplore.model.TourLocationModel;
import edu.miu.cs.cs472.letexplore.model.UserModel;

public interface DataAccess {
	
	public Map<String, UserModel> readUserMap();

	public void saveNewUser(UserModel user);

	public Map<String, TourLocationModel> readTourLocationMap();

	public void saveNewTourLocation(TourLocationModel tourLocation);
	
	public Map<String, NewsModel> readNewsMap();

	public void saveNews(NewsModel newModel);
	
	public void saveNewTourGuides(TourGuideModel newTourGuideModel);
	
	public Map<String, TourGuideModel> readTourGuideMap();
	
	public void resetEveryThing();

}
