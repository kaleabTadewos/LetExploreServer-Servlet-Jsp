package edu.miu.cs.cs472.letexplore.model;

import java.time.LocalDate;
import java.util.List;

public class TourLocationModelList{
	
	private String name;
	private String history;
	private String demography;
	private String transportation;
	private String imgPath;
	private LocalDate createDate;
	private List<TourGuideModel> tourGuides;

	public TourLocationModelList() {
		// TODO Auto-generated constructor stub
	}

	public TourLocationModelList(String name, String history, String demography,
			String transportation, String imgPath, LocalDate createDate) {
		super();
		this.name = name;
		this.history = history;
		this.demography = demography;
		this.transportation = transportation;
		this.imgPath = imgPath;
		this.createDate = createDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getDemography() {
		return demography;
	}

	public void setDemography(String demography) {
		this.demography = demography;
	}

	public String getTransportation() {
		return transportation;
	}

	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	
	public List<TourGuideModel> getTourGuides() {
		return tourGuides;
	}

	public void setTourGuides(List<TourGuideModel> tourGuides) {
		this.tourGuides = tourGuides;
	}

	@Override
	public String toString() {
		return "TourLocationModel [name=" + name + ", history=" + history
				+ ", demography=" + demography + ", transportation=" + transportation + ", imgPath=" + imgPath
				+ ", createDate=" + createDate + "]";
	}
}
