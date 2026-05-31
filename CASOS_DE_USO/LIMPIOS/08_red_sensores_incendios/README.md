# Red de sensores de incendios

## Enunciado

Una red de sensores forestales esta formada por sensores conectados entre si. Cada sensor puede emitir alertas con identificador, fecha, severidad y zona. Se quiere registrar sensores, conectar sensores, difundir alertas con un limite de saltos y borrar alertas antiguas.

## Que esta dado

- `Sensor`: entidad simple.
- `Alerta`: entidad simple.
- `RedSensoresIncendios`: clase gestora con metodos `TODO`.

## Que debes completar

- `addSensor`
- `connect`
- `registrarAlerta`
- `sensoresAlcanzables`
- `borrarAlertasAntiguas`
- `sensorCentral`

No hay estructuras internas declaradas: elige atributos privados e inicializalos en el constructor.


## Ejecutar

```bash
mvn test
```
