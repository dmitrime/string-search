package aa.util.results;

import java.util.HashMap;
import java.util.Map;

public class Results {
	private Map<String, Pair<Long, Long> > res = new HashMap<String, Pair<Long, Long> >();
	
	public void add(String name, long a, long b) {
		res.put(name, new Pair<Long, Long> (a, b));
	}
	
	public Pair<Long, Long> get(String name) {
		return res.get(name);
	}
	
	/*
	public static void main(String args[]) {
		Results rr = new Results();
		
		rr.add("AA", 1, 1);
		rr.add("BB", 11,11);
		rr.add("AA", 2, 2);
		rr.add("CC", 111, 111);
		
		Pair<Long, Long> p = rr.get("AA");
		System.out.println(p.getFirst() + " " + p.getSecond()); 
	    p = rr.get("BB");
		System.out.println(p.getFirst() + " " + p.getSecond()); 
		p = rr.get("CC");
		System.out.println(p.getFirst() + " " + p.getSecond()); 
		
		
	}
	*/
	
}
