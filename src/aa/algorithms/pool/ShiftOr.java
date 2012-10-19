package aa.algorithms.pool;

import java.util.HashSet;
import java.util.Set;

import aa.algorithms.PatternMatcher;

public class ShiftOr implements PatternMatcher {
	
	private Set<Integer> found = new HashSet<Integer>();
	private long count = 0;
	
	public void search(String x, String y) {
		int m = x.length();
		int n = y.length();
		
		if (m > 32) {
			return;
		}
		
		long[] S = new long[256];
		long lim, state, j;
		
		for (int i = 0; i < 256; i++) {
			S[i] = ~0;
		}
		
		j = 1;
		lim = 0;
		for (int i = 0; i < m; i++, j <<= 1) {
			S[x.charAt(i)] &= ~j;
			lim |= j;
		} 
		lim = ~(lim >> 1);
		
		state = ~0;
		for (int i = 0; i < n; i++) {
			state = (state << 1) | (S[y.charAt(i)]);
			if (state < lim) {
				count++;
				//found.add(i - m - 1);
			}
		}
	}

	
	public String getName() {
		return "Or";
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
