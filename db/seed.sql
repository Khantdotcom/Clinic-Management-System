USE clinic_db;

INSERT INTO users (email, password, full_name, role, specialty)
VALUES
('admin@clinic.com', '$2a$10$PGc6Mr6ZtV2igxM5jI7fXeaJfr7CQ7ly4kVhiQg1fLgm61VRXqFMi', 'System Admin', 'ADMIN', NULL),
('doctor@clinic.com', '$2a$10$.mIr49ObfJmE35ljRwcviumGpk6xVxQiWJtSIe47uMlYoHSkjM5Uu', 'Dr. Aisha Patel', 'DOCTOR', 'Cardiology'),
('patient@clinic.com', '$2a$10$bP97uz7oRfgFl2ZRuGS8QO2X4DcKQbHIiOJkHhwspE4/AsfWEMu9K', 'John Doe', 'PATIENT', NULL),
('jane@clinic.com', '$2a$10$bP97uz7oRfgFl2ZRuGS8QO2X4DcKQbHIiOJkHhwspE4/AsfWEMu9K', 'Jane Roe', 'PATIENT', NULL),
('sam@clinic.com', '$2a$10$bP97uz7oRfgFl2ZRuGS8QO2X4DcKQbHIiOJkHhwspE4/AsfWEMu9K', 'Sam Lee', 'PATIENT', NULL),
('ava@clinic.com', '$2a$10$bP97uz7oRfgFl2ZRuGS8QO2X4DcKQbHIiOJkHhwspE4/AsfWEMu9K', 'Ava Carter', 'PATIENT', NULL),
('noah@clinic.com', '$2a$10$bP97uz7oRfgFl2ZRuGS8QO2X4DcKQbHIiOJkHhwspE4/AsfWEMu9K', 'Noah Wilson', 'PATIENT', NULL)
ON DUPLICATE KEY UPDATE full_name = VALUES(full_name);

INSERT INTO patient (full_name, email, phone_number)
VALUES
('John Doe', 'patient@clinic.com', '+1000000001'),
('Jane Roe', 'jane@clinic.com', '+1000000002'),
('Sam Lee', 'sam@clinic.com', '+1000000003'),
('Ava Carter', 'ava@clinic.com', '+1000000004'),
('Noah Wilson', 'noah@clinic.com', '+1000000005')
ON DUPLICATE KEY UPDATE full_name = VALUES(full_name);
