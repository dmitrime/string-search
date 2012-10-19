package aa.algorithms;

import java.util.ArrayList;
import java.util.List;

import aa.algorithms.pool.BackwardOracle;
import aa.algorithms.pool.BoyerMoore;
import aa.algorithms.pool.Horspool;
import aa.algorithms.pool.IndexOf;
import aa.algorithms.pool.KnuthMorrisPratt;
import aa.algorithms.pool.Naive;
import aa.algorithms.pool.RabinKarp;
import aa.algorithms.pool.ShiftOr;
import aa.algorithms.pool.Sunday;
import aa.algorithms.pool.TurboBoyerMoore;
import aa.util.results.Results;
import aa.util.timer.Timer;

public class StringSearchAlgorithms {
	private String text;
	private String pattern;
	private List<PatternMatcher> algos = new ArrayList<PatternMatcher>();
	private Results results = new Results();
	
	public StringSearchAlgorithms(String t, String p) {
		this.text = t;
		this.pattern = p;
		
		//add the algorithms
		algos.add(new IndexOf());
		algos.add(new Naive());
		algos.add(new KnuthMorrisPratt());
		algos.add(new RabinKarp());
		algos.add(new BoyerMoore());
		algos.add(new Horspool());
		algos.add(new Sunday());
		algos.add(new TurboBoyerMoore());
	    algos.add(new BackwardOracle());
		algos.add(new ShiftOr());
		
	}
	
	public Results getResults() {
		return results;
	}
	
	public List<PatternMatcher> getAlgos() {
		return algos;
	}
	
	public void run() {
		Timer tm = new Timer();
		
		for (PatternMatcher pm : algos) {
			tm.reset();
			tm.start();
			
			pm.search(pattern, text);
			
			tm.stop();
			results.add(pm.getName(), pm.getCount(), tm.elapsed());
			//System.out.println(pm.getName() + " found " + pm.getCount() + " in " + tm.elapsed() + " ms.");
		}
	}
	
	public void setText(String text) {
		this.text = text;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
}
