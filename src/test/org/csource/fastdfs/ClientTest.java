package org.csource.fastdfs;

import org.csource.common.MyException;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * Created by tangjialin on 2017-02-24 0024.
 */
public class ClientTest {
	@Test
	public void downloadTest () throws IOException, MyException {
		URL resource = Thread.currentThread().getContextClassLoader().getResource("fdfs_client.conf");
		ClientGlobal.init(resource.getPath());
		TrackerClient tracker = new TrackerClient();
		TrackerServer trackerServer = tracker.getConnection();
		StorageServer storageServer = null;
		StorageClient1 client = new StorageClient1(trackerServer, storageServer);
		byte[] bytes = client.download_file1("group1/M00/00/00/wKgZgFicJ0WAc_MgAAAaOIjTsT4409.jpg");
		FileOutputStream fileOutputStream = new FileOutputStream("d:/xxx.jpg");
		fileOutputStream.write(bytes);
		fileOutputStream.close();
	}
}
