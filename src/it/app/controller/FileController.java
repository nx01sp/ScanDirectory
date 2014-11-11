package it.app.controller;

import java.io.File;
import java.nio.file.Path;

import org.apache.commons.io.FileUtils;


public class FileController {
	
	public FileController() {
		
		
	}
	
	
	public boolean validateFile(File file)
	{
		if(file.getName().endsWith(".sql"))
		{
			return true;
			
		}
		return false;
		
	}
	
	public void moveFile(Path fileSrc, Path dirPath, String dstPath) throws Exception
	{
		try{
			String srcfile = dirPath+File.separator+fileSrc.toString();
			
			File dst = new File(dstPath);
			if(!dst.exists())
			{
		        FileUtils.moveFileToDirectory(new File(srcfile), dst, true);
			}else{
		        FileUtils.moveFileToDirectory(new File(srcfile), dst, false);

			}
			
		}catch(Exception e){
			
			throw new Exception("Errore, il file destinazione non esiste sul file system.");
			
		}
		
	}

	

	
}
