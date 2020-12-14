package com.inesshasnaoui.bibliotheekbeheersysteem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.inesshasanoui.bibliotheekbeheersysteem.model.Reservation;
import com.inesshasanoui.bibliotheekbeheersysteem.model.StateReservation;



public class ReservationDaoDB implements ReservationDao {
	private ConnectDB connectDB;
	
	public ReservationDaoDB(ConnectDB connectDB) {
		super();
		this.connectDB = connectDB;
	}
	

	@Override
	public Reservation insert(Reservation reservation) {
		int id = 0;
		int userId = reservation.getUserId();
		int itemId = reservation.getItemId();
		int copyIdReserved = reservation.getCopyIdReserved();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String reservationDate = dateFormat.format(reservation.getDateReservation());
		String stateReservation =reservation.getStateReservation();
					
		String query = "INSERT INTO reservation";
		query += "(user_id,item_id,copy_id_reserved,date_reservation,state)";
		query += "VALUE ('" + userId + "','" + itemId + "','" + copyIdReserved + "','"+reservationDate + "','" + stateReservation + "')";
		
		id = connectDB.insertQuery(query);
		System.out.println("A new reservation was inserted successfully!" + id);
		reservation.setId(id);
		
		return reservation;
	}

	@Override
	public Reservation update(Reservation reservation) {
		
		int id = reservation.getId();
		int userId = reservation.getUserId();
		int itemId = reservation.getItemId();
		int copyIdReserved = reservation.getCopyIdReserved();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String reservationDate = dateFormat.format(reservation.getDateReservation());
		String stateReservation =reservation.getStateReservation();
		
		String query = "UPDATE reservation SET user_id='" + userId + "'";
		query += ",item_id='" + itemId + "'";
		query += ",copy_id_reserved='" + copyIdReserved + "'";
		query += ",date_reservation='" + reservationDate + "'";
		query += ",state='" +stateReservation + "'";
		query += "WHERE id='" + id + "'";
		connectDB.executeUpdate(query);
		return reservation;
	}

	@Override
	public boolean delete(Reservation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Reservation get(long id) {
		String query = "SELECT * FROM reservation  WHERE id =" + id + " ";
		ResultSet rs = connectDB.selectQuery(query);
		Reservation reservation = null;
		try {
			reservation = extractReservationnFromResultSet(rs);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return reservation;
	}
	@Override
	public List<Reservation> getAlleCurrentReservationsOfItem(int itemId) {
		
		String query = "SELECT * FROM reservation  WHERE item_id ='"+ itemId +"' ";
		query+= "AND state ='"+StateReservation.waitingForReturnCopy+"' ";
		ResultSet rs = connectDB.selectQuery(query);
		List<Reservation>  listReservation= new ArrayList<>();
		try {
			listReservation = extractListReservationFromResultSet(rs);
			System.out.println(listReservation +"listReservation");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listReservation;
	}

	@Override
	public List<Reservation> getAlleNotCompletedReservationsOfItem(int itemId) {
		
		String query = "SELECT * FROM reservation  WHERE item_id ='"+ itemId +"' ";
		query+= "AND state !='"+StateReservation.completed+"' ";
		ResultSet rs = connectDB.selectQuery(query);
		List<Reservation>  listReservation= new ArrayList<>();
		try {
			listReservation = extractListReservationFromResultSet(rs);
			System.out.println(listReservation +"listReservation");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listReservation;
	}

	@Override
	public List<Reservation> getAll() {
		String query = "SELECT * FROM reservation ";
		List<Reservation>  listReservation= new ArrayList<>();
		ResultSet rs = connectDB.selectQuery(query);
		
		try {
			listReservation = extractListReservationFromResultSet(rs);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listReservation;
	}
	
	@Override
	public Reservation getReservationForUserOfItem(int userId, int itemId) {
		String query = "SELECT * FROM reservation  WHERE user_id ='" + userId +"' ";
		query+= "AND item_id = '"+itemId+"'";
		query+= "AND state !='"+StateReservation.completed+"' ";
		ResultSet rs = connectDB.selectQuery(query);
		Reservation reservation = null;
		try {
			reservation = extractReservationnFromResultSet(rs);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return reservation;
	}

	@Override
	public List<Reservation> getAlleReservationsForCopyItem(int copyItemId) {
		
		String query = "SELECT * FROM reservation  WHERE copy_id ='" + copyItemId +"' ";
		query+= "AND state !='"+StateReservation.completed+"' ";
		
		List<Reservation>  listReservation= new ArrayList<>();
		ResultSet rs = connectDB.selectQuery(query);
		
		try {
			listReservation = extractListReservationFromResultSet(rs);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listReservation;
	}

	@Override
	public List<Reservation> getAlleWaitingForReturnReservationsOfItem(int itemId) {
		String query = "SELECT * FROM reservation  WHERE item_id ='"+ itemId +"' ";
		query+= "AND state ='"+StateReservation.waitingForReturnCopy+"' ";
		List<Reservation>  listReservation= new ArrayList<>();
		ResultSet rs = connectDB.selectQuery(query);
		
		try {
			listReservation = extractListReservationFromResultSet(rs);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listReservation;
	}

	
	private Reservation extractReservationnFromResultSet(ResultSet rs) throws SQLException {
		
		Reservation reservation = null;
		int id;
		int userId;
		int itemId;
		int copyIdReserved;
		Date reservationDate;
		String stateReservation;
		
		try {
			if (rs.next()) {

				id = rs.getInt("id");
				userId = rs.getInt("user_id");
				itemId = rs.getInt("item_id");
				copyIdReserved = rs.getInt("copy_id_reserved");
				reservationDate=rs.getDate("date_reservation");
				stateReservation = rs.getString("state");
				
				reservation = new Reservation(id,userId, itemId,copyIdReserved,reservationDate,stateReservation);
				
			}
			return reservation;
		} catch (SQLException ex) {
			return null;
		}
	}
	
	
	private List<Reservation> extractListReservationFromResultSet(ResultSet rs) throws SQLException {
		List<Reservation>  listReservation= new ArrayList<>();
		Reservation reservation = null;
		int id;
		int userId;
		int itemId;
		int copyIdReserved;
		Date reservationDate;
		String stateReservation;
		
		try {
			while (rs.next()) {
				id = rs.getInt("id");
				userId = rs.getInt("user_id");
				itemId = rs.getInt("item_id");
				reservationDate=rs.getDate("date_reservation");
				stateReservation = rs.getString("state");
				copyIdReserved = rs.getInt("copy_id_reserved");
				reservation = new Reservation(id,userId, itemId,copyIdReserved,reservationDate,stateReservation);
				listReservation.add(reservation);
			}
			return listReservation;
		} catch (SQLException ex) {
			return null;
		}
	}


	






}
