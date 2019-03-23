import java.util.*;
public class MyDeque<E>{
  private E[] data;
  private int size, start, end;
  public static int modulus(int i, int j){
      if(i%j < 0){
          return i%j + j;
      }
      return i%j;
  }
  public static void main(String[] args) {
      MyDeque<Integer> test = new MyDeque<Integer> ();
      test.addFirst(2);
      test.addLast(3);
      test.toDebug();
      System.out.println(test);
      System.out.println(test.size());
      System.out.println(test.getLast());
  }
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
      for(int i = start; i < start + size; i++){
          output += data[i%data.length].toString();
      }
      return "{" + output + "}";
  }

  public void toDebug(){
      for (E i: data){
          System.out.print(i);
      }
      System.out.println();
  }
  public void addFirst(E element){
      if(element == null){
          throw new NullPointerException();
      }
      if(size == data.length){
      resize();
      }
      data[modulus((start-1*(size)),data.length)] = element;
      start = modulus((start-1),data.length);
      size++;
  }

  public void addLast(E element){
      if(element == null){
          throw new NullPointerException();
      }
      if(size == data.length){
      resize();
      }
      data[(end+1)%data.length] = element;
      end = (end+1)%data.length;
      size++;
  }
  public E removeFirst(){
      if(size == 0){
          throw new NoSuchElementException();
      }
      E hold = data[start];
      start = (start+1)%data.length;
      size--;
      return hold;
  }
  public E removeLast(){
      if(size == 0){
          throw new NoSuchElementException();
      }
      E hold = data[end];
      end = (end-1)%data.length;
      size--;
      return hold;
  }
  public E getFirst(){
      if(size == 0){
          throw new NoSuchElementException();
      }
      return data[start];
  }
  public E getLast(){
      if(size == 0){
          throw new NoSuchElementException();
      }
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
