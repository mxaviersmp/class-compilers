package br.ufc.quixada.qxd0025.chulapa_compiler.symbols;

import java.util.IdentityHashMap;
import java.util.Map;

public class Symbol {

    public static Symbol getSymbolFor(String identifier) {
        String id = identifier.intern();
        Symbol s = symbols.get(id);

        if(s == null) {
            s = new Symbol(id.intern());
            symbols.put(id, s);
        }

        return s;
    }

    @Override
    public String toString() {
        return identifier;
    }

    private static Map<String, Symbol> symbols = new IdentityHashMap<>();

    private final String identifier;

    private Symbol(String id) {
        identifier = id;
    }

}