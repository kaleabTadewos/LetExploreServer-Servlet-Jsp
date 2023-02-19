package edu.miu.cs.cs472.letexplore.service;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ImageUploder {
	
	String currentUploadFilePath = null;
	
	String locationName = null;
	String demography = null;
	String transportation = null;
	String history = null;
	
	String title = null;
	String description = null;
	
	String tourGuideName = null;
	String street = null;
	String city = null;
	String state = null;
	String zip = null;
	String phoneNo = null;
	String email = null;
	String website = null;

	public ImageUploder() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean imageUploaderFunctionForTourLocation(HttpServletRequest request, HttpServletResponse response, String dictoryPath, String dictoryPathForDataBase) {
		currentUploadFilePath = dictoryPathForDataBase;
		 
		 try {
			 List<FileItem> multiparts = new ServletFileUpload(
                    new DiskFileItemFactory()).parseRequest(request);

			 for(FileItem item : multiparts){
				 if(item.getFieldName().equals("locationName"))
			        {   
					 locationName = item.getString();
			        }
				 if(item.getFieldName().equals("demography"))
			        {   
					 demography = item.getString();
			        }
				 if(item.getFieldName().equals("transportation"))
			        {   
					 transportation = item.getString();
			        }
				 if(item.getFieldName().equals("history"))
			        {   
					 history = item.getString();
			        }
				 if(!item.isFormField()){
					 String name = new File(item.getName()).getName();
					 currentUploadFilePath += name;
					 item.write( new File(dictoryPath + File.separator + name));
				 }
			 }
			 return true;
		 
		 } catch (Exception e) {
			 e.printStackTrace();
			 return false;
		 }
	 }
	
	public String[] inputFiledsForTourTransportations() {
		String[] inputFiledValues = new String[5];
		inputFiledValues[0] = locationName;
		inputFiledValues[1] = history;
		inputFiledValues[2] = demography;
		inputFiledValues[3] = transportation;
		inputFiledValues[4] = currentUploadFilePath;
		currentUploadFilePath = null;
		return inputFiledValues;
	}
	
	public boolean imageUploaderFunctionForNews(HttpServletRequest request, HttpServletResponse response, String dictoryPath, String dictoryPathForDataBase) {
		currentUploadFilePath = dictoryPathForDataBase;
		 
		 try {
			 List<FileItem> multiparts = new ServletFileUpload(
                   new DiskFileItemFactory()).parseRequest(request);

			 for(FileItem item : multiparts){
				 if(item.getFieldName().equals("title"))
			        {   
					 title = item.getString();
			        }
				 if(item.getFieldName().equals("description"))
			        {   
					 description = item.getString();
			        }
				 if(!item.isFormField()){
					 String name = new File(item.getName()).getName();
					 currentUploadFilePath += name;
					 item.write( new File(dictoryPath + File.separator + name));
				 }
			 }
			 return true;
		 
		 } catch (Exception e) {
			 e.printStackTrace();
			 return false;
		 }
	}
	
	public String[] inputFiledsForNews() {
		String[] inputFiledValues = new String[3];
		inputFiledValues[0] = title;
		inputFiledValues[1] = description;
		inputFiledValues[2] = currentUploadFilePath;
		currentUploadFilePath = null;
		return inputFiledValues;
	}
	
	public boolean imageUploaderFunctionForTourGuide(HttpServletRequest request, HttpServletResponse response, String dictoryPath, String dictoryPathForDataBase) {
		currentUploadFilePath = dictoryPathForDataBase;
		 
		 try {
			 List<FileItem> multiparts = new ServletFileUpload(
                  new DiskFileItemFactory()).parseRequest(request);

			 for(FileItem item : multiparts){
				 if(item.getFieldName().equals("tourGuideName"))
			        {   
					 tourGuideName = item.getString();
			        }
				 if(item.getFieldName().equals("street"))
			        {   
					 street = item.getString();
			        }
				 if(item.getFieldName().equals("city"))
			        {   
					 city = item.getString();
			        }
				 if(item.getFieldName().equals("state"))
			        {   
					 state = item.getString();
			        }
				 if(item.getFieldName().equals("zip"))
			        {   
					 zip = item.getString();
			        }
				 if(item.getFieldName().equals("phoneNo"))
			        {   
					 phoneNo = item.getString();
			        }
				 if(item.getFieldName().equals("email"))
			        {   
					 email = item.getString();
			        }
				 if(item.getFieldName().equals("website"))
			        {   
					 website = item.getString();
			        }
				 if(!item.isFormField()){
					 String name = new File(item.getName()).getName();
					 currentUploadFilePath += name;
					 item.write( new File(dictoryPath + File.separator + name));
				 }
			 }
			 return true;
		 
		 } catch (Exception e) {
			 e.printStackTrace();
			 return false;
		 }
	}
	
	public String[] inputFiledsForTourGuides() {
		String[] inputFiledValues = new String[9];
		inputFiledValues[0] = tourGuideName;
		inputFiledValues[1] = street;
		inputFiledValues[2] = city;
		inputFiledValues[3] = state;
		inputFiledValues[4] = zip;
		inputFiledValues[5] = phoneNo;
		inputFiledValues[6] = email;
		inputFiledValues[7] = website;
		inputFiledValues[8] = currentUploadFilePath;
		currentUploadFilePath = null;
		return inputFiledValues;
	}
}
