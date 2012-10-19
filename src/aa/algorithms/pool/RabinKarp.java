package aa.algorithms.pool;

import java.util.HashSet;
import java.util.Set;

import aa.algorithms.PatternMatcher;

public class RabinKarp implements PatternMatcher {
	
	private Set<Integer> found = new HashSet<Integer>();
	private long count = 0;
	
	private final int prime = 65437;
	private final int base = 256;
	
	public void search(String x, String y) {
		int m = x.length();
		int n = y.length();
		
		int i;
		int D = 1;
		int P, T;
		for (i = 0; i< m - 1; i++) {
			D *= base;
			D %= prime;
		}
		
		P = T = 0;
		for (i = 0; i < m; i++) {
			P *= base;
			P += x.charAt(i);
			P %= prime;
			
			T *= base;
			T += y.charAt(i);
			T %= prime;
		}
		
		for (; i < n; i++) {
			if (P == T) {
				int k;
				for (k = 0; k < m; k++) {
					if (x.charAt(k) != y.charAt(i - m + k)) {
						break;
					}
				}
				if (k == m) {			
					count++;
				    //found.add(i);
				}
			}
			if (i == n) {
				break;
			}
			
			T -= D * (int)y.charAt(i - m);
			T %= prime;
			if (T < 0) {
				T += prime;
			}
			T *= base;
			T += y.charAt(i);
			T %= prime; 
		}
	}
	
	public String getName() {
		return "RK";
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
