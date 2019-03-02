DROP database if exists signature_clients;

CREATE DATABASE `signature_clients`;

use signature_clients;

CREATE TABLE `pays` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(200) NOT NULL,
  `nationalite` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO `pays` VALUES 
(1,'France','Français'),
(2,'Belgique','Belge');

CREATE TABLE `ville` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cp` varchar(5),
  `nom` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO `ville` VALUES 
(1,'69000','Lyon'),
(2,'75000','Paris');

CREATE TABLE `type_marital` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_marital` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

INSERT INTO `type_marital` VALUES 
(1,'célibataire'),
(2,'marié\(e\)'), 
(3, 'divorcé\(e\)'), 
(4, 'veuf\(ve\)'), 
(5, 'séparé\(e\) de corps');

CREATE TABLE `lieu_mariage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `lieu` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `lieu_mariage` VALUES 
(1,'mairie'), 
(2,'consulat'), 
(3,'autre autorité');

CREATE TABLE `cause_rupture_PACS` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cause` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

INSERT INTO `cause_rupture_PACS` VALUES 
(1,'mariage'), 
(2,'rupture'), 
(3,'décès'), 
(4,'rupture');

CREATE TABLE `type_PACS` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `type_PACS` VALUES 
(1,'authentique'), 
(2,'SSP déposé'), 
(3,'SSP non déposé');

CREATE TABLE `regime_mariage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

INSERT INTO `regime_mariage` VALUES 
(1,'communauté légale réduite aux acquets'), 
(2,'communauté légale meubles et acquets'), 
(3,'communauté conventionnelle réduite aux acquets'),
(4,'communauté conventionnelle meubles et acquets'), 
(5,'communauté conventionnelle meubles et acquets'), 
(6,'séparation de biens'), 
(7,'séparation de biens avec société acquets'), 
(8,'participation aux acquets'), 
(9,'autre régime français');

CREATE TABLE `divorce_rendu_par` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rendu_par` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO `divorce_rendu_par` VALUES 
(1,'tribunal de grande instance'), 
(2,'cour d\'appel');

CREATE TABLE `capacite` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `capacite` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO `capacite` VALUES 
(1,'capable'), 
(2,'tutelle'), 
(3,'curatelle'), 
(4,'sauvegarde de justice'), 
(5,'habilitation familiale');

CREATE TABLE `statut` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO `statut` VALUES 
(1,'résident'), 
(2,'résident UE'), 
(3,'non résident');

CREATE TABLE `coordonnees` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `telephone` varchar(200) NOT NULL,
  `comment_telephone` varchar(200) DEFAULT NULL,
  `telephone_pro` varchar(200) DEFAULT NULL,
  `comment_telephone_pro` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `comment_email` varchar(200) DEFAULT NULL,
  `email_pro` varchar(200) DEFAULT NULL,
  `comment_email_pro` varchar(200) DEFAULT NULL,
  `fax` varchar(200) DEFAULT NULL,
  `comment_fax` varchar(200) DEFAULT NULL,
  `site_web` varchar(200) DEFAULT NULL,
  `comment_site_web` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO `coordonnees` (`id`, `telephone`)
VALUES 
(1,'0478005634'),
(2,'0176983209');

CREATE TABLE `document` (
  `id` bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `libelle` varchar(200) NOT NULL,
  `categorie` varchar(200) DEFAULT NULL,
  `typeDoc` varchar(200) NOT NULL,
  `dateEnregistrement` datetime NOT NULL,
  `document` blob NOT NULL,
  `id_client` bigint(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `deces` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `commentaire` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO `deces` VALUES 
(1,'2019-02-21','décès à l\'hôpital');

CREATE TABLE `adresse` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `num` int(4) DEFAULT NULL,
  `ordre_voie` varchar(5) DEFAULT NULL,
  `type_voie` varchar(15) DEFAULT NULL,
  `nom_voie` varchar(200) NOT NULL,
  `id_personne` bigint(20) NOT NULL,
  `id_ville` bigint(20) NOT NULL,
  `id_pays` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_deces_id_personne_idx` (`id_personne`), 
  CONSTRAINT `fk_personne_id_ville` FOREIGN KEY (`id_ville`) REFERENCES `ville` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_personne_id_pays` FOREIGN KEY (`id_pays`) REFERENCES `pays` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO `adresse` VALUES 
(1, 4, 'bis', 'rue', 'Louis XIV', 1, 1, 1),
(2, 5, 'ter', 'avenue', 'Napoléon', 1, 1, 2);

CREATE TABLE `evenement` (
  `id` bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `id_type_marital` bigint(20) NOT NULL,
  `est_pacse` boolean NOT NULL,
  `id_type_PACS` bigint(20) default null, 
  `date` date DEFAULT NULL,
  `jugement_divorce_date` date DEFAULT NULL,
  `comment_separation` varchar(200) DEFAULT NULL,
  `id_cause_rupture_PACS` bigint(20) DEFAULT NULL,
  `notaire` varchar(50) DEFAULT NULL,
  `id_divorce_rendu_par` bigint(20) DEFAULT NULL,
  `id_lieu_mariage` bigint(20) DEFAULT NULL,
  `id_regime_mariage` bigint(20) DEFAULT NULL,
  `id_pays_mariage` bigint(20) DEFAULT NULL,
  `id_ville` bigint(20) DEFAULT NULL,
  `id_client` bigint(20) NOT NULL,
  `id_conjoint` bigint(20) DEFAULT NULL,
  KEY `fk_evenement_id_client_idx` (`id_client`), 
  CONSTRAINT `fk_evenement_id_type_marital` FOREIGN KEY (`id_type_marital`) REFERENCES `type_marital` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_evenement_id_type_PACS` FOREIGN KEY (`id_type_PACS`) REFERENCES `type_PACS` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_evenement_id_divorce_rendu_par` FOREIGN KEY (`id_divorce_rendu_par`) REFERENCES `divorce_rendu_par` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION, 
  CONSTRAINT `fk_evenement_id_lieu_mariage` FOREIGN KEY (`id_lieu_mariage`) REFERENCES `lieu_mariage` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_evenement_id_regime_mariage` FOREIGN KEY (`id_regime_mariage`) REFERENCES `regime_mariage` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_evenement_id_pays_mariage` FOREIGN KEY (`id_pays_mariage`) REFERENCES `pays` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_evenement_id_ville` FOREIGN KEY (`id_ville`) REFERENCES `ville` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO `evenement` (`id`, `id_type_marital`, `est_pacse`, `id_client`, `id_conjoint`)
VALUES 
(1, 1, false, 1, null),
(2, 2, false, 2, 3);

CREATE TABLE `historique` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_client` bigint(20) NOT NULL,
  `id_evenement` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_historique_id_client_idx` (`id_client`),
  KEY `fk_historique_id_evenement_idx` (`id_evenement`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO `historique` 
VALUES 
(1, 1, 1),
(2, 2, 2);

CREATE TABLE `personne` (
  `id` bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `est_client` boolean NOT NULL,
  `civilite` varchar(10) DEFAULT NULL,
  `nom` varchar(200) NOT NULL,
  `prenoms` varchar(200) DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `nationalite` varchar(50) DEFAULT NULL,
  `profession` varchar(200) DEFAULT NULL,
  `nom_usuel` varchar(200) DEFAULT NULL,
  `prenom_usuel` varchar(200) DEFAULT NULL,
  `id_etat_marital_PACS` bigint(20) DEFAULT NULL,
  `clerc_referent` varchar(200) DEFAULT NULL,
  `notaire_referent` varchar(200) DEFAULT NULL,
  `date_modif_fiche` date DEFAULT NULL,
  `id_coordonnes` bigint(20) DEFAULT NULL,
  `id_statut` bigint(20) DEFAULT NULL,
  `id_pays_naissance` bigint(20) DEFAULT NULL,
  `id_ville_naissance` bigint(20) DEFAULT NULL,
  `id_capacite` bigint(20) DEFAULT NULL,
  `id_deces` bigint(20) DEFAULT NULL,
  `id_coordonnees` bigint(20) DEFAULT NULL,
  CONSTRAINT `fk_personne_id_coordonnees` FOREIGN KEY (`id_coordonnees`) REFERENCES `coordonnees` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_personne_id_statut` FOREIGN KEY (`id_statut`) REFERENCES `statut` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_personne_id_pays_naissance` FOREIGN KEY (`id_pays_naissance`) REFERENCES `pays` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_personne_id_ville_naissance` FOREIGN KEY (`id_ville_naissance`) REFERENCES `ville` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_personne_id_capacite` FOREIGN KEY (`id_capacite`) REFERENCES `capacite` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO `personne` 
(`id`, `est_client`, `nom`, `prenoms`,`id_etat_marital_PACS`)
VALUES 
(1, true, "dupont", "jean", 1),
(2, true, "martin", "julie", 2), 
(3, false, "martin", "michel", 2);

ALTER TABLE document
ADD CONSTRAINT `fk_document_id_client` FOREIGN KEY (`id_client`) REFERENCES `personne` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE adresse
ADD CONSTRAINT `fk_adresse_id_personne` FOREIGN KEY (`id_personne`) REFERENCES `personne` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE evenement
ADD CONSTRAINT `fk_evenement_id_client` FOREIGN KEY (`id_client`) REFERENCES `personne` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION, 
ADD CONSTRAINT `fk_evenement_id_conjoint` FOREIGN KEY (`id_conjoint`) REFERENCES `personne` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE historique
ADD CONSTRAINT `fk_historique_id_client` FOREIGN KEY (`id_client`) REFERENCES `personne` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_historique_id_evenement` FOREIGN KEY (`id_evenement`) REFERENCES `evenement` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
