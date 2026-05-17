# Guía de corrección: mapa hash

        ## Criterios

        - 3 puntos: `findEntry` localiza claves y primera celda disponible con prueba lineal.
- 2 puntos: tratamiento correcto de claves nulas y centinelas.
- 3 puntos: `rehash` reinserta solo entradas activas y conserva tamaño.
- 2 puntos: integración con `put`, `get`, `remove`, `entries`, `containsKey`.

        ## Penalizaciones habituales

        - Cambiar firmas públicas o paquetes.
        - Resolver con APIs externas en lugar de usar el entorno entregado.
        - No tratar casos vacíos, nulos o límites indicados en el enunciado.
        - Romper invariantes internos de la estructura.
