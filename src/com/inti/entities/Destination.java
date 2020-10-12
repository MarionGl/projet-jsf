package com.inti.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Destination {

	private long idDestination;
	private long longitude;
	private long latitude;
	
	private List<Hotel> hotels;
	

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}


	@OneToMany(mappedBy="destination")
	public List<Hotel> getHotel() {
		return (List<Hotel>) hotels;
	}



	@Override
	public String toString() {
		return "Destination [idDestination=" + idDestination + ", longitude=" + longitude + ", latitude=" + latitude
				+ "]";
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getIdDestination() {
		return idDestination;
	}



	public void setIdDestination(long idDestination) {
		this.idDestination = idDestination;
	}



	public long getLongitude() {
		return longitude;
	}



	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}



	public long getLatitude() {
		return latitude;
	}



	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}



	public Destination() {
		super();
	}


	public Destination(long idDestination, long longitude, long latitude, List<Hotel> hotels) {
		super();
		this.idDestination = idDestination;
		this.longitude = longitude;
		this.latitude = latitude;
		this.hotels = hotels;
	}




	
}
