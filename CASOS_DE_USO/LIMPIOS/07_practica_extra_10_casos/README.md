# Practica extra 2026: 10 casos de uso

Proyecto nuevo dentro de `CASOS_DE_USO/LIMPIOS`. Sigue el estilo del PDF de casos de uso: clases de dominio dadas, una clase gestora por ejercicio, firmas publicas cerradas y tests JUnit.

No hay soluciones incluidas. Las clases gestoras no traen estructuras internas declaradas: debes elegir tus atributos privados e inicializarlos en el constructor.

## Normas

- No cambies las firmas publicas.
- No anadas metodos, clases o atributos publicos.
- Puedes anadir atributos privados y metodos privados auxiliares.
- Mantén coherentes todos tus indices cuando haya altas, bajas o actualizaciones.
- Si usas estructuras ordenadas, recuerda quitar y reinsertar objetos cuando cambie el campo de ordenacion.

## Caso 1. Sistema de emergencias 112

Llegan incidencias con codigo, gravedad, hora, municipio y descripcion. Debes registrar incidencias sin duplicados, atender siempre la mas urgente, cancelar incidencias pendientes, consultar incidencias antiguas y detectar el municipio con mas incidencias activas.

Metodos a completar en `Emergencias112`: `registrarIncidencia`, `atenderSiguiente`, `cancelarIncidencia`, `incidenciasAntesDe`, `municipioConMasIncidencias`.

## Caso 2. Registro de opositores avanzado

Se gestionan opositores por DNI, provincia, nota y estado de apto. Debes evitar DNIs repetidos, actualizar notas manteniendo el ranking, devolver el top de opositores, consultar aptos por provincia y buscar opositores en un rango de notas.

Metodos a completar en `RegistroOpositoresExtra`: `addOpositor`, `actualizarNota`, `top`, `aptosPorProvincia`, `opositoresEntreNotas`.

## Caso 3. Empresa logistica

Cada paquete tiene localizador, destino, prioridad, peso y fecha limite. Debes registrar paquetes, obtener la siguiente entrega, listar paquetes vencidos, reprogramar fechas y eliminar todos los paquetes de un destino.

Metodos a completar en `PaquetesLogistica`: `registrarPaquete`, `siguienteEntrega`, `paquetesVencidosHasta`, `reprogramar`, `eliminarDestino`.

## Caso 4. Reservas de aulas

Se registran aulas y solicitudes de reserva con prioridad, hora y capacidad necesaria. Debes procesar solicitudes, asignar aulas validas, cancelar reservas y consultar reservas por rango temporal.

Metodos a completar en `ReservasAulasExtra`: `registrarAula`, `solicitarReserva`, `procesarSiguienteSolicitud`, `cancelarReserva`, `reservasEntre`.

## Caso 5. Multas de trafico

Cada multa tiene codigo, matricula, fecha, importe, gravedad y estado de pago. Debes registrar multas, buscar por matricula, consultar por fechas, devolver las multas mas caras y marcar multas como pagadas.

Metodos a completar en `MultasTraficoExtra`: `registrarMulta`, `multasDeMatricula`, `multasEntreFechas`, `topMultasMasCaras`, `pagarMulta`.

## Caso 6. Biblioteca universitaria

Se gestionan libros, prestamos, reservas pendientes y devoluciones. Debes anadir libros, prestar libros actualizando popularidad, registrar reservas, consultar devoluciones vencidas y obtener los libros mas prestados.

Metodos a completar en `BibliotecaExtra`: `addLibro`, `prestarLibro`, `reservarLibro`, `devolucionesHasta`, `librosTopPrestados`.

## Caso 7. Subastas online

Cada producto tiene cierre y precio inicial. Los usuarios pueden pujar si la subasta sigue abierta y la cantidad mejora la mejor puja. Debes consultar ganador, cerrar subastas por fecha y listar productos mas caros.

Metodos a completar en `SubastasExtra`: `crearSubasta`, `pujar`, `ganador`, `cerrarSubastasHasta`, `productosMasCaros`.

## Caso 8. Red social sin Graph

Debes representar relaciones dirigidas de seguimiento sin usar una clase `Graph`. Hay usuarios, publicaciones denunciadas y sugerencias por amigos de amigos.

Metodos a completar en `RedSocialExtra`: `addUsuario`, `seguir`, `sugerencias`, `publicar`, `siguientePostAModerar`.

## Caso 9. Hipergrafo de proyectos

Un participante puede estar en varios proyectos y un proyecto puede tener varios participantes. Debes mantener indices cruzados, obtener participantes relacionados, proyectos comunes y expansion por saltos.

Metodos a completar en `HipergrafoProyectosExtra`: `addProyecto`, `addParticipante`, `asignar`, `participantesRelacionados`, `proyectosComunes`, `grupoExpandido`.

## Caso 10. Vuelos dirigidos con escalas

Se gestionan aeropuertos y vuelos dirigidos. Debes comprobar conexiones con un maximo de escalas, buscar vuelos por rango de fechas y devolver el aeropuerto con mas salidas.

Metodos a completar en `VuelosExtra`: `addAirport`, `addFlight`, `conexionConMaxEscalas`, `vuelosEntre`, `aeropuertoConMasSalidas`.

## Ejecutar

```bash
mvn test
```

Al principio los tests fallan por `UnsupportedOperationException`. Eso es correcto: el proyecto es un esqueleto de practica.
