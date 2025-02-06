package br.com.alura;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TesteMultiplasThreads {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
        Instant inicio = Instant.now();

        try(ExecutorService e = executor){
            for (int i = 1; i <= 14400 ; i++) {
                var tarefa = new ExecutaTarefa();
                e.execute(tarefa);
            }
        }

        Instant fim = Instant.now();

        Duration duracao = Duration.between(inicio, fim);
        System.out.println("Duração: " + duracao.toMillis() + "ms");
    }
}
