package aa.algorithms.pool;

import java.util.HashSet;
import java.util.Set;

import aa.algorithms.PatternMatcher;

public class TurboBoyerMoore implements PatternMatcher {
	
	private Set<Integer> found = new HashSet<Integer>();
	private long count = 0;
	
	public void search(String x, String y) {
		int n = y.length();
		int m = x.length();
	
		int[] good = new int[256];
		int[] bad = new int[256];


		badCharShift(x, bad);
		goodSuffixShift(x, good);
		
		int i, j, u, v, badShift, shift, turboShift;
		j = u = 0;
		shift = m;
		while (j <= n - m) {
			i = m - 1;
			while (i >= 0 && x.charAt(i) == y.charAt(i + j)) {
				i--;
				if (u != 0 && i == m - 1 - shift) {
					i -= u;
				}
			}
			if (i < 0) {
				count++;
				//found.add(j);
				
				shift = good[0];
				u = m - shift;
			}
			else {
				v = m - 1 - i;
				turboShift = u - v;
				badShift = bad[y.charAt(i + j)] - m + 1 + i;
				shift = Math.max(turboShift, badShift);
				shift = Math.max(shift, good[i]);
				if (shift == good[i]) {
					u = Math.min(m - shift, v);
				}
				else {
					if (turboShift < badShift) {
						shift = Math.max(shift, u + 1);
					}
					u = 0;
				}
			}
			j += shift;
		}
	}
	
	void suffixes(String p, int[] suff) {
		int m = p.length();
		int f, g, i;

		suff[m - 1] = m;
		g = m - 1;
		f = 0;
		for (i = m - 2; i >= 0; i--) {
			if (i > g && suff[i + m - 1 - f] < i - g) {
				suff[i] = suff[i + m - 1 - f];
			}
			else {
				if (i < g) {
					g = i;
				}
				f = i;
				while (g >= 0 && p.charAt(g) == p.charAt(g + m - 1 - f)) {
					g--;
				}
				suff[i] = f - g;
			}
		}
	}

	
	private void goodSuffixShift(String p, int[] good) {
		int m = p.length();
		int[] suff = new int[256];
		int i, j;

		suffixes(p, suff);

		for (i = 0; i < m; i++)
			good[i] = m;
		
		j = 0;
		for (i = m - 1; i >= 0; i--) {
			if (suff[i] == i + 1) {
				for (; j < m - 1 - i; j++) {
					if (good[j] == m) {
						good[j] = m - 1 - i;
					}
				}
			}
		}
		
		for (i = 0; i <= m - 2; ++i) {
			good[m - 1 - suff[i]] = m - 1 - i;
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
		return "TBM";
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