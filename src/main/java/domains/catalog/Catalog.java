package domains.catalog;

import domains.Document;

import java.util.*;

public abstract class Catalog {

    private String name;
    private Set<Document> documents;
    private List<Catalog> subCatalogs;

    public Catalog(String name) {
        this.name = name;
        this.documents = new HashSet<>();
        this.subCatalogs = new ArrayList<>();
    }

    public void addDocument(Document document) {
        boolean key = documents.add(document);
        if(!key) {
            throw new IllegalArgumentException("Document with the same header is already exists");
        }
        document.setCurrCatalog(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

    public List<Catalog> getSubCatalogs() {
        return subCatalogs;
    }

    public void setSubCatalogs(List<Catalog> subCatalogs) {
        this.subCatalogs = subCatalogs;
    }

}
