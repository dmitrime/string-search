package aa.algorithms.pool;

import java.util.HashSet;
import java.util.Set;

import aa.algorithms.PatternMatcher;

public class Naive implements PatternMatcher {
	private Set<Integer> found = new HashSet<Integer>();
	private long count = 0;
	
	public void search(String needle, String hay) {
		int m = needle.length();
		int n = hay.length();
		
		for (int i = 0; i <= n-m; i++) {
			int j;
			for (j = 0; j < m; j++) {
				if (needle.charAt(j) != hay.charAt(i+j)) {
					break;
				}
			}
			if (j == m) {
				//found.add(i);
				count++;
			}
		}
	}
	
	public String getName() {
		return "Naive";
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
