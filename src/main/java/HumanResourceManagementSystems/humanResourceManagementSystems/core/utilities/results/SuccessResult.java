package HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results;

public class SuccessResult extends Result{

	public SuccessResult() { // Sadece işlemin sonucunu döndürür
		super(true);		
	}
	public SuccessResult(String message) {  // işlemin sonucunu ve mesajını döndürür
		super(true, message);		
	}

}
