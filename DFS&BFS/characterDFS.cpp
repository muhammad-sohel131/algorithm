#include<iostream>
#include<list>
#include<queue>
#include<vector>
#include<algorithm>

using namespace std;

class Graph {
    int nodes;
    list<char> *adj;

    vector<char> charaters;
    bool *visited;


public:
    Graph(int n);
    int findIndex(char c);
    void addEdge(char src, char dest);
    void BFS(char root);
    void DFS(char root);
};

Graph::Graph(int n){
    nodes = n;
    adj = new list<char>[nodes];

    visited = new bool[nodes];
    for(int i = 0; i < nodes; i++){
        visited[i] = false;
    }
}

int Graph::findIndex(char c){
        auto i = find(charaters.begin(), charaters.end(), c);
        int index = distance(charaters.begin(), i);
        return index;
}

void Graph::addEdge(char src, char dest){
    int length = charaters.size() ;

    int srcIndex = findIndex(src);

    if(srcIndex == length){
        charaters.push_back(src);
        adj[length].push_back(dest);
    }else {
        adj[srcIndex].push_back(dest);
    }

    length = charaters.size();
    int destIndex = findIndex(dest);
    if(destIndex == length){
        charaters.push_back(dest);
        adj[length].push_back(src);
    }else {
        adj[destIndex].push_back(src);
    }

}

void Graph::DFS(char root){

    int index = findIndex(root);
    visited[index] = true;

    cout << root << " ";

    for(auto i = adj[index].begin(); i != adj[index].end(); i++){
        if(!visited[findIndex(*i)]){
            DFS(*i);
        }
    }

}

void Graph::BFS(char root){

    for(int i = 0; i < nodes; i++){
        visited[i] = false;
    }

    queue<char> q;
    q.push(root);

    while(!q.empty()){
        char value = q.front();
        q.pop();

        int index = findIndex(value);
        visited[index] = true;

        cout << value << " ";

        for(auto i = adj[index].begin(); i != adj[index].end(); i++){
            if(!visited[findIndex(*i)]){
                visited[findIndex(*i)] = true;
                q.push(*i);
            }
        }
    }
}
int main(){
    Graph g(5);
    g.addEdge('a', 'c');
    g.addEdge('a', 'w');
    g.addEdge('c', 'x');
    g.addEdge('c', 'z');
    g.addEdge('a', 'z');


    cout << "DFS : ";
    g.DFS('a');

    cout << "\nBFS : ";
    g.BFS('a');

}
