package edu.miu.cs.cs472.letexplore.service;

public class NewLineRemoverService {
	
	public String newLineRemover(String s) {
		return s.replaceAll("\\r\\n|\\n", "");
	}
}
