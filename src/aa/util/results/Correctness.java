package aa.util.results;

import aa.algorithms.PatternMatcher;
import aa.algorithms.StringSearchAlgorithms;

public class Correctness {
	private StringSearchAlgorithms ssa;
	
	public Correctness(StringSearchAlgorithms s) {
		this.ssa = s; 
	}
	
	public void check() throws Exception {
		Results r = ssa.getResults();
		Long prev = new Long(-1);
		PatternMatcher prevm = null;
		
		for (PatternMatcher pm : ssa.getAlgos()) {
			Long c = r.get(pm.getName()).getFirst();
			
			if (c.compareTo(prev) != 0 && prev.compareTo(new Long(-1)) != 0) {
				throw new Exception(pm.getName() + " found " 
						+ c + ", but " + prevm.getName() + " found " + prev + " matches!");
			}
			
			prev = c;
			prevm = pm;
		}
	}
}
