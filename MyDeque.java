public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
      data = (E[])new Object[10];
}
  public MyDeque(int initialCapacity){
      data = (E[])new Object[initialCapacity];
  }
  public int size(){
      return size;
}
  public String toString(){
      String output = "";
      for(int i = start; i < start + end; i++){
          output += data[i%size()].toString();
      }
      return output;
  }
  public void addFirst(E element){}
  public void addLast(E element){ }
  public E removeFirst(){ }
  public E removeLast(){ }
  public E getFirst(){ }
  public E getLast(){ }
}
