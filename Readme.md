# Mapa de Marcadores - Fullstack Demo

Aplicación fullstack minimalista diseñada para demostrar integración frontend ↔ backend, persistencia de datos, consumo de API REST y buenas prácticas de desarrollo web.

## 🛠 Stack Tecnológico
| Capa        | Tecnología                          |
|-------------|-------------------------------------|
| Backend     | Java 17 + Spring Boot 3 + JPA       |
| Base de datos| H2 (en memoria, auto-configurada)   |
| Frontend    | HTML5 + CSS3 + JS Vanilla + Leaflet |
| Build/Run   | Maven Wrapper (`./mvnw`)            |

## Ejecución Rápida
```bash
git clone https://github.com/ElGamezzz/map-marker-app.git
cd map-marker-app
./mvnw spring-boot:run   # macOS/Linux
# mvnw.cmd spring-boot:run en Windows