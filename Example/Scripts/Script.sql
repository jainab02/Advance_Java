SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";
create database ATM_Users;
use ATM_Users;
CREATE TABLE `Users` (
  `UserID` int(7) NOT NULL,
  `Full Name` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `Pin` smallint(4) NOT NULL,
  `Balance` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
INSERT INTO `Users` (`UserID`, `Full Name`, `Pin`, `Balance`) VALUES
(123083749, 'Jainab', 0201, 323000),
(181011224, 'Shivam', 1102, 5000293),
(21309283,'Vaishnavi',0410,2340283);
ALTER TABLE `Users`
  ADD PRIMARY KEY (`UserID`);
SELECT * FROM Users;