package Model;

public class releationship {
	private int doctor_id,clinic_id;
	private String doctor_name,clinic_name;

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public String getClinic_name() {
		return clinic_name;
	}

	public void setClinic_name(String clinic_name) {
		this.clinic_name = clinic_name;
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public int getClinic_id() {
		return clinic_id;
	}

	public void setClinic_id(int clinic_id) {
		this.clinic_id = clinic_id;
	}

	@Override
	public String toString() {
		return "releationship [doctor_id=" + doctor_id + ", clinic_id=" + clinic_id + ", doctor_name=" + doctor_name
				+ ", clinic_name=" + clinic_name + "]";
	}
	
}
