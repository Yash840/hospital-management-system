# 🏥 Hospital Management System (Console-Based Java Application)

## 📄 Project Description

The **Hospital Management System (HMS)** is a console-based Java application designed to simulate and manage core hospital operations in a structured and secure manner. Built entirely in Java using object-oriented programming principles, this project serves as a simplified yet modular solution for managing hospital staff data without relying on external databases.

This system facilitates the management of **hospital staff records**, including doctors, receptionists, and administrative personnel. It supports **user authentication** using staff IDs and securely hashed passwords, mimicking real-world login and access control systems. The application's architecture is lightweight and extensible, making it ideal for educational purposes, prototype design, and self-practice in Java development.

---

## 🔧 Key Features

- ✅ **Role-based Data Modeling** using `enum Roles` (`DOCTOR`, `RECEPTION`, `MANAGEMENT`)
- 🔐 **Secure Authentication System**
  - Unique login ID (`staffId`)
  - Passwords securely hashed using BCrypt
- ⚙️ **Efficient In-Memory Storage**
  - Staff records stored in `HashMap<String, Staff>` for O(1) lookup
- 📋 **Staff Management Functionalities**
  - Add, view, update, and remove staff members
  - Lookup staff details by `staffId`
- 🧩 **Modular and Scalable Architecture**
  - Clean separation of concerns using model and service layers
  - Extensible design for future features like patient tracking or appointment scheduling
- 💾 **Optional Data Persistence (Planned)**
  - Support for file-based serialization or JSON-based export/import
- ♨️ **Graphical User Interface (Planned)**
  - User friendly attractive GUI
- **Database Connection (Planned)**

---

## 🧱 Tech Stack

| Component        | Technology                    |
|------------------|-------------------------------|
| Programming Lang | Java (JDK 24)                |
| Architecture     | Object-Oriented Design (OOP)  |
| Build Tool       | Maven              |
| Security         | BCrypt (`org.mindrot.jbcrypt`)|
| Storage          | In-Memory (`HashMap`)         |

---

## 📚 Learning Outcomes

This project demonstrates:

- Proficiency in Java OOP principles (Encapsulation, Inheritance, Abstraction)
- Use of `HashMap` for efficient data retrieval and management
- Integration of secure password handling with hashing algorithms
- Practical application of enums, constructors, and service layers
- Real-world modeling of role-based access control and login systems

---

## 🚀 Future Enhancements (Optional Ideas)

- Patient and appointment management
- Staff scheduling and shift assignment
- File-based or JSON-based data persistence
- Admin dashboard and analytics view

---

> 🔖 This project is developed for academic purposes and self-practice in Java application design and architecture.
