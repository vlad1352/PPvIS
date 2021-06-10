package domains.catalog;

public class SubCatalog extends Catalog {

    private Catalog root;

    public SubCatalog(String name, Catalog root) {
        super(name);
        checkCatalog(root,name);
        this.root = root;
        root.getSubCatalogs().add(this);

    }

    private void checkCatalog( Catalog root, String name) {
        for(Catalog c: root.getSubCatalogs()) {
            if (c.getName().equals(name)){
                throw new IllegalArgumentException("Catalog with the same name is already exists in this root catalog");
            }
        }
    }

    public Catalog getRoot() {
        return root;
    }

    public void setRoot(Catalog root) {
        this.root = root;
    }
}
