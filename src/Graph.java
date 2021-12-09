import java.util.ArrayList;

public class Graph {

    int graph[][];

    public Graph(int[][] graph) {
        this.graph = graph;
    }

    /**
     * Create a massive graph with sumits give
     * @param sumits
     */
    public Graph(ArrayList<Integer> sumits){

    }

    /**
     * Methode static à améliorer pour des graphes de taille n
     */
    public Graph() {
        graph = new int[][]{
                /*    0 1 2 3 4 5 */
                /*0*/{0, 0, 0, 0, 0, 0},
                /*1*/{0, 0, 0, 0, 0, 0},
                /*2*/{0, 0, 0, 0, 0, 0},
                /*3*/{0, 0, 0, 0, 0, 0},
                /*4*/{0, 0, 0, 0, 0, 0},
                /*5*/{0, 0, 0, 0, 0, 0}
        };
    }

    public void convertToFile_CNF(){

    }

    /**
     * Methode pour passer un graph en sont inverse
     * ( otpimisé au niveau de la boucle car [a][b] = x => [b][a] = c )
     * @return
     */
    public Graph converteToClique(){
        Graph newGraph = new Graph();
        /* Inversion du graphe */
        for(int i=0 ; i < graph.length ; i++)
            for (int j=0; j<=i ; j++) {
                if (graph[i][j] == 0 || i == j/*correspond à la laison A-A = même sommet*/)
                    newGraph.set(i, j, 1);
                else
                    newGraph.set(i, j, 0);
            }

        return newGraph;
    }

    private void set(int i, int j, int b) {
        graph[i][j] = b ;
        graph[j][i] = b ;
    }

    public ArrayList<Integer> getIndependantSumits() {
        ArrayList<Integer> arrayListSave = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {

            //Construction d'un ensemble K
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(i);
            for (int j = 0; j < graph.length; j++)
                if (graph[i][j] == 0 && !this.thereIsNeighbor(arrayList, j))
                    arrayList.add(j);
            String string = "[ ";
            for (int point : arrayList)
                string += point+" ";
            System.out.println(string+" ]");

            // Test si nous avons un plus grand ensemble K
            if(arrayListSave.size()<arrayList.size())
                arrayListSave = arrayList;
        }
        return arrayListSave;
    }

    public boolean thereIsNeighbor(ArrayList<Integer> arrayList, int j){
       for(int point : arrayList){
           if(graph[point][j] == 1 && point != j)
               return true;
       }
       return false;
    }

    public void print(){
        for (int[] ints : graph) {
            StringBuilder graphText = new StringBuilder("[ ");
            for (int j = 0; j < graph.length; j++) {
                graphText.append(ints[j]).append(" ");
            }
            System.out.println(graphText + "]");
        }
    }

    public int[][] getMatrix() {
        return graph;
    }
}
