import java.util.Arrays;

/**
 * ListArray
 */
public class ListArray<T> implements ListInterface<T> {
  private T[] list = (T[]) new Object[10];
  private int lastIndex = -1;

  public void add(T newEntry) {
    if (!isFull()) {
      lastIndex++;
      list[lastIndex] = newEntry;
    }
  }

  public void add(int position, T newEntry) {
    for(int i=lastIndex+1; i <= position; i++) {
      list[i-1] = list[i];
    }
    list[position] = newEntry;
  }

  public T replace(int position, T newEntry) {
    T oldEntry = list[position];
    list[position] = newEntry;
    return oldEntry;
  }

  public T getEntry(int position) {
    return list[position];
  }

  public T remove(int position) {
    T entry = list[position];
    return entry;
  }

  public void clear() {
    for (int i = 0; i <= lastIndex; i++) {
      list[i] = null;
    }
  }

  public boolean isFull() {
    return lastIndex == 9;
  }

  public T[] toArray() {
    return Arrays.copyOf(list, 10);
  }

  public boolean contains(T anEntry) {
    for (int i = 0; i <= lastIndex; i++) {
      if (list[i] == anEntry)
        return true;
    }
    return false;
  }

  public int getLength() {
    return lastIndex + 1;
  }

  @Override
  public boolean isEmpty() {
    return lastIndex == -1;
  }
}