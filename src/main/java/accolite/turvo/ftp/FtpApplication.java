package accolite.turvo.ftp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import accolite.turvo.ftp.service.Download;
import accolite.turvo.ftp.service.Upload;

@SpringBootApplication
public class FtpApplication {
	
	@Autowired
	Upload upload;
	
	@Autowired
	Download download;

	public static void main(String[] args) {
		SpringApplication.run(FtpApplication.class, args);
	}

}
