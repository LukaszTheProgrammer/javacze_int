import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stack<T> {
  private final   List<T> list = new ArrayList<>();


    public Stack() {
    }

    public Stack(T arg, T... args) {

        list.add(arg);
        list.addAll(Arrays.asList(args));
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }
    public void add(T e){

        list.add(e);
    }
    public T pop(){
        if (list.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }else {

          T stackpoped=  list.get(list.size()-1);
          list.remove(list.size()-1);
            return stackpoped;
        }


    }

}
