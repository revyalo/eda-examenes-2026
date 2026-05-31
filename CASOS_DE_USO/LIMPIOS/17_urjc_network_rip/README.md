# URJCNetwork RIP

Caso de uso inspirado en el enunciado del ISP URJC Network Corporation.

Debes completar las clases `Router` y `Network` usando las estructuras que consideres adecuadas.

## Algoritmo RIP simplificado

- Cada `Router` conoce destinos alcanzables, siguiente vecino y coste.
- `advertise()` devuelve mensajes con todos sus destinos conocidos.
- `receiveMessage(messages)` incorpora rutas nuevas o mejora rutas existentes si el nuevo coste es menor.
- `connectNewRouter(router, neighbors)` conecta un router nuevo con vecinos directos y propaga los cambios de forma recursiva cuando un router actualiza su informacion.

La clase `Message` ya esta completa.

```bash
mvn test
```
