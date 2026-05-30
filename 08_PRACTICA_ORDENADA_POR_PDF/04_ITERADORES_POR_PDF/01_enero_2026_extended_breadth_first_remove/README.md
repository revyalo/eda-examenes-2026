# ExtendedBreadthFirstTreeIterator.remove

        **Origen:** PDF/esqueleto real: implementación enero 2026, iterador en anchura sobre LinkedTree.

        **Dificultad:** Alta

        ## Enunciado

        Completa únicamente el método remove del iterador en anchura.

El iterador ya sabe recorrer el árbol general en anchura. Debes hacer que remove elimine del
LinkedTree el último nodo devuelto por next y todo su subárbol. Además, las posiciones pendientes
del iterador que pertenecieran al subárbol eliminado no deben visitarse en llamadas posteriores.

Casos importantes: no permitir remove antes de next, no permitir dos remove seguidos sobre el
mismo nodo, eliminar hojas, eliminar nodos internos y eliminar la raíz.

        ## Qué debes tocar

        Completa la clase:

        `src/main/java/es/urjc/grafo/EDA/examen/iteradores/ExtendedBreadthFirstTreeIterator.java`

        No cambies la firma pública de constructores ni métodos. Puedes añadir atributos privados o métodos
        auxiliares si los necesitas.

        ## Tests

        Ejecuta:

        ```bash
        mvn test
        ```

        Los tests están en `src/test/java/es/urjc/grafo/EDA/examen/iteradores/ExtendedBreadthFirstTreeIteratorTest.java`.
        Deben fallar inicialmente por los TODO esperados.
