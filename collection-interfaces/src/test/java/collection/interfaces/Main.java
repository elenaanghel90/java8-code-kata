package collection.interfaces;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static List<String> listaStringuri = new ArrayList<>();

    public static void main(String[] args) {
        //lambda de tip Function, care primeste param si returneaza rez
        Function<Integer, Integer> doubleItFn = a -> a * 2;
        Function<Integer, String> returnIt = b -> "Rezultatul este: " + b;
        Function<String, String> nrCaractere = c -> {
            int caractere = c.length();
            if (caractere > 5) {
                return "mare";
            }
            return "mic";
        };

        //lambda de tip Supplier, care nu primeste param si returneaza rez
        Supplier<Integer> nrNorocos = () -> new Random().nextInt();

        //lambda de tip Consumer, care primeste param si nu returneaza rez
        Consumer<String> adaugaInLista = a -> listaStringuri.add(a);

        //lambda de tip Runnable, care nu primeste param si nu returneaza rez
        Runnable currentTime = () -> System.out.println(LocalDateTime.now());

        System.out.println(doubleItFn.apply(10));
        System.out.println(returnIt.apply(10));
        System.out.println(nrCaractere.apply("Elena"));
        System.out.println(nrNorocos.get());
        adaugaInLista.accept("Elena");
        listaStringuri.forEach(a -> System.out.println(a));
        currentTime.run();
    }

    public static int doubleIt(int a) {
        return a * 2;
    }

    public static String returnezaRezultat(int b) {
        return "Rezultatul este: " + b;
    }

    public static String esteMareSauMic(String c) {
        int caractere = c.length();
        if (caractere > 5) {
            return "mare";
        }
        return "mic";
    }

    public static int nrNorocos() {
        return new Random().nextInt();
    }

    public static void adaugaInLista(String a) {
        listaStringuri.add(a);
    }

    public static void currentTime() {
        System.out.println(LocalDateTime.now());
    }
}
