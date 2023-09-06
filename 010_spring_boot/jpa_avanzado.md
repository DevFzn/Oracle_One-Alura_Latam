# JPA Avanzado

<style>div.mermaid{text-align: center;}</style>

Retomando el proyecto [anterior](./jpa/tienda/src/main/java/com/latam/alura/tienda/)

```mermaid
erDiagram
    Categorias ||--o{ Productos : tiene
    Productos {
        id bigint PK
        nombre varchar
        descripcion varchar
        precio decimal
        categoria_id bigint FK
    }
    Categorias {
        id biging PK
        nombre string
    }
    Clientes ||--o{ Pedidos : tiene
    Clientes {
        id bigint PK
        nombre string
        dni string
    }
    Pedidos {
        id bigint PK
        fecha date
        valor_total decimal
        cliente_id bigint FK
    }
    Items_Pedido {
        id bigint PK
        producto_id biging FK
        pedido_id bigint FK
        precio_unitario decimal
        cantidad int
    }
    Pedidos ||--|{ Items_Pedido : tiene
    Items_Pedido }|--|| Productos: tiene
```

## H2

Alias para manejar H2

```bash
alias h2server='java -cp ${HOME}/.m2/repository/com/h2database/h2/2.2.222/h2-2.2.222.jar org.h2.tools.Server -tcpAllowOthers -pgAllowOthers'
alias h2console='java -jar ${HOME}/.m2/repository/com/h2database/h2/2.2.222/h2-2.2.222.jar'
```

- Creación de base de datos `h2console`

### H2 en modo servidor

```bash
h2server

TCP server running at tcp://127.0.1.1:9092 (others can connect)
PG server running at pg://127.0.1.1:5435 (others can connect)
Web Console server running at http://127.0.1.1:8082 (only local connections)
```


En [pom.xml](./jpa/tienda2/pom.xml) cambiar la `url` para usar base de datos
creada anteriormente

```xml
...
<properties>
  ...
  <property name="javax.persistence.jdbc.url"
   value="jdbc:h2:tcp://127.0.1.1:9092//ruta/database;DATABASE_TO_UPPER=false;AUTO_SERVER=false"/>
  ...
</properties>
...
```

#### Sumario Aula 1

- Mapeo de nuevas entidades en la aplicación según el modelado de la base de
datos
- Mapeo de una relación con cardinalidad de muchos a muchos
- Mapeo de una relación bidireccional
- Persitencia entidades que tienen relaciones bidireccionales

