import java.util.ArrayList;

public class Main {

    static int K = 4;

    public static void main(String[] args) {
        //initialisation d'un graph
        int[][] temp = {{0, 1, 2, 1},{0,1,2,1},{0,1,2,1}};
        Graph graph = new Graph(temp);
        // 1) graphe -> Clqiue(graphe) => graphResult
        Graph cliqueGraph = graph.converteToClique();
        // 2)grapheResult-> calculeIndépendant(graphe) -> liste de K points
        ArrayList<Integer> kPoints = cliqueGraph.getIndependantSumits();
        // 3) comparer entier avec nombrePoint(Liste de K)
        if(kPoints.size()<K)
            System.out.println("Error : K < number solutions found");
        // 4) construire graphe de K
        Graph kGraph = new Graph(kPoints);
        // 5) grapheK -> convertir en fichier CNF
        kGraph.convertToFile_CNF();

        /**
         * Suite à la main ou optionnel
         */
        // 6 optionnel) Executer kissat sur notre fichier CNF
        //   • Executer du bash depuis java
        //  • Récupérer soertie bash en java
        // 7 optionnel) parse le resultat pour en extraite si satifaisable
    }

}
