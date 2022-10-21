package references;

public enum Role {
    Admin(1),
    Doctor(2),
    Patient(3),
    Nurse(4);

    public final int Id;

    private Role(int Id) {
        this.Id = Id;
    }

    public static Role getById(int id) {
        for (Role e : values()) {
            if (e.Id == id)
                return e;
        }
        return null;
    }

}
