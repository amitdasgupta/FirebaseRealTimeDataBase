package com.example.amitdasgupta.firebaserealtimedatabase;

/**
 * Created by AMIT DAS GUPTA on 12-08-2017.
 */

public class Artist {
    String id;
    String name;
    String gene;

    public Artist(String id, String name, String gene) {
        this.id = id;
        this.name = name;
        this.gene = gene;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGene() {
        return gene;
    }
}
