package edu.miu.cs.cs472.letexplore.dataaccess;

import java.time.LocalDate;

import edu.miu.cs.cs472.letexplore.model.AddressModel;
import edu.miu.cs.cs472.letexplore.model.NewsModel;
import edu.miu.cs.cs472.letexplore.model.TourGuideModel;
import edu.miu.cs.cs472.letexplore.model.TourLocationModel;
import edu.miu.cs.cs472.letexplore.model.UserModel;
import edu.miu.cs.cs472.letexplore.service.NewsService;
import edu.miu.cs.cs472.letexplore.service.TourGuideService;
import edu.miu.cs.cs472.letexplore.service.TourLocationService;
import edu.miu.cs.cs472.letexplore.service.UsersService;

/**
 * This class loads data into the data repository and also sets up the storage
 * units that are used in the application. The main method in this class must be
 * run once (and only once) before the rest of the application can work
 * properly. It will create three serialized objects in the dataaccess.storage
 * folder.
 * 
 *
 */
public class TestData {

	TourLocationService ci = new TourLocationService();
	TourGuideService tg = new TourGuideService();
	NewsService ng = new NewsService();
	UsersService us = new UsersService();
	

	public static void main(String[] args) {
		TestData td = new TestData();
		DataAccess da = new DataAccessFacade();
		

//		// News ///////////////////////////////////////////
				System.out.println("News Data");
				System.out.println("______________________________________________________");
				td.addNewsData();
				System.out.println("Fetch News Data");
				System.out.println("______________________________________________________");
				System.out.print(td.getNews());
//				System.out.println("Fetch News By Name");
//				System.out.println("______________________________________________________");
//				System.out.print(td.getNewsByTitle("Today News 2"));
////		
		
		
//		//		da.resetEveryThing();
//		
//		// TourLocation ///////////////////////////////////////////
		System.out.println("TourLocation Data");
		System.out.println("______________________________________________________");
		td.addTourLocationData();
		System.out.println("Fetch TourLocation Data");
		System.out.println("______________________________________________________");
		System.out.print(td.getTourLocations());
		System.out.println("Fetch TourLocation By Name");
		System.out.println("______________________________________________________");
		System.out.print(td.getTourLocationsByName("lalibela"));
//		
//		
//		// TourGuide ///////////////////////////////////////////
		System.out.println("TourGuide Data");
		System.out.println("______________________________________________________");
		td.addTourGuideData();
//		
		System.out.println("Fetch TourGuide Data");
		System.out.println("______________________________________________________");
		System.out.print(td.getTourGuides());
//		
		System.out.println("Fetch TourGuide By Name");
		System.out.println("______________________________________________________");
		System.out.print(td.getTourGuideByName("Kan2Pc"));
////		
//		
//		// Users ///////////////////////////////////////////
		System.out.println("Users Data");
		System.out.println("______________________________________________________");
		td.addUserData();
//		
		System.out.println("Fetch Users Data");
		System.out.println("______________________________________________________");
		System.out.print(td.getUsers());
	
	}

//	//TourLocation
	public void addTourLocationData() {
		
		TourLocationModel tourLocation = new TourLocationModel("lalibela3", "In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock", "hot", "Car", "images/location/sites.jpg", LocalDate.now());
		ci.addTourLocation(tourLocation);
		ci.addTourLocationWithParameter("lalibela", "In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock", "hot", "Car", "images/location/sites.jpg", LocalDate.now());
		ci.addTourLocationWithParameter("fasileDes", "In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock", "hot", "Car", "images/location/sites.jpg", LocalDate.now());
		ci.addTourLocationWithParameter("Ras Dashen", "In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock", "hot", "Car", "images/location/sites.jpg", LocalDate.now());
		ci.addTourLocationWithParameter("Aba Gifar", "In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock", "hot", "Car", "images/location/sites.jpg", LocalDate.now());
		ci.addTourLocationWithParameter("Paris", "In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock", "hot", "Car", "images/location/sites.jpg", LocalDate.now());

	}

	public String getTourLocations() {
		return ci.getAllTourLocationDatas();
	}
	
	public String getTourLocationsByName(String name) {
		return ci.getTourLocationByName(name);
	}
//	
//	
//	//TourGuideData
    public void addTourGuideData() {
    	AddressModel add = new AddressModel("4TH", "FairField" , "IOWA" , "52557");
		
		TourGuideModel tourGuide = new TourGuideModel("KanPc" , add , "0932353432" , "adhfja" , "aaa" , "bbb");
		tg.addTourGuideWithParameter("Kan2Pc" , "4TH", "FairField" , "IOWA" , "52557" , "0932353432" , "adhfja" , "aaa" , "images/tourGuideLogo/434319249_237245.jpg");
		tg.addTourGuide(tourGuide);
		tg.addTourGuideWithParameter("Kan3Pc" , "4TH", "FairField" , "IOWA" , "52557" , "0932353432" , "adhfja" , "aaa" , "images/tourGuideLogo/434319249_237245.jpg");
	}
//
	public String getTourGuides() {
		return tg.getAllTourGuideDatas();
	}
//	
	public String getTourGuideByName(String name) {
		return tg.getTourGuideByName(name);
	}
//
//	//NewsData 
//	
	public void addNewsData() {
    	AddressModel add = new AddressModel("4TH", "FairField" , "IOWA" , "52557");	
    	Integer newsID = ng.getAllNewsDatas().length();
		NewsModel news = new NewsModel("New 1" , "In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock" , "DataAccessFinal/images/news/news.jpg" , LocalDate.now());
		ng.addNews(news);
		
		ng.addNewsWithParameter("Today News 2" , "In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock , no one can afford to pass this event" , "images/news/news.jpg" , LocalDate.now());

		ng.addNewsWithParameter("Today News" , "In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock , no one can afford to pass this event" , "images/news/news.jpg" , LocalDate.now());

		ng.addNewsWithParameter("Today News 3" , "In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock , no one can afford to pass this event" , "images/news/news.jpg" , LocalDate.now());
		
		ng.addNewsWithParameter("Today News 4" , "In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock In a mountainous region in the heart of Ethiopia, some 645 km from Addis Ababa, eleven medieval monolithic churches were carved out of rock , no one can afford to pass this event" , "images/news/news.jpg" , LocalDate.now());
	}
//
	public String getNews() {
		return ng.getAllNewsDatas();
	}
//	
	public String getNewsByTitle(String title) {
		return ng.getNewsByTitle(title);
	}
//	
//	//UsersData 
//	
		public void addUserData() {
	    	UserModel user = new UserModel("kal", "tad");
			
			us.addUser(user);
			us.addUserWithParameter("gir", "tek");
			us.addUserWithParameter("tad", "gir");
		}
//
		public String getUsers() {
			return us.getAllUsersDatas();
		}
	
	
	/*
	 * public void bookData() { // ci.addNewBook("23-11451", "The Big Fish", 2,
	 * "Rodney", "Erickson", "09323555478", //
	 * "Rodney Erickson is a content marketing professional at HubSpot, an inbound marketing and sales platform that helps companies attract visitors, convert leads, and close customers. Previously, Rodney worked as a marketing manager for a tech software startup. He graduated with honors from Columbia University with a dual degree in Business Administration and Creative Writing"
	 * , "credentials"); // ci.addNewBook("28-12331", "Antartica", 2, "Mark",
	 * "Gallion", "093255478", //
	 * "As a venture capitalist and an executive at several start-ups, Mark Gallion has different versions of his bio all over the internet. You can imagine some are more formal than others. But when it comes to his Twitter bio, he carefully phrased his information in a way that helps him connect with his audience -- specifically, through the use of humor"
	 * , "credentials"); // ci.addNewBook("99-22223", "Thinking Java", 2, "tadewos",
	 * "teklemariam", "093255478", "hee he is", "credentials"); //
	 * ci.addNewBook("48-56882", "Jimmy's First Day of School", 1, "tadewos",
	 * "teklemariam", "093255478", "hee he is", "credentials");
	 * 
	 * }
	 */

}
