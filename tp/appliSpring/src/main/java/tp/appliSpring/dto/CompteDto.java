package tp.appliSpring.dto;

//DTO = Data Transfert Object 
//Concept proche : VO : Value Object (ou view)

public class CompteDto {
     
	private Long num;
	private String label;
	private Double solde;
	
	//+get/set, constructeurs , toString()
	@Override
	public String toString() {
		return "CompteDto [num=" + num + ", label=" + label + ", solde=" + solde + "]";
	}
	
	
	public CompteDto() {
		super();
	}


	public CompteDto(Long num, String label, Double solde) {
		super();
		this.num = num;
		this.label = label;
		this.solde = solde;
	}


	public Long getNum() {
		return num;
	}
	
	public void setNum(Long num) {
		this.num = num;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getSolde() {
		return solde;
	}
	public void setSolde(Double solde) {
		this.solde = solde;
	}
	
	
	

}
