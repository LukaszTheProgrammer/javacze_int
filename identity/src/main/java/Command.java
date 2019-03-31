import java.util.List;

interface Command {

    void run(List<String> arguments);

    default void validateArguments(List<String> arguments, int expectedArgumentsCount) {
        if (arguments.size() != expectedArgumentsCount) {
            throw new RuntimeException("Niewystarczająca liczba argumentów!");
        }
    }
}