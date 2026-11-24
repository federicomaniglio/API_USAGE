import static java.lang.IO.println;
import static java.lang.IO.readln;

void main() throws InterruptedException {
    API api = new API();
    while (true) {
        try {
            Pokemon pokemon = api.getPokemonByName(readln("Inserire nome Pokemon: "));
            println(pokemon.toString());
        } catch (IOException | InterruptedException e) {
            System.err.println(e.getMessage());
            Thread.sleep(50);

        }
    }
}