package com.restapi.assignment.findingnumber.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.restapi.assignment.findingnumber.exception.ExtractNumberFromTextFailedException;
import com.restapi.assignment.findingnumber.response.ResponseHolder;

@Component
public class FindingNumberDetailsFromFileService {
	
	private static final Logger logger = LoggerFactory.getLogger(FindingNumberDetailsFromFileService.class);
	
	private String textReadLineByLine;

	public List<ResponseHolder> numberLocator(File file) {
		
		List<ResponseHolder> list = new ArrayList<>();
		
		try {
			  File myObj = new File(file.getPath());
		      Scanner myReader = new Scanner(myObj);     
		      int lineNumber = 0;
		      
		      //Reading text from the uploaded file Line by Line
		      while (myReader.hasNextLine()) {
		    	  lineNumber++;
		    	ResponseHolder result = new ResponseHolder();
		        textReadLineByLine = myReader.nextLine();
		        
		        //Calling function to get the number of words in the line
		        int numberOfWords = getNumberOfWords(textReadLineByLine);
				
		        //Creating variable to capture the Number and its position in the text
				Map<String,String> numbDetails = new HashMap<>();
				Pattern p = Pattern.compile("\\d+");
				
				//Creating a local index with the maximun number of words in the sentence
				 int[] index = new int[numberOfWords];
				 int i = 0;
				 
				 //using regex Mactcher from java util to match the number in the input text
			        Matcher m = p.matcher(textReadLineByLine);
			        
			        while(m.find()) {
			            logger.info(m.group());
			            if(m.group()!= null) {			            
			            index[i] = textReadLineByLine.indexOf(m.group());
			            logger.info("Text Position:"+index[i]);
			            numbDetails.put("Number :"+m.group()+", Line Number : "+lineNumber, "Number Position:"+String.valueOf(index[i]));
			            i++;
			            }				            
			        }
			        
			    //Setting the Number details to result 
				if (numbDetails.isEmpty()) {
					numbDetails.put("No Number found in this line.", "Line Number: " + lineNumber);
				}
			    result.setNumberDetails(numbDetails);
			    result.setFragment(textReadLineByLine); 
			    result.setNumberOfWordsInTheText(numberOfWords);  	
			    list.add(result);
		        }
		      
		      myReader.close();	
			}
			 
		catch (IOException e) {
			throw new ExtractNumberFromTextFailedException("Could not process the file!", e);
		}	
		return list;
	}
	
	/*
	 * Method to retrieve number of words in a sentence
	 */
	public static int getNumberOfWords(String sentence)
    {
        int counter=0;
        for(int i=0;i<sentence.length();i++)
        {
            if(sentence.charAt(i)==' ')
            counter++;
        }
        return counter+1;
    }

}
