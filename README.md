# Guided programming tasks for INF01151 Operating Systems II N
Reports available [here](https://www.overleaf.com/7279775428bkkkdygnmttj)

## PG1 - Websockets
<details>
<summary>Details</summary>

Implementation of a chat application using Java websockets
### Methods implemented:
* ChatServer.openSession(Session new_session) 
* ChatServer.closeSession(Session closing_session)
* ChatServer.transmitMessage(String message)
### Running:
In parent directory (PG1_Websockets/) execute:
```sh
mvn jetty:run
```
Then open a web browser and access ```localhost:8080```
</details>

## PG2 - Webservices
<details>
<summary>Details</summary>


Implementation of a remote procedure call using Java webservices
### Classes implemented:
* Servidor.java
* Cliente.java
* CalculadoraRest.java
### Compiling:
- Run ```make``` in the parent directory (PG2_Webservice/)
### Running:
```
 make run_client
 make run_server
 ```
</details>

