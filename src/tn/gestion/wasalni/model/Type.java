package tn.gestion.wasalni.model;

public class Type {
    private int id;
    private String category;
    private String descprition ;

    public Type() {
    }

    public Type(int id, String name, String slug) {
        this.id = id;
        this.category = name;
        this.descprition = slug;
    }
    
    public Type(String name, String slug) {
        this.category = name;
        this.descprition = slug;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String name) {
        this.category = name;
    }

    public String getDescprition() {
        return descprition;
    }

    public void setDescprition(String slug) {
        this.descprition = slug;
    }

    @Override
    public String toString() {
        return "Categorie{" + "id=" + id + ", name=" + category + ", slug=" + descprition + '}';
    }

}
