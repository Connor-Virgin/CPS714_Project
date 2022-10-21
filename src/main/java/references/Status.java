package references;

public enum Status {
    Staff(1),
    Inpatient(2),
    Outpatient(3);

    public final int Id;

    private Status(int Id) {
        this.Id = Id;
    }

    public static Status getById(int id) {
        for (Status e : values()) {
            if (e.Id == id)
                return e;
        }
        return null;
    }
}
