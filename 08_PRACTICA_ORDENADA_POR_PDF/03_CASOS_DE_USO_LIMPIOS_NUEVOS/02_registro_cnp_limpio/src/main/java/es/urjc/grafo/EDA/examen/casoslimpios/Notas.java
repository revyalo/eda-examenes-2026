package es.urjc.grafo.EDA.examen.casoslimpios;

public record Notas(double teoria, double fisica, double psicotecnico) {
                        public double media() {
                            return (teoria + fisica + psicotecnico) / 3.0;
                        }
                    }
