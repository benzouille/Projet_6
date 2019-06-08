--
-- PostgreSQL database dump
--

-- Dumped from database version 10.3
-- Dumped by pg_dump version 11.2

-- Started on 2019-06-08 15:09:38

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
-- TOC entry 2912 (class 0 OID 43623)
-- Dependencies: 197
-- Data for Name: departement; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.departement (id, num, nom) FROM stdin;
1	01	Ain
2	02	Aisne
3	03	Allier
4	05	Hautes Alpes
5	04	Alpes de Haute Provence
6	06	Alpes Maritimes
7	07	Ardèche
8	08	Ardennes
9	09	Ariège
10	10	Aube
11	11	Aude
12	12	Aveyron
13	13	Bouches du Rhône
14	14	Calvados
15	15	Cantal
16	16	Charente
17	17	Charente Maritime
18	18	Cher
19	19	Corrèze
20	2A	Corse du sud
21	2B	Haute corse
22	21	Côte d'Or
23	22	Côtes d'armor
24	23	Creuse
25	24	Dordogne
26	25	Doubs
27	26	Drôme
28	27	Eure
29	28	Eure-et-Loir
30	29	Finistère
31	30	Gard
32	31	Haute-Garonne
33	32	Gers
34	33	Gironde
35	34	Hérault
36	35	Ile et Vilaine
37	36	Indre
38	37	Indre et Loire
39	38	Isère
40	39	Jura
41	40	Landes
42	41	Loir et Cher
43	42	Loire
44	43	Haute Loire
45	44	Loire Atlantique
46	45	Loiret
47	46	Lot
48	47	Lot et Garonne
49	48	Lozère
50	49	Maine et Loire
51	50	Manche
52	51	Marne
53	52	Haute Marne
54	53	Mayenne
55	54	Meurthe et Moselle
56	55	Meuse
57	56	Morbihan
58	57	Moselle
59	58	Nièvre
60	59	Nord
61	60	Oise
62	61	Orne
63	62	Pas de Calais
64	63	Puy de Dôme
65	64	Pyrénées Atlantiques
66	65	Hautes Pyrénées
67	66	Pyrénées Orientales
68	67	Bas Rhin
69	68	Haut Rhin
70	69	Rhône
71	70	Haute Saône
72	71	Saône et Loire
73	72	Sarthe
74	73	Savoie
75	74	Haute Savoie
76	75	Paris
77	76	Seine Maritime
78	77	Seine et Marne
79	78	Yvelines
80	79	Deux Sèvres
81	80	Somme
82	81	Tarn
83	82	Tarn et Garonne
84	83	Var
85	84	Vaucluse
86	85	Vendée
87	86	Vienne
88	87	Haute Vienne
89	88	Vosges
90	89	Yonne
91	90	Territoire de Belfort
92	91	Essonne
93	92	Hauts de Seine
94	93	Seine Saint Denis
95	94	Val de Marne
96	95	Val d'oise
97	976	Mayotte
98	971	Guadeloupe
99	973	Guyane
100	972	Martinique
101	974	Réunion
\.


--
-- TOC entry 2919 (class 0 OID 43659)
-- Dependencies: 204
-- Data for Name: privilege; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.privilege (id, privilege) FROM stdin;
1	utilisateur
2	modérateur
3	administrateur
\.


--
-- TOC entry 2918 (class 0 OID 43650)
-- Dependencies: 203
-- Data for Name: sexe; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sexe (id, sexe) FROM stdin;
1	homme
2	femme
3	non renseigné
\.


--
-- TOC entry 2920 (class 0 OID 43667)
-- Dependencies: 205
-- Data for Name: utilisateur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.utilisateur (id, id_sexe, pseudo, email, password, id_departement, date_naissance, id_privilege) FROM stdin;
\.


--
-- TOC entry 2921 (class 0 OID 43672)
-- Dependencies: 206
-- Data for Name: spot; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.spot (id, id_createur, nom, officiel, id_departement, adresse, description) FROM stdin;
\.


--
-- TOC entry 2929 (class 0 OID 43726)
-- Dependencies: 214
-- Data for Name: commentaire; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.commentaire (id, id_user, id_spot, commentaire) FROM stdin;
\.


--
-- TOC entry 2914 (class 0 OID 43634)
-- Dependencies: 199
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
-- TOC entry 2916 (class 0 OID 43642)
-- Dependencies: 201
-- Data for Name: duree; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.duree (id, duree) FROM stdin;
1	matin
2	après-midi
3	journée
\.


--
-- TOC entry 2925 (class 0 OID 43696)
-- Dependencies: 210
-- Data for Name: image; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.image (id, id_spot, titre) FROM stdin;
\.


--
-- TOC entry 2926 (class 0 OID 43705)
-- Dependencies: 211
-- Data for Name: secteur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.secteur (id, id_spot, nom, description) FROM stdin;
\.


--
-- TOC entry 2927 (class 0 OID 43713)
-- Dependencies: 212
-- Data for Name: voie; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.voie (id, nom, id_secteur, id_difficulte, description) FROM stdin;
\.


--
-- TOC entry 2928 (class 0 OID 43721)
-- Dependencies: 213
-- Data for Name: longueur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.longueur (id, id_voie, equipement, nb_point) FROM stdin;
\.


--
-- TOC entry 2922 (class 0 OID 43681)
-- Dependencies: 207
-- Data for Name: topo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.topo (id, id_utilisateur, description, date_creation, id_spot) FROM stdin;
\.


--
-- TOC entry 2923 (class 0 OID 43689)
-- Dependencies: 208
-- Data for Name: reservation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.reservation (id, id_topo, id_utilisateur_locataire, date, id_duree) FROM stdin;
\.


--
-- TOC entry 2935 (class 0 OID 0)
-- Dependencies: 196
-- Name: departement_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.departement_id_seq', 101, true);


--
-- TOC entry 2936 (class 0 OID 0)
-- Dependencies: 198
-- Name: difficulte_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.difficulte_id_seq', 1, false);


--
-- TOC entry 2937 (class 0 OID 0)
-- Dependencies: 200
-- Name: duree_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.duree_id_seq', 3, true);


--
-- TOC entry 2938 (class 0 OID 0)
-- Dependencies: 209
-- Name: image_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.image_id_seq', 1, false);


--
-- TOC entry 2939 (class 0 OID 0)
-- Dependencies: 202
-- Name: sexe_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sexe_id_seq', 1, false);


-- Completed on 2019-06-08 15:09:39

--
-- PostgreSQL database dump complete
--

