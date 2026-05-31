package es.urjc.grafo.EDA.examen;

    public class RedElectricaEspanola {

        // TODO: define aqui los atributos privados necesarios.


        public boolean addArea(Area area) {
            // TODO: registrar un area sin duplicados.
            throw new UnsupportedOperationException("TODO: addArea");
        }

        public boolean addCentral(CentralElectrica central) {
            // TODO: registrar una central y todos los indices.
            throw new UnsupportedOperationException("TODO: addCentral");
        }

        public boolean conectar(String origen, String destino) {
            // TODO: anadir una conexion no dirigida entre centrales existentes.
            throw new UnsupportedOperationException("TODO: conectar");
        }

        public Iterable<CentralElectrica> centralesDeArea(String areaId) {
            // TODO: devolver las centrales de un area.
            throw new UnsupportedOperationException("TODO: centralesDeArea");
        }

        public boolean estanConectadas(String origen, String destino) {
            // TODO: comprobar si hay camino entre dos centrales.
            throw new UnsupportedOperationException("TODO: estanConectadas");
        }

        public CentralElectrica centralMasConectada() {
            // TODO: devolver la central con mas conexiones.
            throw new UnsupportedOperationException("TODO: centralMasConectada");
        }

    }
