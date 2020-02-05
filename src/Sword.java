public class Sword extends Weapon {

    private String material = "iron";//FIXME: Change to ENUM (Material: IRON, STEEL, GLASS)
    private String swordType;//FIXME: Change to ENUM (SwordType: SHORT, LONG, GREAT, RAPIER)



    public Sword() {
        setName(getMaterial() + " sword");
        setValue(10);
        setMaterial("iron");
        setArmorRating(1);
        setDamage(5);
        setIsTwoHanded(false);
        setSwordType("short");
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
    public String getSwordType() {
        return swordType;
    }

    public void setSwordType(String swordType) {
        this.swordType = swordType;
    }
}
