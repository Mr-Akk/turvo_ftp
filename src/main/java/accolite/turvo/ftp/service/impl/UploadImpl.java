package accolite.turvo.ftp.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import accolite.turvo.ftp.service.Upload;

@Service
public class UploadImpl implements Upload {


	@Value("${Host}")
	private  String host;
	
	@Value("${name}")
	private  String userName;
	
	@Value("${PassWord}")
	private  String pwd;
	
	@Value("${UploadDir}")
	private  String dir;
	
	
    private Logger logger = LoggerFactory.getLogger(UploadImpl.class);

	public  void UploadFile() {
		FTPClient ftp=new FTPClient();	
		try {
			ftp.connect(host);
			ftp.login(userName,pwd);
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			ftp.enterLocalPassiveMode();
			InputStream input=new FileInputStream(new File("C:\\Users\\akash.m\\Desktop\\sample.txt"));
			boolean status=ftp.storeFile("/1/Sampletext.txt",input);
			if(status) {
				logger.info("File successfully uploaded!!");
			}
			else {
				logger.info("File upload failed!!");
			}
			ftp.logout();
			ftp.disconnect();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
