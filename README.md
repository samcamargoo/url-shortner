# URL Shortener Service (In-Memory)

A simple, lightweight, and fast URL shortener built with **Java 17+** and **Spring Boot**, using **in-memory** storage via `HashMap`. Perfect for learning purposes or small-scale usage.

---

##  Features

- Shorten long URLs into a unique short code
- Redirect short URLs to their original destination
- In-memory storage (no database required)
- RESTful API
- Auto-generated short codes
- Basic URL validation

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot
- Spring Web
- HashMap (for storage)

---

## 📦 Installation & Run

### Prerequisites
- Java 21 or higher
- Maven

### Steps

```bash
# Clone the repository
git clone https://github.com/yourusername/url-shortener.git
cd url-shortener

# Build and run
./mvnw spring-boot:run

The application will start at: http://localhost:8080

## API Endpoints
➕ Create Short URL
POST localhost:8080/api/urls

Request Body
{
  "url": "validurl
}

Response
 aLBIIHZeOaLBIIHZeO

## Redirect to Original URL
GET localhost:8080/api/urls/aLBIIHZeOaLBIIHZeO
