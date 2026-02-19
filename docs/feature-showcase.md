# Feature Showcase (Example Data)

This guide provides end-to-end sample data to demonstrate every MVP feature.

## Seed identities
- Admin: `admin@clinic.com` / `Admin@123`
- Doctor: `doctor@clinic.com` / `Doctor@123`
- Patient: `patient@clinic.com` / `Patient@123`

## Example domain data
- Doctor: `id=2`, `Dr. Aisha Patel`, specialty `Cardiology`
- Patient: `id=3`, `John Doe`
- Availability sample date: `2026-02-21`
- Slots: `09:00`, `09:30`, `10:00`
- Appointment sample: `id=10`, doctor `2`, patient `3`, date/time `2026-02-21 09:00`
- Prescription sample: diagnosis `Mild flu`, medications `Paracetamol 500mg twice daily for 3 days`

## Feature checklist with sample API calls
1. Authentication (login/register)
2. Admin doctor CRUD
3. Doctor search and availability
4. Appointment booking/listing
5. Prescription create/view
6. Reports: daily appointments + top doctor month/year

Use API contract examples in `docs/api-contract.md` and portal pages under `frontend/*` for demo-ready flows.
