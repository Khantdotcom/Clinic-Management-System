# API Contract (MVP)

Base URL: `/api`

## Auth
- `POST /auth/login`
- `POST /auth/register`

## Admin (ADMIN)
- `POST /admin/doctors`
- `PUT /admin/doctors/{id}`
- `GET /admin/doctors`
- `DELETE /admin/doctors/{id}`

## Doctor
- `GET /doctors/{id}/availability?date=YYYY-MM-DD`
- `PUT /doctors/{id}/availability`
- `GET /doctors/{id}/appointments?date=YYYY-MM-DD`

## Patient
- `GET /doctors/search?name=&specialty=`
- `POST /appointments`
- `GET /patients/me/appointments`
- `GET /patients/me/prescriptions`

## Prescriptions
- `POST /prescriptions`
- `GET /appointments/{id}/prescriptions`

## Reports
- `GET /reports/daily-appointments?doctorId=&date=`
- `GET /reports/top-doctor/month?year=&month=`
- `GET /reports/top-doctor/year?year=`

## Example: Login
Request
```json
{
  "email": "admin@clinic.com",
  "password": "Admin@123"
}
```
Response
```json
{
  "success": true,
  "message": "Login successful",
  "data": {
    "token": "<jwt>",
    "role": "ADMIN",
    "userId": 1,
    "fullName": "System Admin"
  }
}
```
