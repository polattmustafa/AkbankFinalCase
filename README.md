## General Info
- This project illustrates adding users and cities to the database and weather using OpenWeatherAPI for Cities 

## Technologies
Project is created with:
- Java 17
- Maven 4
- Spring Boot 3.1
- PostgreSQL
- Thymeleaf
- Security
- Mapstruct

## Setup
To run this project;
- clone the repo with git then run the following commands in the root directory

```sh
cd AkbankFinalCase
mvn clean
mvn install
mvn spring-boot:run
```

After running the commands, you will see the output on the screen as follows:
![Image of the maven spring-boot:run](https://i.imgur.com/SU3xOe1.png)

After executing the commands, you can use swagger or postman to access the APIs and make requests. Go to http://localhost:8090/swagger-ui/index.html#/ in browser
![Image of the swagger-ui](https://i.imgur.com/p86BDFI.png)

After the project is up, you can go to the http://localhost:8090/register address and perform your registration operations
![Image of the register page](https://i.imgur.com/8ZKHK0j.png)

After register, you can go to the http://localhost:8090/login address and perform your login operations
![Image of the login page](https://i.imgur.com/airgCIv.png)

After logging in, you will see a screen where you can bring weather information by typing the city name
- After entering the city name you should see 5 day 3 hours weather data
  ![Image of the weather data](https://i.imgur.com/TVgQL1N.png)



