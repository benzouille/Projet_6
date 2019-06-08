--
-- PostgreSQL database dump
--

-- Dumped from database version 10.3
-- Dumped by pg_dump version 11.2

-- Started on 2019-06-08 15:08:50

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 214 (class 1259 OID 43726)
-- Name: commentaire; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.commentaire (
    id integer NOT NULL,
    id_user integer NOT NULL,
    id_spot integer NOT NULL,
    commentaire character varying(1000) NOT NULL
);


ALTER TABLE public.commentaire OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 43623)
-- Name: departement; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.departement (
    id integer NOT NULL,
    num character varying NOT NULL,
    nom character varying NOT NULL
);


ALTER TABLE public.departement OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 43621)
-- Name: departement_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.departement_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.departement_id_seq OWNER TO postgres;

--
-- TOC entry 2916 (class 0 OID 0)
-- Dependencies: 196
-- Name: departement_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.departement_id_seq OWNED BY public.departement.id;


--
-- TOC entry 199 (class 1259 OID 43634)
-- Name: difficulte; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.difficulte (
    id integer NOT NULL,
    difficulte character varying(2) NOT NULL
);


ALTER TABLE public.difficulte OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 43632)
-- Name: difficulte_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.difficulte_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.difficulte_id_seq OWNER TO postgres;

--
-- TOC entry 2917 (class 0 OID 0)
-- Dependencies: 198
-- Name: difficulte_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.difficulte_id_seq OWNED BY public.difficulte.id;


--
-- TOC entry 201 (class 1259 OID 43642)
-- Name: duree; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.duree (
    id integer NOT NULL,
    duree character varying(25) NOT NULL
);


ALTER TABLE public.duree OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 43640)
-- Name: duree_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.duree_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.duree_id_seq OWNER TO postgres;

--
-- TOC entry 2918 (class 0 OID 0)
-- Dependencies: 200
-- Name: duree_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.duree_id_seq OWNED BY public.duree.id;


--
-- TOC entry 210 (class 1259 OID 43696)
-- Name: image; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.image (
    id integer NOT NULL,
    id_spot integer NOT NULL,
    titre character varying NOT NULL
);


ALTER TABLE public.image OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 43694)
-- Name: image_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.image_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.image_id_seq OWNER TO postgres;

--
-- TOC entry 2919 (class 0 OID 0)
-- Dependencies: 209
-- Name: image_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.image_id_seq OWNED BY public.image.id;


--
-- TOC entry 213 (class 1259 OID 43721)
-- Name: longueur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.longueur (
    id integer NOT NULL,
    id_voie integer NOT NULL,
    equipement boolean NOT NULL,
    nb_point integer
);


ALTER TABLE public.longueur OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 43659)
-- Name: privilege; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.privilege (
    id integer NOT NULL,
    privilege character varying NOT NULL
);


ALTER TABLE public.privilege OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 43689)
-- Name: reservation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reservation (
    id integer NOT NULL,
    id_topo integer NOT NULL,
    id_utilisateur_locataire integer NOT NULL,
    date date NOT NULL,
    id_duree integer NOT NULL
);


ALTER TABLE public.reservation OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 43705)
-- Name: secteur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.secteur (
    id integer NOT NULL,
    id_spot integer NOT NULL,
    nom character varying(25) NOT NULL,
    description character varying(1000) NOT NULL
);


ALTER TABLE public.secteur OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 43650)
-- Name: sexe; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sexe (
    id integer NOT NULL,
    sexe character varying NOT NULL
);


ALTER TABLE public.sexe OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 43648)
-- Name: sexe_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sexe_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sexe_id_seq OWNER TO postgres;

--
-- TOC entry 2920 (class 0 OID 0)
-- Dependencies: 202
-- Name: sexe_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.sexe_id_seq OWNED BY public.sexe.id;


--
-- TOC entry 206 (class 1259 OID 43672)
-- Name: spot; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.spot (
    id integer NOT NULL,
    id_createur integer NOT NULL,
    nom character varying(25) NOT NULL,
    officiel boolean DEFAULT false NOT NULL,
    id_departement integer NOT NULL,
    adresse character varying(200) NOT NULL,
    description character varying(1000) NOT NULL
);


ALTER TABLE public.spot OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 43681)
-- Name: topo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.topo (
    id integer NOT NULL,
    id_utilisateur integer NOT NULL,
    description character varying(1000) NOT NULL,
    date_creation character varying(10) NOT NULL,
    id_spot integer NOT NULL
);


ALTER TABLE public.topo OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 43667)
-- Name: utilisateur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.utilisateur (
    id integer NOT NULL,
    id_sexe integer NOT NULL,
    pseudo character varying(25) NOT NULL,
    email character varying(25) NOT NULL,
    password character varying(25) NOT NULL,
    id_departement integer,
    date_naissance character varying(10) NOT NULL,
    id_privilege integer NOT NULL
);


ALTER TABLE public.utilisateur OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 43713)
-- Name: voie; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.voie (
    id integer NOT NULL,
    nom character varying(25) NOT NULL,
    id_secteur integer NOT NULL,
    id_difficulte integer NOT NULL,
    description character varying(1000) NOT NULL
);


ALTER TABLE public.voie OWNER TO postgres;

--
-- TOC entry 2739 (class 2604 OID 43626)
-- Name: departement id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.departement ALTER COLUMN id SET DEFAULT nextval('public.departement_id_seq'::regclass);


--
-- TOC entry 2740 (class 2604 OID 43637)
-- Name: difficulte id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.difficulte ALTER COLUMN id SET DEFAULT nextval('public.difficulte_id_seq'::regclass);


--
-- TOC entry 2741 (class 2604 OID 43645)
-- Name: duree id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.duree ALTER COLUMN id SET DEFAULT nextval('public.duree_id_seq'::regclass);


--
-- TOC entry 2744 (class 2604 OID 43699)
-- Name: image id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image ALTER COLUMN id SET DEFAULT nextval('public.image_id_seq'::regclass);


--
-- TOC entry 2742 (class 2604 OID 43653)
-- Name: sexe id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sexe ALTER COLUMN id SET DEFAULT nextval('public.sexe_id_seq'::regclass);


--
-- TOC entry 2772 (class 2606 OID 43733)
-- Name: commentaire commentaire_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT commentaire_pk PRIMARY KEY (id, id_user, id_spot);


--
-- TOC entry 2746 (class 2606 OID 43631)
-- Name: departement departement_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.departement
    ADD CONSTRAINT departement_pk PRIMARY KEY (id);


--
-- TOC entry 2748 (class 2606 OID 43639)
-- Name: difficulte difficulte_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.difficulte
    ADD CONSTRAINT difficulte_pk PRIMARY KEY (id);


--
-- TOC entry 2750 (class 2606 OID 43647)
-- Name: duree duree_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.duree
    ADD CONSTRAINT duree_pk PRIMARY KEY (id);


--
-- TOC entry 2764 (class 2606 OID 43704)
-- Name: image image_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image
    ADD CONSTRAINT image_pk PRIMARY KEY (id);


--
-- TOC entry 2770 (class 2606 OID 43725)
-- Name: longueur longueur_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.longueur
    ADD CONSTRAINT longueur_pk PRIMARY KEY (id);


--
-- TOC entry 2754 (class 2606 OID 43666)
-- Name: privilege privilege_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.privilege
    ADD CONSTRAINT privilege_pk PRIMARY KEY (id);


--
-- TOC entry 2762 (class 2606 OID 43693)
-- Name: reservation reservation_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_pk PRIMARY KEY (id, id_topo, id_utilisateur_locataire);


--
-- TOC entry 2766 (class 2606 OID 43712)
-- Name: secteur secteur_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secteur
    ADD CONSTRAINT secteur_pk PRIMARY KEY (id);


--
-- TOC entry 2752 (class 2606 OID 43658)
-- Name: sexe sexe_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sexe
    ADD CONSTRAINT sexe_pk PRIMARY KEY (id);


--
-- TOC entry 2758 (class 2606 OID 43680)
-- Name: spot spot_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.spot
    ADD CONSTRAINT spot_pk PRIMARY KEY (id);


--
-- TOC entry 2760 (class 2606 OID 43688)
-- Name: topo topo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT topo_pk PRIMARY KEY (id);


--
-- TOC entry 2756 (class 2606 OID 43671)
-- Name: utilisateur utilisateur_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT utilisateur_pk PRIMARY KEY (id);


--
-- TOC entry 2768 (class 2606 OID 43720)
-- Name: voie voie_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie
    ADD CONSTRAINT voie_pk PRIMARY KEY (id);


--
-- TOC entry 2776 (class 2606 OID 43734)
-- Name: spot departement_spot_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.spot
    ADD CONSTRAINT departement_spot_fk FOREIGN KEY (id_departement) REFERENCES public.departement(id);


--
-- TOC entry 2773 (class 2606 OID 43739)
-- Name: utilisateur departement_utilisateur_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT departement_utilisateur_fk FOREIGN KEY (id_departement) REFERENCES public.departement(id);


--
-- TOC entry 2785 (class 2606 OID 43744)
-- Name: voie difficulte_voie_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie
    ADD CONSTRAINT difficulte_voie_fk FOREIGN KEY (id_difficulte) REFERENCES public.difficulte(id);


--
-- TOC entry 2780 (class 2606 OID 43749)
-- Name: reservation duree_reservation_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT duree_reservation_fk FOREIGN KEY (id_duree) REFERENCES public.duree(id);


--
-- TOC entry 2775 (class 2606 OID 43759)
-- Name: utilisateur privilege_user_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT privilege_user_fk FOREIGN KEY (id_privilege) REFERENCES public.privilege(id);


--
-- TOC entry 2786 (class 2606 OID 43809)
-- Name: voie secteur_voie_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie
    ADD CONSTRAINT secteur_voie_fk FOREIGN KEY (id_secteur) REFERENCES public.secteur(id);


--
-- TOC entry 2774 (class 2606 OID 43754)
-- Name: utilisateur sexe_user_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT sexe_user_fk FOREIGN KEY (id_sexe) REFERENCES public.sexe(id);


--
-- TOC entry 2789 (class 2606 OID 43784)
-- Name: commentaire spot_commentaire_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT spot_commentaire_fk FOREIGN KEY (id_spot) REFERENCES public.spot(id);


--
-- TOC entry 2783 (class 2606 OID 43794)
-- Name: image spot_image_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image
    ADD CONSTRAINT spot_image_fk FOREIGN KEY (id_spot) REFERENCES public.spot(id);


--
-- TOC entry 2784 (class 2606 OID 43789)
-- Name: secteur spot_secteur_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secteur
    ADD CONSTRAINT spot_secteur_fk FOREIGN KEY (id_spot) REFERENCES public.spot(id);


--
-- TOC entry 2779 (class 2606 OID 43799)
-- Name: topo spot_topo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT spot_topo_fk FOREIGN KEY (id_spot) REFERENCES public.spot(id);


--
-- TOC entry 2782 (class 2606 OID 43804)
-- Name: reservation topo_reservation_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT topo_reservation_fk FOREIGN KEY (id_topo) REFERENCES public.topo(id);


--
-- TOC entry 2788 (class 2606 OID 43764)
-- Name: commentaire user_commentaire_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT user_commentaire_fk FOREIGN KEY (id_user) REFERENCES public.utilisateur(id);


--
-- TOC entry 2781 (class 2606 OID 43779)
-- Name: reservation user_reservation_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT user_reservation_fk FOREIGN KEY (id_utilisateur_locataire) REFERENCES public.utilisateur(id);


--
-- TOC entry 2777 (class 2606 OID 43769)
-- Name: spot user_spot_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.spot
    ADD CONSTRAINT user_spot_fk FOREIGN KEY (id_createur) REFERENCES public.utilisateur(id);


--
-- TOC entry 2778 (class 2606 OID 43774)
-- Name: topo user_topo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT user_topo_fk FOREIGN KEY (id_utilisateur) REFERENCES public.utilisateur(id);


--
-- TOC entry 2787 (class 2606 OID 43814)
-- Name: longueur voie_longueur_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.longueur
    ADD CONSTRAINT voie_longueur_fk FOREIGN KEY (id_voie) REFERENCES public.voie(id);


-- Completed on 2019-06-08 15:08:50

--
-- PostgreSQL database dump complete
--

