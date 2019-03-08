package alexrm84;

import java.util.Objects;

public class Vertex {

    private final String label;
    private Vertex previousCity;
    private boolean wasVisited;

    public Vertex getPreviousCity() {
        return previousCity;
    }

    public void setPreviousCity(Vertex previousCity) {
        this.previousCity = previousCity;
    }

    public Vertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public boolean isWasVisited() {
        return wasVisited;
    }

    public void resetState() {
        this.wasVisited = false;
    }

    public void markAsVisited(){
        this.wasVisited=true;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }
}
