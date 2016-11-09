package cn.bling.exception;

@SuppressWarnings("serial")
public class msgException extends Exception{
	public msgException(){
		super();
	}
	public msgException(String msg){
		super(msg);
	}
}
