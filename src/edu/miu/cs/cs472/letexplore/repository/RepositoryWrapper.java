package edu.miu.cs.cs472.letexplore.repository;

public class RepositoryWrapper {
	
	public static NewsRepository getNewsRepository() {
		return new NewsRepository();
	}
	
	public static TourGuideRepository getTourGuideRepository() {
		return new TourGuideRepository();
	}
	
	public static TourLocationRepository getTourLocationRepository() {
		return new TourLocationRepository();
	}
	
	public static UserRepository getUserRepository() {
		return new UserRepository();
	}
}
