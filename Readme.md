```markdown
# Map Markers App

A lightweight fullstack project built to showcase practical web development skills: REST API design, frontend-backend integration, data persistence, and clean UI/UX patterns. Designed for quick technical review and interview walkthroughs.

## Tech Stack
- **Backend:** Java 17, Spring Boot 3, Spring Data JPA
- **Database:** H2 (in-memory, zero-config for fast demos)
- **Frontend:** HTML5, CSS3, Vanilla JavaScript, Leaflet.js
- **Build Tool:** Maven (wrapped for zero-setup execution)

## How to Run Locally
No extra installations or database servers required. Just clone and start:

```bash
git clone https://github.com/ElGamezzz/map-marker-app.git
cd map-marker-app
```

Then run the app:
- **macOS/Linux:** `./mvnw spring-boot:run`
- **Windows:** `mvnw.cmd spring-boot:run`

Once the startup logs settle, open `http://localhost:8080`

## Architecture & Design Choices
- **Clean separation of concerns:** `Entity → Repository (auto-CRUD) → REST Controller → Frontend`. Keeps each layer focused and easy to test or extend.
- **RESTful API:** Semantic endpoints (`GET`, `POST`, `DELETE`) with proper HTTP status codes (`200`, `204`, `404`).
- **Zero-friction setup:** H2 in-memory means anyone can clone and run it in under a minute. Migrating to PostgreSQL or MySQL only requires changing the connection URL and adding a driver dependency.
- **Lightweight frontend:** No heavy frameworks. Vanilla JS + Leaflet keeps the bundle small, avoids unnecessary abstraction, and makes the logic transparent for reviewers.
- **UX touches:** Dynamic sidebar, smooth `flyTo` map transitions, double-confirmation on deletes, and basic input sanitization to prevent XSS.

## How to Evaluate It
1. Open `http://localhost:8080` and click anywhere on the map.
2. Give the marker a name and hit **Save**. It appears on the map and in the right-hand panel.
3. Refresh the page — your markers stay put (as long as the JVM is running).
4. Use the sidebar buttons: **View** smoothly centers the map on that marker, **Delete** asks for confirmation twice before removing it from both the UI and the database.
5. *(Optional)* Peek at the raw data: `http://localhost:8080/h2-console`
   → JDBC URL: `jdbc:h2:mem:marcadoresdb` | User: `sa` | Password: *(leave empty)*

## Packaging for Production
```bash
./mvnw clean package -DskipTests
java -jar target/map-marker-app-0.0.1-SNAPSHOT.jar
```
> **Note on CORS:** `@CrossOrigin("*")` is enabled for local development convenience. In a real deployment, you'd restrict it to your actual frontend domain or handle it via a reverse proxy.

---
Built by **José Sebastián** | [jsgamez46@gmail.com] | [[linkedin.com/in/jose-sebastian-delgado-gamez-980243394] | [github.com/ElGamezzz]