# Censo URJC por municipios

        ## Estructuras del esqueleto

        - `HashMap<String, Habitante> habitantesPorDni`
- `HashMap<String, HashSet<String>> habitantesPorMunicipio`
- `TreeMap<Integer, HashSet<String>> habitantesPorEdad`
- `TreeSet<Municipio> municipiosPorPoblacion`

        ## Archivos principales

        - `src/main/java/es/urjc/grafo/EDA/examen/casos/CensoURJCMunicipios.java`
        - `src/test/java/es/urjc/grafo/EDA/examen/casos/CensoURJCMunicipiosTest.java`

        Completa los TODO manteniendo todos los indices sincronizados.
