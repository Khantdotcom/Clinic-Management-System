USE clinic_db;

INSERT INTO users (email, password, full_name, role, specialty)
VALUES
('admin@clinic.com', '$2a$10$PGc6Mr6ZtV2igxM5jI7fXeaJfr7CQ7ly4kVhiQg1fLgm61VRXqFMi', 'System Admin', 'ADMIN', NULL),
('doctor@clinic.com', '$2a$10$.mIr49ObfJmE35ljRwcviumGpk6xVxQiWJtSIe47uMlYoHSkjM5Uu', 'Dr. Aisha Patel', 'DOCTOR', 'Cardiology'),
('patient@clinic.com', '$2a$10$bP97uz7oRfgFl2ZRuGS8QO2X4DcKQbHIiOJkHhwspE4/AsfWEMu9K', 'John Doe', 'PATIENT', NULL)
ON DUPLICATE KEY UPDATE full_name = VALUES(full_name);
