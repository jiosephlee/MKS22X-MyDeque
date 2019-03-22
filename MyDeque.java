public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
      data = (E[])new Object[10];
      size = 0;
      start = 0;
      end = 0;
  }
  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
      data = (E[])new Object[initialCapacity];
      size = 0;
      start = 0;
      end = 0;
  }
  public int size(){
      return size;
}
  public String toString(){
      String output = "";
      for(int i = start; i < start + end; i++){
          output += data[i%data.length].toString();
      }
      return output;
  }
  public void addFirst(E element){
      if(size == data.length){
      resize();
      }
      if(start == 0){
          start = size;
          data[size] = element;
      } else{
          start--;
          data[start] = element;
      }
  }
  public void addLast(E element){
      if(size == data.length){
      resize();
      }
      data[end+1] = element;
      size++;
  }
  public E removeFirst(){
      E hold = data[start];
      start = (start+1)%data.length;
      size--;
      return hold;
  }
  public E removeLast(){
      E hold = data[end];
      end = (end-1)%data.length;
      size--;
      return hold;
  }
  public E getFirst(){
      return data[start];
  }
  public E getLast(){
      return data[end];
  }
  @SuppressWarnings("unchecked")
  private void resize(){
    E[] newData = (E[])new Object[(size() * 2) + 1];
    for (int x = 0; x < size(); x++){
      newData[x] = data[x];
    }
    data = newData;
  }
}
