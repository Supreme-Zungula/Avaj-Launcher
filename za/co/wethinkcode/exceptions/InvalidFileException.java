import java.lang.RuntimeException;

public class InvalidFileException extends Exception
{
    public InvalidFileException(String message)
    {
        super(message);
    }
}