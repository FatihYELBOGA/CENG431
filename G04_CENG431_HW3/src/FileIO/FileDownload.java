package FileIO;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileDownload {
	
	
		public static void initDownload(String folderPath,String downnloadPath) throws IOException {
			downloadFile(folderPath,downnloadPath);

		}
	
		 public static void downloadFile(String sourceFilePath, String destinationFilePath) throws IOException {
		        Path sourcePath = Path.of(sourceFilePath);
		        Path destinationFolder = Path.of(destinationFilePath);
		        Path destinationPath = destinationFolder.resolve(sourcePath.getFileName());

		        Files.copy(sourcePath, destinationFolder, StandardCopyOption.REPLACE_EXISTING);

		    }
	   
}
