# Smart Email Backend 🚀

This is the backend service for the Smart Email application. It's a Spring Boot application that uses the Google Gemini API to generate intelligent and context-aware email content based on user prompts.

## Features
-   **AI-Powered Content Generation:** Leverages the Google Gemini API for high-quality email text.
-   **RESTful API:** Provides a simple and clean API endpoint for the frontend to consume.
-   **Scalable and Robust:** Built with Spring Boot for a reliable and production-ready foundation.

## Technology Stack
-   **Java 17**
-   **Spring Boot 3**
-   **Spring Web** (for REST controllers)
-   **Spring WebFlux** (for the reactive WebClient to call the Gemini API)
-   **Maven** (for dependency management)

## Prerequisites
-   Java 17 or later
-   Maven 3.2+
-   A Google Gemini API Key

## Setup and Installation

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/ArmanShaikh684/Smart-Email-Backend.git](https://github.com/ArmanShaikh684/Smart-Email-Backend.git)
    cd Smart-Email-Backend
    ```

2.  **Configuration:**
    This project requires two environment variables to connect to the Google Gemini API. You can set these in your IDE's run configuration or your operating system.

    -   `GEMINI_URL`: The full URL for the Gemini model endpoint.
    -   `GEMINI_KEY`: Your secret API key for the Gemini API.

    **Example:**
    ```
    GEMINI_URL=[https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent](https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent)
    GEMINI_KEY=AIzaSy...your...secret...key...here...
    ```

3.  **Build and Run the Application:**
    You can run the application using the Maven wrapper:
    ```bash
    ./mvnw spring-boot:run
    ```
    The application will start on `http://localhost:8080`.

## API Endpoints

### Generate Email
Generates email content based on a given prompt.

-   **URL:** `/api/email/generate`
-   **Method:** `POST`
-   **Request Body:**
    ```json
    {
      "prompt": "Write a professional follow-up email to a client named John Doe regarding the project proposal we sent last week. Ask if he has any questions."
    }
    ```
-   **Success Response (200 OK):**
    ```json
    {
      "response": "Subject: Following Up on the Project Proposal\n\nDear John,\n\nI hope this email finds you well. I'm writing to follow up on the project proposal we sent over last week. We're very excited about the possibility of working together.\n\nPlease let me know if you've had a chance to review it or if you have any questions. I'd be happy to schedule a brief call to discuss it further.\n\nBest regards,\n\n[Your Name]"
    }
    ```

---
