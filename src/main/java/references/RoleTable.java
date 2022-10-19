package references;

public enum RoleTable {
    Admin(1),
    Doctor(2),
    Patient(3),
    Nurse(4);

    public final int Id;

    private RoleTable(int Id) {
        this.Id = Id;
    }

}
