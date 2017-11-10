/**
 * PriorityQueue
 */
public class PriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface<T> {
  SNode front;
  SNode back;

  @Override
  public void add(T newEntry) {
    SNode newNode =  new SNode();
    newNode.setData(newEntry);

    if(back == null) {
      back = newNode;
      front = newNode;
    }
    if (newEntry.compareTo((T)back.getData()) > 0) {
      back.setLink(newNode);
      back = newNode;
    } else if (newEntry.compareTo((T)front.getData()) < 0) {
      newNode.setLink(front);
      front = newNode;
    } else {
      SNode prev = front;
      while(newEntry.compareTo((T)prev.getLink().getData()) < 0) {
        prev = prev.getLink();
      }
      SNode next = prev.getLink();
      prev.setLink(newNode);
      newNode.setLink(next);
    }
  }
  public T remove() {
    SNode removed = front;
    if(back == front) {
      back = null;
      front = null;
    } else {
      front = front.getLink();
    }
    return (T)removed.getData();
  }
  
  public T peek(){
    if (front == null) return null;
    return (T)front.getData();
  }
  
  public boolean isEmpty() {
    return front == null;
  }
  
  public int getSize(){
    if (isEmpty()) return 0;
    int count = 1;
    SNode current = front;
    while(current.getLink() != null) {
      count++;
      current = current.getLink();
    }
    return count;
  }
  
  public void clear() {
    front = null;
    back = null;
  }
  
}