package com.madak.org.model;

public class CovidDataSource {

	private String Date;
	private String State;
	private String District;
	private long Confirmed;
	private long Recovered;
	private long Deceased;
	private String ZoneStatus;
	private String serviceAvailable;
	
	public CovidDataSource() {
		super();
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public long getConfirmed() {
		return Confirmed;
	}
	public void setConfirmed(long confirmed) {
		Confirmed = confirmed;
	}
	public long getRecovered() {
		return Recovered;
	}
	public void setRecovered(long recovered) {
		Recovered = recovered;
	}
	public long getDeceased() {
		return Deceased;
	}
	public void setDeceased(long deceased) {
		Deceased = deceased;
	}
	public String getZoneStatus() {
		return ZoneStatus;
	}
	public void setZoneStatus(String zoneStatus) {
		ZoneStatus = zoneStatus;
	}
	public String getServiceAvailable() {
		return serviceAvailable;
	}
	public void setServiceAvailable(String serviceAvailable) {
		this.serviceAvailable = serviceAvailable;
	}
	@Override
	public String toString() {
		return "CovidDataSource [Date=" + Date + ", State=" + State + ", District=" + District + ", Confirmed="
				+ Confirmed + ", Recovered=" + Recovered + ", Deceased=" + Deceased + ", ZoneStatus=" + ZoneStatus
				+ ", serviceAvailable=" + serviceAvailable + "]";
	}
	
}
