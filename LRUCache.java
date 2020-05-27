import java.util.Map;
import java.util.HashMap;

class LRUCache {
	//Prestart is a dummy node to signify start of linked list. Next is most recent.
	private Node preStart;
	//Dummy node to signify end of list. Prev is least recent.
	private Node postFinish;
	//Space in the cache
	private int maxSize;
	//How much space is being taken up.
	private int size;
	//Hash map to point to individual members of cache.
	private Map<String, Node> cacheMap;
	
	public LRUCache(int max) {
		//Constructor takes space in cache.
		maxSize = max;
		size = 0;
		cacheMap = new HashMap<String, Node>();
		//No data in dummy nodes.
		preStart = new Node(null);
		postFinish = new Node(null);
		
		//Start pointing to eachother. Prestart has no prev, postfinish has no next.
		preStart.setNext(postFinish);
		postFinish.setPrev(preStart);
	}
	public void use(String x) {
		if(this.cacheMap.containsKey(x)) {
			Node subject = this.cacheMap.get(x);
			removeFromLL(subject);
			addToLL(subject);
		}else {
			//Check to see if max size reached. If so, must remove least recently used.
			if(this.size >= this.maxSize) {
				this.cacheMap.remove(this.postFinish.getPrev().getData());
				removeFromLL(this.postFinish.getPrev());
			}
			Node toAdd = new Node(x);
			this.cacheMap.put(x, toAdd);
			addToLL(toAdd);
		}
	}
	private void addToLL(Node toAdd) {
		//Always add to beginning so change preStart's next pointer.
		Node temp = this.preStart.getNext();
		toAdd.setNext(temp);
		toAdd.setPrev(this.preStart);
		temp.setPrev(toAdd);
		this.preStart.setNext(toAdd);
		this.size++;
	}
	private void removeFromLL(Node toRemove) {
		Node before = toRemove.getPrev();
		Node after = toRemove.getNext();
		before.setNext(after);
		after.setPrev(before);
		this.size--;
	}
	public Node getLeastRecentlyUsed() {
		return this.postFinish.getPrev();
	}
	
	public Node getMostRecentlyUsed() {
		return this.preStart.getNext();
	}
	
	public void print() {
		Node temp = preStart.getNext();
		while(temp.getData() != null) {
			System.out.print(temp.getData()+" ");
			temp = temp.getNext();
		}
		System.out.println();
	}
	
	
	
	
	private class Node{
		String data;
		Node next;
		Node prev;
		
		Node(String x){
			data = x;
			next = null;
			prev = null;
		}
		Node getNext(){
			return next;
		}
		Node getPrev() { 
			return prev;
		}
		void setNext(Node x) {
			next = x;
		}
		void setPrev(Node x) {
			prev = x;
		}
		String getData() {
			return data;
		}
	}
}
