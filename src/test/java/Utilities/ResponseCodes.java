package Utilities;

public enum ResponseCodes {
    REQUEST_INVALID(422),
    REQUEST_FORBIDDEN(403),
    REQUEST_SUCCESS(201);
     public   int code;
    ResponseCodes(int code)
    {
        this.code=code;
    }


}
