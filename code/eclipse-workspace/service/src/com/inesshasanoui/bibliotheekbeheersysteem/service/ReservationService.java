package com.inesshasanoui.bibliotheekbeheersysteem.service;

import java.util.List;

import com.inesshasanoui.bibliotheekbeheersysteem.model.Reservation;

public interface ReservationService {

	Reservation makeReservation (int itemId, int userId);
	Boolean IsItemReserved(int itemId);
	List<Reservation> getAlleCurrentReservationsOfItem(int itemId);
	List<Reservation> getAlleReservationsForCopyItem(int copyItemId);
	Reservation hasUserItemReserved(int userId,int itemId);
	Reservation update(Reservation reservation);
//	Boolean cancelReservation(Reservation reservation)
	//+getAlleCurrentReservationsOfUser(int userId) : List<Reservation>
	List<Reservation> getAll();
	List<Reservation> getAlleWaitingForReturnReservationsOfItem(int itemId);
	List<Reservation> getAlleNotCompletedReservationsOfItem(int itemId);
}
