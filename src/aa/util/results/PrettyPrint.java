package aa.util.results;

import java.util.ArrayList;
import java.util.List;

import aa.algorithms.PatternMatcher;
import aa.algorithms.StringSearchAlgorithms;

public class PrettyPrint {
	private int alphabet;
	private List<Pair<Long, StringSearchAlgorithms> > rows = new ArrayList<Pair<Long, StringSearchAlgorithms> >();
	
	public PrettyPrint(int alpha) {
		this.alphabet = alpha;
	}
	
	public void add(int ptrn, StringSearchAlgorithms res) {
		rows.add(new Pair<Long, StringSearchAlgorithms>(new Long(ptrn), res));
	}
	
	public void printConsole() {
		System.out.println("Alphabet of size " + alphabet);
		System.out.println();

		System.out.print("Ptrn\t");
		for (PatternMatcher pm : rows.get(0).getSecond().getAlgos()) {
			System.out.print(pm.getName() + "\t");
		}
		System.out.println();
		
		for (Pair<Long, StringSearchAlgorithms> ssap : rows) {
			Results res = ssap.getSecond().getResults();
			
			System.out.print(ssap.getFirst() + "\t\t");
			
			for (PatternMatcher pm : rows.get(0).getSecond().getAlgos()) {
				
				Pair<Long, Long> p = res.get(pm.getName());
				System.out.print(p.getSecond() + "\t");
			}
			System.out.println();
		}
	}
}
