#!/usr/bin/env bash

VersionStr='2023-10-29'
BASEDIR=$(dirname $(realpath -s $BASH_SOURCE))

while read LINE; do
    declare "$LINE" 2>/dev/null
done < $BASEDIR/.env

connect_db(){
    echo "mariadb -u ${DBUSER} -p${DBPASS} -h ${DBADDR%%:*} ${DBNAME} -P ${DBADDR##*:}"
}

create_tables(){
    $(connect_db) < ./create_tables.sql
}

populate_tables(){
    $(connect_db) < ./populate_tables.sql
}

import_records(){
    $(connect_db) < ./import_records.sql
}

re_create_tables(){
    $(connect_db) < ./re_create_tables.sql
}

create_f_sp(){
    $(connect_db) < ./funcs_sp.sql
}

create_triggers(){
    $(connect_db) < ./triggers.sql
}

deactivate_session(){
    unset DBNAME DBUSER DBPASS DBADDR PEPPER
    unset VersionStr BASEDIR
    unset connect_db create_populate_tables
    unset populate_tables import_records
    unset re_create_tables create_f_sp
    unset create_triggers deactivate_session
}
