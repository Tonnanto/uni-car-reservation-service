# CarReservationService

A car reservation service that is part of the software architecture course at our university. The service consists of
multiple modules, each one of them complying with a given design pattern.

___
## Authors

- [@Tonnanto](https://www.github.com/Tonnanto)
- [@Plploe](https://www.github.com/Plploe)
- [@RamazanKaymaz](https://www.github.com/RamazanKaymaz)

___
## Development Process

1. The detail of requirements for this system was very limited.
2. Neither did we have prior knowledge of this domain nor did we have contact to someone who does.
   
This led to many of our architectural decisions result in a compromise between the given requirements and our personal understanding of a useful system that makes sense in this domain.

___
## Architecture
This service consists of multiple modules. The CarReservationService module contains all other modules and coordinates their interactions.
Each module is built using the ***MVC*** architecture pattern, and the ***Command*** design pattern.
The `model` package contains domain specific types and their relations.
The `view` package contains view classes that only serve the purpose of displaying text to the console and calling commands on user interaction.
The `controller` package contains a service class and multiple command classes. 
The service class has methods that represent the use cases of this module and methods that are being called by the corresponding commands to manipulate its state.
The service class also manages the user interaction (displays the correct view) determined by its current state.  

### Modules:
#### Person
- Creates new Person Objects that represent a single customer within the application.
- Complies with the ***Factory Method*** design pattern.
    
#### Authentication
- Authenticates a customer using a selected authentication method.
- Complies with the ***Strategy*** design pattern.
    
#### Resource
- Lets the customer select a resource that consists of one car and optionally multiple add-ons.
- Complies with the ***Decorator*** design pattern.
    
#### Payment
- Once a resource has been selected this module lets the user select a payment provider and handles the payment process.
- Complies with the ***Template Method*** design pattern.
    
#### Booking
- The Booking module creates booking objects that can be stored and reviewed later.
- Booking objects contain information about the customer, the booked resource and the payment.
- Bookings can be created in different languages.
- Complies with the ***Builder*** design pattern.
  
#### Content
- Content creates and manages a hierarchy with folders and files.
- For each booking a booking file is created and stored in a folder representing the date of the booking.
- The hierarchy can be navigated to view every single file.
- Complies with the ***Composites*** design pattern.
    
#### Statistics
- Allows insight into statistics about bookings for given payment types and languages.
- Automatically creates summary files to each folder in the content hierarchy of Content.
- In order to create summary files this module uses the ***Observer*** Pattern to observe changes in a content hierarchy from the Content module.
- Complies with the ***Visitor*** design pattern.
    
#### Utilities
- This is the only module that does not serve a domain related use case.
- Contains helper classes that are relevant for each of the other modules.
- Contains domain specific classes that are used in multiple other modules (language, currency, ...)

<ins>A package diagram and a class diagramm of each module can be found in the attached files.</ins>

___
## Run

Note: For demo purposes the system is being populated with 25 randomly generated bookings, so that `show content` and `show statistics`can easily be tested.


In order to run this project you can either
1. Open the project in your editor of choice.
2. Build the project.  
3. Run controller.Main.java

or 

1. run the attached jar file `CarReservationService.jar`
    - Note: Some characters might not be displayed correctly in the console.
