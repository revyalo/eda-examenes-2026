# Registro de opositores al Cuerpo Nacional de Policía


**Tiempo máximo:** 1,5 horas

**Instrucciones:**
- La puntuación de cada ejercicio se indica junto al enunciado.
- No se responderán preguntas sobre los enunciados. La interpretación de estos forma parte del examen.
- No está permitido el uso de calculadoras, ni la consulta de libros, apuntes o dispositivos electrónicos de ningún tipo durante el examen.


## Caso de uso: oposiciones al Cuerpo de Policía Nacional

El Cuerpo de Policía Nacional (CNP) necesita una aplicación informática en la que guardar y consultar ciertos datos. En particular, están interesados en datos que tienen que ver con la oposición para pasar a formar parte del cuerpo. Es decir, quieren guardar una colección de los opositores que se han presentado y las notas que han obtenido. Nos han pedido que nos encarguemos de implementar una clase, _Registro_, que guarde los datos descritos y que permita realizar las siguientes operaciones:

| Operación | Descripción | Puntos |
| --- | --- | --- |
| `public Registro(Iterable<Opositor> opositores)` | Inicializa el objeto. | 0,5 |
| `public Iterable<Opositor> opositores()` | Devuelve un objeto Iterable de los opositores guardados en el registro. | 0,5 |
| `public int size()` | Devuelve el número de opositores en el registro. | 0,5 |
| `public Opositor getOpositor(Integer dni)` | Devuelve el opositor con el DNI especificado. | 0,5 |
| `public boolean addOpositor(Opositor opositor)` | Añade un opositor al registro. No puede aparecer el mismo opositor dos veces en el Registro. | 1 |
| `public double getMinNotaMedia()` | Obtiene la nota media mínima (es decir, la peor nota media) de los opositores en el registro. | 1 |
| `public double getMaxNotaMedia()` | Obtiene la nota media máxima (es decir, la mejor nota media) de los opositores en el registro. | 1 |
| `public Iterable<Opositor> OpositoresConPeorNota()` | Obtiene un objeto Iterable de los opositores con la peor nota media. Puede haber más de un opositor con esa nota. | 1 |
| `public Iterable<Opositor> OpositoresConMejorNota()` | Obtiene un objeto Iterable de los opositores con la mejor nota media. Puede haber más de un opositor con esa nota. | 1 |
| `public Iterable<Opositor> getOpositoresConNotaMediaSuperiorA(double notaMedia)` | Devuelve un objeto iterable de los opositores con una nota media superior a la especificada. | 1 |
| `public Iterable<Opositor> getOpositoresConNotaMediaInferiorA(double notaMedia)` | Devuelve un objeto iterable de los opositores con una nota media inferior a la especificada. | 1 |
| `public Iterable<Opositor> getOpositoresConNotaMediaEnElRango(double min, double max)` | Devuelve un objeto Iterable de los opositores con una nota media que está entre la nota mínima y la nota máxima especificada. | 1 |



**Consideraciones adicionales:**
- No se pueden añadir nuevas clases públicas.
- Solo se pueden añadir nuevos métodos y propiedades a las clases ya existentes siempre y cuando sean privados.
- No se pueden modificar las cabeceras de los métodos ya dados.
- La clase `Registro` podrá tener, como máximo, dos propiedades
