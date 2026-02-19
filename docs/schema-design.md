# Schema Design

## Core tables
- `users` - unified users table with role (`ADMIN`, `DOCTOR`, `PATIENT`) and optional specialty.
- `doctor_available_times` - date/time slot level availability for doctors.
- `appointments` - booked slots connecting doctor + patient.
- `prescriptions` - clinical notes and medications for appointments.

## Relationships
- `appointments.doctor_id` -> `users.id` (DOCTOR)
- `appointments.patient_id` -> `users.id` (PATIENT)
- `prescriptions.appointment_id` -> `appointments.id`

## Reporting
Stored procedures in `db/stored-procedures.sql` provide:
- daily appointments by doctor
- top doctor by unique patients in month
- top doctor by unique patients in year
