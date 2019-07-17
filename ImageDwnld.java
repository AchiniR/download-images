package cs;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ImageDwnld {
	private static String webpage = "http://www.pdn.ac.lk/";
	private static String folderPath="C:\\Users\\Achini\\Desktop\\images";
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Document doc=Jsoup.connect(webpage).get();
		Elements imgs = doc.getElementsByTag("img");
		
		for(Element img:imgs) {
			String src = img.absUrl("src");
			getImages(src);
		}

	}
	
	public static void getImages(String src) throws IOException {
		URL url = new URL(src);
        InputStream in = url.openStream();
        int indexname = src.lastIndexOf("/");
        
        if (indexname == src.length()) {
            src = src.substring(1, indexname);
        }
 
        indexname = src.lastIndexOf("/");
        String name = src.substring(indexname, src.length());
 
        System.out.println(name);
 
        OutputStream out = new BufferedOutputStream(new FileOutputStream( folderPath+name));
 
        for (int b; (b = in.read()) != -1;) {
            out.write(b);
        }
        out.close();
        in.close();
		
	}

}
