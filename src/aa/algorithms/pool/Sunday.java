package aa.algorithms.pool;

import java.util.HashSet;
import java.util.Set;

import aa.algorithms.PatternMatcher;

public class Sunday implements PatternMatcher {
	
	private Set<Integer> found = new HashSet<Integer>();
	private long count = 0;
	
	public void search(String x, String y) {
		int n = y.length();
		int m = x.length();

		int[] bad = new int[256];

		badCharShift(x, bad);
		
		int j = 0;
		while (j <= n - m) {
			int k;
			for (k = 0; k < m; k++) {
				if (x.charAt(k) != y.charAt(k + j)) {
					break;
				}
			}
			if (k == m) {
				count++;
				//found.add(j);
			}
			if (j + m >= n) {
				break;
			}
			
			j += bad[y.charAt(j + m)];
		}
	}
	
	private void badCharShift(String p, int[] bad) {
		int m = p.length();
		
		for (int i = 0; i < bad.length; ++i) {
			bad[i] = m + 1;
		}
		for (int i = 0; i < m; ++i) {
			bad[p.charAt(i)] = m - i;
		}
	}
	
	public String getName() {
		return "Sunday";
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
