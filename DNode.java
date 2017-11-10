/**
 * class implementing a double-linked node
 * @author Talor Anderson
 * @version 1.0
 */
 public class DNode<T> {
  T data;
  DNode front;
  DNode back;
  
  public DNode(){ this(null,null,null); }
  public DNode(T data){ this(data,null,null); }
  
  public DNode(T nodeData, DNode frontNode, DNode backNode) {
    data = nodeData;
    front = frontNode;
    back = backNode;
  }
  
  public void setData(T newData)      { data = newData; }
  public void setFront(DNode newPrev) { front = newPrev; }
  public void setBack(DNode newNext)  { back = newNext; }
  
  public T getData()      { return data; }
  public DNode getFront() { return front; }
  public DNode getBack()  { return back; }
}