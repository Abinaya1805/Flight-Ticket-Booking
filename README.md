#Flight Ticket Booking

A Flight Ticket Booking system with a basic GUI to guide how the system works.
Java web development technologies(JSP,Servlet,JDBC,etc..,) used for implementation of backend.
The databased used in this project is MySQL.

The Flight Ticket Booking system is designed in such a way that no authenticated user or admin can visit the portal. Only those who are having account can only access the portal. The webpage will not load even if they simply paste the individual page's url. This is achieved by using HttpSession.


This flight booking system contains four main tables :

    Admin 
    User
    Flights
    Booking
    
#Admin

   The Admin represents the administrator who has the ability to modify the system like adding flights, deleting flights, view all the bookings based on time and flight ID. A new admin is created once and there will not be multiple admins as the admin should be unique. logincredentials table will store the login credentials of the admin.
   
 Important admin functionalities include :
 
      addFlight
      removeFlight
      viewBookingsByTime
      viewBookingsByID
      
#User
  
  The user represents the user of the flight booking system. An user can get into the portal only if he/she is having an account. If not they are not allowed to visite the user portal. There can be multiple users. 
  
  
Important User functionalities inclide :

      login
      signUp
      bookTickets
      searchFlightbyTime
      previousBookings
      availableFlight

#Flight
  
  
  The flight table contains all the details of a flight. The maximum capacity of each flight is 60 and if an user tries to book seats from a filled flight then the user will get notified that there is no seats available. The flight also contains how many seats are booked and how many available seats are there.
  
  
#Booking

   The Booking table will contain the information of the bookings taken place. The admin can see all the bookings made in admin portal whereas in a user can only see his/her bookings in user portal. The booking also contains Ticketid and the time of when the booking had taken place.
   
   ![image](https://github.com/Abinaya1805/Flight-Ticket-Booking/assets/93873088/aff77118-79be-41a5-b2f8-0f0ae122b5b4)

   
   ![image](https://github.com/Abinaya1805/Flight-Ticket-Booking/assets/93873088/34ac7b97-e234-4f31-bced-9e1f2405e907)


   
 ![image](https://github.com/Abinaya1805/Flight-Ticket-Booking/assets/93873088/60e9aa51-e3b3-4b41-bf92-1e931b9805d4)

 
![image](https://github.com/Abinaya1805/Flight-Ticket-Booking/assets/93873088/ff26d09b-e181-4f43-8947-4bae426a3d7c)
![image](https://github.com/Abinaya1805/Flight-Ticket-Booking/assets/93873088/b27e8dae-8966-464b-8a9f-af10e2e89346)


![image](https://github.com/Abinaya1805/Flight-Ticket-Booking/assets/93873088/d96ea27c-8088-47ba-a395-473fa84a142f)



![image](https://github.com/Abinaya1805/Flight-Ticket-Booking/assets/93873088/ce33d6d0-2372-4b7a-b543-60206b27bdee)


![image](https://github.com/Abinaya1805/Flight-Ticket-Booking/assets/93873088/437dc1e9-0843-47bb-9f58-a23dde8d9d98)



![image](https://github.com/Abinaya1805/Flight-Ticket-Booking/assets/93873088/9023fbde-8cb9-4f9d-9dc1-fdaaebd519e3)



![image](https://github.com/Abinaya1805/Flight-Ticket-Booking/assets/93873088/330ee59a-54dc-4bb1-9b4d-967ce614e7b6)


![image](https://github.com/Abinaya1805/Flight-Ticket-Booking/assets/93873088/a1f81ed5-93a1-4511-b502-be1948743a87)


![image](https://github.com/Abinaya1805/Flight-Ticket-Booking/assets/93873088/4243ca1d-9550-4a50-9530-0f4578ea5578)
