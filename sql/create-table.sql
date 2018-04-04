-- Table: bschema.config
 DROP TABLE bschema.config;

CREATE TABLE bschema.config
(
    id bigint NOT NULL,
    app_code character varying(10) COLLATE pg_catalog."default" NOT NULL,
    version character varying(10) COLLATE pg_catalog."default" NOT NULL,
    document_content character varying(1000) COLLATE pg_catalog."default",
    last_modified_date timestamp without time zone,
    CONSTRAINT config_pkey PRIMARY KEY (id),
    CONSTRAINT appcode_version_unique UNIQUE (app_code, version)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE bschema.config
    OWNER to postgres;
