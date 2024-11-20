package se.lexicon.model;

public enum VehicleType {

    CAR(1,"Car"),
    MOTORCYCLE(2, "Motorcycle"),
    ELECTRIC(3, "Electric Vehicle");

    private final int code;
    private final String name;

    VehicleType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static VehicleType getVehicleType(int code){

        for (VehicleType type: VehicleType.values()){
            if(type.code == code){
                return type;
            }
        }
        throw new EnumConstantNotPresentException(VehicleType.class, String.valueOf(code));
//        throw new IllegalArgumentException("Invalid vehicle type code: "+ code);

    }
}
