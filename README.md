# Pinggy Assignment

## Backend

This is the backend application for the Pinggy screening assignment, built with Spring Boot. It provides APIs to submit and retrieve posts, with custom authentication based on a header.

### Features
- Custom authentication filter that checks for the `PinggyAuthHeader` header.
- POST endpoint `/post` to accept and store post data with the header value in memory.
- GET endpoint `/list` to return all stored posts.
- Proper error handling (e.g., 401 Unauthorized for missing/invalid header).
- In-memory storage (no database).

### Decisions
- Used `ThreadLocal` to store the `PinggyAuthHeader` value for access in the controller.
- Implemented DTOs for request and response payloads to ensure type safety.
- Kept the project simple by using in-memory storage (HashMap) as per requirements.

### Prerequisites
- Java 17 (or 21/24, specify your version) installed.
- Maven installed.


# Pinggy Frontend

This is the frontend application for the Pinggy screening assignment, built with Next.js and Tailwind CSS. It interacts with a Spring Boot backend to submit and display posts.

## Features
- Form to submit posts with Title, Body, and Auth Code fields.
- Sends POST requests to `/post` with the `PinggyAuthHeader` header.
- Fetches and displays posts from the `/list` endpoint.
- Basic error handling for failed submissions (e.g., 401 Unauthorized).
- Loading state while fetching posts.
- Responsive design using Tailwind CSS.

## Decisions
- Used `axios` for HTTP requests due to its simplicity and error handling capabilities.
- Implemented a `refreshTrigger` to re-fetch posts after a successful submission.
- Kept styling minimal and responsive with Tailwind CSS.

## Prerequisites
- Node.js 18+ installed.
- Backend running at `http://localhost:8080`.
