package com.example.compass.logic;

import com.example.compass.dtos.RangesOfCardinalDirectionsDTO;
import lombok.Getter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Model implements Serializable {
    @Getter
    private static final Model instance = new Model();
    private final Map<String, Pair> model;

    public Model() {
        this.model = new HashMap<>();
    }

    public void setCoordinates(RangesOfCardinalDirectionsDTO ranges) {
        model.put("North", new Pair(ranges.getNorth()));
        model.put("NorthEast", new Pair(ranges.getNortheast()));
        model.put("East", new Pair(ranges.getEast()));
        model.put("SouthEast", new Pair(ranges.getSoutheast()));
        model.put("South", new Pair(ranges.getSouth()));
        model.put("SouthWest", new Pair(ranges.getSouthwest()));
        model.put("West", new Pair(ranges.getWest()));
        model.put("NorthWest", new Pair(ranges.getNorthwest()));
    }

    private static class Pair {
        private final int start;
        private final int end;

        public Pair(String range) {
            String[] rangeMas = range.split("-");
            start = Integer.parseInt(rangeMas[0]);
            end = Integer.parseInt(rangeMas[1]);
        }
    }

    public String findSide(int degree) {
        for (Map.Entry<String, Pair> entry : model.entrySet()) {
            if (degree >= entry.getValue().start && degree <= entry.getValue().end) {
                return entry.getKey();
            }
        }
        return null;
    }
}
