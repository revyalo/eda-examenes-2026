package es.urjc.grafo.EDA.examen;

    public class SyntheticIntel {

        // TODO: define aqui los atributos privados necesarios.


        public boolean addModelo(ModeloIA modelo) {
            // TODO: registrar un modelo unico.
            throw new UnsupportedOperationException("TODO: addModelo");
        }

        public boolean addDependencia(String modelo, String dependencia) {
            // TODO: registrar una dependencia dirigida.
            throw new UnsupportedOperationException("TODO: addDependencia");
        }

        public boolean dependeDirectamente(String modelo, String dependencia) {
            // TODO: comprobar arista directa.
            throw new UnsupportedOperationException("TODO: dependeDirectamente");
        }

        public boolean dependeIndirectamente(String modelo, String dependencia) {
            // TODO: comprobar camino dirigido.
            throw new UnsupportedOperationException("TODO: dependeIndirectamente");
        }

        public Iterable<ModeloIA> modelosEntrePrecision(double min, double max) {
            // TODO: consulta por rango.
            throw new UnsupportedOperationException("TODO: modelosEntrePrecision");
        }

    }
