package aa.algorithms.pool;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

import aa.algorithms.PatternMatcher;

public class BackwardOracle implements PatternMatcher {
	
	private Set<Integer> found = new HashSet<Integer>();
	private long count = 0;
	
	private final int base = 256;
	
	public void search(String x, String y) {
		int[] D = new int[base * base];
		int[] S = new int[base];
		int m = x.length();
		int n = y.length();
		
		Arrays.fill(D, 0, D.length, -1);
		
		S[m] = -1;
		for (int j = m -1; j >= 0; j--) {
			D[(j+1)*base + x.charAt(j)] = j;
			int k = S[j+1];
			
			while (k != -1 && D[k*base + x.charAt(j)] == -1) {
				D[k*base + x.charAt(j)] = j;
				k = S[k];
			}
			if (k == -1) {
				S[j] = m;
			}
			else {
				S[j] = D[k*base + x.charAt(j)];
			}
		}
		
		int pos = 0;
		while (pos <= n-m) {
			int c = m;
			int j = m - 1;
			
			while (j >= 0 && c != -1) {
				c = D[c*base + y.charAt(pos + j)];
				j--;
			}
			if (c != -1) {
				count++;
				//found.add(pos);
			}
			pos += (j+2);
		}
	}
	
	public String getName() {
		return "BOM";
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
