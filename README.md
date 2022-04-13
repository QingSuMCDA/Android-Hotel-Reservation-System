# Android-Hotel-Reservation-System
This is the demo of Android development project
The works or functions I have completed are as follows:
1. Setting colors and themes in color.xml and theme.xml files;
2. Creating call back functions to receive inputs from UI;
3. Tacking DatePicker changes in UI then giving a toast;
4. Convert DatePicker object to Calendar and Date object, using before() and after() methods to compare;
5. Blocking users from jumping to the next screen if the date inputs are valid, and showing a warning message;
6. Showing the names and numbers of the guest(s) in the TextView; 
7. Using SharedPreference to save user's input, including check-in date, check-out date, name and numbers of the guest(s);
8. Using Intent to jump to the next screen;
9. Applying RecyclerView to show the list of hotels;
10. Editing item layout to achieve better displaying;
11. Completing RecyclerView Adapter to bridge data and view, including onCreating and onBinding methods of ViewHolder; 
12. Completing linear, grid and straggered grid layouts of hotel list, and making a selection menu;
13. Requesting hotel data from Booking.com API, on given check-in date and check-out date range;
14. Starting new thread to request web API data, using handler to pass data to the main thread;
15. Display the detailed information of the order.

The unfinished works are as follow:
1. I cannot resolve the unknown crash when requesting web API data; (I do understand new thread cannot interact with the main thread indirectly, but this crash happened even without starting a new thread);
2. Displaying the detailed booking information; 
3. Giving users their booking successfully feedback. 

There are scnapshots of all the screens.
Screen_01: Display the name and number of guest(s).
![image](https://github.com/QingSuMCDA/Android-Hotel-Reservation-System/blob/0d5e94d528e17693377d9ae563727df21e622aa9/IMG/Screen_1_1.png)

Screen_01: Check if check-in date is equal to or after the check-out date, and show warnings if the dates are invalid.
![image](https://github.com/QingSuMCDA/Android-Hotel-Reservation-System/blob/0d5e94d528e17693377d9ae563727df21e622aa9/IMG/Screen_1_2.png)

Screen_02: Display the list of hotels, default layout is Staggered Grid Layout.
![image](https://github.com/QingSuMCDA/Android-Hotel-Reservation-System/blob/0d5e94d528e17693377d9ae563727df21e622aa9/IMG/Screen_2_1.png)

Screen_02: Selection menu is provided for users, including linear layout, grid layout and staggered grid Layout.
![image](https://github.com/QingSuMCDA/Android-Hotel-Reservation-System/blob/0d5e94d528e17693377d9ae563727df21e622aa9/IMG/Screen_2_2.png)
![image](https://github.com/QingSuMCDA/Android-Hotel-Reservation-System/blob/0d5e94d528e17693377d9ae563727df21e622aa9/IMG/Screen_2_3.png)

Screen_02: To make the staggered grid Layout more obvious and beautiful, I set some random increments on heights of hotel pictures.
![image](https://github.com/QingSuMCDA/Android-Hotel-Reservation-System/blob/0d5e94d528e17693377d9ae563727df21e622aa9/IMG/Screen_2_4.png)

Screen_03: In the confirm page, the information of this order would be displayed, and the user is allowed to edit name and select gender.
![image](https://github.com/QingSuMCDA/Android-Hotel-Reservation-System/blob/0d5e94d528e17693377d9ae563727df21e622aa9/IMG/Screen_3_1.png)

Screen_04: The final page provided nothing but a message.
![image](https://github.com/QingSuMCDA/Android-Hotel-Reservation-System/blob/0d5e94d528e17693377d9ae563727df21e622aa9/IMG/Screen_4.png)

API data requested: I am able to connect to Booking.com api and request data with GET method in OkHttp. The information can be extracted from Json file but cannot be put into HotelBean class. And sometimes the app crashed when starting new thread to get data.
![image](https://github.com/QingSuMCDA/Android-Hotel-Reservation-System/blob/main/IMG/Api_returned_data.png)
