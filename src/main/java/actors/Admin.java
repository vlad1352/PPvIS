package actors;

import domains.Document;
import domains.catalog.Catalog;
import domains.catalog.SubCatalog;

import java.util.concurrent.atomic.AtomicBoolean;

public class Admin {

    private Catalog mainCatalog;

    public Admin(Catalog mainCatalog) {
        this.mainCatalog = mainCatalog;
    }

    public void removeDocument(Document document) {

        Catalog catalog = findDocument(document, mainCatalog);
        if (catalog == null) {
            throw new IllegalArgumentException("Document doesn't exists");
        } else {
            catalog.getDocuments().remove(document);
        }

    }

    private Catalog findDocument(Document document, Catalog currCatalog) {
        AtomicBoolean isFind = new AtomicBoolean(false);
        currCatalog.getDocuments().forEach(d -> {
            if (d.equals(document)) {
                isFind.set(true);
            }
        });

        if (isFind.get()) {
            return currCatalog;
        } else {
            for (Catalog c : currCatalog.getSubCatalogs()) {
                return findDocument(document, c);
            }
        }

        return null;
    }

    public void createCatalog(Catalog rootCatalog, String catalogName) {
        Catalog catalog = new SubCatalog(catalogName, rootCatalog);
    }

    public void moveDocument(Document document, Catalog moveTo) {
        Catalog catalog = document.getCurrCatalog();
        catalog.getDocuments().remove(document);
        moveTo.addDocument(document);
        document.setCurrCatalog(moveTo);
    }
}
