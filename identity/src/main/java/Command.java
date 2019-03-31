import java.io.IOException;
import java.util.List;
 interface Command {

        void run(List<String>arguments);
        default void validateArguments(List<String>arguments, int expectedArgumentsNumber){
           if (arguments.size()!=expectedArgumentsNumber){
               throw new RuntimeException("Niepoprawna liczba argumentow");
           }
        }

}
