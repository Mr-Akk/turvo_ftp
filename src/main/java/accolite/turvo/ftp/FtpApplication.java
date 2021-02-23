package accolite.turvo.ftp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import accolite.turvo.ftp.service.Download;
import accolite.turvo.ftp.service.Upload;
import accolite.turvo.ftp.service.impl.DownloadImpl;

@SpringBootApplication
public class FtpApplication {
	
	@Autowired
	Upload upload;
	
	@Autowired
	Download download;

	public static void main(String[] args) {
		SpringApplication.run(FtpApplication.class, args);
	}

	@PostConstruct
	public void CallingMethod() {
		upload.UploadFile();
	}
}
