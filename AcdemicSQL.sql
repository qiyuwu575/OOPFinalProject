-- Users table to store both academic professionals and institutions
Drop table if exists Users;
CREATE TABLE Users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    user_type ENUM('AcademicProfessional', 'AcademicInstitution') NOT NULL,
    current_institution VARCHAR(255),
    academic_position VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 专业人员档案表 (Professional_Profiles)
Drop table if exists Professional_Profiles;
CREATE TABLE Professional_Profiles (
    profile_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    current_position VARCHAR(100),
    current_institution VARCHAR(100),
    education_background TEXT,
    area_of_expertise TEXT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- Professional profiles for academic professionals
Drop table if exists Institution_Profiles;
CREATE TABLE Institution_Profiles (
    profile_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    institution_name VARCHAR(100) NOT NULL,
    institution_address TEXT,
    contact_email VARCHAR(100),
    contact_phone VARCHAR(20),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- 课程表 (Courses)
Drop table if exists Courses;
CREATE TABLE Courses (
    course_id INT PRIMARY KEY AUTO_INCREMENT,
    institution_id INT NOT NULL,
    course_code VARCHAR(20) NOT NULL,
    course_name VARCHAR(100) NOT NULL,
    course_outline TEXT,
    term VARCHAR(10) NOT NULL,  -- 例如: '24W', '24S', '24F'
    schedule VARCHAR(100),      -- 例如: "Mon/Wed 10:00-11:30"
    delivery_method ENUM('In-Person', 'Online', 'Hybrid') NOT NULL,
    compensation DECIMAL(10,2),
    preferred_qualifications TEXT,
    status ENUM('Open', 'Closed', 'Pending') DEFAULT 'Open',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (institution_id) REFERENCES Users(user_id)
);

-- 教学申请表 (Teaching_Requests)
Drop table if exists Teaching_Requests;
CREATE TABLE Teaching_Requests (
    request_id INT PRIMARY KEY AUTO_INCREMENT,
    course_id INT NOT NULL,
    professional_id INT NOT NULL,
    status ENUM('Pending', 'Approved', 'Rejected') DEFAULT 'Pending',
    request_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    response_date TIMESTAMP NULL,
    comments TEXT,
    FOREIGN KEY (course_id) REFERENCES Courses(course_id),
    FOREIGN KEY (professional_id) REFERENCES Users(user_id)
);

CREATE TABLE Notifications (
    notification_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    message TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_read BOOLEAN DEFAULT FALSE,
    type VARCHAR(50),
    related_id INT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);


CREATE TABLE Applications (
    application_id INT PRIMARY KEY AUTO_INCREMENT,
    course_id INT NOT NULL,
    professional_id INT NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    application_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (course_id) REFERENCES Courses(course_id),
    FOREIGN KEY (professional_id) REFERENCES Users(user_id)
);