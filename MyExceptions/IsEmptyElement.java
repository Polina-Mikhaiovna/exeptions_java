package MyExceptions;
public class IsEmptyElement {
    
    public boolean IsEmpty(Object object) throws EmptyElementException{
        System.out.println("Checking is start");
        boolean flag = false;
        if (object == null){
            throw new EmptyElementException("This obgect is empty");
        } else flag = true;
        return flag;
    }
}
