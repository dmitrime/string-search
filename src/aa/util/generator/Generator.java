package aa.util.generator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.apache.log4j.Logger;

public class Generator {
	private static final Logger log = Logger.getLogger(Generator.class);

	private String filename;
	private int alphabet;
	private int length;
	
	public Generator(String f, int alpha, int len) {
		this.filename = f;
		this.alphabet = alpha;
		this.length = len;
	}
	
	
	/*
	public static void main(String args[]) {
		Generator gen = new Generator("data/text-test", 128, 100000000);
		try {
		  gen.generate();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	*/
	
	public void generate(boolean doit) {
		// generate or not
		if (doit == false) {
			return;
		}
		
		Random rand = new Random();
		FileWriter fw = null;
		log.info("Generating " + length + " random characters of alphabet " + alphabet);
		
		try {
			fw = new FileWriter(filename);
			for (int i = 0; i < this.length; i++) {
				int r = rand.nextInt(alphabet);
				fw.write(r);
			}
			log.info("Generation complete");
		}
		catch (IOException ex) {
			log.error("Generation error");
			ex.printStackTrace();
		}
        finally {
	        if (fw != null) {
	        	try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
        }
	}
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getAlphabet() {
		return alphabet;
	}
	public void setAlphabet(int alphabet) {
		this.alphabet = alphabet;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
}
