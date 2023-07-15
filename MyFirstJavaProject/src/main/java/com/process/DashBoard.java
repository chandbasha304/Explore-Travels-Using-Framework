package com.process;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.data.TravelPlaces;
import com.data.UserBookings;
import com.data.UserData;

public class DashBoard {







	static Map<String, String> bookingHistory = new HashMap<>();
	// For Continuation
	static boolean view = true;
	// Login Attempts
	static int failedCountLimit = PermanentValues.count;
	static int userfailedcount = 0;
	// taking Runtime Data by using Scanner
	static Scanner enter = new Scanner(System.in);

	static String userName;
	
	static String gender;
	static String userMail;
	static String userPassword;
	static String mobileNumber;
	static double userAmount;


	public static void main(String[] args) 
	{


		while(view=true)
		{


			try {
				//Start Process
				DashBoard.enteringIntoProcess();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
	private  static void enteringIntoProcess() throws SQLException 
	{


		System.out.println("Welcome To Explore Travels");
		System.out.println(
				"1.New Admin User Registration  2.Login Account 3.Plan Journey 4.Reschedule Ticket Operations \nPlease Enter Your Option");
		int options =enter.nextInt();
		switch(options)
		{
		//New User Registration and Adding Run Time Data to DataBase Through Hibernate
		case 1:
			try {
				System.out.println("New User Registration");
				System.out.println(
						"Please Enter\n1.Name \n2.Gender  \n3.Mobile Number\n4.EmailId \n5.Password\n6.Amount like this Format");
				System.out.println("Please Enter Random Number");
				int number=enter.nextInt();
				System.out.println(number);
				enter.nextLine();
				System.out.println("Please Enter  Name");

				DashBoard.userName = enter.nextLine();

				System.out.println(" Please Enter Gender");
				DashBoard.gender = enter.nextLine();
				System.out.println("Please Enter Mobile Number");
				DashBoard.mobileNumber= enter.nextLine();



				//Mobile Length digits checking
				if (DashBoard.mobileNumber.length() < 10)
				{

					try {
						ErrorHandles customisedErrors=new ErrorHandles("Mobile Number should be 10 Digits ");
						throw customisedErrors;
					} catch (Exception e)
					{
						System.out.println(e.getMessage());
						enteringIntoProcess();

					}


				}
				else 
				{




					System.out.println("Please Enter Email id\n "
							+ "Kindly use all small letters  \nPlease Use This Pattern:xyz145@gmail.com");
					DashBoard.userMail = enter.nextLine();
					DashBoard.userMail= DashBoard.userMail.toLowerCase();

					System.out.println("Please Enter password\n");
					DashBoard.userPassword = enter.nextLine();



					System.out.println("Please Enter UserWallet Amount");
					DashBoard.userAmount= enter.nextDouble();

					//Adding New Data to DataBase Through Hibernate
					String addingData = NewDataAdding.addingData(userName,gender,userMail,userPassword,mobileNumber,userAmount);


					System.out.println(addingData);
				}
			}
			catch (Exception e) 
			{
				System.out.println(e.getMessage());
				System.out.println("Errors In Case1");
			}
			break;

		case 2:
			try
			{
				//Login USing Username and Credentials
				System.out.println("Login Operation");
				System.out.println("Please Enter Random  Number");
				@SuppressWarnings("unused")
				int randoms=enter.nextInt();
				enter.nextLine();
				System.out.println("Enter Your EmailId");
				String emailId = enter.nextLine();
				System.out.println("Password");
				String password = enter.nextLine();
				//we have 5 limits for Invalid Attempts if it's cross limits then Account will block for 24 Hours
				if (userfailedcount < failedCountLimit)
				{

					//Checking Credentials  Exists in DataBase
					boolean checking = NewDataAdding.dataVerify(emailId,password);
					System.out.println(checking);
					//If Data  Exists it enters into If Statement
					if(checking)
					{
						System.out.println("UserMail and User Password  Found In DataBase");
						System.out.println(emailId);
						System.out.println("entering into account");
						System.out.println("Welocome To Explore Travels PLease Book Your Tickets\n");
						System.out.println("Explore Travles Top Tourist Bus Routes");
						System.out.println("1.Vijayawada ->Hyderabad\t   2. Hyderabad-> Vijayawada\n"
								+ "3.Vijayawada -> Chennai\t  4.Chennai-> Vijayawada\n"
								+ "5.Vijayawada -> Bangalore\t  6.Bangalore-> Vijayawada\n"
								+ "7.Vijayawada -> Kochi\t  8.Kochi -> Vijayawada\n"
								+ "9.Vijayawada -> Tirupathi\t   10.Tirupathi-> Vijayawada\n "
								+ "11.Vijayawada -> Vishakapatnam\t  12.Vishakapatnam-> Vijayawada\n"
								+ "13.Vijayawada -> Mysore\t  14.Mysore-> Vijayawada\n"
								+ "15.Vijayawada -> Ooty\t  16.Ooty-> Vijayawada\n"
								+ "17.Hyderabad -> Ooty\t  18.Ooty-> Hyderabad\n" + "19.Bangalore -> Ooty\t  20.Ooty-> Bangalore\n"
								+ "21.Bangalore -> Chennai\t  22.Chennai-> Bangalore\n"
								+ "23.Bangalore -> Tirupati\t  24.Tirupati-> Bangalore\n" + "25.Chennai -> Ooty\t  26.Ooty-> Chennai\n"
								);
						System.out.println("1.My Bookings 2.My Profile 3. Logout ");
					}
					else
					{
						//Returns the Main Page and Count the Limit
						userfailedcount++;
						System.out.println("You Have Only"+(failedCountLimit-userfailedcount)+"times\n"
								+ "Please Enter Correct Credentials");
						enteringIntoProcess();

					}
				}
				else
				{


					//If Limit Exceeds Then Account is Blocked
					System.out.println(
							"Your Account Is Blocked ,Please Visit Our Main Branch OF Explore Travels Or Try Again After 24 hours");
					System.exit(0);
				}
			}
			catch (Exception e) 
			{
				System.out.println(e.getMessage());
				System.out.println("Errors In Case2");
			}


			break;
		case 3:
			try
			{
				//Book Tickets

				System.out.println("Welcome To Explore Travels, PLease Book Your Tickets");
				System.out.println("Explore Travles Top Tourist Bus Routes");
				//For Data Operations We Need Session Factory  in Hibernate
				SessionFactory sessionFactory = SessionFactoryObjects.get();
				System.out.println(sessionFactory.hashCode()+"First Time Hashcode");
				Session openSession = sessionFactory.openSession();
				openSession.beginTransaction();
				List<TravelPlaces> list = openSession.createQuery("FROM TravelPlaces",TravelPlaces.class).list();
				for (TravelPlaces travelPlaces : list) {
					System.out.println(travelPlaces);

				}

				System.out.println("Enter Your Route Id ");
				int busOption = enter.nextInt();
				System.out.println("Enter Your Data in this format\n" + "Year-Month-Date like 2023-05-10");
				String bookingdate = enter.next();
				//Current Date
				LocalDate date = LocalDate.now();
				//Booking Date 
				LocalDate checkingDate = LocalDate.parse(bookingdate);

				DayOfWeek weekDay = checkingDate.getDayOfWeek();
				System.out.println(checkingDate.getMonth());
				System.out.println(checkingDate.getDayOfMonth()+"date");
				System.out.println(checkingDate.getDayOfYear()+"out of  365days");
				System.out.println(checkingDate.getMonthValue()+"month");
				System.out.println(checkingDate.getDayOfWeek()+"day");
				System.out.println(checkingDate.getYear()+"year");
				//Comparing Date with present and future
				if (checkingDate.getDayOfYear() >= date.getDayOfYear()
						& checkingDate.getMonthValue() >= date.getMonthValue()) {
					System.out.println("Entering into month");
					String checkdate = weekDay.toString();
					System.out.println(checkdate);
					//Checking the Day is Weekend Or Normal Days
					if (checkdate.equalsIgnoreCase("Saturday") | checkdate.equalsIgnoreCase("Sunday")) {
						System.out.println("Weekend Days");

						try {
							DashBoard.weekendsBooking(busOption, checkingDate.toString(),date.toString());
						} catch (Exception e) 
						{
							e.printStackTrace();
						}

					}


					else {


						System.out.println("Normal Day");

						try {
							DashBoard.normalDayBooking(busOption, checkingDate.toString(),date.toString());
						} catch (Exception e) {
							e.printStackTrace();
						} 
					}
				} else {
					try {

						throw new InputMismatchException(
								"Please Enter Current Date Or Future Dates with current year and current month or Upcoming Months ");
					} catch (Exception e) {
						System.out.println(e.getMessage());

					}

					break;
				}
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
				System.out.println("Errors In Case3");
			}
			break;
		case 4:
			try
			{

				//Changing Date For Booked Tickets
				DashBoard.changeDateinDatabase();
			}
			catch (Exception e) 
			{

				System.out.println(e.getMessage());
				System.out.println("Errors In Case4");
			}
			break;
		}





	}
	//Before Main Method it Static Blocks will Execute
	static 
	{
		// Text File Reading From Local Disk
		String paylog=PermanentValues.path;
		File ab=new File(paylog);
		FileInputStream logopay = null;
		try 
		{
			logopay = new FileInputStream(ab);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		int logs;
		try {

			while((logs=logopay.read())!=-1)
			{
				char logos=(char) logs;
				System.out.print(logos);
			}
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}


	@SuppressWarnings("deprecation")
	protected static void weekendsBooking(int busOption, String checkingDate, String presentdate)
			throws FileNotFoundException, IOException, SQLException {

		try
		{


			System.out.println( "before seats booking");



			int numbers=0;
			int ticketPerEach=0;
			SessionFactory sessionFactory = SessionFactoryObjects.get();
			System.out.println(sessionFactory.hashCode()+"second Time Hashcode");
			Session openSession = sessionFactory.openSession();
			openSession.beginTransaction();
			List<TravelPlaces> list = openSession.createQuery("from TravelPlaces s where s.travelId=?1 ", TravelPlaces.class)
					.setParameter(1, busOption).list();
			for (TravelPlaces travelPlaces : list) {
				System.out.println(travelPlaces);
				numbers=travelPlaces.getSeatsAvailable();
				ticketPerEach = travelPlaces.getTicketrate();


			}

			System.out.println();
			System.out.println("Book Tickets");
			System.out.println("Enter Number Of Tickets");



			int seatnumber = enter.nextInt();

			if(numbers==0)
			{
				System.out.println("No Seats Available Choose Another Bus");


			}

			else
			{






				System.out.println(
						"Choose Your  Amount Transaction Option\n " + "1.ExploreTravlesWallet 2.Debit Card 3.UPI Payments");
				System.out.println(
						"4.If You are a New User Then Create Your Account In Explore Travels OR PayThrough Debit Card OR UPI");
				int planoptions=enter.nextInt();
				switch(planoptions)
				{
				case 1:
					System.out.println("Enter Your Email Id While Creating Explore Travels Account");
					String correctemail = enter.next();
					SessionFactory checkUser = SessionFactoryObjects.get();
					Session users = checkUser.openSession();
					List<UserData> userDatainDatabase = users.createQuery("FROM UserData s where s.userMail=?1",UserData.class)
							.setParameter(1, correctemail).list();

					if(userDatainDatabase.size()>0)
					{
						int userid=0;

						double useramount=0;
						for (UserData userData : userDatainDatabase) 
						{
							userid=userData.getUserId();
							useramount=userData.getUserAmount();


							System.out.print(userData);

						}
						System.out.println();
						double ticket=(seatnumber*ticketPerEach)+(ticketPerEach*PermanentValues.gst);
						PaymentProcess transfer=new PaymentProcess();
						Thread abc=new Thread(transfer);
						abc.start();
						System.out.print("Payment Processing");
						for(int i=0;i<10;i++)
						{
							System.out.print(".");
							Thread.sleep(2000);
						}
						System.out.println();
						System.out.println("Payment Successfull");

						users.beginTransaction();
						UserData userinAccount = users.get(UserData.class,userid );
						System.out.println(userinAccount);
						int userdetails=userinAccount.getUserId();
						userinAccount.setUserAmount(useramount-ticket);
						users.update(userinAccount);
						users.getTransaction().commit();
						System.out.println(userinAccount);
						System.out.println(userinAccount);
						users.beginTransaction();	
						TravelPlaces travelPlaces = users.get(TravelPlaces.class,busOption );
						travelPlaces.setSeatsAvailable(numbers-seatnumber);
						users.update(travelPlaces);
						users.getTransaction().commit();
						System.out.println(travelPlaces);
						String from=travelPlaces.getFromPlace();
						String toplace=travelPlaces.getDestinationPlace();

						users.beginTransaction();
						UserBookings ab=new UserBookings(0, from, toplace,presentdate,checkingDate, seatnumber, busOption, userdetails);
						users.save(ab);
						users.getTransaction().commit();
						System.out.println(ab);





					}
					else
					{
						System.out.println("No Data Found");
					}













					break;
				case 4:
					try
					{


						DashBoard.changeDateinDatabase();
					}
					catch (Exception e) 
					{

						System.out.println(e.getMessage());
						System.out.println("Errors In Case4");
					}
					break;

				}



			}



		}

		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("Errors in Case3");
		}

	}
	@SuppressWarnings("deprecation")
	public static void normalDayBooking(int busOption, String checkingDate, String presentdate)
	{

		try
		{


			System.out.println( "before seats booking");



			int numbers=0;
			int ticketPerEach=0;
			SessionFactory sessionFactory = SessionFactoryObjects.get();
			System.out.println(sessionFactory.hashCode()+"second Time Hashcode");
			Session openSession = sessionFactory.openSession();
			openSession.beginTransaction();
			List<TravelPlaces> list = openSession.createQuery("from TravelPlaces s where s.travelId=?1 ", TravelPlaces.class)
					.setParameter(1, busOption).list();

			for (TravelPlaces travelPlaces : list) {
				System.out.println(travelPlaces);
				numbers=travelPlaces.getSeatsAvailable();
				ticketPerEach = travelPlaces.getTicketrate();


			}

			System.out.println();
			System.out.println("Book Tickets");
			System.out.println("Enter Number Of Tickets");



			int seatnumber = enter.nextInt();

			if(numbers==0)
			{
				System.out.println("No Seats Available Choose Another Bus");


			}

			else
			{






				System.out.println(
						"Choose Your  Amount Transaction Option\n " + "1.ExploreTravlesWallet 2.Debit Card 3.UPI Payments");
				System.out.println(
						"4.If You are a New User Then Create Your Account In Explore Travels OR PayThrough Debit Card OR UPI");
				int planoptions=enter.nextInt();
				switch(planoptions)
				{
				case 1:
					System.out.println("Enter Your Email Id While Creating Explore Travels Account");
					String correctemail = enter.next();
					SessionFactory checkUser = SessionFactoryObjects.get();
					Session users = checkUser.openSession();
					List<UserData> userDatainDatabase = users.createQuery("FROM UserData s where s.userMail=?1",UserData.class)
							.setParameter(1, correctemail).list();

					if(userDatainDatabase.size()>0)
					{
						int userid=0;

						double useramount=0;
						for (UserData userData : userDatainDatabase) 
						{
							userid=userData.getUserId();
							useramount=userData.getUserAmount();


							System.out.print(userData);

						}

						System.out.println();
						System.out.println("userId= "+userid);
						System.out.print("Payment Processing");
						PaymentProcess transfer=new PaymentProcess();
						Thread abc=new Thread(transfer);
						abc.start();
						for(int i=0;i<10;i++)
						{
							System.out.print(".");
							Thread.sleep(2000);
						}
						System.out.println();
						System.out.println("Payment Successfull");
						double ticket=seatnumber*ticketPerEach;
						users.beginTransaction();
						UserData userinAccount = users.get(UserData.class,userid );
						@SuppressWarnings("unused")
						int pass = userinAccount.getUserId();
						System.out.println(userinAccount);
						int acd=userinAccount.getUserId();
						userinAccount.setUserAmount(useramount-ticket);
						users.update(userinAccount);
						users.getTransaction().commit();
						System.out.println(userinAccount);
						users.beginTransaction();	
						TravelPlaces travelPlaces = users.get(TravelPlaces.class,busOption );
						travelPlaces.setSeatsAvailable(numbers-seatnumber);
						users.update(travelPlaces);
						users.getTransaction().commit();
						System.out.println(travelPlaces);
						String from=travelPlaces.getFromPlace();
						String toplace=travelPlaces.getDestinationPlace();

						users.beginTransaction();
						UserBookings ab=new UserBookings(0, from, toplace,presentdate,checkingDate, seatnumber, busOption, acd);
						users.save(ab);
						users.getTransaction().commit();
						System.out.println(ab);

					}


					else
					{
						System.out.println("No Data Found");
					}
					break;
				}


			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("Errors in Case3");
		}
	}
	private static void changeDateinDatabase() throws SQLException
	{
		try
		{


			System.out.println("Reschedule Operations\n Enter Random Number");
			@SuppressWarnings("unused")
			int abcd=enter.nextInt();
			enter.nextLine();
			System.out.println(" Please Enter Your Registered Email");
			String mailforEdit=enter.nextLine();


			System.out.println("Enter Your Password");
			String passwordforEdit=enter.nextLine();
			System.out.println(mailforEdit+"mail");
			System.out.println(passwordforEdit+"pass");



			SessionFactory getSessions = SessionFactoryObjects.get();
			Session updates = getSessions.openSession();
			updates.beginTransaction();
			List<UserData> list = updates.createQuery("From UserData s where s.userMail=?1 and s.userPassword=?2", UserData.class)
					.setParameter(1, mailforEdit).setParameter(2, passwordforEdit).list();
			System.out.println(list.size());
			int wheres = list.get(0).getUserId();
			if(list.size()>0)
			{
				for (UserData userData : list) {
					System.out.println(userData);

				}
				List<UserBookings> list2 = updates.createQuery("from UserBookings s where s.userid=?1", UserBookings.class)
						.setParameter(1, wheres).list();
				updates.getTransaction().commit();
				System.out.println("Before Updating New Date");
				for (int i = 0; i < list2.size(); i++) 
				{
					System.out.println(list2.get(i));

				}
				System.out.println("Choose Your Route ID");
				int newRoute=enter.nextInt();
				enter.nextLine();
				LocalDate ab=LocalDate.now();
				System.out.println("Enter Your New Date \n use This Format\t"
						+ "Year-Month-Date");
				String newDate=enter.nextLine();
				LocalDate ag=LocalDate.parse(newDate);

				updates.beginTransaction();


				String queryString = "UPDATE UserBookings b SET b.bookeddate = ?1, b.journeydate = ?2 WHERE b.routeNumber = ?3 AND b.userid = ?4";


				@SuppressWarnings({ "deprecation", "rawtypes" })
				Query query = updates.createQuery(queryString);
				query.setParameter(1,ab.toString());
				query.setParameter(2,ag.toString());
				query.setParameter(3,newRoute);
				query.setParameter(4,wheres);


				int updatedCount = query.executeUpdate();
				System.out.println(updatedCount);



				updates.getTransaction().commit();
				System.out.println(updatedCount+"updated");







				System.out.println("After Updating New Date");



			}
			else
			{
				System.out.println("No Data Found");
			}







		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println("Errors In Case4");
		}
	}
}

