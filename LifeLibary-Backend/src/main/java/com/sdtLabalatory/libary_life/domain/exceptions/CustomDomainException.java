package com.sdtLabalatory.libary_life.domain.exceptions;

public class CustomDomainException extends RuntimeException {

	private static final long serialVersionUID = 1137954500153663068L;

	public CustomDomainException() {
		// TODO Auto-generated constructor stub
	}

	public CustomDomainException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public CustomDomainException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public CustomDomainException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public CustomDomainException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
