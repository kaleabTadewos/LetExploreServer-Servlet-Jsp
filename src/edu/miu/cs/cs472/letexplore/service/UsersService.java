package edu.miu.cs.cs472.letexplore.service;

import java.util.List;

import edu.miu.cs.cs472.letexplore.model.UserModel;
import edu.miu.cs.cs472.letexplore.repository.RepositoryWrapper;
import edu.miu.cs.cs472.letexplore.repository.UserRepository;

public class UsersService {
	
	private UserRepository userDataRepo = RepositoryWrapper.getUserRepository();
	
	public void addUserWithParameter(String username , String password) {
		UserModel user = new UserModel(username , password);
		userDataRepo.addUserData(user);
	}
	
	public boolean Login(String username , String password) {

		boolean isValidUser = false;
		List<UserModel> users = userDataRepo.getUserData();
		for(UserModel us : users) {
			if(us.getUserName().equals(username) && us.getPassword().equals(password)) {
				isValidUser = true;
				break;
			}
		}
		return isValidUser;
	}
	
	public void addUser(UserModel user) {
		userDataRepo.addUserData(user);
	}
	
	public String getAllUsersDatas(){
		List<UserModel> users = userDataRepo.getUserData();
		StringBuilder jsonString = new StringBuilder();
		
		jsonString.append("[");
		
		for(int i = 0 ; i < users.size() ; i++) {
        	jsonString.append(UsersJson(users.get(i)));
        	if(i != users.size() - 1) {
				jsonString.append(",");
			}
        }
		jsonString.append("]");
		return jsonString.toString();
		
	}
	
	public List<UserModel> getAllUsersDatasList(){
		return userDataRepo.getUserData();
	}
	
	public String UsersJson(UserModel user) {
		return String.format("{\"username\":\"%s\", \"password\":\"%s\"} \n",
				user.getUserName() ,user.getPassword());
	}
	
}
