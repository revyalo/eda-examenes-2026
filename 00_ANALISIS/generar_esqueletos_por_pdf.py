from __future__ import annotations

import re
import shutil
import textwrap
import zipfile
from pathlib import Path


ROOT = Path("/Users/arevalo/Documents/Codex/EDA")
OUT = ROOT / "EDA_Examenes_2026" / "06_ESQUELETOS_POR_PDF"


def slugify(text: str, max_len: int = 80) -> str:
    replacements = {
        "á": "a",
        "é": "e",
        "í": "i",
        "ó": "o",
        "ú": "u",
        "ü": "u",
        "ñ": "n",
        "Á": "a",
        "É": "e",
        "Í": "i",
        "Ó": "o",
        "Ú": "u",
        "Ü": "u",
        "Ñ": "n",
    }
    for src, dst in replacements.items():
        text = text.replace(src, dst)
    text = re.sub(r"[^A-Za-z0-9]+", "_", text).strip("_").lower()
    return text[:max_len].strip("_") or "sin_nombre"


def method_name(text: str) -> str:
    candidate = text.split(".")[-1].strip()
    if re.match(r"^[A-Za-z_$][A-Za-z0-9_$]*$", candidate):
        return candidate
    slug = slugify(text)
    parts = [p for p in slug.split("_") if p]
    if not parts:
        return "resolver"
    name = parts[0] + "".join(p.capitalize() for p in parts[1:])
    if not re.match(r"[A-Za-z_]", name):
        name = "resolver" + name.capitalize()
    return name


def esc_java(text: str) -> str:
    return text.replace("\\", "\\\\").replace('"', '\\"')


EXAMS = [
    {
        "pdf": "PDFS/Casos de uso/Casos de uso - Enunciado.pdf",
        "slug": "01_cu_2026_urjcnetservices_routers",
        "titulo": "Caso de uso: URJCNetServices / routers",
        "categoria": "casos de uso puro",
        "existing": [{"path": "Esqueletos/Uso - Esqueleto", "label": "Uso - Esqueleto"}],
        "exercises": [
            {
                "id": "E1",
                "nombre": "URJCNetServices: routers, mensajes y consultas de red",
                "tipo": "casos_de_uso",
                "estructura": "grafos, mapas, listas e iteradores",
                "class": "URJCNetServicesRouters",
                "methods": ["registrarRouter", "registrarMensaje", "consultarRuta", "resolverCaso"],
            }
        ],
    },
    {
        "pdf": "PDFS/Casos de uso/Enunciado.pdf",
        "slug": "02_cu_oposiciones_cnp",
        "titulo": "Caso de uso: oposiciones al Cuerpo Nacional de Policia",
        "categoria": "casos de uso puro",
        "existing": [{"path": "Esqueletos/Oposiciones-CNP - esqueleto", "label": "Oposiciones-CNP - esqueleto"}],
        "exercises": [
            {
                "id": "E1",
                "nombre": "Registro de opositores CNP",
                "tipo": "casos_de_uso",
                "estructura": "mapas, diccionarios ordenados, comparadores y colecciones",
                "class": "RegistroOposicionesCNP",
                "methods": ["registrarOpositor", "registrarNota", "consultarAptos", "resolverCaso"],
            }
        ],
    },
    {
        "pdf": "PDFS/Casos de uso/Enunciado (1).pdf",
        "slug": "03_impl_hipergrafo",
        "titulo": "Implementacion: hipergrafo no dirigido",
        "categoria": "implementacion pura",
        "existing": [{"path": "Esqueletos/Hipergrafo", "label": "Hipergrafo"}],
        "exercises": [
            {
                "id": "E1",
                "nombre": "AdjacencyMapUndirectedHyperGraph / ELHyperGraph",
                "tipo": "implementacion",
                "estructura": "grafos e hipergrafos",
                "class": "ImplementacionHipergrafo",
                "methods": ["insertHyperedge", "removeHyperedge", "incidentHyperedges", "degree"],
            }
        ],
    },
    {
        "pdf": "PDFS/Casos de uso/Enunciado (2).pdf",
        "slug": "04_cu_cni_interacciones",
        "titulo": "Caso de uso: CNI Interacciones",
        "categoria": "casos de uso puro",
        "existing": [{"path": "Esqueletos/CNI-Interacciones", "label": "CNI-Interacciones"}],
        "exercises": [
            {
                "id": "E1",
                "nombre": "Detector de interacciones del CNI",
                "tipo": "casos_de_uso",
                "estructura": "arboles, grafos, mapas y recorridos",
                "class": "DetectorInteraccionesCNI",
                "methods": ["registrarInteraccion", "calcularArbolInteres", "consultarSospechosos", "resolverCaso"],
            }
        ],
    },
    {
        "pdf": "PDFS/Implementacion/Implementación - Enunciado.pdf",
        "slug": "05_impl_enero_2026_grafos_arboles_iterador",
        "titulo": "Implementacion enero 2026: grafos, arboles e iterador BFS extendido",
        "categoria": "implementacion pura",
        "existing": [{"path": "Esqueletos/Implementación - Esqueleto", "label": "Implementacion - Esqueleto"}],
        "exercises": [
            {
                "id": "E1",
                "nombre": "GraphOperations.existeCaminoDeLongitudMenorOIgualAN",
                "tipo": "implementacion",
                "estructura": "grafos y recorridos",
                "class": "GraphOperationsEnero2026",
                "methods": ["existeCaminoDeLongitudMenorOIgualAN"],
            },
            {
                "id": "E2",
                "nombre": "GraphOperations.kPower",
                "tipo": "implementacion",
                "estructura": "grafos y construccion de grafos",
                "class": "GraphOperationsKPower",
                "methods": ["kPower"],
            },
            {
                "id": "E3",
                "nombre": "TreeOperations.cumplePropiedadesMonticulo",
                "tipo": "implementacion",
                "estructura": "arboles binarios y monticulos",
                "class": "TreeOperationsMonticulo",
                "methods": ["cumplePropiedadesMonticulo"],
            },
            {
                "id": "E4",
                "nombre": "ExtendedBreadthFirstTreeIterator.remove",
                "tipo": "implementacion",
                "estructura": "arboles e iteradores",
                "class": "ExtendedBreadthFirstTreeIteratorRemove",
                "methods": ["remove"],
            },
        ],
    },
    {
        "pdf": "PDFS/Implementacion/Enunciado_practico_enero.pdf",
        "slug": "06_impl_diciembre_2025_complementario_grado_identicos",
        "titulo": "Implementacion diciembre 2025: complementario, grado e identidad",
        "categoria": "implementacion pura",
        "existing": [{"path": "Esqueletos/Esqueleto", "label": "Esqueleto"}],
        "zip_existing": [{"path": "Esqueletos/Esqueleto_practico_enero.zip", "label": "Esqueleto_practico_enero.zip"}],
        "exercises": [
            {
                "id": "E1",
                "nombre": "GraphOperations.complementary",
                "tipo": "implementacion",
                "estructura": "grafos no dirigidos",
                "class": "GraphOperationsComplementary",
                "methods": ["complementary"],
            },
            {
                "id": "E2",
                "nombre": "TreeOperations.treeDegree",
                "tipo": "implementacion",
                "estructura": "arboles generales",
                "class": "TreeOperationsTreeDegree",
                "methods": ["treeDegree"],
            },
            {
                "id": "E3",
                "nombre": "TreeOperations.areIdentical",
                "tipo": "implementacion",
                "estructura": "arboles binarios",
                "class": "TreeOperationsAreIdentical",
                "methods": ["areIdentical"],
            },
        ],
    },
    {
        "pdf": "PDFS/Implementacion/examen-practico-de-estructuras-de-datos-avanzadas-grado-en-ingenieria.pdf",
        "slug": "07_impl_diciembre_2025_euler_descendants_symmetric",
        "titulo": "Implementacion diciembre 2025: euleriano, descendientes y simetria",
        "categoria": "implementacion pura",
        "exercises": [
            {
                "id": "E1",
                "nombre": "GraphOperations.isEulerianGraph",
                "tipo": "implementacion",
                "estructura": "grafos no dirigidos",
                "class": "GraphOperationsEulerian",
                "methods": ["isEulerianGraph"],
            },
            {
                "id": "E2",
                "nombre": "TreeOperations.descendantsNumber",
                "tipo": "implementacion",
                "estructura": "arboles generales",
                "class": "TreeOperationsDescendantsNumber",
                "methods": ["descendantsNumber"],
            },
            {
                "id": "E3",
                "nombre": "TreeOperations.isSymmetric",
                "tipo": "implementacion",
                "estructura": "arboles binarios",
                "class": "TreeOperationsIsSymmetric",
                "methods": ["isSymmetric"],
            },
        ],
    },
    {
        "pdf": "PDFS/Implementacion/Enunciado (3).pdf",
        "slug": "08_impl_funcionalidades_arboles_perfecto_iterador",
        "titulo": "Implementacion: funcionalidades sobre arboles",
        "categoria": "implementacion pura",
        "existing": [{"path": "Esqueletos/Funcionalidades-arboles", "label": "Funcionalidades-arboles"}],
        "exercises": [
            {
                "id": "E1",
                "nombre": "MoreFunctionality.isPerfect",
                "tipo": "implementacion",
                "estructura": "arboles binarios",
                "class": "MoreFunctionalityIsPerfect",
                "methods": ["isPerfect"],
            },
            {
                "id": "E2",
                "nombre": "InternalNodeIterator",
                "tipo": "implementacion",
                "estructura": "arboles binarios e iteradores",
                "class": "InternalNodeIteratorSkeleton",
                "methods": ["hasNext", "next", "remove"],
            },
        ],
    },
    {
        "pdf": "PDFS/Implementacion y casos de uso/Enunciado.pdf",
        "slug": "09_mixto_junio_2025_iteradores_red_electrica",
        "titulo": "Mixto junio 2025: iteradores y Red Electrica Espanola",
        "categoria": "mixto: implementacion + casos de uso",
        "not_copied": ["Esqueletos/Solución propuesta se ha detectado como solucion y no se copia."],
        "exercises": [
            {
                "id": "E1",
                "nombre": "ReverseInordenBTIterator",
                "tipo": "implementacion",
                "estructura": "arboles binarios e iteradores",
                "class": "ReverseInordenBTIteratorSkeleton",
                "methods": ["hasNext", "next", "remove"],
            },
            {
                "id": "E2",
                "nombre": "FunHandling.esPrefijo",
                "tipo": "implementacion",
                "estructura": "arboles y recorridos",
                "class": "FunHandlingEsPrefijo",
                "methods": ["esPrefijo"],
            },
            {
                "id": "E3",
                "nombre": "Red Electrica Espanola: areas, estaciones y red",
                "tipo": "casos_de_uso",
                "estructura": "grafos, mapas y recorridos",
                "class": "RedElectricaEspanola",
                "methods": ["registrarArea", "registrarConexion", "calcularSuministro", "resolverCaso"],
            },
        ],
    },
    {
        "pdf": "PDFS/Implementacion y casos de uso/4c79148b-e28c-42e4-b222-a9c1a8d5a431.pdf",
        "slug": "10_mixto_enero_2025_additional_features_ranking",
        "titulo": "Mixto enero 2025: AdditionalFeatures y ranking de ajedrez",
        "categoria": "mixto: implementacion + casos de uso",
        "not_copied": ["Esqueletos/Solucion y Ordinaria2025.zip contienen solucion, por eso no se copian."],
        "exercises": [
            {
                "id": "E1",
                "nombre": "graphs.AdditionalFeatures",
                "tipo": "implementacion",
                "estructura": "grafos",
                "class": "GraphsAdditionalFeatures",
                "methods": ["additionalFeatureOne", "additionalFeatureTwo"],
            },
            {
                "id": "E2",
                "nombre": "PlayersRanking y NameComparator",
                "tipo": "casos_de_uso",
                "estructura": "mapas, listas ordenadas y comparadores",
                "class": "PlayersRankingNameComparator",
                "methods": ["registrarJugador", "registrarPartida", "ranking", "resolverCaso"],
            },
        ],
    },
    {
        "pdf": "PDFS/Implementacion y casos de uso/3fca766b-255d-44fe-b8c5-572372d17b0c.pdf",
        "slug": "11_mixto_septiembre_2024_bst_red_p2p_uuid",
        "titulo": "Mixto septiembre 2024: BST, poda de arbol y Red P2P",
        "categoria": "mixto: implementacion + casos de uso",
        "existing": [{"path": "Esqueletos/Esqueleto 2", "label": "Esqueleto 2"}],
        "zip_existing": [{"path": "Esqueletos/Esqueleto2.zip", "label": "Esqueleto2.zip"}],
        "exercises": [
            {
                "id": "E1",
                "nombre": "AdditionalFeatures.merge sobre BinarySearchTree",
                "tipo": "implementacion",
                "estructura": "arboles binarios de busqueda",
                "class": "BSTAdditionalFeaturesMerge",
                "methods": ["merge"],
            },
            {
                "id": "E2",
                "nombre": "FunHandling.removeHalfNodes",
                "tipo": "implementacion",
                "estructura": "arboles binarios",
                "class": "FunHandlingRemoveHalfNodes",
                "methods": ["removeHalfNodes"],
            },
            {
                "id": "E3",
                "nombre": "Red P2P: ConnectionManager, NetP2P y Node",
                "tipo": "casos_de_uso",
                "estructura": "grafos, mapas y rutas",
                "class": "RedP2PConnectionManager",
                "methods": ["registrarNodo", "registrarConexion", "caminoEntreNodos", "resolverCaso"],
            },
        ],
    },
    {
        "pdf": "PDFS/Implementacion y casos de uso/estructuras-de-datos-avanzadas-examen-septiembre-2024-convocatoria.pdf",
        "slug": "12_mixto_septiembre_2024_bst_red_p2p",
        "titulo": "Mixto septiembre 2024: BST, poda de arbol y Red P2P",
        "categoria": "mixto: implementacion + casos de uso",
        "existing": [{"path": "Esqueletos/Esqueleto 2", "label": "Esqueleto 2"}],
        "zip_existing": [{"path": "Esqueletos/Esqueleto2.zip", "label": "Esqueleto2.zip"}],
        "duplicate_of": "PDFS/Implementacion y casos de uso/3fca766b-255d-44fe-b8c5-572372d17b0c.pdf",
        "exercises": [
            {
                "id": "E1",
                "nombre": "AdditionalFeatures.merge sobre BinarySearchTree",
                "tipo": "implementacion",
                "estructura": "arboles binarios de busqueda",
                "class": "BSTAdditionalFeaturesMerge",
                "methods": ["merge"],
            },
            {
                "id": "E2",
                "nombre": "FunHandling.removeHalfNodes",
                "tipo": "implementacion",
                "estructura": "arboles binarios",
                "class": "FunHandlingRemoveHalfNodes",
                "methods": ["removeHalfNodes"],
            },
            {
                "id": "E3",
                "nombre": "Red P2P: ConnectionManager, NetP2P y Node",
                "tipo": "casos_de_uso",
                "estructura": "grafos, mapas y rutas",
                "class": "RedP2PConnectionManager",
                "methods": ["registrarNodo", "registrarConexion", "caminoEntreNodos", "resolverCaso"],
            },
        ],
    },
    {
        "pdf": "PDFS/Implementacion y casos de uso/examen-de-estructuras-de-datos-avanzadas-junio-2024.pdf",
        "slug": "13_mixto_junio_2024_hipergrafo_synthetic_intel",
        "titulo": "Mixto junio 2024: hipergrafo y Synthetic Intel",
        "categoria": "mixto: implementacion + casos de uso",
        "existing": [{"path": "Esqueletos/Hipergrafo", "label": "Hipergrafo"}],
        "zip_existing": [{"path": "Esqueletos/Hipergrafo.zip", "label": "Hipergrafo.zip"}],
        "exercises": [
            {
                "id": "E1",
                "nombre": "ELHyperGraph / hipergrafo",
                "tipo": "implementacion",
                "estructura": "grafos e hipergrafos",
                "class": "ELHyperGraphSkeleton",
                "methods": ["insertHyperedge", "removeHyperedge", "incidentHyperedges"],
            },
            {
                "id": "E2",
                "nombre": "Synthetic Intel",
                "tipo": "casos_de_uso",
                "estructura": "grafos, mapas y consultas de dominio",
                "class": "SyntheticIntelCasoUso",
                "methods": ["registrarElemento", "registrarRelacion", "consultarInfluencia", "resolverCaso"],
            },
        ],
    },
    {
        "pdf": "PDFS/Implementacion y casos de uso/wuolah-free-EnunciadoJunio2024.pdf",
        "slug": "14_mixto_junio_2024_hipergrafo_synthetic_intel_wuolah",
        "titulo": "Mixto junio 2024: hipergrafo y Synthetic Intel",
        "categoria": "mixto: implementacion + casos de uso",
        "existing": [{"path": "Esqueletos/Hipergrafo", "label": "Hipergrafo"}],
        "zip_existing": [{"path": "Esqueletos/Hipergrafo.zip", "label": "Hipergrafo.zip"}],
        "duplicate_of": "PDFS/Implementacion y casos de uso/examen-de-estructuras-de-datos-avanzadas-junio-2024.pdf",
        "exercises": [
            {
                "id": "E1",
                "nombre": "ELHyperGraph / hipergrafo",
                "tipo": "implementacion",
                "estructura": "grafos e hipergrafos",
                "class": "ELHyperGraphSkeleton",
                "methods": ["insertHyperedge", "removeHyperedge", "incidentHyperedges"],
            },
            {
                "id": "E2",
                "nombre": "Synthetic Intel",
                "tipo": "casos_de_uso",
                "estructura": "grafos, mapas y consultas de dominio",
                "class": "SyntheticIntelCasoUso",
                "methods": ["registrarElemento", "registrarRelacion", "consultarInfluencia", "resolverCaso"],
            },
        ],
    },
    {
        "pdf": "PDFS/Implementacion y casos de uso/4d1b6b48-d8b9-49dd-84c2-ccd32de869d3.pdf",
        "slug": "15_mixto_junio_2023_without_sibling_ternario_red_social",
        "titulo": "Mixto junio 2023: iterador sin hermano, arbol ternario y red social",
        "categoria": "mixto: implementacion + casos de uso",
        "exercises": [
            {
                "id": "E1",
                "nombre": "WithoutSiblingIterator",
                "tipo": "implementacion",
                "estructura": "arboles binarios e iteradores",
                "class": "WithoutSiblingIteratorSkeleton",
                "methods": ["hasNext", "next", "remove"],
            },
            {
                "id": "E2",
                "nombre": "LinkedTernaryTree",
                "tipo": "implementacion",
                "estructura": "arboles ternarios",
                "class": "LinkedTernaryTreeSkeleton",
                "methods": ["addRoot", "insertFirst", "insertSecond", "insertThird"],
            },
            {
                "id": "E3",
                "nombre": "RedSocial y Persona",
                "tipo": "casos_de_uso",
                "estructura": "grafos, mapas y recorridos",
                "class": "RedSocialPersona",
                "methods": ["registrarPersona", "registrarAmistad", "sugerencias", "resolverCaso"],
            },
        ],
    },
    {
        "pdf": "PDFS/Implementacion y casos de uso/wuolah-free-EnunciadoJunioUltimaV2-A.pdf",
        "slug": "16_mixto_junio_2022_level_iterator_connection_luces",
        "titulo": "Mixto junio 2022: LevelIterator, ConnectionManager y juego de luces",
        "categoria": "mixto: implementacion + casos de uso",
        "exercises": [
            {
                "id": "E1",
                "nombre": "LevelIterator",
                "tipo": "implementacion",
                "estructura": "arboles binarios e iteradores",
                "class": "LevelIteratorSkeleton",
                "methods": ["hasNext", "next", "remove"],
            },
            {
                "id": "E2",
                "nombre": "ConnectionManager",
                "tipo": "casos_de_uso",
                "estructura": "grafos y rutas",
                "class": "ConnectionManagerCasoUso",
                "methods": ["registrarConexion", "existeRuta", "mejorRuta", "resolverCaso"],
            },
            {
                "id": "E3",
                "nombre": "Juego de las luces / playOfLight",
                "tipo": "casos_de_uso",
                "estructura": "grafos y estados",
                "class": "PlayOfLightCasoUso",
                "methods": ["cambiarLuz", "calcularEstado", "resolverCaso"],
            },
        ],
    },
    {
        "pdf": "PDFS/Implementacion y casos de uso/wuolah-free-Examen-1.pdf",
        "slug": "17_mixto_enero_2022_minimum_successor_basketball",
        "titulo": "Mixto enero 2022: MinimumSuccesorTree y liga de baloncesto",
        "categoria": "mixto: implementacion + casos de uso",
        "exercises": [
            {
                "id": "E1",
                "nombre": "MinimumSuccesorTree y MaximumPredecesorTree",
                "tipo": "implementacion",
                "estructura": "arboles binarios de busqueda e iteradores",
                "class": "MinimumSuccesorTreeSkeleton",
                "methods": ["minimum", "minimumFromPosition", "iterator", "maximumPredecesor"],
            },
            {
                "id": "E2",
                "nombre": "BasketballLeague y Team",
                "tipo": "casos_de_uso",
                "estructura": "mapas, diccionarios y ordenaciones",
                "class": "BasketballLeagueCasoUso",
                "methods": ["registrarEquipo", "registrarPartido", "clasificacion", "resolverCaso"],
            },
        ],
    },
    {
        "pdf": "PDFS/Implementacion y casos de uso/wuolah-free-Examen-2.pdf",
        "slug": "18_mixto_enero_2022_quicktree_urjcflights",
        "titulo": "Mixto enero 2022: QuickTree y URJCFlights",
        "categoria": "mixto: implementacion + casos de uso",
        "exercises": [
            {
                "id": "E1",
                "nombre": "QuickTree con search O(1)",
                "tipo": "implementacion",
                "estructura": "arboles de busqueda y mapas auxiliares",
                "class": "QuickTreeSkeleton",
                "methods": ["search", "insert", "remove"],
            },
            {
                "id": "E2",
                "nombre": "URJCFlights",
                "tipo": "casos_de_uso",
                "estructura": "grafos, mapas y rutas",
                "class": "URJCFlightsCasoUso",
                "methods": ["registrarAeropuerto", "registrarVuelo", "buscarRuta", "resolverCaso"],
            },
        ],
    },
    {
        "pdf": "PDFS/Implementacion y casos de uso/wuolah-free-Examen-3.pdf",
        "slug": "19_mixto_febrero_2021_checkmirror_leftview_rip",
        "titulo": "Mixto febrero 2021: checkMirror, leftView y RIP",
        "categoria": "mixto: implementacion + casos de uso",
        "exercises": [
            {
                "id": "E1",
                "nombre": "MoreFunctionality.checkMirror",
                "tipo": "implementacion",
                "estructura": "arboles binarios",
                "class": "MoreFunctionalityCheckMirror",
                "methods": ["checkMirror"],
            },
            {
                "id": "E2",
                "nombre": "MoreFunctionality.leftView",
                "tipo": "implementacion",
                "estructura": "arboles binarios y recorridos por niveles",
                "class": "MoreFunctionalityLeftView",
                "methods": ["leftView"],
            },
            {
                "id": "E3",
                "nombre": "ISP RIP Router Algorithm",
                "tipo": "casos_de_uso",
                "estructura": "grafos ponderados y tablas de rutas",
                "class": "ISPRIPRouterAlgorithm",
                "methods": ["registrarRouter", "actualizarTabla", "mejorRuta", "resolverCaso"],
            },
        ],
    },
    {
        "pdf": "PDFS/Implementacion y casos de uso/wuolah-free-Examen-6.pdf",
        "slug": "20_impl_diciembre_2020_parcial1_arboles_strings",
        "titulo": "Implementacion diciembre 2020: Parcial1",
        "categoria": "implementacion pura",
        "exercises": [
            {
                "id": "E1",
                "nombre": "Parcial1.antecesors",
                "tipo": "implementacion",
                "estructura": "arboles y posiciones",
                "class": "Parcial1Antecesors",
                "methods": ["antecesors"],
            },
            {
                "id": "E2",
                "nombre": "Parcial1.degree",
                "tipo": "implementacion",
                "estructura": "arboles generales",
                "class": "Parcial1Degree",
                "methods": ["degree"],
            },
            {
                "id": "E3",
                "nombre": "Parcial1.isIsogram",
                "tipo": "implementacion",
                "estructura": "mapas/diccionarios o conjuntos sobre cadenas",
                "class": "Parcial1IsIsogram",
                "methods": ["isIsogram"],
            },
        ],
    },
    {
        "pdf": "PDFS/Implementacion y casos de uso/wuolah-free-Examen-8.pdf",
        "slug": "21_mixto_noviembre_2021_isperfect_internalnode_school",
        "titulo": "Mixto noviembre 2021: arbol perfecto, iterador interno y colegio",
        "categoria": "mixto: implementacion + casos de uso",
        "existing": [
            {"path": "Esqueletos/Funcionalidades-arboles", "label": "Funcionalidades-arboles"},
            {"path": "Esqueletos/Esqueleto 6", "label": "Esqueleto 6"},
        ],
        "zip_existing": [
            {"path": "Esqueletos/Funcionalidades-arboles.zip", "label": "Funcionalidades-arboles.zip"},
            {"path": "Esqueletos/Esqueleto6.zip", "label": "Esqueleto6.zip"},
        ],
        "exercises": [
            {
                "id": "E1",
                "nombre": "MoreFunctionality.isPerfect",
                "tipo": "implementacion",
                "estructura": "arboles binarios",
                "class": "MoreFunctionalityIsPerfect",
                "methods": ["isPerfect"],
            },
            {
                "id": "E2",
                "nombre": "InternalNodeIterator",
                "tipo": "implementacion",
                "estructura": "arboles binarios e iteradores",
                "class": "InternalNodeIteratorSkeleton",
                "methods": ["hasNext", "next", "remove"],
            },
            {
                "id": "E3",
                "nombre": "Student, Organiser y DNI",
                "tipo": "casos_de_uso",
                "estructura": "mapas, diccionarios ordenados y comparadores",
                "class": "SchoolOrganiserCasoUso",
                "methods": ["registrarAlumno", "registrarCentro", "buscarPorDNI", "resolverCaso"],
            },
        ],
    },
    {
        "pdf": "PDFS/Implementacion y casos de uso/d25bf4e1-84a6-4178-a75b-cbd65c3e0058.pdf",
        "slug": "22_mixto_enero_2016_linkedbinarytree_urjcinvest",
        "titulo": "Mixto enero 2016: LinkedBinaryTree y URJCInvest",
        "categoria": "mixto: implementacion + casos de uso",
        "exercises": [
            {
                "id": "E1",
                "nombre": "LinkedBinaryTree.isPerfect",
                "tipo": "implementacion",
                "estructura": "arboles binarios",
                "class": "LinkedBinaryTreeIsPerfect",
                "methods": ["isPerfect"],
            },
            {
                "id": "E2",
                "nombre": "LinkedBinaryTree.isOdd",
                "tipo": "implementacion",
                "estructura": "arboles binarios",
                "class": "LinkedBinaryTreeIsOdd",
                "methods": ["isOdd"],
            },
            {
                "id": "E3",
                "nombre": "InternalNodeIterator",
                "tipo": "implementacion",
                "estructura": "arboles binarios e iteradores",
                "class": "InternalNodeIterator2016",
                "methods": ["hasNext", "next", "remove"],
            },
            {
                "id": "E4",
                "nombre": "URJCInvest: empresas y trabajadores",
                "tipo": "casos_de_uso",
                "estructura": "mapas, grafos y relaciones de dominio",
                "class": "URJCInvestCasoUso",
                "methods": ["registrarEmpresa", "registrarTrabajador", "relacionar", "resolverCaso"],
            },
        ],
    },
    {
        "pdf": "PDFS/Implementacion y casos de uso/examen-ordinario-eda-enero-2018-opcion-a-2h-30m-ejercicios.pdf",
        "slug": "23_mixto_enero_2018_levelscomplete_efficientdict_alergia",
        "titulo": "Mixto enero 2018: LevelsComplete, EfficientDict y alergia a la leche",
        "categoria": "mixto: implementacion + casos de uso",
        "exercises": [
            {
                "id": "E1",
                "nombre": "LevelsComplete.levelsComplete",
                "tipo": "implementacion",
                "estructura": "arboles binarios",
                "class": "LevelsCompleteSkeleton",
                "methods": ["levelsComplete"],
            },
            {
                "id": "E2",
                "nombre": "EfficientDict",
                "tipo": "implementacion",
                "estructura": "diccionarios y mapas",
                "class": "EfficientDictSkeleton",
                "methods": ["put", "get", "remove", "entries"],
            },
            {
                "id": "E3",
                "nombre": "Alergia a la leche: pueblos y centros sanitarios",
                "tipo": "casos_de_uso",
                "estructura": "grafos, mapas y consultas de cercania",
                "class": "AlergiaLecheCasoUso",
                "methods": ["registrarPueblo", "registrarCentro", "centroMasCercano", "resolverCaso"],
            },
        ],
    },
    {
        "pdf": "PDFS/Implementacion y casos de uso/3540d1fd-f0f4-4198-bfcc-adfc51ad30a4.pdf",
        "slug": "24_mixto_junio_2016_teoria_bst_censo",
        "titulo": "Mixto junio 2016: teoria, BST y censo URJC",
        "categoria": "mixto: teoria + implementacion + casos de uso",
        "theory": [
            "Alturas minimas en AVL/RB, dimensionado de tabla hash y maximo de claves en arbol B"
        ],
        "exercises": [
            {
                "id": "E2",
                "nombre": "BST.toLinkedTree y BST.removeRange",
                "tipo": "implementacion",
                "estructura": "arboles binarios de busqueda",
                "class": "BSTToLinkedTreeRemoveRange",
                "methods": ["toLinkedTree", "removeRange"],
            },
            {
                "id": "E3",
                "nombre": "Censo URJC / habitantes",
                "tipo": "casos_de_uso",
                "estructura": "mapas, diccionarios y consultas por clave",
                "class": "CensoURJCCasoUso",
                "methods": ["registrarHabitante", "consultarPorMunicipio", "resolverCaso"],
            },
        ],
    },
    {
        "pdf": "PDFS/Implementacion y casos de uso/f4955113-a3a7-443c-8a04-6f30b9de991e.pdf",
        "slug": "25_mixto_diciembre_2014_indices_hash_arboles_traductor",
        "titulo": "Mixto diciembre 2014: indices, hash, arboles y traductor web",
        "categoria": "mixto: teoria + implementacion + casos de uso",
        "theory": [
            "Indices de fichero por horas/destino y tabla hash de DNI con exploracion cuadratica"
        ],
        "exercises": [
            {
                "id": "E2",
                "nombre": "Arbol n-ario: clear y copy",
                "tipo": "implementacion",
                "estructura": "arboles generales",
                "class": "NAryTreeClearCopy",
                "methods": ["clear", "copy"],
            },
            {
                "id": "E3",
                "nombre": "Traductor web",
                "tipo": "casos_de_uso",
                "estructura": "mapas/diccionarios y procesamiento de texto",
                "class": "TraductorWebCasoUso",
                "methods": ["cargarDiccionario", "traducir", "resolverCaso"],
            },
        ],
    },
    {
        "pdf": "PDFS/Implementacion y casos de uso/examen-practico-eda-24-convocatoria-de-septiembre-2024.pdf",
        "slug": "26_pendiente_septiembre_2024_pdf_escaneado",
        "titulo": "PDF septiembre 2024 con extraccion de texto insuficiente",
        "categoria": "desconocido por extraccion",
        "duplicate_of": "Probable duplicado del examen mixto de septiembre 2024; revisar visualmente el PDF escaneado.",
        "theory": ["Revision manual del PDF escaneado antes de fijar firmas exactas."],
        "exercises": [
            {
                "id": "E1",
                "nombre": "Pendiente de revision manual del PDF",
                "tipo": "pendiente_revision",
                "estructura": "no inferida",
                "class": "RevisionManualSeptiembre2024",
                "methods": ["revisarPDF"],
            }
        ],
    },
    {
        "pdf": "PDFS/Implementacion y casos de uso/wuolah-free-Examen-7.pdf",
        "slug": "27_pendiente_wuolah_examen_7",
        "titulo": "PDF Wuolah Examen 7 con extraccion de texto insuficiente",
        "categoria": "desconocido por extraccion",
        "theory": ["Revision manual necesaria: el texto extraido no permite identificar los ejercicios con seguridad."],
        "exercises": [
            {
                "id": "E1",
                "nombre": "Pendiente de revision manual del PDF",
                "tipo": "pendiente_revision",
                "estructura": "no inferida",
                "class": "RevisionManualWuolahExamen7",
                "methods": ["revisarPDF"],
            }
        ],
    },
    {
        "pdf": "PDFS/Examenes_test_no_tener_en_cuenta/examen-de-estructuras-de-datos-avanzadas-eda-231103-preguntas-y-respuestas.pdf",
        "slug": "28_test_teorico_preguntas_respuestas_231103",
        "titulo": "Test teorico EDA 231103 preguntas y respuestas",
        "categoria": "test teorico / no usado para esqueletos de practica",
        "theory": ["Cuestionario teorico detectado en carpeta marcada como no tener en cuenta."],
        "exercises": [],
    },
    {
        "pdf": "PDFS/Examenes_test_no_tener_en_cuenta/test 2 eda.pdf",
        "slug": "29_test_teorico_2_eda",
        "titulo": "Test teorico 2 EDA",
        "categoria": "test teorico / no usado para esqueletos de practica",
        "theory": ["Cuestionario teorico detectado en carpeta marcada como no tener en cuenta."],
        "exercises": [],
    },
    {
        "pdf": "PDFS/Examenes_test_no_tener_en_cuenta/wuolah-free-Segundo-Parcial-EDA.pdf",
        "slug": "30_test_teorico_segundo_parcial_eda",
        "titulo": "Segundo Parcial EDA",
        "categoria": "test teorico / no usado para esqueletos de practica",
        "theory": ["Cuestionario teorico detectado en carpeta marcada como no tener en cuenta."],
        "exercises": [],
    },
    {
        "pdf": "PDFS/Examenes_test_no_tener_en_cuenta/wuolah-free-preguntas-examenes-EDA.pdf",
        "slug": "31_test_teorico_preguntas_examenes_eda",
        "titulo": "Preguntas de examenes EDA",
        "categoria": "test teorico / no usado para esqueletos de practica",
        "theory": ["Cuestionario teorico detectado en carpeta marcada como no tener en cuenta."],
        "exercises": [],
    },
]


def write(path: Path, content: str) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    cleaned = textwrap.dedent(content).lstrip()
    if path.suffix == ".md":
        # Some generated table rows are injected without indentation, which prevents
        # textwrap.dedent from removing the template indent from the surrounding
        # Markdown. Trim the template indent line by line to keep the files readable.
        cleaned = "\n".join(line[8:] if line.startswith("        ") else line for line in cleaned.splitlines())
    path.write_text(cleaned + "\n", encoding="utf-8")


def copy_existing(src_rel: str, dest: Path) -> None:
    src = ROOT / src_rel
    if not src.exists():
        write(dest / "NO_ENCONTRADO.md", f"# No encontrado\n\nNo se encontro `{src_rel}`.\n")
        return
    shutil.copytree(
        src,
        dest,
        ignore=shutil.ignore_patterns(".git", ".idea", "target", "out", ".DS_Store", "__MACOSX"),
        dirs_exist_ok=True,
    )


def extract_zip(src_rel: str, dest: Path) -> None:
    src = ROOT / src_rel
    dest.mkdir(parents=True, exist_ok=True)
    if not src.exists():
        write(dest / "NO_ENCONTRADO.md", f"# No encontrado\n\nNo se encontro `{src_rel}`.\n")
        return
    with zipfile.ZipFile(src) as zf:
        for member in zf.infolist():
            name = member.filename
            parts = Path(name).parts
            if not parts:
                continue
            lowered = [p.lower() for p in parts]
            if "__macosx" in lowered or ".ds_store" in lowered or ".git" in lowered or ".idea" in lowered:
                continue
            if "target" in lowered or "out" in lowered:
                continue
            if any(p.lower().startswith("solucion") or p.lower().startswith("solución") for p in parts):
                continue
            target = dest / name
            if member.is_dir():
                target.mkdir(parents=True, exist_ok=True)
            else:
                target.parent.mkdir(parents=True, exist_ok=True)
                with zf.open(member) as src_fh, target.open("wb") as dst_fh:
                    shutil.copyfileobj(src_fh, dst_fh)


def exercise_folder(exam_dir: Path, exercise: dict) -> Path:
    tipo = exercise["tipo"]
    if tipo not in {"implementacion", "casos_de_uso"}:
        tipo = "pendiente_revision"
    return exam_dir / "ejercicios" / tipo / f"{exercise['id'].lower()}_{slugify(exercise['nombre'], 52)}"


def write_exercise_readmes(exam_dir: Path, exam: dict) -> None:
    for exercise in exam.get("exercises", []):
        folder = exercise_folder(exam_dir, exercise)
        write(
            folder / "README.md",
            f"""
            # {exercise['id']} - {exercise['nombre']}

            - PDF original: `{exam['pdf']}`
            - Tipo: `{exercise['tipo']}`
            - Estructura de datos principal: {exercise['estructura']}
            - Clase de esqueleto generado: `{exercise['class']}`

            ## Que debe completar el alumno

            Completar la logica indicada por el enunciado original sin cambiar la firma publica del proyecto real.
            Si este PDF tiene una carpeta `esqueletos_existentes`, se debe tomar esa carpeta como base canonica.
            El proyecto `esqueletos_generados` incluye un esqueleto auxiliar nombrado por ejercicio para que todos los PDFs queden normalizados.

            ## Metodos nombrados en este esqueleto

            {chr(10).join(f"- `{m}`" for m in exercise.get("methods", ["resolver"]))}
            """,
        )


def write_generated_project(exam_dir: Path, exam: dict) -> None:
    code_exercises = [
        e for e in exam.get("exercises", []) if e["tipo"] in {"implementacion", "casos_de_uso", "pendiente_revision"}
    ]
    if not code_exercises:
        return
    project = exam_dir / "esqueletos_generados"
    write(
        project / "pom.xml",
        """
        <project xmlns="http://maven.apache.org/POM/4.0.0"
                 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
            <modelVersion>4.0.0</modelVersion>
            <groupId>es.urjc.grafo.eda</groupId>
            <artifactId>esqueleto-pdf-eda</artifactId>
            <version>1.0-SNAPSHOT</version>
            <properties>
                <maven.compiler.source>17</maven.compiler.source>
                <maven.compiler.target>17</maven.compiler.target>
                <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
            </properties>
            <dependencies>
                <dependency>
                    <groupId>org.junit.jupiter</groupId>
                    <artifactId>junit-jupiter</artifactId>
                    <version>5.10.2</version>
                    <scope>test</scope>
                </dependency>
            </dependencies>
            <build>
                <plugins>
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-surefire-plugin</artifactId>
                        <version>3.2.5</version>
                    </plugin>
                </plugins>
            </build>
        </project>
        """,
    )
    write(
        project / "README.md",
        f"""
        # Esqueletos generados - {exam['titulo']}

        Este proyecto Maven normaliza los ejercicios detectados en el PDF `{exam['pdf']}`.

        Importante:

        - No contiene soluciones.
        - Las clases estan en `src/main/java/es/urjc/grafo/EDA/examen`.
        - Los metodos lanzan `UnsupportedOperationException` a proposito.
        - Los tests de arranque fallan mientras el alumno no complete los TODO.
        - Si existe `../esqueletos_existentes`, esa carpeta conserva el esqueleto original del profesor y tiene prioridad.

        Para comprobar compilacion:

        ```bash
        mvn test
        ```
        """,
    )
    for exercise in code_exercises:
        methods = exercise.get("methods") or ["resolver"]
        unique_methods = []
        for m in methods:
            mn = method_name(m)
            if mn not in unique_methods:
                unique_methods.append(mn)
        methods_code = "\n\n".join(
            textwrap.indent(f"""
            /**
             * TODO: completar el metodo correspondiente al ejercicio "{esc_java(exercise['nombre'])}".
             * No cambies la firma publica en el esqueleto real del profesor.
             */
            public Object {mn}(Object... parametros) {{
                throw new UnsupportedOperationException("TODO: completar {esc_java(exercise['nombre'])}");
            }}
            """.strip(), "    ")
            for mn in unique_methods
        )
        write(
            project / "src/main/java/es/urjc/grafo/EDA/examen" / f"{exercise['class']}.java",
            f"""
            package es.urjc.grafo.EDA.examen;

            /**
             * Esqueleto generado a partir del PDF:
             * {exam['pdf']}
             *
             * Nombre del ejercicio: {exercise['nombre']}
             * Tipo: {exercise['tipo']}
             * Estructura principal: {exercise['estructura']}
             */
            public class {exercise['class']} {{

                public static final String NOMBRE_EJERCICIO = "{esc_java(exercise['nombre'])}";
                public static final String TIPO = "{esc_java(exercise['tipo'])}";
                public static final String ESTRUCTURA = "{esc_java(exercise['estructura'])}";

                {methods_code}
            }}
            """,
        )
        tests_code = "\n\n".join(
            f"""
            @Test
            void {mn}DebeResolverElEjercicio() {{
                {exercise['class']} ejercicio = new {exercise['class']}();

                Object resultado = ejercicio.{mn}();

                assertNotNull(resultado, "{esc_java(exercise['nombre'])} debe producir el resultado esperado del enunciado.");
            }}
            """.strip()
            for mn in unique_methods
        )
        write(
            project / "src/test/java/es/urjc/grafo/EDA/examen" / f"{exercise['class']}Test.java",
            f"""
            package es.urjc.grafo.EDA.examen;

            import org.junit.jupiter.api.Test;

            import static org.junit.jupiter.api.Assertions.assertNotNull;

            class {exercise['class']}Test {{

                {tests_code}
            }}
            """,
        )


def write_theory(exam_dir: Path, exam: dict) -> None:
    for idx, item in enumerate(exam.get("theory", []), start=1):
        folder = exam_dir / "respuestas_teoricas" / f"t{idx:02d}_{slugify(item, 48)}"
        write(
            folder / "RESPUESTA.md",
            f"""
            # Teoria / revision - {item}

            PDF original: `{exam['pdf']}`

            ## Respuesta del alumno

            TODO: redactar la respuesta razonada usando el material de clase.

            ## Puntos a comprobar

            - Justificar las estructuras usadas.
            - Indicar complejidad cuando el enunciado lo pida.
            - No incluir codigo de solucion si el apartado es teorico.
            """,
        )


def write_exam_readme(exam_dir: Path, exam: dict) -> None:
    rows = []
    for e in exam.get("exercises", []):
        folder = exercise_folder(exam_dir, e).relative_to(exam_dir)
        rows.append(f"| {e['id']} | {e['nombre']} | {e['tipo']} | {e['estructura']} | `{folder}` |")
    if not rows:
        rows.append("| - | PDF de test/teoria | test_teorico | preguntas de repaso | `respuestas_teoricas/` |")
    existing = exam.get("existing", []) + exam.get("zip_existing", [])
    existing_lines = "\n".join(f"- `{x['label']}` desde `{x['path']}`" for x in existing) or "- No se ha localizado esqueleto original asociado."
    not_copied = "\n".join(f"- {x}" for x in exam.get("not_copied", [])) or "- No aplica."
    duplicate = exam.get("duplicate_of")
    duplicate_text = f"\n\n> Posible duplicado o version equivalente: `{duplicate}`\n" if duplicate else ""
    write(
        exam_dir / "README.md",
        f"""
        # {exam['titulo']}

        - PDF original: `{exam['pdf']}`
        - Categoria detectada: **{exam['categoria']}**
        {duplicate_text}
        ## Ejercicios detectados

        | Id | Nombre del ejercicio | Tipo | Estructuras | Carpeta |
        |---|---|---|---|---|
        {chr(10).join(rows)}

        ## Esqueletos originales copiados

        {existing_lines}

        ## Material no copiado

        {not_copied}

        ## Como usar esta carpeta

        1. Revisa primero `INDICE_EJERCICIOS.md`.
        2. Si existe `esqueletos_existentes`, usa ese proyecto como base principal.
        3. Si no existe esqueleto original, usa `esqueletos_generados` como punto de partida nombrado por ejercicio.
        4. Completa solo los TODO del alumno. No hay soluciones incluidas.
        """,
    )
    write(
        exam_dir / "INDICE_EJERCICIOS.md",
        f"""
        # Indice de ejercicios - {exam['titulo']}

        | Id | Nombre exacto usado en esta organizacion | Tipo | Estructura principal | Clase generada |
        |---|---|---|---|---|
        {chr(10).join(f"| {e['id']} | {e['nombre']} | {e['tipo']} | {e['estructura']} | `{e['class']}` |" for e in exam.get('exercises', [])) or '| - | PDF de test/teoria | test_teorico | preguntas de repaso | - |'}

        El nombre de cada ejercicio se ha puesto de forma explicita para que puedas localizarlo rapidamente aunque el PDF tenga nombre generico como `Enunciado.pdf`.
        """,
    )


def write_global_index() -> None:
    rows = []
    for exam in EXAMS:
        names = "<br>".join(e["nombre"] for e in exam.get("exercises", [])) or "PDF de test/teoria"
        folder = exam["slug"]
        rows.append(f"| `{exam['pdf']}` | `{folder}` | {exam['categoria']} | {names} |")
    write(
        OUT / "INDICE_GENERAL_PDFS.md",
        f"""
        # Indice general de PDFs y esqueletos

        Esta carpeta cubre todos los PDFs de examenes localizados fuera de `PDFS/Presentaciones`.
        Los PDFs de `PDFS/Examenes_test_no_tener_en_cuenta` se incluyen en el indice para que no queden sin documentar, pero se marcan como test/teoricos.

        | PDF | Carpeta creada | Categoria | Ejercicios nombrados |
        |---|---|---|---|
        {chr(10).join(rows)}
        """,
    )
    write(
        OUT / "README.md",
        """
        # Esqueletos por PDF

        Esta seccion corrige la organizacion anterior: aqui hay una carpeta por cada PDF de examen detectado.
        Cada carpeta indica el nombre de cada ejercicio, su tipo y la estructura evaluada.

        Convenciones:

        - `esqueletos_existentes`: copia limpia del esqueleto original cuando ya existia en `Esqueletos/`.
        - `esqueletos_generados`: proyecto Maven auxiliar con clases TODO nombradas por ejercicio.
        - `ejercicios/implementacion`: apartados de implementacion extraidos del PDF.
        - `ejercicios/casos_de_uso`: apartados de caso de uso extraidos del PDF.
        - `respuestas_teoricas`: PDFs o apartados teoricos sin esqueleto Java directo.

        No se copian carpetas de soluciones ni zips cuyo contenido identificado sea una solucion.
        """,
    )


def main() -> None:
    if OUT.exists():
        shutil.rmtree(OUT)
    OUT.mkdir(parents=True)
    for exam in EXAMS:
        exam_dir = OUT / exam["slug"]
        exam_dir.mkdir(parents=True, exist_ok=True)
        write_exam_readme(exam_dir, exam)
        write_exercise_readmes(exam_dir, exam)
        write_theory(exam_dir, exam)
        write_generated_project(exam_dir, exam)
        for item in exam.get("existing", []):
            copy_existing(item["path"], exam_dir / "esqueletos_existentes" / slugify(item["label"]))
        for item in exam.get("zip_existing", []):
            extract_zip(item["path"], exam_dir / "esqueletos_existentes" / slugify(item["label"]))
    write_global_index()


if __name__ == "__main__":
    main()
