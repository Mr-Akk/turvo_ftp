package accolite.turvo.ftp.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import accolite.turvo.ftp.service.Upload;

@Service
public class UploadImpl implements Upload {


	@Value("${UploadDir}")
	private  String direc;
	public  void UploadFile() {
		FTPClient ftp=new FTPClient();
		
		try {
			ftp.connect("ftp.dlptest.com");
			System.out.println("gdsgdhdf");
			ftp.login("dlpuser","rNrKYTX9g7z3RgJRmxWuGHbeu");
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			ftp.enterLocalPassiveMode();
			InputStream input=new FileInputStream(new File("C:\\Users\\nandhini.r\\Desktop\\sample.txt"));
			ftp.storeFile("/1/Sampletext.txt",input);
			ftp.logout();
			ftp.disconnect();
			System.out.println(direc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
