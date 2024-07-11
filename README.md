# BANK-LOCKER-MANAGEMENT-SYSTEM

Overview
The Bank Locker Management System is a web application designed to manage the allocation and details of bank lockers efficiently. It allows bank administrators to add, update, delete, list, and search for lockers based on various criteria.

Features
- Insert: Add new locker details including locker ID, name, size, category, subcategory, contact information, and more.
- Update: Modify existing locker information.
- Delete: Remove lockers from the system.
- List: View a list of all lockers stored in the database.
- Search: Search for lockers by ID, name, category, or subcategory.

Technologies Used
- Frontend: HTML, CSS, JavaScript
- Backend: Java
- Database: MySQL

 Setup Instructions
1. Clone the repository
  
2. Database Setup
   - Create a MySQL database named `lockerdb`.
   - Import the database schema using the provided SQL script (`database_schema.sql`).

3. Configure Database Connection
   - Update the database connection details in `db.properties` file.
   
4. Run the Application
   - Deploy the application on your preferred Java web server (e.g., Apache Tomcat).
   - Access the application through the server URL (e.g., `http://localhost:8080/BankLockerManagementSystem`).

5. Usage
   - Navigate through the application using the provided navigation links (Home, Insert, Update, Delete, List, Search).
   - Fill out the forms to add, update, or search for lockers.
   - Follow on-screen prompts and validations to ensure correct input.

