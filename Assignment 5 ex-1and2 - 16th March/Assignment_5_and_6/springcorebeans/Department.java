package Assignment_5_and_6.springcorebeans;

public class Department {
	private String sbuID;
	private String sbuName;
	private String sbuHead;

	public Department() {
	};

	public Department(String sbuID, String sbuName, String sbuHead) {
		super();
		this.sbuID = sbuID;
		this.sbuName = sbuName;
		this.sbuHead = sbuHead;
	}

	public String getSbuID() {
		return sbuID;
	}

	public void setSbuID(String sbuID) {
		this.sbuID = sbuID;
	}

	public String getSbuName() {
		return sbuName;
	}

	public void setSbuName(String sbuName) {
		this.sbuName = sbuName;
	}

	public String getSbuHead() {
		return sbuHead;
	}

	public void setSbuHead(String sbuHead) {
		this.sbuHead = sbuHead;
	}

	@Override
	public String toString() {
	    return "= SBU [sbuCode=" + sbuID +
	            ", sbuHead=" + sbuHead +
	            ", sbuName=" + sbuName + "]";
	}

}
