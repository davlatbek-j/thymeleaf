package uz.blacknet.thymeleaf.exception;

public class ApiException extends RuntimeException
{
    public ApiException(String message)
    {
        super(message);
    }
}
