package FileIO;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileDownload {
	
	
		public static void initDownload(String path,String downloadPath) throws IOException {
            downloadFile(path, downloadPath);

		}
	
	   public static void downloadFile(String fileUrl, String downloadPath) throws IOException {
	        URL url = new URL(fileUrl);
	        try (InputStream in = new BufferedInputStream(url.openStream())) {
	            Path outputPath = Path.of(downloadPath);
	            Files.copy(in, outputPath, StandardCopyOption.REPLACE_EXISTING);
	        }
	    }
}
