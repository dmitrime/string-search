package aa.util.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;

public class StrReader {
	private static final Logger log = Logger.getLogger(StrReader.class);

	private String filename;
	@SuppressWarnings("unused")
	private int size;
	private String data;
	
	public StrReader(String fl, int sz) {
		this.filename = fl;
		this.size = sz;
	}
	
	public String getResult() {
		return data;
	}
	
	public void clear() {
		data = new String();
	}
	
	public String readAll() {
        char[] buf = null;
        StringBuilder result = new  StringBuilder();
        
	    try {
	        BufferedReader in = new BufferedReader(new FileReader(filename));
	        int block = 1024 * 8;
	        
	        buf = new char[block];
	        int c = 0;
	        while ((c = in.read(buf, 0, block)) != -1) {
	        	//size -= c;
	        	//System.out.println(size);
	        	result.append(buf, 0, c);
	        }
	        
	        in.close();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    	log.error("Reading from " + filename + " failed");
	    }
	    
	    data = new String(result);
	    log.info(data.length() + " characters read from file.");
	    
		return data;
	}
	
	/*
	public static void main(String args[]) {
		StrReader sr = new StrReader("data/text-test", 100000000);
		
		sr.readAll();
		System.out.println("@@@@@@@@@");
		System.out.println(sr.getResult().length());
	}
	*/
}
