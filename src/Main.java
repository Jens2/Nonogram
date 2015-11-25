import fatsoenlijkeversie.GameController;
import fatsoenlijkeversie.HumanPlayer;
import fatsoenlijkeversie.Player;

/**
 * Created by Rogier on 24-11-15
 */
public class Main {
    public static void main(String[] args) {
        Player player = new HumanPlayer();
        new GameController(player);
    }
}
