package com.process;
import org.hibernate.SessionFactory;


import org.hibernate.cfg.Configuration;

import com.data.TravelPlaces;
import com.data.UserBookings;
import com.data.UserData;


	

public class SessionFactoryObjects {


	
		private static SessionFactory facts;
		public static SessionFactory get()
		{
			
			if(facts==null)
			{
				System.out.println("enter");
				Configuration getConfig = new Configuration();
				System.out.println("enter");
			      getConfig.configure();
			      System.out.println("ConFiguration Successfull");
			      getConfig.addAnnotatedClass(UserData.class);
			      getConfig.addAnnotatedClass(TravelPlaces.class);
			      getConfig.addAnnotatedClass(UserBookings.class);
			      System.out.println("Annotation Successfull");
			      SessionFactory sessionFactory = getConfig.buildSessionFactory();
			      System.out.println("Get Factory");
			      facts=sessionFactory;
			      return facts;
			}
			return facts;
			
		}
		

		private SessionFactoryObjects()
		{
			
		}

		
	}




