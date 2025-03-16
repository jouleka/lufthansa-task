Test Project
Develop a single-page application (SPA) to serve as a fictional expense management tool for
travelers. The application will facilitate the tracking, approval, and management of travel expense
refunds in a user-friendly manner.
The users will have 3 levels of access:
▪ End User:
    ▪ Can create a trip
        ▪ Trip Name
        ▪ Trip Duration
        ▪ Trip Start/End Date
    ▪ Can add expenses on the trip by type (Car Rental/Hotel/Flight/Taxi)
        ▪ Car Rental:
            ▪ Car Name
            ▪ Pick up time and date
            ▪ Drop off time and date
            ▪ Pick up location
            ▪ Drop off location
            ▪ Total Price
        ▪ Hotel:
            ▪ Hotel name
            ▪ Hotel Location
            ▪ Check-in date
            ▪ Checkout date
            ▪ Total Price
        ▪ Flight:
            ▪ Airline
            ▪ From
            ▪ To
            ▪ Departure Time and date
            ▪ Arrival Time and date
            ▪ Total Price
        ▪ Taxi:
            ▪ From
            ▪ To
            ▪ Time and date
            ▪ Total Price
    ▪ Edit expense
    ▪ View expense
    ▪ Send Trip for approval to the approver. After sending the Trip for approval, the user cannot
    add/edit expenses anymore.
    ▪ Approver
        ▪ View everything on the trip and it's expenses
        ▪ Cannot update anything on the trip or expenses
        ▪ Can add a note
        ▪ Can Cancel or Approve Trip
    ▪ Finance
        ▪ Can view all approved trips
        ▪ Can mark the trip as refunded/In process

▪ Build a simple login with auth guards based on the user roles

Bonus
▪ Create a UML diagram for the architecture of your application.
▪ Document the application with any documentation tool of your choosing.
▪ Enable window communication so that the same action on one window would lead to the same
action on the other window. (E.g., open list of tickets on one window and on the other window
open ticket creation.)