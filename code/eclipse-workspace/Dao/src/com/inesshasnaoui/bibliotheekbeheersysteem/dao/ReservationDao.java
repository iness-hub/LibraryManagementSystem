package com.inesshasnaoui.bibliotheekbeheersysteem.dao;

import java.util.List;

import com.inesshasanoui.bibliotheekbeheersysteem.model.Reservation;

public interface ReservationDao extends CrudDao <Reservation>{
	List<Reservation> getAlleReservationsForCopyItem(int copyItemId);
	 Reservation getReservationForUserOfItem(int userId,int itemId);
	// List<Reservation> getAlleReservationsOfItem(int itemId);
	 	 List<Reservation> getAlleCurrentReservationsOfItem(int itemId);
		List<Reservation> getAlleWaitingForReturnReservationsOfItem(int itemId);
		List<Reservation> getAlleNotCompletedReservationsOfItem(int itemId);
}
