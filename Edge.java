public class Edge {
    private Vertex tovertex;
    private double weight;

    public Edge(Vertex tovertex, double weight) {
        this.tovertex = tovertex;
        this.weight = weight;
    }

    public Vertex getToVertex() {
        return tovertex;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isConnectedTo(Vertex v) {
        return tovertex.equals(v);
    }

    public Vertex getConnectedVertex(Vertex v) {
        if (tovertex.equals(v)) {
            return v;
        } else {
            throw new IllegalArgumentException("Edge is not connected to vertex");
        }
    }


    public Vertex getTo() {
        return tovertex;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}