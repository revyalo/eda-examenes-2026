# InordenIteratorWithRemove

        **Origen:** Ejercicio nuevo inspirado en iteradores de examen: remove sobre recorrido inorden.

        **Dificultad:** Alta

        ## Enunciado

        Implementa un iterador inorden de árbol binario con remove. El recorrido debe ser izquierda,
raíz, derecha.

remove debe eliminar el último nodo devuelto por next cuando dicho nodo tenga cero o un hijo,
respetando la limitación de LinkedBinaryTree.remove.

        ## Qué debes tocar

        Completa la clase:

        `src/main/java/es/urjc/grafo/EDA/examen/iteradores/InordenIteratorWithRemove.java`

        No cambies la firma pública de constructores ni métodos. Puedes añadir atributos privados o métodos
        auxiliares si los necesitas.

        ## Tests

        Ejecuta:

        ```bash
        mvn test
        ```

        Los tests están en `src/test/java/es/urjc/grafo/EDA/examen/iteradores/InordenIteratorWithRemoveTest.java`.
        Deben fallar inicialmente por los TODO esperados.
