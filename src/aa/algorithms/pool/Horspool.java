package aa.algorithms.pool;

import java.util.HashSet;
import java.util.Set;

import aa.algorithms.PatternMatcher;

public class Horspool implements PatternMatcher {
	
	private Set<Integer> found = new HashSet<Integer>();
	private long count = 0;
	
	public void search(String x, String y) {
		int n = y.length();
		int m = x.length();

		int[] bad = new int[256];

		badCharShift(x, bad);
		
		int j = 0;
		int c;
		while (j <= n - m) {
			c = y.charAt(j + m - 1);
			if (x.charAt(m - 1) == c) {
				int k;
				for (k = m-2; k >= 0; k--) {
					if (x.charAt(k) != y.charAt(j + k)) {
						break;
					}
				}
				if (k == -1) {
					count++;
					//found.add(j);
				}
			}
			j += bad[c];
		}
	}
	
	private void badCharShift(String p, int[] bad) {
		int m = p.length();

		for (int i = 0; i < bad.length; i++) {
			bad[i] = m;
		}
		for (int i = 0; i < m - 1; i++) {
			bad[p.charAt(i)] = m - i - 1;
		}
	}
	
	public String getName() {
		return "Hors";
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
