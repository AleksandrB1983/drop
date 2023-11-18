public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String playerName) {
        super("Элемент с идентификатором " + playerName + " не найден");
    }
}
