package UniformCostSearch;

public class Help {
    public static final Node A = new Node("A");
    public static final Node B = new Node("B");
    public static final Node C = new Node("C");
    public static final Node D = new Node("D");
    public static final Node E = new Node("E");
    public static final Node F = new Node("F");
    public static final Node G = new Node("G");
    public static final Node H = new Node("H");
    public static final Node I = new Node("I");
    public static final Node J = new Node("J");
    public static final Node K = new Node("K");
    public static final Node L = new Node("L");
    public static final Node M = new Node("M");
    public static final Node N = new Node("N");
    public static final Node O = new Node("O");
    public static final Node P = new Node("P");
    public static final Node Q = new Node("Q");
    public static final Node R = new Node("R");
    public static final Node S = new Node("S");
    public static final Node T = new Node("T");
    public static final Node U = new Node("U");
    public static final Node V = new Node("V");
    public static final Node W = new Node("W");
    public static final Node X = new Node("X");
    public static final Node Y = new Node("Y");

    public static void init(){
        A.neighbors = new Edge[]{
                new Edge(C, 10),
                new Edge(Y, 12)
        };
        B.neighbors = new Edge[]{
                new Edge(Y, 2),
                new Edge(E, 2),
                new Edge(D, 20),
        };
        E.neighbors = new Edge[]{
                new Edge(B, 2),
                new Edge(I, 2),
                new Edge(H, 20),
        };
        I.neighbors = new Edge[]{
                new Edge(E, 2),
                new Edge(M, 2),
                new Edge(L, 20),
        };
        M.neighbors = new Edge[]{
                new Edge(I, 2),
                new Edge(Q, 2),
                new Edge(P, 10),
        };
        Q.neighbors = new Edge[]{
                new Edge(M, 2),
                new Edge(T, 8),
        };
        C.neighbors = new Edge[]{
                new Edge(A, 10),
                new Edge(F, 17),
        };
        F.neighbors = new Edge[]{
                new Edge(C, 17),
                new Edge(J, 2),
        };
        J.neighbors = new Edge[]{
                new Edge(F, 2),
                new Edge(N, 3),
                new Edge(G, 20),
        };
        N.neighbors = new Edge[]{
                new Edge(J, 3),
                new Edge(R, 3),
                new Edge(K, 20),
        };
        R.neighbors = new Edge[]{
                new Edge(N, 3),
                new Edge(W, 3),
                new Edge(O, 20),
        };
        W.neighbors = new Edge[]{
                new Edge(R, 3),
                new Edge(X, 3),
                new Edge(S, 20),
        };
        G.neighbors = new Edge[]{
                new Edge(J, 20),
                new Edge(D, 12),
        };
        D.neighbors = new Edge[]{
                new Edge(G, 12),
                new Edge(B, 20),
        };
        K.neighbors = new Edge[]{
                new Edge(N, 20),
                new Edge(O, 12),
                new Edge(H, 12),
        };
        H.neighbors = new Edge[]{
                new Edge(K, 12),
                new Edge(L, 12),
                new Edge(E, 20),
        };
        O.neighbors = new Edge[]{
                new Edge(K, 12),
                new Edge(R, 20),
                new Edge(L, 20),
                new Edge(S, 12),
        };
        L.neighbors = new Edge[]{
                new Edge(O, 20),
                new Edge(H, 12),
                new Edge(I, 20),
                new Edge(P, 12),
        };
        S.neighbors = new Edge[]{
                new Edge(O, 12),
                new Edge(P, 12),
                new Edge(V, 8),
                new Edge(W, 20),
        };
        P.neighbors = new Edge[]{
                new Edge(L, 12),
                new Edge(M, 10),
                new Edge(T, 8),
                new Edge(S, 12),
        };
        V.neighbors = new Edge[]{
                new Edge(S, 8),
                new Edge(U, 5),
                new Edge(X, 20),
        };
        U.neighbors = new Edge[]{
                new Edge(V, 5),
                new Edge(T, 5),
        };
        T.neighbors = new Edge[]{
                new Edge(P, 8),
                new Edge(Q, 8),
                new Edge(U, 5),
        };
        X.neighbors = new Edge[]{
                new Edge(W, 3),
                new Edge(V, 20),
        };
        Y.neighbors = new Edge[]{
                new Edge(A, 12),
                new Edge(B, 2),
        };
    }

}
