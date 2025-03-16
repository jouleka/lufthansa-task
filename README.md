# TravelPay - Expense Management for Travelers

A modern single-page application (SPA) for managing travel expenses. This application allows travelers to track, manage, and submit expenses for approval and reimbursement.

## Features

### End User Features
- **Trip Management**
  - Create new trips with name, duration, and date range
  - Submit trips for approval
  
- **Expense Tracking** - Add expenses by type:
  - **Car Rental**: Car details, pickup/dropoff locations, times, and total price
  - **Hotel**: Hotel details, location, check-in/checkout dates, and total price
  - **Flight**: Airline details, departure/arrival information, and total price
  - **Taxi**: Route information, time, and total price
  
- **Expense Actions**
  - View and edit expenses (before submission)
  - Submit trips for approval

### Approver Features
- View all trip details and expenses
- Add notes to trips
- Approve or reject trip expenses

### Finance Features
- View all approved trips
- Mark trips as "in process" or "refunded"

### Security
- Role-based authentication and authorization
- Protected routes with auth guards

## Technology Stack

### Frontend
- **Framework**: Angular 19
- **UI Components**: Angular Material
- **State Management**: RxJS

### Backend
- **Framework**: Spring Boot 3.2
- **Security**: JWT Authentication
- **Java Version**: Java 17
- **Documentation**: SpringDoc OpenAPI

## Installation

### Prerequisites
- Node.js (latest LTS)
- Java 17 or higher
- Maven

### Frontend Setup
```bash
cd frontend
npm install
npm start
```

### Backend Setup
```bash
cd backend
./mvnw spring-boot:run
```

The application will be available at `http://localhost:4200` with the API running on `http://localhost:8080`.

## Usage

1. Log in with appropriate credentials based on your role (End User, Approver, or Finance)
2. Navigate through the application based on your permissions
3. End users can create trips and add expenses
4. Approvers can review and approve/reject submissions
5. Finance personnel can process approved expenses

## License

This project is licensed under the terms of the license included in the repository.