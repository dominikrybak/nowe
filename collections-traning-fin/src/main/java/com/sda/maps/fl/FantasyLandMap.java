package com.sda.maps.fl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FantasyLandMap {

    public Map<Region, Map<String, FantasyCity>> parseLines(List<String> lines) {
        /**
         * ZAIMPLEMENTUJ MNIE
         */
        return null;
    }


    public static enum Region {

        IAGROYDAL("Iagroydal"),

        SOSCUYVANIA("Soscuyvania"),

        JOCRARIA("Jocraria"),

        KETHIJAN("Kethijan");

        private final String name;

        Region(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
        
        public static Region fromName(String name) {
            Optional<Region> regionOption =
                Arrays.asList(Region.values()).stream()
                    .filter(r -> r.name.equals(name))
                    .findFirst();
            return regionOption
                            .orElseThrow(
                                () -> new IllegalArgumentException(
                                    String.format("No region with %s found!", name)
                                )
                            );
        }

    }

    public static enum Race {

        ELF("Barbaric Waterway Elf"),

        HALFLING("Cursed Fire Halfling"),

        DARK_OGRE("Dark Ogre"),

        MERFLOK("Gray Merfolk"),
        
        HUMAN_ORGE("Human-Ogre");

        private final String name;

        Race(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
        
        public static Race fromName(String name) {
            Optional<Race> raceOption =
                Arrays.asList(Race.values()).stream()
                    .filter(r -> r.name.equals(name))
                    .findFirst();
            return raceOption
                            .orElseThrow(
                                () -> new IllegalArgumentException(
                                    String.format("No race: %s found!", name)
                                )
                            );
        }

    }

}
