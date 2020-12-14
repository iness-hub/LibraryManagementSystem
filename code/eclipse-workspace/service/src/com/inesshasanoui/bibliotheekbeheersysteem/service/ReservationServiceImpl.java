package com.inesshasanoui.bibliotheekbeheersysteem.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.inesshasanoui.bibliotheekbeheersysteem.model.CopyItem;
import com.inesshasanoui.bibliotheekbeheersysteem.model.CopyState;
import com.inesshasanoui.bibliotheekbeheersysteem.model.Reservation;
import com.inesshasanoui.bibliotheekbeheersysteem.model.UserState;
import com.inesshasnaoui.bibliotheekbeheersysteem.dao.CopyItemDao;
import com.inesshasnaoui.bibliotheekbeheersysteem.dao.ReservationDao;

public class ReservationServiceImpl implements ReservationService {
	private ReservationDao reservationDao;
	private CopyItemDao copyItemDao;
	
	public ReservationServiceImpl(ReservationDao reservationDao,CopyItemDao copyItemDao) {
		super();
		this.reservationDao = reservationDao;
		this.copyItemDao=copyItemDao;
	}


	@Override
	public Reservation makeReservation(int itemId, int userId) {
		
		 Date dateReservation = new Date();
		 String stateReservation;//="waitingForLending";
		 int copyIdReserved = 0;
		 
		List <CopyItem>list = new ArrayList<>();
		list = copyItemDao.getAllAvailableCopyItemsForItem(itemId);
		int i=0;
		if (!list.isEmpty()) {
			CopyItem copyItem= list.get(0);
			copyIdReserved = copyItem.getId();
			copyItem.setState(CopyState.reserved.toString());
			copyItemDao.update(copyItem);
			 stateReservation="waitingForLending";
			}else 
			{
				 stateReservation="waitingForReturnCopy";
			}
		Reservation reservation=new Reservation( userId,  itemId, copyIdReserved, dateReservation, stateReservation);
		reservationDao.insert(reservation);
		//System.out.println(hasUserItemReserved( userId, itemId).getId()+"hasUserItemReserved");
			return reservation;
	}

	@Override
	public Boolean IsItemReserved(int itemId) {
		System.out.println(reservationDao.getAlleCurrentReservationsOfItem(itemId));
		return  reservationDao.getAlleCurrentReservationsOfItem(itemId)!= null;
		
	}
	
	@Override
	public List<Reservation> getAlleNotCompletedReservationsOfItem(int itemId){
		return  reservationDao.getAlleNotCompletedReservationsOfItem(itemId);
	}

	@Override
	public List<Reservation> getAlleCurrentReservationsOfItem(int itemId) {
		return  reservationDao.getAlleCurrentReservationsOfItem(itemId);
	}

	@Override
	public List<Reservation> getAlleWaitingForReturnReservationsOfItem(int itemId) {
		return  reservationDao.getAlleWaitingForReturnReservationsOfItem(itemId);
	}
	@Override
	public List<Reservation> getAlleReservationsForCopyItem(int copyItemId) {
		// TODO Auto-generated method stub 
		// return reservationDao.getAlleReservationsForCopyItem
		return null;
	}


	@Override
	public Reservation hasUserItemReserved(int userId,int itemId){
		return reservationDao.getReservationForUserOfItem(userId,itemId);
		
	}


	@Override
	public Reservation update(Reservation reservation) {
		return reservationDao.update(reservation);
	}


	@Override
	public List<Reservation> getAll() {
		return reservationDao.getAll();
	}

}
