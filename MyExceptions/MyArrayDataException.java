package MyExceptions;

public class MyArrayDataException extends Exception{
    public MyArrayDataException(String message){
        super("Arrays data is incorrect");
    }
}
