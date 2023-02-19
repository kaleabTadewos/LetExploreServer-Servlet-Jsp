package edu.miu.cs.cs472.letexplore.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import edu.miu.cs.cs472.letexplore.dataaccess.DataAccess;
import edu.miu.cs.cs472.letexplore.dataaccess.DataAccessFacade;
import edu.miu.cs.cs472.letexplore.model.TourLocationModel;
import edu.miu.cs.cs472.letexplore.model.UserModel;

public class UserRepository {
	
	DataAccess dataAccess = DataAccessFacade.getInstance();
	
	public UserRepository() {
		// TODO Auto-generated constructor stub
	}

     public void addUserData(UserModel userModel) {
		
		dataAccess.saveNewUser(userModel);
	}
	
	
	public List<UserModel> getUserData(){
		List<UserModel> userModels = new ArrayList<>();
		Map<String , UserModel> userMap = dataAccess.readUserMap();
		
		Iterator<String> it = userMap.keySet().iterator();
		while (it.hasNext()) {
			userModels.add(userMap.get(it.next()));
		}
		return userModels;
	}

}
