package com.xworkz.web.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/")
public class FileUploadController {

	public FileUploadController() {
		System.out.println("created\t" + this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/fileupload", method = RequestMethod.GET)
	public String fileUploadPage(ModelMap model) {
		FileUploadBean files = new FileUploadBean();
		model.addAttribute("files", files);
		return "success";

	}

	@RequestMapping(value = "/fileupload", method = RequestMethod.POST)
	public String onFileUploading(@RequestParam("file") MultipartFile file, ModelMap model) {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				
				String fileName=file.getOriginalFilename();
				
				// Creating the directory to store file
				String rootPath="D:\\";
				
				File dir=new File(rootPath+File.separator+"fileuplaod");
				if(!dir.exists())
				{
					dir.mkdirs();
				}
				
				// Create the file on server
				File serverFile=new File(dir.getAbsolutePath()+File.separator+fileName);
				BufferedOutputStream stream=new BufferedOutputStream(new FileOutputStream(serverFile));
				
				stream.write(bytes);
				stream.close();
				
				model.addAttribute("uploadedFile", "You successfully uploaded file="+fileName);
				return "success";
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			String fileName=file.getOriginalFilename();
			model.addAttribute("uploadedFile", "You failed to upload " + fileName
					+ " because the file was empty.");
			return "success";
		}
		return "success";

	}
}
