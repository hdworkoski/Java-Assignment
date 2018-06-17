SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE DATABASE IF NOT EXISTS `NBA` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `NBA`;

CREATE TABLE `tblCoach` (
  `ID` varchar(5) NOT NULL,
  `team` varchar(30) NOT NULL,
  `firstName` varchar(30) NOT NULL,
  `lastName` varchar(30) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `email` varchar(60) NOT NULL,
  `yearsExp` smallint(4) NOT NULL,
  `championships` tinyint(3) NOT NULL,
  `playoffs` tinyint(3) NOT NULL,
  `wLRatio` decimal(3,3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `tblCoach` (`ID`, `team`, `firstName`, `lastName`, `phone`, `email`, `yearsExp`, `championships`, `playoffs`, `wLRatio`) VALUES
('1001', 'Atlanta Hawks', 'Lloyd', 'Pierce', '203 298 3729', 'lloydpierce@gmail.com', 0, 0, 0, '0.000'),
('1002', 'Boston Celtics', 'Brad', 'Stevens', '902 829 3023', 'bradstevens@celtics.com', 5, 0, 4, '0.671'),
('1003', 'Brooklyn Nets', 'Kenny', 'Atkinson', '380 289 2983', 'kennyatkinson@gmail.com', 5, 0, 1, '0.341'),
('1004', 'Charlotte Hornets', 'James', 'Borrego', '203 892 4082', 'jamesborrego@hotmail.com', 4, 0, 1, '0.000'),
('1005', 'Chicago Bulls', 'Fred', 'Hoiberg', '389 298 4983', 'fredhoiberg@yahoo.com', 2, 0, 1, '0.329'),
('1006', 'Cleveland Cavaliers', 'Tyronn', 'Lue', '489 028 3927', 'tlue@gmail.com', 5, 1, 5, '0.610'),
('1007', 'Dallas Mavericks', 'Rick', 'Carlisle', '279 208 2983', 'rickcarlisle@yahoo.com', 15, 1, 12, '0.293'),
('1008', 'Denver Nuggets', 'Michael', 'Malone', '302 839 8430', 'mmalone@gmail.com', 5, 0, 0, '0.561'),
('1009', 'Detroit Pistons', 'Dwayne', 'Casey', '208 283 0283', 'dwaynecasey@pistons.com', 9, 0, 5, '0.720'),
('1010', 'Golden State Warriors', 'Steve', 'Kerr', '918 371 0382', 'stevekerr@gsw.com', 4, 3, 4, '0.707'),
('1011', 'Houston Rockets', 'Mike', 'D\'Antoni', '283 028 8484', 'mikedantoni@yahoo.com', 14, 0, 8, '0.793'),
('1012', 'Indiana Pacers', 'Nate', 'McMillan', '408 273 0484', 'natemcmillan@yahoo.com', 17, 0, 7, '0.585'),
('1013', 'LA Clippers', 'Doc', 'Rivers', '818 384 0238', 'docrivers@clippers.com', 18, 1, 16, '0.512'),
('1014', 'Los Angeles Lakers', 'Luke', 'Walton', '310 839 2733', 'lukewalton@lalakers.com', 4, 0, 2, '0.427'),
('1015', 'Memphis Grizzlies', 'J.B.', 'Bickerstaff', '382 883 1722', 'jbbick@grizz.com', 4, 0, 2, '0.238'),
('1016', 'Miami Heat', 'Erik', 'Spoelstra', '203 887 1002', 'erikspoelstra@heat.com', 10, 2, 8, '0.537'),
('1017', 'Milwaukee Bucks', 'Mike', 'Budenholzer', '293 279 4028', 'mike@mbucks.com', 5, 0, 4, '0.293'),
('1018', 'Minnesota Timberwolves', 'Tom', 'Thibodeau', '203 942 0022', 'tomt@timberwolves.com', 7, 0, 6, '0.573'),
('1019', 'New Orleans Pelicans', 'Alvin', 'Gentry', '302 830 0002', 'alvingentry@pelicans.com', 13, 0, 3, '0.585'),
('1020', 'New York Knicks', 'David', 'Fizdale', '302 918 3002', 'davidfizdale@gmail.com', 5, 0, 2, '0.368'),
('1021', 'Oklahoma City Thunder', 'Billy', 'Donovan', '203 102 2803', 'billydonovan@okc.com', 3, 0, 3, '0.585'),
('1022', 'Orlando Magic', 'Steve', 'Clifford', '102 993 0233', 'steveclifford@magic.com', 5, 0, 2, '0.439'),
('1023', 'Philadelphia 76ers', 'Brett', 'Brown', '209 303 0293', 'bbrown@philly.com', 5, 0, 1, '0.634'),
('1024', 'Phoenix Suns', 'Igor', 'Kokoskov', '102 804 2983', 'igorkokoskov@yahoo.com', 4, 0, 0, '0.500'),
('1025', 'Portland Trail Blazers', 'Terry', 'Stotts', '308 028 3022', 'terrystots@yahoo.com', 10, 0, 6, '0.598'),
('1026', 'Sacramento Kings', 'David', 'Joerger', '108 208 2039', 'david@sackings.com', 5, 0, 3, '0.329'),
('1027', 'San Antonio Spurs', 'Gregg', 'Popovich', '404 298 2833', 'gregg@spurs.com', 21, 5, 21, '0.573'),
('1028', 'Toronto Raptors', 'Nick', 'Nurse', '801 293 5598', 'nicknurse@toronto.com', 0, 0, 0, '0.000'),
('1029', 'Utah Jazz', 'Quin', 'Snyder', '506 839 0837', 'quinsnyder@yahoo.com', 5, 0, 3, '0.585'),
('1030', 'Washington Wizards', 'Scott', 'Brooks', '208 589 2983', 'scottbrooks@gmail.com', 9, 0, 7, '0.524');

CREATE TABLE `tblPlayer` (
  `ID` varchar(5) NOT NULL,
  `team` varchar(30) NOT NULL,
  `firstName` varchar(30) NOT NULL,
  `lastName` varchar(30) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `email` varchar(60) NOT NULL,
  `number` varchar(2) NOT NULL,
  `college` varchar(40) NOT NULL,
  `rookie` tinyint(1) NOT NULL,
  `startYear` smallint(4) NOT NULL,
  `position` varchar(20) NOT NULL,
  `country` varchar(30) NOT NULL,
  `ppg` float(3,1) NOT NULL,
  `rpg` float(3,1) NOT NULL,
  `highScore` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `tblPlayer` (`ID`, `team`, `firstName`, `lastName`, `phone`, `email`, `number`, `college`, `rookie`, `startYear`, `position`, `country`, `ppg`, `rpg`, `highScore`) VALUES
('1001', 'Cleveland Cavaliers', 'LeBron', 'James', '918 283 4932', 'lebronjames@gmail.com', '23', 'none', 0, 2003, 'Small Forward', 'USA', 27.2, 7.4, 61),
('1002', 'Golden State Warriors', 'Kevin', 'Durant', '202 382 0483', 'kevindurant@hotmail.com', '35', 'University of Texas at Austin', 0, 2007, 'Small Forward', 'USA', 25.1, 8.3, 54),
('1003', 'San Antonio Spurs', 'Kawhi', 'Leonard', '298 291 7239', 'kleonard@gmail.com', '2', 'San Diego State University', 0, 2011, 'Small Forward', 'USA', 25.5, 5.8, 29),
('1004', 'Golden State Warriors', 'Stephen', 'Curry', '907 293 0031', 'stephcurry@hotmail.com', '30', 'Davidson College', 0, 2009, 'Point Guard', 'USA', 25.3, 4.5, 54),
('1005', 'Oklahoma City Thunder', 'Russell', 'Westbrook', '389 203 0330', 'russwestbrook@yahoo.com', '0', 'University of California, Los Angeles', 0, 2008, 'Point Guard', 'USA', 31.6, 10.7, 58),
('1006', 'Houston Rockets', 'James', 'Harden', '203 848 3394', 'jamesharden@gmail.com', '13', 'Arizona State University', 0, 2009, 'Shooting Guard', 'USA', 29.1, 8.1, 60),
('1007', 'Milwaukee Bucks', 'Giannis', 'Antetokounmpo', '293 874 6649', 'gantetokounmpo@hotmail.com', '34', 'none', 0, 2013, 'Small Forward', 'Greece', 22.9, 8.8, 44),
('1008', 'New Orleans Pelicans', 'Anthony', 'Davis', '203 884 3923', 'anthonydavis@yahoo.com', '23', 'University of Kentucky', 0, 2012, 'Power Forward', 'USA', 28.0, 11.8, 59),
('1009', 'Minnesota Timberwolves', 'Jimmy', 'Butler', '102 893 4038', 'jimmybutler@hotmail.com', '23', 'Marquette University', 0, 2011, 'Small Forward', 'USA', 23.9, 6.2, 53),
('1010', 'Minnesota Timberwolves', 'Karl-Anthony', 'Towns', '405 389 3948', 'kat@gmail.com', '32', 'University of Kentucky', 0, 2015, 'Center', 'USA', 25.1, 12.3, 56),
('1011', 'Golden State Warriors', 'Draymond', 'Green', '798 038 0023', 'draymondgreen@yahoo.com', '23', 'Michigan State University', 0, 2012, 'Power Forward', 'USA', 10.2, 7.9, 37),
('1012', 'Houston Rockets', 'Chris', 'Paul', '809 380 0283', 'chrispaul@gmail.com', '3', 'Wake Forest University', 0, 2005, 'Point Guard', 'USA', 18.1, 5.0, 38),
('1013', 'Washington Wizards', 'John', 'Wall', '508 394 3994', 'johnwall@gmail.com', '2', 'University of Kentucky', 0, 2010, 'Point Guard', 'USA', 23.1, 4.2, 52),
('1014', 'Golden State Warriors', 'Klay', 'Thompson', '102 382 4893', 'klaythompson@gmail.com', '11', 'Washington State University', 0, 2011, 'Shooting Guard', 'USA', 22.3, 3.7, 60),
('1015', 'Oklahoma City Thunder', 'Paul', 'George', '928 389 9283', 'paulgeorge@hotmail.com', '13', 'California State University, Fresno', 0, 2010, 'Small Forward', 'USA', 23.7, 6.6, 48),
('1016', 'New Orleans Pelicans', 'DeMarcus', 'Cousins', '403 283 9237', 'demarcuscousins@gmail.com', '0', 'University of Kentucky', 0, 2010, 'Center', 'USA', 27.8, 10.6, 56),
('1017', 'Boston Celtics', 'Gordon', 'Hayward', '708 023 8898', 'gordonhayward@hotmail.com', '20', 'Butler University', 0, 2010, 'Small Forward', 'USA', 21.9, 5.4, 39),
('1018', 'Utah Jazz', 'Rudy', 'Gobert', '708 028 3820', 'rudygobert@gmail.com', '27', 'Marist College', 0, 2013, 'Center', 'France', 14.0, 12.8, 35),
('1019', 'Memphis Grizzlies', 'Marc', 'Gasol', '908 937 2937', 'marcgasol@gmail.com', '33', 'none', 0, 2003, 'Center', 'Spain', 19.5, 6.3, 33),
('1020', 'Toronto Raptors', 'Kyle', 'Lowry', '901 280 2983', 'kylelowry@hotmail.com', '7', 'Villanova University', 0, 2006, 'Point Guard', 'USA', 22.4, 4.8, 43),
('1021', 'Denver Nuggets', 'Paul', 'Millsap', '302 803 3048', 'pmillsap@gmail.com', '4', 'Louisiana Tech', 0, 2006, 'Power Forward', 'USA', 18.1, 7.7, 46),
('1022', 'Detroit Pistons', 'Blake', 'Griffin', '818 302 0482', 'blakegriffin@gmail.com', '23', 'University of Oklahoma', 0, 2009, 'Power Forward', 'USA', 21.6, 8.1, 47),
('1023', 'Memphis Grizzlies', 'Mike', 'Conley', '203 493 2038', 'mikeconley@gmail.com', '11', 'Ohio State University', 0, 2007, 'Point Guard', 'USA', 20.5, 3.5, 38),
('1024', 'Portland Trail Blazers', 'Damian', 'Lillard', '408 397 2093', 'damianlillary@yahoo.com', '0', 'Weber State University', 0, 2012, 'Point Guard', 'USA', 27.0, 4.9, 59),
('1025', 'LA Clippers', 'DeAndre', 'Jordan', '818 304 4839', 'deandre@gmail.com', '6', 'Texas A&M University', 0, 2008, 'Center', 'USA', 12.7, 13.8, 30),
('1036', 'New York Knicks', 'Kristaps', 'Porzingis', '917 308 3082', 'kristaps@yahoo.com', '6', 'none', 0, 2015, 'Power Forward', 'Latvia', 18.1, 7.2, 40),
('1038', 'Charlotte Hornets', 'Kemba', 'Walker', '208 389 3982', 'kwalker@gmail.com', '15', 'University of Connecticut', 0, 2011, 'Point Guard', 'USA', 23.2, 3.9, 52),
('1044', 'Los Angeles Lakers', 'Brook', 'Lopez', '818 208 3082', 'brooklopez@hotmail.com', '11', 'Stanford University', 0, 2008, 'Center', 'USA', 20.5, 5.4, 39),
('1046', 'Dallas Mavericks', 'Harrison', 'Barnes', '308 398 4982', 'harrisonbarnes@yahoo.com', '40', 'University of North Carolina Chapel Hill', 0, 2012, 'Power Forward', 'USA', 19.2, 5.0, 34),
('1048', 'Miami Heat', 'Goran', 'Dragic', '908 579 3984', 'gorandragic@gmail.com', '7', 'none', 0, 2008, 'Point Guard', 'Slovenia', 20.3, 3.8, 40),
('1055', 'Cleveland Cavaliers', 'George', 'Hill', '803 792 7492', 'georgehill@hotmail.com', '3', 'Indiana University Purdue', 0, 2008, 'Point Guard', 'USA', 16.9, 3.4, 34),
('1064', 'Indiana Pacers', 'Myles', 'Turner', '402 284 9344', 'mylesturner@gmail.com', '33', 'University of Texas at Austin', 0, 2015, 'Center', 'USA', 14.5, 7.3, 26),
('1067', 'Phoenix Suns', 'Devin', 'Booker', '205 398 5082', 'devinbooker@yahoo.com', '1', 'University of Kentucky', 0, 2015, 'Point Guard', 'USA', 22.1, 3.2, 70),
('1068', 'Philadelphia 76ers', 'Joel', 'Embiid', '503 682 2947', 'joelembiied@gmail.com', '21', 'University of Kansas', 0, 2014, 'Center', 'Cameroon', 20.2, 7.8, 46),
('1084', 'Atlanta Hawks', 'Dennis', 'Schroder', '209 302 8403', 'dennisschroder@yahoo.com', '17', 'none', 0, 2013, 'Point Guard', 'Germany', 17.9, 3.1, 41),
('1091', 'Orlando Magic', 'Evan', 'Fournier', '408 508 3984', 'evanfournier@yahoo.com', '10', 'none', 0, 2012, 'Shooting Guard', 'France', 17.2, 3.1, 32);

CREATE TABLE `tblTeam` (
  `name` varchar(30) NOT NULL,
  `conference` varchar(15) NOT NULL,
  `division` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `tblTeam` (`name`, `conference`, `division`) VALUES
('Atlanta Hawks', 'Eastern', 'Southeast'),
('Boston Celtics', 'Eastern', 'Atlantic'),
('Brooklyn Nets', 'Eastern', 'Atlantic'),
('Charlotte Hornets', 'Eastern', 'Southeast'),
('Chicago Bulls', 'Eastern', 'Central'),
('Cleveland Cavaliers', 'Eastern', 'Central'),
('Dallas Mavericks', 'Western', 'Southwest'),
('Denver Nuggets', 'Western', 'Northwest'),
('Detroit Pistons', 'Eastern', 'Central'),
('Golden State Warriors', 'Western', 'Pacific'),
('Houston Rockets', 'Western', 'Southwest'),
('Indiana Pacers', 'Eastern', 'Central'),
('LA Clippers', 'Western', 'Pacific'),
('Los Angeles Lakers', 'Western', 'Pacific'),
('Memphis Grizzlies', 'Western', 'Southwest'),
('Miami Heat', 'Eastern', 'Southeast'),
('Milwaukee Bucks', 'Eastern', 'Central'),
('Minnesota Timberwolves', 'Western', 'Northwest'),
('New Orleans Pelicans', 'Western', 'Southwest'),
('New York Knicks', 'Eastern', 'Atlantic'),
('Oklahoma City Thunder', 'Western', 'Northwest'),
('Orlando Magic', 'Eastern', 'Southeast'),
('Philadelphia 76ers', 'Eastern', 'Atlantic'),
('Phoenix Suns', 'Western', 'Pacific'),
('Portland Trail Blazers', 'Western', 'Northwest'),
('Sacramento Kings', 'Western', 'Pacific'),
('San Antonio Spurs', 'Western', 'Southwest'),
('Toronto Raptors', 'Eastern', 'Atlantic'),
('Utah Jazz', 'Western', 'Northwest'),
('Washington Wizards', 'Eastern', 'Southeast');


ALTER TABLE `tblCoach`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `team` (`team`);

ALTER TABLE `tblPlayer`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `team` (`team`);

ALTER TABLE `tblTeam`
  ADD PRIMARY KEY (`name`);


ALTER TABLE `tblCoach`
  ADD CONSTRAINT `tblcoach_ibfk_1` FOREIGN KEY (`team`) REFERENCES `tblTeam` (`name`);

ALTER TABLE `tblPlayer`
  ADD CONSTRAINT `tblplayer_ibfk_1` FOREIGN KEY (`team`) REFERENCES `tblTeam` (`name`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
