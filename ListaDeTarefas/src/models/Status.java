package models;

public enum Status {
	PARA_FAZER("PARA FAZER"),
	TRABALHANDO("TRABALHANDO"),
	ESPERANDO("ESPERANDO"),
	FEITO("FEITO");

	private String status;
	
	private Status(String status) {
		this.status = status;
	}
	
    public String getStatus() {
        return status;
    }
}
