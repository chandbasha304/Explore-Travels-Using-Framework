package com.process;





import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.data.UserData;


public class NewDataAdding {
	@SuppressWarnings("deprecation")
	public static String addingData(String userName, String gender, String userMail, String userPassword, String mobileNumber, double userAmount)
	{
		SessionFactory sessionFactory = SessionFactoryObjects.get();
		Session openSession = sessionFactory.openSession();
		UserData newDataAdding=new UserData(0, userName, gender, userMail, userPassword, mobileNumber, userAmount);
		openSession.beginTransaction();
		openSession.save(newDataAdding);
		openSession.getTransaction().commit(); 
		System.out.println("Data Added In Local Host");
		String string = openSession.get(UserData.class, newDataAdding.getUserId()).toString();
		openSession.close();


		return string;

	}

	public static boolean dataVerify(String emailId, String password)
	{
		try {
			
			
			
			SessionFactory datashowing=SessionFactoryObjects.get();
			Session openSession = datashowing.openSession();
			openSession.beginTransaction();
			org.hibernate.query.Query<UserData> abc = openSession.createQuery(" From UserData s where s.userMail = ?1 and s.userPassword = ?2 ", UserData.class);

			abc.setParameter(1, emailId);
			abc.setParameter(2, password);
			openSession.getTransaction().commit();
			List<UserData> list = abc.list();
			System.out.println(list.size());
			if(list.size()>0)
			{
				return true;
			}



							return true;
		}

		catch (Exception e) {
			e.printStackTrace();
		}







		return false; 

	}
}



