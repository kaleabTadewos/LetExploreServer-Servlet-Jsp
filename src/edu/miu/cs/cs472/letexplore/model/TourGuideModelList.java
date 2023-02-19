package edu.miu.cs.cs472.letexplore.model;

 public class TourGuideModelList{
	
	private String name;
	private AddressModel addressModel;
	private String phoneNo;
	private String email;
	private String website;
	private String logoPath;

	public TourGuideModelList() {
		// TODO Auto-generated constructor stub
	}

	public TourGuideModelList(String name, AddressModel addressModel, String phoneNo, String email, String website,
			String logoPath) {
		super();
		this.name = name;
		this.addressModel = addressModel;
		this.phoneNo = phoneNo;
		this.email = email;
		this.website = website;
		this.logoPath = logoPath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddressModel getAddress() {
		return addressModel;
	}

	public void setAddress(AddressModel addressModel) {
		this.addressModel = addressModel;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	@Override
	public String toString() {
		return "TourGuideModel [name=" + name + ", address=" + addressModel.toString() + ", phoneNo="
				+ phoneNo + ", email=" + email + ", website=" + website + ", logoPath=" + logoPath + "]";
	}
	
	

}
