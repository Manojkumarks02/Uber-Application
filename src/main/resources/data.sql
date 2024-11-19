INSERT INTO app_user    (name, email, password) VALUES
('manojkumar', 'manoj@gmail.com', 'password'),
('priya', 'priya@gmail.com', 'password123'),
('arun', 'arun@gmail.com', 'arunpass'),
('suresh', 'suresh@yahoo.com', 'suresh789'),
('ravi', 'ravi@gmail.com', 'ravi@pass'),
('kavitha', 'kavitha@gmail.com', 'kavipass'),
('vijay', 'vijay@yahoo.com', 'vijay123'),
('anitha', 'anitha@gmail.com', 'anitha_pass'),
('meena', 'meena@gmail.com', 'meena123'),
('mohan', 'mohan@gmail.com', 'mohanpass'),
('arvind', 'arvind@gmail.com', 'arvind_123'),
('deepa', 'deepa@yahoo.com', 'deepa456'),
('ganesh', 'ganesh@gmail.com', 'ganeshpass'),
('lakshmi', 'lakshmi@gmail.com', 'laxmi_pass'),
('gokul', 'gokul@yahoo.com', 'gokul789'),
('nandhini', 'nandhini@gmail.com', 'nandy123'),
('balaji', 'balaji@gmail.com', 'balaji_pass'),
('swetha', 'swetha@gmail.com', 'swetha123'),
('naveen', 'naveen@gmail.com', 'naveen456'),
('vimal', 'vimal@yahoo.com', 'vimal_pass'),
('rajiv', 'rajiv@gmail.com', 'rajiv789'),
('hema', 'hema@gmail.com', 'hema_pass'),
('ajay', 'ajay@yahoo.com', 'ajay456'),
('sindhu', 'sindhu@gmail.com', 'sindhu_pass'),
('vikram', 'vikram@gmail.com', 'vikram_123'),
('rekha', 'rekha@yahoo.com', 'rekha789'),
('anand', 'anand@gmail.com', 'anandpass'),
('preethi', 'preethi@gmail.com', 'preethi_123'),
('raj', 'raj@gmail.com', 'rajpass'),
('santhosh', 'santhosh@yahoo.com', 'sandy123'),
('keerthi', 'keerthi@gmail.com', 'keerthi456'),
('bala', 'bala@gmail.com', 'bala_pass'),
('shalini', 'shalini@yahoo.com', 'shalini123'),
('rajesh', 'rajesh@gmail.com', 'rajesh_456'),
('jyothi', 'jyothi@gmail.com', 'jyothi_pass'),
('sunil', 'sunil@yahoo.com', 'sunil789'),
('rohini', 'rohini@gmail.com', 'rohini_pass'),
('karthik', 'karthik@gmail.com', 'karthik_123'),
('madhu', 'madhu@yahoo.com', 'madhu789'),
('shiva', 'shiva@gmail.com', 'shivapass'),
('neha', 'neha@gmail.com', 'neha_pass');

INSERT INTO user_roles (user_id, roles) VALUES
(1, 'RIDER'),
(2, 'DRIVER'),
(2, 'RIDER'),
(3, 'DRIVER'),
(3, 'RIDER'),
(4, 'DRIVER'),
(4, 'RIDER'),
(5, 'DRIVER'),
(5, 'RIDER'),
(6, 'DRIVER'),
(6, 'RIDER'),
(7, 'DRIVER'),
(7, 'RIDER'),
(8, 'DRIVER'),
(8, 'RIDER'),
(9, 'DRIVER'),
(9, 'RIDER'),
(10, 'DRIVER'),
(10, 'RIDER'),
(11, 'DRIVER'),
(11, 'RIDER'),
(12, 'DRIVER'),
(12, 'RIDER'),
(13, 'DRIVER'),
(13, 'RIDER'),
(14, 'DRIVER'),
(14, 'RIDER'),
(15, 'DRIVER'),
(15, 'RIDER'),
(16, 'DRIVER'),
(16, 'RIDER'),
(17, 'DRIVER'),
(17, 'RIDER'),
(18, 'DRIVER'),
(18, 'RIDER'),
(19, 'DRIVER'),
(19, 'RIDER'),
(20, 'DRIVER'),
(20, 'RIDER'),
(21, 'DRIVER'),
(21, 'RIDER'),
(22, 'DRIVER'),
(22, 'RIDER'),
(23, 'DRIVER'),
(23, 'RIDER'),
(24, 'DRIVER'),
(24, 'RIDER'),
(25, 'DRIVER'),
(25, 'RIDER'),
(26, 'DRIVER'),
(26, 'RIDER'),
(27, 'DRIVER'),
(27, 'RIDER'),
(28, 'DRIVER'),
(28, 'RIDER'),
(29, 'DRIVER'),
(29, 'RIDER'),
(30, 'DRIVER'),
(30, 'RIDER'),
(31, 'DRIVER'),
(31, 'RIDER'),
(32, 'DRIVER'),
(32, 'RIDER'),
(33, 'DRIVER'),
(33, 'RIDER'),
(34, 'DRIVER'),
(34, 'RIDER'),
(35, 'DRIVER'),
(35, 'RIDER'),
(36, 'DRIVER'),
(36, 'RIDER'),
(37, 'DRIVER'),
(37, 'RIDER'),
(38, 'DRIVER'),
(38, 'RIDER'),
(39, 'DRIVER'),
(39, 'RIDER'),
(40, 'ADMIN'),
(40, 'RIDER');

INSERT INTO rider(user_id, rating) VALUES
(1, 4.9);

INSERT INTO driver ( user_id, rating, available, current_location) VALUES
(2, 4.7, true, ST_GeomFromText('POINT(77.1025 28.7041)', 4326)),
(3, 4.7, true, ST_GeomFromText('POINT(77.1026 28.7042)', 4326)),
(4, 4.7, true, ST_GeomFromText('POINT(77.1027 28.7043)', 4326)),
(5, 4.9, true, ST_GeomFromText('POINT(77.1028 28.7044)', 4326)),
(6, 4.7, true, ST_GeomFromText('POINT(77.1029 28.7045)', 4326)),
(7, 4.7, true, ST_GeomFromText('POINT(77.1030 28.7046)', 4326)),
(8, 4.7, true, ST_GeomFromText('POINT(77.1031 28.7047)', 4326)),
(9, 4.7, true, ST_GeomFromText('POINT(77.1032 28.7048)', 4326)),
(10, 4.7, true, ST_GeomFromText('POINT(77.1033 28.7049)', 4326)),
(11, 4.7, true, ST_GeomFromText('POINT(77.1034 28.7050)', 4326)),
(12, 4.7, true, ST_GeomFromText('POINT(77.1035 28.7051)', 4326)),
(13, 4.7, true, ST_GeomFromText('POINT(77.1036 28.7052)', 4326)),
(14, 4.7, true, ST_GeomFromText('POINT(77.1037 28.7053)', 4326)),
(15, 4.7, true, ST_GeomFromText('POINT(77.1038 28.7054)', 4326)),
(16, 4.7, true, ST_GeomFromText('POINT(77.1039 28.7055)', 4326)),
(17, 4.7, true, ST_GeomFromText('POINT(77.1040 28.7056)', 4326)),
(18, 4.7, true, ST_GeomFromText('POINT(77.1041 28.7057)', 4326)),
(19, 4.7, true, ST_GeomFromText('POINT(77.1042 28.7058)', 4326)),
(20, 4.7, true, ST_GeomFromText('POINT(77.1043 28.7059)', 4326)),
(21, 4.7, true, ST_GeomFromText('POINT(77.1044 28.7060)', 4326)),
(22, 4.7, true, ST_GeomFromText('POINT(77.1045 28.7061)', 4326)),
(23, 4.7, true, ST_GeomFromText('POINT(77.1046 28.7062)', 4326)),
(24, 4.7, true, ST_GeomFromText('POINT(77.1047 28.7063)', 4326)),
(25, 4.7, true, ST_GeomFromText('POINT(77.1048 28.7064)', 4326)),
(26, 4.7, true, ST_GeomFromText('POINT(77.1049 28.7065)', 4326)),
(27, 4.7, true, ST_GeomFromText('POINT(77.1050 28.7066)', 4326)),
(28, 4.7, true, ST_GeomFromText('POINT(77.1051 28.7067)', 4326)),
(29, 4.7, true, ST_GeomFromText('POINT(77.1052 28.7068)', 4326)),
(30, 4.7, true, ST_GeomFromText('POINT(77.1053 28.7069)', 4326)),
(31, 4.7, true, ST_GeomFromText('POINT(77.1054 28.7070)', 4326)),
(32, 4.7, true, ST_GeomFromText('POINT(77.1055 28.7071)', 4326)),
(33, 4.7, true, ST_GeomFromText('POINT(77.1056 28.7072)', 4326)),
(34, 4.7, true, ST_GeomFromText('POINT(77.1057 28.7073)', 4326)),
(35, 4.7, true, ST_GeomFromText('POINT(77.1058 28.7074)', 4326)),
(36, 4.7, true, ST_GeomFromText('POINT(77.1059 28.7075)', 4326)),
(37, 4.7, true, ST_GeomFromText('POINT(77.1060 28.7076)', 4326)),
(38, 4.7, true, ST_GeomFromText('POINT(77.1061 28.7077)', 4326)),
(39, 4.7, true, ST_GeomFromText('POINT(77.1062 28.7078)', 4326)),
(40, 4.7, true, ST_GeomFromText('POINT(77.1063 28.7079)', 4326));

INSERT INTO wallet(user_id, balance) VALUES
(1, 100),
(2, 500);
