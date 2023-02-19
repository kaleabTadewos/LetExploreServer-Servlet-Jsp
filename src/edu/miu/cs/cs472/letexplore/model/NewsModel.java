package edu.miu.cs.cs472.letexplore.model;

import java.io.Serializable;
import java.time.LocalDate;

final public class NewsModel   implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7751141478673250520L;
	private String title;
	private String description;
	private String imgPath;
	private LocalDate currentDate;

	public NewsModel() {
		// TODO Auto-generated constructor stub
	}

	public NewsModel(String title, String description, String imgPath, LocalDate currentDate) {
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
		return "NewModel [title=" + title + ", description=" + description + ", imgPath=" + imgPath
				+ ", currentDate=" + currentDate + "]";
	}
}
