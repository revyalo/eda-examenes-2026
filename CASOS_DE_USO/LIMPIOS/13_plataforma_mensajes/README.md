# Plataforma de mensajes

## Enunciado

Una plataforma gestiona usuarios, relaciones de seguimiento y mensajes. Un mensaje puede difundirse por la red social hasta una distancia maxima. Tambien se quieren borrar mensajes antiguos y elegir un usuario central.

## Que esta dado

- `UsuarioPlataforma`: entidad simple.
- `MensajePlataforma`: entidad simple.
- `PlataformaMensajes`: clase gestora con metodos `TODO`.

## Que debes completar

- `addUsuario`
- `seguir`
- `enviarMensaje`
- `usuariosAlcanzables`
- `borrarMensajesHasta`
- `usuarioCentral`

Las relaciones son dirigidas para `seguir`, pero para centralidad puedes aplicar el contrato descrito en los tests/enunciado del metodo.


## Ejecutar

```bash
mvn test
```
