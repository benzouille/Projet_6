--
-- PostgreSQL database dump
--

-- Dumped from database version 10.3
-- Dumped by pg_dump version 11.2

-- Started on 2019-06-01 22:24:53

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2929 (class 0 OID 35451)
-- Dependencies: 203
-- Data for Name: privilege; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.privilege (id, privilege) FROM stdin;
1	utilisateur
2	moderateur
3	admin
\.


--
-- TOC entry 2927 (class 0 OID 35440)
-- Dependencies: 201
-- Data for Name: sexe; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sexe (id, sexe) FROM stdin;
1	non désigné
2	homme
3	femme
\.


--
-- TOC entry 2931 (class 0 OID 35462)
-- Dependencies: 205
-- Data for Name: utilisateur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.utilisateur (id, id_sexe, pseudo, email, password, departement, date_naissance, id_privilege) FROM stdin;
\.


--
-- TOC entry 2937 (class 0 OID 35489)
-- Dependencies: 211
-- Data for Name: spot; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.spot (id, id_createur, officiel, departement, adresse, difficulte, description) FROM stdin;
\.


--
-- TOC entry 2946 (class 0 OID 35536)
-- Dependencies: 220
-- Data for Name: commentaire; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.commentaire (id, id_user, id_spot, commentaire) FROM stdin;
\.


--
-- TOC entry 2923 (class 0 OID 35424)
-- Dependencies: 197
-- Data for Name: difficulte; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.difficulte (id, difficulte) FROM stdin;
1	3a
2	3b
3	3c
4	4a
5	4b
6	4c
7	5a
8	5b
9	5c
10	6a
11	6b
12	6c
13	7a
14	7b
15	7c
16	8a
17	8b
18	8c
19	9a
20	9b
21	9c
\.


--
-- TOC entry 2925 (class 0 OID 35432)
-- Dependencies: 199
-- Data for Name: duree; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.duree (id, duree) FROM stdin;
1	matin
2	après-midi
3	journée
\.


--
-- TOC entry 2939 (class 0 OID 35501)
-- Dependencies: 213
-- Data for Name: secteur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.secteur (id, id_spot, nom, description) FROM stdin;
\.


--
-- TOC entry 2941 (class 0 OID 35512)
-- Dependencies: 215
-- Data for Name: voie; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.voie (id, nom, id_secteur, id_difficulte, description) FROM stdin;
\.


--
-- TOC entry 2943 (class 0 OID 35523)
-- Dependencies: 217
-- Data for Name: longueur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.longueur (id, id_voie, equipement, nb_point) FROM stdin;
\.


--
-- TOC entry 2933 (class 0 OID 35470)
-- Dependencies: 207
-- Data for Name: topo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.topo (id, id_utilisateur, description, date_creation) FROM stdin;
\.


--
-- TOC entry 2935 (class 0 OID 35481)
-- Dependencies: 209
-- Data for Name: reservation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.reservation (id, id_topo, id_utilisateur_locataire, date, id_duree) FROM stdin;
\.


--
-- TOC entry 2944 (class 0 OID 35529)
-- Dependencies: 218
-- Data for Name: topo_spot; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.topo_spot (id_spot, id_topo) FROM stdin;
\.


--
-- TOC entry 2952 (class 0 OID 0)
-- Dependencies: 219
-- Name: commentaire_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.commentaire_id_seq', 1, false);


--
-- TOC entry 2953 (class 0 OID 0)
-- Dependencies: 196
-- Name: difficulte_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.difficulte_id_seq', 21, true);


--
-- TOC entry 2954 (class 0 OID 0)
-- Dependencies: 198
-- Name: duree_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.duree_id_seq', 3, true);


--
-- TOC entry 2955 (class 0 OID 0)
-- Dependencies: 216
-- Name: longueur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.longueur_id_seq', 1, false);


--
-- TOC entry 2956 (class 0 OID 0)
-- Dependencies: 202
-- Name: privilege_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.privilege_id_seq', 3, true);


--
-- TOC entry 2957 (class 0 OID 0)
-- Dependencies: 208
-- Name: reservation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.reservation_id_seq', 1, false);


--
-- TOC entry 2958 (class 0 OID 0)
-- Dependencies: 212
-- Name: secteur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.secteur_id_seq', 1, false);


--
-- TOC entry 2959 (class 0 OID 0)
-- Dependencies: 200
-- Name: sexe_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sexe_id_seq', 3, true);


--
-- TOC entry 2960 (class 0 OID 0)
-- Dependencies: 210
-- Name: spot_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.spot_id_seq', 1, false);


--
-- TOC entry 2961 (class 0 OID 0)
-- Dependencies: 206
-- Name: topo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.topo_id_seq', 1, false);


--
-- TOC entry 2962 (class 0 OID 0)
-- Dependencies: 204
-- Name: utilisateur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.utilisateur_id_seq', 1, false);


--
-- TOC entry 2963 (class 0 OID 0)
-- Dependencies: 214
-- Name: voie_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.voie_id_seq', 1, false);


-- Completed on 2019-06-01 22:24:53

--
-- PostgreSQL database dump complete
--

