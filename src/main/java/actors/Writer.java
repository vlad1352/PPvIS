package actors;

import domains.Document;
import domains.catalog.Catalog;

public class Writer {

    private final String name;

    public Writer(String name) {
        this.name = name;
    }

    public void createDocument(String header, String text, Catalog catalog) {
        Document document = new Document(header, this.name, text);
        catalog.addDocument(document);
    }

    public void changeDocument(Document document, String header, String text) {
        document.setHeader(header);
        document.setText(text);
    }

    public String getName() {
        return name;
    }
}
