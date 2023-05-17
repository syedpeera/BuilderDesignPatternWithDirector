# BuilderDesignPatternWithDirector

The Builder design pattern is a creational design pattern that allows us to construct an object step-by-step. It uses a builder class that contains the construction steps to create an object.

When Will We Need Builder Design Pattern?
Imagine that we want to build software that accepts customers' details and stores them in a database. Customers are shown a form that accepts the below mandatory and optional fields.

Mandatory Fields - First Name, Last Name, Primary Email, and Primary Mobile Number
Optional Fields - Middle Name, Secondary Email, and Secondary Mobile Number

Ideally, we create a Customer class with the mandatory and optional attributes listed above. We create a constructor that accepts the above attributes. Since some attributes are optional, we may need to pass null values to those attributes we don't want to use. The builder design pattern lets us create an object step by step without passing all the values to the constructor.


Builder design pattern eliminates the telescopic constructor problem where we create several overloaded constructors with fewer arguments.

Example Consider creating a Customer object with mandatory attributes firstName, lastName, and optional attributes middleName and age. We create several overloaded constructors that call the default constructor with default values for missing inputs.

class Customer {
    public Customer(String firstName, String lastName, String middleName, int age) {
        this.firstName = firstName;
        this.lastname = lastName;
        this.middleName = middleName;
        this.age = age;
    }
    
    public Customer(String firstName, String lastName, String middleName) {
        this(firstName, lastName, middleName, -1)
    }
    
    public Customer(String firstName, String lastName, int age) {
        this(firstName, lastName, null, age);
    }
    
    public Customer(String firstName, String lastName) {
        this(firstName, lastName, null, -1);
    }
}

How Does Builder Design Pattern Work?
We will understand the working of the builder design pattern with the example mentioned above. We will create a CustomerBuilder and use it to construct the customer object with the mandatory and optional parameters. Finally, we call the builder's build() method to get the constructed Customer object.

Structure:
Builder design pattern consists of components such as builder interface, concrete builders, product, and client.

Builder:

Builder is an interface that declares the methods used to construct the object. For example, the ICustomerBuilder interface declares methods to construct customer attributes.

Concrete Builders Concrete builders implement the builder interface and add details to the interface's construction steps. For example, CusomterBuilder adds the details to the ICustomerBuilder interface's methods.

Product:

Product is a class that will be constructed through concrete builders. For example, the Customer object will be constructed via the CustomerBuilder.

Client The client is the application class that creates product objects using concrete builders.

Implementation:
Create the ICustomerBuilder interface with the construction methods such as firstName(), lastName(), middleName(), etc.
Create the concrete builder CustomerBuilder that implements the ICustomerBuilder interface and overrides its methods. It has a build() method that returns the final Customer object.
Create the Customer class with mandatory and optional attributes. This Customer object will be constructed through the CustomerBuilder.
Create the Client class responsible for instantiating the CustomerBuilder and use it to build the Customer object.


Customer:
Let's start by creating the Customer class with the attributes firstName, lastName, middleName, primaryEmail, primaryMobileNumber, secondaryEmail, and secondaryMobileNumber. We add only getter methods to the Customer class, making it immutable.

Pseudo Code:
class Customer 
    var firstName
    var middleName
    var lastName
    var primaryEmail
    var secondaryEmail
    var primaryMobileNumber
    var secondaryMobileNumber

    Customer(CustomerBuilder customerBuilder) 
        this.firstName = customerBuilder.getFirstName()
        this.middleName = customerBuilder.getMiddleName()
        this.lastName = customerBuilder.getLastName()
        this.primaryEmail = customerBuilder.getPrimaryEmail()
        this.secondaryEmail = customerBuilder.getSecondaryEmail()
        this.primaryMobileNumber = customerBuilder.getPrimaryMobileNumber()
        this.secondaryMobileNumber = customerBuilder.getSecondaryMobileNumber()
    

    var getFirstName() 
        return firstName

    var getMiddleName() 
        return middleName    

    var getLastName() 
        return lastName

    var getPrimaryEmail() 
        return primaryEmail

    var getSecondaryEmail() 
        return secondaryEmail

    var getPrimaryMobileNumber() 
        return primaryMobileNumber

    var getSecondaryMobileNumber() 
        return secondaryMobileNumber

    @Override
    var toString() 
        return "First Name: " + firstName + "\n" +
                "Middle Name: " + middleName + "\n" +
                "Last Name: " + lastName + "\n" +
                "Primary Email: " + primaryEmail + "\n" +
                "Secondary Email: " + secondaryEmail + "\n" +
                "Primary Mobile Number: " + primaryMobileNumber + "\n" +
                "Secondary Mobile Number: " + secondaryMobileNumber + "\n"

Customer Builder:

We create the customer builder interface ICustomerBuilder that declares the construction steps for the Customer object. Every construction method should return the ICustomerBuilder interface that makes the method calls chainable.

Pseudocode:

interface ICustomerBuilder
    ICustomerBuilder firstName(firstName)
    ICustomerBuilder lastName(lastName)
    ICustomerBuilder middleName(middleName)
    ICustomerBuilder primaryEmail(primaryEmail)
    ICustomerBuilder secondaryEmail(secondaryEmail)
    ICustomerBuilder primaryMobileNumber(primaryMobileNumber)
    ICustomerBuilder secondaryMobileNumber(secondaryMobileNumber)
    Customer build();

Concrete Customer Builder:

We create the concrete customer builder CustomerBuilder that implements the ICustomerBuilder interface and overrides all its construction methods. We add the build() that returns the final Customer object on calling.

Pseudocode:

class CustomerBuilder implements ICustomerBuilder
    var firstName
    var middleName
    var lastName
    var primaryEmail
    var secondaryEmail
    var primaryMobileNumber
    var secondaryMobileNumber
    
    CustomerBuilder firstName(var firstName) 
        this.firstName = firstName;
        return this;
    
     CustomerBuilder lastName(var lastName) 
        this.lastName = lastName;
        return this;
    
     CustomerBuilder middleName(var middleName) 
        this.middleName = middleName;
        return this;
    
     CustomerBuilder primaryEmail(var primaryEmail) 
        this.primaryEmail = primaryEmail;
        return this;
    
     CustomerBuilder secondaryEmail(var secondaryEmail) 
        this.secondaryEmail = secondaryEmail;
        return this;
    
     CustomerBuilder primaryMobileNumber(var primaryMobileNumber) 
        this.primaryMobileNumber = primaryMobileNumber;
        return this;
    
     CustomerBuilder secondaryMobileNumber(var secondaryMobileNumber) 
        this.secondaryMobileNumber = secondaryMobileNumber;
        return this;

     Customer build() 
        return new Customer(this);

Client:
We create the Client class responsible for creating the Customer objects through the CustomerBuilder.

Pseudocode:

class Client
    void main()
        Customer customer = new CustomerBuilder()
                .firstName("Tony")
                .lastName("Stark")
                .primaryEmail("tonystark@abc.com")
                .primaryMobileNumber("1234567890")
                .build()
        
        print customer;

Output:
First Name: Tony
Middle Name: null
Last Name: Stark
Primary Email: tonystark@abc.com
Secondary Email: null
Primary Mobile Number: 1234567890
Secondary Mobile Number: null


Pros and Cons of Builder Design Pattern:

Pros:
Builder design pattern allows us to create objects only with the required values and eliminates passing null for missing values.
Builder design pattern eliminates the telescopic constructors (i.e.) creating overloaded constructors with various combinations of attributes.
Builder design pattern allows us to create immutable objects. The object's attributes cannot be modified once built.

Cons:
Builder design pattern introduces additional builder code for every class and increases maintenance overhead.

Difference between Builder Design Pattern and Factory Design Pattern:

Builder Design Pattern
Factory Design Pattern
The builder design pattern is used to construct an object step-by-step by passing the necessary values.
The factory design pattern is used to build various subtypes of an object based on the requirement.
Example: PizzaBuilder constructs Pizza object with ingredients such as crust, sauce, toppings, etc.
Example: PizzaFactory creates pizzas such as PepperoniPizza, MushroomPizza, etc.


FAQs:
1. Why do we need a Builder interface? The Builder interface declares the construction steps of an object, and it can be implemented to provide various concrete builder implementations. In the below example, the PizzaBuilder interface is implemented to provide a builder for pizza dish (food) and pizza recipe (instruction).

interface PizzaBuilder {
    PizzaBuilder addCrust(String crust);
    PizzaBuilder addSauce(String sauce);
}

class PizzaDishBuilder implements PizzaBuilder {
    PizzaBuilder addCrust(String crust) {
        // logic
        return this;
    }
    
    PizzaBuilder addSauce(String sauce) {
        // logic
        return this;
    }
}

class PizzaRecipeBuilder implements PizzaBuilder {
    PizzaBuilder addCrust(String crust) {
        // logic
        return this;
    }
    
    PizzaBuilder addSauce(String sauce) {
        // logic
        return this;
    }
}

2. Where is the Builder design pattern used in Java? In Java, the builder design pattern is used in the StringBuilder class. StringBuilder contains the append() method to construct string step-by-step, and finally, we call the toString() method to get the constructed string object.

StringBuilder builder = new StringBuilder();

String message = builder
    .append("Thank You")
    .append("\n")
    .append("Come Back")
    .toString();

3. What type is the Builder design pattern?

Builder design pattern is a type of creational design pattern. Creational design patterns provide various mechanisms to construct and create objects.
