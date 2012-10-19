package aa.tester;

import org.apache.log4j.Logger;

import aa.algorithms.StringSearchAlgorithms;
import aa.util.generator.Generator;
import aa.util.reader.StrReader;
import aa.util.results.Correctness;
import aa.util.results.PrettyPrint;
import aa.util.timer.Timer;

public class AlgorithmTester {
	
	public static String PatternFile = "data/ptrn";
	public static String TextFile = "data/text";
	public static int InputLength = 100000000; // ~95MB
	
	public static int TextFrom = 1;
	public static int TextTo = 128;
	
	public static int PtrnFrom = 1;
	public static int PtrnTo = 128;
	
	private static final Logger log = Logger.getLogger(AlgorithmTester.class);
	
	public static void main(String[] args) {
		Timer testing = new Timer();
		testing.start();
		log.info("Testing phase has started.");
		
        /*
         * Test begin.
         */
		for (int i = TextFrom; i <= TextTo; i <<= 1) { //alphabet
			//text
			Generator gen1 = new Generator(TextFile, i, InputLength);
			gen1.generate(true);
			StrReader tr = new StrReader(TextFile, InputLength);
			tr.readAll();
			
			PrettyPrint pp = new PrettyPrint(i);
			for (int j = PtrnFrom; j <= PtrnTo; j <<= 1) {
				//pattern
				Generator gen2 = new Generator(PatternFile, i, j);
				gen2.generate(true);
				
				StrReader pr = new StrReader(PatternFile, j);
				pr.readAll();
				
				StringSearchAlgorithms ssa = new StringSearchAlgorithms(tr.getResult(), pr.getResult());
				ssa.run();
				
				Correctness cr = new Correctness(ssa);
				try {
					cr.check();
				}
				catch (Exception ex) {
					System.err.println(ex);
					log.error("Correctness failed: " + ex);
				}
				
				pp.add(j, ssa);
			}
			pp.printConsole();
		}
		
		/*
		 * Test end.
		 */
		testing.stop();
		log.info("Tesing phase is over.");
		log.info("Testing took " + (testing.elapsed()/1000) + " seconds.");
	}
}
