package HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results;

public class ErrorResult extends Result{
	
	public ErrorResult() { // Sadece işlemin sonucunu döndürür
		super(false);		
	}
	public ErrorResult(String message) {  // işlemin sonucunu ve mesajını döndürür
		super(false, message);		
	}
	
}