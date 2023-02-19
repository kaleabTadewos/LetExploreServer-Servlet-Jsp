package edu.miu.cs.cs472.letexplore.service;

public class ServiceWrapper {
	
	public static UsersService getUsersService() {
		return new UsersService();
	}
	
	public static TourLocationService getTourLocationService() {
		return new TourLocationService();
	}
	
	public static TourGuideService getTourGuideService() {
		return new TourGuideService();
	}
	
	public static ImageUploder getImageUploder() {
		return new ImageUploder();
	}
	
	public static NewsService getNewsService() {
		return new NewsService();
	}
	
	public static NewLineRemoverService getNewLineRemoverService() {
	    return new NewLineRemoverService();
	  }
}