package library.service;

import library.domain.Membro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MembroService {

    private List<Membro> membros = new ArrayList<>();

    // Adicionar membro
    public void adicionarMembro(Membro membro) {
        membros.add(membro);
        System.out.println("Membro adicionado: " + membro);
    }

    // Remover membro
    public void removerMembro(Membro membro) {
        if (membros.contains(membro)) {
            membros.remove(membro);
            System.out.println("Membro removido: " + membro);
        } else {
            System.out.println("Membro não encontrado: " + membro);
        }
    }

    // Buscar todos os membros
    public List<Membro> getMembros() {
        return membros;
    }

    // Buscar um membro por ID
    public Membro buscarMembroPorId(int id) {
        for (Membro membro : membros) {
            if (membro.getId() == id) {
                return membro;
            }
        }
        return null;  // Retorna null caso o membro não seja encontrado
    }

    // Salvar membros em um arquivo
    public void salvarMembrosEmArquivo(String nomeArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Membro membro : membros) {
                writer.write("Membro:" + membro + "\n");
            }
        }
    }

    // Carregar membros de um arquivo
    public void carregarMembrosDeArquivo(String nomeArquivo) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        }
    }
}
