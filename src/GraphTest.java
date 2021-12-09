import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class GraphTest {

    @Test
    public void  printTest(){
        int[][] temp = {
                /*    0 1 2 3 4 5 */
                /*0*/{1,0,1,0,0,0},
                /*1*/{0,1,1,0,1,1},
                /*2*/{1,1,1,1,1,1},
                /*3*/{0,0,1,1,0,1},
                /*4*/{0,1,1,0,1,1},
                /*5*/{0,1,1,1,1,1}
        };

        Graph graph = new Graph(temp);
        graph.print();
    }

    @Test
    public void  converteToCliquetTest(){
        int[][] temp = {
                /*    0 1 2 3 4 5 */
                /*0*/{1,0,1,0,0,0},
                /*1*/{0,1,1,0,1,1},
                /*2*/{1,1,1,1,1,1},
                /*3*/{0,0,1,1,0,1},
                /*4*/{0,1,1,0,1,1},
                /*5*/{0,1,1,1,1,1}
        };

        Graph graph = new Graph(temp);
        Graph graph1 = graph.converteToClique();
        int[][] temp2 = {
                /*    0 1 2 3 4 5 */
                /*0*/{1,1,0,1,1,1},
                /*1*/{1,1,0,1,0,0},
                /*2*/{0,0,1,0,0,0},
                /*3*/{1,1,0,1,1,0},
                /*4*/{1,0,0,1,1,0},
                /*5*/{1,0,0,0,0,1}
        };
        for (int i = 0; i < graph1.getMatrix().length; i++)
            for (int j = 0; j < graph1.getMatrix().length; j++)
                assertEquals(graph1.getMatrix()[i][j],temp2[i][j]);

    }

    @Test
    public void thereIsNeighborTest(){
        int[][] temp = {
                /*    0 1 2 3 */
                /*0*/{1,1,0,0},
                /*1*/{1,1,1,1},
                /*2*/{0,1,1,0},
                /*3*/{0,1,0,1}
        };

        Graph graph = new Graph(temp);
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(0);
        arrayList1.add(3);
        arrayList1.add(2);
        assertTrue(graph.thereIsNeighbor(arrayList1,1));
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList1.add(1);
        assertFalse(graph.thereIsNeighbor(arrayList2,2));
    }

    @Test
    public void getIndependantSumitsTest(){
        int[][] temp1 = {
                /*    0 1 2 3 */
                /*0*/{1,1,0,0},
                /*1*/{1,1,1,1},
                /*2*/{0,1,1,0},
                /*3*/{0,1,0,1}
        };

        Graph graph2 = new Graph(temp1);
        for (int point : graph2.getIndependantSumits())
            System.out.println(point);

        int[][] temp = {
                /*    0 1 2 3 4 5 */
                /*0*/{1,0,1,0,0,0},
                /*1*/{0,1,1,0,1,1},
                /*2*/{1,1,1,1,1,1},
                /*3*/{0,0,1,1,0,1},
                /*4*/{0,1,1,0,1,1},
                /*5*/{0,1,1,1,1,1}
        };

        Graph graph = new Graph(temp);
        Graph graph1 = graph.converteToClique();

        for (int point : graph1.getIndependantSumits())
            System.out.println(point);

    }
}