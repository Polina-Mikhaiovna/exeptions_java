package MyExceptions;
public class DivisionByZeroException extends Exception{

    public DivisionByZeroException(String message, Exception e){ // Принимает строку сообщения и вышестоящюю ошибку (предка нашего исключени по стектрейсу благодаря которому мы можем создать это исключение)
        super(message, e);
    }
}