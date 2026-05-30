# LevelIterator

        **Origen:** PDF mixto junio 2022: parte de implementación LevelIterator, separada del caso de uso de luces.

        **Dificultad:** Media-alta

        ## Enunciado

        Implementa un iterador por niveles para árbol binario. Debe recorrer primero la raíz, después sus
hijos de izquierda a derecha, y continuar nivel a nivel.

El método remove debe eliminar el último nodo devuelto cuando el árbol lo permita. Recuerda que
LinkedBinaryTree.remove solo elimina posiciones con cero o un hijo.

        ## Qué debes tocar

        Completa la clase:

        `src/main/java/es/urjc/grafo/EDA/examen/iteradores/LevelIterator.java`

        No cambies la firma pública de constructores ni métodos. Puedes añadir atributos privados o métodos
        auxiliares si los necesitas.

        ## Tests

        Ejecuta:

        ```bash
        mvn test
        ```

        Los tests están en `src/test/java/es/urjc/grafo/EDA/examen/iteradores/LevelIteratorTest.java`.
        Deben fallar inicialmente por los TODO esperados.
