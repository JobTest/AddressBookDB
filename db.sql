CREATE DATABASE addressbook CHARACTER SET utf8 COLLATE utf8_general_ci

CREATE TABLE IF NOT EXISTS `users` (
  `username` VARCHAR(30) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `fio` varchar(128) DEFAULT NULL,
  `telephone` varchar(13) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `address` text,
  `organization` varchar(32) DEFAULT NULL,
  `position` enum('DRIVER','COURIER','DIRECTOR','MANAGER') DEFAULT NULL,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 ;

INSERT INTO `users` (`username`, `password`, `fio`, `telephone`, `email`, `address`, `organization`, `position`, `enabled`) VALUES
  ('gavrishuk', 'EBESExQVFhcYGRobHB0eHw==', 'Gavrishuk Tetyana Alexandrovna', '0930189116', 'komahka@gmail.com', 'Kazatin city, P.Orlika 19 street', 'M.E.DOC', 'COURIER', TRUE),
  ('reshetnik', 'EBESExQVFhcYGRobHB0eHw==', 'Reshetnik Jurij', '0923041580', 'jurij.reshetnik@privatbank.ua', 'Nikolaev city, Mostoctroiteley 17 street', 'PrivatBank', 'MANAGER', TRUE),
  ('grogorievna', 'EBESExQVFhcYGRobHB0eHw==', 'Grogorievna Anna', '0512766330', 'agrogorievna@gmail.com', 'Nikolaev city, Nikolskaya 25 street', 'GlobalLogic', 'MANAGER', TRUE),
  ('mokretsova', 'EBESExQVFhcYGRobHB0eHw==', 'Mokretsova Anastasiya', '0660375435', 'amokretsova@gmail.com', 'Kiev city, Krasnoarmeyskaya 55 street', 'N.S.K.', 'MANAGER', TRUE),
  ('asulin', 'EBESExQVFhcYGRobHB0eHw==', 'Asulin Hay', '3103105441', 'chai@pushmyweb.com', 'Los Angeles city, 17777 Ventura Blvd., Suite 240\r\nEncino, CA 91316', 'PushMyWeb', 'DIRECTOR', TRUE),
  ('liron', 'EBESExQVFhcYGRobHB0eHw==', 'Liron', '8186548340', 'liron@pushmyweb.com', 'Los Angeles city, 17777 Ventura Blvd., Suite 240 Encino, CA 91316', 'PushMyWeb', 'COURIER', TRUE),
  ('haim', 'EBESExQVFhcYGRobHB0eHw==', 'Haim Ben Ami', '+972722116601', 'haim@veloxpro.com', '8 Hamelacha St. POB 8261\r\nNetanya 42505 Israel', 'Ignite Outsourcing', 'DIRECTOR', TRUE),
  ('rakhlin', 'EBESExQVFhcYGRobHB0eHw==', 'Rakhlin Boris', '+14157023031', 'boris.rakhlin@gmail.com', '6261 Hollis Street    Emeryville, CA 94608', 'Ignite Outsourcing', 'MANAGER', TRUE),
  ('sharaya', 'EBESExQVFhcYGRobHB0eHw==', 'Irina Sharaya', '+380936690016', 'ISharaya@luxoft.com', 'IBS Group of Companies\r\n10/14 Radishcheva Str.,Kiev, 03680', 'Luxoft', 'COURIER', TRUE),
  ('ieremeieva', 'EBESExQVFhcYGRobHB0eHw==', 'Lana Ieremeieva', '+380577630525', 'lanko.hr@gmail.com', 'Kiev city, Marinu Roskovoy 21 street', 'P-Product', 'COURIER', TRUE),
  ('lazarchuk', 'EBESExQVFhcYGRobHB0eHw==', 'Lazarchuk Alexandr Konstantinovitch', '0664097748', 'dn200978lak@gmail.com', 'Nikolaev, Kolodeznaya 5/62', 'home', 'MANAGER', TRUE);

CREATE TABLE user_roles (
  `user_role_id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(30) NOT NULL,
  `ROLE` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY uni_username_role (`ROLE`,`username`),
  KEY fk_username_idx (`username`),
  CONSTRAINT fk_username FOREIGN KEY (`username`) REFERENCES users (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 ;

INSERT INTO user_roles (username, ROLE) VALUES
  ('gavrishuk', 'ROLE_USER'),
  ('reshetnik', 'ROLE_USER'),
  ('grogorievna', 'ROLE_USER'),
  ('mokretsova', 'ROLE_USER'),
  ('asulin', 'ROLE_USER'),
  ('liron', 'ROLE_USER'),
  ('haim', 'ROLE_USER'),
  ('rakhlin', 'ROLE_USER'),
  ('sharaya', 'ROLE_USER'),
  ('ieremeieva', 'ROLE_USER'),
  ('lazarchuk', 'ROLE_USER');
