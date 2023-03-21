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

![Screenshot_20230321_172115](https://user-images.githubusercontent.com/59287277/226691765-ced2266d-3646-413e-96c1-fa4d16cec4f8.png)
![Screenshot_20230321_172203](https://user-images.githubusercontent.com/59287277/226691788-05c3a817-ffbd-4881-b92e-d0c90f884efe.png)
![Screenshot_20230321_172338](https://user-images.githubusercontent.com/59287277/226691800-b7e90f48-bf39-4d59-8808-a11b4826435f.png)



Screens: 

Have two screens in the application:

- A list view displaying 16 days weather forecast for Paris.
- A detail view displaying a maximum of information for a specific day's weather

Workflow:
The application will follow the following workflow:

The user opens the application and sees the list of weather forecasts for the next 16 days for Paris.
The user selects a day from the list, and the application displays the detail view for that day's weather.
On the detail view, the application displays the maximum temperature, minimum temperature, humidity, and wind speed for that day's weather.
If the temperature for the selected day is above 25°C, the application displays "Hot," and if it is below 10°C, the application displays "Cold." otherwise the temperature is "Normal."

Unit Tests:
We will write unit tests to test the business logic of the application. We will use JUnit and Mockito to write the tests.
