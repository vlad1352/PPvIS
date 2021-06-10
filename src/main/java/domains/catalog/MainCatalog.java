package domains.catalog;

public class MainCatalog extends Catalog{


    private static MainCatalog maincatalog;

    private MainCatalog(String name) {
        super(name);
    }

    public static MainCatalog createMainCatalog(String name) {
        if (maincatalog == null) {
            maincatalog = new MainCatalog(name);
        } else {
            throw new RuntimeException("Main catalog is already exists");
        }
        return maincatalog;
    }





}
