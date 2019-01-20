CREATE DATABASE "CabinetRugina" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';


ALTER DATABASE "CabinetRugina" OWNER TO admin;

\connect "CabinetRugina"

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
-- TOC entry 2867 (class 0 OID 0)
-- Dependencies: 2866
-- Name: DATABASE "CabinetRugina"; Type: COMMENT; Schema: -; Owner: admin
--

COMMENT ON DATABASE "CabinetRugina" IS 'Baza de date cabinet Rugina Cosmin';


--
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2870 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 201 (class 1259 OID 16467)
-- Name: antecedente; Type: TABLE; Schema: public; Owner: admin_rugina
--

CREATE TABLE public.antecedente (
    id bigint NOT NULL,
    pacient_id integer,
    antecedent character varying(4000) NOT NULL,
    data_inregistrare date NOT NULL
);


ALTER TABLE public.antecedente OWNER TO admin_rugina;

--
-- TOC entry 200 (class 1259 OID 16465)
-- Name: antecedente_id_seq; Type: SEQUENCE; Schema: public; Owner: admin_rugina
--

CREATE SEQUENCE public.antecedente_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.antecedente_id_seq OWNER TO admin_rugina;

--
-- TOC entry 2871 (class 0 OID 0)
-- Dependencies: 200
-- Name: antecedente_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin_rugina
--

ALTER SEQUENCE public.antecedente_id_seq OWNED BY public.antecedente.id;


--
-- TOC entry 203 (class 1259 OID 16483)
-- Name: atasamente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.atasamente (
    id bigint NOT NULL,
    pacient_id bigint NOT NULL,
    nume_fisier character varying NOT NULL,
    tip_fisier character varying NOT NULL,
    atasament bytea NOT NULL,
    data_salvare date,
    lungime_fisier bigint
);


ALTER TABLE public.atasamente OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16481)
-- Name: atasamente_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.atasamente_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.atasamente_id_seq OWNER TO postgres;

--
-- TOC entry 2872 (class 0 OID 0)
-- Dependencies: 202
-- Name: atasamente_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.atasamente_id_seq OWNED BY public.atasamente.id;


--
-- TOC entry 207 (class 1259 OID 24671)
-- Name: cabinet; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cabinet (
    id bigint NOT NULL,
    nume character varying NOT NULL,
    adresa character varying NOT NULL,
    telefon character varying NOT NULL,
    data_modificare date NOT NULL,
    folder_salvare character varying DEFAULT 'C:\\DosareMedicale\\'::character varying,
    server character varying,
    portdb character varying,
    userdb character varying,
    paroladb character varying
);


ALTER TABLE public.cabinet OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 24669)
-- Name: cabinet_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cabinet_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cabinet_id_seq OWNER TO postgres;

--
-- TOC entry 2873 (class 0 OID 0)
-- Dependencies: 206
-- Name: cabinet_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cabinet_id_seq OWNED BY public.cabinet.id;


--
-- TOC entry 199 (class 1259 OID 16451)
-- Name: consultatii; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.consultatii (
    id bigint NOT NULL,
    id_pacienta bigint NOT NULL,
    data_consultatie date NOT NULL,
    consultatie character varying(5000),
    alte_observatii character varying
);


ALTER TABLE public.consultatii OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 16449)
-- Name: consultatii_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.consultatii_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.consultatii_id_seq OWNER TO postgres;

--
-- TOC entry 2874 (class 0 OID 0)
-- Dependencies: 198
-- Name: consultatii_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.consultatii_id_seq OWNED BY public.consultatii.id;


--
-- TOC entry 205 (class 1259 OID 24659)
-- Name: dbversion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dbversion (
    id bigint NOT NULL,
    versiune character varying NOT NULL,
    data_rulare date NOT NULL,
    observatii character varying
);


ALTER TABLE public.dbversion OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 24657)
-- Name: dbversion_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.dbversion_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.dbversion_id_seq OWNER TO postgres;

--
-- TOC entry 2875 (class 0 OID 0)
-- Dependencies: 204
-- Name: dbversion_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.dbversion_id_seq OWNED BY public.dbversion.id;


--
-- TOC entry 197 (class 1259 OID 16420)
-- Name: patient_sequence; Type: SEQUENCE; Schema: public; Owner: admin
--

CREATE SEQUENCE public.patient_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.patient_sequence OWNER TO admin;

--
-- TOC entry 196 (class 1259 OID 16396)
-- Name: paciente; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.paciente (
    id integer DEFAULT nextval('public.patient_sequence'::regclass) NOT NULL,
    nume character varying(70) NOT NULL,
    prenume character varying(70) NOT NULL,
    data_nasterii date NOT NULL,
    cnp character varying(13),
    altele character varying(3000),
    data_inscriere date NOT NULL,
    nasteri_naturale numeric,
    cezariene numeric,
    avorturi_cerere numeric,
    avorturi_spontane numeric,
    telefon character varying(15)
);


ALTER TABLE public.paciente OWNER TO admin;

--
-- TOC entry 2876 (class 0 OID 0)
-- Dependencies: 196
-- Name: TABLE paciente; Type: COMMENT; Schema: public; Owner: admin
--

COMMENT ON TABLE public.paciente IS 'Tabel Paciente';


--
-- TOC entry 2708 (class 2604 OID 16519)
-- Name: antecedente id; Type: DEFAULT; Schema: public; Owner: admin_rugina
--

ALTER TABLE ONLY public.antecedente ALTER COLUMN id SET DEFAULT nextval('public.antecedente_id_seq'::regclass);


--
-- TOC entry 2709 (class 2604 OID 16520)
-- Name: atasamente id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.atasamente ALTER COLUMN id SET DEFAULT nextval('public.atasamente_id_seq'::regclass);


--
-- TOC entry 2711 (class 2604 OID 24674)
-- Name: cabinet id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cabinet ALTER COLUMN id SET DEFAULT nextval('public.cabinet_id_seq'::regclass);


--
-- TOC entry 2707 (class 2604 OID 16521)
-- Name: consultatii id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consultatii ALTER COLUMN id SET DEFAULT nextval('public.consultatii_id_seq'::regclass);


--
-- TOC entry 2710 (class 2604 OID 24662)
-- Name: dbversion id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dbversion ALTER COLUMN id SET DEFAULT nextval('public.dbversion_id_seq'::regclass);

--
-- TOC entry 2714 (class 2606 OID 16423)
-- Name: paciente Paciente_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT "Paciente_pkey" PRIMARY KEY (id);


--
-- TOC entry 2718 (class 2606 OID 16475)
-- Name: antecedente antecedente_pkey; Type: CONSTRAINT; Schema: public; Owner: admin_rugina
--

ALTER TABLE ONLY public.antecedente
    ADD CONSTRAINT antecedente_pkey PRIMARY KEY (id);


--
-- TOC entry 2720 (class 2606 OID 16491)
-- Name: atasamente atasamente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.atasamente
    ADD CONSTRAINT atasamente_pkey PRIMARY KEY (id);


--
-- TOC entry 2724 (class 2606 OID 24679)
-- Name: cabinet cabinet_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cabinet
    ADD CONSTRAINT cabinet_pkey PRIMARY KEY (id);


--
-- TOC entry 2716 (class 2606 OID 16459)
-- Name: consultatii consultatie_primarykey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consultatii
    ADD CONSTRAINT consultatie_primarykey PRIMARY KEY (id);


--
-- TOC entry 2722 (class 2606 OID 24667)
-- Name: dbversion dbversion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dbversion
    ADD CONSTRAINT dbversion_pkey PRIMARY KEY (id);


--
-- TOC entry 2726 (class 2606 OID 16476)
-- Name: antecedente antecedent_pacient_primarykey; Type: FK CONSTRAINT; Schema: public; Owner: admin_rugina
--

ALTER TABLE ONLY public.antecedente
    ADD CONSTRAINT antecedent_pacient_primarykey FOREIGN KEY (pacient_id) REFERENCES public.paciente(id);


--
-- TOC entry 2725 (class 2606 OID 16460)
-- Name: consultatii consultatie_pacient_foreignkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consultatii
    ADD CONSTRAINT consultatie_pacient_foreignkey FOREIGN KEY (id_pacienta) REFERENCES public.paciente(id);


--
-- TOC entry 2727 (class 2606 OID 16492)
-- Name: atasamente foreignkey_atasamente_pacient; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.atasamente
    ADD CONSTRAINT foreignkey_atasamente_pacient FOREIGN KEY (pacient_id) REFERENCES public.paciente(id);


--
-- TOC entry 2869 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2019-01-19 18:53:49

--
-- PostgreSQL database dump complete
--
