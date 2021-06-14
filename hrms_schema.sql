--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.1

-- Started on 2021-06-14 17:44:42

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 200 (class 1259 OID 16573)
-- Name: candidates; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.candidates (
    id integer NOT NULL,
    name character varying(15) NOT NULL,
    surname character varying(15) NOT NULL,
    identify_number character varying(11) NOT NULL,
    birth_of_year date NOT NULL,
    e_mail character varying(35) NOT NULL,
    password character varying(500) NOT NULL,
    created_at date DEFAULT CURRENT_TIMESTAMP,
    updated_at date,
    deleted_at date,
    mail_confirmation_id integer,
    staff_confirmation_id integer,
    profile_picture character varying(255),
    github_address character varying(255),
    linkedin_address character varying(255)
);


ALTER TABLE public.candidates OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16640)
-- Name: candidates_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.candidates ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.candidates_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 211 (class 1259 OID 16728)
-- Name: cities; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cities (
    id integer NOT NULL,
    city_name character varying NOT NULL,
    plate_number integer NOT NULL,
    job_advertisement_id integer
);


ALTER TABLE public.cities OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 16736)
-- Name: cities_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.cities ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.cities_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 207 (class 1259 OID 16667)
-- Name: confirmation_by_mail; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.confirmation_by_mail (
    id integer NOT NULL,
    confirmation_code character varying(255),
    is_confirmed boolean
);


ALTER TABLE public.confirmation_by_mail OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16705)
-- Name: confirmation_by_mail_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.confirmation_by_mail ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.confirmation_by_mail_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 209 (class 1259 OID 16699)
-- Name: confirmation_by_staff; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.confirmation_by_staff (
    id integer NOT NULL,
    is_confirmed boolean
);


ALTER TABLE public.confirmation_by_staff OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 16697)
-- Name: confirmation_by_staff_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.confirmation_by_staff_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.confirmation_by_staff_id_seq OWNER TO postgres;

--
-- TOC entry 3122 (class 0 OID 0)
-- Dependencies: 208
-- Name: confirmation_by_staff_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.confirmation_by_staff_id_seq OWNED BY public.confirmation_by_staff.id;


--
-- TOC entry 201 (class 1259 OID 16586)
-- Name: employers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employers (
    id integer NOT NULL,
    company_name character varying(45) NOT NULL,
    web_site character varying(45) NOT NULL,
    e_mail character varying(45) NOT NULL,
    phone character varying(13) NOT NULL,
    password character varying(500) NOT NULL,
    created_at date DEFAULT CURRENT_TIMESTAMP,
    updated_at date,
    deleted_at date,
    mail_confirmation_id integer,
    staff_confirmation_id integer
);


ALTER TABLE public.employers OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16626)
-- Name: employers_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.employers ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.employers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 205 (class 1259 OID 16643)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 16740)
-- Name: job_advertisements; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.job_advertisements (
    id integer NOT NULL,
    job_description character varying(255),
    city_id integer,
    salary_max double precision,
    salary_min double precision,
    position_count integer,
    application_deadline timestamp without time zone,
    created_at timestamp without time zone,
    deleted_at timestamp without time zone,
    updated_at timestamp without time zone,
    is_active boolean,
    position_id integer,
    employer_id integer,
    job_type_id integer
);


ALTER TABLE public.job_advertisements OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 16738)
-- Name: job_advertisements_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.job_advertisements_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.job_advertisements_id_seq OWNER TO postgres;

--
-- TOC entry 3123 (class 0 OID 0)
-- Dependencies: 213
-- Name: job_advertisements_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.job_advertisements_id_seq OWNED BY public.job_advertisements.id;


--
-- TOC entry 217 (class 1259 OID 16773)
-- Name: job_experiences; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.job_experiences (
    id integer NOT NULL,
    end_date timestamp without time zone,
    job_position character varying(255),
    start_date timestamp without time zone,
    workplace character varying(255),
    candidate_id integer
);


ALTER TABLE public.job_experiences OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16771)
-- Name: job_experiences_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.job_experiences_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.job_experiences_id_seq OWNER TO postgres;

--
-- TOC entry 3124 (class 0 OID 0)
-- Dependencies: 216
-- Name: job_experiences_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.job_experiences_id_seq OWNED BY public.job_experiences.id;


--
-- TOC entry 224 (class 1259 OID 17054)
-- Name: job_types; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.job_types (
    id integer NOT NULL,
    is_active boolean,
    job_type character varying(255)
);


ALTER TABLE public.job_types OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 17059)
-- Name: job_types_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.job_types ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.job_types_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 219 (class 1259 OID 16784)
-- Name: languages; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.languages (
    id integer NOT NULL,
    language_name character varying(255),
    level integer,
    candidate_id integer
);


ALTER TABLE public.languages OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16782)
-- Name: languages_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.languages_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.languages_id_seq OWNER TO postgres;

--
-- TOC entry 3125 (class 0 OID 0)
-- Dependencies: 218
-- Name: languages_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.languages_id_seq OWNED BY public.languages.id;


--
-- TOC entry 202 (class 1259 OID 16599)
-- Name: positions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.positions (
    id integer NOT NULL,
    created_at timestamp without time zone,
    deleted_at timestamp without time zone,
    job_name character varying(255) NOT NULL,
    updated_at timestamp without time zone
);


ALTER TABLE public.positions OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16645)
-- Name: positions_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.positions ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.positions_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 221 (class 1259 OID 16792)
-- Name: programming_languages; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.programming_languages (
    id integer NOT NULL,
    level integer,
    programming_language_name character varying(255),
    candidate_id integer
);


ALTER TABLE public.programming_languages OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16790)
-- Name: programming_languages_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.programming_languages_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.programming_languages_id_seq OWNER TO postgres;

--
-- TOC entry 3126 (class 0 OID 0)
-- Dependencies: 220
-- Name: programming_languages_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.programming_languages_id_seq OWNED BY public.programming_languages.id;


--
-- TOC entry 223 (class 1259 OID 16886)
-- Name: resumes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.resumes (
    id integer NOT NULL,
    is_active boolean,
    resume_text character varying(255),
    candidate_id integer
);


ALTER TABLE public.resumes OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16763)
-- Name: schools; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.schools (
    id integer NOT NULL,
    department character varying(255),
    school_name character varying(255),
    end_date timestamp without time zone,
    start_date timestamp without time zone,
    candidate_id integer
);


ALTER TABLE public.schools OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16834)
-- Name: schools_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.schools ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.schools_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 2930 (class 2604 OID 16702)
-- Name: confirmation_by_staff id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.confirmation_by_staff ALTER COLUMN id SET DEFAULT nextval('public.confirmation_by_staff_id_seq'::regclass);


--
-- TOC entry 2931 (class 2604 OID 16743)
-- Name: job_advertisements id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_advertisements ALTER COLUMN id SET DEFAULT nextval('public.job_advertisements_id_seq'::regclass);


--
-- TOC entry 2932 (class 2604 OID 16776)
-- Name: job_experiences id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_experiences ALTER COLUMN id SET DEFAULT nextval('public.job_experiences_id_seq'::regclass);


--
-- TOC entry 2933 (class 2604 OID 16787)
-- Name: languages id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.languages ALTER COLUMN id SET DEFAULT nextval('public.languages_id_seq'::regclass);


--
-- TOC entry 2934 (class 2604 OID 16795)
-- Name: programming_languages id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.programming_languages ALTER COLUMN id SET DEFAULT nextval('public.programming_languages_id_seq'::regclass);


--
-- TOC entry 2952 (class 2606 OID 16735)
-- Name: cities cities_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cities
    ADD CONSTRAINT cities_pkey PRIMARY KEY (id);


--
-- TOC entry 2948 (class 2606 OID 16671)
-- Name: confirmation_by_mail confirmation_by_mail_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.confirmation_by_mail
    ADD CONSTRAINT confirmation_by_mail_pkey PRIMARY KEY (id);


--
-- TOC entry 2950 (class 2606 OID 16704)
-- Name: confirmation_by_staff confirmation_by_staff_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.confirmation_by_staff
    ADD CONSTRAINT confirmation_by_staff_pkey PRIMARY KEY (id);


--
-- TOC entry 2942 (class 2606 OID 16598)
-- Name: employers employers_eMail_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employers
    ADD CONSTRAINT "employers_eMail_key" UNIQUE (e_mail);


--
-- TOC entry 2944 (class 2606 OID 16593)
-- Name: employers employers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employers
    ADD CONSTRAINT employers_pkey PRIMARY KEY (id);


--
-- TOC entry 2954 (class 2606 OID 16745)
-- Name: job_advertisements job_advertisements_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_advertisements
    ADD CONSTRAINT job_advertisements_pkey PRIMARY KEY (id);


--
-- TOC entry 2958 (class 2606 OID 16781)
-- Name: job_experiences job_experiences_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_experiences
    ADD CONSTRAINT job_experiences_pkey PRIMARY KEY (id);


--
-- TOC entry 2966 (class 2606 OID 17058)
-- Name: job_types job_types_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_types
    ADD CONSTRAINT job_types_pkey PRIMARY KEY (id);


--
-- TOC entry 2960 (class 2606 OID 16789)
-- Name: languages languages_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.languages
    ADD CONSTRAINT languages_pkey PRIMARY KEY (id);


--
-- TOC entry 2946 (class 2606 OID 16604)
-- Name: positions positions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.positions
    ADD CONSTRAINT positions_pkey PRIMARY KEY (id);


--
-- TOC entry 2962 (class 2606 OID 16797)
-- Name: programming_languages programming_languages_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.programming_languages
    ADD CONSTRAINT programming_languages_pkey PRIMARY KEY (id);


--
-- TOC entry 2964 (class 2606 OID 16890)
-- Name: resumes resumes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.resumes
    ADD CONSTRAINT resumes_pkey PRIMARY KEY (id);


--
-- TOC entry 2956 (class 2606 OID 16767)
-- Name: schools schools_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.schools
    ADD CONSTRAINT schools_pkey PRIMARY KEY (id);


--
-- TOC entry 2936 (class 2606 OID 16583)
-- Name: candidates workers_identifyNumber_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT "workers_identifyNumber_key" UNIQUE (identify_number);


--
-- TOC entry 2938 (class 2606 OID 16585)
-- Name: candidates workers_mail_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT workers_mail_key UNIQUE (e_mail);


--
-- TOC entry 2940 (class 2606 OID 16580)
-- Name: candidates workers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT workers_pkey PRIMARY KEY (id);


--
-- TOC entry 2982 (class 2606 OID 16829)
-- Name: programming_languages fk1flebidapln3j3wscfs63pjwh; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.programming_languages
    ADD CONSTRAINT fk1flebidapln3j3wscfs63pjwh FOREIGN KEY (candidate_id) REFERENCES public.candidates(id);


--
-- TOC entry 2974 (class 2606 OID 17049)
-- Name: job_advertisements fk1oyoicgy5q2gg0v1bb5r6kg2s; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_advertisements
    ADD CONSTRAINT fk1oyoicgy5q2gg0v1bb5r6kg2s FOREIGN KEY (employer_id) REFERENCES public.employers(id);


--
-- TOC entry 2986 (class 2606 OID 17009)
-- Name: resumes fk7f3ggj8e7as0h64jydv7noicf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.resumes
    ADD CONSTRAINT fk7f3ggj8e7as0h64jydv7noicf FOREIGN KEY (candidate_id) REFERENCES public.candidates(id);


--
-- TOC entry 2970 (class 2606 OID 16723)
-- Name: employers fk85yvd1w79ij5a4fll6jkg2yck; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employers
    ADD CONSTRAINT fk85yvd1w79ij5a4fll6jkg2yck FOREIGN KEY (staff_confirmation_id) REFERENCES public.confirmation_by_staff(id);


--
-- TOC entry 2978 (class 2606 OID 16819)
-- Name: job_experiences fk9f7y2g19rixx7oc2vqww04ndu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_experiences
    ADD CONSTRAINT fk9f7y2g19rixx7oc2vqww04ndu FOREIGN KEY (candidate_id) REFERENCES public.candidates(id);


--
-- TOC entry 2985 (class 2606 OID 16906)
-- Name: resumes fkapakx2nqtl5bmn97y2fxklygj; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.resumes
    ADD CONSTRAINT fkapakx2nqtl5bmn97y2fxklygj FOREIGN KEY (id) REFERENCES public.candidates(id);


--
-- TOC entry 2967 (class 2606 OID 16708)
-- Name: candidates fkbple67ad7myb2h6dh2746194y; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT fkbple67ad7myb2h6dh2746194y FOREIGN KEY (mail_confirmation_id) REFERENCES public.confirmation_by_mail(id);


--
-- TOC entry 2971 (class 2606 OID 16753)
-- Name: cities fkbtos9v9fi39bfi3xlqvvooxwx; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cities
    ADD CONSTRAINT fkbtos9v9fi39bfi3xlqvvooxwx FOREIGN KEY (job_advertisement_id) REFERENCES public.job_advertisements(id);


--
-- TOC entry 2968 (class 2606 OID 16713)
-- Name: candidates fke8b4mmd0um4l5e01gi8n8pilu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT fke8b4mmd0um4l5e01gi8n8pilu FOREIGN KEY (staff_confirmation_id) REFERENCES public.confirmation_by_staff(id);


--
-- TOC entry 2981 (class 2606 OID 16841)
-- Name: languages fkfih05vceg3kgjdpklnu4auye6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.languages
    ADD CONSTRAINT fkfih05vceg3kgjdpklnu4auye6 FOREIGN KEY (id) REFERENCES public.languages(id);


--
-- TOC entry 2976 (class 2606 OID 16809)
-- Name: schools fkg637y8p4j9e0fw8qmaq5x1xg8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.schools
    ADD CONSTRAINT fkg637y8p4j9e0fw8qmaq5x1xg8 FOREIGN KEY (candidate_id) REFERENCES public.candidates(id);


--
-- TOC entry 2969 (class 2606 OID 16718)
-- Name: employers fkgnjs237pc3a65qdxuiat8glrr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employers
    ADD CONSTRAINT fkgnjs237pc3a65qdxuiat8glrr FOREIGN KEY (mail_confirmation_id) REFERENCES public.confirmation_by_mail(id);


--
-- TOC entry 2972 (class 2606 OID 16746)
-- Name: job_advertisements fkgnyxsalughgsumyjfb3bmr3jt; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_advertisements
    ADD CONSTRAINT fkgnyxsalughgsumyjfb3bmr3jt FOREIGN KEY (city_id) REFERENCES public.cities(id);


--
-- TOC entry 2973 (class 2606 OID 16758)
-- Name: job_advertisements fkhleljqy0g5lted8qo23w95mtl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_advertisements
    ADD CONSTRAINT fkhleljqy0g5lted8qo23w95mtl FOREIGN KEY (position_id) REFERENCES public.positions(id);


--
-- TOC entry 2980 (class 2606 OID 16824)
-- Name: languages fki56o4l6f72k3sjjyqsget40d6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.languages
    ADD CONSTRAINT fki56o4l6f72k3sjjyqsget40d6 FOREIGN KEY (candidate_id) REFERENCES public.candidates(id);


--
-- TOC entry 2979 (class 2606 OID 16836)
-- Name: job_experiences fkmcvfdlq7hmq6oae4g0wg8nxha; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_experiences
    ADD CONSTRAINT fkmcvfdlq7hmq6oae4g0wg8nxha FOREIGN KEY (id) REFERENCES public.job_experiences(id);


--
-- TOC entry 2975 (class 2606 OID 17066)
-- Name: job_advertisements fkn45y29jdkoick0p9ft0i44bhe; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_advertisements
    ADD CONSTRAINT fkn45y29jdkoick0p9ft0i44bhe FOREIGN KEY (job_type_id) REFERENCES public.job_types(id);


--
-- TOC entry 2983 (class 2606 OID 16846)
-- Name: programming_languages fkov4kfljv9lsi8cygpfemr3bj2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.programming_languages
    ADD CONSTRAINT fkov4kfljv9lsi8cygpfemr3bj2 FOREIGN KEY (id) REFERENCES public.programming_languages(id);


--
-- TOC entry 2977 (class 2606 OID 16856)
-- Name: schools fkqygyuhhl0k0mmheivfue32e0b; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.schools
    ADD CONSTRAINT fkqygyuhhl0k0mmheivfue32e0b FOREIGN KEY (id) REFERENCES public.schools(id);


--
-- TOC entry 2984 (class 2606 OID 16901)
-- Name: programming_languages fkrw8moooy874r4r825y543cnb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.programming_languages
    ADD CONSTRAINT fkrw8moooy874r4r825y543cnb FOREIGN KEY (id) REFERENCES public.candidates(id);


-- Completed on 2021-06-14 17:44:42

--
-- PostgreSQL database dump complete
--

