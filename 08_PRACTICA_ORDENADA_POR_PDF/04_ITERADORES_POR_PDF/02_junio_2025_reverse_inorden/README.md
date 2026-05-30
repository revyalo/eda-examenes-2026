# ReverseInordenBTIterator

        **Origen:** PDF mixto junio 2025: parte de implementación de iteradores, separada del caso de uso de red eléctrica.

        **Dificultad:** Alta

        ## Enunciado

        Implementa un iterador de árbol binario que devuelva las posiciones en inorden inverso:
primero subárbol derecho, después nodo actual y por último subárbol izquierdo.

No debes modificar el árbol. El método remove no forma parte del objetivo principal; puedes dejarlo
sin soportar si el estilo de tu implementación lo justifica.

        ## Qué debes tocar

        Completa la clase:

        `src/main/java/es/urjc/grafo/EDA/examen/iteradores/ReverseInordenBTIterator.java`

        No cambies la firma pública de constructores ni métodos. Puedes añadir atributos privados o métodos
        auxiliares si los necesitas.

        ## Tests

        Ejecuta:

        ```bash
        mvn test
        ```

        Los tests están en `src/test/java/es/urjc/grafo/EDA/examen/iteradores/ReverseInordenBTIteratorTest.java`.
        Deben fallar inicialmente por los TODO esperados.
