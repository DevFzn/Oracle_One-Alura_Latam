# OCI 2da Parte

## Bases de datos

- Video OCI [Database](https://youtu.be/F4-sxIsnbKI) -
[Docs](https://docs.oracle.com/es-ww/iaas/Content/home.htm)

- [MongoDB](https://docs.oracle.com/en/cloud/paas/autonomous-database/adbsa/mongo-using-oracle-database-api-mongodb.html)

Para la app de ejemplo
[doguito](https://github.com/alura-es-cursos/1911-OCI2-doguito-app)
se crea una base de data autonoma basada en JSON

### Paquetes necesarios de Oracle Linux 8

no están disponibles para  Oracle Linux 9

```sh
sudo yum install oracle-instantclient-release-el8 oracle-instantclient-basic
sudo yum install @nodejs:18 git
```

```sh
sudo mkdir alura_app
cd $_

git clone https://github.com/alura-es-cursos/1911-OCI2-doguito-app

npm install
npm audit fix --force
npm start

sudo firewall-cmd --permanent --add-port=3000/tcp
sudo firewall-cmd --reload
```

### Servicio systemd

en `/lib/systemd/system/doguito-api.service`

```sh
[Unit]
Description=Doguito API Service
After=network.target

[Service]
Environment="DB_USER=<USER>"
Environment="DB_PASSWORD=<PASSWORD>"
Environment="CONNECT_STRING=<STRING>"
Type=simple
User=opc
ExecStart=/usr/bin/node /home/opc/alura_app/bin/www
Restart=on-failure

[Install]
WantedBy=multi-user.target
```

```sh
sudo systemctl deamon-reload
sudo systemctl enable doguito-api.service
sudo systemctl start doguito-api.service
sudo systemctl status doguito-api.service
```

# Almacenamiento

- Persistencia
- Tipo de datos
- Tipo de performance
- Capacidad de almacenamiento
- Operaciones I/O por segundo
- Velocidad de transferencia
- Durabilidad
- Forma de conexión
- Protocolo

### Almacenamiento de bloques

- Disco virtual

### Almacenamiento de archivos

- NFS

### Almacenamiento de objetos

- Bucket: llave-valor

Object Storage [Docs](https://docs.oracle.com/es-ww/iaas/Content/home.htm) -
[Video](https://www.youtube.com/watch?v=IePCpBGza0k)

## Niveles de almacenamiento

- Estandar 🔥️
- Acceso Infrecuente ❄️
- Archivo 🥶️

# IaC

Infrastructure as code

- Arquitectura Monolítica, convencional. Limita el uso de tecnologías según
el proyecto
- Arquitectura de microservicios, permite utilizar multiples tecnologias, pero
vuelve mas compleja la mantención

IaC establece una "receta" para levantar la infraestructura

- Api Gateway

## Developer Services

1. Creación de Pila
2. Creación de Plan
3. Aplicar

Luego de aplicar el plan, se crea la infraestructura, posterior a ello corren
las instrucciones especificadas en `cloud-init.yaml` bajo el `runcmd`. Esto
puede demorar aproxmadamente 10 minutos (para la app de prueba)

- Resource Manager [video](https://www.youtube.com/watch?v=btnRgK36LnE) -
[docs](https://docs.oracle.com/es-ww/iaas/Content/home.htm)

- Alura blog [Terraform](https://www.aluracursos.com/blog/conociendo-terraform)
