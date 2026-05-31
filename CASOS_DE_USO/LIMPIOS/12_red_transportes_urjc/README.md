# Red de transportes URJC

## Enunciado

La URJC modela paradas y conexiones de transporte entre campus. La red es no dirigida y se consultan trayectos con limite de saltos, paradas alcanzables y la parada con mas conexiones.

## Que esta dado

- `Parada`: entidad simple.
- `ConexionTransporte`: entidad simple.
- `RedTransportesURJC`: clase gestora con metodos `TODO`.

## Que debes completar

- `addParada`
- `conectar`
- `existeTrayecto`
- `paradasAlcanzables`
- `paradaMasConectada`

No uses una clase `Graph`: representa la red con atributos privados elegidos por ti.


## Ejecutar

```bash
mvn test
```
