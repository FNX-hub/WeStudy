package logic.model.bean;


//@author Adriano
public class WrongDeclarationCustomException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public WrongDeclarationCustomException (String message){
		super("[CUSTOM-EXCEPTION: WrongDeclaration]:" + message);
	}
	
}
