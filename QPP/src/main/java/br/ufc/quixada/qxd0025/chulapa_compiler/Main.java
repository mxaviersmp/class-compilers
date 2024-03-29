package br.ufc.quixada.qxd0025.chulapa_compiler;

import br.ufc.quixada.qxd0025.chulapa_compiler.ast.Programa;
import br.ufc.quixada.qxd0025.chulapa_compiler.backend.IntermediateCode;
import br.ufc.quixada.qxd0025.chulapa_compiler.frontend.QPPLexer;
import br.ufc.quixada.qxd0025.chulapa_compiler.frontend.QPPParser;
import br.ufc.quixada.qxd0025.chulapa_compiler.frontend.QPPTranslator;
import br.ufc.quixada.qxd0025.chulapa_compiler.symbols.QPPChecker;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;


public class Main {

    public static void main(String[] args) {

        try {

            QPPLexer lexer = new QPPLexer(CharStreams.fromFileName("/home/flycher/Dropbox/VScode/compiladores/QPP/test_files/malan1.qpp"));
            QPPParser parser = new QPPParser(new CommonTokenStream(lexer));

            QPPParser.ProgramaContext ctx = parser.programa();

            System.out.println("Parser executado.");

            QPPTranslator translator = new QPPTranslator();
            Programa programa = (Programa) translator.visit(ctx);
            programa.printAtDepth(0);

            System.out.println("Tradução AST executada.");

            QPPChecker checker = new QPPChecker(programa);
            if (checker.check()) {
                System.out.println("Tabela de simbolos criada.");
                checker.mostrarErros();
            }

            IntermediateCode backend = new IntermediateCode(checker.getSymbolTable());

            System.out.println("Código Intermediário:\n");
            System.out.println(backend.gerar(programa));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
