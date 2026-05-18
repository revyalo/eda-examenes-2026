# Synthetic Intel: red de modelos de IA

        ## Estructuras del esqueleto

        - `HashMap<String, ModeloIA> modelos`
- `HashMap<String, HashSet<String>> dependencias`
- `HashMap<String, HashSet<String>> modelosPorEmpresa`
- `TreeSet<ModeloIA> rankingPrecision`
- `TreeMap<Double, HashSet<String>> modelosPorPrecision`

        ## Archivos principales

        - `src/main/java/es/urjc/grafo/EDA/examen/casos/SyntheticIntelModelos.java`
        - `src/test/java/es/urjc/grafo/EDA/examen/casos/SyntheticIntelModelosTest.java`

        Completa los TODO manteniendo todos los indices sincronizados.
