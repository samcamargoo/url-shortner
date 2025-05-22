# URL Shortener Service (In-Memory)

A simple, lightweight, and fast URL shortener built with **Java 21** and **Spring Boot**, using **in-memory** storage via `HashMap`. Perfect for learning purposes or small-scale usage.

---

## Features

- Shorten long URLs into a unique short code  
- Redirect short URLs to their original destination  
- In-memory storage (no database required)  
- RESTful API  
- Auto-generated short codes  
- Basic URL validation  

---

## Tech Stack

- Java 21  
- Spring Boot  
- Spring Web  
- HashMap (for storage)  

---

## Installation & Run

### Prerequisites

- Java 21 or higher  
- Maven  

### Steps

```bash
# Clone the repository
git clone https://github.com/yourusername/url-shortener.git
cd url-shortener

# Build and run the application
./mvnw spring-boot:run
```

The application will start at: `http://localhost:8080`

---

## API Endpoints

### 1. Create Short URL

```http
POST /api/urls
Content-Type: application/json
```

#### Request Body

```json
{
  "url": "https://example.com"
}
```

#### Response

```json
{
  "shortCode": "aLBIIHZeOaLBIIHZeO"
}
```

---

### 2. Redirect to Original URL

```http
GET /api/urls/{shortCode}
```

#### Example

```http
GET /api/urls/aLBIIHZeOaLBIIHZeO
```

Response: HTTP 302 redirect to the original URL

---

## Notes

- All data is stored in-memory and will be lost when the application restarts.  
- Short codes are auto-generated and can be customized in the logic.  

---

## License

This project is licensed under the MIT License.
