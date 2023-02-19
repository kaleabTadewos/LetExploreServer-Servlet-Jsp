package edu.miu.cs.cs472.letexplore.model;

import java.time.LocalDate;

public class NewsModelList {
	
	/**
	 * 
	 */
	private String title;
	private String description;
	private String imgPath;
	private LocalDate currentDate;

	public NewsModelList() {
		// TODO Auto-generated constructor stub
	}

	public NewsModelList(String title, String description, String imgPath, LocalDate currentDate) {
		super();
		this.title = title;
		this.description = description;
		this.imgPath = imgPath;
		this.currentDate = currentDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public LocalDate getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(LocalDate currentDate) {
		this.currentDate = currentDate;
	}

	@Override
	public String toString() {
		return "NewsModelList [title=" + title + ", description=" + description + ", imgPath=" + imgPath
				+ ", currentDate=" + currentDate + "]";
	}

	
	
	
}
