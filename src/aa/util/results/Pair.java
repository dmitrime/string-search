package aa.util.results;

public class Pair<T, S> {
	private T first;
	private S second;
	
	public Pair(T f, S s) {
		this.first = f;
		this.second = s;
	}
	
	public T getFirst() {
		return first;
	}
	public void setFirst(T first) {
		this.first = first;
	}
	public S getSecond() {
		return second;
	}
	public void setSecond(S second) {
		this.second = second;
	}
}
