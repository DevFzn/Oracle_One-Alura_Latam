#!/usr/bin/env bash

VersionStr='2023-10-29'
BASEDIR=$(dirname $(realpath -s $BASH_SOURCE))

while read LINE; do
    declare "$LINE" 2>/dev/null
done < $BASEDIR/.env

maria_connect(){
    echo "mariadb -u ${DBUSER} -p${DBPASS} -h ${DBADDR%%:*} ${DBNAME} -P ${DBADDR##*:}"
}

connect_db(){
    $(maria_connect)
}

create_tables(){
    $(maria_connect) < ./create_tables.sql
}

populate_tables(){
    $(maria_connect) < ./populate_tables.sql
}

import_records(){
    $(maria_connect) < ./import_records.sql
}

re_create_tables(){
    $(maria_connect) < ./re_create_tables.sql
}

create_f_sp(){
    $(maria_connect) < ./funcs_sp.sql
}

create_triggers(){
    $(maria_connect) < ./triggers.sql
}

deactivate_session(){
    unset DBNAME DBUSER DBPASS DBADDR PEPPER
    unset VersionStr BASEDIR connect_db
    unset maria_connect create_populate_tables
    unset populate_tables import_records
    unset re_create_tables create_f_sp
    unset create_triggers deactivate_session
}
