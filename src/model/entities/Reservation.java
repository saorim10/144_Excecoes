package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	// Attributes
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	// Constructors
	public Reservation() {
	}
	
	public Reservation(int roomNumber, Date checkin, Date checkout) throws DomainException{
		 
		if (!checkout.after(checkin)) {
			throw new DomainException("Data de entrada posterior a data de saída!!!");
		}
		
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	
	// Getters & Setters
	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}
	
	
	// Methods
	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkin, Date checkout) throws DomainException{
		Date now = new Date();
		
		if (checkin.before(now) || checkout.before(now)) {
			throw new DomainException("Datas inferiores a data atual (hoje)!!!");
		} 
		if (!checkout.after(checkin)) {
			throw new DomainException("Data de entrada posterior a data de saída!!!");
		}
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	@Override
	public String toString() {
		return "Reserva: Quarto "
				+ roomNumber
				+ ", entrada: "
				+ sdf.format(checkin)
				+ ", saída: "
				+ sdf.format(checkout)
				+ ", "
				+ duration()
				+ " noites.";
	}
}
