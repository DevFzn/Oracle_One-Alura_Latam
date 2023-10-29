#!/usr/bin/env bash

VersionStr='2023-10-29'
BASEDIR=$(dirname $(realpath -s $BASH_SOURCE))

while read LINE; do
    declare "$LINE" 2>/dev/null
done < $BASEDIR/.env

connect_db(){
    mariadb -u ${DBUSER} \
            -p${DBPASS}  \
            -h ${DBADDR%%:*} ${DBNAME} \
            -P ${DBADDR##*:} || \
    echo "Ocurrio un error al intentar conectar con la DB"
}

create_tables(){
    mariadb -u ${DBUSER} \
            -p${DBPASS}  \
            -h ${DBADDR%%:*} ${DBNAME} \
            -P ${DBADDR##*:} < ./create_tables.sql &>/dev/null && \
    echo "DB creada" || \
    echo "Ocurrio un error al intentar crear las tablas"
}

populate_tables(){
    echo "Poblando tablas: Clientes, Vendedores y Productos"
    mariadb -u ${DBUSER} \
            -p${DBPASS}  \
            -h ${DBADDR%%:*} ${DBNAME} \
            -P ${DBADDR##*:} < ./populate_tables.sql &>/dev/null && \
    echo "DB poblada" || \
    echo "Ocurrio un error al intentar poblar la DB"
}

import_records(){
    echo "Importando registros de jugos_ventas, tablas -> Facturas e Items"
    mariadb -u ${DBUSER} \
            -p${DBPASS}  \
            -h ${DBADDR%%:*} ${DBNAME} \
            -P ${DBADDR##*:} < ./import_records.sql &>/dev/null && \
    echo "DB poblada" || \
    echo "Ocurrio un error al intentar poblar la DB"
}

re_create_tables(){
    mariadb -u ${DBUSER} \
            -p${DBPASS}  \
            -h ${DBADDR%%:*} ${DBNAME} \
            -P ${DBADDR##*:} < ./re_create_tables.sql
}

create_f_sp(){
    mariadb -u ${DBUSER} \
            -p${DBPASS}  \
            -h ${DBADDR%%:*} ${DBNAME} \
            -P ${DBADDR##*:} < ./funcs_sp.sql
}

create_triggers(){
    mariadb -u ${DBUSER} \
            -p${DBPASS}  \
            -h ${DBADDR%%:*} ${DBNAME} \
            -P ${DBADDR##*:} < ./triggers.sql
}

deactivate_session(){
    unset DBNAME DBUSER DBPASS DBADDR PEPPER
    unset VersionStr BASEDIR
    unset connect_db create_populate_tables
    unset populate_tables import_records
    unset re_create_tables create_f_sp
    unset create_triggers deactivate_session
}
