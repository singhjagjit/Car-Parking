# Car Parking System

<br />

### **Major Technologies Used**

Spring Boot, React, MongoDB. JUnit, and Mockito.
<br />
<br />

### **Introduction**

This is a car parking system web application to override the problems that persists in practicing manual system. This application is developed to eliminate the problems that are faced by the existing car parking systems. Moreover, this system is designed to make the life of the residents easy and hassle-free, thereby giving them a tool that makes their parking experience smooth and better than ever.

The application is made as much as minimalistic as possible to avoid complexities and errors while entering the data. No prior knowledge needed for the user to use this system as it is user-friendly, easy to navigate and use by any person of any age group.

Thus, by this all it provides a sense of security and reliability that leads to faster management of the system. It can therefore assist the user to focus on their activities and not worry about their vehicles.

Every organization, whether big or small, has challenges to overcome and managing the information of parking car, parking slots, car number, parking fees, etc. Every online car parking system has different car needs, therefore we designed this system that are adapted to the user's needs. This is designed to assist in strategic planning and will help you ensure that you are equipped with the right level of information.

Finally, our system will ultimately allow to better manage your time by automatically allocating the parking slots based on the size of the car that you choose, thereby creating an organized and well implemented system that not only makes your life easy but help to make it provide a better user experience altogether.
<br />
<br />

### **System Architecture**

We have used Multi-layered architecture for developing car-parking system which mainly consist of 3 layers.

- The **web layer** is the uppermost layer of a web application. It is responsible of processing user’s input and returning the correct response back to the user. The web layer must also handle the exceptions thrown by the other layers. Because the web layer is the entry point of our application, it must take care of authentication and act as a first line of defense against unauthorized users. React library is used for the frontend.

- The **service layer** resides below the web layer. It acts as a transaction boundary and contains both application and infrastructure services. The application services provides the public API of the service layer. They also act as a transaction boundary and are responsible of authorization. The infrastructure services contain code that communicates with external resources such as database in our case is MongoDB.

- The **repository layer** is the lowest layer of a web application. It is responsible of communicating with the used data storage.
  <br />
  <br />

### **System Components**

We have defined 4 components in this system :

- Admin
- Car
- Owner
- Parking Lot

**Admin** will login into the system and will add the car into system. He will input information about the car and owner. Car inputs are Car number, Car size i.e., small, medium and large and Owner inputs are First Name, Last Name and Phone number.

In addition to the information added by the Admin, the **Car** component will have information about cars entry and exit time, which parking lot it will be parked in and a parking fee which based on the size of the car and time it was parked for.

**Parking lot** component is of 3 sizes similar to the car. There are 20parking lots available and the cars will be randomly assigned to the parking lot based on the car size.

The **Owner** Component has owner first name, last name and phone will be noted by the admin when he registers a new car into the system.
