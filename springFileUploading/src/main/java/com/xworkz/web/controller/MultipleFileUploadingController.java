package com.xworkz.web.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/")
public class MultipleFileUploadingController {
	public MultipleFileUploadingController() {
		System.out.println("created\t" + this.getClass().getSimpleName());
	}

	@RequestMapping("/multipleFile")
	public String onClickUploading(@RequestParam("fileName") String[] names,
			@RequestParam("files") MultipartFile[] file, ModelMap model) {

		if (names.length != file.length) {
			return "Mondatary information missing";
		} else {

			for (int i = 0; i < file.length; i++) {
				MultipartFile file1 = file[i];
				String name = names[i];

				try {

					byte[] bytes = file1.getBytes();

					// Creating the directory to store file
					String rootpath = "D:\\";
					File dir = new File(rootpath + File.separator + "fileuplaod");
					
					if(!dir.exists()) {
						dir.mkdirs();
					}
					
					// Create the file on server
					File serverFile=new File(dir.getAbsolutePath()+File.separator+name);
					BufferedOutputStream stream=new BufferedOutputStream(new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();
					
					model.addAttribute("file1", "You successfully uploaded file=" + name);
					return "multiSuccess";

				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}
		return null;

	}
}
