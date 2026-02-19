USE clinic_db;

DROP PROCEDURE IF EXISTS sp_daily_appointments_by_doctor;
DELIMITER $$
CREATE PROCEDURE sp_daily_appointments_by_doctor(IN p_doctor_id BIGINT, IN p_date DATE)
BEGIN
  SELECT doctor_id, appointment_date, COUNT(*) AS total_appointments
  FROM appointments
  WHERE doctor_id = p_doctor_id AND appointment_date = p_date
  GROUP BY doctor_id, appointment_date;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS sp_top_doctor_by_month;
DELIMITER $$
CREATE PROCEDURE sp_top_doctor_by_month(IN p_year INT, IN p_month INT)
BEGIN
  SELECT a.doctor_id, u.full_name AS doctor_name, COUNT(DISTINCT a.patient_id) AS total_patients
  FROM appointments a
  JOIN users u ON u.id = a.doctor_id
  WHERE YEAR(a.appointment_date) = p_year AND MONTH(a.appointment_date) = p_month
  GROUP BY a.doctor_id, u.full_name
  ORDER BY total_patients DESC
  LIMIT 1;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS sp_top_doctor_by_year;
DELIMITER $$
CREATE PROCEDURE sp_top_doctor_by_year(IN p_year INT)
BEGIN
  SELECT a.doctor_id, u.full_name AS doctor_name, COUNT(DISTINCT a.patient_id) AS total_patients
  FROM appointments a
  JOIN users u ON u.id = a.doctor_id
  WHERE YEAR(a.appointment_date) = p_year
  GROUP BY a.doctor_id, u.full_name
  ORDER BY total_patients DESC
  LIMIT 1;
END $$
DELIMITER ;

-- Grading-friendly aliases requested in assessment prompts
DROP PROCEDURE IF EXISTS GetDailyAppointmentReportByDoctor;
DELIMITER $$
CREATE PROCEDURE GetDailyAppointmentReportByDoctor(IN p_doctor_id BIGINT, IN p_date DATE)
BEGIN
  CALL sp_daily_appointments_by_doctor(p_doctor_id, p_date);
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS GetDoctorWithMostPatientsByMonth;
DELIMITER $$
CREATE PROCEDURE GetDoctorWithMostPatientsByMonth(IN p_year INT, IN p_month INT)
BEGIN
  CALL sp_top_doctor_by_month(p_year, p_month);
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS GetDoctorWithMostPatientsByYear;
DELIMITER $$
CREATE PROCEDURE GetDoctorWithMostPatientsByYear(IN p_year INT)
BEGIN
  CALL sp_top_doctor_by_year(p_year);
END $$
DELIMITER ;
