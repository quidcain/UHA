DROP TABLE IF EXISTS `eptituders_clans`;

CREATE TABLE `eptituders_clans` (
  `eptituder_id` bigint(20) NOT NULL,
  `clan_id` bigint(20) NOT NULL,
  PRIMARY KEY (`eptituder_id`, `clan_id`)
);


DROP TABLE IF EXISTS `clans`;

CREATE TABLE `clans` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `side` varchar(255) DEFAULT NULL,
  `ico` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `eptituders_events`;

CREATE TABLE `eptituders_events` (
  `eptituder_id` bigint(20) NOT NULL,
  `event_id` bigint(20) NOT NULL,
  PRIMARY KEY (`eptituder_id`, `event_id`)
);

DROP TABLE IF EXISTS `eptituders`;

CREATE TABLE `eptituders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `eptitudes` varchar(255) DEFAULT NULL,
  `ico` varchar(255) DEFAULT NULL,
  `side` varchar(255) DEFAULT NULL,
  `bio` text,
  `rank` varchar(255) DEFAULT NULL,
  `points` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `eptituder_roles`;

CREATE TABLE `eptituder_roles` (
  `name` varchar(255) DEFAULT NULL,
  `role` varchar(40) DEFAULT NULL
);

DROP TABLE IF EXISTS `events`;

CREATE TABLE `events` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` text,
  `ico` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `points` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `rank` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `exams_questions`;

CREATE TABLE `exams_questions` (
  `exam_id` bigint(20) NOT NULL,
  `question_id` bigint(20) NOT NULL,
  PRIMARY KEY (`exam_id`, `question_id`)
);

DROP TABLE IF EXISTS `exam_tickets_questions`;

CREATE TABLE `exam_tickets_questions` (
  `exam_ticket_id` bigint(20) NOT NULL,
  `question_id` bigint(20) NOT NULL,
  PRIMARY KEY (`exam_ticket_id`, `question_id`)
);

DROP TABLE IF EXISTS `exam_tickets`;

CREATE TABLE `exam_tickets` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rank` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `questions`;

CREATE TABLE `questions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `question` text,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `exams`;

CREATE TABLE `exams` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `exam_ticket_id` bigint(20) DEFAULT NULL,
  `eptituder_id` bigint(20) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `answers`;

CREATE TABLE `answers` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `exam_id` bigint(20) DEFAULT NULL,
  `question_id` bigint(20) DEFAULT NULL,
  `answer` text,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
