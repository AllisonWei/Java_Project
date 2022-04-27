package business.exception;

public class CommonException extends RuntimeException {
    //字段的描述
    private static final long serialVersionUID = 1L;
    
    String code;
    
    String message;

    public CommonException(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
