public class Player extends Humanoid {

    private static Player player = null;

    private Player() {

    }

    public static Player getPlayer() {

        if (player == null) {
            player = new Player();
        }
        return player;
    }
}
