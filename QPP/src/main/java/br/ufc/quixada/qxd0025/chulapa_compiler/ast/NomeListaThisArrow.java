package br.ufc.quixada.qxd0025.chulapa_compiler.ast;

public class NomeListaThisArrow extends NomeLista {
    private final NomeLista nomeLista1;
    private final ParametrosReais parametrosReais;
    private final NomeLista nomeLista2;
    private final Nome_Lista_ nomeLista_;

    public NomeListaThisArrow(NomeLista nomeLista1, ParametrosReais parametrosReais, NomeLista nomeLista2, Nome_Lista_ nomeLista_) {
        this.nomeLista1 = nomeLista1;
        this.parametrosReais = parametrosReais;
        this.nomeLista2 = nomeLista2;
        this.nomeLista_ = nomeLista_;
    }

    public NomeLista getNomeLista1() {
        return nomeLista1;
    }

    public ParametrosReais getParametrosReais() {
        return parametrosReais;
    }

    public NomeLista getNomeLista2() {
        return nomeLista2;
    }

    public Nome_Lista_ getNomeLista_() {
        return nomeLista_;
    }

    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth * 2));
        System.out.print("[NomeListaIDDOT]: {");

        System.out.print(" ".repeat(depth * 2));
        System.out.print("NomeLista:");
        nomeLista1.printAtDepth(depth + 1);
        System.out.print(" ".repeat(depth * 2));
        System.out.print("ParametrosReais:");
        parametrosReais.printAtDepth(depth + 1);
        System.out.print(" ".repeat(depth * 2));
        System.out.print("NomeLista:");
        nomeLista2.printAtDepth(depth + 1);
        System.out.print(" ".repeat(depth * 2));
        System.out.print("NomeLista_:");
        nomeLista_.printAtDepth(depth + 1);
        System.out.print(" ".repeat(depth * 2));

        System.out.print("}");
    }
}
