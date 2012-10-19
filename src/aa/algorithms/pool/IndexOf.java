package aa.algorithms.pool;

import java.util.HashSet;
import java.util.Set;

import aa.algorithms.PatternMatcher;

public class IndexOf implements PatternMatcher {
	
	private Set<Integer> found = new HashSet<Integer>();
	private long count = 0;
	
	public void search(String needle, String hay) {
		int k = -1;
		while ((k = hay.indexOf(needle, k+1)) != -1) {
			count++;
			//found.add(k);
		}
	}
	
	public String getName() {
		return "indexOf";
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
