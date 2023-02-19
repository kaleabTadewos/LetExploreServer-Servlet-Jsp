package edu.miu.cs.cs472.letexplore.dataaccess;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import edu.miu.cs.cs472.letexplore.model.NewsModel;
import edu.miu.cs.cs472.letexplore.model.TourGuideModel;
import edu.miu.cs.cs472.letexplore.model.TourLocationModel;
import edu.miu.cs.cs472.letexplore.model.UserModel;

public class DataAccessFacade implements DataAccess {

	enum StorageType {
		TOURLOCATIONS, NEWS , USERS , TOURGUIDES;
	}

	public DataAccessFacade() {
	};

	public static DataAccessFacade getInstance() {
		return new DataAccessFacade();
	}

	public static final String OUTPUT_DIR = "C:\\Users\\tadew\\OneDrive\\Desktop\\WORKSPACE\\Downloads\\WAP Final Project - Kaleab Tadewos 610709(1)\\WAP Final Project - Kaleab Tadewos 610709\\LetExploreProject\\LetExploreProject\\src\\edu\\miu\\cs\\cs472\\letexplore\\dataaccess\\storage";
    
	//	public static final String OUTPUT_DIR = Path  "../src/edu/miu/cs/cs472/letexplore/dataaccess/storage";
//	public static final String OUTPUT_DIR = System.getProperty("user.dir") + "\\LetExploreProject\\src\\edu\\miu\\cs\\cs472\\letexplore\\dataaccess\\storage";
	//public static final String OUTPUT_DIR = System.getProperty("user.dir") + "\\src\\edu\\miu\\cs\\cs472\\letexplore\\dataaccess\\storage";
	public static final String DATE_PATTERN = "MM/dd/yyyy";
	
	
	//Reading the data from files.
	
	@SuppressWarnings("unchecked")
	public Map<String, UserModel> readUserMap() {
	
		return ((Map<String, UserModel>) readFromStorage(StorageType.USERS) == null) ? new HashMap<String, UserModel>()
				: (Map<String, UserModel>) readFromStorage(StorageType.USERS);
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, NewsModel> readNewsMap() {

		return ((Map<String, NewsModel>) readFromStorage(StorageType.NEWS) == null) ? new HashMap<String, NewsModel>()
				: (Map<String, NewsModel>) readFromStorage(StorageType.NEWS);
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, TourLocationModel> readTourLocationMap() {

		return ((Map<String, TourLocationModel>) readFromStorage(StorageType.TOURLOCATIONS) == null) ? new HashMap<String, TourLocationModel>()
				: (Map<String, TourLocationModel>) readFromStorage(StorageType.TOURLOCATIONS);
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, TourGuideModel> readTourGuideMap() {

		return ((Map<String, TourGuideModel>) readFromStorage(StorageType.TOURGUIDES) == null) ? new HashMap<String, TourGuideModel>()
				: (Map<String, TourGuideModel>) readFromStorage(StorageType.TOURGUIDES);
	}

	//Save New Record to File.
	
	public void saveNewUser(UserModel userModel) {
		Map<String, UserModel> users;
		if (!(userModel == null)) {
			if (readUserMap() == null) {
				users = new HashMap<String, UserModel>();
			} else {
				users = readUserMap();
			}
			
			String userId = userModel.getUserName();
			users.put(userId, userModel);
			saveToStorage(StorageType.USERS, users);
		}
	}
	
	
	public void saveNews(NewsModel newModel) {
		Map<String, NewsModel> newModels;
		if (!(newModel == null)) {
			if (readNewsMap() == null) {
				newModels = new HashMap<String, NewsModel>();
			} else {
				newModels = readNewsMap();
			}
			
			String newsID = newModel.getTitle();
			newModels.put(newsID, newModel);
			saveToStorage(StorageType.NEWS, newModels);
		}
	}
	
	
	public void saveNewTourLocation(TourLocationModel tourLocationModel) {
		Map<String, TourLocationModel> tourLocations;
		if (!(tourLocationModel == null)) {
			if (readTourLocationMap() == null) {
				tourLocations = new HashMap<String, TourLocationModel>();
			} else {
				tourLocations = readTourLocationMap();
			}
			
			String name = tourLocationModel.getName();
			tourLocations.put(name, tourLocationModel);
			saveToStorage(StorageType.TOURLOCATIONS, tourLocations);
		}
	}

	
	public void saveNewTourGuides(TourGuideModel tourGuideModel) {
		
		Map<String, TourGuideModel> tourGuides;
		if (!(tourGuideModel == null)) {
			if (readTourGuideMap() == null) {
				tourGuides = new HashMap<String, TourGuideModel>();
			} else {
				tourGuides = readTourGuideMap();
			}
			
			String name = tourGuideModel.getName();
			tourGuides.put(name, tourGuideModel);
			saveToStorage(StorageType.TOURGUIDES, tourGuides);
		}
		
	}
	
	
	public void resetEveryThing() {

		Map<String, UserModel> emptyUserMap = new HashMap<String, UserModel>();
		Map<String, NewsModel> emptyNewModelMap = new HashMap<String, NewsModel>();
		Map<String, TourLocationModel> emptyTourLocationModelMap = new HashMap<String, TourLocationModel>();
		Map<String, TourGuideModel> emptyGuideModelMap = new HashMap<String, TourGuideModel>();

		UserModel initialAdmin = new UserModel("super", "super");
		emptyUserMap.put("super", initialAdmin);
		
		saveToStorage(StorageType.USERS, emptyUserMap);
		saveToStorage(StorageType.NEWS, emptyNewModelMap);
		saveToStorage(StorageType.TOURLOCATIONS, emptyTourLocationModelMap);
		saveToStorage(StorageType.TOURGUIDES, emptyGuideModelMap);
	}

	static void saveToStorage(StorageType type, Object ob) {
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(ob);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
				}
			}
		}
	}

	static Object readFromStorage(StorageType type) {
		ObjectInputStream in = null;
		Object retVal = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
			in = new ObjectInputStream(Files.newInputStream(path));
			retVal = in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
				}
			}
		}
		return retVal;
	}

	final static class Pair<S, T> implements Serializable {

		S first;
		T second;

		Pair(S s, T t) {
			first = s;
			second = t;
		}

		@Override
		public boolean equals(Object ob) {
			if (ob == null)
				return false;
			if (this == ob)
				return true;
			if (ob.getClass() != getClass())
				return false;
			@SuppressWarnings("unchecked")
			Pair<S, T> p = (Pair<S, T>) ob;
			return p.first.equals(first) && p.second.equals(second);
		}

		@Override
		public int hashCode() {
			return first.hashCode() + 5 * second.hashCode();
		}

		@Override
		public String toString() {
			return "(" + first.toString() + ", " + second.toString() + ")";
		}

		private static final long serialVersionUID = 5399827794066637059L;
	}

}
