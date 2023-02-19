package edu.miu.cs.cs472.letexplore.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.miu.cs.cs472.letexplore.model.NewsModel;
import edu.miu.cs.cs472.letexplore.model.NewsModelList;
import edu.miu.cs.cs472.letexplore.repository.NewsRepository;
import edu.miu.cs.cs472.letexplore.repository.RepositoryWrapper;

public class NewsService {
	
	private NewsRepository newsDataRepo = RepositoryWrapper.getNewsRepository();
	
	public void addNewsWithParameter(String title , String discription , String imgPath , LocalDate date) {
		NewsModel news = new NewsModel(title , discription , imgPath , date);
		newsDataRepo.addNewData(news);
	}
	
	public void addNews(NewsModel news) {
		NewsModel newModel = news;
		newsDataRepo.addNewData(newModel);
	}
	
	public String getAllNewsDatas(){
		List<NewsModel> news = newsDataRepo.getNewsData();
		StringBuilder jsonString = new StringBuilder();
		
		jsonString.append("[");
		
        for(int i = 0 ; i < news.size() ; i++) {
        	
        	NewsModel newA = news.get(i);
        	newA.setImgPath("http://localhost:8080/LetExploreInEclipseFolder/" + newA.getImgPath());
        	jsonString.append(NewsJson(newA));
        	if(i != news.size() - 1) {
				jsonString.append(",");
			}
        }
		jsonString.append("]");
		return jsonString.toString();
	}
	
	public List<NewsModelList> getAllNewsDatasList(){
		List<NewsModelList> newsList = new ArrayList<>();
		List<NewsModel> news = newsDataRepo.getNewsData();
		for(NewsModel newss : news) {
			NewsModelList newdata = new NewsModelList(newss.getTitle(), newss.getDescription(), newss.getImgPath(), newss.getCurrentDate());
			newsList.add(newdata);
		}
		return newsList;
	}
	
	public String getNewsByTitle(String title) {
		List<NewsModel> news = newsDataRepo.getNewsData();
		NewsModel selectedNews = null;
		for(NewsModel newss : news) {
			if(newss.getTitle().equals(title)) {
				selectedNews =  newss;
				break;
			}
		}
		return NewsJson(selectedNews);
	}
	
	public String NewsJson(NewsModel news) {
		return String.format("{\"title\":\"%s\", \"description\":\"%s\", \"imgPath\":\"%s\", \"date\":\"%s\"} \n",
				news.getTitle() ,news.getDescription() ,news.getImgPath(),news.getCurrentDate());
	}
	
}
