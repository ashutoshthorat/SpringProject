package com.bridgelabz.demo.exception;

import java.util.Locale;

import org.springframework.web.bind.annotation.ResponseStatus;

import com.bridgelabz.demo.response.Response;


@ResponseStatus
public class ExceptionHandle extends Exception
 {
	   private static final long serialVersionUID = 1073576132744986874L;

	    protected long errorCode;
	    protected Object[] args;

	    public ExceptionHandle(String cause) {
	        super(cause);
	    }

	    public ExceptionHandle(long errorCode) {
	        this(errorCode, new Object[]{});
	    }

	    public ExceptionHandle(long errorCode, Object[] args) {
	        this(errorCode, args, null);
	    }

	    public ExceptionHandle(long errorCode, Throwable pCause) {
	        this(errorCode, null, pCause);
	    }

	    public ExceptionHandle(long errorCode, Object[] args, Throwable pCause) {
	        super(pCause);
	        this.errorCode = errorCode;
	        this.args = args;
	    }

	    public String getMessage() {
	        return getDisplayMessage();
	    }

	    public String getDisplayMessage() {
	        return getDisplayMessage(Locale.getDefault());
	    }

	    public String getDisplayMessage(Locale locale) {
	        return getMessageInternal(false, locale);
	    }

	    private String getMessageInternal(boolean isLog, Locale plocale) {

	        if (plocale == null) {
	            plocale = Locale.getDefault();
	        }

	        String message = "user not found";
	        if (message == null || message.trim().isEmpty()) {
	        	ExceptionHandle exp = new ExceptionHandle(100);
	            if (isLog) {
	                // Fatal Error
	                return exp.getLogMessage();
	            }
	            // Generic display message for end user
	            return exp.getDisplayMessage(plocale);
	        }

	        String[] msgs = message.split("\\|");
	        if (isLog) {
	            return msgs[0];
	        }

	        if (msgs.length == 1)
	            return msgs[0].trim();

	        if (msgs.length > 1 && !msgs[1].trim().isEmpty()) {
	            return msgs[1].trim();
	        }

	        // Generic display message for end user
	        ExceptionHandle exp = new ExceptionHandle(100);
	        return exp.getDisplayMessage(plocale);
	    }

	    public String getLogMessage() {
	        return getMessageInternal(true, null);
	    }

	    public Object[] getArgs() {
	        return args;
	    }

	    public long getErrorCode() {
	        return errorCode;
	    }

	    public Response getErrorResponse() {
	        return getErrorResponse(Locale.getDefault());
	    }

	    public Response getErrorResponse(Locale locale) {
	        ErrorResponse err = new ErrorResponse();
	        err.setStatusCode(getErrorCode());
	        err.setMessage(getDisplayMessage(locale));

	        return err;
	    }

}
