# Android-Hotel-Reservation-System
This is the demo of Android development project
The works or functions I have completed are as follows:
1. Setting colors and themes in .xml files;
2. Creating call back functions to receive inputs from UI;
3. Tacking DatePicker changes in UI then giving a toast;
4. Convert DatePicker object to Calendar and Date object, using before() and after() methods to compare;
5. Blocking users from jumping to next screen if date inputs are valid, and showing a warning message;
6. Showing the names and numbers of the guest(s) in the TextView; 
7. Using SharedPreference to save user's input, including check-in date, check-out date, name and numbers of the guest(s);
8. Using Intent to jump to the next screen;
9. Applying RecyclerView to show the list of hotels;
10. Editing item layout to achieve better displaying;
11. Completing RecyclerView Adapter to bridge data and view, including onCreating and onBinding methods of ViewHolder; 
12. Completing linear, grid and stragger layouts of hotel list, and making a selection menu;
13. Requesting hotel data from Booking.com API, on given check-in date and check-out date range;
14. Starting new thread to request web API data, using handler to pass data to the main thread.

The unfinished works are as follow:
1. I cannot resolve the unknown crash when requesting web API data; (I do understand new thread cannot interact with the main thread indirectly, but this crash happened even without starting a new thread);
2. Displaying the detailed booking information: 
3. Giving users their booking successfully feedback. 
