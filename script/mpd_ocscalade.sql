
CREATE SEQUENCE public.departement_id_seq;

CREATE TABLE public.departement (
                id INTEGER NOT NULL DEFAULT nextval('public.departement_id_seq'),
                num VARCHAR NOT NULL,
                nom VARCHAR NOT NULL,
                CONSTRAINT departement_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.departement_id_seq OWNED BY public.departement.id;

CREATE SEQUENCE public.difficulte_id_seq;

CREATE TABLE public.difficulte (
                id INTEGER NOT NULL DEFAULT nextval('public.difficulte_id_seq'),
                difficulte VARCHAR(2) NOT NULL,
                CONSTRAINT difficulte_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.difficulte_id_seq OWNED BY public.difficulte.id;

CREATE SEQUENCE public.sexe_id_seq;

CREATE TABLE public.sexe (
                id INTEGER NOT NULL DEFAULT nextval('public.sexe_id_seq'),
                sexe VARCHAR NOT NULL,
                CONSTRAINT sexe_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.sexe_id_seq OWNED BY public.sexe.id;

CREATE SEQUENCE public.privilege_id_seq;

CREATE TABLE public.privilege (
                id INTEGER NOT NULL DEFAULT nextval('public.privilege_id_seq'),
                privilege VARCHAR NOT NULL,
                CONSTRAINT privilege_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.privilege_id_seq OWNED BY public.privilege.id;

CREATE SEQUENCE public.utilisateur_id_seq;

CREATE TABLE public.utilisateur (
                id INTEGER NOT NULL DEFAULT nextval('public.utilisateur_id_seq'),
                id_sexe INTEGER,
                pseudo VARCHAR(25) NOT NULL,
                email VARCHAR(25) NOT NULL,
                password VARCHAR(25) NOT NULL,
                id_departement INTEGER,
                date_naissance VARCHAR(10),
                id_privilege INTEGER NOT NULL,
                CONSTRAINT utilisateur_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.utilisateur_id_seq OWNED BY public.utilisateur.id;

CREATE SEQUENCE public.spot_id_seq;

CREATE TABLE public.spot (
                id INTEGER NOT NULL DEFAULT nextval('public.spot_id_seq'),
                id_createur INTEGER NOT NULL,
                nom VARCHAR(25) NOT NULL,
                officiel BOOLEAN DEFAULT false NOT NULL,
                id_departement INTEGER NOT NULL,
                adresse VARCHAR(200) NOT NULL,
                description VARCHAR(1000) NOT NULL,
                CONSTRAINT spot_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.spot_id_seq OWNED BY public.spot.id;

CREATE SEQUENCE public.topo_id_seq;

CREATE TABLE public.topo (
                id INTEGER NOT NULL DEFAULT nextval('public.topo_id_seq'),
                id_utilisateur INTEGER NOT NULL,
                description VARCHAR(1000) NOT NULL,
                date_creation VARCHAR(10) NOT NULL,
                id_spot INTEGER NOT NULL,
                CONSTRAINT topo_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.topo_id_seq OWNED BY public.topo.id;

CREATE SEQUENCE public.reservation_id_seq;

CREATE TABLE public.reservation (
                id INTEGER NOT NULL DEFAULT nextval('public.reservation_id_seq'),
                id_topo INTEGER NOT NULL,
                id_utilisateur_locataire INTEGER NOT NULL,
                date_debut DATE NOT NULL,
                date_fin DATE NOT NULL,
                CONSTRAINT reservation_pk PRIMARY KEY (id, id_topo, id_utilisateur_locataire)
);


ALTER SEQUENCE public.reservation_id_seq OWNED BY public.reservation.id;

CREATE SEQUENCE public.image_id_seq;

CREATE TABLE public.image (
                id INTEGER NOT NULL DEFAULT nextval('public.image_id_seq'),
                id_spot INTEGER NOT NULL,
                titre VARCHAR NOT NULL,
                path VARCHAR NOT NULL,
                CONSTRAINT image_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.image_id_seq OWNED BY public.image.id;

CREATE SEQUENCE public.secteur_id_seq;

CREATE TABLE public.secteur (
                id INTEGER NOT NULL DEFAULT nextval('public.secteur_id_seq'),
                id_spot INTEGER NOT NULL,
                nom VARCHAR(25) NOT NULL,
                description VARCHAR(1000) NOT NULL,
                CONSTRAINT secteur_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.secteur_id_seq OWNED BY public.secteur.id;

CREATE SEQUENCE public.voie_id_seq;

CREATE TABLE public.voie (
                id INTEGER NOT NULL DEFAULT nextval('public.voie_id_seq'),
                nom VARCHAR(25) NOT NULL,
                id_secteur INTEGER NOT NULL,
                id_difficulte INTEGER NOT NULL,
                nb_longueur INTEGER NOT NULL,
                equipement BOOLEAN NOT NULL,
                nb_point INTEGER,
                description VARCHAR(1000) NOT NULL,
                CONSTRAINT voie_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.voie_id_seq OWNED BY public.voie.id;

CREATE SEQUENCE public.commentaire_id_seq;

CREATE TABLE public.commentaire (
                id INTEGER NOT NULL DEFAULT nextval('public.commentaire_id_seq'),
                id_user INTEGER NOT NULL,
                id_spot INTEGER NOT NULL,
                commentaire VARCHAR(1000) NOT NULL,
                CONSTRAINT commentaire_pk PRIMARY KEY (id, id_user, id_spot)
);


ALTER SEQUENCE public.commentaire_id_seq OWNED BY public.commentaire.id;

ALTER TABLE public.spot ADD CONSTRAINT departement_spot_fk
FOREIGN KEY (id_departement)
REFERENCES public.departement (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.utilisateur ADD CONSTRAINT departement_utilisateur_fk
FOREIGN KEY (id_departement)
REFERENCES public.departement (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.voie ADD CONSTRAINT difficulte_voie_fk
FOREIGN KEY (id_difficulte)
REFERENCES public.difficulte (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.utilisateur ADD CONSTRAINT sexe_user_fk
FOREIGN KEY (id_sexe)
REFERENCES public.sexe (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.utilisateur ADD CONSTRAINT privilege_user_fk
FOREIGN KEY (id_privilege)
REFERENCES public.privilege (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.commentaire ADD CONSTRAINT user_commentaire_fk
FOREIGN KEY (id_user)
REFERENCES public.utilisateur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.spot ADD CONSTRAINT user_spot_fk
FOREIGN KEY (id_createur)
REFERENCES public.utilisateur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.topo ADD CONSTRAINT user_topo_fk
FOREIGN KEY (id_utilisateur)
REFERENCES public.utilisateur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.reservation ADD CONSTRAINT user_reservation_fk
FOREIGN KEY (id_utilisateur_locataire)
REFERENCES public.utilisateur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.commentaire ADD CONSTRAINT spot_commentaire_fk
FOREIGN KEY (id_spot)
REFERENCES public.spot (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.secteur ADD CONSTRAINT spot_secteur_fk
FOREIGN KEY (id_spot)
REFERENCES public.spot (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.image ADD CONSTRAINT spot_image_fk
FOREIGN KEY (id_spot)
REFERENCES public.spot (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.topo ADD CONSTRAINT spot_topo_fk
FOREIGN KEY (id_spot)
REFERENCES public.spot (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.reservation ADD CONSTRAINT topo_reservation_fk
FOREIGN KEY (id_topo)
REFERENCES public.topo (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.voie ADD CONSTRAINT secteur_voie_fk
FOREIGN KEY (id_secteur)
REFERENCES public.secteur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;