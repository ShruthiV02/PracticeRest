package com.restapi.assignment.findingnumber.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.restapi.assignment.findingnumber.constant.Constant;
import com.restapi.assignment.findingnumber.exception.ExtractNumberFromTextFailedException;
import com.restapi.assignment.findingnumber.response.ResponseHolder;
import com.restapi.assignment.findingnumber.service.FileStorageService;
import com.restapi.assignment.findingnumber.service.FindingNumberDetailsFromFileService;

@RestController
public class ExtractDataFromFileController {
	
	 private static final Logger logger = LoggerFactory.getLogger(ExtractDataFromFileController.class);
	
	@Autowired
	private FindingNumberDetailsFromFileService finder;
	
	@Autowired
    private FileStorageService fileStorageService;
	
	@PostMapping("/extractNumericDataFromFileUpload")
	public List<ResponseHolder> findAllNumber(@RequestPart("file") MultipartFile file) {
		//Storing the file in local machine in order to read the content.
		String fileName = fileStorageService.storeFile(file);
		logger.info(fileName);
		List<ResponseHolder> response = new ArrayList<ResponseHolder>();

		File file1 = new File(Constant.FILE_PATH+fileName);
		
		response = finder.numberLocator(file1);
		
		if (response.isEmpty()) {
			throw new ExtractNumberFromTextFailedException("The file is not readable");
		}
		
		return response;
		
	}

}
