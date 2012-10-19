package aa.algorithms.pool;

import java.util.HashSet;
import java.util.Set;

import aa.algorithms.PatternMatcher;

public class KnuthMorrisPratt implements PatternMatcher {
	
	private Set<Integer> found = new HashSet<Integer>();
	private long count = 0;
	
	public void search(String x, String y) {
		int m = x.length();
		int n = y.length();
		
		int i, j;
		int[] next = new int[256];

		prefix(x, next);

		j = -1;
		for (i = 0; i < n; i++) {
			while (true) {
				if (x.charAt(j+1) == y.charAt(i)) {
					j++;
					break;
				} else {
					if (j == -1) { 
						break;
					}
					else { 
						j = next[j] - 1;
					}
				}
			}
			if (j == m-1) {
				count++;
				//found.add(i);
				j = next[j] -1;
			}
		}
	}
	
	void prefix(String p, int next[]) {
		int m = p.length();
		
		next[0] = 0;
		int j = 0;
		for (int k = 1; k < m; k++) {
			while (true) {
				if (p.charAt(j) == p.charAt(k)) {
					j++;
					break;
				} 
				else {
					if (j == 0) {
						break;
					}	
					j = next[j - 1];
				}
			}
			next[k] = j;
		}
	}
	
	public String getName() {
		return "KMP";
	}
	
	public long getCount() {
		return count;
	}
	
	public Set<Integer> getFound() {
		return found;
	}
	
	public void clear() {
		found.clear();
		count = 0;
	}
}