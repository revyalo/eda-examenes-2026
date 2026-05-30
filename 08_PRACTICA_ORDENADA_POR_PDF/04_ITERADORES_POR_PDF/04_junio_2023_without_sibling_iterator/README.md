# WithoutSiblingIterator

        **Origen:** PDF mixto junio 2023: parte de implementación con iterador de nodos sin hermano, separada del caso de uso.

        **Dificultad:** Alta

        ## Enunciado

        Implementa un iterador sobre árbol binario que devuelva las posiciones que no tienen hermano.
La raíz no cuenta como nodo sin hermano porque no tiene padre.

Debes usar la API del árbol binario: parent, left, right, hasLeft, hasRight y sibling cuando sea útil.

        ## Qué debes tocar

        Completa la clase:

        `src/main/java/es/urjc/grafo/EDA/examen/iteradores/WithoutSiblingIterator.java`

        No cambies la firma pública de constructores ni métodos. Puedes añadir atributos privados o métodos
        auxiliares si los necesitas.

        ## Tests

        Ejecuta:

        ```bash
        mvn test
        ```

        Los tests están en `src/test/java/es/urjc/grafo/EDA/examen/iteradores/WithoutSiblingIteratorTest.java`.
        Deben fallar inicialmente por los TODO esperados.
