-- x#PostgreS#PostgreS DB script

CREATE DATABASE "CabinetRugina"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE "CabinetRugina"
    IS 'Baza de date cabinet Rugina Cosmin';
	
\connect "CabinetRugina";

-- SEQUENCE: public.patient_sequence

-- DROP SEQUENCE public.patient_sequence;

CREATE SEQUENCE public.patient_sequence;

ALTER SEQUENCE public.patient_sequence
    OWNER TO postgres;
	
-- SEQUENCE: public.dosare_sequence

-- DROP SEQUENCE public.dosare_sequence;

CREATE SEQUENCE public.dosare_sequence;

ALTER SEQUENCE public.dosare_sequence
    OWNER TO postgres;
	
-- SEQUENCE: public.consultatii_id_seq

-- DROP SEQUENCE public.consultatii_id_seq;

CREATE SEQUENCE public.consultatii_id_seq;

ALTER SEQUENCE public.consultatii_id_seq
    OWNER TO postgres;	
	
-- SEQUENCE: public.antecedente_id_seq

-- DROP SEQUENCE public.antecedente_id_seq;

CREATE SEQUENCE public.antecedente_id_seq;

ALTER SEQUENCE public.antecedente_id_seq
    OWNER TO postgres;
	
-- SEQUENCE: public.atasamente_id_seq

-- DROP SEQUENCE public.atasamente_id_seq;

CREATE SEQUENCE public.atasamente_id_seq;

ALTER SEQUENCE public.atasamente_id_seq
    OWNER TO postgres;
--------------------------------------------------------------------------------------------

-- Table: public.paciente

-- DROP TABLE public.paciente;

CREATE TABLE public.paciente
(
    id integer NOT NULL DEFAULT nextval('patient_sequence'::regclass),
    nume character varying(70) COLLATE pg_catalog."default" NOT NULL,
    prenume character varying(70) COLLATE pg_catalog."default" NOT NULL,
    data_nasterii date NOT NULL,
    cnp character varying(13) COLLATE pg_catalog."default",
    altele character varying(3000) COLLATE pg_catalog."default",
    data_inscriere date NOT NULL,
    nasteri_naturale numeric,
    cezariene numeric,
    avorturi_cerere numeric,
    avorturi_spontane numeric,
    CONSTRAINT "paciente_pkey" PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.paciente
    OWNER to postgres;
COMMENT ON TABLE public.paciente
    IS 'Tabel Paciente';

	
--------------------------------------------------------------------------------------------	
-- Table: public.consultatii

-- DROP TABLE public.consultatii;

CREATE TABLE public.consultatii
(
    id bigint NOT NULL DEFAULT nextval('consultatii_id_seq'::regclass),
    id_pacienta bigint NOT NULL,
    data_consultatie date NOT NULL,
    consultatie character varying(5000) COLLATE pg_catalog."default",
    alte_observatii character varying COLLATE pg_catalog."default",
    CONSTRAINT consultatie_primarykey PRIMARY KEY (id),
    CONSTRAINT consultatie_pacient_foreignkey FOREIGN KEY (id_pacienta)
        REFERENCES public.paciente (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.consultatii
    OWNER to postgres;
	
ALTER TABLE public.paciente
    ADD COLUMN telefon character varying(15);
	
-- Table: public.antecedente

-- DROP TABLE public.antecedente;

CREATE TABLE public.antecedente
(
    id bigint NOT NULL DEFAULT nextval('antecedente_id_seq'::regclass),
    pacient_id integer,
    antecedent character varying(4000) COLLATE pg_catalog."default" NOT NULL,
    data_inregistrare date NOT NULL,
    CONSTRAINT antecedente_pkey PRIMARY KEY (id),
    CONSTRAINT antecedent_pacient_primarykey FOREIGN KEY (pacient_id)
        REFERENCES public.paciente (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.antecedente
    OWNER to postgres;
	
	-- Table: public.atasamente

-- DROP TABLE public.atasamente;

CREATE TABLE public.atasamente
(
    id bigint NOT NULL DEFAULT nextval('atasamente_id_seq'::regclass),
    pacient_id bigint NOT NULL,
    nume_fisier character varying COLLATE pg_catalog."default" NOT NULL,
    tip_fisier character varying COLLATE pg_catalog."default" NOT NULL,
    atasament bytea NOT NULL,
    data_salvare date,
    lungime_fisier bigint,
    CONSTRAINT atasamente_pkey PRIMARY KEY (id),
    CONSTRAINT foreignkey_atasamente_pacient FOREIGN KEY (pacient_id)
        REFERENCES public.paciente (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.atasamente
    OWNER to postgres;
	
-- SEQUENCE: public.dbversion_id_seq

-- DROP SEQUENCE public.dbversion_id_seq;

CREATE SEQUENCE public.dbversion_id_seq;

ALTER SEQUENCE public.dbversion_id_seq
    OWNER TO postgres;
	
-- Table: public.dbversion

-- DROP TABLE public.dbversion;

CREATE TABLE public.dbversion
(
    id bigint NOT NULL DEFAULT nextval('dbversion_id_seq'::regclass),
    versiune character varying COLLATE pg_catalog."default" NOT NULL,
    data_rulare date NOT NULL,
    observatii character varying COLLATE pg_catalog."default",
    CONSTRAINT dbversion_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.dbversion
    OWNER to postgres;
	
INSERT INTO public.dbversion(versiune, data_rulare, observatii)
	VALUES ('1.0', NOW(), 'Script initial pentru structura bazei de date');
	

-- SEQUENCE: public.cabinet_id_seq

-- DROP SEQUENCE public.cabinet_id_seq;

CREATE SEQUENCE public.cabinet_id_seq;

ALTER SEQUENCE public.cabinet_id_seq
    OWNER TO postgres;

-- Table: public.cabinet

-- DROP TABLE public.cabinet;

CREATE TABLE public.cabinet
(
    id bigint NOT NULL DEFAULT nextval('cabinet_id_seq'::regclass),
    nume character varying COLLATE pg_catalog."default" NOT NULL,
    adresa character varying COLLATE pg_catalog."default" NOT NULL,
    telefon character varying COLLATE pg_catalog."default" NOT NULL,
    data_modificare date NOT NULL,
    folder_salvare character varying COLLATE pg_catalog."default" DEFAULT 'C:\\DosareMedicale\\'::character varying,
    server character varying COLLATE pg_catalog."default",
    portdb character varying COLLATE pg_catalog."default",
    userdb character varying COLLATE pg_catalog."default",
    paroladb character varying COLLATE pg_catalog."default",
    CONSTRAINT cabinet_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.cabinet
    OWNER to postgres;

INSERT INTO public.cabinet(
	nume, adresa, telefon, data_modificare, folder_salvare, server, portdb, userdb, paroladb)
	VALUES ('C.M. Dr. RUGINA', 'Str. Bd. 9Mai, nr. 1, Bl. A13, Ap.2', '0233-237969', NOW(), 
			'C:\\DosareMedicale\\', 'localhost', '5434', 'postgres', 'root');