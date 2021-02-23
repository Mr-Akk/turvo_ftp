package accolite.turvo.ftp.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import accolite.turvo.ftp.service.Download;

@Service
public class DownloadImpl implements Download {

	static String SERVER = "ftp://ftp.dlptest.com/";
    static int PORT = 21;
    static String USERNAME = "dlpuser";
    static String PASSWORD = "rNrKYTX9g7z3RgJRmxWuGHbeu";
     
    private Logger logger = LoggerFactory.getLogger(DownloadImpl.class);
    public void upload(FTPClient ftpClient) {
    	try {
    		ftpClient.connect(SERVER, PORT);
            ftpClient.login(USERNAME, PASSWORD);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            
            String remoteFile1 = "/1/2021/WholeFileWrite.txt";
            File downloadFile1 = new File("C:/Users/akash.m/Downloads/wholefilewrite.txt");
            OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
            boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
            outputStream1.close();
 
            if (success) {
        		logger.info("File #1 has been downloaded successfully.");
            }
            else {
        		logger.info("File #1 download failed");
            }
    	}
    	catch(Exception e) {
    		logger.info("Error occured while uploading file");
    	}
    }
	public void downloadMain() {
		FTPClient ftpClient = new FTPClient();
		upload(ftpClient);
	}
}
