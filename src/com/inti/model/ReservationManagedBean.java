package com.inti.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.inti.entities.Reservation;
import com.inti.service.impl.ReservationService;
import com.inti.service.interfaces.IReservationService;

@ManagedBean
@SessionScoped
public class ReservationManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Reservation resa = new Reservation();
	private List<Reservation> reservations = new ArrayList<Reservation>();
	IReservationService resaService = new ReservationService();

	public ReservationManagedBean() {
		super();
	}

	public Reservation getResa() {
		return resa;
	}

	public void setResa(Reservation resa) {
		this.resa = resa;
	}

	public List<Reservation> getReservations() {
		reservations = resaService.findAll(Reservation.class);
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@PostConstruct
	public void init() {
		this.reservations = resaService.findAll(Reservation.class);
	}

	public void enregistrerReservation() {
		try {
			resaService.save(this.resa);
			this.resa = new Reservation();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String ajout() {
		return "ajout";
	}

}
