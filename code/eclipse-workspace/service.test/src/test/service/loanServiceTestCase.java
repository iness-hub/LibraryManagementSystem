package test.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import com.inesshasanoui.bibliotheekbeheersysteem.model.Constants;
import com.inesshasanoui.bibliotheekbeheersysteem.model.CopyItem;
import com.inesshasanoui.bibliotheekbeheersysteem.model.CopyState;
import com.inesshasanoui.bibliotheekbeheersysteem.model.Item;
import com.inesshasanoui.bibliotheekbeheersysteem.model.Loan;
import com.inesshasanoui.bibliotheekbeheersysteem.model.Reservation;
import com.inesshasanoui.bibliotheekbeheersysteem.service.CopyItemService;
import com.inesshasanoui.bibliotheekbeheersysteem.service.ItemService;
import com.inesshasanoui.bibliotheekbeheersysteem.service.LoanService;
import com.inesshasanoui.bibliotheekbeheersysteem.service.LoanServiceImpl;
import com.inesshasanoui.bibliotheekbeheersysteem.service.ReservationService;
import com.inesshasanoui.bibliotheekbeheersysteem.service.ReservationServiceImpl;
import com.inesshasanoui.bibliotheekbeheersysteem.service.StateUserService;
import com.inesshasanoui.bibliotheekbeheersysteem.service.UserService;
import com.inesshasanoui.bibliotheekbeheersysteem.service.exception.LoanException;
import com.inesshasnaoui.bibliotheekbeheersysteem.dao.LoanDao;




class loanServiceTestCase {
	
	private LoanService loanService;
	private LoanDao loanDao;
	private UserService userService;
	private ItemService itemService;
	private StateUserService stateUserService;
	private ReservationService reservationService;
	private CopyItemService copyItemService;;

	@BeforeEach
	void setUp() throws Exception {
	
		
		userService = mock(UserService.class);
		itemService = mock(ItemService.class);
		loanDao = mock(LoanDao.class);
		stateUserService = mock(StateUserService.class);
		copyItemService= mock(CopyItemService.class);
		reservationService = mock(ReservationService.class);
	//	 this.loanService = mock(LoanService.class);
		this.loanService = new LoanServiceImpl(loanDao,userService,itemService,copyItemService,stateUserService,reservationService);	
	}

	@Test
	void penaltyAmountSuccessTest(){
		// Arrange
		int days =7;
		float expected= Constants.amountPenalityEachDay*days; 
		Date dateLoaned= new Date();
		Date returnDate =addDays(dateLoaned,Constants.maxLendingDays);
		Date returnedDate = addDays(returnDate,days);
		Loan loan =new Loan(1,2, dateLoaned, returnDate, returnedDate, 0F);
		// Act 
		float actual=loanService.penalityAmount(loan);
		// Assert
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	void checkMaxLoanToUserSuccessTest(){
		// Arrange
		Boolean expected= true; 
		int idMember = 1;
		// Mock
		when(loanDao.countCurrentLoans(idMember)).thenReturn(4);
		// Act 
		Boolean actual=loanService.checkMaxLoanToUser(idMember);
		
		// Assert
		Assertions.assertEquals(expected, actual);
	}
	@Test
	void checkMaxLoanToUserFailedTest(){
	
		// Arrange
		Boolean expected= false; 
		int idMember = 1;
		// Mock
		when(loanDao.countCurrentLoans(idMember)).thenReturn(Constants.maxLoanedItemsToAUser +1);
		// Act 
		Boolean actual=loanService.checkMaxLoanToUser(idMember);
		// Assert
		Assertions.assertEquals(expected, actual);
	}
	
	

	@Test
	void checkOfCopyIsAlreadyReturned() throws LoanException {
		//Arrange
		
		int copyId =1;
		int itemId=2;
		 List<Reservation> listReservation= new ArrayList<>();
		 Date dateLoaned = new Date();
		 Date returnDate = addDays(dateLoaned,Constants.maxLendingDays);
		 Date returnedDate;
		 Float penality = 0F;
		 Item item = new Item(1);
		 CopyItem availableCopy= new CopyItem(copyId,123456,CopyState.available.toString(),item);
		 Loan expected = new Loan(1,1,copyId,dateLoaned,returnDate,returnDate,penality);
		
		// Mock
		when (copyItemService.get(copyId)).thenReturn(availableCopy);
		when (loanDao.getLoanedcopyItem(copyId)).thenReturn(expected);
		when (reservationService.getAlleCurrentReservationsOfItem(itemId)).thenReturn(listReservation);
		//Act
		Loan actual =loanService.returnCopyItem(copyId);
		//Assert
		Assertions.assertEquals(expected, actual);
	}
	
	private Date addDays(Date date, int nbDay) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date); 
		cal.add(Calendar.DATE, nbDay);
		return cal.getTime();
	}
	
		
}