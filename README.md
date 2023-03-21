# MyVestiaireWeather
Architecture: 
I use the MVVM (Model-View-ViewModel) architecture for the application. This will help to separate the business logic from the presentation logic and make it easier to
test the application.

API
To fetch the weather data, I use the OpenWeather API. Use Retrofit to make network calls.

Database
To store the weather data and make it accessible offline, use a local database. We can use Room, which is an abstraction layer over SQLite database.

Libraries:

I can use the following libraries for this project:

Retrofit and OkHttp: To make network calls
Room: To store the weather data
Coroutines: To handle asynchronous tasks
ViewModel : To implement the MVVM architecture
Jetpack Compose and navigation : To display the list of weather forecasts
TDD: Unit testing


![Screenshot 2023-03-21 133752](https://user-images.githubusercontent.com/59287277/226623289-d87c9f32-3d08-4498-9034-f76e5b19df95.png)
![Screenshot 2023-03-21 133819](https://user-images.githubusercontent.com/59287277/226623338-7a474e68-689a-46b8-881d-bcb4577182aa.png)


Screens: 

Have two screens in the application:

- A list view displaying 16 days weather forecast for Paris.
- A detail view displaying a maximum of information for a specific day's weather

Workflow:
The application will follow the following workflow:

The user opens the application and sees the list of weather forecasts for the next 16 days for Paris.
The user selects a day from the list, and the application displays the detail view for that day's weather.
On the detail view, the application displays the maximum temperature, minimum temperature, humidity, and wind speed for that day's weather.
If the temperature for the selected day is above 25°C, the application displays "Hot," and if it is below 10°C, the application displays "Cold."
Unit Tests
We will write unit tests to test the business logic of the application. We will use JUnit and Mockito to write the tests.
