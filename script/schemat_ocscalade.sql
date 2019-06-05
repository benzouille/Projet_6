--
-- PostgreSQL database dump
--

-- Dumped from database version 10.3
-- Dumped by pg_dump version 11.2

-- Started on 2019-06-01 22:23:56

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
-- TOC entry 220 (class 1259 OID 35536)
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
-- TOC entry 219 (class 1259 OID 35534)
-- Name: commentaire_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.commentaire_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.commentaire_id_seq OWNER TO postgres;

--
-- TOC entry 2927 (class 0 OID 0)
-- Dependencies: 219
-- Name: commentaire_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.commentaire_id_seq OWNED BY public.commentaire.id;


--
-- TOC entry 197 (class 1259 OID 35424)
-- Name: difficulte; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.difficulte (
    id integer NOT NULL,
    difficulte character varying(2) NOT NULL
);


ALTER TABLE public.difficulte OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 35422)
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
-- TOC entry 2928 (class 0 OID 0)
-- Dependencies: 196
-- Name: difficulte_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.difficulte_id_seq OWNED BY public.difficulte.id;


--
-- TOC entry 199 (class 1259 OID 35432)
-- Name: duree; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.duree (
    id integer NOT NULL,
    duree character varying(25) NOT NULL
);


ALTER TABLE public.duree OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 35430)
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
-- TOC entry 2929 (class 0 OID 0)
-- Dependencies: 198
-- Name: duree_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.duree_id_seq OWNED BY public.duree.id;


--
-- TOC entry 217 (class 1259 OID 35523)
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
-- TOC entry 216 (class 1259 OID 35521)
-- Name: longueur_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.longueur_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.longueur_id_seq OWNER TO postgres;

--
-- TOC entry 2930 (class 0 OID 0)
-- Dependencies: 216
-- Name: longueur_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.longueur_id_seq OWNED BY public.longueur.id;


--
-- TOC entry 203 (class 1259 OID 35451)
-- Name: privilege; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.privilege (
    id integer NOT NULL,
    privilege character varying NOT NULL
);


ALTER TABLE public.privilege OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 35449)
-- Name: privilege_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.privilege_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.privilege_id_seq OWNER TO postgres;

--
-- TOC entry 2931 (class 0 OID 0)
-- Dependencies: 202
-- Name: privilege_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.privilege_id_seq OWNED BY public.privilege.id;


--
-- TOC entry 209 (class 1259 OID 35481)
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
-- TOC entry 208 (class 1259 OID 35479)
-- Name: reservation_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.reservation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.reservation_id_seq OWNER TO postgres;

--
-- TOC entry 2932 (class 0 OID 0)
-- Dependencies: 208
-- Name: reservation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.reservation_id_seq OWNED BY public.reservation.id;


--
-- TOC entry 213 (class 1259 OID 35501)
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
-- TOC entry 212 (class 1259 OID 35499)
-- Name: secteur_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.secteur_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.secteur_id_seq OWNER TO postgres;

--
-- TOC entry 2933 (class 0 OID 0)
-- Dependencies: 212
-- Name: secteur_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.secteur_id_seq OWNED BY public.secteur.id;


--
-- TOC entry 201 (class 1259 OID 35440)
-- Name: sexe; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sexe (
    id integer NOT NULL,
    sexe character varying NOT NULL
);


ALTER TABLE public.sexe OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 35438)
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
-- TOC entry 2934 (class 0 OID 0)
-- Dependencies: 200
-- Name: sexe_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.sexe_id_seq OWNED BY public.sexe.id;


--
-- TOC entry 211 (class 1259 OID 35489)
-- Name: spot; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.spot (
    id integer NOT NULL,
    id_createur integer NOT NULL,
    officiel boolean DEFAULT false NOT NULL,
    departement character varying NOT NULL,
    adresse character varying(200) NOT NULL,
    difficulte character varying(10) NOT NULL,
    description character varying(1000) NOT NULL
);


ALTER TABLE public.spot OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 35487)
-- Name: spot_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.spot_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.spot_id_seq OWNER TO postgres;

--
-- TOC entry 2935 (class 0 OID 0)
-- Dependencies: 210
-- Name: spot_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.spot_id_seq OWNED BY public.spot.id;


--
-- TOC entry 207 (class 1259 OID 35470)
-- Name: topo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.topo (
    id integer NOT NULL,
    id_utilisateur integer NOT NULL,
    description character varying(1000) NOT NULL,
    date_creation character varying(10) NOT NULL
);


ALTER TABLE public.topo OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 35468)
-- Name: topo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.topo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.topo_id_seq OWNER TO postgres;

--
-- TOC entry 2936 (class 0 OID 0)
-- Dependencies: 206
-- Name: topo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.topo_id_seq OWNED BY public.topo.id;


--
-- TOC entry 218 (class 1259 OID 35529)
-- Name: topo_spot; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.topo_spot (
    id_spot integer NOT NULL,
    id_topo integer NOT NULL
);


ALTER TABLE public.topo_spot OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 35462)
-- Name: utilisateur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.utilisateur (
    id integer NOT NULL,
    id_sexe integer NOT NULL,
    pseudo character varying(25) NOT NULL,
    email character varying(25) NOT NULL,
    password character varying(25) NOT NULL,
    departement integer,
    date_naissance character varying(10) NOT NULL,
    id_privilege integer NOT NULL
);


ALTER TABLE public.utilisateur OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 35460)
-- Name: utilisateur_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.utilisateur_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.utilisateur_id_seq OWNER TO postgres;

--
-- TOC entry 2937 (class 0 OID 0)
-- Dependencies: 204
-- Name: utilisateur_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.utilisateur_id_seq OWNED BY public.utilisateur.id;


--
-- TOC entry 215 (class 1259 OID 35512)
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
-- TOC entry 214 (class 1259 OID 35510)
-- Name: voie_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.voie_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.voie_id_seq OWNER TO postgres;

--
-- TOC entry 2938 (class 0 OID 0)
-- Dependencies: 214
-- Name: voie_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.voie_id_seq OWNED BY public.voie.id;


--
-- TOC entry 2759 (class 2604 OID 35539)
-- Name: commentaire id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire ALTER COLUMN id SET DEFAULT nextval('public.commentaire_id_seq'::regclass);


--
-- TOC entry 2747 (class 2604 OID 35427)
-- Name: difficulte id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.difficulte ALTER COLUMN id SET DEFAULT nextval('public.difficulte_id_seq'::regclass);


--
-- TOC entry 2748 (class 2604 OID 35435)
-- Name: duree id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.duree ALTER COLUMN id SET DEFAULT nextval('public.duree_id_seq'::regclass);


--
-- TOC entry 2758 (class 2604 OID 35526)
-- Name: longueur id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.longueur ALTER COLUMN id SET DEFAULT nextval('public.longueur_id_seq'::regclass);


--
-- TOC entry 2750 (class 2604 OID 35454)
-- Name: privilege id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.privilege ALTER COLUMN id SET DEFAULT nextval('public.privilege_id_seq'::regclass);


--
-- TOC entry 2753 (class 2604 OID 35484)
-- Name: reservation id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation ALTER COLUMN id SET DEFAULT nextval('public.reservation_id_seq'::regclass);


--
-- TOC entry 2756 (class 2604 OID 35504)
-- Name: secteur id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secteur ALTER COLUMN id SET DEFAULT nextval('public.secteur_id_seq'::regclass);


--
-- TOC entry 2749 (class 2604 OID 35443)
-- Name: sexe id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sexe ALTER COLUMN id SET DEFAULT nextval('public.sexe_id_seq'::regclass);


--
-- TOC entry 2754 (class 2604 OID 35492)
-- Name: spot id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.spot ALTER COLUMN id SET DEFAULT nextval('public.spot_id_seq'::regclass);


--
-- TOC entry 2752 (class 2604 OID 35473)
-- Name: topo id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo ALTER COLUMN id SET DEFAULT nextval('public.topo_id_seq'::regclass);


--
-- TOC entry 2751 (class 2604 OID 35465)
-- Name: utilisateur id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur ALTER COLUMN id SET DEFAULT nextval('public.utilisateur_id_seq'::regclass);


--
-- TOC entry 2757 (class 2604 OID 35515)
-- Name: voie id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie ALTER COLUMN id SET DEFAULT nextval('public.voie_id_seq'::regclass);


--
-- TOC entry 2785 (class 2606 OID 35544)
-- Name: commentaire commentaire_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT commentaire_pk PRIMARY KEY (id, id_user, id_spot);


--
-- TOC entry 2761 (class 2606 OID 35429)
-- Name: difficulte difficulte_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.difficulte
    ADD CONSTRAINT difficulte_pk PRIMARY KEY (id);


--
-- TOC entry 2763 (class 2606 OID 35437)
-- Name: duree duree_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.duree
    ADD CONSTRAINT duree_pk PRIMARY KEY (id);


--
-- TOC entry 2781 (class 2606 OID 35528)
-- Name: longueur longueur_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.longueur
    ADD CONSTRAINT longueur_pk PRIMARY KEY (id);


--
-- TOC entry 2767 (class 2606 OID 35459)
-- Name: privilege privilege_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.privilege
    ADD CONSTRAINT privilege_pk PRIMARY KEY (id);


--
-- TOC entry 2773 (class 2606 OID 35486)
-- Name: reservation reservation_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_pk PRIMARY KEY (id, id_topo, id_utilisateur_locataire);


--
-- TOC entry 2777 (class 2606 OID 35509)
-- Name: secteur secteur_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secteur
    ADD CONSTRAINT secteur_pk PRIMARY KEY (id);


--
-- TOC entry 2765 (class 2606 OID 35448)
-- Name: sexe sexe_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sexe
    ADD CONSTRAINT sexe_pk PRIMARY KEY (id);


--
-- TOC entry 2775 (class 2606 OID 35498)
-- Name: spot spot_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.spot
    ADD CONSTRAINT spot_pk PRIMARY KEY (id);


--
-- TOC entry 2771 (class 2606 OID 35478)
-- Name: topo topo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT topo_pk PRIMARY KEY (id);


--
-- TOC entry 2783 (class 2606 OID 35533)
-- Name: topo_spot topo_spot_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo_spot
    ADD CONSTRAINT topo_spot_pk PRIMARY KEY (id_spot, id_topo);


--
-- TOC entry 2769 (class 2606 OID 35467)
-- Name: utilisateur utilisateur_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT utilisateur_pk PRIMARY KEY (id);


--
-- TOC entry 2779 (class 2606 OID 35520)
-- Name: voie voie_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie
    ADD CONSTRAINT voie_pk PRIMARY KEY (id);


--
-- TOC entry 2794 (class 2606 OID 35545)
-- Name: voie difficulte_voie_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie
    ADD CONSTRAINT difficulte_voie_fk FOREIGN KEY (id_difficulte) REFERENCES public.difficulte(id);


--
-- TOC entry 2789 (class 2606 OID 35550)
-- Name: reservation duree_reservation_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT duree_reservation_fk FOREIGN KEY (id_duree) REFERENCES public.duree(id);


--
-- TOC entry 2787 (class 2606 OID 35560)
-- Name: utilisateur privilege_user_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT privilege_user_fk FOREIGN KEY (id_privilege) REFERENCES public.privilege(id);


--
-- TOC entry 2795 (class 2606 OID 35610)
-- Name: voie secteur_voie_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie
    ADD CONSTRAINT secteur_voie_fk FOREIGN KEY (id_secteur) REFERENCES public.secteur(id);


--
-- TOC entry 2786 (class 2606 OID 35555)
-- Name: utilisateur sexe_user_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT sexe_user_fk FOREIGN KEY (id_sexe) REFERENCES public.sexe(id);


--
-- TOC entry 2800 (class 2606 OID 35595)
-- Name: commentaire spot_commentaire_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT spot_commentaire_fk FOREIGN KEY (id_spot) REFERENCES public.spot(id);


--
-- TOC entry 2793 (class 2606 OID 35605)
-- Name: secteur spot_secteur_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secteur
    ADD CONSTRAINT spot_secteur_fk FOREIGN KEY (id_spot) REFERENCES public.spot(id);


--
-- TOC entry 2798 (class 2606 OID 35600)
-- Name: topo_spot spot_topo_spot_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo_spot
    ADD CONSTRAINT spot_topo_spot_fk FOREIGN KEY (id_spot) REFERENCES public.spot(id);


--
-- TOC entry 2791 (class 2606 OID 35590)
-- Name: reservation topo_reservation_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT topo_reservation_fk FOREIGN KEY (id_topo) REFERENCES public.topo(id);


--
-- TOC entry 2797 (class 2606 OID 35585)
-- Name: topo_spot topo_topo_spot_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo_spot
    ADD CONSTRAINT topo_topo_spot_fk FOREIGN KEY (id_topo) REFERENCES public.topo(id);


--
-- TOC entry 2799 (class 2606 OID 35565)
-- Name: commentaire user_commentaire_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT user_commentaire_fk FOREIGN KEY (id_user) REFERENCES public.utilisateur(id);


--
-- TOC entry 2790 (class 2606 OID 35580)
-- Name: reservation user_reservation_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT user_reservation_fk FOREIGN KEY (id_utilisateur_locataire) REFERENCES public.utilisateur(id);


--
-- TOC entry 2792 (class 2606 OID 35570)
-- Name: spot user_spot_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.spot
    ADD CONSTRAINT user_spot_fk FOREIGN KEY (id_createur) REFERENCES public.utilisateur(id);


--
-- TOC entry 2788 (class 2606 OID 35575)
-- Name: topo user_topo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT user_topo_fk FOREIGN KEY (id_utilisateur) REFERENCES public.utilisateur(id);


--
-- TOC entry 2796 (class 2606 OID 35615)
-- Name: longueur voie_longueur_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.longueur
    ADD CONSTRAINT voie_longueur_fk FOREIGN KEY (id_voie) REFERENCES public.voie(id);


-- Completed on 2019-06-01 22:23:56

--
-- PostgreSQL database dump complete
--

