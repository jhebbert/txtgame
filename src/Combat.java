import java.util.Random;
import java.util.Scanner;

public class Combat {
    static Random diceRoll = new Random();
    static boolean hasCountered = false;

    // Attack monster or player and determine attack modifiers
    public static void attack(Creature attacker, Creature target) throws Exception {
        // Random modifier
        int attackRoll = diceRoll.nextInt(21);
        int toHit = attackRoll + (attacker.getStrength() - 10) / 2;

        Combat.calculateHit(toHit, attacker, target);
    }

    // Compare toHit to target Armor class
    public static void calculateHit(int toHit, Creature attacker, Creature target) throws Exception {
        boolean hit = false;

        // Attack mods vs ac. Defender wins tie
        if (toHit > target.getArmorClass()) {
            hit = true;
        } else {
            System.out.println(attacker.getName() + " missed.");
            if (!hasCountered) {
                counter(target, attacker);
            }
            continueCombat(attacker, target);
        }

        if (hit) {
            System.out.println(target.getName() + " was hit!");
            dealDamage(attacker, target);
        }
    }

    // Update target hp to reflect damage dealt
    public static void dealDamage(Creature attacker, Creature target) throws Exception {

        // Damage dealt
        int damage = 1+ diceRoll.nextInt(attacker.getEquipedWeapon().getDamage()) + (attacker.getStrength() - 10) / 2;
        int targetHp = target.getHp();
        targetHp = targetHp - damage;

        target.setHp(targetHp);
        System.out.println(target.getName() + " has " + target.getHp() + " HP");

        checkCombatEnd(attacker, target);
    }

    // Check to see if either the attacker or the target has reached 0 HP
    public static void checkCombatEnd(Creature attacker, Creature target) throws Exception {
        // Check for death
        if (Player.getPlayer().getHp() <= 0) {
            System.out.println(Player.getPlayer().getName() + " is unconscious.");
            Map.moveLoop();
        } else if (Map.getPresentCreatures().get(0).getHp() <= 0) {
            System.out.println(Map.getPresentCreatures().get(0) + " is unconscious");
            Map.moveLoop();
        } else {
            if (!hasCountered) {
                counter(target, attacker);
            }
            //attack(target, attacker);
            continueCombat(attacker, target);
        }

    }

    public static void continueCombat(Creature attacker, Creature target) throws Exception {
        // Prompt for continue fight?
        System.out.println("Do you want to keep fighting?");
        String fightOn = new Scanner(System.in).next();
        if (fightOn.toLowerCase().equals("yes") || fightOn.toLowerCase().equals("y")) {
            hasCountered = false;
            attack(attacker, target);
        }
    }

    public static void counter(Creature monster, Creature player) throws Exception {
        // Random modifier
        int attackRoll = diceRoll.nextInt(21);
        int toHit = attackRoll + (monster.getStrength() - 10) / 2;

        hasCountered = true;

        Combat.calculateHit(toHit, monster, player);
    }
}
