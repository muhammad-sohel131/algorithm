#include <iostream>
#include <vector>
#include <list>
#include<queue>

using namespace std;

class Graph {
    int Nodes;
    list<int>* adj;
    bool *visited;

public:
    Graph(int nodes);
    void addEdge(int start, int destination);
    void DFS(int root);
    void BFS(int root);
};

Graph::Graph(int nodes){
    Nodes = nodes;
    adj = new list<int>[Nodes];
    visited = new bool[nodes];

    for(int i = 0; i < nodes; i++){
        visited[i] = false;
    }
}

void Graph::addEdge(int start, int destination){
    adj[start].push_back(destination);
    adj[destination].push_back(start);
}

void Graph::DFS(int root){
    visited[root] = true;

    cout << root << " ";

    for(auto i = adj[root].begin(); i != adj[root].end(); i++){
        if(!visited[*i]){
            DFS(*i);
        }
    }
}

void Graph::BFS(int root){
    queue<int> q;
    q.push(root);

    while(!q.empty()){
        int value = q.front();
        q.pop();

        visited[value] = true;
        cout << value << " ";

        for(auto i = adj[value].begin(); i != adj[value].end(); i++){
            if(!visited[*i]){
                q.push(*i);
            }
        }

    }
}
int main(){
    Graph g(5);

    g.addEdge(0,1);
    g.addEdge(0,2);
    g.addEdge(0,3);
    g.addEdge(2,4);

    g.BFS(2);
}
