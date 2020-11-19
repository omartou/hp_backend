package com.codecool.hp_backend.entity;

import java.util.HashMap;
import java.util.Map;

public enum Core {
    DRAGON_HEARTSTRING("Dragon heartstring"),
    PHOENIX_FEATHER("Phoenix feather"),
    PHOENIX_FEATHER_CORE("Phoenix feather core"),
    THESTRAL_TAIL_HAIR("Thestral tail hair"),
    THESTRAL_TAIL_HAIR_CORE("Thestral tail hair core"),
    UNICORN_HAIR("Unicorn hair"),
    UNICORN_HAIR_TAIL("Unicorn hair tail"),
    UNKNOWN_CORE("unknown core"),
    VEELA_HAIR("Veela hair");

    private String name;

    Core(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static Core getEnumByString(String name) {
        Map<String, Core> cores = new HashMap<>() {
            {
                put("dragon heartstring", DRAGON_HEARTSTRING);
                put("phoenix feather", PHOENIX_FEATHER);
                put("phoenix feather core", PHOENIX_FEATHER_CORE);
                put("thestral tail hair", THESTRAL_TAIL_HAIR);
                put("thestral tail hair core", THESTRAL_TAIL_HAIR_CORE);
                put("unicorn hair", UNICORN_HAIR);
                put("unicorn hair tail", UNICORN_HAIR_TAIL);
                put("unknown core", UNKNOWN_CORE);
                put("veela hair", VEELA_HAIR);
            }
        };
        return cores.get(name.toLowerCase());
    }

}
