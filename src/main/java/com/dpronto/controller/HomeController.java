package com.dpronto.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dpronto.dto.UserDTO;

/**
 * @author Anil
 *
 */
@Controller

public class HomeController 
{
	static Map<String, String> mapForDescCollection=new TreeMap<String, String>();
	FileOutputStream fileOutputStream=null;
	
	 {
		 String path=  "D:/userfile.txt";
		 try {
			fileOutputStream=new FileOutputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	 }
	
@RequestMapping(value="/homepage")
public String viewHomePage(Model model) {

	model.addAttribute("userDTO", new UserDTO());
	return "home";
}	


@RequestMapping(method=RequestMethod.POST,value="/saveuser")
public String createUser(@ModelAttribute("userDTO") UserDTO userDTO,Model model) throws Exception {
	
	UserDTO user = new UserDTO();
	user.setFirstName(userDTO.getFirstName());
	user.setLastName(userDTO.getLastName());
	fileOutputStream.write(userDTO.toString().getBytes());
	fileOutputStream.write(("\n").getBytes());
	
	getsolteddata();
	
	model.addAttribute("msg", "save used");
	return "home";
}	


public static void getsolteddata() throws Exception {
	
	//create one file to write Data
	  BufferedReader reader = new BufferedReader(new FileReader("D:/userfile.txt"));
      Map<String, String> map=new TreeMap<String, String>();
      String line="";
      while((line=reader.readLine())!=null){
          map.put(getField(line),line);
          mapForDescCollection.put(getField(line),line);
      }
      reader.close();
      
      //create one file to save sorted names in ascending and descending order
      FileWriter writer = new FileWriter("D:/sorteduserfile.txt");
      for(String val : map.values()){
          writer.write(val);  
          writer.write('\n');
      }
      writer.close();
}

private static String getField(String line) {
    return line.split(" ")[0];//extract value you want to sort on
}

@RequestMapping(method=RequestMethod.GET,value="/getSortedData")
public String getSortedData(@RequestParam("userAction") String userAction,ModelMap modelMap) throws Exception
{

	if(userAction.equals("ascending")) 
	{
		modelMap.addAttribute("map", mapForDescCollection);
		
		return "home";
		
	}else {
	     Map descendingMap = ((TreeMap<String, String>) mapForDescCollection).descendingMap();

	      System.out.println("Navigable map values: "+descendingMap);
	      modelMap.addAttribute("map", descendingMap);
	      
			return "home";
	
	}
 }	
}
