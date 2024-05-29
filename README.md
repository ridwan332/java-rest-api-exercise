# Java RESTful API Exercise: IOU Service

## Description

Build a RESTful API service that allows users to `create`, `read`, `update`, and `delete` IOUs (I Owe You) using Java and Spring Boot.

### Implement the Data Model

Inside the `ious` package, create an `IOU` entity class with the following members:
- `final UUID id` - unique identifier for the IOU
- `String borrower` - name of borrower
- `String lender` - name of lender
- `BigDecimal amount` - amount covered by IOU
- `Instant dateTime` - date and time of IOU being issued
- `public IOU(String borrower, String lender, BigDecimal amount, Instant datetime)` - constructor that should generate a new UUID, use [the documentation][1] to learn how to generate a random value.

Set the appropriate accessibility modifiers for all members and add appropriate property getters and setters.

A representative HTTP response will look something like this:
```JSON
{
    "id": "5a6b7692-2322-482e-80cf-a59eedb9164f",
    "borrower": "Bob",
    "lender": "Alice",
    "amount": 1877.51,
    "date": "2023-04-23T18:25:43.511Z"
}
```

### Implement the Repository

A repository interface, `IOURepository` has been provided for you. Create a class that implements this interface using a `List` instance as the backing store and name it something sensible, e.g. `ListIOURepository`, with the following members:

- `final List<IOU> ious = new ArrayList<>()` - list of IOUs stored in the API

Set the appropriate accessibility modifiers for all members and annotate the class as a [Repository][2]. Pay attention to the exceptions defined on the interfaces and ensure your concrete class throws as appropriate.

### Implement the Service

A service interface, `IOUService` has been provided for you. Create a class that implements this interface using a `List` instance as the backing store and name it something sensible, e.g. `ListIOUService`, with the following members:

- `final List<IOU> ious = new ArrayList<>()` - 
- `public ListIOUService (IOURepository iouRepository)`

Set the appropriate accessibility modifiers for all members and annotate the class as a [Service][3]. Ensure your code appropriately handles any exceptions thrown by the repository class.

### Implement the Controller

Create an `IOUController` class with the following members:

- `IOUService iouService` - in instance of the service interface
- `IOUController(IOUService iouService)` - constructor that accepts an instance of the service interface

Add additional methods that defines endpoints for the following operations:

| Method   | URL              | Description          |
| -------- | ---------------- | -------------------- |
| `GET`    | `/api/ious`      | Get all IOUs         |
| `GET`    | `/api/ious/{id}` | Get an IOU by id     |
| `POST`   | `/api/ious`      | Add an IOU           |
| `PUT`    | `/api/ious/{id}` | Replace an IOU by Id |
| `DELETE` | `/api/ious/{id}` | Delete an IOU by id  |

Set the appropriate accessibility modifiers for all members and annotate the class as a [RestController][4].

## Learning Objectives:

By the end of this exercise, you should be able to:

- Set up a Spring Boot project using a development environment
- Create a simple RESTful API for IOU tracking using controllers, services and models.
- Implement CRUD operations (Create, Read, Update, Delete) for IOUs
- Implement graceful exception handling

## Getting Started

### Clone the Repository
Clone this repository or or open in CodeSpaces.

```sh
git clone [REPO_URL]
cd [REPO_NAME]
```
Replace [REPO_URL] with the link to your GitHub repository and [REPO_NAME] with the repository's name.

### Install Dependencies

Open a terminal at the root of the repo directory and run the following command to install the dependencies:

```sh
./mvnw clean dependency:resolve
```

If you are on a Windows machine, that will be:
```cmd
mvnw clean dependency:resolve
```

### Running the Application

To start the API from the terminal, run the following command:

```sh
./mvnw spring-boot:run
```

Or on Windows:

```cmd
mvnw spring-boot:run
```

### Testing the Application

You can test your endpoints using [Postman][5] or your preferred REST client.

For `POST` and `PUT` requests, you'll need to provide a request body in JSON format, e.g.:

```json
{
  "borrower": "John Doe",
  "lender": "Alice Smith",
  "amount": 100.0,
  "dateTime": "2023-11-02T14:30:00Z"
}
```

#### :bulb: Note

Remember that the `id` property may not be needed for all request types.

[1]: https://docs.oracle.com/javase/8/docs/api/java/util/UUID.html
[2]: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Repository.html
[3]: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Service.html
[4]: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RestController.html
[5]: https://www.postman.com
