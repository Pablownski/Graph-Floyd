import networkx as nx

# Crear grafo dirigido
G = nx.DiGraph()

# Nombres de ciudades (nodos)
ciudades = {
    "A": "Ciudad de Guatemala",
    "B": "Zacapa",
    "C": "Chiquimula",
    "D": "Quetzaltenango",
    "E": "Cobán"
}

# Agregar aristas con pesos
aristas = [
    ("A", "B", 3),
    ("A", "D", 7),
    ("B", "C", 1),
    ("B", "E", 8),
    ("C", "D", 2),
    ("D", "E", 3),
    ("E", "A", 4)
]

for origen, destino, peso in aristas:
    G.add_edge(origen, destino, weight=peso)

# Calcular distancias y predecesores
distancias = dict(nx.floyd_warshall(G, weight="weight"))
predecesores = dict(nx.floyd_warshall_predecessor_and_distance(G, weight="weight")[0])

# Imprimir matriz de distancias
print("Matriz de distancias mínimas:")
for origen in ciudades:
    for destino in ciudades:
        d = distancias[origen].get(destino, float('inf'))
        valor = "-" if d == float('inf') else int(d)
        print(f"{ciudades[origen]} -> {ciudades[destino]} = {valor}")
    print()

# Función para reconstruir camino
def reconstruir_camino(predecesores, origen, destino):
    if destino not in predecesores.get(origen, {}):
        return []
    camino = [destino]
    while destino != origen:
        destino = predecesores[origen][destino]
        camino.insert(0, destino)
    return camino

# Mostrar rutas desde A
print("Rutas desde Ciudad de Guatemala:")
for destino in ciudades:
    if destino == "A":
        continue
    camino = reconstruir_camino(predecesores, "A", destino)
    if camino:
        nombres = " -> ".join(ciudades[n] for n in camino)
        print(f"{ciudades['A']} a {ciudades[destino]}: {nombres}")
    else:
        print(f"No hay ruta de {ciudades['A']} a {ciudades[destino]}")

# Calcular centro del grafo
excentricidades = {
    nodo: max(distancias[nodo].values())
    for nodo in G.nodes if float('inf') not in distancias[nodo].values()
}
centro = min(excentricidades, key=excentricidades.get)

print(f"\nCentro del grafo: {ciudades[centro]}")
