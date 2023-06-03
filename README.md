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
   
 
 



