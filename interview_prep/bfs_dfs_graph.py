class Graph:
    def __init__(self):
        self.adj_list = {}
        self.num_vertices = 0
        self.num_edges = 0
        
    def read_undirected_graph(self):
        self.num_vertices = int(input('Enter the number of vertices:'))
        self.num_edges = int(input('Enter the number of edges:'))
        
        current_edge_count = 1
        while current_edge_count <= self.num_edges:
            edge = input('Enter the egde ' + str(current_edge_count) + ' in the format <source vertex number><space><destination vertex number>:')
            source, dest = map(int,edge.split(' '))
            if source not in self.adj_list:
                self.adj_list[source] = []
            if dest not in self.adj_list:
                self.adj_list[dest] = []
            
            self.adj_list[source].append(dest)
            self.adj_list[dest].append(source)
            current_edge_count += 1
    
    def dfs(self, cur_vertex, visited=set(), dfs_path = []):
        if cur_vertex in visited:
            return
        
        dfs_path.append(cur_vertex)
        visited.add(cur_vertex)
        
        # this check needed only for disconnected graphs
        if cur_vertex not in self.adj_list:
            return
        
        for neighbour in self.adj_list[cur_vertex]:
            if neighbour in visited:
                continue
            self.dfs(neighbour, visited, dfs_path)
    
    def bfs(self, start_vertex):
        next_neighbour_visit_queue = []
        next_neighbour_visit_queue.append(start_vertex)
        
        visited_vertices = set()
        visited_vertices.add(start_vertex)
        
        bfs_path = [start_vertex]
        
        while len(next_neighbour_visit_queue) > 0:
            visited_node = next_neighbour_visit_queue.pop(0)
            if visited_node not in self.adj_list:
                continue
            for neighbour in self.adj_list[visited_node]:
                if neighbour in visited_vertices:
                    continue
                visited_vertices.add(neighbour)
                bfs_path.append(neighbour)
                next_neighbour_visit_queue.append(neighbour)
        
        return bfs_path

G = Graph()
G.read_undirected_graph()
dfs_path = []
G.dfs(0, set(), dfs_path)
print(dfs_path)
bfs_path = G.bfs(0)
print(bfs_path)



